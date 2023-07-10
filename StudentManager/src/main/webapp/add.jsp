<%--
  Created by IntelliJ IDEA.
  User: eqxph
  Date: 2023/7/5
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <center>
          <h3>学生信息添加页面</h3>
          <form action="${pageContext.request.contextPath}/student/addStudent">
              学生姓名:<input type="text" name="name"><br>
              学生年龄:<input type="text" name="age"><br>
<%--              性别默认为男--%>
              学生性别:<input type="radio" name="gender" value="男" checked="checked">男
                      <input type="radio" name="gender" value="女">女
              <br>
              <input type="submit" value="提交">提交
          </form>
      </center>
</body>
</html>
