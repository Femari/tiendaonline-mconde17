package model;

public class Comment {

    private String commentID;
    private String commentDate;
    private String commentProductID;
    private String commentUserEmail;
    private String commentContent;

    public Comment(String id, String date, String productID, String userEmail, String comment) {
        commentID = id;
        commentDate = date;
        commentProductID = productID;
        commentUserEmail = userEmail;
        commentContent = comment;
    }

    public void setCommentID(String id) {
        this.commentID = id;
    }

    public String getCommentID() {
        return this.commentID;
    }

    public void setCommentDate(String date) {
        this.commentDate = date;
    }

    public String getCommentDate() {
        return this.commentDate;
    }

    public void setCommentProductID(String productID) {
        this.commentProductID = productID;
    }

    public String getCommentProductID() {
        return this.commentProductID;
    }

    public void setCommentUserEmail(String userEmail) {
        this.commentUserEmail = userEmail;
    }

    public String getCommentUserEmail() {
        return this.commentUserEmail;
    }

    public void setCommentContent(String comment) {
        this.commentContent = comment;
    }

    public String getCommentContent() {
        return this.commentContent;
    }

    public String generateCommentID() {
        String id;
        id = java.util.UUID.randomUUID().toString().substring(0, 29);
        return id;
    }

    public boolean isEquals(String parameter, String condition) {
        boolean equals = false;
        switch (parameter) {
            case "commentID":
                if (this.commentID.equals(condition)) {
                    equals = true;
                }
                break;
            case "commentDate":
                if (this.commentDate.equals(condition)) {
                    equals = true;
                }
                break;
            case "productID":
                if (this.commentProductID.equals(condition)) {
                    equals = true;
                }
                break;
            case "userEmail":
                if (this.commentUserEmail.equals(condition)) {
                    equals = true;
                }
                break;
            case "commentContent":
                if (this.commentContent.equals(condition)) {
                    equals = true;
                }
                break;
            default:
                equals = false;
                break;
        }
        return equals;
    }
}
