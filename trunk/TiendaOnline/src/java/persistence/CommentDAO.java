package persistence;

import java.util.Map;
import model.Comment;

public interface CommentDAO extends PersistenceManager {

    @Override
    public boolean newComment(Comment comment);

    @Override
    public boolean deleteComment(Comment comment);

    @Override
    public boolean updateComment(Comment oldComment, Comment newComment);

    @Override
    public Comment getComment(String commentID);

    @Override
    public Map<String, Comment> getCommentMap();

    @Override
    public Map<String, Comment> getCommentMap(String parameter, String condition);

    @Override
    public boolean connection(String user, String pass, String destiny, String driver);

    @Override
    public boolean disconnect();
}
