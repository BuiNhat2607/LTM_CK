/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

//import chrriis.dj.nativeswing.swtimpl.NativeInterface;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

//import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;


/**
 *
 * @author WitherDragon
 */
public class GeniusWebView {
    public void buildBroswer(String youtubeUrl){
        Engine engine = Engine.newInstance(
        EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                .licenseKey("6P830J66YCCQFZA50FHGU7BEIWMW43Z78KSTPF04CS5EHT8GN5VU4IJAZY1ZWZLIKQ37")
                .build());
        Browser browserOne = engine.newBrowser();
//        Browser browserTwo = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            JTabbedPane pane = new JTabbedPane();
            pane.addTab("Youtube", BrowserView.newInstance(browserOne));
//            pane.addTab("Spotify", BrowserView.newInstance(browserTwo));

            JFrame frame = new JFrame("View video");
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(pane, BorderLayout.CENTER);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        browserOne.navigation().loadUrl(youtubeUrl);
//        browserTwo.navigation().loadUrl(spotifyUrl);
    }
//    private JPanel getBrowserPanel(String url) {
//        JPanel webBrowserPanel = new JPanel(new BorderLayout());
//        JWebBrowser webBrowser = new JWebBrowser();
//        // Set a modern user agent string
//        webBrowser.setBarsVisible(true);
//        webBrowser.setJavascriptEnabled(true);
//
//        webBrowser.navigate(url);
//        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
//        return webBrowserPanel;
//    }
//    private void openFormWebView(){
//        NativeInterface.open();
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("YouTube Viewer");
//            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//            frame.getContentPane().add(getBrowserPanel(url), BorderLayout.CENTER);
//            frame.setSize(800, 600);
//            frame.setLocationByPlatform(true);
//            frame.setVisible(true);
//        });
//        NativeInterface.runEventPump();
//        
//        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//            @Override
//            public void run() {
//                NativeInterface.close();
//            }
//        }));
//    }
}
