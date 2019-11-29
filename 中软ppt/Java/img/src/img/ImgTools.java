package img;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgTools {
	public static void temp(File file) throws IOException{
		BufferedImage srcImg = ImageIO.read(file);
        int w = srcImg.getWidth();
        int h = srcImg.getHeight();
        if(w>h){
        	h = h*2000/w;
        	w = 2000;
        }else{
        	w = w*2000/h;
        	h = 2000;
        }
        BufferedImage targetImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    	//targetImg.getGraphics().drawImage(srcImg, 0, 0, w, h, null);
    	targetImg.getGraphics().drawImage(srcImg, 0, 0, 2000, 2000,1000,2000,2400,3400, null);
        ImageIO.write(targetImg, "JPEG", new File("c:/temp.jpg"));
	}
	public static void changeSize(File file, int width, int height) throws IOException{

	        BufferedImage srcImg = ImageIO.read(file);
	        int w = srcImg.getWidth();
	        int h = srcImg.getHeight();
	        if(w>h){
	        	height = h*width/w;
	        }else{
	        	width = w*height/h;
	        }
	        int i=0;
	        BufferedImage targetImg;
	        while(true){
	        	w = w/2>width?(int)(w/2):width;
	        	h = h/2>height?(int)(h/2):height;
	        	targetImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	        	targetImg.getGraphics().drawImage(srcImg,0,0,1000,1000, 0, 0, w, h, null);
	        	srcImg = targetImg;
	        	ImageIO.write(targetImg, "JPEG", new File("c:/temp"+i+".jpg"));
	        	if(w<=width||h<=height){
	        		break;
	        	}
	        	i++;
	        }
//	        BufferedImage targetImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        	targetImg.getGraphics().drawImage(srcImg, 0, 0, width, height, null);
//        	ImageIO.write(targetImg, "JPEG", new File("c:/temp.jpg"));

	        
	        
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		changeSize(new File("c:/a2.jpg"),500,500);
		temp(new File("c:/a1.jpg"));
	}
}
