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
            BufferedReader b_reader = new BufferedReader(new FileReader("bespoke.txt"));
            String line = b_reader.readLine();
            if (line != null){
                //System.out.println(11111);
                int shoesize = Integer.parseInt(line);
                ss.shoesize = shoesize;
            }
        }catch (IOException x){
            System.err.format("IOException: %s%n", x);
        }
        return ss;
    }

    void save() {
        // add code here that will save shoe size into a file called "FILENAME"
        try{
            BufferedWriter b_writer = new BufferedWriter(new FileWriter("bespoke.txt"));
            if(shoesize != null){
                b_writer.write(shoesize.toString());
            }
            b_writer.close();
        }catch (IOException x){
            System.err.format("IOException: %s%n", x);
        }
    }
}