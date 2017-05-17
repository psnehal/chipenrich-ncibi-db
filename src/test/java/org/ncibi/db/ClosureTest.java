package org.ncibi.db;

import org.junit.Test;

public class ClosureTest
{
    @Test
    public void testClosure()
    {
//        List<Provenance> provList = (List<Provenance>) DB.provenance().withSession(new Closure(this) {
//           public Object call(Object session)
//           {
//               Session s = (Session) session;
//               return s.createQuery("from Provenance").list();
//           }
//        });
        
        //System.out.println(provList.size());
    }
}
