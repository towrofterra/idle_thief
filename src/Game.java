import javax.swing.*;

public class Game {
    int tick = 0;
    private JPanel rootPanel;
    private JLabel name;
    private JButton button1;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar progressBar3;
    private JButton button2;
    private JButton button3;
    private JLabel Generators;
    private JLabel Resources;
//    Player p;

    public static void main(String[] args){
        JFrame frame = new JFrame("Idle Thief");
        frame.setContentPane(new Game().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);




        Player p1 = new Player("Jake");
        System.out.println(p1.getStatus());

        CashResource cash = new CashResource();
        Generator cashGen = new Generator(cash);
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

}
