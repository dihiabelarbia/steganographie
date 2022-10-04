package business;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {
	public Color encoder(Color px,char ch) {
		Color newPx = new Color((px.getRed() & ~0x3) | ((ch & 0x60) >> 5),
				(px.getGreen() & ~0x3) | ((ch & 0x18) >> 3),
				(px.getBlue() & ~0x7) | (ch & 0x7));
		return newPx;
	}
	public char decoder(Color newpx) {
		char ch = (char) (((newpx.getRed() & 0x3) << 5) |
				((newpx.getGreen() & 0x3) << 3) |
				(newpx.getBlue() & 0x7));
		return ch;
	}
	public static void main(String[] args) throws IOException {
		Test y = new Test();
		String text = "ceci est un teste";
		char [] array = text.toCharArray();

		BufferedImage image = ImageIO.read(new File("dd.png"));

		int k = 0;
		int i = 0;
		int j = 0;
		while( k < array.length) {
					Color px = new Color(image.getRGB(i,j));
					image.setRGB(i, j, new Color((px.getRed() & ~0x3) | ((array [k] & 0x60) >> 5),
							(px.getGreen() & ~0x3) | ((array[k] & 0x18) >> 3),
							(px.getBlue() & ~0x7) | (array[k] & 0x7)).getRGB());
					i = i+1;
					j = j+1;
					k = k+1;
				}
		


		File outputfile = new File("save.png");
		ImageIO.write(image, "png", outputfile);
		
		BufferedImage image1 = ImageIO.read(new File("save.png"));
	
		
		int i1 = 0;
		int j1 = 0;
		int k1 = 0;
		while (k1 < array.length) {
		
				Color newpx = new Color(image1.getRGB(i1,j1));	
			
				char ch = (char) (((newpx.getRed() & 0x3) << 5) |
						((newpx.getGreen() & 0x3) << 3) |
						(newpx.getBlue() & 0x7));
				System.out.print(ch);
				i1 = i1+1;
				j1 = j1+1;
				k1 = k1+1;
			}

	}
}
	


		


	   


		
	


