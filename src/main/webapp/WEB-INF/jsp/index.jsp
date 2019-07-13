<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Welcome</h1>

<div>
    <h3>Enter the parking</h3>
    <form action="${pageContext.request.contextPath}/tickets" method="post">
        <label>Enter the code: <input name="subscriptionCode" type="text"/></label>
        <input type="submit" value="Access"/>
    </form>

    <c:out value="${ticketCode}"/>
</div>
<div>
    <h3>Exit the parking</h3>
    <form action="">
        <label>Enter the code: <input type="text"/></label>
        <input type="submit" value="Exit"/>
    </form>
</div>
<div>
    <h3>Pay bill</h3>
    <form action="">
        <input type="submit" value="Pay ticket"/>
    </form>
</div>
<div>
    <h3>Buy subscription</h3>
    <form action="">
        <input type="submit" value="Buy subscription"/>
    </form>
</div>
<%--<a href="${pageContext.request.contextPath}/personList">Person List</a>--%>

</body>

</html>