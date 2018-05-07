import java.util.ArrayList;
import java.util.List;

public class Subset {
    //"abcdef"
    // a ab abc abcd abcde abcdef
    // bcdef cdef
    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();
        String s = "abcdef";
        helper(s, 0, s.length(), new ArrayList<String>(), res);
        System.out.println(res);
    }

    public static void helper(String s, int l, int r, List<String> sub, List<List<String>> res) {
        if (l == r) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = l + 1; i <= r; ++ i) {
            sub.add(s.substring(l, i));
            helper(s, i, r, sub, res);
            sub.remove(sub.size() - 1);
        }
    }
}
