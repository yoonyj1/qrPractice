package com.kh.qrPractice.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.kh.qrPractice.model.service.QRService;
import com.kh.qrPractice.model.vo.QR;
@Controller
public class QrCodeController {
	
	@Autowired
	private QRService qService;
	
	@RequestMapping("login.do")
	public String loginMember(String id, String pwd, Model m) {
		QR q = new QR();
		
		q.setId(id);
		q.setPwd(pwd);
		
		QR qr = qService.loginMember(q);
		
		if (qr != null) {
			m.addAttribute("loginUser", qr);
		}
		return "qrTest";
	}
	 
    @RequestMapping("test.qr")
    public Object createQr(@RequestParam String url) throws WriterException, IOException {
        int width = 200;
        int height = 200;
        BitMatrix matrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height);
 
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            MatrixToImageWriter.writeToStream(matrix, "PNG", out);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(out.toByteArray());
        }
    }
    
    
    

	@RequestMapping("result.att")
	public String resultAt(String id) {
	System.out.println(id);
	  int result = qService.resultAt(id);
	  
	  if(result > 0) {
		  System.out.println("성공? " + result);
		  return "redirect:/";
	  }
	  System.out.println(result);
	  return "redirect:/";
	}
	 
}