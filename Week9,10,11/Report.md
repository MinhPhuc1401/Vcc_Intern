# WEEK 9, 10, 11 REPORT

##### Thực tập sinh: Đỗ Minh Phúc

## 1. Setup môi trường cài đặt cụm HDFS, YARN
### 1.1. Phiên bản
- Hadoop-3.3.2
- OpenJdk11
- Ubuntu 20.04
### 1.2. Cài đặt môi trường
Tạo một bridge network mới trên Docker
```cmd
$ docker network create hadoop
```
Tạo một container trên image Ubuntu 20.04
```cmd
$ docker run -it --name node01 -p 9870:9870 -p 8088:8088 -p 19888:19888 --hostname node01 --network hadoop ubuntu:20.04
```
Cài đặt các package cần thiết
```cmd
$ apt update
$ apt install -y wget tar ssh default-jdk
```
Tạo user hadoop
```cmd
$ groupadd hadoop
$ useradd -g hadoop -m -s /bin/bash hdfs
$ useradd -g hadoop -m -s /bin/bash yarn
$ useradd -g hadoop -m -s /bin/bash mapred
```
Tạo ssh-key trên mỗi user
```cmd
$ su <username>
$ ssh-keygen -m PEM -P '' -f ~/.ssh/id_rsa
$ cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
$ chmod 0600 ~/.ssh/authorized_keys
```
Start ssh service
```cmd
$ service ssh start
```
Thêm hostname trong file /etc/hosts
```cmd
172.18.0.2         node01
```
Kiểm tra ssh
```cmd
$ ssh <username>@node01
```
### 1.3. Download Hadoop và cấu hình
Download Hadoop
```cmd
$ wget https://dlcdn.apache.org/hadoop/common/hadoop-3.2.4/hadoop-3.2.4.tar.gz
$ tar -xvzf hadoop-3.2.4.tar.gz
$ mv hadoop-3.2.4 /lib/hadoop
$ mkdir /lib/hadoop/logs
$ chgrp hadoop -R /lib/hadoop
$ chmod g+w -R /lib/hadoop
```
Thêm các biến môi trường vào file ```cmd /etc/bash.bashrc``` để tất cả các user trên hệ thống đều có thể sử dụng
```cmd
export JAVA_HOME=/usr/lib/jvm/default-java
export HADOOP_HOME=/lib/hadoop
export PATH=$PATH:$HADOOP_HOME/bin

export HDFS_NAMENODE_USER="hdfs"
export HDFS_DATANODE_USER="hdfs"
export HDFS_SECONDARYNAMENODE_USER="hdfs"
export YARN_RESOURCEMANAGER_USER="yarn"
export YARN_NODEMANAGER_USER="yarn"

export HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop
```
Cập nhật biến môi trường
```cmd
$ source /etc/bash.bashrc
```
Cập nhật biến môi trường trong file: ```cmd $HADOOP_HOME/etc/hadoop/hadoop-env.sh```
```cmd
export JAVA_HOME=/usr/lib/jvm/default-java
```
### 1.4. Thiết lập cấu hình cho Hadoop
```$HADOOP_HOME/etc/hadoop/core-site.xml```
```cmd
<configuration>
    <property>
        <name>fs.defaultFS</name>
        <value>hdfs://node01:9000</value>
    </property>
    <property>
        <name>hadoop.tmp.dir</name>
        <value>/home/${user.name}/hadoop</value>
    </property>
</configuration>
```
```$HADOOP_HOME/etc/hadoop/hdfs-site.xml```
```cmd
<configuration>
    <property>
        <name>dfs.replication</name>
        <value>1</value>
    </property>
    <property>
        <name>dfs.permissions.superusergroup</name>
        <value>hadoop</value>
    </property>
    <property>
        <name>dfs.datanode.data.dir.perm</name>
        <value>774</value>
    </property>
</configuration>
```
```$HADOOP_HOME/etc/hadoop/yarn-site.xml```
```cmd
<configuration>
    <property>
        <name>yarn.resourcemanager.hostname</name>
        <value>node01</value>
    </property>
    <property>
        <name>yarn.nodemanager.resource.memory-mb</name>
        <value>-1</value>
    </property>
    <property>
        <name>yarn.nodemanager.resource.detect-hardware-capabilities</name>
        <value>true</value>
    </property>
</configuration>
```
### 1.5. Chạy trên 1 node
Format file trên Name Node
```cmd
$ su hdfs
[hdfs]$ $HADOOP_HOME/bin/hdfs namenode -format
$ exit
```
Chạy các dịch vụ của Hadoop trên account root
```cmd
$ $HADOOP_HOME/sbin/start-all.sh
```
### 1.6. Thêm node mới vào cụm
Tạo một image từ container đang có
```cmd
$ docker commit node01 hadoop
```
Run container mới từ image vừa tạo
```cmd
$ docker run -it --name node02 --hostname node02 --network hadoop hadoop
```
Start service ssh và xoá thư mục data cũ trên node02
```cmd
$ service ssh start
$ rm -rf /home/hdfs/hadoop
$ rm -rf /home/yarn/hadoop
```
Cập nhật ip, hostname của Namenode cho node02
- File ```/etc/hosts```
```cmd
172.18.0.3       node02
172.18.0.2       node01
```
Trên node01 chúng ta bổ sung thêm ip và hostname của node02
- File ```/etc/hosts```
```cmd
172.18.0.2       node01
172.18.0.3       node02
```
- File ```$HADOOP_HOME/etc/hadoop/workers```
```cmd
node01
node02
```
Sau đó start all các dịch vụ của hadoop trên node01
```cmd
$ $HADOOP_HOME/sbin/start-all.sh
```
Kiểm tra node02 đã được add vào chưa

