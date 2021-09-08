public class Main {
    /**
     * Main entry point into the program
     */
    public static void main(String[] args) {
        Game g;
        if(args.length != 1) {
            throw new IllegalArgumentException("Expected player name as the only argument");
        }
        Player p = new Player(args[0]);
        g = new Game(p);
        g.swingSetup();

        CashResource cash = new CashResource();
        p.addGenerator(new Generator(cash));

        g.startTheClock();

    }
}
