JDBC-CRUD

A simple Java project demonstrating JDBC CRUD operations with MySQL, including transaction handling using PreparedStatement and generated keys.

📌 Project Overview

This project demonstrates:

JDBC database connection

Create, Read, Update, Delete (CRUD) operations
Insert operations with auto-generated keys
Transaction management (Commit & Rollback)
Order & OrderItem relational mapping
Exception handling in JDBC

The project is built using:

Java 23
MySQL
Maven
IntelliJ IDEA

📂 Project Structure
JDBC-CRUD
│── src/main/java/org/example
│   ├── JDBCDemo.java
│   ├── TransactionsDemo.java
│   ├── RuntimeException.java
│
│── pom.xml
│── .gitignore

🛠 Technologies Used
Java (JDK 23)
JDBC
MySQL
Maven

🗄 Database Setup
Create the database:
CREATE DATABASE basic_sql;

USE basic_sql;
Orders Table

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    customer_name VARCHAR(100),
    total_amount DOUBLE
);

Order Items Table

CREATE TABLE orderItem (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product_name VARCHAR(100),
    quantity INT,
    price DOUBLE,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);
Database Configuration
Update your database credentials inside the project:

String url = "jdbc:mysql://localhost:3306/basic_sql";
String username = "root";
String password = "your_password";

▶️ How to Run

1.Clone the repository:
git clone https://github.com/shaileshkumar36/JDBC-CRUD.git
2.Open in IntelliJ IDEA
3.Configure MySQL connection
4.Run TransactionsDemo.java

🚀 Features Implemented

✔ Insert Order
✔ Insert Order Items
✔ Auto-generated Order ID retrieval
✔ Transaction handling
✔ Commit & Rollback support
✔ Exception handling

🧠 Concepts Covered
Connection
PreparedStatement
ResultSet
Statement.RETURN_GENERATED_KEYS
Transaction management (setAutoCommit(false))
SQL exception handling

📌 Future Improvements

Add Update & Delete operations
Add REST API using Spring Boot
Add Logging (SLF4J)
Add Unit Testing
Use Connection Pool (HikariCP)

👤 Author

Shailesh Kumar
GitHub: https://github.com/shaileshkumar36
