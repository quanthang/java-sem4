%@page import="util.ShoppingCartHelper" %>
<%@page import="com.example.t2009m1_helloworld.entity.Shoppingcart" %>
<%@page import="" %>
<%@page import="" %>
<%@page import="" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="com.example.t2009m1_helloworld.entity.cartItem" %>
<%@ page import="com.example.t2009m1_helloworld.util.ShoppingCartHelper" %>
<%@ page import="ShoppingCart.ShoppingCart" %>
<%--
  Created by IntelliJ IDEA.
  User: 🤡🤡🤡
  Date: 06/06/2022
  Time: 10:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%
    ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(request);
    Shoppingcart shoppingCart = shoppingCartHelper.getCart();
    Locale loc = new Locale("vi","VN");
    NumberFormat nf = NumberFormat.getCurrencyInstance(loc);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<h1>List products in shopping cart</h1>
<ul>
    <%for (cartItem cartItem : shoppingCart.getListItems()){%>
    <li>
        <%=cartItem.getproductName()%>
        <%=nf.format(cartItem.getUnitPrice())%>
        <%=cartItem.getQuantity()%>
        <a href="/shopping-cart/add?productId=<%=cartItem.getProductId()%>&quantity=1" style="">+</a>
        <a href="/shopping-cart/add?productId=<%=cartItem.getProductId()%>&quantity=1" style="">+</a>
        <a href="/shopping-cart/remove?productId=<%=cartItem.getProductId()%>" style="">+</a>
    </li>
    <%}%>
</ul>
<strong>Total price: <%=nf.format(shoppingCart.getTotalPrice())%></strong>
<div>
    <strong><a href="/product">Back to shopping</a></strong>
</div>
</body>
</html>