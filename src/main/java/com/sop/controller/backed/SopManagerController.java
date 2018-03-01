package com.sop.controller.backed;



import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sop.common.ServerResponse;
import com.sop.service.ISopService;

@Controller
@RequestMapping("/manage")
public class SopManagerController {

	@Autowired
	private ISopService iSopService;
	
@RequestMapping(value="upload_file.do")
@ResponseBody
public ServerResponse uploadFileAndInsertDesc(@RequestParam(value = "upload_file",required = false)
		MultipartFile file,HttpServletRequest request,HttpServletResponse response,String buMen,String xiTong){
				if(!file.isEmpty()){
					String fileName = file.getOriginalFilename();
					String path = "/home/wwenjie/文档/sop/";
					File destFile = new File(path);
					try {
						file.transferTo(new File(path+File.separator+fileName));
						return iSopService.saveFile(fileName, buMen, xiTong);
					} catch (IOException e) {
						e.printStackTrace();
						return ServerResponse.createBySuccessMessage("上传失败！");
					}
				}else{
					return ServerResponse.createBySuccessMessage("文件为空，上传失败！");
				}
	}	
@RequestMapping(value="download_file.do")
@ResponseBody
public ResponseEntity<byte[]> download(HttpServletRequest request,@RequestParam("filename") String filename,Model model) throws Exception{
		String path = "/home/wwenjie/文档/sop/";
		File file =new File(path+File.separator+filename);
		HttpHeaders headers = new HttpHeaders();
		String downloadFileName = new String(filename.getBytes("utf-8"),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", downloadFileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}

}
