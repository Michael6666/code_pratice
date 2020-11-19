package michael.gt.code;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class AHCADZYZ {

	public static void main(String[] args) throws Exception {
		try {
			
			/**
			 * 将单位名称转换为圆形签章图片示例
			 * 
			 * 参数说明：
			 * 单位名称，五角星下方文字，图片大小宽，图片大小高
			 * 
			 * 要求：系统必须支持 宋体 方正姚体 这两种字体
			 */
			
			//画一个圆形通用版的电子印章图片
			BufferedImage image = startGraphics2D("南京数字认证有限公司", "公章", 162, 162);

			//保存为base64
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			ImageIO.write(image, "png", stream);
			System.out.println(Base64.encode(stream.toByteArray()));
			
			//保存为文件
			ImageIO.write(image, "png", new File("D:/test.png"));

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;

	public static BufferedImage startGraphics2D(String yzName,
			String centerName, int destWidth, int destHeight) {

		BufferedImage buffImg = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		buffImg = g.getDeviceConfiguration().createCompatibleImage(WIDTH,
				HEIGHT, Transparency.TRANSLUCENT);
		g.dispose();
		g = buffImg.createGraphics();
		g.setColor(Color.RED);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int radius = WIDTH / 2 - 45;
		int CENTERX = WIDTH / 2;
		int CENTERY = HEIGHT / 2;
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(CENTERX, CENTERY, CENTERX + WIDTH / 2 - 30,
				CENTERY + WIDTH / 2 - 30);
		g.setStroke(new BasicStroke(12f));
		g.draw(circle);
		FontMetrics fm = g.getFontMetrics(new Font("宋体", Font.BOLD,
				WIDTH / 3 + 10));
		int textWidth = fm.stringWidth("★");
		int widthX = (WIDTH - textWidth) / 2;
		g.setFont(new Font("宋体", Font.BOLD, WIDTH / 3 + 10));
		g.drawString("★", widthX, CENTERY + (135 / 3));
		Map<TextAttribute, Object> fontmap0 = new HashMap<TextAttribute, Object>();
		fontmap0.put(TextAttribute.FAMILY, "宋体");
		fontmap0.put(TextAttribute.SIZE, 50);
		fontmap0.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_ULTRABOLD);
		fontmap0.put(TextAttribute.WIDTH, 0.7f);
		Font font0 = new Font(fontmap0);
		g.setFont(font0);
		
		
		
		g.drawString(centerName, CENTERX - (centerName.length()*20 -5 ), CENTERY + (150));

		String[] messages2 = yzName.split("", 0);
		String[] messages = new String[messages2.length - 1];
		System.arraycopy(messages2, 1, messages, 0, messages2.length - 1);

		int ilength = messages.length;
		int fontsize = 80;
		int z = yzName.length();
		String fontFamily = "宋体";
		if (z >= 12) {
			fontFamily = "方正姚体";
		}
		float z1 = 0.5f;
		float z2 = 0.5f;
		float z3 = 0.8f;
		float z4 = 10.0f;
		switch (z) {
		case 6:
			z = -30;
			z1 = 0.65f;
			z2 = 0.35f;
			break;
		case 7:
			z = -15;
			z1 = 0.15f;
			z2 = -0.05f;
			z4 = -10f;
			break;
		case 8:
			z = -10;
			z1 = 0.55f;
			z2 = 0.45f;
			break;
		case 9:
			z = 0;
			z1 = 0.05f;
			z2 = 0.05f;
			z4 = -5f;
			break;
		case 10:
			z = 5;
			z1 = 0.5f;
			z2 = 0.5f;
			break;
		case 11:
			z = 12;
			z1 = -0.05f;
			z2 = 0.2f;
			break;
		case 12:
			z = 15;
			z1 = 0.4f;
			z2 = 0.6f;
			break;
		case 13:
			z = 22;
			z1 = -0.1f;
			z2 = 0.3f;
			break;
		case 14:
			z = 15;
			z1 = 0.35f;
			z2 = 0.65f;
			z3 = 0.7f;
			break;
		case 15:
			z = 29;
			z1 = -0.15f;
			z2 = 0.3f;
			break;
		case 16:
			z = 20;
			z1 = 0.3f;
			z2 = 0.7f;
			z3 = 0.7f;
			break;
		case 17:
			z = 25;
			z1 = -0.15f;
			z2 = 0.3f;
			z3 = 0.7f;
			break;
		case 18:
			z = 18;
			z1 = 0.35f;
			z2 = 0.65f;
			z3 = 0.6f;
			break;
		case 19:
			z = 20;
			z1 = -0.15f;
			z2 = 0.3f;
			z3 = 0.6f;
			break;
		case 20:
			z = 20;
			z1 = 0.35f;
			z2 = 0.65f;
			z3 = 0.6f;
			break;
		case 21:
			z = 22;
			z1 = -0.2f;
			z2 = 0.3f;
			z3 = 0.6f;
			break;
		case 22:
			z = 15;
			z1 = 0.3f;
			z2 = 0.7f;
			z3 = 0.5f;
			break;
		case 23:
			z = 16;
			z1 = -0.2f;
			z2 = 0.3f;
			z3 = 0.5f;
			break;
		case 24:
			fontsize = 75;
			z = 14;
			z1 = 0.3f;
			z2 = 0.7f;
			z3 = 0.5f;
			break;
		case 25:
			fontsize = 75;
			z = 16;
			z1 = -0.2f;
			z2 = 0.3f;
			z3 = 0.5f;
			break;
		case 26:
			fontsize = 75;
			z = 15;
			z1 = 0.3f;
			z2 = 0.7f;
			z3 = 0.5f;
			break;
		case 27:
			fontsize = 75;
			z = 16;
			z1 = -0.2f;
			z2 = 0.3f;
			z3 = 0.5f;
			break;
		case 28:
			fontsize = 70;
			z = 14;
			z1 = 0.3f;
			z2 = 0.7f;
			z3 = 0.5f;
			break;
		case 29:
			fontsize = 70;
			z = 16;
			z1 = -0.2f;
			z2 = 0.3f;
			z3 = 0.5f;
			z4 = 5f;
			break;
		case 30:
			fontsize = 70;
			z = 16;
			z1 = 0.1f;
			z2 = 0.9f;
			z3 = 0.5f;
		case 31:
			fontsize = 70;
			z = 16;
			z1 = -0.2f;
			z2 = 0.3f;
			z3 = 0.5f;
			z4 = 5f;
			break;
		case 32:
			fontsize = 60;
			z = 9;
			z1 = 0.4f;
			z2 = 0.6f;
			z3 = 0.5f;
			break;
		case 33:
			fontsize = 60;
			z = 11;
			z1 = -0.2f;
			z2 = 0.3f;
			z3 = 0.5f;
			z4 = 5f;
			break;
		case 34:
			fontsize = 55;
			z = 9;
			z1 = 0.35f;
			z2 = 0.65f;
			z3 = 0.5f;
			break;
		case 35:
			fontsize = 55;
			z = 9;
			z1 = -0.2f;
			z2 = 0.3f;
			z3 = 0.5f;
			z4 = 5f;
			break;
		case 36:
			fontsize = 55;
			z = 9;
			z1 = 0.35f;
			z2 = 0.65f;
			z3 = 0.5f;
			break;
		case 37:
			fontsize = 55;
			z = 9;
			z1 = -0.2f;
			z2 = 0.3f;
			z3 = 0.5f;
			z4 = 5f;
			break;
		case 38:
			fontsize = 50;
			z = 6;
			z1 = 0.3f;
			z2 = 0.7f;
			z3 = 0.5f;
			break;
		case 39:
			fontsize = 50;
			z = 7;
			z1 = -0.4f;
			z2 = 0.3f;
			z3 = 0.5f;
			z4 = 5f;
			break;
		case 40:
			fontsize = 50;
			z = 7;
			z1 = 0.3f;
			z2 = 0.7f;
			z3 = 0.5f;
			break;
		}
		Map<TextAttribute, Object> fontmap = new HashMap<TextAttribute, Object>();
		fontmap.put(TextAttribute.FAMILY, fontFamily);
		fontmap.put(TextAttribute.SIZE, fontsize);
		fontmap.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_ULTRABOLD);
		fontmap.put(TextAttribute.WIDTH, z3);
		Font f = new Font(fontmap);
		FontRenderContext context = g.getFontRenderContext();
		Rectangle2D bounds = f.getStringBounds(yzName, context);
		double char_interval = (bounds.getWidth() / ilength) - z;
		double ascent = -bounds.getY();
		int first = 0, second = 0;
		boolean odd = false;
		if (ilength % 2 == 1) {
			first = (ilength - 1) / 2;
			odd = true;
		} else {
			first = (ilength) / 2 - 1;
			second = (ilength) / 2;
			odd = false;
		}
		double radius2 = radius - ascent;
		double x0 = CENTERX;
		double y0 = CENTERY - radius + ascent;
		double a = 2 * Math.asin(char_interval / (2 * radius2));
		if (odd) {
			g.setFont(f);
			g.drawString(messages[first],
					(float) (x0 - char_interval / 2) - z4, (float) y0);
			for (int i = first + 1; i < ilength; i++) {
				double aa = (i - first + z1) * a;
				double ax = radius2 * Math.sin(aa);
				double ay = radius2 - radius2 * Math.cos(aa);
				AffineTransform transform = AffineTransform
						.getRotateInstance(aa);
				Font f2 = f.deriveFont(transform);
				g.setFont(f2);
				g.drawString(messages[i], (float) (x0 + ax - char_interval / 2
						* Math.cos(aa)), (float) (y0 + ay - char_interval / 2
						* Math.sin(aa)));
			}
			for (int i = first - 1; i > -1; i--) {
				double aa = (first - i + z2) * a;
				double ax = radius2 * Math.sin(aa);
				double ay = radius2 - radius2 * Math.cos(aa);
				AffineTransform transform = AffineTransform
						.getRotateInstance(-aa);
				Font f2 = f.deriveFont(transform);
				g.setFont(f2);
				g.drawString(messages[i], (float) (x0 - ax - char_interval / 2
						* Math.cos(aa)), (float) (y0 + ay + char_interval / 2
						* Math.sin(aa)));
			}

		} else {
			for (int i = second; i < ilength; i++) {
				double aa = (i - second + z1) * a;
				double ax = radius2 * Math.sin(aa);
				double ay = radius2 - radius2 * Math.cos(aa);
				AffineTransform transform = AffineTransform
						.getRotateInstance(aa);
				Font f2 = f.deriveFont(transform);
				g.setFont(f2);
				g.drawString(messages[i], (float) (x0 + ax - char_interval / 2
						* Math.cos(aa)), (float) (y0 + ay - char_interval / 2
						* Math.sin(aa)));
			}
			for (int i = first; i > -1; i--) {
				double aa = (first - i + z2) * a;
				double ax = radius2 * Math.sin(aa);
				double ay = radius2 - radius2 * Math.cos(aa);
				AffineTransform transform = AffineTransform
						.getRotateInstance(-aa);
				Font f2 = f.deriveFont(transform);
				g.setFont(f2);
				g.drawString(messages[i], (float) (x0 - ax - char_interval / 2
						* Math.cos(aa)), (float) (y0 + ay + char_interval / 2
						* Math.sin(aa)));
			}
		}

		if (destWidth != WIDTH || destHeight != HEIGHT) {
			buffImg = scale(buffImg, destWidth, destHeight);
		}

		return buffImg;
	}

	private static BufferedImage scale(BufferedImage bi, int destImgW,
			int destImgH) {
		try {
			int narrowImgW;
			int narrowImgH;
			int srcImgW = bi.getWidth();
			int srcImgH = bi.getHeight();
			if ((float) srcImgW / srcImgH > (float) destImgW / destImgH) {
				narrowImgW = (int) (((float) destImgH / (float) srcImgH) * srcImgW);
				narrowImgH = destImgH;
				BufferedImage narrowImg = new BufferedImage(narrowImgW,
						narrowImgH, Transparency.TRANSLUCENT);
				narrowImg.getGraphics().drawImage(
						bi.getScaledInstance(narrowImgW, narrowImgH,
								Image.SCALE_SMOOTH), 0, 0, null);
				Image image = narrowImg.getScaledInstance(narrowImgW,
						narrowImgH, Image.SCALE_DEFAULT);
				CropImageFilter cropFilter = new CropImageFilter(0, 0,
						narrowImgW, destImgH);
				Image img = Toolkit.getDefaultToolkit().createImage(
						new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage cutRightNarrowImg = new BufferedImage(narrowImgW,
						destImgH, Transparency.TRANSLUCENT);
				Graphics g = cutRightNarrowImg.getGraphics();
				g.drawImage(img, 0, 0, null);
				g.dispose();
				return cutRightNarrowImg;
			} else {
				narrowImgW = destImgW;
				narrowImgH = (int) (((float) destImgW / (float) srcImgW) * srcImgH);
				BufferedImage narrowImg = new BufferedImage(narrowImgW,
						narrowImgH, Transparency.TRANSLUCENT);
				narrowImg.getGraphics().drawImage(
						bi.getScaledInstance(narrowImgW, narrowImgH,
								Image.SCALE_SMOOTH), 0, 0, null);
				Image image = narrowImg.getScaledInstance(narrowImgW,
						narrowImgH, Image.SCALE_DEFAULT);// 等比例压缩  
				CropImageFilter cropFilter1 = new CropImageFilter(0, 0,
						narrowImgW, destImgH);
				Image img1 = Toolkit.getDefaultToolkit()
						.createImage(
								new FilteredImageSource(image.getSource(),
										cropFilter1));
				BufferedImage cutBottomNarrowImg1 = new BufferedImage(
						narrowImgW, destImgH, Transparency.TRANSLUCENT);
				Graphics g = cutBottomNarrowImg1.getGraphics();
				g.drawImage(img1, 0, 0, null);
				g.dispose();
				return cutBottomNarrowImg1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}