//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ShoeSizeGUI {
    private static final int SHOESIZETEXTFIELDWIDTH = 5;
    JFrame jframe = new JFrame("Shoe Size");
    JPanel mainpanel;
    JTextField sizejtextfield;
    ShoeSize shoesize = ShoeSize.load();

    public ShoeSizeGUI() {
        this.jframe.setDefaultCloseOperation(3);
        this.mainpanel = new JPanel();
        this.mainpanel.add(new JLabel("Shoe Size:"));
        this.sizejtextfield = new JTextField(5);
        this.sizejtextfield.setText(this.shoesize.show());
        this.sizejtextfield.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {
                this.update();
            }

            public void insertUpdate(DocumentEvent documentEvent) {
                this.update();
            }

            public void removeUpdate(DocumentEvent documentEvent) {
                this.update();
            }

            private void update() {
                try {
                    if (ShoeSizeGUI.this.shoesize.set(Integer.parseInt(ShoeSizeGUI.this.sizejtextfield.getText()))) {
                        ShoeSizeGUI.this.sizejtextfield.setBackground(Color.white);
                    } else {
                        ShoeSizeGUI.this.sizejtextfield.setBackground(Color.red);
                    }
                } catch (NumberFormatException var2) {
                    ShoeSizeGUI.this.shoesize.set((Integer)null);
                    ShoeSizeGUI.this.sizejtextfield.setBackground(Color.red);
                }

            }
        });
        this.mainpanel.add(this.sizejtextfield);
        this.jframe.getContentPane().add(this.mainpanel);
        this.jframe.pack();
        this.jframe.setVisible(true);
    }

    public static void main(String[] args) {
        new ShoeSizeGUI();
    }
}
