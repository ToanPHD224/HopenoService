package com.hope.ServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hope.Service.UpLoadFileService;
@Service
public class UploadFileServiceImpl implements UpLoadFileService {
	

	@Override
	public int upFile(String dir, MultipartFile file,HttpServletRequest request) {
		
		System.out.println(file.getSize());
		if(file.getSize() >= 52428800)
		{
			return 0;
		}
        try {
			try {
				file.transferTo(new File(this.getFolderUpload(dir,request), file.getOriginalFilename()));
				return 1;
			} catch (/*IOException*/ Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
	public File getFolderUpload(String dir,HttpServletRequest request) {
		String rootDir=request.getSession().getServletContext().getRealPath("/");
	    File folderUpload = new File(rootDir+"\\resources\\image\\"+dir);
	    System.out.println(folderUpload);
	    if (!folderUpload.exists()) {
	      folderUpload.mkdirs();
	    }
	    return folderUpload;
	  }

}
