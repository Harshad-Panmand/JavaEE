import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyingFiles {
	private static String sourceFileName = "E:\\Harshad\\Git\\JavaEE\\XML parsing\\src\\WindchillOfficeApp.xml";

	public static void main(String[] args) throws IOException {
		Path destTempFile = Files.createTempFile("MyFile", ".xml");
		File windchillOfficeFile = new File(sourceFileName);
		Path sourceFile = windchillOfficeFile.toPath();

		System.out.println("Windchill source file " + sourceFile);
		System.out.println("temp file : " + destTempFile);

		Path copiedFile = Files.copy(sourceFile, destTempFile, StandardCopyOption.REPLACE_EXISTING);
		
		System.out.println(copiedFile);
	}
}
