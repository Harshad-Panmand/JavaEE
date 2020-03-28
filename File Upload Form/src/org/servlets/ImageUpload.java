package org.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hibernate.DAO.FilesDAO;
import com.hibernate.entity.Files;

@WebServlet("/ImageUpload")
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		System.out.println("File will get uploaded to " + System.getProperty("java.io.tmpdir"));
		try {
			List<FileItem> files = upload.parseRequest(request);
			for (FileItem file : files) {
				// On windows getName returns full file path
				String fileName = file.getName();
				try {
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
				} catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
				}

				new FilesDAO().addFileDetails(new Files(fileName));
				file.write(new File(System.getProperty("java.io.tmpdir") + fileName));
				System.out.println(fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
