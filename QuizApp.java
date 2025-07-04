import java.util.*;//User for Scanner,List ArrayList,Collection ,etc.

public class QuizApp 
{
    // class  to represent each quiz question
    static class Question
    {
        String questionText;
        String[] options;
        int correctAnswerIndex;

        //Constructor to set question, options,and correct answer
        public Question(String questionText, String[] options,int correctAnswerIndex)
        {
            this.questionText=questionText;
            this.options=options;
            this.correctAnswerIndex=correctAnswerIndex;

        }
        //Method to display the question and options
        public void displayQuestion()
        {
            System.out.println(questionText);
            for(int i=0; i<options.length;i++)
            {
                System.out.println((i+1)+"."+options[i]);
            }
        }
        
        //Method to check if uer's answer is correct
        public boolean isCorrect(int userAnswer)
        {
            return userAnswer==correctAnswerIndex+1;
        }
    }
    public static void main(String args[])
    {
      Scanner sc = new Scanner(System.in);//Used to get user input
      List<Question>questions=new ArrayList<>();//List to store quiz questions

      //Adding questions to the quiz
      questions.add(new Question("Which language is used for Android App Development?",new String[]{"Python","Java","C#","Swift"},
      1));

      questions.add(new Question("Which of the following is not a java keyword?",
      new String[]{"static","Boolean","void","private"},1));

      questions.add(new Question("Which is the size of int in Java?",new
      String[]{"2 bytes","4 bytes","Depends on OS","8 bytes"},1));
      
      questions.add(new Question("Which collection is used to store key-value pairs?",
      new String[]{"ArrayList","HashSet","Map","Queue"},2));

      //Shuffle questions to make it interesting
      Collections.shuffle(questions);
      int score =0;//user's total score
      System.out.println("Welcome to the OnLine Quiz App!");
      System.out.println("Type the number of the correct option:\n");

      //Loop to display each question and take input 
      for (int i=0;i<questions.size();i++)
      {
        Question q=questions.get(i);
        System.out.println("Q"+(i+1)+":");
        q.displayQuestion();
        System.out.print("Your answer: ");
        int userAnswer;

        //Handle invalid input using tr-catch
        try{
            userAnswer=Integer.parseInt(sc.nextLine());
        }
        catch(Exception e)
        {
            System.out.println("Invalid input! Skipping question.\n");
            continue;
        }
        //Check the answer and update score
      if(q.isCorrect(userAnswer))
      {
        System.out.println("✔ Correct!\n");
        score++;
      }
      else{
        System.out.println("× Incorrect.Correct answer is "+(q.correctAnswerIndex+1)+"."+
        q.options[q.correctAnswerIndex]+"\n");
      }
    }  

      //Show final result
    System.out.println("🎉 Quiz Completed!");
    System.out.println(" Your Score: "+ score +" out of "+ questions.size());

    sc.close();//close the Scanner
     } 
}
