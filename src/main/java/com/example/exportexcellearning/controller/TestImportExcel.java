/**
 * @author SargerasWang
 */
package com.example.exportexcellearning.controller;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.exportexcellearning.entity.Student;
import com.example.exportexcellearning.excel.ExcelCell;
import com.example.exportexcellearning.excel.ExcelLogs;
import com.example.exportexcellearning.excel.ExcelUtil;
import com.example.exportexcellearning.service.StudentService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试导入Excel 97/2003
 */
@RestController
public class TestImportExcel {
    @Resource
    private StudentService studentService;

    /**
     * @author lst
     * @date 2023/4/6 17:16
     */
    @GetMapping("/getExcelList")
    public List<Student> getExcelList() throws IOException {
        List<Student> studentList = studentService.queryAll(null).getContent();
        File f = new File("test.xls");
        OutputStream out = new FileOutputStream(f);

        LinkedHashMap<String, String> studentMap = createTitle(Student.class);

        ExcelUtil.exportExcel(studentMap, studentList, out);
        out.close();
        return studentList;
    }

    private LinkedHashMap<String, String> createTitle(Class mClass) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        // 获取类变量注解：
        Field[] fields = mClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ExcelCell.class)) {
                ExcelCell excelCell = field.getAnnotation(ExcelCell.class);
                result.put(field.getName(), excelCell.name());
            }
        }
        return result;
    }

    @GetMapping("importxls")
    public void importXls() throws FileNotFoundException {
        File f = new File("C:\\Demos\\exportExcelLearning\\test.xls");
        InputStream inputStream = new FileInputStream(f);

        ExcelLogs logs = new ExcelLogs();
        Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs, 0);


        for (Map m : importExcel) {
            Student student = new Student();
            student.setName(m.get("姓名").toString());
            student.setNo(Integer.parseInt(m.get("学号").toString()));
            studentService.insert(student);
        }
    }

}
