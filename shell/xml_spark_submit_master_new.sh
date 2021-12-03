#!/bin/bash
# Purpose: Refreshing the Sales order flow using spark-submit and in-memory tables
# Author: Vinod B
# Date: 17-Sep-2018
# Call Example: sh xml_spark_submit_master.sh <Job_Name>
# Description: This script will be a having multiple call statments to spark-submit, which block gets executed is decided by
#              by the input parameter given while calling this master script,  Standardization in turn will have multiple
#                          calls.
#***********************************************************************


if [ $# -lt 1 ]
then
echo "input arguments missed. Sample command: sh xml_spark_submit_master.sh <JOB_Name> "
exit 1
fi

export DATESTART=$(date +%d_%b_%Y_%T)

export DATE=$(date +%d_%b_%Y_%T)
(echo -e "Hi Team,\n\n\tThe $1 refresh has been triggered just now.\n\nThanks,\n Team") | mailx -s "$1 execution Started" vinod@email.com

#Get the last successfully run file name, should be null in case of full run
#last_successful_run=`head -1 /hdfs/app/DFGCS/hive/warehouse/script/Wrapper/last_successful_run.txt`

## For standard jobs
if [[ $1 = "df_STANDARDIZATION" ]]
then
## If no sucess file is available then start execution from df Sales order
if [[ $last_success_run = "" ]]
then
/users/hdpdfgcs/xmlsparkfwsetup/dfDB_INT/df_STANDARDIZATION/xml_sparksubmit_config.sh /users/hdpdfgcs/xmlsparkfwsetup/dfDB_INT/df_STANDARDIZATION/Sales_Order_Start.xml df_SOL_STANDARD_RUN /app/DFGCS/hive/warehou
se/script/dfDB_INT/xml/df_STANDARDIZATION /app/DFGCS/hive/warehouse/script/dfDB_INT/properties/df_STANDARDIZATION/DML/SOL >> /hdfs/app/DFGCS/hive/war
ehouse/script/Logs/dfDB_INT/SOL/df_SALES_ORDER_"$DATE.txt"
## Create a success file post successful execution
if [[ $? -eq 0 ]]
then  echo "df_SALES_ORDER" > /hdfs/app/DFGCS/hive/warehouse/script/Wrapper/last_successful_run.txt
## If sales order execution has failed, attached the log and send an failure email
else
rm -f /hdfs/app/DFGCS/hive/warehouse/script/Wrapper/last_successful_run.txt
(echo -e "Hi Team,\n\n\tThe $1 Refresh has been failed. Please Find Attached log for further analysis.\n\nThanks,\ndf Team") | mailx -s "$1 execution Faile
d" -a /hdfs/app/DFGCS/hive/warehouse/script/Logs/dfDB_INT/SOL/df_SALES_ORDER_"$DATE.txt" vinod@email.com
exit 1
fi
fi

## if previous successful run is Sales order then trigger df Base
last_successful_run=`head -1 /hdfs/app/DFGCS/hive/warehouse/script/Wrapper/last_successful_run.txt`

if [[ $last_success_run = "df_SALES_ORDER" ]]
then
/users/hdpdfgcs/xmlsparkfwsetup/dfDB_INT/df_STANDARDIZATION/xml_sparksubmit_config.sh /users/hdpdfgcs/xmlsparkfwsetup/dfDB_INT/df_STANDARDIZATION/df_df_BASE_START.xml df_IB_STANDARD_RUN /app/DFGCS/hive/warehouse/script/dfDB_INT/xml/df_STANDARDIZATION /app/DFGCS/hive/warehouse/script/dfDB_INT/properties/df_STANDARDIZATION/DML/IB >> /hdfs/app/DFGCS/hive/war
ehouse/script/Logs/dfDB_INT/IB/df_df_BASE_"$DATE.txt"
## Create a success file post successful execution
if [[ $? -eq 0 ]]
then  echo "df_df_BASE" > /hdfs/app/DFGCS/hive/warehouse/script/Wrapper/last_successful_run.txt
## If sales order execution has failed, attached the log and send an failure email
else
rm -f /hdfs/app/DFGCS/hive/warehouse/script/Wrapper/last_successful_run.txt
(echo -e "Hi Team,\n\n\tThe $1 Refresh has been failed. Please Find Attached log for further analysis.\n\nThanks,\ndf Team") | mailx -s "$1 execution Failed" -a /hdfs/app/DFGCS/hive/warehouse/script/Logs/dfDB_INT/IB/df_df_BASE_"$DATE.txt" vinod@email.com
exit 1
fi
fi



fi
if [[ $? -eq 0 ]]
then
(echo -e "Hi Team,\n\n\tThe $1 refresh has been completed.\n\nThanks,\ndf Team") | mailx -s "$1 execution has been completed" vinod@email.com
fi
