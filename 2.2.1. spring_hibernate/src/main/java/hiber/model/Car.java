package hiber.model;

import javax.persistence.*;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String model;
    @Column
    private Integer series;

    public Car() {

    }

    public Car(String model, Integer series) {
        this.model = model;
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car " +
                "series=" + series +
                ", model='" + model + '\'';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}