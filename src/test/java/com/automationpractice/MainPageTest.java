package com.automationpractice;

import com.automationpractice.annotations.Layer;
import com.automationpractice.annotations.Microservice;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Layer("web")
public class MainPageTest extends BaseTest {

    @DisplayName("В меню 'women' выбираем Casual Dresses")
    @Test
    public void casual() {
        open("/");
        $("a[title='Women']").hover();
        $("a[title='Casual Dresses']").click();
        $("span[class='cat-name']").shouldHave(exactText("casual dresses"));

    }

    @DisplayName("Ищем товар в поиске")
    @Microservice("Search")
    @Owner("VasilyBelov")
    @Test
    public void search() {
        step("Открываем главную страницу", (step) -> {
            open("/");
        });
        step("Набираем в поиске t-shirt  нажимаем искать", (step) -> {
            $("#search_query_top").setValue("t-shirt");
            $("button[name='submit_search']").click();
        });
        step("Проверяем что в результатах есть t-short", (step) -> {
            $("div .product-container").shouldHave(text("t-shirts"));
        });
    }

    @Test
    @Layer("main page")
    @DisplayName("Добавляем товар в корзину")
    void buyDresses() {
        open("/");
        step("добавляем товар в корзину", (step) -> {
            String itemName = $("div.product-container .product-name").getText();
            $("#layer_cart_product_title").shouldHave(exactText(itemName));
            $("div.product-container [title='Add to cart']").click();
        });
        step("Нажимаем на продолжить покупки", (step) -> {
            $(".layer_cart_cart .continue").click();
            $("div #layer_cart").shouldNotBe(visible);
        });
    }
}
