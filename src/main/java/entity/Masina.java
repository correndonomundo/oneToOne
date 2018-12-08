package entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "masina")

public class Masina implements Serializable{

    @Id
    @Column(name = "serie", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serie;

    @Column(name = "model", unique = true )
    private String model;

    @Column(name = "an_fabricatie", nullable = false)
    private int anFabricatie;


    @OneToOne(mappedBy = "masina", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Motor motor;

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String culoare) {
        this.model = culoare;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Masina masina = (Masina) o;
        return serie == masina.serie &&
                Objects.equals(model, masina.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serie, model);
    }


    @Override
    public String toString(){
        return serie + " " + model + " " + anFabricatie;
    }
}
