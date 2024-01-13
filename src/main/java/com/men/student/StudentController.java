package com.men.student;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.men.common.model.Student;

import java.util.List;

@Before(StudentInterceptor.class)
public class StudentController extends Controller
{

    @Inject
    StudentService service = new StudentService();

    /**
     * 主界面
     */
    public void index()
    {
        if (getSession().getAttribute("loginUser") == null)
        {
            redirect("/");
        } else
        {
            render("student.html");
        }

    }

    /**
     * 学生列表
     */
    public void list()
    {
        setAttr("list", service.paginate(getParaToInt(0, 1), 5));
        render("list.html");
    }

    /**
     * 添加学生
     */
    public void add()
    {
        render("add.html");
    }

    public void save()
    {
        getModel(Student.class).save();
        redirect("/student/list");
    }


    /**
     * 更新学生信息
     */
    public void edit()
    {
        setAttr("student", service.findById(getParaToInt()));
        render("update.html");
    }

    public void update()
    {
        String id = getPara("student.id");
        getModel(Student.class).update();
        redirect("/student/list");
    }

    /**
     * 删除学生信息
     */
    public void delete()
    {
        service.deleteById(getParaToInt());
        redirect("/student/list");
    }

    /**
     * 模糊查询
     */
    public void search()
    {
        String param = getPara("param");

        if (param != null && !param.isEmpty())
        {
            // 执行模糊查询操作
            List<Record> students = service.searchStudents(param);

            // 将查询结果传递到页面
            setAttr("students", students);
            setAttr("param", param);
        } else
        {
            //如果没有参数,显示所有学生列表
            List<Student> allStudents = service.findAll();
            setAttr("students", allStudents);
        }

        // 渲染结果到页面
        render("/student/search.html");
    }
//    public void search() {
//        String param = getPara("param"); // 从请求参数中获取关键字，默认为空字符串
//
//        if (param != null) {
//            // 调用带有模糊查询的分页方法
//            Page<Student> list = service.paginate(getParaToInt("pageNumber", 1), 5, param);
//
//            setAttr("list", list);
//            setAttr("param", param);
//        } else {
//            // 如果没有参数，显示所有学生列表
//            List<Student> allStudents = service.findAll();
//            setAttr("list", allStudents);
//        }
//
//        render("/student/search.html");
//    }

}


