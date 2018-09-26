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
			PrintWriter pwExerises = new PrintWriter(exercisesFile,"UTF-8");
			PrintWriter pwAnswer = new PrintWriter(answerFile,"UTF-8");
			int n = 1;
			for(Calculation c :s) {
				pwExerises.println(n + ". " + c.getFormula() + " = ");
				pwAnswer.println(n++ + ". " + c.getAnswer().getFromatNumber());
			}
			pwExerises.close();
			pwAnswer.close();
		} catch (Exception e) {
			System.out.println("open file error!");
		}
	}

	public static void grade() {
		try {
			BufferedReader brExerises = new BufferedReader(new FileReader(exercisesFile));
			try {
				BufferedReader brAnswer = new BufferedReader(new FileReader(answerFile));
				PrintWriter pw = new PrintWriter(gradeFile,"UTF-8");
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
			}
			brExerises.close();
		} catch (Exception e) {
			System.out.println("open exercisesFile1:" + exercisesFile + " error!");
		}
	}
	
}
