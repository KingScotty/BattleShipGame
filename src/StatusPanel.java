import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {
    private MissileTracker missileTracker;
    private JLabel missLabel;
    private JLabel strikeLabel;
   //probably not needed
    // private JLabel hitLabel;
    private JLabel totalMissLabel;
    private JLabel totalHitLabel;

    public StatusPanel(MissileTracker missileTracker){
        this.missileTracker = missileTracker;

        setLayout(new GridLayout(1, 4));//subject to change

        missLabel = new JLabel("Misses: 0");
        strikeLabel = new JLabel("Strikes: 0");
     //   hitLabel = new JLabel("Hits: 0");
        totalMissLabel = new JLabel("Total Misses: 0");
        totalHitLabel = new JLabel("Total Hits: 0");

        add(missLabel);
        add(strikeLabel);
        // add(hitLabel);
        add(totalMissLabel);
        add(totalHitLabel);
    }

    public void update() {
        missLabel.setText("Misses: " + missileTracker.getMissCounter());
        strikeLabel.setText("Strikes: " + missileTracker.getStrikeCounter());
        //  hitLabel.setText("Hits: " + missileTracker.getHitCounter());
        totalMissLabel.setText("Total Misses: " + missileTracker.getTotalMissCounter());
        totalHitLabel.setText("Total Hits: " + missileTracker.getTotalHitCounter());

    }



}
