package edu.mui.cs489.reachnou.questify.repository;

import edu.mui.cs489.reachnou.questify.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
