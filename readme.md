# Summary

This web application provides access to contact information of co-workers.

It supports REST API and web interface.

# Libraries

This application is based on [Spring][framework:spring] framework.

[Hibernate][library:hibernate] and [Spring JPA][library:spring-jpa] are used to access data from DB.
[Thymeleaf][library:thymeleaf] and [Bootstrap][framework:bootstrap] are used for web interface.

[framework:spring]: http://www.springsource.org/

[library:hibernate]: http://www.hibernate.org/
[library:spring-jpa]: http://projects.spring.io/spring-data-jpa/

[framework:bootstrap]: http://getbootstrap.com/
[library:thymeleaf]: http://www.thymeleaf.org/

# Tools

To work on this project you can use: [Git][tool:git], [Maven][tool:maven], [Tomcat][tool:tomcat], [Open DJ][tool:opendj] and [MySQL][tool:mysql]

[tool:git]: http://git-scm.com/
[tool:maven]: http://maven.apache.org/
[tool:tomcat]: http://tomcat.apache.org/
[tool:opendj]: http://opendj.forgerock.org/
[tool:mysql]: http://www.mysql.com/

# REST API

REST API requires basic authentication.

`GET /coworkers` - returns list of coworkers of current user.

# License

[Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)
