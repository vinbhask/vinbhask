# ============================
# Script: spark-stream-analysis.py
# Description: Analyzes Kafka stream data using PySpark.
# Author: Your Name
# Date: 1 May 2025
# ============================

# Import necessary libraries
import time
from pyspark.sql import SparkSession
from pyspark.sql.functions import from_json, col
from pyspark.sql.types import StructType, StringType
import logging

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(message)s')
logger = logging.getLogger("SparkStreamAnalysis")

# Kafka configuration
kafka_brokers = "localhost:9092"
kafka_topic = "iot_json_topic"

# Define schema for Kafka messages
json_schema = StructType().add("timestamp", StringType())

# Create Spark session
spark = SparkSession.builder.appName("KafkaTimestampPrinter").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")

# Subscribe to Kafka topic
kafka_df = spark.readStream.format("kafka") \
    .option("kafka.bootstrap.servers", kafka_brokers) \
    .option("subscribe", kafka_topic) \
    .option("startingOffsets", "latest").load()

# Extract JSON data from Kafka messages
json_data_df = kafka_df.selectExpr("CAST(value AS STRING) as json_string") \
    .select(from_json(col("json_string"), json_schema).alias("data"))

# Select timestamp and calculate elapsed time
start_time = time.time()

def process_row(row):
    current_time = time.time()
    elapsed_time = current_time - start_time
    logger.info(f"Timestamp: {row.timestamp}, Elapsed Time: {elapsed_time:.2f} seconds")

# Write stream to process each row
query = json_data_df.select("data.timestamp") \
    .writeStream \
    .outputMode("append") \
    .foreach(process_row) \
    .start()

# Wait for the streaming query to terminate
query.awaitTermination()