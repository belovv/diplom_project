package com.automationpractice;

import com.automationpractice.annotations.Layer;
import com.automationpractice.annotations.Microservice;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("web")
public class MainPageTest extends BaseTest {


    @DisplayName("Кликаем бесплатные курсы")
    @Test
    public void openMainPage() {
        step("открываем главную страницу", (step) -> {
            open("/");
        });
        step("Кликаем на бесплатно", (step) -> {
            $("div .dropdown-wrapper-free").click();
        });
        step("Кликаем на пробные уроки", (step) -> {
            $("[href*='trial-lessons']").click();
        });
        step("проверяем", (step) -> {
            $("section .trial-header__title").shouldHave(text("Запишитесь на пробный онлайн-урок"));
        });

    }
    @Microservice("Repository")
    @DisplayName("Выбираем курс 'егэ'")
    @Test
    public void buyDemoItem() {
        step("открываем главную страницу", (step) -> {
            open("/");
        });
        step("кликаем на егэ", (step) -> {
            $(".card [href*='ege']").click();
            $("div .header-ege__title").shouldHave(text("Онлайн-курсы подготовки к ЕГЭ"));
        });
    }
    @Owner("Belov")
    @DisplayName("входим в личный кабинет")
    @Test
    public void clickOnSign() {
        open("/");
        step("Нажимаем на иконку профиля", (step) -> {
            $("a.icon-person rect").click();
            switchTo().window(1);
            $("[data-test='title']").shouldHave(exactText("ВХОД В ОНЛАЙН-МОДУЛЬ"));
        });
    }

    @Owner("Vasil")
    @DisplayName("Идем в магазин")
    @Test
    public void clickOnRegistration() {
        open("/");
        step("кликаем на магазин", (step) -> {
            $("a.icon-store svg").click();
            switchTo().window(1);
            $(".top-menu__item--store").shouldHave(exactText("Магазин"));
        });
    }


    @AllureId("2078")
    @DisplayName("Ищем товар в поиске")
    @Tag("web")
    @Microservice("Search")
    @Owner("VasilyBelov")
    @Test
    public void search() {
        step("Открываем главную страницу", (step) -> {
            open("/");
        });
        step("Набираем в поиске t-shirt  нажимаем искать", (step)->{
            $("#search_query_top").setValue("t-shirt");
            $("button[name='submit_search']").click();
                });
        step("Проверяем что в результатах есть t-short", (step) -> {
            $("div .product-container").shouldHave(text("t-shirts"));
        });
    }

}
