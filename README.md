# TomcatServlet

## Overview
- Simple Java web application using Servlets and JSP  
- Demonstrates request → processing → response flow  

## Tech Stack
- Java  
- Jakarta Servlet API  
- Apache Tomcat  
- Maven  

## Features
- UC1: Basic servlet response  
- UC2: Login form with Servlet and JSP  
- UC3: Username validation (capital, min 3 chars)  
- UC4: Password validation (length, uppercase, digit, special char)  

## Flow
- Browser → Tomcat → Servlet → Response  

## Run
- mvn clean package  
- Copy WAR to tomcat/webapps/  
- Open http://localhost:8080/FirstServletProject/login.html  

## Note
- Uses jakarta.servlet (Tomcat 10+)  
