package dumm;

import lombok.Data;

@Data
public class Emp {
    private String name;
    private Double rate;

    public Emp(String name, Double rate) {
        this.name = name;
        this.rate = rate;
    }
}
