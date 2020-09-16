package michael.code;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class Base64Test {

	public static void main(String[] args) throws Exception {
//		String base64Code =readImg("C:\\Users\\WL\\Desktop\\΢��ͼƬ_20200219193645.jpg");
		String base64Code = readImg("http://tzwjw.gaj.taizhou.gov.cn/files/103216/1710/y_25b2452411.png");
//        System.out.println(base64Code);
		decoderBase64File2(base64Code, "F:/picture/a.png");
	}

	public static void decoderBase64File(String base64Code, String targetPath) throws Exception {
		byte[] buffer = new sun.misc.BASE64Decoder().decodeBuffer(base64Code);
//		byte[] buffer = Base64.decodeBase64(base64Code);
		FileOutputStream out = new FileOutputStream(targetPath);
		out.write(buffer);
		out.close();
	}

	// local
	@SuppressWarnings("restriction")
	public static String encodeBase64File(String path) throws Exception {
		File file = new File(path);
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		return new sun.misc.BASE64Encoder().encode(buffer);
	}

	public static void decoderBase64File2(String base64Code, String targetPath) {
		// �ǵð�ͷ����ȡ��
		String str = base64Code.substring(base64Code.indexOf(',') + 1);
		// base64�ַ���ת��Ϊ��������
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		byte[] imageByte = new byte[0];
		try {
			imageByte = decoder.decodeBuffer(str);
			FileOutputStream out = new FileOutputStream(targetPath);
			out.write(imageByte);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	// all
	public static String readImg(String urlOrPath) {
		InputStream in = null;
		try {
			byte[] b;
			// ����https;����ͼƬ��Ҫ�ܿ�����֤�����֤��
			if (urlOrPath.toLowerCase().startsWith("https")) {
				b = HttpsUtils.doGet(urlOrPath);
			} else if (urlOrPath.toLowerCase().startsWith("http")) {
				// ����http;����ͼƬ
				URL url = new URL(urlOrPath);
				URLConnection openConnection = url.openConnection();
				openConnection.connect();
				in = new BufferedInputStream(openConnection.getInputStream());
//    			in = url.openStream();    			           	
			} else { // ���ر���·����ͼƬ
				File file = new File(urlOrPath);
				if (!file.isFile() || !file.exists() || !file.canRead()) {
//                    log.info("ͼƬ�����ڻ��ļ�����");
					System.out.println("ͼƬ�����ڻ��ļ�����");
					return "error";
				}
				in = new FileInputStream(file);
			}
			b = getByte(in); // ���÷������õ���������ֽ�����
			return base64ToStr(b); // ���÷�����Ϊ��ֹ�쳣 ���õ������Ľ��
			
		} catch (Exception e) {
//        	log.error("��ȡͼƬ�����쳣:"+ e);
			System.out.println("��ȡͼƬ�����쳣:" + e);
			return "error";
		}
	}

	public static byte[] getByte(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			byte[] buf = new byte[in.available()]; // ��������
			while ((in.read(buf)) != -1) { // ��ȡ�������е����ݷ��뻺�棬�����ȡ����ѭ������Ϊfalse;
				out.write(buf, 0, buf.length); // �����������е�����д��out������������Ҫд���ļ���ʹ�����������������
			}
			out.flush();
			byte[] data = out.toByteArray(); // ��������Ľ��ת��Ϊ�ֽ��������ʽ���� ����ִ��finally��ִ��return ��
			return data;
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	/*
	 * ���� Base64������Ϊ��Base64���ݴ��ͱ��뱻����������������е�8λ�ֽ�����Ϊһ�ֲ��ױ���ֱ��ʶ�����ʽ
	 */
	public static String base64ToStr(byte[] bytes) throws IOException {
		String content = "";
		content = new sun.misc.BASE64Encoder().encode(bytes);
		return content.trim().replaceAll("\n", "").replaceAll("\r", ""); // �����س��ͻ���
	}

}
