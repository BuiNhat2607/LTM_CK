/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

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
public class frmGeniusWebView extends JFrame {
    private static String url;
    public frmGeniusWebView(String url){
        frmGeniusWebView.url=url;
        openFormWebView();
    }
    private JPanel getBrowserPanel(String url) {
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        JWebBrowser webBrowser = new JWebBrowser();
        // Set a modern user agent string
        webBrowser.setBarsVisible(true);
        webBrowser.setJavascriptEnabled(true);

        webBrowser.navigate(url);
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
        return webBrowserPanel;
    }
    private void openFormWebView(){
        NativeInterface.open();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("YouTube Viewer");
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(getBrowserPanel(url), BorderLayout.CENTER);
            frame.setSize(800, 600);
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        });
        NativeInterface.runEventPump();
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                NativeInterface.close();
            }
        }));
    }
}
