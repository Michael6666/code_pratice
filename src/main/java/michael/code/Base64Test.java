package michael.code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Base64Test {

	public static void main(String[] args) throws Exception {
		String base64Code =encodeBase64File("E:/code/jsgaosp-manage/jsgaosp-manage-web/src/main/webapp/app/img/lg.png");
        System.out.println(base64Code);
        decoderBase64File(base64Code, "D:/picture/a.jpg");
	}

	public static void decoderBase64File(String base64Code,String targetPath) throws Exception {
        byte[] buffer = new sun.misc.BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }
	
	public static String encodeBase64File(String path) throws Exception {
        File  file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new sun.misc.BASE64Encoder().encode(buffer);
    }

}
