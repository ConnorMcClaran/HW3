

/**
 * Created by mcclarci on 10/18/2016.
 * Connor McClaran code for 3.1. # 8,9
 */


import java.io.*;


public class Frequency_Counter {


    private Frequency_Counter() { }

    /**
     * Reads in a command-line integer and sequence of words from
     * standard input and prints out a word (whose length exceeds
     * the threshold) that occurs most frequently to standard output.
     * It also prints out the number of words whose length exceeds
     * the threshold and the number of distinct such words.
     *
     * @param args the command-line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) {


        int Length1 = Integer.parseInt(args[0]);
        int Length2 = Integer.parseInt(args[1]);
        int Length3 = Integer.parseInt(args[2]);


        ST<String, Integer> st = new ST<String, Integer>();
        ST<String, Integer> Table1 = new ST<String, Integer>();
        ST<String, Integer> Table2 = new ST<String, Integer>();
        ST<String, Integer> Table3 = new ST<String, Integer>();


        String fileName="src/tale.txt";

        String Finalvalone = "";
        String Finalvaltwo = "";
        String Finalvalthree = "";

        int previousvalue1 = 0;
        int previousvalue2 = 0;
        int previousvalue3 = 0;



        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = in.readLine()) != null)
            {
                String[] pieces = line.split("\\s+");
                for (String Key : pieces) {

                    if (Key.length() < Length1) {

                    }
                    if (Key.length() >= Length1) {
                        if (st.contains(Key)) {


                            st.put(Key, st.get(Key) + 1);
                        }
                        else {
                            st.put(Key, 1);


                        }
                    }
                    if (Key.length() < Length1) continue;
                    if (!Table1.contains(Key)) {
                        Table1.put(Key, 1);
                        previousvalue1 ++;
                        Finalvalone = Key;
                    }
                    else {
                        Table1.put(Key, Table1.get(Key) + 1);
                        previousvalue1 ++;
                        Finalvalone = Key;
                    }

                    if (Key.length() < Length2) continue;
                    if (!Table2.contains(Key)) {
                        Table2.put(Key, 1);
                        previousvalue2 ++;
                        Finalvaltwo = Key;
                    }
                    else    {
                        Table2.put(Key, Table2.get(Key) + 1);
                        previousvalue2 ++;
                        Finalvaltwo = Key;
                    }

                    if (Key.length() < Length3) continue;
                    if (!Table3.contains(Key)) {
                        Table3.put(Key, 1);
                        previousvalue3 ++;
                        Finalvalthree = Key;
                    }
                    else {
                        Table3.put(Key, Table3.get(Key) + 1);
                        previousvalue3 ++;
                        Finalvalthree = Key;
                    }
                }
            }
            String max = "";
            st.put(max, 0);

            for (String word : st.keys()) {
                if (st.get(word) > st.get(max))
                    max = word;
            }




            String TenOrMore = "";
            Table3.put(TenOrMore, 0);
            for (String word : Table3.keys())
                if (Table3.get(word) > Table3.get(TenOrMore))
                    TenOrMore = word;
            System.out.println("Most Frequently used word of 10 letters or more: " +TenOrMore + " " + Table3.get(TenOrMore)+" times" +"\n");
            System.out.println("Words Processed Length1: " + previousvalue1 + " Last Word Inserted: " + Finalvalone);
            System.out.println("Words Processed Length2: " + previousvalue2 + " Last Word Inserted: " + Finalvaltwo);
            System.out.println("Words Processed Length3: " + previousvalue3 + " Last Word Inserted: " + Finalvalthree + "\n");


        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s': " + e.getMessage(), fileName);
            e.printStackTrace();

        }
    }
}