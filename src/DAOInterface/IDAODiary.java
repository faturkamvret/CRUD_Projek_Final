package DAOInterface;

import Model.Diary;
import java.util.List;

public interface IDAODiary {
    boolean insertDiary(Diary diary);
    void updateDiary(Diary diary);
    void deleteDiary(int id_diary);
    Diary getDiaryById(int id_diary);
    List<Diary> getDiariesByUserId(int id_user);
}
