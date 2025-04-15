import java.util.*;
/**
 * author: satyam naolekar
 * prints the longest palendrom in string
 */
public class LongestPal {
  public static void main (String[] args) {
    Scanner sc= new Scanner(System.in);
        int match_len=0;
        String match_word="";
        String st= sc.nextLine();
        char [] str= st.toCharArray();
        for(int j=0;j<st.length()-match_len;j++){
          int temp_len=0;
          for(int k=st.length()-1; k>=0;k--){
              while(k>=0 && str[j]!=str[k])
                  k--;
              if(k >0){
                  temp_len=1;
                  while(k>0 && j+temp_len < st.length() && str[j+temp_len]== str[--k])
                      temp_len++;
              }
              if(temp_len > match_len){
                  match_len= temp_len;
                  match_word = st.substring(j,j+match_len);
              }
          } 
        }
        System.out.println(match_word);
        sc.close();
}

}