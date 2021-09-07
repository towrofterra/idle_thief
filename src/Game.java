import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Game {

    /////////////////
    // SWING STUFF //
    /////////////////
    private JTabbedPane rootPanel;
    private JLabel name;
    private JButton steal$10Button;
    private JProgressBar progressBar1;
    private JButton $100Button;
    private JLabel Generators;
    private JLabel Resources;
    private JButton steal$5Button;
    private JProgressBar progressBar2;
    private JButton stealACookieFromButton;
    private JProgressBar progressBar4;
    private JLabel youAreAPennilessLabel;
    private JButton $500Button;
    private JButton $50000Button;
    private JButton $XButton;
    private JButton $10000Button;
    private JButton $5000Button;
    private JLabel cash;

    /**
     * Handles swing window setup
     */
    public void swingSetup() {
        JFrame frame = new JFrame("Idle Thief");

        // Theming
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        frame.setContentPane(new Game().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //////////////
    //  FIELDS  //
    //////////////
    private int tick = 0;
    private Player player;

    //////////////////
    // CONSTRUCTORS //
    //////////////////
    /**
     * Convenience default constructor
     */
    public Game() {
        this.player = new Player();
    }

    /**
     * Construct a game with the given player
     */
    public Game(Player player) {
        this.player = player;
    }

    ////////////
    //  TIME  //
    ////////////

    /**
     * Moves this game 1 tick forward
     */
    public void tick() {
        this.tick++;
        player.tick();
    }

    /**
     * @return The current tick of this Game
     */
    public int getCurrTick() {
        return this.tick;
    }

    public void startTheClock() throws IllegalStateException {
        long period = 1000;
        if (this.tick != 0) {
            throw new IllegalStateException("Clock cannot be started at a non-zero value.");
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        }, 0, period);

    }

}
