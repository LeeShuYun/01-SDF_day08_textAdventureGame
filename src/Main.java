public class Main {
    public static void main(String[] args){
        // String file = "src/zork.txt";
        //read a file
        String gameFile = args[0];

        //start the game loop
        TextGame game = new TextGame();
        game.prepGame(gameFile);
        game.startGame();
    }
}
