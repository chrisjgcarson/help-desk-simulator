import java.util.*;

public class Selector {

    public static <T> List<T> pickRandom(List<T> source, int count) {
        List<T> result = new ArrayList<>();
        Set<Integer> indexSet = new HashSet<>();
        Random rand = new Random();

        while (result.size() < count) {
            int index = rand.nextInt(source.size());

            if (!indexSet.contains(index)) {
                result.add(source.get(index));
                indexSet.add(index);
            }
        }
        return result;
    }
}
