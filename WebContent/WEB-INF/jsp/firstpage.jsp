<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <title>Fundstarter</title>

        <link rel="stylesheet" type="text/css" href="styles.css" />

    </head>

    <body>

    	<section id="page"> <!-- Defining the #page section with the section tag -->

            <header> <!-- Defining the header section of the page with the appropriate tag -->

                <hgroup>
                    <h1>FundStarter</h1>
                    <h3>The place where dreams come true</h3>
                </hgroup>

                <nav class="clear"> <!-- The nav link semantically marks your main site navigation -->
                    <ul>
                        <li><a href="#article1">Login</a></li>
                        <li><a href="#article2">Sign up</a></li>
                        <li><a href="#article3">About</a></li>
                    </ul>
                </nav>

            </header>

            <section id="articles"> <!-- A new section with the articles -->

				<!-- Article 1 start -->

                <div class="line"></div>  <!-- Dividing line -->

                <article id="article1"> <!-- The new article tag. The id is supplied so it can be scrolled into view. -->
                    <h3>Already Registered? LOGIN HERE</h3>

                    <div class="login-page">
                      <div class="form">
                        <form class="login-form">
                          <input type="text" placeholder="username" style="font-size:18pt;width: 150px;height:30px;"/>
                          <input type="password" placeholder="password" style="font-size:18pt;width: 150px;height:30px;"/>
                          <button style="font-size:18pt;width: 150px;height:30px;">login</button>
                          <h4>New User? Click <a href="#article2">here</a> to Sign Up</h4>
                        </form>
                      </div>
                    </div>
                </article>

				<!-- Article 1 end -->
                <article id="article2">
                <div id="register" class="animate form">
                            <form  action="" autocomplete="on">
                                <h3> New User? SIGN UP HERE </h3>
                                <p>
                                    <input style="font-size:18pt;" id="fnamesignup" name="fnamesignup" required="required" type="text" placeholder="First name" />
                                    <input style="font-size:18pt;" id="lnamesignup" name="lnamesignup" required="required" type="text" placeholder="Last name" />
                                    <input style="font-size:18pt;" id="hometownsignup" name="hometownsignup" required="required" type="text" placeholder="Hometown" />
                                </p>
                                <p><select style="font-size:18pt;">
                                    <option value="States">State</option>
                                    <option value="AL">Alabama</option>
                                    <option value="AK">Alaska</option>
                                    <option value="AZ">Arizona</option>
                                    <option value="AR">Arkansas</option>
                                    <option value="CA">California</option>
                                    <option value="CO">Colorado</option>
                                    <option value="CT">Connecticut</option>
                                    <option value="DE">Delaware</option>
                                    <option value="DC">District Of Columbia</option>
                                    <option value="FL">Florida</option>
                                    <option value="GA">Georgia</option>
                                    <option value="HI">Hawaii</option>
                                    <option value="ID">Idaho</option>
                                    <option value="IL">Illinois</option>
                                    <option value="IN">Indiana</option>
                                    <option value="IA">Iowa</option>
                                    <option value="KS">Kansas</option>
                                    <option value="KY">Kentucky</option>
                                    <option value="LA">Louisiana</option>
                                    <option value="ME">Maine</option>
                                    <option value="MD">Maryland</option>
                                    <option value="MA">Massachusetts</option>
                                    <option value="MI">Michigan</option>
                                    <option value="MN">Minnesota</option>
                                    <option value="MS">Mississippi</option>
                                    <option value="MO">Missouri</option>
                                    <option value="MT">Montana</option>
                                    <option value="NE">Nebraska</option>
                                    <option value="NV">Nevada</option>
                                    <option value="NH">New Hampshire</option>
                                    <option value="NJ">New Jersey</option>
                                    <option value="NM">New Mexico</option>
                                    <option value="NY">New York</option>
                                    <option value="NC">North Carolina</option>
                                    <option value="ND">North Dakota</option>
                                    <option value="OH">Ohio</option>
                                    <option value="OK">Oklahoma</option>
                                    <option value="OR">Oregon</option>
                                    <option value="PA">Pennsylvania</option>
                                    <option value="RI">Rhode Island</option>
                                    <option value="SC">South Carolina</option>
                                    <option value="SD">South Dakota</option>
                                    <option value="TN">Tennessee</option>
                                    <option value="TX">Texas</option>
                                    <option value="UT">Utah</option>
                                    <option value="VT">Vermont</option>
                                    <option value="VA">Virginia</option>
                                    <option value="WA">Washington</option>
                                    <option value="WV">West Virginia</option>
                                    <option value="WI">Wisconsin</option>
                                    <option value="WY">Wyoming</option>
                                    </select>
                                    <input style="font-size:18pt;" id="citysignup" name="citysignup" required="required" type="text" placeholder="City" />
                                    <input style="font-size:18pt;" id="zipsignup" name="zipsignup" required="required" type="text" placeholder="Zip" />
                                </p>
                                <p>
                                    <label style="font-size:18pt;" for="interestsignup" class="interests" data-icon="u">Interests</label>
                                    <input style="font-size:18pt;" id="interestsignup" name="interestsignup" required="required" type="text" placeholder="Ex: Jazz, Technology, etc" />
                                </p>
                                <p>
                                    <label style="font-size:18pt;" for="cardnumbersignup" class="cardnumber" data-icon="u">Cardnumber</label>
                                    <input style="font-size:18pt;" id="cardnumbersignup" name="cardnumbersignup" required="required" type="text" placeholder="Credit Card Number" />
                                </p>
                                <p>
                                    <label style="font-size:18pt;" for="usernamesignup" class="uname" data-icon="u">Your username</label>
                                    <input style="font-size:18pt;" id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="mysuperusername690" />
                                </p>
                                <p>
                                    <label style="font-size:18pt;" for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                                    <input style="font-size:18pt;" id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p>
                                    <label style="font-size:18pt;" for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                                    <input style="font-size:18pt;" id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p class="signin button">
                                    <input style="font-size:18pt;width: 150px;height:30px;" type="submit" value="Sign up"/>
                                </p>
                                <h4 class="change_link">
                                    Already a member ?
                                    <a href="#article1" class="to_register"> Log in </a>
                                </h4>
                            </form>
                        </div>
                      </article>

				<!-- Article 2 start -->

                <div class="line"></div>

                <article id="article3">
                    <h2>About us</h2>

                    <div class="line"></div>

                    <div class="articleBody clear">
                    	<figure>
	                    	<a><img src="aboutus.png" width="620" height="340" /></a>
                        </figure>
                        <p style ="font-size:18pt;">Fundstarter is a corporation based in Brooklyn, New York, that maintains a global crowdfunding platform focused on creativity. The company's stated mission is to "help bring creative projects to life". People who back Fundstarter projects are offered tangible rewards and/or experiences in exchange for their pledges.</p>
                    </div>
                </article>

				<!-- Article 2 end -->


            </section>

        <footer> <!-- Marking the footer section -->

           <div class="line"></div>

           <p>Copyright - fundstarter.com</p> <!-- Change the copyright notice -->

        </footer>

		</section> <!-- Closing the #page section -->
</html>
