package org.ncibi.hibernate;

import org.hibernate.Session;
import org.ncibi.commons.exception.ConstructorCalledError;

/**
 * Utility functions for performing hibernate queries within a session and transaction context.
 * 
 * @author gtarcea
 * 
 */
public final class Sessions
{
    /**
     * Constructor. Utility class - should never be called.
     */
    private Sessions()
    {
        throw new ConstructorCalledError(this.getClass());
    }

    /**
     * Performs the hibernate query using the given session but wraps it in a transaction. Closes
     * out the session if autoClose is set to true.
     * 
     * @param <T>
     *            The type of object returned.
     * @param session
     *            The session to use.
     * @param autoClose
     *            If true then closes the session when done.
     * @param sessionFunction
     *            The session query to run.
     * @return The results from the SessionFunction.
     */
    public static <T> T withSession(final Session session, final boolean autoClose,
                final SessionFunction<T> sessionFunction)
    {
        T value = null;
        boolean closeBecauseError = false;
        try
        {
        	
            session.beginTransaction();
            value = sessionFunction.apply(session);
            session.getTransaction().commit();
    		session.flush();
        }
        catch (Exception e)
        {
        	closeBecauseError = true;
            e.printStackTrace();
            try {
            	
            	session.getTransaction().rollback();
            }
            catch (Throwable t) {
            	t.printStackTrace();
            	throw new IllegalStateException(t);
            }
            throw new IllegalStateException(e);
        }
        finally
        {
            if (autoClose || closeBecauseError)
            {
            	try {
            		
            		session.close();
            	}
            	catch (Throwable t) {
                	t.printStackTrace();
                	throw new IllegalStateException(t);
            	}
            }
        }

        return value;
    }

    public static void withSession(final Session session, final boolean autoClose,
                final SessionProcedure sessionProcedure)
    {
        boolean closeBecauseError = false;
        try
        {
        	
            session.beginTransaction();
            sessionProcedure.apply(session);
            session.getTransaction().commit();
            session.flush();
        }
        catch (Exception e)
        {
        	closeBecauseError = true;
            e.printStackTrace();
            try {
            	
            	session.getTransaction().rollback();
            }
            catch (Throwable t) {
            	t.printStackTrace();
            	throw new IllegalStateException(t);
            }
            throw new IllegalStateException(e);
        }
        finally
        {
            if (autoClose || closeBecauseError)
            {
            	try {
            		
            		session.close();
            	}
            	catch (Throwable t) {
                	t.printStackTrace();
                	throw new IllegalStateException(t);
            	}
            }
        }
    }

    /**
     * Performs the hibernate query using the given session but wraps it in a transaction. Does not
     * close out the session.
     * 
     * @param <T>
     *            The type of object returned.
     * @param session
     *            The session to use.
     * @param sessionFunction
     *            The session query to run.
     * @return The results from the SessionFunction.
     */
    public static <T> T withSession(final Session session, final SessionFunction<T> sessionFunction)
    {
        return withSession(session, false, sessionFunction);
    }

    public static void withSession(final Session session, final SessionProcedure sessionProcedure)
    {
        withSession(session, false, sessionProcedure);
    }
}
