package ru.stqa.addressbook.common;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonFunctions {
    public static String randomString(int n) {
        var rnd = new Random();
        Supplier<Integer> randomNumbers = () -> rnd.nextInt(26);
        var result = Stream.generate(randomNumbers)
                .limit(n)
                .map(i -> 'a' + i)
                .map(Character::toString)
                .collect(Collectors.joining());
        return result;
    }

    public static String randomPhone() {
        var result = "";
        for (int i = 0; i < 9; i++) {
            int rnd = (int) (Math.random() * 10);
            String rndStr = String.valueOf(rnd);
            result = result + rndStr;
        }
        result = "89" + result;
        return result;
    }

    public static String randomEmail(int n) {
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n+1; i++) {
            result = result + (char)('a' + rnd.nextInt(26));
        }
        result = result + "@" + result + ".ru" ;
        return result;
    }

    public static String randomFile(String dir) {
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }
}
