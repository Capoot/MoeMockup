package moemockup.controller;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SessionListener implements HttpSessionListener {

	private static final Logger LOG = Logger.getLogger(SessionListener.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent e) {
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(e.getSession().getServletContext());
		e.getSession().setAttribute("moeApplication", ctx.getBean("moeApplication"));
		LOG.debug("Assigned application context for new session");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) { }
}
