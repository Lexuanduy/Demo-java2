/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author duy
 */
public interface Reader {

    public void getIndexArticles();

    public void getListCategories();

    public void getArticlesByCategory(String categoryName);

    public void getArticleDetail(String articleLink);
}
