provider "aws" {
region = var.region
assume_role {
    role_arn = var.sts_role_arn
  }
}

#Generate a private key
resource "tls_private_key" "example" {
algorithm = "RSA"
rsa_bits  = 4096
}

#Upload the public key to AWS
resource "aws_key_pair" "generated_key" {
key_name   = "terraform-generated-key"
public_key = tls_private_key.example.public_key_openssh
}

#Save the private key to a file
resource "local_file" "private_key" {
content  = tls_private_key.example.private_key_pem
filename = "terraform-generated-key.pem"
file_permission = "0400" # Restrict permissions to read-only for the owner
}

# Add S3 bucket resource
resource "aws_s3_bucket" "bigdata_bucket" {
  bucket = var.s3_bucket_name

  tags = {
    Name        = "BigDataPipelineBucket"
    Environment = "NonProd"
  }
}

# Attach IAM role to EC2 instance
resource "aws_iam_instance_profile" "ec2_instance_profile" {
  name = "bigdata-ec2-instance-profile"
  role = var.sts_role_arn
}

resource "aws_instance" "bigdata_ec2" {
ami           = var.ami_id
instance_type = var.instance_type
key_name      = aws_key_pair.generated_key.key_name # var.key_name if you want use existing key pair
subnet_id     = var.subnet_id
associate_public_ip_address = true
vpc_security_group_ids = [var.security_group_id]
iam_instance_profile = aws_iam_instance_profile.ec2_instance_profile.name

tags = {
Name = "BigDataPipeline"
}

provisioner "remote-exec" {
inline = [
"sudo apt update -y",
"sudo apt install -y docker.io docker-compose python3-pip openjdk-8-jdk",
"sudo usermod -aG docker ubuntu",
"readlink -f /usr/bin/java"  # Ensure Java is properly installed
]
connection {
type        = "ssh"
user        = "ubuntu"
private_key = tls_private_key.example.private_key_pem #file(var.private_key_path) if using existing key pair
host        = self.public_ip
}
}
}
