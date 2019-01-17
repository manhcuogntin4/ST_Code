import java.util.Scanner; 
public class FizzBuzz {
    public static String getFizzBuzz(int nombre){
        String str_FizzBuzz;
        if(nombre%15==0){
            str_FizzBuzz="FizzBuzz";
        } else if(nombre%3==0){
            str_FizzBuzz="Fizz";
        } else if(nombre%5==0)
        {
            str_FizzBuzz="Buzz";
        }
        else{
            str_FizzBuzz=String.valueOf(nombre);
        }
        return str_FizzBuzz;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
        System.out.println("Enter a number. Press 0 to quit:");
        int nombre = scan.nextInt();
        if (nombre!=0){
            String str_FizzBuzz;
            str_FizzBuzz=getFizzBuzz(nombre);
            System.out.println(str_FizzBuzz);
        }
        else
            break;
        }

    }
}