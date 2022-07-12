package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class NumberRangeSummarizerImp implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        // Init the returned list
        ArrayList<Integer> inputList = new ArrayList<>();

        // Iterate through input string, convert to int and add to list if possible or catch exception/duplicates and end execution
        try {
            for (String s : input.split(",")) {
                if (!inputList.contains(Integer.parseInt(s))) {
                    inputList.add(Integer.parseInt(s));
                } else {
                    System.out.println("Input string contains duplicates. Please re-enter.");
                    System.exit(1);
                }
            }
        } catch (NumberFormatException n) {
            System.out.println("Input string contains non-numeric characters or whitespace. Please re-enter.");
            System.exit(1);
        }

        // Sort the input
        Collections.sort(inputList);
        return inputList;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        ArrayList<Integer> inputList = new ArrayList<>(input);

        // Init returned string
        String output = "";

        int count = 0, current = 0, next = 0; // Number of consec numbers, current number in list, next number in list
        int trim = 1; // Number of chars to trim at the end
        int length = inputList.size(); // Max number of iterations

        for (int i = 0; i < length; i++) {
            // If loop gets to last item, add it to output string
            if (i == length - 1) {
                output = output.concat(inputList.get(i).toString());
                trim = 0;
                break;
            }
            current = inputList.get(i);
            next = inputList.get(i + 1);

            // Check if range begins
            if (current == next - 1) {
                count++; // Increment range length
                int first = current; // Set current range beginning

                // Determine current range
                for (int j = i + 1; ; j++) {
                    current = next;
                    // Accommodate for end of array
                    try {
                        next = inputList.get(j + 1);
                    } catch (IndexOutOfBoundsException e) {
                        trim = 2;
                    }

                    // Check if range continues
                    if (current == next - 1) {
                        count++; // Increment range length
                    } else {
                        i = j; // Next iteration of main loop starts at index of current range ending

                        // Check if range is > 2 consec numbers and format accordingly
                        if (count > 1) {
                            output = output.concat(first + " - " + current + ", ");
                        } else {
                            output = output.concat(first + ", " + current + ", ");
                        }
                        break;
                    }
                }
            }
            // If not consecutive, just print current number
            else {
                output = output.concat(current + ", ");
            }
            count = 0;
        }

        // Remove unnecessary chars and whitespace
        return output.substring(0, output.length() - trim);
    }
}
