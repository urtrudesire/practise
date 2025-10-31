package code;

public class BucketsMicrosoft {
    public int solution(String buckets) {
        // Implement your solution here
        int balls = 0;
        int space = 0;
        for(int i = 0 ; i < buckets.length()-1 ; i++){
            if(buckets.charAt(i) == '.')
                space++;
            else
                balls++;
        }
        if( space + 1 < balls){
            return -1;
        }
        return balls;
    }
}
