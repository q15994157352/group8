package com.aaa.group8.controller;

import com.aaa.group8.service.ErChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("ercharts")
public class EchartsController {
    @Autowired(required = false)
    private ErChartsService erChartsService;
    /**
     *获取统计数据
     * @param map
     * @return
     */
    @RequestMapping("getData")
    public Object getData(@RequestParam Map map){
        return  erChartsService.getData(map);
    }
}
