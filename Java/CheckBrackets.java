import java.util.*;
/**
* author: Satyam Naolekar
 * CheckBrackets
 * Simply checking if expression has balanced set of brackets
 */
 public class CheckBrackets {
    public static void main(String[] args) {
        Stack <Character>s = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        sc.nextLine(); // skipping the line for the input number
        for(int i=0;i<loop; i++){
            Boolean result = true ;
            String input = sc.nextLine();
            char nCh ;
            for (char ch : input.toCharArray()){
                switch (ch) {
                    case '{':
                        s.push(ch);
                        break;
                    case '}':
                        if(s.empty())
                            result=false;
                        else
                        {
                            nCh =s.pop();
                            if(nCh != '{' )
                            result= false ;
                        }
                        break;
                    case '[':
                        s.push(ch);
                        break;
                    case ']':
                        if(s.empty())
                            result=false;
                        else
                        {
                            nCh = s.pop();
                            if(nCh != '[')
                                result= false ;
                        }
                        break;
                    case '(':
                        s.push(ch);
                        break;
                    case ')':
                        if(s.empty())
                            result=false;
                        else
                        {
                            nCh = s.pop();
                            if(nCh != '(')
                                result= false ;
                        }
                        break;
                    default:
                        result= false ;
                        break;
                }
            }
            if(result && s.empty())
                System.out.println("balanced");
            else
                System.out.println("not balanced");
            s.clear();
        }
    }
 } 