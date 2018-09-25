package myapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Set;

public class MyFile {
	private static String root = "D:\\";
	static String exercisesFile = root + "Exercises.txt";
	static String answerFile = root + "Answer.txt";
	static String gradeFile = root + "Grade.txt";
	
	public static void writeInCalc(Set<Calculation> s) {
		try {
			PrintWriter pwExerises = new PrintWriter(exercisesFile);
			PrintWriter pwAnswer = new PrintWriter(answerFile);
			int n = 1;
			for(Calculation c :s) {
				pwExerises.println(n + ". " + c.getFormula() + " = ");
				pwAnswer.println(n++ + ". " + c.getAnswer().getFromatNumber());
			}
			pwExerises.close();
			pwAnswer.close();
		} catch (FileNotFoundException e) {
			System.out.println("open file error!");
		}
	}

	public static void grade() {
		try {
			BufferedReader brExerises = new BufferedReader(new FileReader(exercisesFile));
			try {
				BufferedReader brAnswer = new BufferedReader(new FileReader(answerFile));
				PrintWriter pw = new PrintWriter(gradeFile);
				int rightNum = 0, wrongNum = 0;
				String right = "";
				String wrong = "";
				String number,e,a;
				do {
					if((e = brExerises.readLine()) == null || (a = brAnswer.readLine()) == null) {//如果读完文件
						break;
					}
					e = e.substring(e.indexOf("=") + 1).replace(" ","");
					number = a.split(". ")[0];
					a = a.split(". ")[1];
					if(a.equals(e)) {
						right += number + ", ";
						rightNum++;
					}else {
						wrong += number + ", ";
						wrongNum++;
					}
				}while(true);
				pw.println("Correct: " + rightNum + " (" + (right + ")").replaceAll(", \\)", ")"));
				pw.println("Wrong: " + wrongNum + " (" + (wrong + ")").replaceAll(", \\)", ")"));
				pw.close();
				brAnswer.close();
			}catch (Exception e) {
				System.out.println("open answerFile:" + answerFile + " error!");
				e.printStackTrace();
			}
			brExerises.close();
		} catch (Exception e) {
			System.out.println("open exercisesFile1:" + exercisesFile + " error!");
		}
	}
	
	/*
	public static void answer() {
		try {
			BufferedReader brExerises = new BufferedReader(new FileReader(exercisesFile));
			BufferedReader brAnswer = new BufferedReader(new FileReader(answerFile));
			PrintWriter pw = new PrintWriter(gradeFile);
//			do {
//				brExerises.readLine()
//			}while();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void solve(String calc) {
		Stack<Num> stNum = new Stack<Num>();
		Stack<String> stOper = new Stack<String>();
		ArrayList<String> c = getSymbols(calc);
		Num num;
		for(String s:c) {
			if((num = Num.getNum(s)) != null) { //如果是一个操作数
				stNum.push(num);
			}
		}
		
	}
	
	public static ArrayList<String> getSymbols(String calc) {
		ArrayList<String> s = new ArrayList<String>();
		String tmp = "";
		char c;
		for(int n = 0;n < calc.length();n++) {
			c = calc.charAt(n);
			if(c >= 48 && c <= 57 || c == '\'' || c == '/') {//如果一位数字,先放进tmp，
				tmp += String.valueOf(calc.charAt(n));
				continue;
			}
			if(!tmp.equals("")) {//把前面的一个数add进去
				s.add(tmp);
				tmp = "";
			}
			s.add(calc.substring(n,n+1));
		}
		if(!tmp.equals("")) {//如果最后是一个数字，add进去
			s.add(tmp);
			tmp = "";
		}
		return s;
	}*/
}
