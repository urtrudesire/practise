package code;

public class VersionCheck {

    public static void main(String[] args) {
        System.out.println(compareVersion("2", "4"));
    }
    public static int compareVersion(String A, String B) {
        String[] x = A.split("\\.");
        String[] y = B.split("\\.");
        int i = 0;
        for( ; i < Math.min(x.length, y.length); i++){
            x[i] = x[i].replaceFirst("^0+(?!$)", "");
            y[i] = y[i].replaceFirst("^0+(?!$)", "");
            int z = compareString(x[i], y[i]);
            if(z == 0)
                continue;
            return z;
       }
        int res = Integer.compare(x.length, y.length);
        if(res == 1){
            res = removeZero(x, i, res);
        }
        if(res == -1){
            res = removeZero(y, i, res);
        }
        return res;
}

    private static int compareString(String x, String y) {
        int c = Integer.compare(x.length(), y.length());
        if(c != 0){
            return c;
        }
        for(int i = 0; i < x.length(); i++){
            c = Integer.compare(x.charAt(i), y.charAt(i));
            if(c != 0)
                return c;
        }
        return 0;
    }

    private static int removeZero(String[] x, int i, int res) {
        int r = 0;
        for(;i < x.length; i++){
            x[i] = x[i].replaceFirst("^0+(?!$)", "");
            if(!x[i].isEmpty() && !x[i].equals("0")){
                return  res;
            }
        }
        return r;
    }
}
