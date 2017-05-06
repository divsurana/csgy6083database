create database db_project;

create table db_project.users(
username varchar(20) primary key,
fname varchar(20),
lname varchar(20),
password text,
state varchar(20),
city varchar(20),
zipcode varchar(20),
cardnumber varchar(30),
interests text,
hometown varchar(20)
);

create table db_project.category(
categoryid char(32) primary key,
categoryname text,
categorytime timestamp DEFAULT CURRENT_TIMESTAMP
);

create table db_project.project(
projectid char(32) primary key,
projectname text,
owner varchar(20),
pdesc text,
pcategory char(32),
pstatus varchar(30),
minfund int,
maxfund int,
postingdate timestamp DEFAULT CURRENT_TIMESTAMP,
enddate timestamp NULL DEFAULT NULL,
actualenddate timestamp NULL DEFAULT NULL,
completiondate timestamp NULL DEFAULT NULL,
FOREIGN KEY (owner)
    REFERENCES db_project.users(username)
    ON DELETE CASCADE,
FOREIGN KEY (pcategory)
    REFERENCES db_project.category(categoryid)
    ON DELETE CASCADE
);

create table db_project.followers(
userfollowed char(32),
userfollower char(32),
timefollowed timestamp DEFAULT CURRENT_TIMESTAMP,
primary key (userfollowed, userfollower),
FOREIGN KEY (userfollowed)
    REFERENCES db_project.users(username)
    ON DELETE CASCADE,
FOREIGN KEY (userfollower)
    REFERENCES db_project.users(username)
    ON DELETE CASCADE
);

create table db_project.pledge(
pledgeid char(32) primary key,
projectid char(32),
sponsor char(32),
amount int,
pledgetime timestamp DEFAULT CURRENT_TIMESTAMP,
transactiontime timestamp NULL DEFAULT NULL,
cardnumber varchar(30) NOT NULL,
isbilled boolean,
FOREIGN KEY (projectid)
    REFERENCES db_project.project(projectid)
    ON DELETE CASCADE,
FOREIGN KEY (sponsor)
    REFERENCES db_project.users(username)
    ON DELETE CASCADE
);

create table db_project.likes(
username char(32),
projectid char(32),
liketime timestamp DEFAULT CURRENT_TIMESTAMP,
primary key (username, projectid),
FOREIGN KEY (username)
    REFERENCES db_project.users(username)
    ON DELETE CASCADE,
FOREIGN KEY (projectid)
    REFERENCES db_project.project(projectid)
    ON DELETE CASCADE
);

create table db_project.comments(
username char(32),
projectid char(32),
content text,
media blob,
commenttime timestamp DEFAULT CURRENT_TIMESTAMP,
primary key (username, projectid, commenttime),
FOREIGN KEY (username)
    REFERENCES db_project.users(username)
    ON DELETE CASCADE,
FOREIGN KEY (projectid)
    REFERENCES db_project.project(projectid)
    ON DELETE CASCADE
);

create table db_project.ratings(
username char(32),
projectid char(32),
content text,
rating int,
ratingtime timestamp DEFAULT CURRENT_TIMESTAMP,
primary key (username, projectid),
FOREIGN KEY (username)
    REFERENCES db_project.users(username)
    ON DELETE CASCADE,
FOREIGN KEY (projectid)
    REFERENCES db_project.project(projectid)
    ON DELETE CASCADE
);