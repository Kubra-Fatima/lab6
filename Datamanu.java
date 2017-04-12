import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import javax.imageio.spi.ServiceRegistry;
import javax.security.auth.login.Configuration;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Hp-pc on 4/5/2017.
 */
public class Datamanu {
    public static void main(String[] args) throws FileNotFoundException {
        //creating configuration object
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
        //creating seession factory object
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()). build();
        SessionFactory factory=cfg.buildSessionFactory(serviceRegistry);
        //creating session object
       /* Session session=factory.openSession();
        //creating transaction object
       Transaction t=session.beginTransaction();*/
        //Citiesdata[] emp=new Citiesdata[123833];
        //  emp[1].getLatitude();
        /*Scanner scanner = new Scanner(new File("/F:/syeda kubra fatima/6th Semester/SC/GeoLiteCity-Location.csv"));
        scanner.useDelimiter(",");
        for(int i=0;i<123833,scanner.hasNext();i){

            System.out.print(scanner.next()+" ");
        }
        scanner.close();*/
        /*e1.setId(115);
        e1.esetFirstNam("Fahad");
        e1.setLastName("Satti");*/
        String csvFile = "/F:/syeda kubra fatima/6th Semester/SC/GeoLiteCity-Location.csv";
        String line = "";
        String cvsSplitBy = ",";
        Citiesdata city=new Citiesdata();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            for (int j=0;j<=1;j++)
            { line = br.readLine();
            }
            for (int i=0;(line = br.readLine()) != null;i++) {
                Session session=factory.openSession();
                Transaction t=session.beginTransaction();
                int CityId=0;
                String[] data=new String[8];
                data = line.split("[,]");
                city.setid(Integer.parseInt(data[0]));
                city.setcountry(data[1]);
                city.setregion(data[2]);
                city.setcity(data[3]);
                city.setlatitude(data[5]);
                city.setlongitude(data[6]);
                CityId= (Integer) session.save(city);
                t.commit();
                session.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //persisting the object
        //transaction is commited
//        session.save(emp);
        //  t.commit();
        //session.close();
    }
}
