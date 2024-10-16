<%@ page import="java.util.List" %>
<%@ page import="BEAN.Post" %>
<%@ page import="DAO.PostDAO" %>

<%
    String jdbcURL = getServletContext().getInitParameter("jdbcURL");
    String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
    String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

    DAO.PostDAO postDAO = new PostDAO(jdbcURL, jdbcUsername, jdbcPassword);
    List<Post> listPost = postDAO.all();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Post List</title>
</head>
<body>
    <h1>Post List</h1>
    <table border="1">
        <tr>
            <th>PostId</th>
            <th>Title</th>
            <th>Content</th>
            <th>Name</th>
            <th>PostDay</th>
            <th>CategoryId</th>
        </tr>
        <%
            for (Post post : listPost) {
        %>
        <tr>
            <td><%= post.getPostId() %></td>
            <td><%= post.getTitle() %></td>
            <td><%= post.getContent() %></td>
            <td><%= post.getName() %></td>
            <td><%= post.getPostDay() %></td>
            <td><%= post.getCategoryId() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
