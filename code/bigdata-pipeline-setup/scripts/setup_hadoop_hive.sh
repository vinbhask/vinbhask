#!/bin/bash
cd /home/ubuntu
wget https://downloads.apache.org/hadoop/common/hadoop-3.3.6/hadoop-3.3.6.tar.gz
tar -xzf hadoop-3.3.6.tar.gz
mv hadoop-3.3.6 hadoop
rm hadoop-3.3.6.tar.gz

wget https://downloads.apache.org/hive/hive-3.1.3/apache-hive-3.1.3-bin.tar.gz
tar -xzf apache-hive-3.1.3-bin.tar.gz
mv apache-hive-3.1.3-bin hive
rm apache-hive-3.1.3-bin.tar.gz

echo "export HADOOP_HOME=/home/ubuntu/hadoop" >> ~/.bashrc
echo "export HIVE_HOME=/home/ubuntu/hive" >> ~/.bashrc
echo "export PATH=$HADOOP_HOME/bin:$HADOOP_HOME/sbin:$HIVE_HOME/bin:$PATH" >> ~/.bashrc
source ~/.bashrc