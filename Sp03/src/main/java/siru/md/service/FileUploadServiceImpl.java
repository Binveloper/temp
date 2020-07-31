package siru.md.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import siru.md.filesetting.Path;

@Log4j
@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Override
	public String saveStore(MultipartFile f) {
		String ofname = f.getOriginalFilename();
		int idx = ofname.lastIndexOf(".");
		String ofheader = ofname.substring(0, idx);
		String ext = ofname.substring(idx);
		long ms = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		sb.append(ofheader); //file �̸�
		sb.append("_"); 
		sb.append(ms); //�ð�
		sb.append(ext); //Ȯ���� (idx���� ������) ex) .jpg .png
		String saveFileName = sb.toString(); //StringBuilder�� �޼ҵ�.. ������� ���ڿ����� �����ִ� ��
		long fsize = f.getSize();
		
		//log.info("#Service ofname: " + ofname + ", saveFileName: " + saveFileName + ", fsize: " + fsize);
		
		boolean flag = writeFile(f, saveFileName);
		if(flag) {
			log.info("���ε� ����");
		}else{
			log.info("���ε� ����");
		}
		// return Path.FILE_STORE + saveFileName;
		return saveFileName;
	}

	@Override
	public boolean writeFile(MultipartFile f, String saveFileName) {
		File dir = new File(Path.FILE_STORE);
		if(!dir.exists()) dir.mkdirs();
		FileOutputStream fos = null;
		try {
			byte data[] = f.getBytes();
			fos = new FileOutputStream(Path.FILE_STORE + saveFileName);
			fos.write(data);
			fos.flush();
			
			return true;
		}catch(IOException ie) {
			return false;
		}finally {
			try {
				fos.close();
			}catch(IOException ie) {}
		}
	}

}
/*

File.mkdir()

������� �ϴ� ���丮�� ���� ���丮�� �������� ���� ���, ���� �Ұ�

C:\base\want

want ���丮�� ������� �ϴµ�, base ���丮�� ���� ���, ���� �Ұ�

--------------------------------------------------------------
File.mkdirs()

������� �ϴ� ���丮�� ���� ���丮�� �������� ���� ���, ���� ���丮���� ����

C:\base\want

want ���丮�� ������� �ϴµ�, base ���丮�� ���� ���, base ���丮���� ����

*/