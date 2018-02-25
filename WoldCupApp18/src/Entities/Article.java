/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Doggaz Jihed
 */
public class Article {
    public int ARTICLE_ID;
    public String ARTICLE_TITLE;
    public String ARTICLE_DESCRIPTION;
    public String ARTICLE_IMAGE;
   
    
    public Article(){
    }
    
    public Article(int ARTICLE_ID,String ARTICLE_TITLE,String ARTICLE_IMAGE,String ARTICLE_DESC){
    
        this.ARTICLE_ID = ARTICLE_ID;
        this.ARTICLE_TITLE = ARTICLE_TITLE;
        this.ARTICLE_IMAGE = ARTICLE_IMAGE;
        this.ARTICLE_DESCRIPTION = ARTICLE_DESC;
    
    }
    
        public Article(String ARTICLE_TITLE,String ARTICLE_DESC,String ARTICLE_IMAGE){
    
        this.ARTICLE_TITLE = ARTICLE_TITLE;
        this.ARTICLE_DESCRIPTION = ARTICLE_DESC;
        this.ARTICLE_IMAGE = ARTICLE_IMAGE;
    
    }
        
 

    public int getARTICLE_ID() {
        return ARTICLE_ID;
    }

    public void setARTICLE_ID(int ARTICLE_ID) {
        this.ARTICLE_ID = ARTICLE_ID;
    }

    public String getARTICLE_TITLE() {
        return ARTICLE_TITLE;
    }

    public void setARTICLE_TITLE(String ARTICLE_TITLE) {
        this.ARTICLE_TITLE = ARTICLE_TITLE;
    }

    public String getARTICLE_DESCRIPTION() {
        return ARTICLE_DESCRIPTION;
    }

    public void setARTICLE_DESCRIPTION(String ARTICLE_DESC) {
        this.ARTICLE_DESCRIPTION = ARTICLE_DESC;
    }

    public String getARTICLE_IMAGE() {
        return ARTICLE_IMAGE;
    }

    public void setARTICLE_IMAGE(String ARTICLE_IMAGE) {
        this.ARTICLE_IMAGE = ARTICLE_IMAGE;
    }

    @Override
    public String toString() {
        return "Article{" + "ARTICLE_ID=" + ARTICLE_ID + ", ARTICLE_TITLE=" + ARTICLE_TITLE + ", ARTICLE_DESC=" + ARTICLE_DESCRIPTION + ", ARTICLE_IMAGE=" + ARTICLE_IMAGE + '}';
    }
        
        
}
