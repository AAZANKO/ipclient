<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library</title>
        <link rel="stylesheet" type="text/css" href="librarystilest.css">
        <link rel="stylesheet" type="text/css" href="/css/librarystilest.css">
        <link rel="stylesheet" type="text/css" href="css/librarystilest.css">

    </head>
    <body>

        <table class="llokale" width=40 height=20 align="right">
            <tr>
                <td>
                    <form action="Controller" method="post">
                        <input type="hidden" name="local" value="ru" />
                        <input class="button" type="submit" value="${ru_button}" />
                    </form>
                </td>
                <td>
                    <form action="Controller" method="post">
                        <input type="hidden" name="local" value="en" />
                        <input class="button" type="submit" value="${en_button}" />
                    </form>
                </td>
            </tr>
        </table>

    <h1 class="library"><b>Library</b></h1>


        <form class="contact_form" action="RegisPage" method="post">
            <ul>
                <li>
                    <input class="button_a" type="submit" name="sing in" value="${submit_button_reg}" />
                </li>
            </ul>
        </form>


    </body>
</html>