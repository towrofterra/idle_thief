public class Game {
    int tick = 0;
//    Player p;

    public static void main(String[] args){
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
