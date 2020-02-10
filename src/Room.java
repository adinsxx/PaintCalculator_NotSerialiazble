
import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable, Paintable {

    private ArrayList<Wall> wallList;
    //Add a static int called roomCount to the Room
    //Also add a (non-static) int called roomNum
    public static int roomCount=0;
    private int roomNum;


    public Room(double length, double width, double height) throws BadWidthException, BadHeightException {
        //In Room's constructor, increment roomCount,
        //then set the value of roomNum to the updated
        //value of roomCount.
        roomCount++;
        roomNum = roomCount;
        wallList = new ArrayList<Wall>();

        Wall wallA = new Wall(length, height);
        wallList.add(wallA);
        Wall wallB = new Wall(length, height);
        wallList.add(wallB);
        Wall wallC = new Wall(width, height);
        wallList.add(wallC);
        Wall wallD = new Wall(width, height);
        wallList.add(wallD);


    }

    public double getArea() {
        double area = 0;

        for (int i = 0; i < wallList.size(); i++) {
            Wall w = wallList.get(i);
            area += w.getArea();
        }

        return area;
    }
    //Create (or modify) the toString() method in Room
    //to return the roomNum and the calculated area
    @Override
    public String toString() {
        return "Room #" + roomNum + " of "  + roomCount + " {" +
                "wallList=" + wallList +
                '}';
    }
    //Add getter to get room number
    public int getRoomNum() {
        return roomNum;
    }

    @Override
    public double getPremiumPaintCostPerGallon() {
        return (getArea() / 350) * PREMIUM_PAINT_COST_PER_GALLON;
    }

    @Override
    public double getStandardPaintCostPerGallon() {
        return (getArea() / 350) * STANDARD_PAINT_COST_PER_GALLON;
    }
}
