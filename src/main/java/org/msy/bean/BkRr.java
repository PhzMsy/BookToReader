package org.msy.bean;

import lombok.Data;

/**
 * @author Msy
 * @date 2023/2/9  14:25
 */
@Data
public class BkRr {
    private Integer id;
    private Reader reader;
    private Book book;

    public BkRr(Integer id, Reader reader, Book book) {
        this.id = id;
        this.reader = reader;
        this.book = book;
    }

    public BkRr() {
    }

}
