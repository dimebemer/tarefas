package br.com.listadetarefas.filtros;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.listadetarefas.dao.ConnectionFactory;

@WebFilter("/*")
public class FiltroDBConnection implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		Connection connection = new ConnectionFactory().getConnection();
		req.setAttribute("connection", connection);

		chain.doFilter(req, res);

		try {
			connection.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
