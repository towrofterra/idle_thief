public class Main {
    /**
     * Main entry point into the program
     */
    public static void main(String[] args) {
        Game g;
        if(args.length != 1) {
            throw new IllegalArgumentException("Expected player name as the only argument");
        }
        g = new Game(new Player(args[0]));
        g.swingSetup();
        g.startTheClock();
        g.tick();

    }
}
