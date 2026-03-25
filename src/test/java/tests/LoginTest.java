package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void shouldLoginSuccessfully() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        Assertions.assertTrue(
                inventoryPage.isLoaded(),
                "Inventory page did not load after login"
        );
    }
}
