<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tic-tac-toe</title>
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css"/>
</head>
<body>
<div id="container" class="mx-auto" style="height:750px; width: 500px;">
    <p><h1 class="text-center">Tic-tac-toe</h1></p>
    <form:form action="handleDecision" modelAttribute="game" method="post">
        <table>
        <tr>
            <td>
                <form:textarea path="currentTTT[0]" style="resize:none" class="form-control" readonly="false"/>
            </td>
            <td>
                <form:textarea path="currentTTT[1]" style="resize:none" class="form-control" readonly="false"/>
            </td>
            <td>
                <form:textarea path="currentTTT[2]" style="resize:none" class="form-control" readonly="false"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:textarea path="currentTTT[3]" style="resize:none" class="form-control" readonly="false"/>
            </td>
            <td>
                <form:textarea path="currentTTT[4]" style="resize:none" class="form-control" readonly="false"/>
            </td>
            <td>
                <form:textarea path="currentTTT[5]" style="resize:none" class="form-control" readonly="false"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:textarea path="currentTTT[6]" style="resize:none" class="form-control" readonly="false"/>
            </td>
            <td>
                <form:textarea path="currentTTT[7]" style="resize:none" class="form-control" readonly="false"/>
            </td>
            <td>
                <form:textarea path="currentTTT[8]" style="resize:none" class="form-control" readonly="false"/>
            </td>
        </tr>
        </table>
        <form:input path="previousTTT[0]" type="hidden"/>
        <form:input path="previousTTT[1]" type="hidden"/>
        <form:input path="previousTTT[2]" type="hidden"/>
        <form:input path="previousTTT[3]" type="hidden"/>
        <form:input path="previousTTT[4]" type="hidden"/>
        <form:input path="previousTTT[5]" type="hidden"/>
        <form:input path="previousTTT[6]" type="hidden"/>
        <form:input path="previousTTT[7]" type="hidden"/>
        <form:input path="previousTTT[8]" type="hidden"/>
        <input type="submit" value="Confirm" class="btn btn-primary btn-block"/>
    </form:form>
</div>
</body>
</html>