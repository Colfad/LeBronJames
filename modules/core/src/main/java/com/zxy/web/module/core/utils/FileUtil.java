package com.zxy.web.module.core.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件的操作
 * 
 * @author James
 * 
 */
public class FileUtil {
	private static final int BUFFER_SIZE = 50 * 1024;// 缓冲区大小

	private static Logger log = LoggerFactory.getLogger(FileUtil.class);

	private static boolean copyFile(File from, File to) {
		boolean isSuccess = false;
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(from), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(to),
					BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			while (in.read(buffer) > 0) {
				out.write(buffer);
			}
			isSuccess = true;
		} catch (Exception e) {
			isSuccess = false;
			log.error(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}

		}

		return isSuccess;
	}

	private static boolean copyFileByLines(File from, File to) {
		boolean isSuccess = false;
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new FileReader(from));
			out = new BufferedWriter(new FileWriter(to));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = in.readLine()) != null) {
				// 显示行号
				
				if (tempString.indexOf("com.vortex.ydhw.dataaccess.service.impl.UploadDataServiceImpl") != -1) {
					out.write(tempString + "\r\n");
					System.out.println("line " + line + ": " + tempString);
				}

				line++;
			}
			isSuccess = true;
		} catch (Exception e) {
			isSuccess = false;
			log.error(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}

		}

		return isSuccess;
	}

	/**
	 * 复制文件到指定的地方
	 * 
	 * @param fromPathname
	 *            源文件
	 * @param toPathname
	 *            指定的文件
	 * @return
	 */
	public static boolean copyFile(String fromPathname, String toPathname) {
		File from = new File(fromPathname);
		File to = new File(toPathname);
		try {

			if (!from.exists()) {
				from.createNewFile();
			}
			if (!to.exists()) {
				to.createNewFile();
			}
//			return copyFile(from, to);
			return copyFileByLines(from, to);
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除文件夹下的所有文件
	 * 
	 * @param folderFullPath
	 *            = null 或 "" 都删除默认临时目录
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteAllFile(String folderFullPath) throws Exception {
		boolean ret = false;
		if (folderFullPath == null || "".equals(folderFullPath)) {
			return ret;
		}
		try {
			File file = new File(folderFullPath);
			if (file.exists()) {
				if (file.isDirectory()) {
					File[] fileList = file.listFiles();
					for (int i = 0; i < fileList.length; i++) {
						String filePath = fileList[i].getPath();
						deleteAllFile(filePath);
					}
				}
				if (file.isFile()) {
					file.delete();
				}
			}
			ret = true;
		} catch (Exception e) {
			ret = false;
			e.printStackTrace();
		}

		return ret;
	}

    /**
     *
     * 获得文件的后缀名，统一小写，为了以后在数据库中查找MIMETYPE类型而准备的
     *
     * @param fileName
     * @return
     */
    public static String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1) {
            fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
        }

        return fileName.toLowerCase();
    }

	public static void main(String[] args) {
		//copyFile("C:\\Users\\dejunx\\Desktop\\ydhw-deploy\\ydhw-dataserver.log.2012-08-25","D:\\test20120827.txt");
        String fileName = "james.png.JPG";

        System.out.println(getFileExtension(fileName));
	}
}
