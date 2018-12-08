package entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "motor")

public class Motor implements Serializable{

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "capacitate", unique = true )
    private String capacitate;

    @Column(name = "carburant", nullable = false)
    private String carburant;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "masina_id")
    private Masina masina;

    public int getId() {
        return id;
    }

    public void setId(int serie) {
        this.id = serie;
    }

    public String getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(String capacitate) {
        this.capacitate = capacitate;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String rpm) {
        this.carburant = rpm;
    }

    public Masina getMasina() {
        return masina;
    }

    public void setMasina(Masina masina) {
        this.masina = masina;
    }

    public Motor(){}

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Motor motor = (Motor) o;
        return id == motor.id &&
                Objects.equals(capacitate, motor.capacitate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capacitate);
    }


    @Override
    public String toString(){
        return id + " " + capacitate + " " + carburant;
    }
}
