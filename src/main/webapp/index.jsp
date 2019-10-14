<%@page contentType="text/html;utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <script src=${path}/js/jquery-1.8.3.min.js></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                var key = $("#txt").val();
                $.ajax({
                    url: "${path}/poem/findAll",
                    data: {"key": key},
                    type: "post",
                    dataType: "json",
                    success: function (data) {
                        console.log(data);
                        for (var i = 0; i < data.length; i++) {
                            var nli = $("<li>").text(data[i].name);
                            var ali = $("<li>").text(data[i].author);
                            var tli = $("<li>").text(data[i].type);
                            var cli = $("<li>").text(data[i].content);
                            var hr = $("<hr>");
                            $("#ul").append(nli).append(ali).append(tli).append(cli).append(hr);
                        }
                    }
                })
            })
        })
    </script>


</head>
<body>

<input id="txt" type="text">
<input id="btn" type="button" value="搜索">

<div id="ul">
</div>

</body>
</html>