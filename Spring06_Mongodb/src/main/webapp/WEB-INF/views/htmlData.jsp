<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HTML Parsing</title>
</head>
<body>
    <table border="1">
        <thead>
            <tr>
                <th>NAME</th>
                <th>AGE</th>
            </tr>
        </thead>
        <tbody id="jsonTable">
        </tbody>
    </table>
    <script>
        // 컨트롤러에서 전달된 JSON 데이터
        var jsonData = ${jsonData};
        var tableBody = document.getElementById("jsonTable");
        jsonData.forEach(function(item) {
            var row = "<tr>";
            row += "<td>" + item.name + "</td>";
            row += "<td>" + item.age + "</td>";
            row += "</tr>";
            tableBody.innerHTML += row;
        });
    </script>
</body>
</html>
