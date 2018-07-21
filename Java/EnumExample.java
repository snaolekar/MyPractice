
  enum Department {
  ELECTRICAL_ENGINEERING("Department of electrical Engineernig"), 
  CIVIL_ENGINEERING("Department of civil Engineernig"), 
  COMPUTER_SCIENCE_ENGINEERING("Department of computer science Engineernig"), 
  GOBAR_ENGINEERING("Department of Gobar Engineernig");

  String deptName;
  Department(String department){
    this.deptName = department ;
  }
  @Override
  public String toString(){
    return this.deptName ;
  }
}

class Student {
  
  String name;
  Department dept;

  public Student(String name, Department dept){
    this.name= name ;
    this.dept= dept;
  }

  public String getName(){
    return name;   
  }

  public Department getDepartment(){
    return dept;
  }
}

public class EnumExample {

  public static void main(String args[]){
    Student st = new Student("Satyam", Department.COMPUTER_SCIENCE_ENGINEERING);
    Student bs = new Student("Bhahyshree",Department.ELECTRICAL_ENGINEERING);
    System.out.println("first stu "+ st.getName()+" in Department "+st.getDepartment());    
    System.out.println("second stu "+ bs.getName()+" in Department "+bs.getDepartment());
  }

}