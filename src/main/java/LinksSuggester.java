

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LinksSuggester {
    File file;

    public LinksSuggester(File file) throws IOException, WrongLinksFormatException {
        this.file = file;

    }

    public List<Suggest> allSuggestFromConfig() throws FileNotFoundException {
        List<Suggest> suggestList = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] conf = scanner.nextLine().split("\t");
            if (conf.length != 3) {
                throw new WrongLinksFormatException("В файле конфигурации задано не 3 параметра!");
            }
            suggestList.add(new Suggest(conf[0], conf[1], conf[2]));
        }
        scanner.close();
        return suggestList;
    }


    public List<Suggest> suggest(String text) throws FileNotFoundException {
        return allSuggestFromConfig().stream()
                .filter(p -> StringUtils.containsIgnoreCase(text, p.getKeyWord()))
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Suggest> suggest(List<Suggest> suggestList,String text) throws FileNotFoundException {
        return suggestList.stream()
                .filter(p -> StringUtils.containsIgnoreCase(text, p.getKeyWord()))
                .distinct()
                .collect(Collectors.toList());
    }
}
