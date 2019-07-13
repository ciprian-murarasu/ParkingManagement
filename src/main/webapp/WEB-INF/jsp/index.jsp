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
    <form action="${pageContext.request.contextPath}/access" method="post">
        <label>Enter the code: <input name="code" type="text"/></label>
        <input type="submit" value="Access"/>
    </form>
    <p><c:out value="${ticketCode}"/></p>
    <p><c:out value="${accessMessage}"/></p>
</div>
<div>
    <h3>Exit the parking</h3>
    <form action="">
        <label>Enter the code: <input type="text"/></label>
        <input type="submit" value="Exit"/>
    </form>
</div>
<br>
<div>
    <h3>Pay bill</h3>
    <form action="${pageContext.request.contextPath}/payBill" method="post">
        <label>Enter the code:
            <p><input name="code" type="text"/></label></p>
        <input type="submit" value="Calculate fee"/>
        <p> <label>You have to pay:</label> </p>
            <p><c:out value="${ticketCode}"/></p>
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