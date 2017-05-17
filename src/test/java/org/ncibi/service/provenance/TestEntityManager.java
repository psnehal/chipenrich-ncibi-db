package org.ncibi.service.provenance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Test;


public class TestEntityManager
{
    @Test
    public void testEM()
    {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("metdb");
        final EntityManager entityManager = emf.createEntityManager();
        Assert.assertNotNull(entityManager);
    }
}
