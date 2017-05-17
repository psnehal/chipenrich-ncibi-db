package org.ncibi.service.provenance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.ObjectUtils.Null;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.LocalDate;
import org.ncibi.commons.collections.IdentityMapper;
import org.ncibi.commons.collections.MapUtilities;
import org.ncibi.commons.lang.PreCond;
import org.ncibi.db.DB;
import org.ncibi.db.PersistenceUnit;
import org.ncibi.db.provenance.Provenance;
import org.ncibi.db.provenance.ProvenanceDate;
import org.ncibi.hibernate.SessionFunction;
import org.ncibi.hibernate.Sessions;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * Provides a set of interfaces to the Provenance data store. Allows for adding, removing and
 * updating of existing Provenance. Querying and retrieval of Provenance, and accessing the latest
 * Provenance item.
 * 
 * @author gtarcea
 */
public final class ProvenanceDataService
{
    /**
     * We use a common session for all the calls rather than opening and closing a session on each
     * call.
     */
    private final Session session;
    private static PersistenceUnit provenance;

    /**
     * Constructor. Accepts an existing session to use for all calls.
     * 
     * @param session
     */
    public ProvenanceDataService(final Session session)
    {
        PreCond.requireArg(session != null, "session != null");
        this.session = session;
    }

    /**
     * Constructor. Creates a new open session that is then used for all calls to the provenance
     * database.
     */
    public ProvenanceDataService()
    {
        session = provenance().session();
    }
    
    private static PersistenceUnit provenance()
    {
        if (provenance == null)
        {
            provenance = DB.db("prov");
        }
        
        return provenance;
    }

    /**
     * Utility function that looks for matching provenance items and returns them.
     * 
     * @param p
     *            A provenance item that might already exist in the database.
     * @return A list of matching items.
     */
    private List<Provenance> findMatch(final Provenance p)
    {
        final String hql = "" + "from prov.Provenance where source = :source and "
                + "sourceYear = :sourceYear and " + "sourceMonth = :sourceMonth and "
                + "sourceDay = :sourceDay and" + "loadYear = :loadYear and "
                + "loadMonth = :loadMonth and" + "loadDay = :loadDay ";
        final LocalDate sdate = p.getSourceDate();
        final LocalDate ldate = p.getLoadDate();
        final List<Provenance> plist = provenance().hqlQuery(session, hql).forParam(
                "sourceYear", sdate.year()).forParam("sourceMonth", sdate.monthOfYear()).forParam(
                "sourceDay", sdate.dayOfMonth()).forParam("loadYear", ldate.year()).forParam(
                "loadMonth", ldate.monthOfYear()).forParam("loadDay", ldate.dayOfMonth()).list();
        return plist;
    }

    /**
     * Creates a new provenance entry if one doesn't already exist.
     * 
     * @param source
     *            The data source.
     * @param sourceDate
     *            The data source date.
     * @param loadDate
     *            The load date for the source.
     * @param notes
     *            Additional notes.
     * @return True if created, false if a record already existed.
     */
    public boolean create(final String source, final LocalDate sourceDate,
            final LocalDate loadDate, final String notes)
    {
        final Provenance p = new Provenance();
        p.setSource(source);
        p.setSourceDate(sourceDate);
        p.setLoadDate(loadDate);
        p.setNotes(notes);

        return create(p);
    }

    /**
     * Creates a new provenance entry if one doesn't already exist. Uses today as the loadDate.
     * 
     * @param source
     *            The data source.
     * @param sourceDate
     *            The data source date.
     * @param notes
     *            Additional notes.
     * @return True if created, false if a record already existed.
     */
    public boolean create(final String source, final LocalDate sourceDate, final String notes)
    {
        return create(source, sourceDate, ProvenanceDate.today(), notes);
    }

    /**
     * Creates a new provenance entry if one doesn't already exist.
     * 
     * @param prov
     *            The provenance entry to attempt to add.
     * @return True if created, false if a record already existed.
     */
    public boolean create(final Provenance prov)
    {
        final List<Provenance> matches = findMatch(prov);

        if (matches.size() == 0)
        {
            return false;
        }

        Sessions.withSession(session, new SessionFunction<Null>()
        {
            @Override
            public Null apply(final Session session)
            {
                session.saveOrUpdate(prov);
                return null;
            }
        });

        return true;
    }

