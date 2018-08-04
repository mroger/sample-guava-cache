package br.org.roger.spring.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Person {

    @NonNull
    private Long id;
    @NonNull
    private String name;

}
