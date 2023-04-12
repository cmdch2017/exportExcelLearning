package com.example.exportexcellearning.service.impl;

import com.example.exportexcellearning.entity.Student;
import com.example.exportexcellearning.dao.StudentDao;
import com.example.exportexcellearning.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2023-04-06 17:20:51
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param testid 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Integer testid) {
        return this.studentDao.queryById(testid);
    }

    /**
     * 分页查询
     *
     * @param student     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Student> queryByPage(Student student, PageRequest pageRequest) {
        long total = this.studentDao.count(student);
        return new PageImpl<>(this.studentDao.queryAllByLimit(student, pageRequest), pageRequest, total);
    }

    @Override
    public Page<Student> queryAll(Student student) {
        return new PageImpl<>(this.studentDao.queryAll(student));
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student update(Student student) {
        this.studentDao.update(student);
        return this.queryById(student.getTestid());
    }

    /**
     * 通过主键删除数据
     *
     * @param testid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer testid) {
        return this.studentDao.deleteById(testid) > 0;
    }
}
