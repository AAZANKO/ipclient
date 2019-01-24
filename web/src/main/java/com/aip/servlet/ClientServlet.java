package com.aip.servlet;

import com.aip.service.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @WebServlet("/client_jsp")
public class ClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // List<Client> clientService = ClientService.getInstance().getClientService();

        ClientService clientService = null;

       // List<Client> clientServiceList = clientService.findById();

        req.setAttribute("allclient", clientService);

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(req, resp);
    }
}
