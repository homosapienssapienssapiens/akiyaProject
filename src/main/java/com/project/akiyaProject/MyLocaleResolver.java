package com.project.akiyaProject;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.LocaleResolver;

public class MyLocaleResolver implements LocaleResolver {

    private Locale defaultLocale;

    public MyLocaleResolver() {
        this.defaultLocale = Locale.JAPAN;
    }

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        if (lang != null) {
            switch (lang) {
                case "ja":
                    return Locale.JAPAN;
                case "ko":
                    return Locale.KOREAN;
                case "zh":
                    return Locale.CHINESE;
                default:
                    break;
            }
        }
        return this.defaultLocale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        throw new UnsupportedOperationException("Cannot change fixed locale - use a different locale resolution strategy");
    }

    public Locale getDefaultLocale() {
        return this.defaultLocale;
    }

    public void setDefaultLocale(Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }
}
