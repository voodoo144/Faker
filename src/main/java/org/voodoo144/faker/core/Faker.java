package org.voodoo144.faker.core;

import org.apache.commons.lang3.RandomStringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

public class Faker implements IFaker {
    private IFakerDict dict;
    
    private final static int DEFAULT_NUMBER_OF_WORDS_IN_SENTENCE=5;
    private final  static int DEFAULT_NUMBER_OF_SENTENCES_IN_TEXT=10;
    
    public Faker(String dictClassName) {
        try {
            Class dictClass = Class.forName(dictClassName);
            dict = (IFakerDict) dictClass.getConstructors()[0].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Faker(Class fakerDictClass) {
        try {
            dict = (IFakerDict) fakerDictClass.getConstructors()[0].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return random text
     *
     * @return String
     */
    public String text() {
        StringBuffer text = new StringBuffer();
        for (int i = 0; i < DEFAULT_NUMBER_OF_SENTENCES_IN_TEXT; i++) {
            text.append(" ");
            text.append(sentence());
        }
        return text.toString();
    }

    public String sentence() {
        StringBuffer sentence = new StringBuffer();
        for (int i = 0; i < DEFAULT_NUMBER_OF_WORDS_IN_SENTENCE; i++) {
            sentence.append(" "); 
            sentence.append(word());
        }
        sentence.append(".");
        return capitalize(sentence.toString());
    }

    public String word() {
        return FakerUtils.getRandomElement(dict.getWords());
    }

    public String email() {
        return FakerUtils.getRandomElement(dict.getWords()) + "." + FakerUtils.getRandomElement(dict.getWords()) + "." + number("##") + "@example.com";
    }

    public String date() {
        return null;
    }

    public String number() {
        return null;
    }

    public String dateBetween() {
        return null;
    }

    /**
     * Return random number as String
     *
     * @param format must be String like this "### ###-##-##"
     * @return String
     */
    public String number(String format) {
        char[] ar = format.toCharArray();
        for (int i = 0; i < format.length(); i++) {
            if (ar[i] == '#') {
                ar[i] = RandomStringUtils.randomNumeric(1).charAt(0);
            }
        }
        return new String(ar);
    }

    public String birthdate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, FakerUtils.randBetween(1900, 1995));
        calendar.set(Calendar.MONTH, FakerUtils.randBetween(1, 12));
        calendar.set(Calendar.DAY_OF_MONTH, FakerUtils.randBetween(1, 28));
        return calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
    }

    private static String capitalize(String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    public static String string(String format) {
        char[] ar = format.toCharArray();
        for (int i = 0; i < format.length(); i++) {
            if (ar[i] == '#') {
                ar[i] = RandomStringUtils.randomAlphabetic(1).charAt(0);
            }
        }
        return new String(ar);
    }

    public String address() {
        return number(dict.getPostCodeFormat()) + ", "
                + FakerUtils.getRandomElement(dict.getRegionsOrStates()) + " "
                + FakerUtils.getRandomElement(dict.getRegionSuffixes()) + ", "
                + FakerUtils.getRandomElement(dict.getCityPrefixes()) + " "
                + FakerUtils.getRandomElement(dict.getCities()) + ", "
                + FakerUtils.getRandomElement(dict.getStreetPrefixes()) + " "
                + FakerUtils.getRandomElement(dict.getStreets()) + ", "
                + FakerUtils.getRandomInt();
    }

    public String city() {
        return FakerUtils.getRandomElement(dict.getCities());
    }

    public String street() {
        return null;
    }

    public String zipCode() {
        return null;
    }

    public String regionOrState() {
        return null;
    }

    public String country() {
        return null;
    }

    public String streetPrefix() {
        return null;
    }

    public String cityPrefix() {
        return null;
    }

    public String firstName() {
        return FakerUtils.getRandomElement(dict.getFirstNames());
    }

    public String lastName() {
        return FakerUtils.getRandomElement(dict.getLastNames());
    }

    public String middleName() {
        return FakerUtils.getRandomElement(dict.getMiddleNames());
    }

    public String namePrefix() {
        return null;
    }

    public String nameSuffix() {
        return null;
    }

    }
