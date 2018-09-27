package myapp;

import java.util.HashSet;
import java.util.Set;

public class Myapp {
	Set<Calculation> s = new HashSet<Calculation>();
	int n = 10;
	int r = 10;
	static final int COUNTER = 100;//检测生成的题目数不可能等于n的情况
	
	public Myapp(String[] args) {
		processingArgs(args);
	}
	
	public void processingArgs(String[] args) {
		boolean hasE = false;
		boolean hasA = false;
		boolean createCalc = false;
		try {
			for(int n = 0; n < args.length; n++) {
				switch(args[n]) {
				case "-n":
					if(++n < args.length) {
						this.n = Integer.parseInt(args[n]);
						createCalc = true;
					}else {
						System.out.println("n参数错误,后面没有带数字");
					}
					break;
				case "-r":
					if(++n < args.length) {
						this.r = Integer.parseInt(args[n]);
						createCalc = true;
					}else {
						System.out.println("r参数错误,后面没有带数字");
					}
					break;
				case "-e":
					if(++n < args.length) {
						MyFile.exercisesFile = args[n];
						hasE = true;
					}else {
						System.out.println("e参数错误");
					}
					break;
				case "-a":
					if(++n < args.length) {
						MyFile.answerFile = args[n];
						hasA = true;
					}else {
						System.out.println("a参数错误");
					}
					break;
				}
				if(hasE && hasA) {
					MyFile.grade();
				}
				if(createCalc) {
					createCalc();
				}
			}
		}catch (Exception e) {
			System.out.println("参数错误");
		}
	}
	
	public void createCalc() {
		int counter = -1;
		int oldSize = s.size();
		while(s.size() < n) {
		    Calculation tmp = new Calculation(r);
		    if(tmp.getAnswer() == null || tmp.getAnswer().getFromatNumber().indexOf('-') != -1) {
		        continue;
		    }
		    s.add(tmp);
		    if(oldSize != s.size()) {
		    	oldSize = s.size();
		    	counter = 1;
		    }else {
		    	counter++;
		    }
		    if(counter >= COUNTER) {
		    	System.out.println("在r为" + r + "的情况下，不能生成" + n + "个题目,只能生成 " + s.size() + "个题目！");
		    	return;
		    }
        }
		MyFile.writeInCalc(s);
	}
	
	public static void main(String[] args) {
		new Myapp(args);
	}
}

