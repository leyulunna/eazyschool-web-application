# EasySchool Web Application

## Introduction
EasySchool Web Application is a comprehensive school management system built using Java Spring Framework. It aims to streamline various school administrative tasks and provide an easy-to-use interface for school administrators.

## Features
- Student enrollment and management
- Teacher assignment and management
- Class scheduling
- User authentication and role-based access control

## Prerequisites
Before you begin, ensure you have met the following requirements:
- Java Development Kit (JDK) 8 or later
- Apache Maven 3.6 or later
- MySQL Database
- Git (for version control)

## Installation
1. **Clone the repository:**
   ```sh
   git clone https://github.com/leyulunna/eazyschool-web-application.git
   cd eazyschool-web-application
2. **Configure the database:**
   Create a MySQL database named easyschool and configure the connection in src/main/resources/application.properties:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/easyschool
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
3. **Load Spring dependencies:**
   Ensure Maven is installed and run the following command to load all necessary dependencies:
   ```sh
   mvn clean install
4. **Run the application:**
   Start the application using Maven:
   ```sh
   mvn spring-boot:run
5. Access the application:
   Open your web browser and navigate to http://localhost:8080.

## Project Structure
The project follows a standard Spring Boot structure:
- src/main/java/com/easyschool: Contains the main application code
   - controller: REST controllers
   - service: Business logic
   - repository: Data access
   - model: Entity classes
- src/main/resources: Configuration files and static resources
- src/test/java/com/easyschool: Unit and integration tests

## Contact
If you have any questions or need further assistance, please contact [yulun.zhangyl@gmail.com].