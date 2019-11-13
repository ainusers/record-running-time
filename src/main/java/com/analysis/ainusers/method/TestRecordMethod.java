package com.analysis.ainusers.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: tianyong
 * @date: 2019/11/12 13:55
 * @desciption:测试api接口
 */
@Controller
@RequestMapping("/api")
public class TestRecordMethod {

    @Record
    @RequestMapping("/testRecordMethod")
    public void testRecordMethod() {
        System.out.println("testRecordMethod...");
    }

}
