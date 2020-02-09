package filePraser;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileParser {

    public void readFile(String args[]) {
        try (FileReader fileReader = new FileReader(args[0])) {

            Stream<String> streamFromFiles = Files.lines(Paths.get(args[0]));
            System.out.println(streamFromFiles.count());
          //  boolean a = streamFromFiles.allMatch((s) -> s.contains("of"));
            // long d =streamFromFiles.filter("of"::equals).count();
            // collection.stream().filter(«a1»::equals).count();
//            System.out.println("fillter :");
            //  System.out.println(d);
//
//            System.out.println("match : ");
//            System.out.println(a);
//            char[] buf = new char[200];
//            int c;
//            while((c = fileReader.read(buf))>0) {
//
//                if (c < 200) {
//                    buf = Arrays.copyOf(buf, c);
//                }
//                System.out.println("hello : ");
//                System.out.println(buf);
//            }

//            FileInputStream fileInputStream = new FileInputStream(args[0]);
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200);
//
//            int i;
//            while ((i = bufferedInputStream.read()) != -1) {
//                System.out.print((char) i);
//            }

//
//            Scanner scanner = new Scanner(fileReader);
//
//            if (args.length == 2) {
//                while (scanner.hasNext()) {
//                    scanner.nextLine();
//                    System.out.println(" я пишу: " + scanner.nextLine());
//                }
//                // todo подсчет
//
//            } else if (args.length == 3) {
//                // todo замена
//                System.out.println(" я меняю : " + scanner.nextLine());
//            }


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

//
//    private boolean checkInput(String args[],) {
//
//
//    }

}
