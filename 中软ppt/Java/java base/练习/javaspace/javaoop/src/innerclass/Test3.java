package innerclass;

import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Test3 {
	private JTextField txt;
	private JButton btn;
	public void init() {
		// TODO Auto-generated method stub
		txt = new JTextField();
		btn = new JButton("点我啊");
		btn.setText("hello");
		
		btn.addMouseListener(new MouseListener(){
			//重写接口中所有的方法
		});

	}


}


