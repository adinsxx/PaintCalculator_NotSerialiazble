import java.io.Serializable;

public class Garage implements Paintable, Serializable {
    @Override
    public double getPremiumPaintCostPerGallon() {
        return 2000;
    }

    @Override
    public double getStandardPaintCostPerGallon() {
        return 800;
    }

    @Override
    public String toString(){
        return "Garage{$ " + getPremiumPaintCostPerGallon() + "}";
    }
}
