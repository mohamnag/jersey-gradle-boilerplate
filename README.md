# JAX-RS RESTful Web Service
Using:
 - Jersey framework

For testing:
 - JUnit
 - Hamcrest
 - Jetty Gradle Plugin

Although Jetty is used for running server instance for tests,
the final `war` file produced can be potentially deployed to
any Java Servlet container environment.

Servlet is configured by `src/webapp/WEB-INF/web.xml` (the
classic way).

## How to use
 - obviously, check out repo
 - rename packages under `src/main/java/` as necessary
 - update values in `src/webapp/WEB-INF/web.xml`
 - write tests and integration tests in test package, all tests with `IntegrationTest` are run as integration tests while server is running on `localhost:8080/`
 - write code in web app package to pass the tests