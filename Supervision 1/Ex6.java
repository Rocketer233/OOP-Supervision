class Ex6 {

    int x, y;

    Ex6(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void vectorAdd(int dx, int dy) {
        x=x+dx;
        y=y+dy; 
    }

    public static void main(String[] args) {
        Ex6 o = new Ex6(0, 2);
        o.vectorAdd(1, 1);
        System.out.println(o.x+" "+o.y);
        // (a,b) is still (0,2)
    }
}
