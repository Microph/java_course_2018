package day4;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbbreviationGen {

    public String generateAbbreviation(String string) {
        return Stream.of(string.split(" "))
            .map(String::toLowerCase)
            .filter(str -> str.compareTo("of") != 0)
            .filter(str -> str.compareTo("by") != 0)
            .map(str -> str.substring(0, 1))
            .map(String::toUpperCase)
            .collect(Collectors.joining( "" ));
    }

}
