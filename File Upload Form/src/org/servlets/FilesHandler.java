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

@WebServlet("/FilesHandler")
public class FilesHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String tempPath = System.getProperty("java.io.tmpdir");

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String actionParam = request.getParameter("action");

		switch (actionParam) {
		case "fileUpload":
			filesUpload(request, response);
			break;

		case "updateInformation":
			updateInformation(request, response);
			break;

		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String actionParam = request.getParameter("action");

		switch (actionParam) {

		case "listingImages":
			listingImages(request, response);
			break;
		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	public void filesUpload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("File will get uploaded to " + tempPath);

		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

		try {
			List<FileItem> files = upload.parseRequest(request);
			for (FileItem fileItem : files) {
				// On windows getName returns full file path
				String fileName = fileItem.getName();
				try {
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
				} catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
				}
				File file = new File(tempPath + fileName);

				if (!file.exists()) {
					new FilesDAO().addFileDetails(new Files(fileName));
					fileItem.write(file);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		listingImages(request, response);
	}

	public void listingImages(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Files> files = new FilesDAO().listFiles();
		request.setAttribute("files", files);
		request.setAttribute("path", tempPath);
		request.getRequestDispatcher("listFiles.jsp").forward(request, response);
	}

	public void updateInformation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int fileId = Integer.parseInt(request.getParameter("fileId"));
		String label = request.getParameter("label");
		String caption = request.getParameter("caption");
		new FilesDAO().udpateInformation(fileId, label, caption);
		listingImages(request, response);
	}
}