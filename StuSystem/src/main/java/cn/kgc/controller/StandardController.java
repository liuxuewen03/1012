package cn.kgc.controller;

import cn.kgc.pojo.Standard;
import cn.kgc.service.StandardService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2020-10-12 14:44
 */
@Controller
public class StandardController {
    @Resource
    StandardService standardService;
    private Standard standard;
    private MultipartFile packagePath2;
    private HttpSession session;

    @RequestMapping("/")
    public String toIndex(String zhname, String pageNumStr, Model model) {
        if (zhname == null) {
            zhname = "";
        }
        Integer pageNum = 1;
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }
        int pageSize = 5;
        PageInfo<Standard> standardPageInfo = standardService.selectByZhname(zhname, pageNum, pageSize, pageNumStr);
        model.addAttribute("standardPageInfo", standardPageInfo);
        return "jsp/index";
    }

    @RequestMapping("toadd")
    public String toadd() {
        return "jsp/add";
    }

    @RequestMapping("doadd")
    public String doadd(Standard standard, MultipartFile packagePath2, HttpSession session) {
        String realPath = session.getServletContext().getRealPath("statics/images");
        String originalFilename = packagePath2.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);
        String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "." + extension;
        File file = new File(realPath, fileName);
        try {
            packagePath2.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        standard.setPackagePath(fileName);
        standardService.insert(standard);
        return "redirect:/";
    }

    @RequestMapping("toupd/{id}")
    public String toupd(@PathVariable int id, Model model) {
        Standard standard = standardService.selectById(id);
        model.addAttribute("standard", standard);
        System.out.println(standard.getImplDate());
        return "jsp/upd";
    }

    @RequestMapping("doupd")
    public String doupd(Standard standard) {
        standardService.update(standard);
        return "redirect:/";
    }
    @RequestMapping("/del")
    @ResponseBody
    public Map<String,Object> del(@RequestParam("arr[]")Integer[] arr){
        Map<String,Object> map=new HashMap<>();
        int del = standardService.del(arr);
        if (del>0){
            map.put("success","true");
        }else{
            map.put("success","false");
        }
        return map;
    }
}
