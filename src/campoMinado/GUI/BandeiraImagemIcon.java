package campoMinado.GUI;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BandeiraImagemIcon extends ImageIcon {
    public BandeiraImagemIcon() {
        try {
            setImage(ImageIO.read(new File("bandeira.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BandeiraImagemIcon(int width, int height) {
        this();
        setImage(getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
}
