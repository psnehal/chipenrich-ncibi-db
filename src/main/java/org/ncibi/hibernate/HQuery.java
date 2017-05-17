package org.ncibi.hibernate;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import static org.ncibi.hibernate.Sessions.*;

/**
 * Implements standard queries to Hibernate that wraps the calls in
 * transactions. Handles closing of sessions if specified. This enum factors out
 * common code into a single place.
 * 
 * @author gtarcea
 */
public enum HQuery
{
    /**
     * SQL based queries to Hibernate.
     */
    SQL
    {
        /**
         * Retrieve a list of objects using SQL.
         */
        @Override
        @SuppressWarnings("unchecked")
        protected <T> List<T> getListFor(final String query,
                final Class<T> cls, final ResultTransformer rt,
                final Session session)
        {
            final SQLQuery q = session.createSQLQuery(query);
            if (rt != null)
            {
                q.setResultTransformer(rt);
            }
            return q.addEntity(cls).list();
        }

        /**
         * Retrieve a single object using SQL.
         */
        @Override
        @SuppressWarnings("unchecked")
        protected <T> T getSingleFor(final String query, final Class<T> cls,
                final ResultTransformer rt, final Session session)
        {
            final SQLQuery q = session.createSQLQuery(query);
            if (rt != null)
            {
                q.setResultTransformer(rt);
            }
            return (T) q.addEntity(cls).uniqueResult();
        }

        /**
         * Retrieve the count using SQL.
         */
        @Override
        @SuppressWarnings("unchecked")
        protected int getCountFor(final String query, final Session session)
        {
            final List<Integer> l = session.createSQLQuery(query).addScalar("",
                    Hibernate.INTEGER).list();
            return l.get(0);
        }
    },

    /**
     * HQL based queries to Hibernate.
     */
    HQL
    {
        /**
         * Retrieve a list using HQL.
         */
        @Override
        @SuppressWarnings("unchecked")
        protected <T> List<T> getListFor(final String query,
                final Class<T> cls, final ResultTransformer rt,
                final Session session)
        {
            final Query q = session.createQuery(query);
            if (rt != null)
            {
                q.setResultTransformer(rt);
            }
            return q.list();
        }

        /**
         * Retrieve a single item using HQL.
         */
        @Override
        @SuppressWarnings("unchecked")
        protected <T> T getSingleFor(final String query, final Class<T> cls,
                final ResultTransformer rt, final Session session)
        {
            final Query q = session.createQuery(query);
            if (rt != null)
            {
                q.setResultTransformer(rt);
            }
            return (T) q.uniqueResult();
        }

        /**
         * Retrieve a count using HQL.
         */
        @Override
        protected int getCountFor(final String query, final Session session)
        {
            return ((Number) session.createQuery(query).uniqueResult())
                    .intValue();
        }
    },

    /**
     * Named SQL based queries to Hibernate.
     */
    NAMED
    {
        /**
         * Retrieve a list using Named SQL.
         */
        @Override
        @SuppressWarnings("unchecked")
        protected <T> List<T> getListFor(final String query,
                final Class<T> cls, final ResultTransformer rt,
                final Session session)
        {
            final Query q = session.getNamedQuery(query);
            if (rt != null)
            {
                q.setResultTransformer(rt);
            }
            return q.list();
        }

        /**
         * Retrieve a single object using Named SQL.
         */
        @Override
        @SuppressWarnings("unchecked")
        protected <T> T getSingleFor(final String query, final Class<T> cls,
                final ResultTransformer rt, final Session session)
        {
            final Query q = session.getNamedQuery(query);
            if (rt != null)
            {
                q.setResultTransformer(rt);
            }
            return (T) q.uniqueResult();
        }

        /**
         * Retrieve a count using Named SQL.
         */
        @Override
        protected int getCountFor(final String query, final Session session)
        {
            return ((Number) session.getNamedQuery(query).uniqueResult())
                    .intValue();
        }
    };

    /*
     * Each of the Enum types implements the 3 abstract methods below. These
     * implement the single, list, and count queries for Hibernate across the
     * different query types.
     */

