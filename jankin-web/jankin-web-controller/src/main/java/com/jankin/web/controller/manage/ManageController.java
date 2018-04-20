package com.jankin.web.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Hello word
 *
 * @author 刘洋印
 * @date  2018/3/28 12:58
 */

@Controller
@RequestMapping("/manage")
public class ManageController {

    @RequestMapping("hello")
    public String hello(){
        return "index";
    }


    @RequestMapping("thymeleaf")
    @ResponseBody
    public String thymeleafTest(){
        //构造模板引擎
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        System.out.println(ManageController.class.getClassLoader().getParent());
        //模板所在目录，相对于当前classloader的classpath。
        resolver.setPrefix("templates/");
        //模板文件后缀
        resolver.setSuffix(".html");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        //构造上下文(Model)
        Context context = new Context();
        context.setVariable("name", "蔬菜列表");
        context.setVariable("array", new String[]{"土豆", "番茄", "白菜", "芹菜"});

        //渲染模板
        FileWriter write = null;
        try {
            write = new FileWriter("example.html");
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        templateEngine.process("example_template", context, write);
        return "success";
    }


}
