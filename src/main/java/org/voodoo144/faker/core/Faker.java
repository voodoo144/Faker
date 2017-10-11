package org.voodoo144.faker.core;

import org.apache.commons.lang3.RandomStringUtils;

import java.lang.reflect.InvocationTargetException;

public class Faker implements IFaker {
    private IFakerDict dict;

    private final static int DEFAULT_NUMBER_OF_WORDS_IN_SENTENCE = 5;
    private final static int DEFAULT_NUMBER_OF_SENTENCES_IN_TEXT = 10;

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

    /**
     * This method return generated sentence with DEFAULT_NUMBER_OF_WORDS_IN_SENTENCE
     *
     * @return String
     */
    public String sentence() {
        StringBuffer sentence = new StringBuffer();
        for (int i = 0; i < DEFAULT_NUMBER_OF_WORDS_IN_SENTENCE; i++) {
            sentence.append(" ");
            sentence.append(word());
        }
        sentence.append(".");
        return FakerUtils.capitalize(sentence.toString());
    }

    /**
     * Random word from dictionary
     *
     * @return String
     */
    public String word() {
        return FakerUtils.getRandomElement(dict.getWords());
    }

    /**
     * Random email generated from words in dictionary
     *
     * @return String
     */
    public String email() {
        return FakerUtils.getRandomElement(dict.getWords()) + "." + FakerUtils.getRandomElement(dict.getWords()) + "." + number("##") + "@example.com";
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

    public String city() {
        return FakerUtils.getRandomElement(dict.getCities());
    }

    public String street() {
        return FakerUtils.getRandomElement(dict.getStreets());
    }

    public String zipCode() {
        return number(dict.getPostCodeFormat());
    }

    public String regionOrState() {
        return FakerUtils.getRandomElement(dict.getRegionsOrStates());
    }

    public String country() {
        return FakerUtils.getRandomElement(dict.getCountries());
    }

    public String streetPrefix() {
        return FakerUtils.getRandomElement(dict.getStreetPrefixes());
    }

    public String cityPrefix() {
        return FakerUtils.getRandomElement(dict.getCityPrefixes());
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
        return FakerUtils.getRandomElement(dict.getNamePrefixes());
    }

    public String nameSuffix() {
        return FakerUtils.getRandomElement(dict.getNameSuffixes());
    }

}
