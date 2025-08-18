from pyspark.context import SparkContext
import pyspark.sql.functions as f

#Import glue modules
from awsglue.transforms import *
from awsglue.utils import getResolvedOptions
from pyspark.context import SparkContext
from awsglue.context import GlueContext
from awsglue.dynamicframe import DynamicFrame
from awsglue.job import Job
from pyspark.sql import SparkSession
import sys

SNOWFLAKE_SOURCE_NAME = "net.snowflake.spark.snowflake"
args = getResolvedOptions(sys.argv, ['JOB_NAME', 'URL', 'ACCOUNT', 'WAREHOUSE', 'DB', 'SCHEMA', 'USERNAME', 'PASSWORD'])

spark_session = SparkSession.builder.appName("Example").config("hive.metastore.client.factory.class", "com.amazonaws.glue.catalog.metastore.AWSGlueDataCatalogHiveClientFactory").config("aws.region", "us-west-2").config("hive.metastore.glue.catalogid", "937000578452").enableHiveSupport().getOrCreate()


sfOptions = {
"sfURL" : args['URL'],
"sfAccount" : args['ACCOUNT'],
"sfUser" : args['USERNAME'],
"sfPassword" : args['PASSWORD'],
"sfDatabase" : args['DB'],
"sfSchema" : args['SCHEMA'],
"sfWarehouse" : args['WAREHOUSE'],
}

dl_tables_list=['dcc_preprocess_niatelemetry_dcnmfandetails','dcc_preprocess_niatelemetry_dcnmfexdetails','dcc_preprocess_niatelemetry_dcnmmoduledetails','dcc_preprocess_niatelemetry_dcnmpsudetails','dcc_preprocess_niatelemetry_dcnmpsudetails','dcc_preprocess_niatelemetry_niainventories','dcc_preprocess_niatelemetry_niainventorydcnms','dcc_preprocess_niatelemetry_niainventoryfabrics','dcc_preprocess_niatelemetry_nialicensestates','dcc_preprocess_niatelemetry_siteinventories','dcc_preprocess_niatelemetry_dcnmtransceiverdetails']

for table in dl_tables_list:
    data_df = spark_session.sql("select * from cxdl4_sbx_sonoma_preprocess_db."+table)
    data_df.write.format(SNOWFLAKE_SOURCE_NAME).options(**sfOptions).option("dbtable", "EDW_TELMTRY_ETL_DB_TS3.WI.DCNM_"+table).mode("overwrite").save()
    print("Done for table: DCNM_"+table)