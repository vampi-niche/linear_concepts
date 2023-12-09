package DP_basics;

public class minSquares {

    public static void main(String[] args) {
        
        System.out.println(getMinSquares(12));
    }

    public static int getMinSquares(int target){
        
        if(target < 0){
            return -1;
        }

        if(target == 0){
            return 0;
        }

        int min = (int) Double.POSITIVE_INFINITY;

        for(int i=1; i*i <= target; i++){

            int sum  = getMinSquares(target - (i*i));

            if( sum> -1){
                if( min > (sum +1)){
                    min = sum +1;
                }
            }

        }
        return min;
    }
    
}
