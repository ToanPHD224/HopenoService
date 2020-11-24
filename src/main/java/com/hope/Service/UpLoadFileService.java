package com.hope.Service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface UpLoadFileService {
		public int upFile(String dir,MultipartFile file);
}
