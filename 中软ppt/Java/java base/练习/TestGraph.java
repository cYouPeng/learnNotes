package oop2;

public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.icon = "#";
		g.showRect(3, 5);
		g.showTriangle(4);
	}

}
class Graph{
	String icon;
	public void showRect(int row, int col){
		for(int i=0; i<row; i++){
			System.out.println(this.getGraphLine(col));
		}
	}
	public void showTriangle(int row){
		for(int i=0; i<row; i++){
			System.out.println(this.getGraphLine(i+1));
		}
	}
	public String getGraphLine(int num){
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<num; i++){
			sb.append(icon);
		}
		return sb.toString();
	}
	
}
