import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class TryVideo {
    TryVideo(){
        JPanel videoPanel = new JPanel();
        videoPanel.setLayout(new BorderLayout());
        videoPanel.setPreferredSize(new Dimension(720, 720));

        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        videoPanel.add(mediaPlayerComponent, BorderLayout.CENTER);

        // Create a root panel and add the video panel to it
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(null); // We'll manually position our components
        rootPanel.setPreferredSize(new Dimension(1080, 720));
        videoPanel.setBounds(360, 0, videoPanel.getPreferredSize().width, videoPanel.getPreferredSize().height);
        rootPanel.add(videoPanel);

        JFrame frame = new JFrame("My Video Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(rootPanel);
        frame.pack();
        frame.setVisible(true);


        mediaPlayerComponent.mediaPlayer().video().setAspectRatio("1:1");
        mediaPlayerComponent.mediaPlayer().video().setScale(1.0f);
        mediaPlayerComponent.mediaPlayer().media().play("src/Videos/HomeScreen.mp4");
        mediaPlayerComponent.mediaPlayer().controls().setRepeat(true);
    }
    public static void main(String[] args) throws Exception {
        TryVideo frame = new TryVideo();
    }
}
