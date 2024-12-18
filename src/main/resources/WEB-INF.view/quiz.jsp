<!DOCTYPE html>
<html>
<head>
    <title>Quiz - Question</title>
</head>
<body>
    <h1>${question.questionText}</h1>
    <form action="/quiz/answer" method="post">
        <input type="hidden" name="sessionId" value="${sessionId}" />
        <input type="hidden" name="questionId" value="${question.id}" />
        <ul>
            <c:forEach var="option" items="${question.options}">
                <li><input type="radio" name="answer" value="${option}" /> ${option}</li>
            </c:forEach>
        </ul>
        <button type="submit">Submit Answer</button>
    </form>
</body>
</html>
