package com.men.index;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.men.common.model.Student;
import com.men.student.StudentService;

/**
 * @author mendianyu
 */
public class IndexController extends Controller
{

    StudentService service = new StudentService();

    //前台渲染登录界面
    public void index()
    {
        render("index.html");
    }

    /**
     * 用户登录验证
     */
    @ActionKey("/login")
    public void login()
    {
        //获取用户输入的账号和密码
        String account = getPara("account");
        String password = getPara("password");

        //从数据库中获取数据
        Student userMassage = service.findUserByNameAndPassword(account);

        //验证用户名和密码是否正确
        if (userMassage != null)
        {
            if (password.equals(userMassage.getStr("password")))
            {
                setSessionAttr("loginUser", userMassage);
                redirect("/student");
            } else
            {
                setAttr("errorMsg", "用户名或密码错误,请重新输入。");
                render("index.html");
                return;
            }
        } else
        {
            setAttr("errorMsg", "该用户名不存在,请重新输入。");
            render("index.html");
            return;
        }
    }

    /**
     * 用户退出
     */
    @ActionKey("logout")
    public void logout()
    {
        getSession().removeAttribute("loginUser");
        render("index.html");
    }
}



