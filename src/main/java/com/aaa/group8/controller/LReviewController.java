package com.aaa.group8.controller;

import com.aaa.group8.entity.GAdmin;
import com.aaa.group8.service.LReviewService;
import com.aaa.group8.util.FtpConfig;
import com.aaa.group8.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Review")
public class LReviewController {

    @Autowired
    private LReviewService lReviewService;

    @Autowired
    private FtpUtil ftpUtil;

    //spring core io里面提供的资源加载器
    @Autowired
    private ResourceLoader resourceLoader;

    //引入配置类
    @Autowired
    private FtpConfig ftpConfig;

    @RequestMapping("save")
    public Object savePeople(@RequestBody Map map,HttpSession session) {
        System.out.println(map);
        //取出session中用户名
        GAdmin admin = (GAdmin)session.getAttribute("userSession");
        if (admin!=null){
            Integer ba_id=admin.getBa_id();
            System.out.println(ba_id);
            List<Map> info = lReviewService.getInfo(ba_id);
            System.out.println(info);
            System.out.println(info.size());
            if (info.size()==0){
                System.out.println(admin.getBa_id());

                map.put("ba_id",ba_id);
                //保存公司信息
                int i1 = lReviewService.saveCompany(map);
                //查询外键信息
                List<Map> company = lReviewService.findCompany(map);
                System.out.println(company.get(0));
                //获取外键
                Object bci_id = company.get(0).get("BCI_ID");
                System.out.println(bci_id);
                //保存到map中
                map.put("bci_id",bci_id);
                System.out.println(map);
                //保存法人信息
                int i = lReviewService.saveFaren(map);
                //保存贷款信息
                int i2 = lReviewService.saveLoan(map);
                return i+i1+i2;
            }
            return 1;
        }
        return 0;
//        return 1;
    }


    /**
     * 图片上传
     * @param headPic
     * @return
     */
    @RequestMapping("headPicUpload")
    public Object headPicUpload(@RequestParam MultipartFile headPic) {
        Map map = new HashMap();
        map.put("oldFileName", headPic.getOriginalFilename());
        map.put("newFileName", ftpUtil.upLoad(headPic));
        return map;
    }
    @RequestMapping("headPicUpload1")
    public Object headPicUpload1(@RequestParam MultipartFile headPic1) {
        Map map = new HashMap();
        map.put("oldFileName1", headPic1.getOriginalFilename());
        map.put("newFileName1", ftpUtil.upLoad(headPic1));
        return map;
    }
    @RequestMapping("headPicUpload2")
    public Object headPicUpload2(@RequestParam MultipartFile headPic2) {
        Map map = new HashMap();
        map.put("oldFileName2", headPic2.getOriginalFilename());
        map.put("newFileName2", ftpUtil.upLoad(headPic2));
        return map;
    }
    /**
     * 图片的显示方法
     * @param fileName
     * @return
     */
    @RequestMapping("show")
    public ResponseEntity show(String fileName){
        // ftp://userName:passWord@192.168.1.56/img/AFADSFADSFADSFASDFA3R4QAEF.jgp
        return ResponseEntity.ok(resourceLoader.getResource("ftp://"+ftpConfig.getFtpUserName()+":"+ftpConfig.getFtpPassWord()+"@"
                +ftpConfig.getRemoteIp()+ftpConfig.getRemotePath()+"/"+fileName));
    }
    /**
     * 文件下载
     * @param fileName
     * @param response
     */
    @RequestMapping("downLoadFile")
    public void downLoadFile(String fileName,String originalName, HttpServletResponse response){
        //调用封装好的下载方法
        ftpUtil.downLoad(fileName,response,originalName);
    }
}
