package com.zxsc.prepare.core.authority;

import com.zxsc.prepare.core.util.Key;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AuthorityFilter extends OncePerRequestFilter {

    private Set<String> skipPaths = new HashSet<>();
    private List<String> skipPrefixes = new LinkedList<>();
    private String loginPage;
    private Log logger = LogFactory.getLog(this.getClass());

    public void setSkipUrl(String skipUrl) {
        String[] paths = skipUrl.split("\n");
        for (String path : paths) {
            path = path.trim();
            if (path.endsWith("/*")) {
                skipPrefixes.add(path.substring(0, path.length() - 1));
            } else {
                skipPaths.add(path);
            }
        }
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = getServletContext().getContextPath() + loginPage;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {
        String path = request.getServletPath();
        logger.debug("AuthorityFilter is testing authority for [" + path + "]");
        if (request.getSession().getAttribute(Key.USER) != null) {
            logger.debug("Already authorized for [" + path + "]");
            chain.doFilter(request, response);
        } else if (matchSkipPath(path) || matchSkipPrefix(path)) {
            chain.doFilter(request, response);
        } else {
            logger.debug("Did not find skip rule for [" + path + "]");
            logger.debug("Redirecting to login page [" + loginPage + "]");
            response.sendRedirect(loginPage);
        }
    }

    private boolean matchSkipPath(String path) {
        if (skipPaths.contains(path)) {
            logger.debug("Found a skip rule [skip path] for [" + path + "]");
            return true;
        }
        return false;
    }

    private boolean matchSkipPrefix(String path) {
        for (String prefix : skipPrefixes) {
            if (path.startsWith(prefix)) {
                logger.debug("Found a skip rule [skip prefix] for [" + path + "]");
                return true;
            }
        }
        return false;
    }
}
