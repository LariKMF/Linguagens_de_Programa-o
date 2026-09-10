public class Main {
    public static void main(String[] args){

        int[][] numbers= { {5,4,9,6},
        {3,5,1,8},
        {7,6,8,2},
        {3,6,1,9}
        };

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++) {
                numbers [i][j] = 0;
            

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++) {
                System.out.println(numbers[i][j]);
            }
        }
        
        /*System.out.println(numbers[2][3]);*/
    }
}
