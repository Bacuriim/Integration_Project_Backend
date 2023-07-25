package connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateConnection {

    public static SessionFactory sessionFactory;

    public static SessionFactory buildSessionFactory() {

        if(sessionFactory == null){
            try {
                return new Configuration().configure().buildSessionFactory();
            }
            catch (Throwable ex) {

                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }else {
            return getSessionFactory();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}