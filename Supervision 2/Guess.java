public class Guess {
    private int ans;

    public Guess(int ans){
        this.ans = ans;
    }

    public String check(int v){
        if (ans == v)
            return "Correct!";
        return v < ans ? "Go higher." : "Go lower.";
    }
}
