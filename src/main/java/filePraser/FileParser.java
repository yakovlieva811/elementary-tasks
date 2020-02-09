package filePraser;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileParser {

    public void readFile(String args[]) {
        try (Stream<String> streamFromFiles = Files.lines(Paths.get(args[0]))) {
            List<String> lines = streamFromFiles.collect(Collectors.toList());
            lines.stream().forEach(System.out::println);
            if (args.length == 2) {
                OutputToConsole.printToConsole(" [ " + args[1] + " ] found " +
                        lines.stream().filter(word -> word.contains(args[1]))
                                .count()
                        + " times.");
            } else if (args.length == 3) {
                lines.forEach(word -> word.replace(args[1], args[2]));
                List<String> updatedText = replaceWord(args[1], args[2], lines);
                updateFile(updatedText, args[0]);
                OutputToConsole.printToConsole("Successfully replaced.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void updateFile(List<String> updatedText, String path) throws IOException {
        try (FileWriter writer = new FileWriter(path)) {
            updatedText.forEach(line -> {
                try {
                    writer.write(line);
                } catch (IOException e) {
                    OutputToConsole.printToConsole(e.getMessage());
                    e.printStackTrace();
                }
            });

        }
    }

    private List<String> replaceWord(String toBeReplaced, String newWord, List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            result.add(line.replace(toBeReplaced, newWord));
        }
        return result;
    }


}
