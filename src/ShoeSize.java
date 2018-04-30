import java.io.*;

public class ShoeSize {
    private static final String SHOESIZEENAME = "SHOESIZE";
    public static final int SHOESIZEMAX = 15;
    public static final int SHOESIZEMIN = 3;

    static final String FILENAME = "shoesize.xml";

    private Integer shoesize;

    public ShoeSize() {
        shoesize = null;
    }

    public String show() {
        return (shoesize == null ? "" : shoesize.toString());
    }

    public boolean set(Integer v) {
        if (v == null || v >= ShoeSize.SHOESIZEMIN && v <= ShoeSize.SHOESIZEMAX) {
            shoesize = v;
            save();
            return true;
        } else {
            shoesize = null;
            return false;
        }
    }

    static ShoeSize load() {
        // add code here that will load shoe size from a file called "FILENAME"
        ShoeSize ss = new ShoeSize();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serializable.txt"));
            if (ois != null){
                int shoesize = (Integer) ois.readObject();
                ss.shoesize = shoesize;
                ois.close();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return ss;
    }

    void save() {
        // add code here that will save shoe size into a file called "FILENAME"
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serializable.txt"));
            if (shoesize != null){
                oos.writeObject(shoesize);
            }
            oos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}