<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <link rel="stylesheet" href="node_modules/datatables.net-dt/css/jquery.dataTables.css">
    <script src="node_modules/jquery/dist/jquery.min.js"></script>
    <script src="node_modules/datatables.net/js/jquery.dataTables.js"></script>

</head>
<body>

<%--<table id="example" class="display">--%>
<%--<thead>--%>
<%--<tr>--%>
<%--<th>First name</th>--%>
<%--<th>Last name</th>--%>
<%--<th>Position</th>--%>
<%--<th>Office</th>--%>
<%--<th>Start date</th>--%>
<%--<th>Salary</th>--%>
<%--</tr>--%>
<%--</thead>--%>
<%--<tfoot>--%>
<%--<tr>--%>
<%--<th>First name</th>--%>
<%--<th>Last name</th>--%>
<%--<th>Position</th>--%>
<%--<th>Office</th>--%>
<%--<th>Start date</th>--%>
<%--<th>Salary</th>--%>
<%--</tr>--%>
<%--</tfoot>--%>
<%--</table>--%>


<%--<table id="table_id" class="display">--%>
<%--<thead>--%>
<%--<tr>--%>
<%--<th>Employee No</th>--%>
<%--<th>First Name</th>--%>
<%--<th>Last Name</th>--%>
<%--<th>Birth Date</th>--%>
<%--<th>Gender</th>--%>
<%--<th>Hire Date</th>--%>
<%--</tr>--%>
<%--</thead>--%>
<%--<tfoot>--%>
<%--<tr>--%>
<%--<th>Employee No</th>--%>
<%--<th>First Name</th>--%>
<%--<th>Last Name</th>--%>
<%--<th>Birth Date</th>--%>
<%--<th>Gender</th>--%>
<%--<th>Hire Date</th>--%>
<%--</tr>--%>
<%--</tfoot>--%>
<%--</table>--%>


<script>
    $(document).ready(function () {
//        alert("hello");

        <%--$('#example').DataTable({--%>
        <%--"processing": true,--%>
        <%--"serverSide": true,--%>
        <%--"ajax": {--%>
        <%--"url": "<c:url value="/emp/pagi" />",--%>
        <%--"data": function (d) {--%>
        <%--//                    d.myKey = "myValue";--%>
        <%--alert(JSON.stringify(d));--%>

        <%--}--%>
        <%--}--%>
        <%--})--%>
    })
</script>

</body>
</html>