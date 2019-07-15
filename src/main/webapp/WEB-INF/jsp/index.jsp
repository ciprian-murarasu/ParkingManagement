<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<h1>Welcome</h1>

<div>
    <h3>Enter the parking</h3>
    <form action="${pageContext.request.contextPath}/access" method="post">
        <label>Enter the code: <input type="text" name="code" size="8" maxlength="10"/></label>
        <input type="submit" value="Access"/>
    </form>
    <c:if test="${not empty ticketCode}">
        <p><c:out value="${ticketCode}"/></p>
    </c:if>
    <p><c:out value="${accessMessage}"/></p>
</div>
<div>
    <h3>Exit the parking</h3>
    <form action="${pageContext.request.contextPath}/exit" method="post">
        <label>Enter the code: <input type="text" size="8" maxlength="10"/></label>
        <input type="submit" value="Exit"/>
    </form>
</div>
<br>
<div>
    <h3>Pay bill</h3>
    <form action="${pageContext.request.contextPath}/tickets/pay" method="post">
        <label>Enter the code: <input type="text" name="code" size="8" maxlength="10" value="<c:out value='${code}'/>"/></label>
        <button>Calculate fee</button>
        <c:if test="${calculated}">
            <p><c:out value="You have to pay: ${price}"/></p>
            <input type="submit" name="pay" value="Pay ticket"/>
            <c:if test="${payed}">
                <p><c:out value="${payMessage}"/></p>
            </c:if>
        </c:if>
        <c:if test="${not calculated}">
            <p><c:out value="${calculateMessage}"/></p>
        </c:if>
    </form>
</div>
<div>
    <h3>Buy subscription</h3>
    <form action="${pageContext.request.contextPath}/subscriptions" method="post">
        <label for="from">Start date</label>
        <input type="text" size="8" maxlength="10" id="from" name="from">
        <label for="to">End date</label>
        <input type="text" size="8" maxlength="10" id="to" name="to">
        <input type="submit" value="Get subscription"/>
    </form>
</div>

<script>
    $(function () {
        var dateFormat = "mm/dd/yy",
            from = $("#from")
                .datepicker({
                    defaultDate: "+1w",
                    changeMonth: true,
                    numberOfMonths: 1
                })
                .on("change", function () {
                    to.datepicker("option", "minDate", getDate(this));
                }),
            to = $("#to").datepicker({
                defaultDate: "+1w",
                changeMonth: true,
                numberOfMonths: 1
            })
                .on("change", function () {
                    from.datepicker("option", "maxDate", getDate(this));
                });

        function getDate(element) {
            var date;
            try {
                date = $.datepicker.parseDate(dateFormat, element.value);
            } catch (error) {
                date = null;
            }
            return date;
        }
    });
</script>

</body>
</html>