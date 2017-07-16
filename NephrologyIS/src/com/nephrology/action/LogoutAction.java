package com.nephrology.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
	
	/**
	 * LogoutAction.java
	 * Purpose: Invalidates users session.
	 *
	 * @author Venkatesh Prasad D
	 * @version 1.0 6/18/2017
	 */
public class LogoutAction implements SessionAware{

	private SessionMap<String,Object> sessionMap ;
	
	/**
	 * If session is present then invalidate
	 *
	 * @return String.
	 */
	public String logout(){		
		if(sessionMap != null){ // checking whether session is present
			System.out.println("session invalidated");
			sessionMap.invalidate();
			}
			return "success";
		}
	/**
	 * Getters and setters for session 
	 */
@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap)map;
	// TODO Auto-generated method stub	
		}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
		}

}
