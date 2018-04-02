package com.jankin.web.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public String hello(){
        return "hello";
    }

}
