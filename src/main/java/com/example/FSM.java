package com.example;

/**
 * Created by peter.ty on 15/11/19.
 */
public class FSM {

    public static void main(String[] args) {

        String str = " i \t am     here     ! ";
        int count = count(str);
        System.out.println(count);
    }

    enum State {
        IN,
        OUT
    }

    public static int count(String str) {

        int start = 0;
        int end = str.length();

        int count = 0;
        State state = State.OUT;

        for(int i = start; i<end; i++) {

            char current = str.charAt(i);
            if(state == State.OUT) {
                if(current == ' ' || current == '\t') {
                    state = State.OUT;
                }else{
                    state = State.IN;
                    count++;
                }
            }else{
                if(current != ' ' && current != '\t') {
                    state = State.IN;
                }else{
                    state = State.OUT;
                }
            }
        }

        return count;
    }
}
