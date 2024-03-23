public class Assignment01_20230808049 {

    /*
     * @yunus Turan
     * 14.03.2024
     */
    public static void main(String[] args) {
        // System.out.println(0/0);
        //Course c = new Course("flk", 100, "null", null, 2);
        Teacher t = new Teacher("yunus ", "yunus@turan.com", 123L, "CSE", 1);
    }
}

class Course{
    private String departmentCode;//must be 3 or 4 characters
    private int courseNumber;//must be 100-999 or 5000-5999 or 7000-7999
    private String title;
    private String description;
    private int AKTS;//must be positive
    Course(String departmentCode,int courseNumber,
    String title,String description,int AKTS){
        setAKTS(AKTS);
        setCourseNumber(courseNumber);
        setDepartmentCode(departmentCode);
        setDescription(description);
        setTitle(title);
    }

    public int getAKTS() {
        return AKTS;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setAKTS(int AKTS) {
        if(AKTS>0){
        this.AKTS = AKTS;
        }else{
            DontRun.theError();
        }
    }

    public void setCourseNumber(int courseNumber) {
        if((courseNumber>=100&&courseNumber<=999)||
        (courseNumber>=5000&&courseNumber<=5999)||
        (courseNumber>=7000&&courseNumber<=7999)){
        this.courseNumber = courseNumber;
        }else{
            DontRun.theError();
        }
    }

    public void setDepartmentCode(String departmentCode) {
        if(departmentCode.length()==3||departmentCode.length()==4){
        this.departmentCode = departmentCode;
        }else{
            DontRun.theError();
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String courseCode(){
        return String.format("%s%d",departmentCode,courseNumber);
    }

    @Override
    public String toString() {
        return String.format("%s%d - %s (%d)",
        departmentCode,courseNumber,title,AKTS);
    }
}

class Person{
    private String name;
    private String email;
    private long ID;
    private String departmentCode;
    Person(String name,String email,long ID,String departmentCode){
        setDepartmentCode(departmentCode);
        setEmail(email);
        setID(ID);
        setName(name);
    }
    public void setDepartmentCode(String departmentCode) {
        if(departmentCode.length()==3||departmentCode.length()==4){
        this.departmentCode = departmentCode;
        }else{
            DontRun.theError();
        }
    }
    
    public void setID(long iD) {
        ID = iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getEmail() {
        return email;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        if(email.contains("@")&&email.contains(".")){

            int i =email.indexOf("@");

            String sub1=email.substring(0, i);

            if(sub1.equals(email)){
                DontRun.theError();
            }else{

            if(sub1.equals("@")){
                DontRun.theError();
            }else{

            String sub2=email.substring(i+1);

            if(sub2.contains(".")){

                if(sub2.contains("@")){

                DontRun.theError();
                
                }else{
                    this.email=email;
                }
            }else{
                DontRun.theError();
             } }
            }
        }else{
            DontRun.theError();
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%d) - %s",name,ID,email );
    }
}

class Teacher extends Person{
    private int rank;

    Teacher(String name,String email,long number,String department,int rank){
        super(name, email, number, department);
        setRank(rank);
    }

    public void setRank(int rank) {
        if(rank>=1&&rank<=4){
            this.rank=rank;
        }else{
            DontRun.theError();
        }
    }

    public String getTitle(){
        if(rank==1){
            return "Lecturer";
        }else if(rank==2){
            return "Assistant Professor";
        }else if(rank==3){
            return "Associate Professor";
        }else{
            return "Professor";
        }
    }

    public void promote(){
        if(rank<4){
            rank++;
        }else{
            DontRun.theError();
        }
    }

    public void demote(){
        if(rank>1){
            rank--;
        }else{
            DontRun.theError();
        }
    }

    @Override
    public String toString() {
        return String.format("%s "+super.toString(),getTitle());
    }
}

class Student extends Person{
    private int AKTS;
    Student(String name,String email,long number,String department){
        super(name, email, number, department);
        AKTS=0;
    }

    public int getAKTS() {
        return AKTS;
    }

    public void passCourse(Course course){
        AKTS+=course.getAKTS();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class GradStudent extends Student{
    private int rank;
    private String thesisTopic;
    GradStudent(String name,String email,long number,
    String department,int rank,String thesisTopic){
        super(name, email, number, department);

    }

    public void setRank(int rank) {
        if(rank>=1&&rank<=3){
            this.rank=rank;
        }else{
            DontRun.theError();
        }
    }

    public String getLevel(){
        if(rank==1){
            return "Master's Student";
        }else if(rank==2){
            return "Doctoral Student";
        }else{
            return "Doctoral Candidate";
        }
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class DontRun{
    public static void theError(){
        System.out.println(0/0);
    }
}