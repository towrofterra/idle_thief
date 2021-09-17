import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Game implements ActionListener {

    //////////////
    //  FIELDS  //
    //////////////
    private final Player player;
    private int tick = 0;
    private boolean debug = false;

    /////////////////
    // SWING STUFF //
    /////////////////
    private JTabbedPane rootPanel;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar progressBar4;
    private JButton $100Button;
    private JButton steal1;
    private JButton steal5;
    private JButton steal10;
    private JButton $1000Button;
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
        steal1.addActionListener(this);
        steal5.addActionListener(this);
        steal10.addActionListener(this);
        $100Button.addActionListener(this);
        $1000Button.addActionListener(this);
        $50000Button.addActionListener(this);

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
        this.num_gens.setText(Integer.toString(this.player.getNumGens(RESOURCE_TYPES.CASH)));
        this.name.setText(this.player.getName());
        this.cash.setText(Integer.toString(this.player.getResourceStatus(RESOURCE_TYPES.CASH)));
        this.tickVal.setText(Integer.toString(getCurrTick()));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the ActionCommand from the ActionEvent
        // This holds the string containing the command for the given button
        // e.g. steal-5-10, would mean steal $5 with a 10 second cooldown
        String[] fullActionCommand = e.getActionCommand().split("-");
        switch (fullActionCommand[0].toLowerCase()) {
            case "steal":
                RESOURCE_TYPES resource = RESOURCE_TYPES.valueOf(fullActionCommand[1].toUpperCase());
                int num = Integer.decode(fullActionCommand[2]);
                addResources(this.player, resource, num);
                // cooldown
                break;
            case "buy":
                RESOURCE_TYPES price_resource = RESOURCE_TYPES.valueOf(fullActionCommand[1].toUpperCase());
                int price_num = Integer.decode(fullActionCommand[2]);
                RESOURCE_TYPES reward_resource = RESOURCE_TYPES.valueOf(fullActionCommand[3].toUpperCase());
                int reward_num = Integer.decode(fullActionCommand[4]);
                if(price_num > this.player.getResourceStatus(price_resource)) {
                    util.debug("PLAYER CANNOT AFFORD ".concat(fullActionCommand[4]).concat(" ".concat(price_resource.toString())));
                    return;
                }
                // Payment
                this.player.removeResources(price_resource,price_num);

                // Getting the generators
                addGenerators(player, reward_resource, reward_num);
                break;
        }
    }

    private void handleSteal(int value, int cooldown) {

    }

    ////////////
    //  TIME  //
    ////////////

    /**
     * Moves this Game 1 tick forward
     */
    public void tick() {
        // Manage local tick value
        util.debug("Tick: " + tick);
        this.tick++;
        // Tick the player forward
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
     *
     * @throws IllegalStateException If the timer has already been started
     */
    public void startTheClock() throws IllegalStateException {

        // Checks for a non-zero tick
        if (this.getCurrTick() != 0) {
            throw new IllegalStateException("Clock cannot be started at a non-zero value.");
        }

        // Starts up a timer every /period/ms
        long period = 100;
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

    public void addResources(Player player, RESOURCE_TYPES resourceType, int num) {
        player.addResources(resourceType, num);
    }

    public void addGenerators(Player player, RESOURCE_TYPES resourceType, int numGens) {
        player.addGenerators(resourceType, numGens);
    }

    //////////
    // UTIL //
    //////////


    public enum RESOURCE_TYPES {
        CASH
    }


}

