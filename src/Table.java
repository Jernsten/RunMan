package com.company;

import java.io.*;
import java.util.Scanner;

public class Table {

    public void showTable(int score) throws IOException {
        String fileHigh = "/Users/kemal/Documents/java/Vecka 2/game/RunningMan/Highscore.txt";
        String tmp = "/Users/kemal/Documents/java/Vecka 2/game/tmp.txt";

        Scanner br = new Scanner(new File(fileHigh));
        PrintWriter writer = new PrintWriter(tmp, "UTF-8");

        int current;

        while (br.hasNextLine()) {
            current = Integer.parseInt(br.nextLine());
            if (score > current) {
                writer.println(score);
                score = 0;
            }
            writer.println(current);
        }
        writer.close();
        br.close();

        Scanner sc = new Scanner(new File(tmp));
        writer = new PrintWriter(fileHigh, "UTF-8");
        while (sc.hasNextLine()) {
            writer.println(sc.nextLine());
        }
        writer.close();
        sc.close();
    }
}

