import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class roomReader {
    public static List<Paintable> readRoomFile(String fileName) {
        List<Paintable> rooms = new ArrayList<>();
        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            Object obj = null;
            try {
                // Method for deserialization of object
                while ((obj = in.readObject()) != null) {
                    rooms.add((Room) obj);
                }
            } catch (EOFException e){
                //Room constructor is referenced, but not the newly created room
                //This references the newly created rooms from the list they're generated to
                Room.roomCount = rooms.size();
            }

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException ex) {
            System.out.println("IOException is caught");
        } catch (
                ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

        return rooms;

    }
}