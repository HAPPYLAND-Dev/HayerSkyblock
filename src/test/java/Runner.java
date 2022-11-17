import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Runner {

    @Test
    public void load() {
        HashMap<String, Integer> list = new HashMap<>();
        int i;
        for (i = 1; i < 3000000; i++) {
            list.put("Int" + i, 200);
        }
        for (i = 1; i < 40; i++) {
            pick(list);
        }
    }

    public static void pick(HashMap<String, Integer> list) {
        long start = System.currentTimeMillis();
        if (list.getOrDefault("Int2999000", 1) == 200) {
            long now = System.currentTimeMillis();
            System.out.println("Time: " + (now - start) + " ms");
        }
    }

}
