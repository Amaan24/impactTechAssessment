package numberrangesummarizer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        NumberRangeSummarizerImp nrs = new NumberRangeSummarizerImp();
        ArrayList<Integer> inputList = (ArrayList<Integer>) nrs.collect("1,22,5,3,6,2,7,72,8,12,13,21,23");
        System.out.println(inputList);
        String output = nrs.summarizeCollection(inputList);
        System.out.println(output);

    }
}
