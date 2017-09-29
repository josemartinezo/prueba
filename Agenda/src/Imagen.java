
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public class Imagen extends JComponent {

    private Image img;
    private int p;
    private File file;
    public final int ESTIRADA = 0, AJUSTADA = 1, ORIGINAL = 2;

    public Imagen() {
        setSize(50, 100);
    }

    public void cargar(File a) {
        try {
            img = ImageIO.read(a);
            file=a;
        } catch (IOException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }

    public void setIcon(Icon i) {
        if (i != null) {
            JComponent j = new JPanel();
            j.setSize(i.getIconWidth(), i.getIconHeight());
            img = new BufferedImage(j.getWidth(), j.getHeight(), BufferedImage.TYPE_INT_ARGB);
            i.paintIcon(j, img.getGraphics(), 0, 0);
        } else {
            img = null;
        }
        repaint();
    }

    public void setProporcion(int p) {
        if (p >= 0 && p <= 2) {
            this.p = p;
        } else {
            this.p = 0;
        }
    }

    public File getFile() {
        return file;
    }

    @Override
    public void paint(Graphics g) {
        if (img != null) {
            switch (p) {
                case 0:
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                    break;
                case 1:
                    Point res = getAjuste();
                    g.drawImage(img, 0, 0, res.x, res.y, this);
                    break;
                case 2:
                    g.drawImage(img, 0, 0, img.getWidth(null), img.getHeight(null), this);
                    break;
            }
        }
        super.paint(g);
    }

    private Point getAjuste() {
        double x, y;
        x = img.getWidth(null);
        y = img.getHeight(null);
        if (x <= getWidth() && y <= getHeight()) {
            while (x <= getWidth() && y <= getHeight()) {
                x += x * 0.1;
                y += x * 0.1;
            }
        } else {
            while (x > getWidth() && y > getHeight()) {
                x -= x * 0.1;
                y -= x * 0.1;
            }
        }
        return new Point((int) x, (int) y);
    }
}
