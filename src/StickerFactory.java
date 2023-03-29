import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerFactory {

	public void create(InputStream inputStream, String fileName) throws Exception {

		//InputStream inputStream = new FileInputStream(new File("entry/movie.jpg"));
		//InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();


		BufferedImage originalImage = ImageIO.read(inputStream);
		int width = originalImage.getWidth();
		int height = originalImage.getHeight();
		int newHeight = height + 200;
		BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

		Graphics2D graphics = (Graphics2D) newImage.getGraphics();
		graphics.drawImage(originalImage, 0, 0, null);

		graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		graphics.setColor(Color.red);
		graphics.drawString("AWESOME", width / 2 - 30, newHeight - 120);

		ImageIO.write(newImage, "png", new File(fileName));
	}

	public static void main(String[] args) throws Exception {
		//StickerFactory stickerFactory = new StickerFactory();
		//stickerFactory.create();
	}
}
