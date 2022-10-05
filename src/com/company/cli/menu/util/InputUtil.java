package com.company.cli.menu.util;

import java.util.Scanner;

public class InputUtil {

    public String inputString(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public int inputInt(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}
