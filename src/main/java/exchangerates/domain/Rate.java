package exchangerates.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameRate;
    private String valueRate;

    public Rate() {}

    public Rate(String nameRate, String valueRate) {
        this.nameRate = nameRate;
        this.valueRate = valueRate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameRate() {
        return nameRate;
    }

    public void setNameRate(String nameRate) {
        this.nameRate = nameRate;
    }

    public String getValueRate() {
        return valueRate;
    }

    public void setValueRate(String valueRate) {
        this.valueRate = valueRate;
    }
}
