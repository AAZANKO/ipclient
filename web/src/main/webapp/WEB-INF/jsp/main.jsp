<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.ArrayList" %>
<%@ page import="com.aip.dao.model.Client" %>
<%@ page import="com.aip.dao.model.Officer" %>
<%@ page import="com.aip.dao.model.Contract" %>

<%--         import="by.htp.library.entity.User"
         import="by.htp.library.entity.Book"
         import="by.htp.library.entity.Zakaz"--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Страница администратора</title>
        <link rel="stylesheet" type="text/css" href="librarystilest.css">

    </head>
<body>
<%
    /*        String message = (String) request.getAttribute("message");
            User user = (User) request.getAttribute("myuser");
            Book book = (Book) request.getAttribute("mybook");
            Zakaz zakaz = (Zakaz) request.getAttribute("myzakaz");
            User userSession = (User) request.getAttribute("loginer");*/

/*    ArrayList<Officer> arrOfficer = (ArrayList<Officer>) request.getAttribute("allofficer");
    ArrayList<Client> arrClient = (ArrayList<Client>) request.getAttribute("allclient");
    ArrayList<Contract> arrContract = (ArrayList<Contract>) request.getAttribute("allcontract");*/

    /*    ArrayList<Integer> arrIntBut = (ArrayList<Integer>) request.getAttribute("arrIntButton");*/
%>
<h1 class="library">
    <b>AIP-CLIENT</b>
</h1>
<header>
    <nav class="dws-menu">
        <ul>
            <li><a href=#>Клиент</a>
                <ul>
                    <li>
                        <!--  class="contact_form"  -->
                        <form action="/client" method="get">
                            <input class="button_menu" type="submit" name="sing in" value="Все клиенты"/>
                        </form>
                    <li>
                        <!--  class="contact_form"  -->
                        <form action="FrontController" method="post">
                            <input type="hidden" name="command" value="allusersearch"/>
                            <input class="button_menu" type="submit" name="sing in" value="Карточка клиента"/>
                        </form>
                    <li>
                        <form action="FrontController" method="post">
                            <input type="hidden" name="idPage" value="1"/>
                            <input type="hidden" name="command" value="allusersearchpage"/>
                            <input class="button_menu" type="submit" name="sing in" value="Добавить"/>
                        </form>
                    <li>
                        <form action="AdminRegisPage" method="post">
                            <input class="button_menu" type="submit" name="sing in" value="Удалить"/>
                        </form>
                    <li>
                        <form action="AdminDelUserPage" method="post">
                            <input class="button_menu" type="submit" name="sing in" value="Обновить"/>
                        </form>
                    <li>
                        <form action="AdminUpdUserFirstNamePage" method="post">
                            <input class="button_menu" type="submit" name="sing in" value="Закрыть"/>
                        </form>
                </ul>
            </li>
            <li><a href=#>Договора</a>
                <ul>
                    <li>
                        <form action="/contract" method="get">
                            <input class="button_menu" type="submit" name="sing in" value="Договоры"/>
                        </form>
                    <li>
                        <form action="FrontController" method="get">
                            <input type="hidden" name="idPage" value="1"/>
                            <input type="hidden" name="command" value="allbooksearchpage"/>
                            <input class="button_menu" type="submit" name="sing in" value="Ликвидации"/>
                        </form>
                    <li>
                        <form action="AdminAddBookPage" method="post">
                            <input class="button_menu" type="submit" name="sing in" value="Анкеты"/>
                        </form>
                </ul>
            </li>
            <li><a href=#>Справочник телефонов</a>
                <ul>
                    <li>
                        <form action="FrontController" method="post">
                            <input type="hidden" name="command" value="allkaufzakazalluser"/>
                            <input class="button_menu" type="submit" name="sing in" value="Телефоны"/>
                        </form>
                    <li>
                        <form action="FrontController" method="post">
                            <input type="hidden" name="idPage" value="1"/>
                            <input type="hidden" name="command" value="allkaufzakazalluserpage"/>
                            <input class="button_menu" type="submit" name="sing in" value="Поиск по номеру"/>
                        </form>
                </ul>
            </li>
            <li><a href=#>График</a>
                <ul>
                    <li><a href=#>Поиск по аудитору</a>
                    <li><a href=#>Поиск по дате</a>
                </ul>
            </li>
            <li><a href=#>Отчеты</a>
                <ul>
                    <li>
                        <form action="/other" method="post">
                            <input class="button_menu" type="submit" name="sing in" value="submit_button_log_out"/>
                        </form>
                </ul>
            </li>
            <li><a href=#>Администрирование</a>
                <ul>
                    <li><a href=#>Услуги</a>
                    <li><a href=#>Аудиторы</a>
                    <li><a href="http://localhost:8080/officer">Пользователи</a>
                    <li>
                        <%--<form id="my_form" name="user_data" method="get" action="http://178.124.206.48/fe/form.php">--%>

                        <form action="/officer" method="get">
                            <input class="button_menu" type="submit" name="officer" value="Все Пользователи"/>
                        </form>
                </ul>
            </li>
        </ul>
    </nav>
