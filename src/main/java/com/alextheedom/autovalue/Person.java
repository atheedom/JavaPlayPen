package com.alextheedom.autovalue;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class Person {
    static Person create(String name, int age) {
        return new AutoValue_Person(name, age);
    }

    abstract String name();
    abstract int age();
}
