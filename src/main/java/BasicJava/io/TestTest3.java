package BasicJava.io;

/**
 * Created by root on 16-2-17.
 */

import java.io.*;

public class TestTest3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializeObject();
        Deserialize();
    }

    private static Test3 Deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream oi =
                new ObjectInputStream(new FileInputStream(new File("serialize.txt")));
        Test3 object = (Test3) oi.readObject();
        System.out.println("Age " + object.getAge());
        System.out.println("Deserialization Success");
        return object;
    }

    /**
     * Serialize an object is just use a outputstream to write.
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void SerializeObject() throws IOException {
        Test3 object = new Test3();
        object.setName("Jackie");
        object.setAge(25);
        object.setSex("male");
        ObjectOutputStream oo =
                new ObjectOutputStream(new FileOutputStream(new File("serialize.txt")));
        oo.writeObject(object);
        System.out.println("io Success");
        oo.close();

    }
}