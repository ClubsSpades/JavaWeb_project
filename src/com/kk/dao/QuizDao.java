package com.kk.dao;

import java.util.List;
import com.kk.entity.Question;
import com.kk.entity.Option;

public interface QuizDao {

    // ��ѯ������Ŀ
    List<Question> findAllQuestions();

    // ������ĿID��ѯѡ��
    List<Option> findOptionsByQuestionId(int questionId);
}
