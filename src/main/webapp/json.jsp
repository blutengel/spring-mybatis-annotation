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

offset <input type="text" name="offset"> <br>
limit <input type="text" name="limit"> <br>

<button id="req">RequestJson</button>
<button id="resp">ResponseJson</button>


<script>

    $(document).ready(function () {

        $('#req').click(function () {

            var offset = $('input[name="offset"]').val();
            var limit = $('input[name="limit"]').val();
            var params = {};
            params.offset = offset;
            params.limit = limit;

            $.ajax({
                type: 'post',
                url: '<c:url value="/emp/pagi"/>',
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify(params),
                success: function (data) {
                    alert(JSON.stringify(data));
                }
            })
        });

        $('#req').click(function () {
            var offset = $('input[name="offset"]').val();
            var limit = $('input[name="limit"]').val();
            var params = {};
            params.offset = offset;
            params.limit = limit;

            $.ajax({
                type: 'post',
                url: '<c:url value="/emp/pagi"/>',
//                contentType: 'application/json;charset=utf-8',
                data: 'offset='+offset+ '&limit='+limit,
                success: function (data) {
                    alert(JSON.stringify(data));
                }
            })
        });
    })

</script>

</body>
</html>