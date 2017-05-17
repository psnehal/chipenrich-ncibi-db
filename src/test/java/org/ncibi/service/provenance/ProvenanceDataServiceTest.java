package org.ncibi.service.provenance;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import org.ncibi.db.provenance.*;

public class ProvenanceDataServiceTest
{
    private ProvenanceDataService pds;
    
    public ProvenanceDataServiceTest()
    {
        
    }
    
    @Before 
    public void setUp()
    {
        pds = new ProvenanceDataService();
    }
    
    @Test
    public void testCreateAllFields()
    {
        pds.create("BIND", ProvenanceDate.today(), ProvenanceDate.today(), "Hello world");
    }
    
    @Test
    public void testCreateStringProvenanceDateString()
    {
        fail("Not yet implemented");
    }
    
    @Test
    public void testCreateProvenance()
    {
        fail("Not yet implemented");
    }
    
    @Test
    public void testRemoveInt()
    {
        fail("Not yet implemented");
    }
    
    @Test
    public void testRemoveProvenance()
    {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSourceExists(){
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetLatest(){
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetLatestFor()
    {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetAll()
    {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetSources()
    {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetAllFor()
    {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdate()
    {
        fail("Not yet implemented");
    }
    
    @Test
    public void testRemoveSource()
    {
        fail("Not yet implemented");
    }
}
