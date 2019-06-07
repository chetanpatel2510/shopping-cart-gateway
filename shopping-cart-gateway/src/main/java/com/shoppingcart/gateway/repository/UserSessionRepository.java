/**
 * 
 */
package com.shoppingcart.gateway.repository;

import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Component;

/**
 * @author root
 *
 */
@Component
public class UserSessionRepository implements SessionRepository<Session> {

	/* (non-Javadoc)
	 * @see org.springframework.session.SessionRepository#createSession()
	 */
	@Override
	public Session createSession() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.session.SessionRepository#delete(java.lang.String)
	 */
	@Override
	public void delete(String arg0) {
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.session.SessionRepository#getSession(java.lang.String)
	 */
	@Override
	public Session getSession(String arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.session.SessionRepository#save(org.springframework.session.Session)
	 */
	@Override
	public void save(Session arg0) {
		
	}

}
