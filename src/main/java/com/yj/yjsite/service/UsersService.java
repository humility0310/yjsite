package com.yj.yjsite.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yj.yjsite.repository.UsersDao;
import com.yj.yjsite.vo.UsersVo;

@Service
public class UsersService {
	private static final String SAVE_PATH = "/upload";
	// private static final String URL = "/gallery/assets/";

	@Autowired
	UsersDao usersDao;

	public void join(UsersVo vo) {
		usersDao.join(vo);
	}

	public boolean checkId(String id) {
		return (usersDao.checkId(id) != null);
	}
	
	
	public void modify(UsersVo vo){
		usersDao.modify(vo);
	}
	
	public UsersVo login(UsersVo vo){
		return usersDao.login(vo);
	}
	

	public String restore(MultipartFile multipartFile) {
		// String url = "";
		String saveFileName = null;
		try {
			/*
			 * if (multipartFile.isEmpty() == true) { //return url; }
			 */

			String originalFileName = multipartFile.getOriginalFilename();
			String extName = originalFileName.substring(originalFileName.lastIndexOf('.') + 1,
					originalFileName.length());
			saveFileName = generateSaveFileName(extName);
			Long fileSize = multipartFile.getSize();

			System.out.println("###originalFileName####" + originalFileName);
			System.out.println("###extName####" + extName);
			System.out.println("###saveFileName####" + saveFileName);
			System.out.println("###fileSize####" + fileSize);

			writeFile(multipartFile, saveFileName);

			// url = URL + saveFileName;
			System.out.println("file write commit");
			
		} catch (IOException ex) {
			// throw new UploadFileException( "write file" );
			// log 남기기
			throw new RuntimeException("upload file");
		}

		// return url;
		return saveFileName;
	}

	private void writeFile(MultipartFile multipartFile, String saveFileName) throws IOException {
		System.out.println("into write file");
		byte[] fileData = multipartFile.getBytes();
		System.out.println("1111111");
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		System.out.println("222222");
		fos.write(fileData);
		System.out.println("3333333333");
		fos.close();
		System.out.println("444444444444");
	}

	private String generateSaveFileName(String extName) {
		String fileName = "";
		Calendar calendar = Calendar.getInstance();

		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += ("." + extName);

		return fileName;
	}
	
	//-----------------------JSON Test----------------------------
	public UsersVo getUsersInfo(String id){
		return usersDao.getUsersInfo(id);
	}
	//-----------------------JSON List----------------------------
	public List<UsersVo> getList(){
		return usersDao.getList();
	}
}
