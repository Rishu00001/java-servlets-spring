package com.rishu.servlet;


import com.rishu.model.User;
import com.rishu.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        if(id == null || email == null || name == null || mobile == null){
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write("{\"message\":\"Provide all fields\"}");
        }
        User user = new User(id,name,email,mobile);
        User createdUser = userService.createUser(user);
        response.setStatus(201);
        response.setContentType("application/json");
        //return json having message and data
        response.getWriter().write(
                "{"
                        + "\"message\":\"User created successfully\","
                        + "\"data\":{"
                        + "\"id\":" + createdUser.getId() + ","
                        + "\"name\":\"" + createdUser.getName() + "\","
                        + "\"email\":\"" + createdUser.getEmail() + "\","
                        + "\"mobile\":\"" + createdUser.getMobile() + "\""
                        + "}"
                        + "}"
        );
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");

        String idParam = request.getParameter("id");

        // Get All Users
        if (idParam == null || idParam.isBlank()) {

            List<User> users = userService.getAllUsers();

            StringBuilder json = new StringBuilder();
            json.append("{");
            json.append("\"message\":\"Users fetched successfully\",");
            json.append("\"data\":[");

            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);

                json.append("{");
                json.append("\"id\":").append(user.getId()).append(",");
                json.append("\"name\":\"").append(user.getName()).append("\",");
                json.append("\"email\":\"").append(user.getEmail()).append("\",");
                json.append("\"mobile\":\"").append(user.getMobile()).append("\"");
                json.append("}");

                if (i < users.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]}");

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(json.toString());
        }

        // Get User By ID
        else {

            try {

                Integer id = Integer.parseInt(idParam);

                User user = userService.getUserById(id);

                if (user == null) {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write(
                            "{\"message\":\"User not found\",\"data\":null}"
                    );
                    return;
                }

                String json =
                        "{"
                                + "\"message\":\"User fetched successfully\","
                                + "\"data\":{"
                                + "\"id\":" + user.getId() + ","
                                + "\"name\":\"" + user.getName() + "\","
                                + "\"email\":\"" + user.getEmail() + "\","
                                + "\"mobile\":\"" + user.getMobile() + "\""
                                + "}"
                                + "}";

                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write(json);

            } catch (NumberFormatException e) {

                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(
                        "{\"message\":\"Invalid id\",\"data\":null}"
                );
            }
        }
    }
    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response){

    }
    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response){

    }
}
