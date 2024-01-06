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

![img](https://imgur.com/9IIsljj)

http://localhost:8088/cluster/nodes

![img](https://imgur.com/gallery/9twHwkc)



