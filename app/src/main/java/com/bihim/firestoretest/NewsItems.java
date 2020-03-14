package com.bihim.firestoretest;

public class NewsItems
{
     /*private int imageID;
     private String headline;
     private String description;
     private String timeStamp;

    public NewsItems(int imageID, String headline, String description, String timeStamp)
    {
        this.imageID = imageID;
        this.headline = headline;
        this.description = description;
        this.timeStamp = timeStamp;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }*/

     private String newsTitle, newsImageLink, newsWriterName, newsSource, newsDay, newsDescription;

    public NewsItems(String newsTitle, String newsImageLink, String newsWriterName, String newsSource, String newsDay, String newsDescription)
    {
        this.newsTitle = newsTitle;
        this.newsImageLink = newsImageLink;
        this.newsWriterName = newsWriterName;
        this.newsSource = newsSource;
        this.newsDay = newsDay;
        this.newsDescription = newsDescription;
    }

    public NewsItems(String newsTitle, String newsWriterName, String newsSource, String newsDay, String newsDescription)
    {
        this.newsTitle = newsTitle;
        this.newsWriterName = newsWriterName;
        this.newsSource = newsSource;
        this.newsDay = newsDay;
        this.newsDescription = newsDescription;
        newsImageLink = "www.google.com";
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsImageLink() {
        return newsImageLink;
    }

    public void setNewsImageLink(String newsImageLink) {
        this.newsImageLink = newsImageLink;
    }

    public String getNewsWriterName() {
        return newsWriterName;
    }

    public void setNewsWriterName(String newsWriterName) {
        this.newsWriterName = newsWriterName;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    public String getNewsDay() {
        return newsDay;
    }

    public void setNewsDay(String newsDay) {
        this.newsDay = newsDay;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }
}
