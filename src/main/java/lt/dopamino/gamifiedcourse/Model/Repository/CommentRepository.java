package lt.dopamino.gamifiedcourse.Model.Repository;

import lt.dopamino.gamifiedcourse.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("select m from Comment m where m.post.id = ?1")
    List<Comment> getCommentsById(int id);
    @Transactional
    @Modifying
    @Query("delete from Comment m where m.post.id = ?1")
    void deleteAllByPost(int postId);
}
