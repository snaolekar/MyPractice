import java.util.*;
/**
 * Rotate
 */
public class Rotata {
  public static void rotate(String s1,String s2){
  if(s1.length() != s2.length()){
    System.out.println(0);
    return ;
}
int count=s1.length();
  //check for anticlock
Boolean status=false;
for(int j=0,k=2;j<count;j++,k++){
    status= (s1.charAt(j) == s2.charAt(k%count));
    if(!status)
      break;
}
if(!status){
    for(int j=2,k=0;k<count;j++,k++){
    status= (s1.charAt(j%count) == s2.charAt(k));
    if(!status)
      break;
  }
}
if(status)
  System.out.println(1);
else
  System.out.println(0);
}

public static Boolean Anagrag(String s1,String s2){
  Map <Character,Integer>strMap= new HashMap<Character,Integer>();
  for (char r : s1.toCharArray()){
      strMap.put(r,1);
  }
  for(char s:s2.toCharArray()){
    if(!strMap.containsKey(s)) 
    return false;
  }
  return true;
}
 
public static void main(String[] args) {
  Scanner sc= new Scanner(System.in);
  String s1= sc.next();
  String s2= sc.next();
  Rotata.rotate(s1,s2);
  if(Rotata.Anagrag(s1,s2))
    System.out.println("TRUE");
  else
    System.out.println("FALSE");
  }
  }