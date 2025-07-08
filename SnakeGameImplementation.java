import java.util.*;

public class SnakeGameImplementation implements SnakeGame {
    boolean gameOver = false;
    int snakeSize;
    int moves ;
    Deque<int[]> snakePosition;
    Set<String> snakePositionSet;
    int boardHeight;
    int boardLength;
    Directions lastDirection = null;

    public SnakeGameImplementation(int boardHeight, int boardLength, int snakeInitialSize){
        this.boardHeight = boardHeight;
        this.boardLength = boardLength;
        this.moves = 0;
        snakePosition = new LinkedList<>();
        snakePositionSet = new HashSet<>();
        initialiseSnake(snakeInitialSize);

    }
    public String makeStringKey(int[] pair){
       

        return pair[0]+","+pair[1];
    }
    public void initialiseSnake(int snakeInitialSize){
         this.snakeSize = snakeInitialSize;
        
         for(int i=0; i<snakeInitialSize; i++){
           
            int[] pair = new int[]{0,i};
            String str = makeStringKey(pair);
            snakePosition.add(pair);//tail tail head
            snakePositionSet.add(str);

         }

    }
    public int[] move(int[] currHead, Directions currDir){

        int x =  currHead[0];//row
        int y = currHead[1];//column

        switch(currDir){
             case Directions.UP:
             {
                x = (x-1+boardHeight)%boardHeight;
                break;
             }
             case Directions.DOWN:
             {
                x = (x+1+boardHeight)%boardHeight;
                break;
             }
             case Directions.RIGHT:
             {
                y = (y+1+boardLength)%boardLength;
                break;
             }
             case Directions.LEFT:
             {
                y = (y-1+boardLength)%boardLength;
                break;
             }
        }
       


        return new int[]{x,y};
    }

    @Override
    public void moveSnake(Directions currDir){

        
        if((lastDirection == null && currDir == Directions.LEFT )|| (lastDirection != null && currDir.getOppositeDirection(currDir) == lastDirection)){
            System.out.println("InvalidMove");
            return;
        }
       

        int[] currHead = snakePosition.peekLast();
        int[] newHead = move(currHead, currDir);

         String headStringKey = makeStringKey(newHead);
        //collision
         if(snakePositionSet.contains(headStringKey)){
            this.gameOver = true;
            return;
         }

         int[] tail = snakePosition.peekFirst();
         boolean isGrow = (++moves)%5 == 0 ? true: false;

         
         if(!isGrow){
            snakePosition.pollFirst();
            snakePositionSet.remove(makeStringKey(tail));
         }
         snakePositionSet.add(headStringKey);
         snakePosition.add(newHead);
        this.lastDirection = currDir;



         
    }
    @Override
    public boolean isGameOver(){


        return gameOver;
    }

    public void printSnake(){
        for (int[] pos : snakePosition) {
            System.out.printf(pos[0] + " " + pos[1] + ", ");
        }
        System.out.println();
    }

}
