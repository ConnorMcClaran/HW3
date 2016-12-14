/**
 * Created by mcclarci on 10/25/2016.
 * Connor McClaran Code for 3.1.19;
 */
import java.io.*;
public class Frequency_Counter2 {



        public static void main(String[] args) {
            int minlen = Integer.parseInt(args[0]);


            ST<String, Integer> st = new ST<String, Integer>();

            int[] maxCounter = new int[10];
            int maxWordLen = 0;
            int CountX = 0;
            int diff = 0;
            int wordLen;

            String[] maxWord = new String[10];
            String fileName="src/tale.txt";
            String wordTxt = "";

            try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = in.readLine()) != null)
                {
                    String[] pieces = line.split("\\s+");

                    for (String Key : pieces) {
                        if (Key.length() < minlen) {
                            continue;
                        }
                        if (st.contains(Key)) {
                            st.put(Key, st.get(Key) + 1);
                        }
                        else {st.put(Key, 1);}
                    }
                }
                String max;

                for (CountX = 0; CountX < 10;CountX++) {
                    max = "";
                    st.put(max, 0);
                    for (String word : st.keys()) {

                        if (st.get(word) > st.get(max))
                            max = word;
                    }
                    maxWord[CountX] = max;
                    if (maxWordLen < max.length())
                        maxWordLen = max.length();
                    maxCounter[CountX] = st.get(max);
                    st.delete(max);
                }
                maxWordLen += 4;
                System.out.println(" Top 10 words and their counts:");

                int i = 0;
                for (CountX = 0; CountX < 10; CountX++) {
                    wordTxt = maxWord[CountX];
                    wordLen = wordTxt.length();
                    diff = maxWordLen - wordLen;
                    System.out.print(maxWord[CountX]);
                    for (i = 1; i <= diff; i++)
                        System.out.print(" ");
                    System.out.println(maxCounter[CountX]);
                }


            }
            catch (Exception e)
            {
                System.err.format("Exception occurred trying to read '%s': " + e.getMessage(), fileName);
                e.printStackTrace();

            }
        }
    }

