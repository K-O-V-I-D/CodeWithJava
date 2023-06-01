class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String s) {
        StringBuilder reversedString = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // Skip leading spaces
            while (i >= 0 && s.charAt(i) == ' ')
                i--;

            if (i < 0)
                break;

            // Append word
            StringBuilder currentWord = new StringBuilder();
            while (i >= 0 && s.charAt(i) != ' ')
                currentWord.append(s.charAt(i--));

            // Reverse and append word to reversedString
            if (reversedString.length() == 0)
                reversedString.append(currentWord.reverse());
            else
                reversedString.append(' ').append(currentWord.reverse());
        }

        return reversedString.toString();
    }
}
