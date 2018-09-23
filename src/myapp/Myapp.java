package myapp;

import java.util.HashSet;
import java.util.Set;

public class Myapp {
	private int max;
	private static String[] operations= new String[] {"+","-","*","/"};
	/**
     * 构造函数
     * @param 数字上限
     */
	public Myapp(int max) {
		this.max = max;
	}
	
	
	/**
	 * 获得随机操作数
	 * @return 操作数
	 */
	private String getNum() {
		return "1";
	}
	
	/**
	 * 获得运算符
	 * @return 运算符
	 */
	private String getOpera() {
		return operations[(int) (Math.random()*10%4)];
	}
	
	/**
     * 获得随机题目
     * @param (n 题目数量,以后再是否加入这个参数)
     * @return 题目
     */
	public String[] getCalc() {
		String[] calc = {};
		
		return calc;
	}
	
	public static void main(String[] args) {
		String[] a = new String[9];
		Set<Calculation> s = new HashSet<Calculation>();
		System.out.println(Math.random()*100000);
	}
	
}

class Calculation { 
	String[] calculation;
	CTree tree = null;
	public Calculation(String[] s) {
		calculation = s;
	}
	
	public String[] getCalculation() {
		return calculation;
	}
	
	public void randomOperation() {
		
	}
	
	public void randomNum() {
		
	}
	
	public int hashCode() {
		return calculation.length + calculation[0].charAt(0); 
	}
	
	public boolean equals(Object  obj) {
		if(true) {
			return true;
		}
		return false;
	}
}

class Num{
	boolean type ;
	int num[] = new int[3];
	 
	private Num(int r) {
		num[1] = (int) (Math.random() * r * 10 % r);
		num[2] = (int) (Math.random() * r * 10 % r);
		
		r = 
		num = new int[] {(int) (Math.random()%num),,};
		r %= 100000;
		int opNum = (r / 1000) % 4; //操作数个数
		int[] 
	}
	public static Num getRNum(int n) {
		 
	}
	 
}

class CTree { //Calculation tree
	private CTree parent;
	private CTree lchild;
	private CTree rchild;
	private boolean type; //true为操作数，false为运算符
	private String operation;//数据域
	private int[] num;
	
	public CTree( ) {
		
	}
	public CTree(int[] s) {
		switch(s[0]) {
		case 0:
			type = true;
			num
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}
		
	}
	
	public CTree getTree() {
		return this;
	}
	
	public boolean equals(CTree s) { //比较树是否相同 ,不区分左右子树位置不同
		if(this.type == s.type && 
				//还要比较两个变量
				(this.lchild.equals(s.lchild) && this.rchild.equals(s.rchild) ) ||
				(this.lchild.equals(s.rchild) && this.rchild.equals(s.lchild) )
				)
			return true;
		return false;
	}
	
	
}
