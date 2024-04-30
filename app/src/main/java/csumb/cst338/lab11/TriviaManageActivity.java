package csumb.cst338.lab11;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import csumb.cst338.lab11.databinding.ActivityTriviaManageBinding;
import csumb.cst338.lab11.databinding.ItemQuestionBinding;


public class TriviaManageActivity extends AppCompatActivity {
    private ActivityTriviaManageBinding binding;
    private TriviaDatabase db;
    private List<Question> triviaList;
    private ListView triviaListView;
    private ArrayAdapter<Question> triviaAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTriviaManageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = TriviaDatabase.getInstance(this);
        triviaListView = binding.triviaList;
        updateUI();
    }
    private void updateUI() {
        triviaList = db.question().getAll();

        if (triviaAdapter == null) {
            triviaAdapter = new ArrayAdapter<>(this, R.layout.item_question,
                    R.id.question_item, triviaList);
            triviaListView.setAdapter(triviaAdapter);
        } else {
            triviaAdapter.clear();
            triviaAdapter.addAll(triviaList);
            triviaAdapter.notifyDataSetChanged();
        }
    }
}
