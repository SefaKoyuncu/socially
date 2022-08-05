package com.example.socially.classes;

public class Post
{
    private String personImage;
    private String personName;
    private String sharingTime;
    private String postImage;
    private double likesCounts;
    private int saveCounts;
    private double commentCounts;

    public Post()
    {
    }

    public Post(String personImage, String personName, String sharingTime, String postImage, double likesCounts, int saveCounts, double commentCounts)
    {
        this.personImage = personImage;
        this.personName = personName;
        this.sharingTime = sharingTime;
        this.postImage = postImage;
        this.likesCounts = likesCounts;
        this.saveCounts = saveCounts;
        this.commentCounts = commentCounts;
    }

    public String getPersonImage() {
        return personImage;
    }

    public void setPersonImage(String personImage) {
        this.personImage = personImage;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getSharingTime() {
        return sharingTime;
    }

    public void setSharingTime(String sharingTime) {
        this.sharingTime = sharingTime;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public double getLikesCounts() {
        return likesCounts;
    }

    public void setLikesCounts(double likesCounts) {
        this.likesCounts = likesCounts;
    }

    public int getSaveCounts() {
        return saveCounts;
    }

    public void setSaveCounts(int saveCounts) {
        this.saveCounts = saveCounts;
    }

    public double getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(double commentCounts) {
        this.commentCounts = commentCounts;
    }


}

