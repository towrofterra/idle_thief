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


    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        JFrame frame = new JFrame("Idle Thief");
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        frame.setContentPane(new Game().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        Player p1 = new Player("Jake");
        System.out.println(p1.getStatus());

        CashResource cash = new CashResource();
        Generator<CashResource> cashGen = new Generator<>(cash);
        p1.addGenerator(cashGen);
        p1.addResources(cash, 10);
        p1.tick();
        p1.addGenerator(cashGen);
        p1.tick();
        p1.tick();
        p1.addGenerators(cashGen, 100);
        p1.tick();
        p1.tick();
        p1.tick();
        p1.tick();

    }

    /**
     * Adds the given player to the game
     * @param p The player to be added
     */
    public void addPlayer(Player p) {

    }
}
