//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.Serializable;
import java.util.prefs.Preferences;

public class ShoeSize implements Serializable {
    private static final String SHOESIZEENAME = "SHOESIZE";
    public static final int SHOESIZEMAX = 15;
    public static final int SHOESIZEMIN = 3;
    static final String FILENAME = "shoesize.xml";
    private Integer shoesize = null;
    static Preferences prefs;

    public ShoeSize() {
    }

    public String show() {
        return this.shoesize == null ? "" : this.shoesize.toString();
    }

    public boolean set(Integer v) {
        if (v != null && (v < 3 || v > 15)) {
            this.shoesize = null;
            this.save();
            return false;
        } else {
            this.shoesize = v;
            this.save();
            return true;
        }
    }

    static ShoeSize load() {
        ShoeSize size = new ShoeSize();
        prefs = Preferences.userNodeForPackage(ShoeSize.class);
        size.shoesize = prefs.getInt("ShoeSize", 5);
        return size;
    }

    void save() {
        if (this.shoesize != null) {
            ShoeSize data = new ShoeSize();
            prefs.putInt("ShoeSize", this.shoesize);
        }

    }
}
