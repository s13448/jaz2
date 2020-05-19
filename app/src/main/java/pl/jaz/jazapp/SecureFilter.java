package pl.jaz.jazapp;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class SecureFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (isUserAuthenticated() || isSiteAllowed(req) || isResourceReq(req)) {
            chain.doFilter(req, res);
        }
    }

    private boolean isUserAuthenticated() {
        return true;
    }

    private boolean isSiteAllowed(HttpServletRequest req) {
        return true;
    }

    private boolean isResourceReq(HttpServletRequest req) {
        return "/login.xhtml".equals(req.getServletPath())
                || "register.xhtml".equals(req.getServletPath());
    }
}
