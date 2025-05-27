
# Camunda BPMN Spring Boot Project

This is a **Spring Boot** project integrated with **Camunda BPM Platform** to demonstrate a business process workflow using **BPMN** and **Camunda Forms**. It includes an employee review process with decision points such as **Accept** or **Reject** using Camunda Form buttons.

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.example.camunda/       # Java code (controllers, delegates, etc.)
│   ├── resources/
│   │   ├── application.yml            # Spring Boot Configuration
│   │   ├── processes/
│   │   │   └── employee-review.bpmn   # BPMN diagram
│   │   └── forms/
│   │       ├── review-form.form       # Camunda form JSON
│   │       └── leave-form.form        # Camunda form JSON
```

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+
- Docker (optional, for database or Camunda Cockpit)

### Clone the Repository

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```

### Build and Run the Project

```bash
./mvnw spring-boot:run
```

The application will start on:  
📍 `http://localhost:8080`

## 🔄 Camunda Integration

### BPMN Process

The main BPMN process is located at:  
📁 `src/main/resources/processes/employee-review.bpmn`

It includes the following tasks:
- Fill Employee Details
- Review Employee Form (User Task with Accept/Reject buttons)
- Gateway for decision
- Approved/Rejected End Events

### Camunda Forms

Forms are in JSON format (Camunda v7 Compatible):

- `review-form.form`: Includes decision buttons **Accept** and **Reject**
- `leave-form.form`: Used for another user task in the process

These are stored in:
```
src/main/resources/forms/
```

## 🧪 API Endpoints

| Method | Endpoint          | Description                    |
|--------|-------------------|--------------------------------|
| POST   | `/start-process`  | Starts a new process instance  |
| GET    | `/tasks`          | Lists active user tasks        |
| POST   | `/complete-task`  | Completes a task with payload  |

> You can interact with these using Postman or any REST client.

## 🛠️ Customization

### Add Custom Java Delegates
Implement `JavaDelegate` and register them as Spring beans to use in BPMN service tasks.

```java
@Component("myCustomDelegate")
public class MyDelegate implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        // business logic here
    }
}
```

## 🐳 Optional: Run Camunda Cockpit via Docker

```bash
docker run -d -p 8080:8080 camunda/camunda-bpm-platform:run-latest
```

Access Camunda Cockpit at:  
📍 `http://localhost:8080/camunda`

Default login:
- Username: `admin`
- Password: `admin`

## 📦 Deployment

You can package the app and deploy it:

```bash
./mvnw clean package
java -jar target/camunda-demo-0.0.1-SNAPSHOT.jar
```

## 🧑‍💻 Contributors

- [Ghulam Yaseen Shar](https://github.com/yaseenshar)
- [LinkedIn](https://www.linkedin.com/in/ghulam-yaseen-shar-782233bb/)
- Contributors are welcome via PRs!

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📌 References

- [Camunda Documentation](https://docs.camunda.org/manual/latest/)
- [Spring Boot](https://spring.io/projects/spring-boot)
