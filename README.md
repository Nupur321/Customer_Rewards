# Charter/Retailer Customer Rewards Program

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total.
· Make up a data set to best demonstrate your solution
· Check solution into GitHub

# Sample data
1. Using Spring Boot in memory H2 DB for creation of sample data. 
2. There are two schemas - Customer and Transaction schema
3. These two schemas have a Foreign key relationship. Queries to create these schemas are present in schema.sql under src/main/resources.
4. Queries to define the constraint and add sample data to above schemas are written under data.sql

# Test Cases
Create Test Cases under src/test/java for below scenarios:
1. Multiple Transaction data
2. Amount < 50
3. Amount > 50 & < 100
4. Amount > 100
5. Amount = Hundred

# Exception Handling
Implemented Spring Boot @Controller Advice.
Define a Custom Exception named CustomerNotFoundexception for scenarios where no customer is returned.

# To run
- git clone 
- mvn clean compile
- mvn spring-boot:run

# Urls:
1. To get rewards for All customers  -> /rewards
2. To get Rewards for Customer by their Id -> /rewards/{customerId} 

After the program is run, user can enter either of the following link in the URL:
http://localhost:8080/rewards

http://localhost:8080/rewards/1

# Database 

To log into the H2 database to check the data in tables use following link:
http://localhost:9091/h2  
JDBC URL =jdbc:h2:mem:testdb  
UserName = sa   
There is no password  

