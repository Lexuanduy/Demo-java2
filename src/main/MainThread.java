/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.DanTriReader;
import controller.Reader;
import controller.VnExpressReader;
import java.util.Scanner;

/**
 *
 * @author duy
 */
public class MainThread {

    public static void main(String[] args) {
        generateMenu();
    }

    public static void generateMenu() {
        Scanner sc = new Scanner(System.in);
        VnExpressReader vnexpress = new VnExpressReader();

        System.out.println("Please choose a website to read: ");
        System.out.println("1. vnexpress.net");
        System.out.println("2. dantri.com.vn");
        System.out.println("Please enter your Websitechoice");
        int websiteChoice = sc.nextInt();
        sc.nextLine();

        Reader reader;
        if (websiteChoice == 1) {
            reader = new VnExpressReader();
        } else {
            reader = new DanTriReader();
        }

        while (true) {
            //Hiển thị menu chương trình.
            System.out.println("==========News Reader=========");
            System.out.println("1. Get index article.");
            System.out.println("2. Get lít categories.");
            System.out.println("3. Get article categories by categoty.");
            System.out.println("4. Get article detail.");
            System.out.println("==============================");
            //Yêu cầu người dùng lựa chon danh mục.
            System.out.println("Please enter your choice: ");
            int choice = sc.nextInt();
            //Ngay sau nextInt gọi nextLine để có thể nhận dữ liệu từ nextLine trong lần gọi sau
            sc.nextLine();
            //Dựa vào lựa chọn người dùng để thực hiện các thao tác tiếp theo.
            switch (choice) {
                case 1:
                    reader.getIndexArticles();
                    break;
                case 2:
                    reader.getListCategories();
                    break;
                case 3:
                    System.out.println("Nhập tên danh mục: ");
                    String categoryName = sc.nextLine();
                    reader.getArticlesByCategory(categoryName);
                    break;
                case 4:
                    System.out.println("Nhập link: ");
                    String articleLink = sc.nextLine();
                    reader.getArticleDetail(articleLink);
                    break;
                case 5:
                    System.out.println("Close program. See you again!");
                    break;
                default:
                    System.out.println("Wrong choice, please enter again: ");
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }
}
