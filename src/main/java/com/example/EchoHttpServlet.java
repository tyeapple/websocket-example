package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by peter.ty on 15/11/13.
 */
public class EchoHttpServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger("root");

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("this is httpservlet");
        logger.info("txxxxx");
    }
}
