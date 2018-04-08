/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Article;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author duy
 */
public class DanTriReader implements Reader{

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://dantri.com.vn/").get();
        Elements els = doc.select(".fr");
        for (Element el : els) {
            Article article = new Article();
            article.setUrl(el.attr("href"));
            article.setTitle(el.text());
            article.setStatus(1);
            System.out.println(article.toString());
        }
    }

    @Override
    public void getIndexArticles() {
        try {
            Document doc = Jsoup.connect("http://dantri.com.vn/").get();
            Elements els = doc.select(".fr");
            for (Element el : els) {
                Article article = new Article();
                article.setUrl(el.attr("href"));
                article.setTitle(el.text());
                article.setStatus(1);
                System.out.println(article.toString());
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void getListCategories() {
        System.out.println("Lấy danh mục từ vnexpress.net");
    }

    @Override
    public void getArticlesByCategory(String categoryName) {
        System.out.println("Lấy danh sach tin theo chuyên mục " + categoryName);
    }

    @Override
    public void getArticleDetail(String articleLink) {
        System.out.println("Lấy nội dung tin từ trang " + articleLink);
    }
}
