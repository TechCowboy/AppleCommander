package com.webcodepro.applecommander.test;

import com.webcodepro.applecommander.storage.filters.imagehandlers.SwtImage;

import java.io.FileOutputStream;

import junit.framework.TestCase;

/**
 * Excersize the SwtImage class for all known types.
 * @author Rob
 */
public class SwtImageTest extends TestCase {
	/**
	 * Constructor for SwtImageTest.
	 */
	public SwtImageTest(String arg0) {
		super(arg0);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(SwtImageTest.class);
	}

	public void testPNG() throws Exception {
		performTest("PNG");
	}
	
	public void testJPEG() throws Exception {
		performTest("JPEG");
	}
	
	public void testBMP() throws Exception {
		performTest("BMP");
	}
	
	public void testGIF() throws Exception {
		performTest("GIF");
	}
	
	protected void performTest(String imageType) throws Exception {
		int height = 100;
		int width = 100;
		SwtImage image = new SwtImage(width, height);
		image.setFileExtension(imageType);
		int[] colors = { 
			0xff0000, 0xff0000, 0xff0000, 0xff0000, 0xff0000,	// red
			0x00ff00, 0x00ff00, 0x00ff00, 0x00ff00, 0x00ff00,	// green
			0x0000ff, 0x0000ff, 0x0000ff, 0x0000ff, 0x0000ff,	// blue
			0xffff00, 0xffff00, 0xffff00, 0xffff00, 0xffff00,	// red+green
			0xff00ff, 0xff00ff, 0xff00ff, 0xff00ff, 0xff00ff,	// purple
			0x00ffff, 0x00ffff, 0x00ffff, 0x00ffff, 0x00ffff,	// green+blue
			0x000000, 0x000000, 0x000000, 0x000000, 0x000000,	// black
			0xffffff, 0xffffff, 0xffffff, 0xffffff, 0xffffff	// white
		};
		for (int y=0; y<height; y++) {
			int color= colors[y % colors.length];
			for (int x=0; x<width; x++) {
				image.setPoint(x, y, color);
			}
		}
		image.save(new FileOutputStream("C:/Temp/TestImage." + imageType));
	}
}
