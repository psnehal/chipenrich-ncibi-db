package org.ncibi.db;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import org.ncibi.db.metdb.Compound;
import org.ncibi.db.metdb.Reaction;
import org.ncibi.db.metdb.ReactionEquation;

public class MetdbTest
{
    @Test
    public void testCompounds()
    {
        PersistenceUnit p = new PersistenceUnit(EntityManagers.newEntityManagerFromProject("metdb"));
        
        Session s = p.session();
        
        List<Compound> compounds = p.hqlQuery(s, "from metdb.Compound where cid in ('C00001')").list();
        System.out.println("compounds size = " + compounds.size());
        Compound c = compounds.get(0);
        if (c.getReactions() == null)
        {
            System.out.println("Reactions is null");
        }
        else
        {
            System.out.println("Reactions size = " + c.getReactions().size());
        }
    }
    
    @Test
    public void testReactions() {
    	 PersistenceUnit p = new PersistenceUnit(EntityManagers.newEntityManagerFromProject("metdb"));
         
         Session s = p.session();
         
         Reaction r = p.hqlQuery(s, "from metdb.Reaction where rid in ('R00006')").single();
         for(ReactionEquation equ: r.getEquations())
        	 System.out.println(equ.getEquation());
         System.out.println("Inputs:");
         for(Compound c: r.getInputs())
        	 System.out.println(c.getCid() + " " + c.getName());
         System.out.println("Outputs:");
         for(Compound c: r.getOutputs())
        	 System.out.println(c.getCid() + " " + c.getName());
         System.out.println("Main:");
         for(Compound c: r.getMainCmpds())
        	 System.out.println(c.getCid() + " " + c.getName());
    }
}
