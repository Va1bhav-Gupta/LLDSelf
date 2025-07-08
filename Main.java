//package TestingLLD.SnakeTry;

public class Main {
    public static void main(String[] args) {

        //initialise length and size and go some move after each 5 moves increase it
    int boardLength = 5;
    int boardHeight = 2;
    int snakeInitialSize = 3;

    SnakeGameImplementation game = new SnakeGameImplementation(boardHeight, boardLength, snakeInitialSize);

    Directions[] dir = {Directions.LEFT,
                        Directions.RIGHT,
                        Directions.LEFT,
                         Directions.DOWN,
                         Directions.LEFT,
                         Directions.UP};
    
    
     game.printSnake();   
    for(Directions currDir : dir){
       
        game.moveSnake(currDir);
        game.printSnake();

        if(game.isGameOver()){
            System.out.println("Game Over");
            break;
        }


        
    }

    }
    

}
