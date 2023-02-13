package org.msy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Msy
 * @date 2023/2/9  14:25
 */
@Data
@AllArgsConstructor
public class Reader {
    private Integer id;
    private String name;
    private String hobby;
    private String age;
    private List<BkRr> bkRrList;
    private Country country;

    public Reader() {

    }

    public Reader(Integer id, String name, String hobby, String age) {
        this.id = id;
        this.name = name;
        this.hobby = hobby;
        this.age = age;
    }
}
