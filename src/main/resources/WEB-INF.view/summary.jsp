<!DOCTYPE html>
<html>
<head>
    <title>Quiz - Result</title>
</head>
<body>
    <h1>${isCorrect ? 'Correct!' : 'Incorrect!'}</h1>
    <p>Summary: ${summary}</p>
    <form action="/quiz/start" method="get">
        <button type="submit">Start New Quiz</button>
    </form>
</body>
</html>
