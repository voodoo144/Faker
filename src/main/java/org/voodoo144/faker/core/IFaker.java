package org.voodoo144.faker.core;

public interface IFaker {
    String city();
    String street();
    String zipCode();
    String regionOrState();
    String country();
    String streetPrefix();
    String cityPrefix();

    String firstName();
    String lastName();
    String middleName();
    String namePrefix();
    String nameSuffix();

    String word();
    String sentence();
    String text();

    String email();
}
