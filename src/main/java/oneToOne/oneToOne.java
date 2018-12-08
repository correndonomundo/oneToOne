package oneToOne;

import entity.Masina;
import entity.Motor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

import static util.HibernateUtil.*;

public class oneToOne {

    public static void main(String[] args) {

        Masina masina1 = new Masina();
        masina1.setModel("Corsa");
        masina1.setAnFabricatie(2010);

        Motor motor1 = new Motor();
       // motor1.setSerie();
        motor1.setCapacitate("1500");
        motor1.setCarburant("");
        motor1.setMasina(masina1);

        masina1.setMotor(motor1);

        save(masina1);

        List<Masina> masini = readAll(Masina.class);

        System.out.println("Found" + masini.size() + "masini");

        for(Masina m: masini){
            System.out.println(m);
        }

        Masina m = masini.get(0);

    }
}
