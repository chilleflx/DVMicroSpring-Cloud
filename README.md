# 🚀 DVMicroSpring-Cloud
This repository contains two Spring Boot microservices:

ConfigMicro: A Spring Cloud Config Server for centralized configuration management.

mcommandes: A microservice for managing orders (Commandes) with dynamic configuration and health monitoring.

# 📚 Table of Contents
Introduction

Projects Overview

ConfigMicro

mcommandes

Team

License

# 🚀 Introduction
This repository demonstrates a microservices architecture using Spring Boot and Spring Cloud. It includes:

ConfigMicro: A configuration server that fetches properties from a Git repository.

mcommandes: A microservice for managing orders, which dynamically retrieves its configuration from ConfigMicro.
# 🌐 ConfigMicroService

# 📝 Description
This is a Spring Boot application that serves as a configuration server using Spring Cloud Config. It fetches configuration properties from a Git repository and provides centralized configuration management for microservices.

# 🛠 Requirements
Java 17 ☕

Maven 🛠️

Git 📂

# 🚀 Getting Started
1. Clone the Repository
git clone https://github.com/chilleflx/configmicro.git
cd configmicro

2. Build the Project
   mvn clean install
3. Run the Application
mvn spring-boot:run
The application will start on port 9101 by default.

# ⚙️ Configuration
The application fetches configuration properties from the following Git repository:
Application Properties
The following properties are configured in application.properties:

# Application Configuration
spring.application.name=configmicro
server.port=9101

# Spring Cloud Config Server Configuration
spring.cloud.config.server.git.uri=https://github.com/chilleflx/cloud-config.git
spring.cloud.config.server.git.default-label=main

# Logging Configuration
logging.level.root=INFO
logging.level.com.mcommerce.config.server=INFO
logging.level.org.springframework.boot.web.embedded.tomcat=INFO

Customizing Configuration
To customize the configuration:

1.Modify the application.properties file.

2.Update the Git repository URI or other properties as needed.

# 📦 Dependencies
The project uses the following dependencies:

Spring Boot Starter Thymeleaf 🍃

Spring Boot Starter Web 🌐

Spring Cloud Config Server ☁️

WebJars Bootstrap 🎨

Spring Boot Starter Test (for testing) 🧪


# 📦 Mcommandes
Microservices for simulating payments and managing orders.

# 📚 Table of Contents
Introduction

Technologies

Setup

Usage

API Endpoints

Swagger

Actuator Endpoints

Configuration Management

Health Check and Monitoring

# 🚀 Introduction
Mcommandes is a Spring Boot-based microservice application designed to simulate payment processing and manage orders (Commandes). It provides a robust and scalable solution for handling CRUD operations on orders, dynamic configuration management, and health monitoring.

Key Features:

CRUD Operations: Create, Read, Update, and Delete orders.

Dynamic Configuration: Manage application properties using Spring Cloud Config.

Health Monitoring: Monitor the health of the microservice using Spring Boot Actuator.

Swagger Integration: Interactive API documentation for easy testing and exploration.

# 🛠 Technologies
Java 1.8 🖥️

Spring Boot 2.7.16 🌱

Spring Data JPA 🗄️

H2 Database 💾 (In-memory database for development)

Spring Cloud Config ☁️ (Centralized configuration management)

Springfox Swagger 📄 (API documentation)

Maven 🛠️ (Build and dependency management)

Spring Boot Actuator 🩺 (Health checks and monitoring)

# 🛠 Setup
Prerequisites
Java 1.8 or higher

Maven 3.x

Git

Steps to Run the Application
1.Clone the Repository:
git clone https://github.com/yourusername/mcommandes.git
cd mcommandes
2.Build the Project:
mvn clean install
3.Run the Application:
mvn spring-boot:run
4.Access the Application:
http://localhost:9001

# 🎯 Usage
Once the application is running, you can interact with the API using tools like Postman, cURL, or directly via Swagger UI.

🔗 API Endpoints
HTTP Method	Endpoint	Description
POST	/commandes	Add a new order.
GET	/commandes/last	Retrieve the last orders.
GET	/commandes	Retrieve all orders.
GET	/commandes/{id}	Retrieve a specific order by ID.
PUT	/commandes/update	Update an existing order.
DELETE	/commandes/{id}	Delete an order by ID.

# 📄 Swagger
Swagger UI is integrated into the application for easy API exploration and testing. Access it at:
http://localhost:9001/swagger-ui/index.html

# ⚙️ Actuator Endpoints
Spring Boot Actuator provides several endpoints for monitoring and managing the application. Below are the key Actuator endpoints:

HTTP Method	Endpoint	Description
POST	/actuator/refresh	Refresh the application configuration dynamically.
GET	/actuator/health	Check the health status of the application (UP/DOWN).
GET	/actuator/env/mes-config-ms.commandes-last	Retrieve the current value of the mes-config-ms.commandes-last property.

# ⚙️ Configuration Management
The application uses Spring Cloud Config to manage configurations dynamically. The configuration is stored in a GitHub repository and can be updated without restarting the application.

Key Configuration Properties
mes-config-ms.commandes-last: Determines the number of days to look back for retrieving the last orders. Default value is 10.

Updating Configuration
To update the configuration dynamically:

Modify the configuration in the GitHub repository.

Refresh the configuration using the Actuator endpoint:
curl -X POST http://localhost:9001/actuator/refresh
or use the Swagger UI

# 🩺 Health Check and Monitoring
The application uses Spring Boot Actuator to monitor its health and status.

Health Check Endpoint
Access the health check endpoint at:
http://localhost:8080/actuator/health
or use the Swagger UI

Custom Health Indicator
The microservice is considered UP if there are orders in the COMMANDE table. Otherwise, it will return DOWN.

# 👥 Team
Meet the team behind Mcommandes:

DAKKA Ilyass
Marouane Rachdi

# 📜 License
This project is licensed under the MIT License. See the LICENSE file for details.
