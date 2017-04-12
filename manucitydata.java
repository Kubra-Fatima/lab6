import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Created by nashm on 29/03/2017.
 */
public class manucitydata {
    private static SessionFactory factory;

    manucitydata(){
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public int addEntry(int id, String co, String re, String ci, String lat, String lon){
        Session session = factory.openSession();
        Transaction tx = null;
        int id1=0;
        try{
            tx = session.beginTransaction();
            citydata al = new citydata(id, co, re, ci, lat, lon);
            id1 = (Integer) session.save(al);
            tx.commit();
        }
        catch(HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return id1;
    }




}
