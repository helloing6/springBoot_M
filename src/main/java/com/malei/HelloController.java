package com.malei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {


    @RequestMapping(value={"/hello","/hi"},method= RequestMethod.GET)
    public String say(){
        return "Hello malei";
    }


    @RequestMapping(value="/helloByPost",method= RequestMethod.POST)
    public String helloByPost(){
        return "Hello malei "+"post ";
    }

    @RequestMapping(value="/helloByPost/{id}",method= RequestMethod.GET)
    public String hello2(@PathVariable("id") Integer id){
        return "Hello malei "+ id ;
    }

    @RequestMapping(value="/hello3",method= RequestMethod.GET)
    public String hello3(@RequestParam("id") Integer id){
        return "Hello malei "+ id ;
    }

    @GetMapping(value="/hello4")
    public String hello4(@RequestParam("id") Integer id){
        return "Hello malei "+ id ;
    }

}
