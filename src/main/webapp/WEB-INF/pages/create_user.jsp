<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 18.10.2015
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
    <style>
        #login-box {
            width: 300px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
        #msgLow {
            color: #8f0612;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }
        #msgNormal {
            color: #0e198f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }
        #msgStrong{
            color: #059f17;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }
    </style>

</head>
<body>
<script type="text/javascript"
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js">
</script>
<div id="login-box">
<form name='createForm'
      action="<c:url value='/create' />" method='get'>
    <h3>Create User</h3>
  <table>
    <tr>
      <td>User:</td>
      <td><input type='text' name='username'></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type='password' name='password' onchange="checkPassword(this.value)"/></td>
      <td><div id="msgLow"><P>Low</P></div>
          <div id="msgNormal"><P>Normal</P></div>
          <div id="msgStrong"><P>Strong</P></div></td>
    </tr>
    <tr>
      <td colspan='2'><input name="submit" type="submit"
                             value="submit" /></td>
      <td colspan='2'><a href="<c:url value='/login' />">
        <input type="button" value="back" />
      </a></td>
    </tr>
  </table>

  <input type="hidden" name="${_csrf.parameterName}"
         value="${_csrf.token}" />

</form>
</div>
<script>
  function checkPassword(password) {

      $.ajax({
          url: "check_password",
          type: 'GET',
          data: "password=" + password,
          dataType: "json",
          success: function(level){
              if (level>2) {
                  $('#msgLow').hide();
                  $('#msgNormal').hide();
                  $('#msgStrong').show();
              } else if (level>1) {
                  $('#msgLow').hide();
                  $('#msgNormal').show();
                  $('#msgStrong').hide();
              } else {
                  $('#msgLow').show();
                  $('#msgNormal').hide();
                  $('#msgStrong').hide();
              }

//response here
          }
      });
 /* $.getJSON("check_password", { name: $(password').val() }, function(level) {
    if (level>2) {
        $('#msgLow').show();
        $('#msgNormal').hide();
        $('#msgStrong').hide();
    } else if (level>1) {
          $('#msgLow').hide();
          $('#msgNormal').show();
          $('#msgStrong').hide();
      } else {
        $('#msgLow').hide();
        $('#msgNormal').hide();
        $('#msgStrong').show();
    }*/
      return;
  /*});*/
}</script>
</body>
</html>
