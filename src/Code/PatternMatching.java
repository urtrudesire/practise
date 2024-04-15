package Code;

public class PatternMatching {

    public static void main(String[] args) {
        PatternMatching p = new PatternMatching();
        System.out.println(p.isMatch("ab", "a"));
    }

    public boolean isMatch(String s, String p) {
        if(s.length() < p.length())
            return false;
        int pIndex = 0, sIndex=0;
        while(pIndex < p.length()){
            if(p.charAt(pIndex) == '*'){
                pIndex++;
                sIndex = s.length() - (p.length() - pIndex);
            }else if(p.charAt(pIndex) == '.'){
                pIndex++;
                sIndex++;
            } else {
                if(p.charAt(pIndex) != s.charAt(sIndex))
                    return false;
                pIndex++;
                sIndex++;
            }
        }
        if(sIndex < s.length())
            return false;
        return true;
    }
}
