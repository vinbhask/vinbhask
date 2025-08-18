# Big Data Pipeline Setup

This project sets up a comprehensive big data pipeline using Kafka, PySpark, Streamlit, and AWS services. It includes Terraform scripts for infrastructure provisioning, Python scripts for Kafka producers and consumers, and a Streamlit dashboard for real-time monitoring. The pipeline is designed to handle streaming data efficiently and store processed data in AWS S3.

---

## Table of Contents
1. [Overview](#overview)
2. [Prerequisites](#prerequisites)
3. [Setup Instructions](#setup-instructions)
4. [Project Structure](#project-structure)
5. [Key Components](#key-components)
6. [Usage](#usage)
7. [Troubleshooting](#troubleshooting)
8. [License](#license)
9. [Author](#author)

---

## Overview

The pipeline includes:
- **Kafka**: For message streaming and real-time data ingestion.
- **PySpark**: For real-time stream processing and analytics.
- **Streamlit**: For building an interactive monitoring dashboard.
- **AWS S3**: For storing processed data securely.
- **Terraform**: For provisioning and managing AWS infrastructure.

This setup is ideal for scenarios requiring real-time data processing, such as IoT data pipelines, log processing, and event-driven architectures.

---

## Prerequisites

Ensure the following are installed on your local machine:
- Python 3.8 or higher
- Terraform
- Docker and Docker Compose
- AWS CLI (configured with appropriate credentials)

---

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository-url>
cd bigdata-pipeline-setup
```

### 2. Install Python Dependencies
Create a virtual environment and install the required Python packages:
```bash
python3 -m venv venv
source venv/bin/activate
pip install -r configs/requirements.txt
```

### 3. Provision AWS Infrastructure
Use Terraform to provision the required AWS resources:
```bash
cd terraform
terraform init
terraform plan -out=tfplan -var-file="terraform_non_prod.tfvars"
terraform apply tfplan
```

### 4. Run the Setup Script
Run the `setup_run.sh` script to configure the environment:
```bash
bash configs/setup_run.sh
```

---

## Project Structure

```
bigdata-pipeline-setup/
├── configs/
│   ├── requirements.txt         # Python dependencies
│   ├── setup_run.sh             # Shell script for setup
│   └── terraform_non_prod.tfvars # Terraform variables
├── scripts/
│   ├── kafka-producer.py        # Kafka producer script
│   ├── spark-stream-analysis.py # PySpark stream analysis script
│   ├── s3_connector_config.json # Kafka S3 connector configuration
├── streamlit/
│   └── dashboard.py             # Streamlit dashboard
├── terraform/
│   ├── main.tf                  # Terraform configuration
│   ├── variables.tf             # Terraform variables
├── docker-compose/
│   └── docker-compose.yml       # Docker Compose configuration
└── README.md                    # Project documentation
```

---

## Key Components

### 1. **Kafka Producer**
- Script: `scripts/kafka-producer.py`
- Produces messages to the Kafka topic `iot_json_topic`.

### 2. **PySpark Stream Analysis**
- Script: `scripts/spark-stream-analysis.py`
- Consumes messages from Kafka and processes them in real-time.

### 3. **Streamlit Dashboard**
- Script: `streamlit/dashboard.py`
- Monitors Kafka messages and displays partition and offset information.

### 4. **AWS S3**
- Stores processed data from the Kafka consumer.

### 5. **Terraform**
- Provisions AWS resources, including:
  - EC2 instance
  - S3 bucket
  - Security groups

---

## Usage

### Start the Kafka Producer
```bash
python3 scripts/kafka-producer.py
```

### Run the Streamlit Dashboard
```bash
streamlit run streamlit/dashboard.py
```

### Analyze Kafka Streams with PySpark
```bash
python3 scripts/spark-stream-analysis.py
```

---

## Troubleshooting

### 1. Kafka Import Issues
Ensure `kafka-python` is installed in the correct Python environment:
```bash
pip install kafka-python
```

### 2. Terraform Errors
Check AWS credentials and ensure the `terraform_non_prod.tfvars` file is correctly configured.

### 3. Streamlit Dashboard Not Loading
Verify that the Streamlit server is running and accessible at `http://<EC2_IP>:8501`.

---

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## Author

**Vinod B**  
Date: 6 June 2025  
This project was developed to demonstrate a scalable and efficient big data pipeline using modern tools and cloud infrastructure. For any queries or contributions, feel free to reach out.
