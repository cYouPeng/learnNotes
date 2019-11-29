package oopcore.interfaces;

public interface Style {
	int TEXT_NO_STYLE = 0;
	int TEXT_SHADOW = 1<<0;
	int TEXT_BOLDER = 1<<1;
	int TEXT_UNDER_LINE = 1<<2;
	int TEXT_EM = 1<<3;
	
	void method();
}
