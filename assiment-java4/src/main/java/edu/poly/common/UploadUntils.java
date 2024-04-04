package edu.poly.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

public class UploadUntils {
	public static String processUploadField(String fieldName, HttpServletRequest request, String storedFolder,
			String storedFilename) throws IOException, ServletException {
		Part filePart = request.getPart(fieldName);

		if (filePart == null || filePart.getSize() == 0) {
			return "";
		}

		if (storedFolder == null) {
			storedFolder = "/uploads"; // (/images)
		}

		if (storedFilename == null) {
			storedFilename = Path.of(filePart.getSubmittedFileName()).getFileName().toString();
		} else {
			storedFilename += "." + FilenameUtils.getExtension(Path.of(filePart.getSubmittedFileName()).toString());
		}

		String uploadFolder = request.getServletContext().getRealPath(storedFolder);

		Path uploadPath = Paths.get(uploadFolder);

		if (!Files.exists(uploadPath)) {
			Files.createDirectory(uploadPath);
		}
		filePart.write(Paths.get(uploadPath.toString(), storedFilename).toString());

		return storedFilename;
	}
}
