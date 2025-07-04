key_name         = "bigdata-pipeline-test"
vpc_id           = "vpc-4fa7b627"
subnet_id        = "subnet-8dabc4c1"
private_key_path = "configs/key.pem"
ami_id           = "ami-00bb6a80f01f03502"
instance_type    = "t2.xlarge"
region           = "ap-south-1"
sts_role_arn     = "arn:aws:iam::207022024306:role/test_role_for_scripts"
security_group_id = "sg-091def8a6a43f7bc5"
s3_bucket_name  = "bigdata-pipeline-test"
s3_key_prefix   = "bigdata-pipeline-test"
s3_region      = "ap-south-1"