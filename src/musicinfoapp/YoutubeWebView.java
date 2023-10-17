/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicinfoapp;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author WitherDragon
 */
public class YoutubeWebView extends JFrame {

    public static void main(String[] args) {
        NativeInterface.open();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("YouTube Viewer");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.getContentPane().add(getBrowserPanel(), BorderLayout.CENTER);
                frame.setSize(800, 600);
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        });
        NativeInterface.runEventPump();
        // Don't forget to properly close native components
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                NativeInterface.close();
            }
        }));
    }

    public static JPanel getBrowserPanel() {
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        JWebBrowser webBrowser = new JWebBrowser();
        // Set a modern user agent string
        webBrowser.setBarsVisible(true);
        webBrowser.setJavascriptEnabled(true);
//        webBrowser.setMenuBarVisible(true);
        webBrowser.navigate("https://genius.com/Alan-walker-faded-lyrics");
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
        return webBrowserPanel;
    }
}
