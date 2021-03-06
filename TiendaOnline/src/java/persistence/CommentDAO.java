package persistence;

import java.util.Map;
import model.Comment;

public interface CommentDAO {

    public boolean newComment(Comment comment);

    public boolean deleteComment(Comment comment);

    public boolean updateComment(Comment oldComment, Comment newComment);

    public Comment getComment(String commentID);

    public Map<String, Comment> getCommentMap();

    public Map<String, Comment> getCommentMap(String parameter, String condition);

    public boolean connection(String user, String pass, String destiny, String driver);

    public boolean disconnect();
}
