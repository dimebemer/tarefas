package br.com.listadetarefas.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object controller) throws Exception {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();

        if (uri.contains("/usuario/") ||
                uri.endsWith("tarefas/listar") ||
                    uri.endsWith(contextPath + "/") ||
                        uri.contains("resources")) {
            return true;
        }

        if (request.getSession()
                .getAttribute("USUARIO_LOGADO") != null) {
            return true;
        }

        String urlRedirect = contextPath + "/usuario/login";
        response.sendRedirect(urlRedirect);
        return false;
    }
}
