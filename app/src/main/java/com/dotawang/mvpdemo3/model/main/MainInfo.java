package com.dotawang.mvpdemo3.model.main;

/**
 * @author Dota.Wang
 * @date 2018/11/26
 * @description
 */

public class MainInfo {
    private int id;
    private String articlePic;
    private String articleTitle;
    private String articleContent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticlePic() {
        return articlePic;
    }

    public void setArticlePic(String articlePic) {
        this.articlePic = articlePic;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }
}
