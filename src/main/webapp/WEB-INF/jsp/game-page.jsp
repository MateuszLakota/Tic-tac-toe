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
                <form:textarea path="currentBoard[0]" style="resize:none" class="form-control" readonly="${game.shouldElementBeReadonly(0)}"/>
            </td>
            <td>
                <form:textarea path="currentBoard[1]" style="resize:none" class="form-control" readonly="${game.shouldElementBeReadonly(1)}"/>
            </td>
            <td>
                <form:textarea path="currentBoard[2]" style="resize:none" class="form-control" readonly="${game.shouldElementBeReadonly(2)}"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:textarea path="currentBoard[3]" style="resize:none" class="form-control" readonly="${game.shouldElementBeReadonly(3)}"/>
            </td>
            <td>
                <form:textarea path="currentBoard[4]" style="resize:none" class="form-control" readonly="${game.shouldElementBeReadonly(4)}"/>
            </td>
            <td>
                <form:textarea path="currentBoard[5]" style="resize:none" class="form-control" readonly="${game.shouldElementBeReadonly(5)}"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:textarea path="currentBoard[6]" style="resize:none" class="form-control" readonly="${game.shouldElementBeReadonly(6)}"/>
            </td>
            <td>
                <form:textarea path="currentBoard[7]" style="resize:none" class="form-control" readonly="${game.shouldElementBeReadonly(7)}"/>
            </td>
            <td>
                <form:textarea path="currentBoard[8]" style="resize:none" class="form-control" readonly="${game.shouldElementBeReadonly(8)}"/>
            </td>
        </tr>
        </table>
        <form:input path="previousBoard[0]" type="hidden"/>
        <form:input path="previousBoard[1]" type="hidden"/>
        <form:input path="previousBoard[2]" type="hidden"/>
        <form:input path="previousBoard[3]" type="hidden"/>
        <form:input path="previousBoard[4]" type="hidden"/>
        <form:input path="previousBoard[5]" type="hidden"/>
        <form:input path="previousBoard[6]" type="hidden"/>
        <form:input path="previousBoard[7]" type="hidden"/>
        <form:input path="previousBoard[8]" type="hidden"/>
        <input type="submit" value="Confirm" class="btn btn-primary btn-block"/>
    </form:form>
</div>
</body>
</html>