package org.ncibi.service.idmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.ncibi.db.DB;
import org.ncibi.db.PersistenceUnit;
import org.ncibi.db.idmap.ProteinIdTypeMap;

/**
 * @author gtarcea
 */
class ProteinIdTypeMapService
{
    /**
     * The session to use for all service calls.
     */
    private final Session session;
    private final Map<String, String> idmapCache = new HashMap<String, String>();
    private volatile boolean mapLoaded = false;
    private static PersistenceUnit idmap;

    /**
     * Constructor. Uses the given session for all calls.
     * 
     * @param session
     *            The session to use for all calls that connect to the database.
     */
    public ProteinIdTypeMapService(final Session session)
    {
        this.session = session;
        loadIdMapCache();
    }
    
    private PersistenceUnit idmap()
    {
        if (idmap == null)
        {
            idmap = DB.db("idmap");
        }
        
        return idmap;
    }

    /**
     * Constructor. Creates a new session that is used for all calls that
     * connect to the database.
     */
    public ProteinIdTypeMapService()
    {
        session = idmap().session();
        loadIdMapCache();
    }

    /**
     * Loads the data cache. This is performed in a thread safe manner.
     */
    private void loadIdMapCache()
    {
        synchronized (this)
        {
            if (mapLoaded)
            {
                return;
            }

            final List<ProteinIdTypeMap> ids = idmap().hqlQuery(session, "from IdMap").list();

            for (final ProteinIdTypeMap id : ids)
            {
                idmapCache.put(id.getIdtype(), id.getIdtypemap());
            }

            mapLoaded = true;
        }
    }

    /**
     * Returns an idtype mapping or null if there is no value found.
     * 
     * @param idtype
     *            The idtype to look for a mapping to.
     * @return The idtype name mapping, or null if not found.
     */
    public String getIdTypeMapping(final String idtype)
    {
        final String mappedType = idmapCache.get(idtype);
        return mappedType;
    }

}
