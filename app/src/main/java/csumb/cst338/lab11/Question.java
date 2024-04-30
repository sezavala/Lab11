package csumb.cst338.lab11;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "questionBank")
public class Question {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "question")
    private String question;

    @ColumnInfo(name="answer")
    private int answer;

    @ColumnInfo(name="topic")
    private String topic;

    // constructor without id
    // getters/setters

    public Question(String question, int answer, String topic) {
        this.question = question;
        this.answer = answer;
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public String getTopic() {
        return topic;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}

