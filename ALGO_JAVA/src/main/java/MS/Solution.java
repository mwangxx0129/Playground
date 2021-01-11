package MS;

import java.util.*;

public class Solution {

//    public boolean solution(int[] A, int K) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 1; i <= K; ++ i) {
//            set.add(i);
//        }
//
//        for (int e : A) {
//            set.remove()
//        }
//
//        return false;
//    }

    // # 2
    // M: length of A
    // N: longest length String in A
    // T = O(M * N)
    // S = O(M + N)
    public int solution(String[] A) {
        Arrays.sort(A, (s1, s2) -> s1.length() - s2.length());
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            String cur = A[i];

            // check unique character in String
            if(isUniqueCharacterInString(cur)) continue;

            boolean existed = false;
            for(int j = 0 ; j < cur.length() ; j++) {
                if(set.contains(cur.charAt(j))) {
                    existed = true;
                    break;
                }
            }

            if(!existed) {
                for(int j = 0 ; j < cur.length() ; j++) {
                    set.add(cur.charAt(j));
                }
            }
        }
        return set.size();
    }

    boolean isUniqueCharacterInString(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size() == s.length();
    }
}
