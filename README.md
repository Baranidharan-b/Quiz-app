# Quiz Application

A simple Spring Boot-based Quiz Application that allows users to start a quiz, answer questions, and view the quiz summary.

## Features

- Start a new quiz session for a user.
- Get a random question from the database.
- Submit answers and calculate correct/incorrect answers.
- Get a summary of the quiz session.

## Technologies Used

- **Spring Boot** for building the backend.
- **H2 Database** for in-memory storage (used for development).
- **JPA/Hibernate** for database operations.
- **REST API** to expose the quiz functionality.

## Prerequisites

- **Java 17+** (Spring Boot 3.x version).
- **Maven** (for building the project).
- **IDE** like IntelliJ IDEA or Eclipse (optional, for development).

## Running the Application

1. **Clone the Repository**:

   ```bash
   git clone <repository-url>
   cd quiz-app
   ```

2. **Run the Application**:

   You can run the application using Maven or your IDE.

   **Using Maven**:

   ```bash
   mvn spring-boot:run
   ```

   **Using IDE**:

   - Open the project in your IDE (e.g., IntelliJ IDEA or Eclipse).
   - Run the main application class (`QuizApplication.java`) that contains the `@SpringBootApplication` annotation.

   The application will run on `http://localhost:8080` by default.

3. **Access the H2 Database Console**:

   Navigate to:

   ```
   http://localhost:8080/h2-console
   ```

   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **Username**: `sa`
   - **Password**: (leave blank)

   Click **Connect**.

## Database Initialization

The database will be automatically initialized with the following data (via `data.sql`):

```sql
-- Sample user data
INSERT INTO username (id, name) VALUES (1, 'John Doe');

-- Sample question data
INSERT INTO question (id, text, options, correct_answer) VALUES
(1, 'What is 2+2?', '4,3,5,2', '4'),
(2, 'Capital of France?', 'Paris,London,Berlin,Madrid', 'Paris'),
(3, 'Sun rises in?', 'East,West,North,South', 'East');
```

## Testing the Endpoints

You can test the API endpoints using Postman or `cURL`. Below are the details of each endpoint:

### 1. Start a New Quiz Session

- **Endpoint**: `POST /api/quiz/start/{userId}`
- **Description**: Starts a new quiz session for a user.

**Example Request**:

- **URL**: `http://localhost:8080/api/quiz/start/1`
- **Method**: `POST`

**Expected Response (200 OK)**:

```json
{
  "id": 1,
  "user": {
    "id": 1,
    "name": "John Doe"
  },
  "totalQuestions": 0,
  "correctAnswers": 0,
  "incorrectAnswers": 0
}
```

### 2. Get a Random Question

- **Endpoint**: `GET /api/quiz/question`
- **Description**: Retrieves a random question from the database.

**Example Request**:

- **URL**: `http://localhost:8080/api/quiz/question`
- **Method**: `GET`

**Expected Response (200 OK)**:

```json
{
  "id": 1,
  "text": "What is 2+2?",
  "options": "4,3,5,2",
  "correctAnswer": "4"
}
```

### 3. Submit an Answer

- **Endpoint**: `POST /api/quiz/submit/{sessionId}/{questionId}`
- **Description**: Submits an answer for a specific question in a quiz session.

**Example Request**:

- **URL**: `http://localhost:8080/api/quiz/submit/1/1?answer=4`
- **Method**: `POST`

**Expected Response (200 OK)**:

```json
"Answer submitted successfully"
```

### 4. Get Quiz Summary

- **Endpoint**: `GET /api/quiz/summary/{sessionId}`
- **Description**: Retrieves the summary of a quiz session.

**Example Request**:

- **URL**: `http://localhost:8080/api/quiz/summary/1`
- **Method**: `GET`

**Expected Response (200 OK)**:

```json
{
  "id": 1,
  "user": {
    "id": 1,
    "name": "John Doe"
  },
  "totalQuestions": 1,
  "correctAnswers": 1,
  "incorrectAnswers": 0
}
```

## Example cURL Commands

If you prefer using `cURL` to test the API, here are some example commands:

### Start Quiz

```bash
curl -X POST http://localhost:8080/api/quiz/start/1
```

### Get Random Question

```bash
curl http://localhost:8080/api/quiz/question
```

### Submit Answer

```bash
curl -X POST "http://localhost:8080/api/quiz/submit/1/1?answer=4"
```

### Get Quiz Summary

```bash
curl http://localhost:8080/api/quiz/summary/1
```

## H2 Database Access

You can use the H2 Console to check the data directly. The console is accessible at:

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (leave blank)

Once connected, you can execute SQL queries such as:

```sql
SELECT * FROM username;
SELECT * FROM question;
```

---

### Notes:

- Replace `<repository-url>` with your actual repository URL.
- Ensure the correct paths for any files or directories mentioned.

Let me know if you need any changes or further additions!
