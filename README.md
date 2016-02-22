# A Jersey boilerplate
Using Jersey framework, this boilerplate can be a good starting point for a web application serving pre-rendered HTML, JAX-RS RESTful web service or a mixture of both.

Rendering HTML is handled by excellent Handlebars templates. Serving JSON is as easy as returning POJOs from resource handlers.

Servlet is configured by `src/webapp/WEB-INF/web.xml` (the classic way).

Although Jetty is used for running server instance for tests, the final `war` file produced can be potentially deployed to any Java Servlet container environment.

The functionality is also ready for testing from day zero using:
 - JUnit
 - Jetty as Gradle Plugin

Two categories of tests are considered, unit tests (run by task `test`) and integration tests (run by task `integrationTest`). In best practice of testing, unit tests are considered a fast independent tests where no external resource (DB, server, application container, ...) is needed.

## How to use
 - obviously, clone/fork this repo
 - rename/add packages under `src/main/java/` as needed
 - update/add values in `src/webapp/WEB-INF/web.xml` as needed
 - write unit and integration tests in test package
 - add functionality in your servlet classes to serve JSON or HTML
 - add Handlebars templates in `resources/web/ui` if needed

## Gradle tasks
Aside from normal Gradle tasks following additional ones are also provided:

### `serveDemo`
Serves application on `http://localhost:8080/`.

### `integrationTest`
Runs integration tests. All tests under package names ending with `.IntegrationTest` are run as integration tests while server is running on `http://localhost:8080/`.

*NOTE* in order to run integration tests, you need both ports 8080 & 8081 free. If it is not possible, change both the settings in `build.gradle` and URLs in tests.

## Credits and further reading
[Jersey](https://jersey.java.net) version 2.x is used as application framework integrated with [Jackson](https://github.com/FasterXML/jackson) for serving and accepting JSON.

[Jetty](http://www.eclipse.org/jetty/) is used as application container for serving demo version and integration tests.

[Hanldebars.java](https://github.com/jknack/handlebars.java) is used for rendering templates to HTML. Take a look there if you need more details for tuning template functionality.

Basic idea of this code comes from [ziroby/jetty-gradle-hello-world](https://github.com/ziroby/jetty-gradle-hello-world) however it has evolved and gone in a different direction with the time.

## License
This code is licensed under [MIT License](https://opensource.org/licenses/MIT).