package com.hope.ServiceImpl;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hope.Service.UpLoadFileService;
@Service
public class UploadFileServiceImpl implements UpLoadFileService {
	
	
	@Override
	public int upFile(String dir, MultipartFile file,HttpServletRequest request) {
		File file1 = new File(this.getFolderUpload(dir), file.getOriginalFilename());
		if(file.getSize() >= 52428800)
		{
			return 0;
		}
        if (!file1.exists()) {
            if (file1.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        try {
			try {
				file.transferTo(new File(file1.getAbsolutePath()));
			} catch (IOException e) {
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
	public File getFolderUpload(String dir) {
	    File folderUpload = new File("C:\\Users\\84911\\Desktop\\DoAnTotNghiep\\HopenoService\\src\\main\\webapp\\resources\\image\\dir\\");
	    if (!folderUpload.exists()) {
	      folderUpload.mkdirs();
	    }
	    return folderUpload;
	  }

}
