package Code;

public class AmericanExpress {
    /**
     * Given a sorted array of only 0s and 1s, you need to find the occurrence of the
     * first 1 in the array.
     * Eg.
     * A = [0,0,1,1,1]
     * Return: 2
     * A = [0,0,0,0]
     * Return: -1
     */

    public static void main(String[] args) {
        int[] arr = {0,0,0,0};
        System.out.println(search(arr));
    }

    public static int search(int[] array){
        if(array.length == 0){
            return -1;
        }
        if(array[0] == 1){
            return 0;
        }
        if(array[array.length-1] == 0){
            return -1;
        }
        if(array.length > 1 && array[array.length - 2] == 0 && array[array.length - 1] == 1){
            return array.length-1;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = (start + end)/2;
        while(start < end && mid != start && mid != end){
            if(array[mid] == 1){
                if(array[mid -1] == 0){
                    return mid;
                }
                end = mid;
            } else {
                start = mid;
            }
            mid = (start+end)/2;
        }
        return -1;
    }
}
