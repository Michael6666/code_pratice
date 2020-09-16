package michael.code;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import sun.misc.BASE64Encoder;

public class Base64Test {

	public static void main(String[] args) throws Exception {
//		String base64Code =encodeBase64File("E:/code/jsgaosp-manage/jsgaosp-manage-web/src/main/webapp/app/img/lg.png");
		String base64Code =readImg("http://tzwjw.gaj.taizhou.gov.cn/files/103216/1710/y_98c2452455.JPG");
        System.out.println(base64Code);
        decoderBase64File(base64Code, "D:/picture/a.png");
	}

	public static void decoderBase64File(String base64Code,String targetPath) throws Exception {
        byte[] buffer = new sun.misc.BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }
	
	//local
	public static String encodeBase64File(String path) throws Exception {
        File  file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new sun.misc.BASE64Encoder().encode(buffer);
    }
	
	//all
	/*
	 * ��ȡԶ�̺ͱ����ļ�ͼƬ
	 */
	public static String readImg(String urlOrPath){
        InputStream in = null;
        try {
          byte[] b ;
       //����https;����ͼƬ��Ҫ�ܿ�����֤�����֤��
         if(urlOrPath.toLowerCase().startsWith("https")){
            b=HttpsUtils.doGet(urlOrPath);
         }else if(urlOrPath.toLowerCase().startsWith("http")){ 
          //����http;����ͼƬ
            	URL url = new URL(urlOrPath);
            	URLConnection openConnection = url.openConnection();
    			in = openConnection.getInputStream();
//    			in = url.openStream();    			           	
            }else{ //���ر���·����ͼƬ
                File file = new File(urlOrPath);
                if(!file.isFile() || !file.exists() || !file.canRead()){
//                    log.info("ͼƬ�����ڻ��ļ�����");
                	System.out.println("ͼƬ�����ڻ��ļ�����");
                    return "error";
                }                
                in = new FileInputStream(file);
            }
            b = getByte(in); //���÷������õ���������ֽ�����
			return base64ToStr(b);    //���÷�����Ϊ��ֹ�쳣 ���õ������Ľ��
 
        } catch (Exception e) {
//        	log.error("��ȡͼƬ�����쳣:"+ e);
        	System.out.println("��ȡͼƬ�����쳣:"+ e);
        	return "error";
        }
    }
	
	public static byte[] getByte(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();		
		try {
			byte[] buf=new byte[1024]; //��������
			while(in.read(buf)!=-1){ //��ȡ�������е����ݷ��뻺�棬�����ȡ����ѭ������Ϊfalse;
				out.write(buf); //�����������е�����д��out������������Ҫд���ļ���ʹ�����������������
				}
			out.flush();
			return out.toByteArray();	//��������Ľ��ת��Ϊ�ֽ��������ʽ����	����ִ��finally��ִ��return	��
		} finally{
			if(in!=null){
					in.close();
			}
			if(out!=null){
				out.close();
			}			
		}
	}
	
	/*
	 * ����
	 * Base64������Ϊ��Base64���ݴ��ͱ��뱻����������������е�8λ�ֽ�����Ϊһ�ֲ��ױ���ֱ��ʶ�����ʽ
	 */
	public static String base64ToStr(byte[] bytes) throws IOException {
		String content = "";
		content = new BASE64Encoder().encode(bytes);
		return content.trim().replaceAll("\n", "").replaceAll("\r", ""); //�����س��ͻ���
	}


}
