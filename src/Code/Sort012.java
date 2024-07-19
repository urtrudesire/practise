package Code;

public class Sort012 {

    public static void sort012(int a[], int n)
    {
        // code here
        int s = 0, mid = 0, end = n-1;
        while(mid <= end){
            switch (a[mid]) {
                case 0: {
                    a[mid] = a[s];
                    a[s] = 0;
                    s++;
                    mid++;
                    break;
                }
                case 2: {
                    a[mid] = a[end];
                    a[end] = 2;
                    end--;
                    break;
                }
                default:
                    mid++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 0,0,1,2,1,2,2,0};
        sort012(a, a.length);
        for (int x : a){
            System.out.println(x);
        }
    }
}
