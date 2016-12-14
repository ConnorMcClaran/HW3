

/**
 * Created by mcclarci on 10/18/2016.
 * Connor McClaran code for 3.1. # 8,9
 */


import java.io.*;


import java.util.ArrayList;

public class Frequency_Counter {


    private Frequency_Counter() { }

    /**
     * This code doesnt work, I can't make StdIn compile
     */
    public static void main(String[] args) {
        int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<String, Integer>();

        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
        }

        ArrayList<String> topWords = new ArrayList<>();
        ArrayList<Integer> Count = new ArrayList<>();


        String max = "";
        int num = 0;

        for(int i = 0; i < 10; i++)
        {
            st.put(max, 0);
            for (String word : st.keys())
            {
                if (st.get(word) > st.get(max))
                {
                    max = word;
                    num = st.get(max);

                }

            }

            topWords.add(max);
            Count.add(num);
            st.delete(max); //deleting the max from the table
        }//for loop, 10 times

        //StdOut.println(topWords.size());

        //ArrayList display
        System.out.println("Top 10 Words used in The Tale of Two Cities:");
        System.out.println();
        System.out.println("Words\tCount");
        System.out.println();

        for(int i = 0; i < topWords.size(); i++)
        {
            System.out.println(topWords.get(i) + "\t" + Count.get(i));
        }


    }
}