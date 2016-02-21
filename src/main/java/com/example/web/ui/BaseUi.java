package com.example.web.ui;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Base class for all servlet resource handlers who serve a web UI.
 * This class provides some of the common functionality for rendering
 * and returning HTML in response.
 *
 * <p>This class is made with some presumptions like:
 * <ul>
 * <li>
 * each page needs a title
 * </li>
 * <li>
 * each template may have multiple additional context values
 * </li>
 * <li>
 * a bunch of specific extra handlers are required on most of
 * templates
 * </li>
 * </ul>
 *
 * <p>Templates are searched for in following directories inside
 * <code>resources/web/ui</code>:
 *
 * <ol>
 * <li><code>layouts/</code></li>
 * <li><code>partials/</code></li>
 * <li><code>templates/</code></li>
 * </ol>
 *
 * <p>All page templates shall reside inside <code>templates/</code>
 * directory. <code>layouts/</code> and <code>partials/</code> is only
 * intended for sharing template parts and code.
 * <br/>
 * <b>NOTE:</b> all layouts, partials and page templates share the
 * same namespace, so be careful not to dave duplicates. At best
 * organise your templates in subdirectories with the name of related
 * calls (maybe including package name) so that template names will
 * never conflict with layouts and partials.
 *
 * <p>Created by mohamnag on 21/02/16.
 */
public class BaseUi {
    protected static Handlebars handlebars;

    static {
        ClassPathTemplateLoader layoutsLoader = new ClassPathTemplateLoader("/web/ui/layouts");
        ClassPathTemplateLoader partialsLoader = new ClassPathTemplateLoader("/web/ui/partials");
        ClassPathTemplateLoader templatesLoader = new ClassPathTemplateLoader("/web/ui/templates");

        handlebars = new Handlebars().with(layoutsLoader, partialsLoader, templatesLoader);
    }

    /**
     * Similar to {@link #renderTemplate(String, String, java.util.Map)} but used for
     * rendering pages without any context object necessary.
     *
     * @param name      see {@link #renderTemplate(String, String, java.util.Map)}
     * @param pageTitle see {@link #renderTemplate(String, String, java.util.Map)}
     *
     * @return see {@link #renderTemplate(String, String, java.util.Map)}
     *
     * @throws IOException see {@link #renderTemplate(String, String, java.util.Map)}
     */
    static String renderTemplate(String name, String pageTitle) throws IOException {
        return renderTemplate(name, pageTitle, Collections.<String, Object>emptyMap());
    }

    /**
     * Similar to {@link #renderTemplate(String, String, java.util.Map)} but
     * meant for rendering a page template with one single object as context.
     *
     * @param name          see {@link #renderTemplate(String, String, java.util.Map)}
     * @param pageTitle     see {@link #renderTemplate(String, String, java.util.Map)}
     * @param contextName   name of context object in templates
     * @param contextObject context object itself
     *
     * @return see {@link #renderTemplate(String, String, java.util.Map)}
     *
     * @throws IOException see {@link #renderTemplate(String, String, java.util.Map)}
     */
    static String renderTemplate(String name, String pageTitle, String contextName, Object contextObject) throws IOException {
        HashMap<String, Object> pageContext = new HashMap<String, Object>();
        pageContext.put(contextName, contextObject);

        return renderTemplate(name, pageTitle, pageContext);
    }

    /**
     * The most comprehensive way to render a page templates with context.
     * Multiple context objects can be passed to template using this method.
     *
     * @param name        name of template file inside <code>templates</code> directory
     * @param pageTitle   the title of this page, passed to template as <code>page.title</code>
     * @param pageContext all the context objects that should be available for template
     *
     * @return rendered HTML of template
     *
     * @throws IOException if template is not found or not readable
     */
    static String renderTemplate(String name, String pageTitle, Map<String, Object> pageContext) throws IOException {
        Map<String, Object> values = new HashMap<String, Object>();
        values.put("page.title", pageTitle);
        values.putAll(pageContext);

        return handlebars.compile(name).apply(values);
    }
}
