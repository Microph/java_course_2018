package day4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AbbreviationGen {

    public String generateAbbreviation(String string) {
        String[] splittedStrings = string.split(" ");
        String out = "";
        List<String> outList = Arrays.stream(splittedStrings)
            .map(String::toLowerCase)
            .filter(str -> str.compareTo("of") != 0)
            .filter(str -> str.compareTo("by") != 0)
            .map(str -> str.substring(0, 1))
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        
        for (String str : outList) {
            out += str;
        }
        
        return out;
    }

}
