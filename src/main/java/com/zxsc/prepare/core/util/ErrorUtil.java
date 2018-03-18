package com.zxsc.prepare.core.util;

import javax.servlet.http.HttpSession;

public class ErrorUtil {
    public static Error pickFromSession(HttpSession session) {
        Object error = session.getAttribute(Key.ERROR);
        session.setAttribute(Key.ERROR, null);
        return error instanceof Error ? (Error) error : null;
    }
}
