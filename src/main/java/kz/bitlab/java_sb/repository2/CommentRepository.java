package kz.bitlab.java_sb.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kz.bitlab.java_sb.model2.Comment;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
