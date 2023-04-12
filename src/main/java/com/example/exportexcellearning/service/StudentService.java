package com.example.exportexcellearning.service;

import com.example.exportexcellearning.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Student)表服务接口
 *
 * @author makejava
 * @since 2023-04-06 17:20:51
 */
public interface StudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param testid 主键
     * @return 实例对象
     */
    Student queryById(Integer testid);

    /**
     * 分页查询
     *
     * @param student 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Student> queryByPage(Student student, PageRequest pageRequest);

    Page<Student> queryAll(Student student);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param testid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer testid);

}
