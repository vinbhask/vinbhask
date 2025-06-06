#!/bin/bash

# Exit immediately if a command exits with a non-zero status
set -e

# Log all commands for debugging
set -x

# Function to configure AWS credentials
function configure_aws() {
  echo "Configuring AWS credentials..."
  aws configure set aws_access_key_id $AWS_ACCESS_KEY_ID > /dev/null 2>&1
  aws configure set aws_secret_access_key $AWS_SECRET_ACCESS_KEY > /dev/null 2>&1
  aws configure set default.region ap-south-1 > /dev/null 2>&1
}

# Function to initialize and apply Terraform
function setup_terraform() {
  echo "Initializing and applying Terraform..."
  cd terraform  # Navigate to the Terraform directory
  terraform init
  terraform plan -out=tfplan -var-file="terraform_non_prod.tfvars"
  terraform apply -auto-approve tfplan
  cd -  # Return to the previous directory
}

# Function to set up Docker Compose and Kafka
function setup_docker_kafka() {
  echo "Setting up Docker Compose and Kafka..."
  sudo docker-compose -f docker-compose/docker-compose.yml up -d
  docker logs kafka

  # Create Kafka topics
  docker exec -it kafka kafka-topics.sh --create --topic iot_json_topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
  docker exec kafka /opt/bitnami/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic connect-configs --partitions 1 --replication-factor 1
  docker exec kafka /opt/bitnami/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic connect-offsets --partitions 50 --replication-factor 1
  docker exec kafka /opt/bitnami/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic connect-status --partitions 1 --replication-factor 1
}

# Function to clean up Docker resources
function cleanup_docker() {
  echo "Cleaning up Docker resources..."
  docker stop $(docker ps -a -q) || true
  docker rm $(docker ps -a -q) || true
  docker image prune -a -f
  docker volume prune -f
  docker network prune -f
  sudo systemctl restart docker
}

# Function to run the Streamlit dashboard
function run_streamlit_dashboard() {
  echo "Running Streamlit dashboard..."
  pip3 install -r configs/requirements.txt
  streamlit run streamlit/dashboard.py --server.port 8501 --server.address 0.0.0.0 &
  sleep 5  # Wait for the server to start
  EC2_IP=$(terraform output -raw public_ip)
  open http://$EC2_IP:8501  # Open the Streamlit URL in the default browser
}

# Main script execution
configure_aws
setup_terraform
setup_docker_kafka
cleanup_docker
run_streamlit_dashboard


