/**
 * 
 */
package pp4;

import java.util.Scanner;

/**
 * @author Peter McLane
 *
 */
//
//Peter McLane 4/7/21
//This program will calculate the users score on the drivers test based on the user input for each question and tell them if they passed or not
public class DriverExam {

	//declaring array of correct answers and user answers
	public String[] userAnswers ;
	public String[] answers = {"B", "D", "A", "A", "C", "A","B", "A", "C","D",
	"B", "C", "D","A","D","C","C","B","D","A"};

	int[] miss = new int[answers.length];
	int count_correct;
	int count_incorrect;


	public DriverExam(String[] ans){
		userAnswers = ans;
	}
//created boolean with if statement in passed method to determine if user passed test or not
	public boolean passed(){
		if ( count_correct >= 15){
			System.out.println("You passed!");
			return true;
	}else{
		System.out.println("You did not pass.");
		return false;
		}
	
	}

//for loop to count users total correct answers in total correct method
	public int totalCorrect(){
		for (int i = 0; i < answers.length; i++){
			if (userAnswers[i].equalsIgnoreCase(answers[i]))
				count_correct++;
		}
		return count_correct;

	}

//for loop to count total incorrect answers in totaIncorrect method 
	public int totalIncorrect(){
		for (int i = 0; i < answers.length; i++){
			if( !userAnswers[i].equalsIgnoreCase(answers[i])){
				miss[count_incorrect] = i + 1;
				count_incorrect++;
			}
			
	}
		return count_incorrect;

	}

//this method prints out all the missed questions that were answered wrong
	public int[] questionsMissed(){

	int size = answers.length - count_correct;
	int [] miss = new int [size];
	int count = 0;
		for (int i = 0; i < answers.length; i++){
			if(!userAnswers[i].equalsIgnoreCase(answers[i])){
				miss[count] = i + 1;
				System.out.print("\nThe missed ones are : " + miss[count] + "\n");
				count++;
				}
		}
		return miss;
	}
	

	public static void main(String[] args) {
		//here we make a string that will contain 20 elements for the 20 answers for each question
		String[] userAnswers = new String[20];
		String answer;
		System.out.println("Welcome to the driving test center:\n");
		System.out.println("\nPlease Enter an Answer: \n");
		//here we have a for loop that will put us through each question and allow us to answer with the letters being not case sensitive and
		//characters must be a, b, c, or d
			for(int i = 0;i<userAnswers.length;i++) {
				System.out.println(" Question: " + (i + 1) );
				Scanner input = new Scanner(System.in);
				answer = input.next();
				while((!answer.equalsIgnoreCase("A")) && (!answer.equalsIgnoreCase("B")) && (!answer.equalsIgnoreCase("C")) && (!answer.equalsIgnoreCase("D"))){
					System.out.println("Please input a character using A B C or D");
					answer = input.next();
						}
		userAnswers[i]=answer;

		}
		DriverExam exam = new DriverExam(userAnswers);
		//here we will print out the correct answers and the incorrect answers and the passed method will be called along with the questions missed method
		//to indicate if the user passed or failed 
		System.out.println("\nYou answered " + exam.totalCorrect() + " questions correctly.");
		System.out.println("\n" + exam.totalIncorrect() + " questions were answered incorrectly." );
		exam.passed();
		exam.questionsMissed();
			}
	
		}


	


