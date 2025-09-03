class Example {
    int rated;
    String problem;
    private String name;
    Example(int rated, String problem, String name){
        this.rated = rated;
        this.problem = problem;
        this.name = name;
    }
    void display(){
        System.out.println("The rated is: "+rated);
        System.out.println("The problem is: "+problem);
        System.out.println("The name is"+name);
    }

    public String getName(){
        return name;
    }
}
class Solution extends Example{
    int val;
    String solution;
    Solution(int rated, String problem, String name, int val, String solution){
        super(rated, problem, name);
        this.val = val;
        this.solution = solution;
    }

    void display(){
        System.out.println("The rated of the problem: "+rated);
        System.out.println("The problem is: "+problem);
        System.out.println("The value of the problem: "+val);
        System.out.println("The solution of the problem: "+solution);
    }
}
class Main{
    public static void main(String[] args) {
        Solution obj = new Solution(5, "Reverse of array","Aman Raj", 4, "Two pointer");
        obj.display();
        System.out.println();
        Example obj2 = new Example(10, "Rotate k places", "Aman Singh");
        obj2.display();
        System.out.println(obj2.getName());
    }
}
