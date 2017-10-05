package com.company;

import java.io.*;
import java.util.Scanner;

public class Table {

    public void showTable(int score) throws IOException {
        String fileHigh = "/Users/kemal/Documents/java/Vecka 2/game/RunningMan/Highscore.txt";
        String tmp      = "/Users/kemal/Documents/java/Vecka 2/game/RunningMan/tmp.txt";

        Scanner sc = new Scanner(new File(fileHigh));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(tmp)));

        while (sc.hasNextLine()) {
            int current = Integer.parseInt(sc.nextLine());
            if (score > current) {
                writer.println(score);
                score = 0;
            }
            writer.println(current);
        }

        writer.close(); sc.close();

        sc      = new Scanner(new File(tmp));
        writer  = new PrintWriter(new BufferedWriter(new FileWriter(fileHigh)));

        while (sc.hasNextLine()) {
            writer.println(sc.nextLine());
        }

        writer.close(); sc.close();
    }
}

