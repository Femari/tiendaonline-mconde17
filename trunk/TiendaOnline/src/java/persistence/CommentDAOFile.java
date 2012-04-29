package persistence;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Comment;

public class CommentDAOFile implements CommentDAO {

    private Map<String, Comment> commentMap = new HashMap<>();
    private String commentFile;
    private static CommentDAOFile mechanismOfPersistence = null;
    private static final Logger log = Logger.getLogger(CommentDAOFile.class.getName());

    public CommentDAOFile() {
    }

    public static CommentDAO getImplementation() {
        if (mechanismOfPersistence == null) {
            mechanismOfPersistence = new CommentDAOFile();
        }
        return mechanismOfPersistence;
    }

    @Override
    public synchronized boolean newComment(Comment comment) {
        if (getCommentMap().containsKey(comment.getCommentID())) {
            return false;
        } else {
            getCommentMap().put(comment.getCommentID(), comment);
            return true;
        }
    }

    @Override
    public synchronized boolean deleteComment(Comment comment) {
        if (getCommentMap().containsKey(comment.getCommentID())) {
            getCommentMap().remove(comment.getCommentID());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public synchronized boolean updateComment(Comment oldComment, Comment newComment) {
        if (getCommentMap().containsKey(oldComment.getCommentID())) {
            getCommentMap().put(oldComment.getCommentID(), newComment);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public synchronized Comment getComment(String commentID) {
        return getCommentMap().get(commentID);
    }

    @Override
    public Map<String, Comment> getCommentMap() {
        return commentMap;
    }

    @Override
    public Map<String, Comment> getCommentMap(String parameter, String condition) {
        Map<String, Comment> resultMap = new HashMap<>();
        Iterator it = getCommentMap().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            Comment c = (Comment) e.getValue();
            if (c.isEquals(parameter, condition)) {
                resultMap.put(c.getCommentID(), c);
            }
        }
        return resultMap;
    }

    @Override
    public boolean connection(String user, String pass, String destiny, String driver) {
        this.commentFile = destiny;
        File f = new File(this.commentFile);
        InputStream is = null;
        ObjectInputStream ois = null;
        try {
            if (f.exists() && f.isFile()) {
                is = new FileInputStream(f);
                ois = new ObjectInputStream(is);
                int numberOfProducts = (Integer) ois.readObject();
                for (int i = 0; i < numberOfProducts; i++) {
                    Comment c = (Comment) ois.readObject();
                    getCommentMap().put(c.getCommentID(), c);
                }
            } else {
                f.createNewFile();
            }
        } catch (ClassNotFoundException | IOException ex) {
            log.log(Level.WARNING, "No se pudo crear la Conexion correctamente", ex);
            return false;
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex2) {
                log.log(Level.INFO, "No se pudo cerrar el fichero correctamente", ex2);
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ex3) {
                log.log(Level.INFO, "No se pudo cerrar el fichero correctamente", ex3);
            }
        }
        return true;
    }

    @Override
    public boolean disconnect() {
        File f = new File(this.commentFile);
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            if (f.exists() && f.isFile()) {
                os = new FileOutputStream(f);
                oos = new ObjectOutputStream(os);
                int mapSize = getCommentMap().size();
                oos.writeObject(mapSize);
                Iterator it = getCommentMap().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry e = (Map.Entry) it.next();
                    Comment c = (Comment) e.getValue();
                    oos.writeObject(c);
                }
            }
        } catch (IOException ex) {
            log.log(Level.WARNING, "No se pudo realizar la Desconexión de forma correcta", ex);
            return false;
        } finally {
            try {
                oos.close();
            } catch (IOException ex2) {
                log.log(Level.INFO, "No se pudo cerrar el fichero correctamente", ex2);
            }
            try {
                os.close();
            } catch (IOException ex3) {
                log.log(Level.INFO, "No se pudo cerrar el fichero correctamente", ex3);
            }
        }
        return true;
    }
}
