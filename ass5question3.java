import java.util.*;

public class ass5question3 {

    public static ArrayList<tuple> tuples = new ArrayList<tuple>();

    public static void main(String[] args) {
        tuple tup = new tuple("","P","P","");
        derive(2, 1, tup);
        for(tuple t : tuples) {
            System.out.println(t.snd + " => "+ t.fst+t.trd+t.fth);
        }
    }

    public static void derive(int i, int j, tuple tup) {
        if(i > 0) {
            tuple newTup = deriveset("a",tup);
            tuples.add(newTup);
            derive(i-1, j, newTup);
        } else if(j>0) {
            tuple newTup = deriveset("b",tup);
            tuples.add(newTup);
            derive(i, j-1, newTup);       
        } else {
            tuple lasttup = tuples.get(tuples.size()-1);
            String fin = lasttup.trd.replaceAll("P","");
            tuples.add(new tuple(lasttup.fst, lasttup.fst+lasttup.trd+lasttup.fth,fin,lasttup.fth));
            return;
        }
    }

    public static tuple deriveset(String s, tuple tup) {
        if(s.equals("a")) {
            String old = tup.fst + tup.snd + tup.fth;
            tuple newTup = new tuple("a",old,old,"b");
            return newTup;
        } else {
            String old = tup.fst + tup.snd + tup.fth;
            tuple newTup = new tuple("",old,old,"b");
            return newTup;
        }
    }
    
    private static class tuple {
        public String fst;
        public String snd;
        public String trd;
        public String fth;

        public tuple(String s, String s1, String s2, String s3) {
            fst = s;
            snd = s1;
            trd = s2;
            fth = s3;
        }
    }
}
