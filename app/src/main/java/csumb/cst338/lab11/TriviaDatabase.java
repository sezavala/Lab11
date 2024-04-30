package csumb.cst338.lab11;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Question.class}, version=2, exportSchema = false)
public abstract class TriviaDatabase extends RoomDatabase {

    public abstract QuestionDao question();
    private static TriviaDatabase sInstance;

    public static synchronized TriviaDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            TriviaDatabase.class, "trivia.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

}

