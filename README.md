# SpringBootBackendTask
This project is for Rest services using Spring boot framework and MySql database. In this Project we are using Gradle Build Tool.

## Related Api Task
- Allow to add new todo task.
- Show list of all todo.
- Update existing todo task.
- Delete Single todo task or multiple todo task.

## Installation
- Clone the project from git link.
- Link to setup connection configuration of MySql database ([application.properties](https://github.com/anilkayosys/SpringBootBackendTask/blob/master/src/main/resources/application.properties))
- Create your database into MySql Database
- Change here your database name from ([application.properties](https://github.com/anilkayosys/SpringBootBackendTask/blob/master/src/main/resources/application.properties)) `jdbc:mysql://localhost:3306/{databaseName}`
- Specify username and password for MySql Database spring.datasource.username={yourUsername} & spring.datasource.password={your password}
- Now to enable cross origin Change `@CrossOrigin(origins = "http://localhost:4200")` to your localhost and port ([TodoItemController](https://github.com/anilkayosys/SpringBootBackendTask/blob/master/src/main/java/com/kayosys/springquiztask/controllers/TodoItemController.java))

## Run Rest Services
- To run the rest services you need to run the MytodoApplication.java class ([MytodoApplication](https://github.com/anilkayosys/SpringBootBackendTask/blob/master/src/main/java/com/kayosys/springquiztask/MytodoApplication.java))


