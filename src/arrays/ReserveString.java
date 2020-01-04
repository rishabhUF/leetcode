package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReserveString {

    public void reverse(List<Character> characters) {
        int start = 0, end = characters.size()-1;
        while(start < end) {
            Character temp = characters.get(start);
            characters.set(start, characters.get(end));
            characters.set(end, temp);
            start++;
            end--;
        }
    }

    public void reverse_words(List<Character> characters) {

        //1. Reverse the characters
        int start = 0, end = characters.size()-1;
        while(start < end) {
            Character temp = characters.get(start);
            characters.set(start, characters.get(end));
            characters.set(end, temp);
            start++;
            end--;
        }

        //2. Reverse the characters of each word
        int current_word_index = 0;
        for(int i = 0;i <= characters.size(); i++) {
            if((i == characters.size()) || characters.get(i).equals(' ')) {
                reverse_word(characters, current_word_index, i);
                current_word_index = i+1;
            }
        }

    }

    private void reverse_word(List<Character> characters, int current_word_index, int i) {
        int start = current_word_index, end = i-1;
        while(start < end) {
            Character temp = characters.get(start);
            characters.set(start, characters.get(end));
            characters.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReserveString reserveString = new ReserveString();
        ArrayList<Character> characters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd'));
        reserveString.reverse(characters);
        characters.forEach(c -> System.out.print(c));
        System.out.println("");
        ArrayList<Character> words = new ArrayList<>(Arrays.asList('c', 'a', 'k', 'e', ' ', 's', 't', 'e', 'a', 'l'));
        reserveString.reverse_words(words);
        words.forEach(c -> System.out.print(c));


    }
}