    /**
     * A query to retrieve a count. It is assumed that this is a valid count
     * query and not a list query where the function is expected to count the
     * returned items.
     * 
     * @param query
     *            The count query to execute.
     * @param session
     *            The session to use.
     * @return The count from the query.
     */
    protected abstract int getCountFor(String query, Session session);

    /**
     * A query that returns a single match.
     * 
     * @param <T>
     *            The type of item being returned.
     * @param query
     *            The query to run.
     * @param cls
     *            The class of object. This is ignored by some Hibernate query
     *            types.
     * @param rt
     *            The result transformer when a business object is passed in and
     *            mapping from the results needs to be performed. If null this
     *            is ignored.
     * @param session
     *            The session to use.
     * @return A single match or null.
     */
    protected abstract <T> T getSingleFor(String query, Class<T> cls,
            ResultTransformer rt, Session session);

    /**
     * A query that returns a list of matches.
     * 
     * @param <T>
     *            The type of item being returned.
     * @param query
     *            The query to run.
     * @param cls
     *            The class of object. This is ignored by some Hibernate query
     *            types.
     * @param rt
     *            The result transformer when a business object is passed in and
     *            mapping from the results needs to be performed. If null this
     *            is ignored.
     * @param session
     *            The session to use.
     * @return A list of matches or an empty list if nothing matched..
     */
    protected abstract <T> List<T> getListFor(String query, Class<T> cls,
            ResultTransformer rt, Session session);

    /**
     * Runs a count query. Closes the session if autoClose is set to true.
     * 
     * @param query
     *            The query to run.
     * @param session
     *            The session to use.
     * @param autoClose
     *            If true close the session, otherwise flush it.
     * @return The count for the query.
     * @throws HibernateException
     *             if an error occurs processing the query.
     */
    public final int getCount(final String query, final Session session,
            final boolean autoClose)
    {
        SessionFunction<Integer> sfunc = new SessionFunction<Integer>()
        {
            @Override
            public Integer apply(Session session)
            {
                return getCountFor(query, session);
            }
        };

        return withSession(session, autoClose, sfunc);
    }

    /**
     * Runs a query that returns a single object.
     * 
     * @param <T>
     *            The type of object being returned.
     * @param query
     *            The query to run.
     * @param cls
     *            The class of object -- ignored by some Hibernate query types.
     * @param rt
     *            The result transformer when a business object is passed in and
     *            mapping from the results needs to be performed. If null this
     *            is ignored.
     * @param session
     *            The session to use.
     * @param autoClose
     *            If true close the session, otherwise flush it.
     * @return A single match or null if query didn't return any results.
     * @throws HibernateException
     *             if an error occurs processing the query.
     */
    public final <T> T getSingle(final String query, final Class<T> cls,
            final ResultTransformer rt, final Session session,
            final boolean autoClose)
    {
        SessionFunction<T> sfunc = new SessionFunction<T>()
        {
            @Override
            public T apply(Session session)
            {
                return getSingleFor(query, cls, rt, session);
            }
        };

        return withSession(session, autoClose, sfunc);
    }

    /**
     * Runs a query that returns a list of objects.
     * 
     * @param <T>
     *            The type of object being returned in the list.
     * @param query
     *            The query to run.
     * @param cls
     *            The class of object -- ignored by some Hibernate query types.
     * @param rt
     *            The result transformer when a business object is passed in and
     *            mapping from the results needs to be performed. If null this
     *            is ignored.
     * @param session
     *            The session to use.
     * @param autoClose
     *            If true close the session, otherwise flush it.
     * @return A list of matches (an empty list if query didn't return any
     *         results).
     * @throws HibernateException
     *             if an error occurs processing the query.
     */
    public final <T> List<T> getList(final String query, final Class<T> cls,
            final ResultTransformer rt, final Session session,
            final boolean autoClose)
    {
        SessionFunction<List<T>> sfunc = new SessionFunction<List<T>>()
        {
            @Override
            public List<T> apply(Session session)
            {
                return getListFor(query, cls, rt, session);
            }          
        };
        
        return withSession(session, autoClose, sfunc);
    }
}
