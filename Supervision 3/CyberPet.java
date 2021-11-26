import java.util.Scanner;

class TooTired extends Exception{
    public TooTired(String msg){
        super(msg);
    }
}

class TooHungry extends Exception{
    public TooHungry(String msg){
        super(msg);
    }
}

class TooFull extends Exception{
    public TooFull(String msg){
        super(msg);
    }
}

public class CyberPet {
    private static final String begin = "Hello! I'm your pet. Please choose the type of your pet.";
    private static final String prompt = "Press 1 to feed. Press 2 to play. Press 3 to let your pet sleep. Press q to quit.";

    private String type;

    static Scanner scanner = new Scanner(System.in);

    interface Status1{
        void play() throws TooTired;
        void sleep();
        String energy();
    }

    private Status1 state1;

    class Energetic implements Status1{
        public void play(){
            state1 = new Normal1();
        }

        public void sleep(){
            state1 = new Energetic();
        }

        public String energy(){
            return "Energetic";
        }
    }

    class Normal1 implements Status1{
        public void play(){
            state1 = new Tired();
        }

        public void sleep(){
            state1 = new Energetic();
        }

        public String energy(){
            return "Normal";
        }
    }

    class Tired implements Status1{
        public void play() throws TooTired{
            throw new TooTired("Tired to death lol.");
        }

        public void sleep(){
            state1 = new Normal1();
        }

        public String energy(){
            return "Tired";
        }
    }

    interface Status2{
        void play() throws TooHungry;
        void feed() throws TooFull;
        String food();
    }

    private Status2 state2;

    class Full implements Status2{
        public void play(){
            state2 = new Normal2();
        }

        public void feed() throws TooFull{
            throw new TooFull("Eat too much!");
        }

        public String food(){
            return "Full";
        }
    }

    class Normal2 implements Status2{
        public void play(){
            state2 = new Hungry();
        }

        public void feed(){
            state2 = new Full();
        }

        public String food(){
            return "Normal";
        }
    }

    class Hungry implements Status2{
        static final String food = "Hungry";

        public void play() throws TooHungry{
            throw new TooHungry("Hungry to death lol.");
        }

        public void feed(){
            state2 = new Normal2();
        }

        public String food(){
            return "Hungry";
        }
    }

    CyberPet(String type){
        this.type = type;
        this.state1 = new Energetic();
        this.state2 = new Full();
    }

    String getType(){
        return type;
    }

    void Feed() throws Exception{
        state2.feed();
    }

    void Play() throws Exception{
        state1.play();
        state2.play();
    }

    void Sleep() throws Exception{
        state1.sleep();
    }

    String getStatus(){
        return state1.energy() + " " + state2.food();
    }

    public static void main(String[] args) throws Exception{
        System.out.println(begin);

        String type = scanner.nextLine();
        CyberPet pet = new CyberPet(type);

        while(true){
            System.out.println(pet.getType() + " " + pet.getStatus());
            System.out.println(prompt);
            int p = Integer.parseInt(scanner.nextLine());

            if(p == 1) 
                pet.Feed();
            else if(p == 2)
                pet.Play();
            else if(p == 3)
                pet.Sleep();
            else break;
        }
    }
}
