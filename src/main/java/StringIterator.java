class StringIterator {
    private char[] source;
    private int pCount;
    private int index;
    private char curChar;

    private String original;

    public StringIterator(String compressedString) {
        this.original = compressedString;
        this.source = compressedString.toCharArray();
        this.curChar = source[index];
        getCharCount();
    }

    public char next() {
        if (this.index == this.source.length && pCount == 0) return ' ';
        if ( this.pCount == 0 ) {
            getCharCount();
        }
        pCount --;
        return this.curChar;
    }

    private void getCharCount() {
        this.curChar = source[index];
        int pre = index;
        index ++;
        while (this.index < source.length  && Character.isDigit(original.charAt(this.index))) {
            ++ this.index;
        }
        pCount = Integer.valueOf(original.substring(pre + 1, index));
    }

    public boolean hasNext() {
        return this.index != this.source.length || pCount == 0;
    }

    public static void main(String[] args) {

        StringIterator obj = new StringIterator("e2s4n8V18");

        for (int i = 0; i < 32; ++ i) {
            char param_1 = obj.next();
            System.out.println(param_1);
        }
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */