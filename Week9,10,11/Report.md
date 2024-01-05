# WEEK 9, 10, 11 REPORT

##### Thực tập sinh: Đỗ Minh Phúc

## 1. Setup môi trường cài đặt cụm HDFS, YARN
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


