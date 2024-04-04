<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
    <div class="row mt-4 m-2">
        <c:forEach var="item" items="${items}">
            <div class="col-sm-4">
                <div class="card bg-light mb-2 text-center">
                    <h6>${item.getName()}</h6>
                    <a href="Bai3/detail.jsp?itemName=${item.getName()}&amp;itemImage=${item.getImage()}&amp;itemPrice=${item.getPrice()}&amp;itemDiscount=${item.getDiscount()}">
                        <img src="img/${item.getImage()}" alt="" class="img-fluid" />
                    </a>
                    <h5><strike>${item.getPrice()}</strike></h5>
                    <mark>${item.getPrice() * (1 - item.getDiscount())}</mark>
                </div>
            </div>
        </c:forEach>
    </div>
</div>



