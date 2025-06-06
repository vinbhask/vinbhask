#!/bin/bash

# ============================
# Script: setup_run.sh
# Description: Automates the setup of a big data pipeline environment.
# Author: Vinod B
# Date: 1 May 2025
# Usage: ./setup_run.sh
# ============================

set -e  # Exit on any error
set -o pipefail  # Catch errors in pipelines

# ----------------------------
# Logging Functions
# ----------------------------
log() {
    echo "$(date '+%Y-%m-%d %H:%M:%S') - $1"
}

error_exit() {
    echo "$(date '+%Y-%m-%d %H:%M:%S') - ERROR: $1" >&2
    exit 1
}

# ----------------------------
# Setup Functions
# ----------------------------
setup_virtualenv() {
    log "Setting up Python virtual environment..."
    python3 -m venv /home/ubuntu/venv || error_exit "Failed to create Python virtual environment"
    source /home/ubuntu/venv/bin/activate || error_exit "Failed to activate Python virtual environment"
    log "Virtual environment activated."
}

install_packages() {
    log "Installing required Python packages in virtual environment..."
    /home/ubuntu/venv/bin/pip install -r /home/ubuntu/configs/requirements.txt || error_exit "Failed to install Python packages"
}

setup_directories() {
    log "Creating necessary directories..."
    mkdir -p /home/ubuntu/docker || error_exit "Failed to create /home/ubuntu/docker"
    mkdir -p /home/ubuntu/configs || error_exit "Failed to create /home/ubuntu/configs"
}

copy_files() {
    log "Copying files..."
    cp /home/ubuntu/docker-compose.yml /home/ubuntu/docker/ || error_exit "Failed to copy docker-compose.yml"
    cp /home/ubuntu/s3_connector_config.json /home/ubuntu/configs/ || error_exit "Failed to copy s3_connector_config.json"
}

remove_unnecessary_files() {
    log "Removing unnecessary files..."
    rm -f /home/ubuntu/scripts/setup_hadoop_hive.sh || error_exit "Failed to remove setup_hadoop_hive.sh"
}

start_docker_compose() {
    log "Starting Docker Compose..."
    docker-compose -f /home/ubuntu/docker/docker-compose.yml up -d || error_exit "Failed to start Docker Compose"
}

configure_kafka_topics() {
    log "Setting Kafka topic policies..."
    docker exec kafka kafka-configs.sh --bootstrap-server localhost:9092 --entity-type topics --entity-name connect-configs --alter --add-config cleanup.policy=compact || error_exit "Failed to set policy for connect-configs"
    docker exec kafka kafka-configs.sh --bootstrap-server localhost:9092 --entity-type topics --entity-name connect-offsets --alter --add-config cleanup.policy=compact || error_exit "Failed to set policy for connect-offsets"
    docker exec kafka kafka-configs.sh --bootstrap-server localhost:9092 --entity-type topics --entity-name connect-status --alter --add-config cleanup.policy=compact || error_exit "Failed to set policy for connect-status"
}

register_s3_connector() {
    log "Registering S3 connector..."
    curl -X POST http://localhost:8083/connectors -H "Content-Type: application/json" -d @/home/ubuntu/configs/s3_connector_config.json || error_exit "Failed to register S3 connector"
}

start_streamlit_dashboard() {
    log "Installing Streamlit and starting dashboard..."
    /home/ubuntu/venv/bin/pip install streamlit || error_exit "Failed to install Streamlit"
    nohup streamlit run /home/ubuntu/streamlit/dashboard.py > /home/ubuntu/streamlit.log 2>&1 & || error_exit "Failed to start Streamlit dashboard"
}

start_kafka_producer() {
    log "Starting Kafka producer..."
    python3 /home/ubuntu/scripts/kafka-producer.py || error_exit "Failed to start Kafka producer"
}

# ----------------------------
# Main Execution
# ----------------------------
main() {
    log "Starting setup..."
    setup_virtualenv
    install_packages
    setup_directories
    copy_files
    remove_unnecessary_files
    start_docker_compose
    configure_kafka_topics
    register_s3_connector
    start_streamlit_dashboard
    start_kafka_producer
    log "Setup completed successfully!"
}

main