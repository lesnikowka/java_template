package edu.hw1;

public class Task5 {
    private Boolean isPalindrome(String string){
        for (int i = 0; i < string.length() / 2; i++){
            int reversedIndex = string.length() - 1 - i;
            if (string.charAt(i) != string.charAt(reversedIndex)){
                return false;
            }
        }
        return true;
    }
}
