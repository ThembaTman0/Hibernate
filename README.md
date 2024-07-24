# Hibernate CRUD Example

This project is a simple Java application demonstrating the use of Hibernate for basic CRUD (Create, Read, Update, Delete) operations. The application connects to a MySQL database and manages user data.

## Technologies Used

- Java
- Hibernate ORM
- MySQL

## Project Structure

src/main/java
├── org
│ ├── entity
│ │ └── Users.java
│ └── main
│ └── App.java
├── resources
│ ├── hibernate.cfg.xml
│ └── log4j2.xml


## Setup

### Prerequisites

- JDK 8 or higher
- Maven
- MySQL

### Database Configuration

Create a MySQL database named `project` and configure the user and password in the `hibernate.cfg.xml` file.

```xml
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
 
<hibernate-configuration>
    <session-factory>
 
        <!-- Connection settings -->
        <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
              <!-- Sample MySQL URL provided  -->  
        <property name="connection.url">jdbc:mysql://localhost:3306/project</property>
        <property name="connection.username">username</property>
        <property name="connection.password">password</property>
           
        <!-- Show SQL on console -->
        <property name="show_sql">true</property>
 
		<!--Setting Session context model -->
		<property name="current_session_context_class">thread</property>
 
    </session-factory>
</hibernate-configuration>
```
##Usage
The application performs the following operations:

Create: Inserts a new user into the database.
Read: Reads and prints the user data from the database.
Update: Updates the user data.
Delete: Deletes the user from the database.



Feel free to modify the content as needed to better suit your project specifics.

