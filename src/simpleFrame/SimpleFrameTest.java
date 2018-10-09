package simpleFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.00 2018-10-08
 * @author megamupik
 */
public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new NotHelloWorldFrame();
            frame.setTitle("NotHelloWorld");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
//            frame.setLocation(100, 100);
//            frame.setUndecorated(true);
                }
        );
    }
}

/**
 * Фрейм содержащий панель сообщений
 */
class NotHelloWorldFrame extends JFrame {
    NotHelloWorldFrame () {
        add(new NotHelloWorldComponent());
        pack();
    }
}

/**
 * Компонент, выводящий сообщение
 */
class NotHelloWorldComponent extends JComponent {
    private static final int MEDDAGE_X = 75;
    private static final int MEDDAGE_Y = 100;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent (Graphics g) {
        g.drawString("UFS", MEDDAGE_X, MEDDAGE_Y);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

//    Toolkit kit = Toolkit.getDefaultToolkit();
//    Dimension screenSize = kit.getScreenSize();
//    int screenWidth = screenSize.width;
//    int screenHeight = screenSize.height;
//
//    public SimpleFrame () {
//        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//        setSize(screenWidth / 2, screenHeight / 2);
//        setLocationByPlatform(true);
//
//        Image img = new ImageIcon("icon.gif").getImage();
//        setIconImage(img);
//    }
}