http://localhost:9870/dfshealth.html#tab-datanode

![img](https://i.imgur.com/9IIsljj.jpeg)

http://localhost:8088/cluster/nodes

![img](https://i.imgur.com/9twHwkc.jpeg)

### 1.7. Chạy chương trình MapReduce
- Tạo project với cấu trúc file 

![img](https://i.imgur.com/OTQJP7U.jpg)

WordCount.java
```cmd
package com.hadoop.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {
	public static void main(String[] args) throws Exception {
		String in = args[0];
		String out = args[1];
		
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "Word count");
		
		job.setJarByClass(WordCount.class);
		job.setMapperClass(WCMapper.class);
		job.setCombinerClass(WCReducer.class);
		job.setReducerClass(WCReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(in));
		FileSystem fs = FileSystem.get(conf); // delete file output when it exists
		if (fs.exists(new Path(out))) {
			fs.delete(new Path(out), true);
		}
		
		FileOutputFormat.setOutputPath(job, new Path(out));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
```
WCMapper.java
```cmd
package com.hadoop.mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WCMapper extends Mapper<Object, Text, Text, IntWritable>{
	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();

	@Override
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		StringTokenizer itr = new StringTokenizer(value.toString());
		while (itr.hasMoreTokens()) {
			word.set(itr.nextToken());
			context.write(word, one);
		}
	}
}
```
WCReducer.java
```cmd
package com.hadoop.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WCReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	private IntWritable result = new IntWritable();

	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		for (IntWritable val : values) {
			sum += val.get();
		}
		result.set(sum);
		context.write(key, result);
	}
}
```
- Cài maven

![img](https://i.imgur.com/10jxygy.jpg)
- Build file jar
Tạo file pom.xml
```cmd
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>wordcount</groupId>
	<artifactId>wordcount</artifactId>
	<version>V1</version>
	<dependencies>
		<dependency>
			<groupId>org.apache.hadoop</groupId>
			<artifactId>hadoop-common</artifactId>
			<version>2.9.0</version>
			<!--<scope>provided</scope> -->
		</dependency>
		<dependency>
			<groupId>org.apache.hadoop</groupId>
			<artifactId>hadoop-hdfs</artifactId>
			<version>2.9.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-mapreduce-client-core -->
		<dependency>
			<groupId>org.apache.hadoop</groupId>
			<artifactId>hadoop-mapreduce-client-core</artifactId>
			<version>2.9.0</version>
		</dependency>
		<dependency>
			<groupId>org.apache.hadoop</groupId>
			<artifactId>hadoop-mapreduce-client-jobclient</artifactId>
			<version>2.9.0</version>
			<scope>provided</scope>
		</dependency>
	</dependencies>
	<build>
		<sourceDirectory>src</sourceDirectory>
		<resources>
			<resource>
				<directory>src</directory>
				<excludes>
					<exclude>**/*.java</exclude>
				</excludes>
			</resource>
		</resources>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.1</version>
				<configuration>
					<release>15</release>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
```
- Chạy lệnh
```cmd
$ mvn clean package
```
![img](https://i.imgur.com/utV2KeL.jpg)
- Chuẩn bị dữ liệu
Copy file từ local lên HDFS
```cmd
$ hdfs dfs -copyFromLocal input.txt /
```
Kiểm tra xem file input.txt
```cmd
$ hdfs dfs -ls /
```
- Chạy chương trình
```cmd
hadoop jar target/wordcount-V1.jar com.hadoop.mapreduce.WordCount hdfs://node01:9000/input.txt hdfs://node01:9000/output
```
![img](https://i.imgur.com/wrVuo63.jpg)
Xem output
```cmd
$ hdfs dfs -cat /output/part-r-00000
```
![img](https://i.imgur.com/ddxV26P.jpg)

## 2. Cài đặt Spark standalone, spark trên yarn

### 2.1 Cài đặt Spark

- Download spark và cài đặt
```cmd
$ wget https://dlcdn.apache.org/spark/spark-3.3.4/spark-3.3.4-bin-without-hadoop.tgz
$ tar -xzvf spark-3.3.4-bin-without-hadoop.tgz 
$ mv spark-3.3.4-bin-without-hadoop /lib/spark
$ mkdir /lib/spark/logs
$ chgrp hadoop -R /lib/spark
$ chmod g+w -R /lib/spark
```
- Cấu hình các biến môi trường trong file ```/etc/bash.bashrc```
```cmd
export SPARK_HOME=/lib/spark
export PATH=$PATH:$SPARK_HOME/bin
```
- Cập nhật biến môi trường
```cmd
$ source /etc/bash.bashrc
```
- Tạo file ```$SPARK_HOME/conf/spark-env.sh```
```cmd
cp $SPARK_HOME/conf/spark-env.sh.template $SPARK_HOME/conf/spark-env.sh
```
- Thêm cấu hình classpath vào file ```$SPARK_HOME/conf/spark-env.sh```
```cmd
export SPARK_DIST_CLASSPATH=$(hadoop classpath)
```
- Kiểm tra xem đã chạy được Spark ở YARN mode hay chưa:
```cmd
spark-shell
```
![img](https://i.imgur.com/sAFwwOA.jpg)

##### 2.2.2 WordCount với Spark chạy trên YARN

- Tạo file input
```cmd
$ nano WordCountSpark.txt
# Nhập nội dung file
$ hdfs dfs -copyFromLocal WordCountSpark.txt /input_spark
```
- Chạy spark: 
```cmd
$ spark-shell
```
- Chạy WordCount
```scala
val textFile = sc.textFile("hdfs://node01:9000/input_spark/WordCountSpark.txt")
val counts = textFile.flatMap(line => line.split(" "))
                 .map(word => (word, 1))
                 .reduceByKey(_ + _)
counts.saveAsTextFile("hdfs://node01:9000/output_spark/WCResultYarn")
```
- Kiểm tra kết quả

![img](https://i.imgur.com/PKPuJYu.jpg)

![img](https://i.imgur.com/fdHLXEG.jpg)




