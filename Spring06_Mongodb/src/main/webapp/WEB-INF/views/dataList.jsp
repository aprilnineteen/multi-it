<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <table class="table">
        <tr>
            <th>이미지</th>
            <th>제목</th>
            <th>X</th>
            <th>Y</th>
            <th>생성일</th>
            <th>수정일</th>
        </tr>
        <c:forEach var="data" items="${dataList}">
            <tr>
                <td><span>${data.display1}</span></td>
                <td><span>${data.display2}</span></td>
                <td><span>${data.x}</span></td>
                <td><span>${data.y}</span></td>
                <td><span>${data.createdAt}</span></td>
                <td><span>${data.updatedAt}</span></td>
            </tr>
        </c:forEach>
    </table>
</div>
