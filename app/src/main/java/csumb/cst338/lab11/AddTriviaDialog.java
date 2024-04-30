package csumb.cst338.lab11;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import csumb.cst338.lab11.databinding.DialogAddTriviaBinding;

public class AddTriviaDialog extends DialogFragment {
    private DialogAddTriviaBinding binding;
    private RadioGroup radioGroup;
    private TriviaDatabase db;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        binding = DialogAddTriviaBinding.inflate(LayoutInflater.from(getContext()));
        db = TriviaDatabase.getInstance(getActivity());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(binding.getRoot())
                .setTitle("Add A Question")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String myq = String.valueOf(binding.qText.getText());
                        String myg = String.valueOf(binding.qGenre.getText());
                        radioGroup = binding.radioGroup;
                        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                        int myBool = 0;
                        if (checkedRadioButtonId == R.id.answer_false) {
                            myBool = 0;
                        } else if (checkedRadioButtonId == R.id.answer_true) {
                            myBool = 1;
                        }
                        Question myQuestion = new Question(myq, myBool, myg);
                        db.question().addQuestion(myQuestion);
                    }
                })
                .setNegativeButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
        return builder.create();
    }
}
