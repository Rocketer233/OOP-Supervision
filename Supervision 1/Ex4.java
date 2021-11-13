import java.util.ArrayList;

class Ex4 {
    int sum (int[] a){
        int s = 0;
        for (int x : a)
            s += x;
        return s; 
    }

    int[] cumsum (int[] a){
        int s = 0;
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++)
            b[i] = (s += a[i]);
        return b; 
    }

    int[] positives (int[] a){
        ArrayList<Integer> b = new ArrayList<Integer>();
        for (int x : a)
            if (x > 0)
                b.add(x);
        int i = 0;
        int[] c = new int[b.size()];
        for (int x : b)
            c[i++] = x;
        return c;
    }

    public static void main(String[] args) {
    }
}
