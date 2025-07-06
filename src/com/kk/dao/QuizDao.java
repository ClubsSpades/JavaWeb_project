package com.kk.dao;

import java.util.List;
import com.kk.entity.Question;
import com.kk.entity.Option;

public interface QuizDao {

    // 查询所有题目
    List<Question> findAllQuestions();

    // 根据题目ID查询选项
    List<Option> findOptionsByQuestionId(int questionId);
}
