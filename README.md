# A Jersey boilerplate
Using Jersey framework, this boilerplate can be a good starting point for a web application, JAX-RS RESTful web service or a mixture of both.

Also ready for testing from day zero using:
 - JUnit
 - Jetty as Gradle Plugin

Although Jetty is used for running server instance for tests, the final `war` file produced can be potentially deployed to any Java Servlet container environment.

Servlet is configured by `src/webapp/WEB-INF/web.xml` (the classic way).

## How to use
 - obviously, check out repo
 - rename packages under `src/main/java/` as necessary
 - update values in `src/webapp/WEB-INF/web.xml`
 - write tests and integration tests in test package, all tests with `IntegrationTest` are run as integration tests while server is running on `localhost:8080/`
 - write code in web app package to pass the tests


*NOTE* in order to run integration tests, you need both ports 8080 & 8081 free. If it is not possible, change both the
settings in `build.gradle` and URLs in tests.