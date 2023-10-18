/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import static com.teamdev.jxbrowser.engine.RenderingMode.OFF_SCREEN;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.internal.licensing.License;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author WitherDragon
 */
public class frmWebViewTest {
    public static void main(String[] args) {
        
        Engine engine = Engine.newInstance(
        EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                .licenseKey("6P830J66YCCQFZA50FHGU7BEIWMW43Z78KSTPF04CS5EHT8GN5VU4IJAZY1ZWZLIKQ37")
                .build());
        Browser browserOne = engine.newBrowser();
        Browser browserTwo = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            JTabbedPane pane = new JTabbedPane();
            pane.addTab("Google", BrowserView.newInstance(browserOne));
            pane.addTab("TeamDev", BrowserView.newInstance(browserTwo));

            JFrame frame = new JFrame("Browser View In JTabbed Pane");
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.getContentPane().add(pane, BorderLayout.CENTER);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        browserOne.navigation().loadUrl("https://www.youtube.com/watch?v=60ItHLz5WEA");
        browserTwo.navigation().loadUrl("https://www.teamdev.com");
    }
}
