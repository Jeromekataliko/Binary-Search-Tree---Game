// QuestionNode.java
public class QuestionNode {
    public String data;
    public QuestionNode yes;
    public QuestionNode no;

    public QuestionNode(String data) {
        this(data, null, null);
    }

    public QuestionNode(String data, QuestionNode yes, QuestionNode no) {
        this.data = data;
        this.yes = yes;
        this.no = no;
    }
}