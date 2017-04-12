import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.List;
import java.util.Date;
import java.util.Iterator;
import org.hibernate.Transaction;

import javax.persistence.metamodel.EntityType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by nashm on 29/03/2017.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();

        String csvFile = "/F:/GeoLiteCity-Location.csv";
       manucitydata ml = new manucitydata();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String[] Line;
        String[] temp;
        try {
            Scanner scanner = new Scanner(new File("/F:/syeda kubra fatima/6th Semester/SC/GeoLiteCity-Location.csv"));
            scanner.useDelimiter(",");
            for(int i=0;i<123833;i++){

                System.out.print(scanner.next()+" ");
            }
            scanner.close();
            int lineNo = 0;
            while ((line = br.readLine()) != null){
                lineNo++;

                if(lineNo >2){
                    String[] data=new String[8];
                    data = line.split("[,]");

                        int id =Integer.parseInt(data[0]);
                        String country = data[1];
                        String region = data[2];
                        String city = data[3];
                        String lon=data[5];
                        String lat= data[6];

                        ml.addEntry(id, country, region, city,lon, lat);
                }

            }
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}