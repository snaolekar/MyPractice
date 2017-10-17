import java.util.*;
class NewTest{
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    String inp= sc.next();
    System.out.println(getLargest(inp));
    sc.close();
  }
 
  static int getLargest(String s){
      int len = s.length();
      char[] input= s.toCharArray();
      int maxSize=0;
      int tempSize=0;
      HashMap<Character,Integer> index = new HashMap<>();
      for(int i=0;i<len;i++){
          if(index.containsKey(input[i])){
              tempSize=i-index.get(input[i]);
              index.clear();
              index.put(input[i],i);
          }
          else{
              tempSize++;
              index.put(input[i],i);
              if(tempSize > maxSize)
                  maxSize= tempSize;
          }
      }
      return maxSize ;
    }
}