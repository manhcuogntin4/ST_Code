public class FizzBuzz {
    public String getFizzBuzz(int nombre){
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
}