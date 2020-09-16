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
//		String base64Code =readImg("C:\\Users\\WL\\Desktop\\微信图片_20200219193645.jpg");
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
		// 记得把头给截取掉
		String str = base64Code.substring(base64Code.indexOf(',') + 1);
		// base64字符串转换为比特数组
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
			// 加载https途径的图片（要避开信任证书的验证）
			if (urlOrPath.toLowerCase().startsWith("https")) {
				b = HttpsUtils.doGet(urlOrPath);
			} else if (urlOrPath.toLowerCase().startsWith("http")) {
				// 加载http途径的图片
				URL url = new URL(urlOrPath);
				URLConnection openConnection = url.openConnection();
				openConnection.connect();
				in = new BufferedInputStream(openConnection.getInputStream());
//    			in = url.openStream();    			           	
			} else { // 加载本地路径的图片
				File file = new File(urlOrPath);
				if (!file.isFile() || !file.exists() || !file.canRead()) {
//                    log.info("图片不存在或文件错误");
					System.out.println("图片不存在或文件错误");
					return "error";
				}
				in = new FileInputStream(file);
			}
			b = getByte(in); // 调用方法，得到输出流的字节数组
			return base64ToStr(b); // 调用方法，为防止异常 ，得到编码后的结果
			
		} catch (Exception e) {
//        	log.error("读取图片发生异常:"+ e);
			System.out.println("读取图片发生异常:" + e);
			return "error";
		}
	}

	public static byte[] getByte(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			byte[] buf = new byte[in.available()]; // 缓存数组
			while ((in.read(buf)) != -1) { // 读取输入流中的数据放入缓存，如果读取完则循环条件为false;
				out.write(buf, 0, buf.length); // 将缓存数组中的数据写入out输出流，如果需要写到文件，使用输出流的其他方法
			}
			out.flush();
			byte[] data = out.toByteArray(); // 将输出流的结果转换为字节数组的形式返回 （先执行finally再执行return ）
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
	 * 编码 Base64被定义为：Base64内容传送编码被设计用来把任意序列的8位字节描述为一种不易被人直接识别的形式
	 */
	public static String base64ToStr(byte[] bytes) throws IOException {
		String content = "";
		content = new sun.misc.BASE64Encoder().encode(bytes);
		return content.trim().replaceAll("\n", "").replaceAll("\r", ""); // 消除回车和换行
	}

}
