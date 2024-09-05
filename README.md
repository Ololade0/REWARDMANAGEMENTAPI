# REWARDMANAGEMENTAPI

## Overview

      The Rewards Management API allows customers to retrieve their current cashback balance and view their cashback transaction history. Built with Java 
      and the Spring framework, this API provides a simple and effective way to manage customer rewards.

## Requirements

      - Java Development Kit (JDK) 11 or higher
      - Spring Boot
      - MySQL
      - Git for version control

- ## Setup Instructions

1. **Clone the Repository:**
     - https://github.com/Ololade0/REWARDMANAGEMENTAPI.git
   
2. **UPDATE APPLICATION.PROPERTIES:**
   -Locate the src/main/resources/application.properties file in your project and update this file : 
     - spring.datasource.url=jdbc:mysql://localhost:3306/rewards_management
     - spring.datasource.username=<your-username>
     - spring.datasource.password=<your-password>
     - spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     - spring.jpa.hibernate.ddl-auto=update
      - spring.jpa.open-in-view=true

   3. Build  the Project: Use Maven to build the project by running this command on your terminal:
       - mvn clean install
       - mvn spring-boot:run
         
    4. API Endpoints :
        - PORT : 8080
       
        ### **Get Rewards Balance**
        - Endpoint: http://localhost:8080/api/rewards/balance/{customerId}
        - Request Type: GET
        - Request Parameters:customerId (path variable)
            ### **RESPONSE**
                              - { "customerId": "1234",
                                   "totalCashback": 100.00,
                                    "currentBalance": 50.00 }
      

          
      ### **Get Cashback History**
         - Endpoint: http://localhost:8080/api/rewards/history/{customerId}
         -  Request Type: GET
         - Request Parameters:customerId (path variable)
             ### **RESPONSE**
   
            -   [
                           {
                                "transactionId": "5678",
                                "transactionDate": "2024-01-01",
                                "amountEarned": 10.00,
                                "description": "SYSTEM DETAILS" },
    
                                  {
                                      "transactionId": "5679",
                                      "transactionDate": "2024-01-05",
                                      "amountEarned": 300.00,
                                      "description": "DETAILS FOR REWARD"
                                  }
                              ]

          

      ### **NOTE** : BEFORE TESTING THE ABOVE ENDPOINT, THERE IS NEED TO CREATE A CUSTOMER AND CREATE TRANSACTION TO AVOID THROWING AN ERROR MESSAGE.
    ### **REGISTER CUSTOMER**
   REQUEST TYPE : POST
   ENDPOINT : http://localhost:8080/api/rewards/customer
   REQUEST PAYLOAD:  - {
                          "totalCashBack": 100.0,
                          "currentBalance": 50.0
                                                }
    ### **CREATE TRANSACTION**
         REQUEST TYPE : POST
         ENDPOINT : http://localhost:8080/api/rewards/TR/createTransaction
         REQUEST PAYLOAD:   {

                                      "customerId": 5,
                                      "amountEarned": 30.0,
                                      "description": "SYSTEM DETAILS"
                                    }
