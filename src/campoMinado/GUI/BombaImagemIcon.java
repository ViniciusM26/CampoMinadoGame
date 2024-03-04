package campoMinado.GUI;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BombaImagemIcon extends ImageIcon {
	
	public BombaImagemIcon() {
		
        try {
            setImage(ImageIO.read(new File("bomba.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BombaImagemIcon(int width, int height) {
    	
        this();
        setImage(getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
}
