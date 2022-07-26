public class WordNode {
    private String word;
    private int freq;
    private WordNode next;

    public WordNode(String word) {
        this.word = word;
        freq = 1;
        this.next = null;
    }

    public WordNode(String word, int freq) {
        this.word = word;
        this.freq = freq;
        this.next = null;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public WordNode getNext() {
        return next;
    }

    public void setNext(WordNode next) {
        this.next = next;
    }
}
