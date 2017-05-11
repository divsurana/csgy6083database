<!doctype html>
<html lang="en-US">
<!--head>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html">
  <title>User Profile with Content Tabs - Design Shack Demo</title>
  <meta name="author" content="Jake Rocheleau">
  <link rel="shortcut icon" href="http://designshack.net/favicon.ico">
  <link rel="icon" href="http://designshack.net/favicon.ico">
  <link rel="stylesheet" type="text/css" media="all" href="css/stylesup.css">
  <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
</head-->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="org.nyu.csgy6083database.model.Project"%>
<%@page import="java.util.List"%>
<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/css/stylesup.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
</head>


<style>

<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:400,300,600,400italic);
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  -webkit-font-smoothing: antialiased;
  -moz-font-smoothing: antialiased;
  -o-font-smoothing: antialiased;
  font-smoothing: antialiased;
  text-rendering: optimizeLegibility;
}

#category{
 width:320px;   
}

/*body {
  font-family: "Roboto", Helvetica, Arial, sans-serif;
  font-weight: 100;
  font-size: 12px;
  line-height: 30px;
  color: #777;
  background: #4CAF50;
}*/

.container {
  max-width: 400px;
  width: 100%;
  margin: 0 auto;
  position: relative;
}

#contact input[type="text"],
#contact input[type="email"],
#contact input[type="tel"],
#contact input[type="url"],
#contact textarea,
#contact button[type="submit"] {
  font: 400 12px/16px "Roboto", Helvetica, Arial, sans-serif;
}

#contact {
  background: #F9F9F9;
  padding: 25px;
  margin: 150px 0;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

#contact h3 {
  display: block;
  font-size: 30px;
  font-weight: 300;
  margin-bottom: 10px;
}

#contact h4 {
  margin: 5px 0 15px;
  display: block;
  font-size: 13px;
  font-weight: 400;
}

fieldset {
  border: medium none !important;
  margin: 0 0 10px;
  min-width: 100%;
  padding: 0;
  width: 100%;
}

#contact input[type="text"],
#contact input[type="email"],
#contact input[type="tel"],
#contact input[type="url"],
#contact textarea {
  width: 100%;
  border: 1px solid #ccc;
  background: #FFF;
  margin: 0 0 5px;
  padding: 10px;
}

#contact input[type="text"]:hover,
#contact input[type="email"]:hover,
#contact input[type="tel"]:hover,
#contact input[type="url"]:hover,
#contact textarea:hover {
  -webkit-transition: border-color 0.3s ease-in-out;
  -moz-transition: border-color 0.3s ease-in-out;
  transition: border-color 0.3s ease-in-out;
  border: 1px solid #aaa;
}

#contact textarea {
  height: 100px;
  max-width: 100%;
  resize: none;
}

#contact button[type="submit"] {
  cursor: pointer;
  width: 100%;
  border: none;
  background: #4CAF50;
  color: #FFF;
  margin: 0 0 5px;
  padding: 10px;
  font-size: 15px;
}

#contact button[type="submit"]:hover {
  background: #43A047;
  -webkit-transition: background 0.3s ease-in-out;
  -moz-transition: background 0.3s ease-in-out;
  transition: background-color 0.3s ease-in-out;
}

#contact button[type="submit"]:active {
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
}

.copyright {
  text-align: center;
}

#contact input:focus,
#contact textarea:focus {
  outline: 0;
  border: 1px solid #aaa;
}

::-webkit-input-placeholder {
  color: #888;
}

:-moz-placeholder {
  color: #888;
}

::-moz-placeholder {
  color: #888;
}

:-ms-input-placeholder {
  color: #888;
}

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>

  
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Fundstarter</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/user/${username}">Dashboard</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${user.username} <span class="caret"></span></a>
        <ul class="dropdown-menu">
           <li>
                            <a href="userprofile.html"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
        </ul>
      </li>
    </ul>
  </div>
</nav>

<body>
  <div id="w">
    <div id="content" class="clearfix">
      <div id="userphoto"><img src="${pageContext.request.contextPath}/resources/images/avatar.png" alt="default avatar"></div>
      <h1>${user.username}</h1>

      <nav id="profiletabs">
        <ul class="clearfix">
          <li><a href="#Followers">Followers</a></li>
          <li><a href="#Info">Info</a></li>
          <li><a href="#Activity">Activity</a></li>
        </ul>
      </nav>

      <section id="Info">
        <p>Name: ${user.username}</p>

        <p>Hometown: Stamford</p>

        <p>Interests: Jazz, technology etc.</p>
      </section>

      <section id="Activity" class="hidden">
        <p>Most recent actions:</p>

        <p class="activity">@8:15PM - Posted a comment</p>

        <p class="activity">@12:30PM - Posted a project</p>
      </section>

      <section id="Followers" class="hidden" action="">
        <p>Followers:</p>

        <ul id="friendslist" class="clearfix">
          <li><a href="${pageContext.request.contextPath}/user/profile/lilymarshall240"><img src="images/avatar.png" width="22" height="22"> Follower1</a></li>
          <li><a href="${pageContext.request.contextPath}/user/profile/DannyRand9009"><img src="images/avatar.png" width="22" height="22"> Follower2</a></li>
          <li><a href="${pageContext.request.contextPath}/user/profile/daredevil"><img src="images/avatar.png" width="22" height="22"> Follower3</a></li>
        </ul>
      </section>

      <section id="Owned" class="hidden">
        <p>Posted the following projects:</p>

            <table>
                    <tr>

                        <th>Project ID #</th>
                        <th>Date-time posted</th>
                        <th>Description of the project</th>
                        <th>Minimum funding</th>
                    </tr>
                    <tr>
                        <a href="http://example.com">
                        <td>3319</td>
                        <td>10/21/2013</td>
                        <td>Blah blah blah</td>
                        <td>$943.45</td>
                        </a>
                    </tr>
            </table>
      </section>
    <!-- @end #content -->
  </div><!-- @end #w -->
<script type="text/javascript">
$(function(){
  $('#profiletabs ul li a').on('click', function(e){
    e.preventDefault();
    var newcontent = $(this).attr('href');

    $('#profiletabs ul li a').removeClass('sel');
    $(this).addClass('sel');

    $('#content section').each(function(){
      if(!$(this).hasClass('hidden')) { $(this).addClass('hidden'); }
    });

    $(newcontent).removeClass('hidden');
  });
});
</script>
</body>
</html>
