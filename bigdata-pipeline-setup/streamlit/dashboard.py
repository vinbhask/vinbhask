# ============================
# Script: dashboard.py
# Description: Streamlit dashboard for monitoring Kafka messages.
# Author: Your Name
# Date: 1 May 2025
# ============================

# Import necessary libraries
import streamlit as st
from kafka import KafkaConsumer
import json
import time
from datetime import datetime
import logging

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(message)s')
logger = logging.getLogger("StreamlitDashboard")

# Streamlit UI setup
st.title("Big Data Pipeline Dashboard")

logger.info("Streamlit dashboard started.")

# Kafka Consumer Configuration
consumer = KafkaConsumer(
    'iot_json_topic',
    bootstrap_servers=['localhost:9092'],  # Adjust if your Kafka is not local
    value_deserializer=lambda v: json.loads(v.decode('utf-8')),
    auto_offset_reset='latest',  # Start from the latest messages
    enable_auto_commit=True
)

# Streamlit UI
st.title("Kafka Message Count and Events")

# Create two columns for displaying message count and events
col1, col2 = st.columns(2)

# Placeholders for dynamic updates
count_placeholder = col1.empty()  # Placeholder for the message count
message_placeholder = col2.empty()  # Placeholder for the messages

# Initialize message count and events list
message_count = 0
events = []

# Function to read and display count, messages, and partition information
def display_count_and_messages():
    global message_count
    for message in consumer:
        message_count += 1
        count_placeholder.write(f"Incoming Messages: {message_count}")

        # Include partition information
        partition_info = f"Partition: {message.partition}, Offset: {message.offset}"
        events.append({"message": message.value, "partition_info": partition_info})

        message_placeholder.write(events)

        time.sleep(1)  # Adjust the sleep time to control the refresh rate

# Run the display function
display_count_and_messages()

# Close the consumer (optional, but good practice)
consumer.close()

logger.info("Streamlit dashboard completed.")