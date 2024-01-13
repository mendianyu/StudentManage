package com.men.student;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.men.common.model.Student;

import java.util.List;


/**
 * @author mendianyu
 */
public class StudentService
{

    private Student dao = new Student().dao();

    /**
     * 遍历学生列表
     */
    public Page<Student> paginate(int pageNumber, int pageSize)
    {
        return dao.paginate(pageNumber, pageSize, "select *", "from student order by id asc");
    }

    /**
     * 根据id查找
     */
    public Student findById(int id)
    {
        return dao.findById(id);
    }

    /**
     * 根据id删除
     */
    public void deleteById(int id)
    {
        dao.deleteById(id);
    }

    /**
     * 用户登录
     */
    public Student findUserByNameAndPassword(String account)
    {
        return dao.findFirst("select * from admin where account = ? ", account);
    }

    /**
     * 模糊查询
     */
    public List<Record> searchStudents(String keyword)
    {
        String sql = "select * from student where id like ? or name like ? or classes like ? or age like ? or sex like ? or tel like ?";
        keyword = "%" + keyword.trim() + "%";

        List<Record> students = Db.find(sql, keyword, keyword, keyword, keyword, keyword, keyword);
        return students;
    }

    public List<Student> findAll()
    {
        return dao.findAll();
    }


//    public Page<Student> paginate(int pageNumber, int pageSize, String keyword)
//    {
//        String select = "SELECT *";
//        String from = "FROM student";
//        String where = "WHERE id LIKE ? OR name LIKE ? OR classes LIKE ? OR age LIKE ? OR sex LIKE ? OR tel LIKE ?";
//        String orderBy = "ORDER BY id ASC";
//
//        // 处理关键字，如果为 null，则设为空字符串
//        keyword = (keyword != null) ? "%" + keyword.trim() + "%" : "";
//
//        // 构造带有条件的分页查询语句
//        String sql = select + " " + from + " " + where + " " + orderBy;
//
//        // 构造模糊查询的参数
//        Object[] params = {keyword, keyword, keyword, keyword, keyword, keyword};
//
//        // 调用 JFinal 的 paginate 方法进行分页查询
//        return dao.paginate(pageNumber, pageSize, select, from + " " + where, params, orderBy);
//    }

}
