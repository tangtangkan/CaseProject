package com.ttk.examplecase.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClass {

    private Integer classId;

    private String className;

    private List<Person> personList;
}
