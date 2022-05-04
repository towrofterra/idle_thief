public class Main {
    /**
     * Main entry point into the program
     */
    public static void main(String[] args) {
        Game g;
        if (args.length > 1) {
            throw new IllegalArgumentException("Expected player name as the only argument");
        }
        Player p;
        if (args.length != 0 ) {
            p = new Player(args[0]);
        }
        else {
            p = new Player("Garret");
        }
        g = new Game(p);
        g.swingSetup();
        g.startTheClock();

    }
}
