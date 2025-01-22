# 📦 Mcommandes
Microservices for simulating payments and managing orders.

📚 Table of Contents
Introduction

Technologies

Setup

Usage

API Endpoints

Swagger

Actuator Endpoints

Configuration Management

Health Check and Monitoring

Team

License

🚀 Introduction
Mcommandes is a Spring Boot-based microservice application designed to simulate payment processing and manage orders (Commandes). It provides a robust and scalable solution for handling CRUD operations on orders, dynamic configuration management, and health monitoring.

Key Features:

CRUD Operations: Create, Read, Update, and Delete orders.

Dynamic Configuration: Manage application properties using Spring Cloud Config.

Health Monitoring: Monitor the health of the microservice using Spring Boot Actuator.

Swagger Integration: Interactive API documentation for easy testing and exploration.

🛠 Technologies
Java 1.8 🖥️

Spring Boot 2.7.16 🌱

Spring Data JPA 🗄️

H2 Database 💾 (In-memory database for development)

Spring Cloud Config ☁️ (Centralized configuration management)

Springfox Swagger 📄 (API documentation)

Maven 🛠️ (Build and dependency management)

Spring Boot Actuator 🩺 (Health checks and monitoring)

🛠 Setup
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
🎯 Usage
Once the application is running, you can interact with the API using tools like Postman, cURL, or directly via Swagger UI.

🔗 API Endpoints
HTTP Method	Endpoint	Description
POST	/commandes	Add a new order.
GET	/commandes/last	Retrieve the last orders.
GET	/commandes	Retrieve all orders.
GET	/commandes/{id}	Retrieve a specific order by ID.
PUT	/commandes/update	Update an existing order.
DELETE	/commandes/{id}	Delete an order by ID.

📄 Swagger
Swagger UI is integrated into the application for easy API exploration and testing. Access it at:
http://localhost:9001/swagger-ui/index.html

⚙️ Actuator Endpoints
Spring Boot Actuator provides several endpoints for monitoring and managing the application. Below are the key Actuator endpoints:

HTTP Method	Endpoint	Description
POST	/actuator/refresh	Refresh the application configuration dynamically.
GET	/actuator/health	Check the health status of the application (UP/DOWN).
GET	/actuator/env/mes-config-ms.commandes-last	Retrieve the current value of the mes-config-ms.commandes-last property.

⚙️ Configuration Management
The application uses Spring Cloud Config to manage configurations dynamically. The configuration is stored in a GitHub repository and can be updated without restarting the application.

Key Configuration Properties
mes-config-ms.commandes-last: Determines the number of days to look back for retrieving the last orders. Default value is 10.

Updating Configuration
To update the configuration dynamically:

Modify the configuration in the GitHub repository.

Refresh the configuration using the Actuator endpoint:
curl -X POST http://localhost:9001/actuator/refresh
or use the Swagger UI

🩺 Health Check and Monitoring
The application uses Spring Boot Actuator to monitor its health and status.

Health Check Endpoint
Access the health check endpoint at:
http://localhost:8080/actuator/health
or use the Swagger UI
Custom Health Indicator
The microservice is considered UP if there are orders in the COMMANDE table. Otherwise, it will return DOWN.

👥 Team
Meet the team behind Mcommandes:
DAKKA Ilyass
Marouane Rachdi

📜 License
This project is licensed under the MIT License. See the LICENSE file for details.
