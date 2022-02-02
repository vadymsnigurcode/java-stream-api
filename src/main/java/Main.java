import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    // create a string of uppercase and lowercase characters and numbers
    static String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    static String numbers = "0123456789";

    // combine all strings
    static String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

    // create random string builder
    StringBuilder sb = new StringBuilder();

    // create an object of Random class
    static Random random = new Random();

    public static void main(String[] args) {
        //    List<Log> logs = Stream
//            .of(    new Log("Сибирская сосна", 10),
//                    new Log("Дуб монгольский", 30),
//                    new Log("Берёза карликовая", 5))
//            .collect(Collectors.toList());
        List<Log> logs = new ArrayList<Log>() {{
            add(new Log("Сибирская сосна", 10));
            add(new Log("Дуб монгольский", 30));
            add(new Log("Берёза карликовая", 5));
        }};

        Stream<Log> stream = logs.stream();
        Stream<Log> filteredStream = stream
                .filter(x -> x.getCount() > 7)
                .filter(x -> !"Дуб монгольский".equalsIgnoreCase(x.getType()));

        filteredStream.forEach(x -> System.out.println(x.getType()));

//        Stream.generate(() -> Math.random()).forEach(System.out::println);

        String randomChar1 = Character.toString(upperAlphabet.charAt(random.nextInt(upperAlphabet.length())));
        String randomChar2 = Character.toString(lowerAlphabet.charAt(random.nextInt(lowerAlphabet.length())));

        Stream randomStream1 = Stream.generate(() -> Character.toString(upperAlphabet.charAt(random.nextInt(upperAlphabet.length())))).limit(10);
        Stream randomStream2 = Stream.generate(() -> Character.toString(lowerAlphabet.charAt(random.nextInt(lowerAlphabet.length())))).limit(10);

        Stream.concat(randomStream2, randomStream1).forEach(System.out::print);


    }


}

class Log {
    String type;
    int count;

    public Log(String type, int count) {
        this.type = type;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }
}

