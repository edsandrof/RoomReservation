variable "instance_name" {
  description = "Name of EC2"
  type        = string
  default     = "ReservationApp"
}

variable "region" {
  description = "AWS Region"
  type = string
  default = "us-west-2"
}

variable "instance_type" {
  description = "Instance type"
  type = string
  default = "t2.micro"
}