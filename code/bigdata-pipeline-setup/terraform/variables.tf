variable "region" {
description = "Region" 
}

variable "ami_id" {
description = "Amazon Machine Image" 
}

variable "instance_type" {
description = "Instance type"
}

variable "key_name" {
description = "Name of the EC2 Key Pair"
}

variable "vpc_id" {
description = "VPC ID"
}

variable "subnet_id" {
description = "Subnet ID"
}

variable "private_key_path" {
description = "Path to your private key"
}

variable "sts_role_arn" {
description = "Role ARN"
}

variable "security_group_id" {
description = "Security Group ID"
}

variable "s3_bucket_name" {
  description = "Name of the S3 bucket"
}