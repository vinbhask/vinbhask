# ============================
# Script: kafka-producer.py
# Description: Produces messages to a Kafka topic.
# Author: Your Name
# Date: 1 May 2025
# ============================

# Import necessary libraries
from kafka import KafkaProducer
import json
import time
from datetime import datetime, timedelta
import logging

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(message)s')
logger = logging.getLogger("KafkaProducer")

# Initialize Kafka producer
producer = KafkaProducer(
    bootstrap_servers=['localhost:9092'],
    value_serializer=lambda v: json.dumps(v).encode('utf-8')
)

logger.info("Kafka producer script started.")

# Define the duration for which the producer will run
end_time = datetime.now() + timedelta(minutes=20)

# Produce messages to the Kafka topic
while datetime.now() < end_time:
    data = {
        'device_id': 'sensor_1',
        'temperature': 25,
        'humidity': 60,
        'timestamp': str(datetime.now())
    }
    producer.send('iot_json_topic', value=data)
    logger.info(f"Produced: {data}")
    time.sleep(2)  # Produces every 2 seconds

# Close the producer
producer.flush()
producer.close()
logger.info("Kafka producer script completed.")

print("Producer stopped after 20 minutes.")