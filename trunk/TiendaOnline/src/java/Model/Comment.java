package Model;

public class Comment {
    
    private String commentID;
    private String commentDate;
    private Product commentProduct;
    private User commentUser;
    private String commentContent;
    
    public Comment(String id, String date, Product product, User user, String comment){
        commentID = id;
        commentDate = date;
        commentProduct = product;
        commentUser = user;
        commentContent = comment;
    }
    
    public void setCommentID(String id){
        this.commentID = id;
    }
    
    public String getCommentID(){
        return this.commentID;
    }
    
    public void setCommentDate(String date){
        this.commentDate = date;
    }
    
    public String getCommentDate(){
        return this.commentDate;
    }
    
    public void setCommentProduct(Product product){
        this.commentProduct = product;
    }
    
    public Product getCommentProduct(){
        return this.commentProduct;
    }
    
    public void setCommentUser(User user){
        this.commentUser = user;
    }
    
    public User getCommentUser(){
        return this.commentUser;
    }
    
    public void setCommentContent(String comment){
        this.commentContent = comment;
    }
    
    public String getCommentContent(){
        return this.commentContent;
    }
    
}
