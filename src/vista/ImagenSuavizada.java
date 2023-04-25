package vista;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.Icon;


public class ImagenSuavizada implements Icon {
	
    private Icon icono;

    
    public ImagenSuavizada(Icon icon) {
        this.icono = icon;
    }

    
    public int getIconWidth() {
        return icono.getIconWidth();
    }

    
    public int getIconHeight() {
        return icono.getIconHeight();
    }

    
    public void paintIcon(Component c, Graphics g, int x, int y) {
    	Graphics2D g2d = (Graphics2D)g.create();
        AffineTransform at = g2d.getTransform();

        int scaleX = (int)(x * at.getScaleX());
        int scaleY = (int)(y * at.getScaleY());

        int offsetX = (int)(icono.getIconWidth() * (at.getScaleX() - 1) / 2);
        int offsetY = (int)(icono.getIconHeight() * (at.getScaleY() - 1) / 2);

        int locationX = scaleX + offsetX;
        int locationY = scaleY + offsetY;

        AffineTransform escala = AffineTransform.getScaleInstance(1.0 / at.getScaleX(), 1.0 / at.getScaleY());
        at.concatenate(escala);
        g2d.setTransform(at);
        icono.paintIcon(c, g2d, locationX, locationY);
        g2d.dispose();
    }

}
