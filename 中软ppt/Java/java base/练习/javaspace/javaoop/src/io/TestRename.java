package io;

import java.io.File;

public class TestRename {
	public static void main(String[] args){
		File root = new File("F:/1813/课件/Wallpaper");
		new TestRename().findAllFile(root);
	}
	
	public void findAllFile(File root){
		if(!root.isDirectory()){
			return;
		}
		File[] files = root.listFiles();
		for(File f : files){
			
			if(f.isDirectory()){
				this.findAllFile(f);
			}
			if(f.isFile()){
				this.rename(f);
			}
		}
	}
	public void rename(File file){
		String path = file.getParent();
		System.out.println(path);
		String name = file.getName();
		int index = name.lastIndexOf(".");
		String newFilePath = path+"/"+name.substring(0, index).toUpperCase()+name.substring(index);
		if(file.renameTo(new File(newFilePath))){
			System.out.println(name+" -> "+ newFilePath);
		}else{
			System.out.println(name+" rename failed");
		}
	}
}
