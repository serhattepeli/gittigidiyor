package org.example;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class caseler extends org.example.driver {


    public By girisElementi = By.cssSelector("div[class='gekhq4-4 egoSnI']");
    public By girisButton = By.cssSelector("div[class='sc-12t95ss-3 fDarBX']");
    public By userName = By.cssSelector("input[name='kullanici']");
    public By userPass = By.cssSelector("input[type='password']");
    public By loginButton = By.cssSelector("input[id='gg-login-enter']");
    public By loginControl = By.cssSelector("div[class='gekhq4-4 egoSnI']>span");
    public By searchBox = By.cssSelector("input[type='text']");
    public By searchButton = By.cssSelector("button[type='submit']");
    public By secondPage = By.cssSelector("li[class='next-link']>a");
    public By pageCheck = By.cssSelector("a[class='current']");
    public By listOfProduct = By.cssSelector("li[id*='product_id']");
    public By addBox = By.cssSelector("button[id='add-to-basket']");
    public By price = By.cssSelector("div[id='sp-price-discountPrice']");
    public By goToBox = By.cssSelector("div[class='basket-icon-title hidden-m hidden-t']");
    public By cartPrice = By.cssSelector("p[class='new-price']");
    public By increaseDrp = By.cssSelector("select[class='amount']");
    public By deleteCart = By.cssSelector("a[title='Sil']");
    public By deger = By.cssSelector("div[class='product-group-box']");


    Methods methods = new Methods(driver);

    @Test
    public void Case1() {
        String title = methods.getTitle();
        Assert.assertTrue("siteye erişim saglanamadı", title.toLowerCase().contains("gittigidiyor"));
        methods.moveToElementHover(girisElementi);
        methods.click(girisButton);
        methods.sendKeys(userName, "serhattepeli@outlook.com");
        methods.sendKeys(userPass, "123asd123");
        methods.click(loginButton);
        String string = methods.getText(loginControl);
        Assert.assertFalse(string.contains("veya Üye Ol"));
    }


    @Test
    public void Case2() throws InterruptedException {

        methods.sendKeys(searchBox, "Bilgisayar");
        methods.click(searchButton);
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.cssSelector("li[class='next-link']>a"));
        methods.scrollToElementVisible(element);
        Thread.sleep(2000);
        methods.click(secondPage);
        Assert.assertEquals("2. sayfaya gelemedi", methods.getText(pageCheck), "2");

    }

    @Test
    public void Case3() throws InterruptedException {

        List<WebElement> liste = methods.findElements(listOfProduct);
        int b = methods.randomGenerator(liste);
        liste.get(b).click();
        WebElement element = driver.findElement(By.cssSelector("button[id='add-to-basket']"));
        methods.scrollToElementVisible(element);
        methods.click(addBox);
        Thread.sleep(3000);
        WebElement element1 = driver.findElement(By.cssSelector("div[class='basket-icon-title hidden-m hidden-t']"));
        methods.scrollToElementVisible(element1);
        Thread.sleep(3000);
        methods.click(goToBox);
        Thread.sleep(3000);
        Assert.assertEquals("fiyatlar eşleşmedi", methods.getText(price), methods.getText(cartPrice));
        methods.select(increaseDrp, "2");
        methods.click(deleteCart);
        Thread.sleep(3000);
        List<WebElement> degisken = methods.findElements(deger);
        Assert.assertEquals("hala sepette urun var", degisken.size(), 0);


    }
}
