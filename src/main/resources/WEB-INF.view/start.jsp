<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Start Quiz</title></head>
<body>
    <h2>Welcome to the Quiz!</h2>
    <form action="/quiz/question" method="get">
        <input type="hidden" name="sessionId" value="${sessionId}" />
        <button type="submit">Start Quiz</button>
    </form>
</body>
</html>
