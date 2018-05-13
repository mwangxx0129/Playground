public class WildcardMatching {
// 递归版 超时
//    public boolean isMatch(String s, String p) {
//        if ( p.length() == 0) return s.length() == 0;
//        boolean firstMatch = s.length() > 0 &&
//                (s.charAt(0) == p.charAt(0) ||  p.charAt(0) == '?');
//
//        if (p.charAt(0) == '*') {
//            return isMatch(s, p.substring(1))
//                    || s.length() > 0 && isMatch(s.substring(1), p);
//        } else {
//            return firstMatch && isMatch(s.substring(1), p.substring(1));
//        }
//    }
//

// 递归 + memory
    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        boolean res = wildcardMatching.isMatch("adceb", "*a*b");
        System.out.println(res);
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean [][] mm = new Boolean[m + 1][n + 1];
        return isValid(s, p, mm);
    }

    public boolean isValid(String s, String p, Boolean[][] mm) {
        if (mm[s.length()][p.length()] != null) return mm[s.length()][p.length()];
        if ( p.length() == 0) return s.length() == 0;
        boolean firstMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) ||  p.charAt(0) == '?');

        if (p.charAt(0) == '*')
            return mm[s.length()][p.length()] = (isValid(s, p.substring(1), mm) ||
                    s.length() > 0 && isValid(s.substring(1), p, mm));
         else
            return mm[s.length()][p.length()] = firstMatch &&
                    isValid(s.substring(1), p.substring(1), mm);

    }
}
