<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html">
<title>User Profile with Content Tabs - Design Shack Demo</title>
<meta name="author" content="Jake Rocheleau">
<link rel="shortcut icon" href="http://designshack.net/favicon.ico">
<link rel="icon" href="http://designshack.net/favicon.ico">


<style>
@import
	url(https://fonts.googleapis.com/css?family=Roboto:400,300,600,400italic)
	;

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

#category {
	width: 320px;
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

#contact input[type="text"], #contact input[type="email"], #contact input[type="tel"],
	#contact input[type="url"], #contact textarea, #contact button[type="submit"]
	{
	font: 400 12px/16px "Roboto", Helvetica, Arial, sans-serif;
}

#contact {
	background: #F9F9F9;
	padding: 25px;
	margin: 150px 0;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
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

#contact input[type="text"], #contact input[type="email"], #contact input[type="tel"],
	#contact input[type="url"], #contact textarea {
	width: 100%;
	border: 1px solid #ccc;
	background: #FFF;
	margin: 0 0 5px;
	padding: 10px;
}

#contact input[type="text"]:hover, #contact input[type="email"]:hover,
	#contact input[type="tel"]:hover, #contact input[type="url"]:hover,
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

#contact input:focus, #contact textarea:focus {
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
</style>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Fundstarter</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Dashboard</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">${user.username}<span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="userprofile.html"><i class="fa fa-fw fa-user"></i>
							Profile</a></li>
					<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
					</li>
					<li class="divider"></li>
					<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log
							Out</a></li>
				</ul></li>
		</ul>
	</div>
</nav>

<body>

	<div class="container">
		<form:form id="contact" action="project/save" method="post"
			modelAttribute="user">
			<h3>Post your own project!</h3>
			<h4>Please fill in all the details</h4>
			<fieldset>
				<form:input placeholder="Your username" type="text" path="owner"
					tabindex="1" required autofocus />
			</>
			<fieldset>
				<form:select name="category" path="pcategory" id="category"
					style="font-size:15pt" />
				<option value="cat0">Project category</option>
				<option value="cat1">Jazz</option>
				<option value="cat2">Pop</option>
				<option value="cat3">Advertising</option>
				<option value="cat4">Politics</option>
				<option value="cat5">Theatre</option>
				<option value="cat6">Films</option>
				<option value="cat7">Biology</option>
				<option value="cat8">Computer Science</option>
				</form:select>
			</fieldset>
			<fieldset>
				<form:input placeholder="Project description" path="pdesc"
					type="email" name="pdesc" tabindex="2" required />
			</fieldset>
			<fieldset>
				<form:input placeholder="Minimum funding required" path="minfund"
					type="tel" tabindex="3" required />
			</fieldset>
			<fieldset>
				<form:input placeholder="Maximum funding" path="maxfund" type="url"
					tabindex="4" required />
			</fieldset>
			<fieldset>
				<form:input placeholder="End of Campaign date" path="enddate"
					type="url" tabindex="4" required />
			</fieldset>
			<!--fieldset>
      <textarea placeholder="Type your message here...." tabindex="5" required></textarea>
    </fieldset-->
			<fieldset>
				<input name="submit" type="submit" id="contact-submit"
					data-submit="...Sending">Submit</input>
			</fieldset>
		</form:form>
	</div>