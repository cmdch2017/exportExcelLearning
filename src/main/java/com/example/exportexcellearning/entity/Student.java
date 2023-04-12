package com.example.exportexcellearning.entity;

import com.example.exportexcellearning.excel.ExcelCell;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2023-04-06 17:20:50
 */
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = -25840779812747354L;
    @ExcelCell(name = "序列", index = 0)

    private Integer testid;
    @ExcelCell(name = "姓名", index = 1)
    /**
     *
     */
    private String name;
    @ExcelCell(name = "学号", index = 2)
    /**
     * 学号
     */
    private Integer no;


    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Student(Integer testid, String name, Integer no) {
        this.testid = testid;
        this.name = name;
        this.no = no;
    }
}