</header>


    <h1 class="library">
        <b>${message}</b>
    </h1>


    <c:if test="${allofficer != null}">
        <table
                style="border-style: solid; border-width: 1px; width: 1400px; border-collapse: collapse;">
            <thead>
            <tr style="background-color: gray;">
                <td style="width: 40px;">ID</td>
                <td style="width: 120px;">firstName</td>
                <td style="width: 120px;">lastName</td>
                <td style="width: 120px;">middleName</td>
                <td style="width: 120px;">officerType</td>
                <td style="width: 120px;">officerCode</td>
                <td style="width: 120px;">datePrinyat</td>
                <td style="width: 120px;">dateUvolen</td>
                <td style="width: 120px;">status</td>
            </tr>
            </thead>
            <tr>
                <c:forEach var="officers" items="${allofficer}">
            <tr>
                <td><c:out value="${officers.id}"/></td>
                <td><c:out value="${officers.firstName}"/></td>
                <td><c:out value="${officers.lastName}"/></td>
                <td><c:out value="${officers.middleName}"/></td>
                <td><c:out value="${officers.officerType}"/></td>
                <td><c:out value="${officers.officerCode}"/></td>
                <td><c:out value="${officers.datePrinyat}"/></td>
                <td><c:out value="${officers.dateUvolen}"/></td>
                <td><c:out value="${officers.status}"/></td>
            </tr>
            </c:forEach>
            </tr>
        </table>
    </c:if>


    <c:if test="${allclient != null}">
        <table
                style="border-style: solid; border-width: 1px; width: 1400px; border-collapse: collapse;">
            <thead>
            <tr style="background-color: gray;">
                <td style="width: 40px;">ID</td>
                <td style="width: 180px;">NUMBER</td>
                <td style="width: 180px;">NAME</td>
                <td style="width: 80px;">SHORTNAME</td>
                <td style="width: 80px;">TYPE</td>
                <td style="width: 80px;">CODE</td>
                <td style="width: 40px;">OPDEN</td>
                <td style="width: 100px;">CLOSE</td>
                <td style="width: 100px;">UNP</td>
                <td style="width: 100px;">ACCOUNT</td>
            </tr>
            </thead>
            <tr>
                <c:forEach var="clients" items="${allclient}">
            <tr>
                <td><c:out value="${clients.id}"/></td>
                <td><c:out value="${clients.clientNumber}"/></td>
                <td><c:out value="${clients.name}"/></td>
                <td><c:out value="${clients.shortName}"/></td>
                <td><c:out value="${clients.analytikTypeId}"/></td>
                <td><c:out value="${clients.analytikCodeId}"/></td>
                <td><c:out value="${clients.dateOpen}"/></td>
                <td><c:out value="${clients.dateClose}"/></td>
                <td><c:out value="${clients.unp}"/></td>
                <td><c:out value="${clients.account}"/></td>
            </tr>
            </c:forEach>
            </tr>
        </table>
    </c:if>


    <c:if test="${allcontract != null}">
        <table
                style="border-style: solid; border-width: 1px; width: 1400px; border-collapse: collapse;">
            <thead>
            <tr style="background-color: gray;">
                <td style="width: 40px;">id</td>
                <td style="width: 180px;">contractNumber</td>
                <td style="width: 180px;">contractDate</td>
                <td style="width: 180px;">stage</td>
                <td style="width: 180px;">contractAmount</td>
                <td style="width: 100px;">status</td>
            </tr>
            </thead>
            <tr>
                <c:forEach var="contracts" items="${allcontract}">
            <tr>
                <td><c:out value="${contracts.id}"/></td>
                <td><c:out value="${contracts.contractNumber}"/></td>
                <td><c:out value="${contracts.contractDate}"/></td>
                <td><c:out value="${contracts.stage}"/></td>
                <td><c:out value="${contracts.contractAmount}"/></td>
                <td><c:out value="${contracts.status}"/></td>
            </tr>
            </c:forEach>
            </tr>
        </table>
    </c:if>

    </body>
</html>