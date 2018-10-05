package logging;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.*;

/**
 * Это видоизмененный вариант программы просмотра,
 * в которой регистрируется различные события
 * @version 1.00 2018-09-29
 * @author Nikita Postnikov
 */
public class LoggingImageViewer {
    public static void main(String[] args) {
        if (System.getProperty("java.util.logging.config.class") == null
        && System.getProperty("java.util.logging.config.file") == null) {
            try {
                Logger.getLogger("logging").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("logging").addHandler(handler);
            }
            catch (IOException e) {
                Logger.getLogger("logging").log(Level.SEVERE, "Can't create log file handler, e");
            }
        }

        EventQueue.invokeLater(() -> {
            Handler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("logging").addHandler(windowHandler);
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("logging").fine("Showing frame");
            frame.setVisible(true);
        });
    }
}

/**
 * Фрейс, в котором показывается изображение
 */
class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;
    private static Logger logger = Logger.getLogger("logging");

    public ImageViewerFrame() {
        logger.entering("ImageViewerFrame", "<init>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // Установить строку меню
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListene());

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.fine("Exiting.");
                System.exit(0);
            }
        });

        // Использовать метку для обозначения изображений
        label = new JLabel();
        add(label);
        logger.entering("ImageViewerFrame", "<init>");
    }

    private class FileOpenListene implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", event);

            // Установить селектор файлов
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            // Принять все файлы с расширением .gif
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter(){
                public boolean accept (File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                public String getDescription() {
                    return "GIF Images";
                }
            });

            // Показать диалоговое окно селектора файлов
            int r = chooser.showOpenDialog(ImageViewerFrame.this);

            // если файл изображения подходит,
            // выбрать его в качестве пиктограммы для метки
            if (r == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Reading file {0}", name);
                label.setIcon(new ImageIcon(name));
            }
            else logger.fine("File open dialog canceled.");
            logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
        }
    }
}

/**
 * Обработчик для отображения протокольных записей в окне
 */
class WindowHandler extends StreamHandler {
    private JFrame frame;

    public WindowHandler(){
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setVisible(false);
        frame.setSize(200, 200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream() {
            public void write(int b) {
            } // не вызывается!
            public void write (byte[] b, int off, int len){
                output.append(new String(b, off, len));
            }
        });
    }

    public void publish (LogRecord record) {
        if (!frame.isVisible()) return;
        super.publish(record);
        flush();
    }
}