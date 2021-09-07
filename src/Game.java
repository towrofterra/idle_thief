import javax.swing.*;

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
    private Player p;

    //////////////////
    // CONSTRUCTORS //
    //////////////////
    /**
     * Convenience default constructor
     */
    public Game() {
        this.p = new Player();
    }

    /**
     * Construct a game with the given player
     */
    public Game(Player p) {
        this.p = p;
    }


    // Resource/Generator instantiation
    // CashResource cashResource = new CashResource();
    // Generator<CashResource> cashGen = new Generator<>(cashResource);


}
