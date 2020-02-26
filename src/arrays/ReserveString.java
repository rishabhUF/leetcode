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

    // Merge two sorted array
    public int[] merge(int[] arr1, int[] arr2) {
        //edge cases
        if(arr1 == null && arr2 == null)
            return null;
        if(arr1 == null)
            return arr2;
        if(arr2 == null)
            return arr1;

        int i = 0, j= 0, k=0;
        int[] result = new int[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                result[k++] = arr1[i];
                i++;
            } else {
                result[k++] = arr2[j];
                j++;
            }
        }
        while(i<arr1.length) {
            result[k++] = arr1[i];
            i++;
        }
        while(j<arr2.length) {
            result[k++] = arr2[j];
            j++;
        }
        return result;
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

        //merge two sorted array
        int[] merged = reserveString.merge(new int[]{1,3,5,7}, new int[]{2});
        Arrays.stream(merged).forEach(i -> System.out.print(i + " "));
    }
}