    /**
     * Utility function that executes a hibernate executeUpdate() and sets the parameters for the
     * call.
     * 
     * @param hql
     *            The hql to execute.
     * @param mapOfParameters
     *            A map where key = parameter name in hql and value is the value to set the
     *            parameter to.
     * @return The number of rows updated.
     */
    private <T> int executeUpdate(final String hql, final Map<String, T> params)
    {
        final int rows = Sessions.withSession(session, new SessionFunction<Integer>()
        {
            @Override
            public Integer apply(final Session session)
            {
                final Query query = session.createQuery(hql);
                for (final Map.Entry<String, T> entry : params.entrySet())
                {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
                return query.executeUpdate();
            }
        });
        return rows;
    }

    /**
     * Removes a provenance entry by id.
     * 
     * @param provId
     *            The id of the provenance entry to delete.
     * @return True if able to delete, false otherwise.
     */
    public boolean remove(final int provId)
    {
        final Map<String, Integer> params = ImmutableMap.of("id", provId);
        final int rows = executeUpdate("delete from prov.Provenance where id = :id", params);
        return rows != 0;
    }

    /**
     * Removes the given provenance entry.
     * 
     * @param prov
     *            The provenance entry to remove (we only care about the id).
     * @return True if able to delete, false otherwise.
     */
    public boolean remove(final Provenance prov)
    {
        return remove(prov.getId());
    }

    /**
     * Removes all provenance entries matching the given source.
     * 
     * @param source
     *            The source to remove all provenance entries for.
     * @return True if able to delete, false otherwise.
     */
    public boolean removeSource(final String source)
    {
        final Map<String, String> params = ImmutableMap.of("source", source);
        final int rows = executeUpdate("delete from prov.Provenace where source = :source", params);
        return rows != 0;
    }

    /**
     * Updates the given Provenance entry.
     * 
     * @param prov
     *            The provenance entry to update.
     * @return True if able to update, false otherwise.
     */
    public boolean update(final Provenance prov)
    {
        Sessions.withSession(session, new SessionFunction<ObjectUtils.Null>()
        {
            @Override
            public Null apply(final Session session)
            {
                session.update(prov);
                return null;
            }
        });
        return true;
    }

    /**
     * Returns all the Provenance entries for a given source.
     * 
     * @param source
     *            The source to retrieve entries for.
     * @return A list of provenance entries for the given source.
     */
    public List<Provenance> getAllFor(final String source)
    {
        final List<Provenance> plist = provenance().hqlQuery(session,
                "from prov.Provenance where source = :source").forParam("source", source).list();
        return plist;
    }

    /**
     * Get all the known sources in the provenance datastore.
     * <nl/>
     * TODO: Do this with sql rather than fooling around with maps and such.
     * 
     * @return A list of known source names.
     */
    public List<String> getSources()
    {
        final List<Provenance> plist = provenance().hqlQuery(session, "from prov.Provenance")
                .list();
        final Map<String, Provenance> sourceMap = MapUtilities.toImmutableMap(plist,
                new IdentityMapper<String, Provenance>()
                {
                    @Override
                    public String getKey(final Provenance item)
                    {
                        return item.getSource();
                    }
                });

        final List<String> sources = new ImmutableList.Builder<String>().addAll(sourceMap.keySet())
                .build();

        return sources;
    }

    /**
     * Get all the provenance entries in the data store.
     * 
     * @return A list of all provenance entries.
     */
    public List<Provenance> getAll()
    {
        return provenance().hqlQuery(session, "from prov.Provenance").list();
    }

    /**
     * Gets the latest provenance entry for a given source.
     * 
     * @param source
     *            The source to retrieve the latest provenance for.
     * @return The latest provenance entry.
     */
    public Provenance getLatestFor(final String source)
    {
        final List<Provenance> plist = provenance().hqlQuery(session,
                "from prov.Provenance where source = :source").forParam("source", source).list();
        final int lastIndex = plist.size() - 1;

        if (lastIndex != -1)
        {
            return plist.get(lastIndex);
        }
        else
        {
            return null;
        }
    }

    /**
     * Get the latest provenance entries for all sources.
     * 
     * @return A list of the latest provenance entry for each known source.
     */
    public List<Provenance> getLatest()
    {
        final Map<String, Provenance> m = new HashMap<String, Provenance>();
        final List<Provenance> plist = provenance().hqlQuery(session, "from prov.Provenance")
                .list();
        for (final Provenance p : plist)
        {
            m.put(p.getSource(), p);
        }

        final List<Provenance> sources = new ImmutableList.Builder<Provenance>().addAll(m.values())
                .build();
        return sources;
    }

    /**
     * Checks if a source is already known in the provenance data store.
     * 
     * @param source
     *            The source to check existence for.
     * @return True if the source exists, false otherwise.
     */
    public boolean sourceExists(final String source)
    {
        final int count = Sessions.withSession(session, new SessionFunction<Integer>()
        {
            @Override
            public Integer apply(final Session session)
            {
                final String query = "select count(*) from prov.Provenance p where source = :source";
                return ((Integer) session.createQuery(query).setParameter("source", source)
                        .iterate().next()).intValue();
            }
        });

        return count != 0;
    }
}
