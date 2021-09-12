import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Game implements ActionListener {
    //////////////
    //  FIELDS  //
    //////////////
    private int tick = 0;
    private Player player;

    public enum RESOURCE_TYPES {
        CASH
    };

    /////////////////
    // SWING STUFF //
    /////////////////
    private JTabbedPane rootPanel;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar progressBar4;
    private JButton $100Button;
    private JButton stealACookieFromButton;
    private JButton steal$5Button;
    private JButton steal$10Button;
    private JButton $500Button;
    private JButton $50000Button;
    private JButton $XButton;
    private JButton $10000Button;
    private JButton $5000Button;
    private JLabel name;
    private JLabel cash_text;
    private JLabel Resources;
    private JLabel youAreAPennilessLabel;
    private JLabel cash;
    private JLabel tickVal;
    private JLabel num_gens;

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

        // Buttons
        stealACookieFromButton.addActionListener(this);



        frame.setContentPane(this.rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Updates the Swing GUI with the player's info
     * Called every tick
     */
    public void updateGUI() {
        CashResource cash = new CashResource();
        this.num_gens.setText(Integer.toString(this.player.getNumGens(RESOURCE_TYPES.CASH)));
        this.name.setText(this.player.getName());
        this.cash.setText(Integer.toString(this.player.getResourceStatus(new CashResource())));
        this.tickVal.setText(Integer.toString(getCurrTick()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.addResources(RESOURCE_TYPES.CASH, 10);
    }



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
        util.debug("Tick: " + tick);
        this.tick++;
        player.tick();
        this.updateGUI();
    }

    /**
     * @return The current tick of this Game
     */
    public int getCurrTick() {
        return this.tick;
    }

    /**
     * Start the global timer
     * @throws IllegalStateException If the timer has already been started
     */
    public void startTheClock() throws IllegalStateException {

        // Checks for a non-zero tick
        if (this.tick != 0) {
            throw new IllegalStateException("Clock cannot be started at a non-zero value.");
        }

        // Starts up a timer every /period/ms
        long period = 1000;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        }, 0, period);
    }

    ////////////////////
    // PLAYER CONTROL //
    ////////////////////

    public void addResources(RESOURCE_TYPES resourceType, int num) {
        switch (resourceType) {
            case CASH:
                this.player.addResources(new CashResource(), num);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized resource type");
        }
    }
}
