# Client Service
Caja los Heroes challenge

## Required software
- Java: openjdk 8
- IDE: Eclipse Enterprise Edition
- Bdd: MySQL

## Setup database and configurations

1. MySQL has to be installed.
2. Create a user for the database:

- `mysql -u root`: To open the MySQL shell.
- `> CREATE USER 'user' IDENTIFIED BY 'password';`
- `> GRANT ALL PRIVILEGES ON *.* TO 'user'@'%' WITH GRANT OPTION;`

3. Environment variable:
- `ENVIRONMENT_PROFILE`: `local` or `prod` (if don't exist, default value is `local`)
- `CLIENT_SERVICE_DB_USERNAME`: your MySQL ***username***
- `CLIENT_SERVICE_DB_PASSWORD`: your MySQL ***password***

4. Create a new database (for local locally is **reportsTest**):

- `> CREATE DATABASE heroes_challenge_database;`

5. Update the **application-XXX.properties** file with:
- `spring.datasource.url`: jdbc:mysql://***databaseIP***:3306/***databaseName***

6. Others configurations in **application-XXX.properties**:
- `spring.jpa.hibernate.ddl-auto`: `create` or `update` or `create-drop` or `validate` or `none` (for production should be `none`)
- `server.port`: your ***service port***
- `azure.application-insights.instrumentation-key`: your ***application insights instrumentation key***
- `spring.application.name`: your ***application name*** identification