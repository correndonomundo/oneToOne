package oneToOne;

import entity.Masina;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

import static util.HibernateUtil.closeEMF;
import static util.HibernateUtil.getEM;
import static util.HibernateUtil.readAll;

public class Update {

    public static void main(String[] args) {

        List<Masina> masini = readAll(Masina.class);

        System.out.println("Found" + masini.size() + "masini");

        for(Masina m: masini){
            System.out.println(m);
        }



        EntityManager em = getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Masina m = em.find(Masina.class, 1);
        m.setModel("xyz");
        t.commit();
        em.close();

        closeEMF();
    }
}
