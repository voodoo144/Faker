package org.voodoo144.faker.core;

import java.util.Random;

class FakerUtils {

    private static Random random = new Random();

    static String getRandomElement(String[] elements) {
        int idx = random.nextInt(elements.length);
        return elements[idx];
    }

    static int getRandomInt(){
        return random.nextInt();
    }
    static int randBetween(int start, int end) {
        return start + random.nextInt(end - start);
    }

}
