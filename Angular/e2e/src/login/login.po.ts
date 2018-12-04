import { browser, by, element } from 'protractor';
export class LoginPage {
    navigateTo() {
        return browser.get('/');
    }
    getEmailTextbox() {
        return element(by.name('email'));
    }

    getPasswordTextbox() {
        return element(by.name('password'));
    }

    getForm() {
        return element(by.css('#loginForm'));
    }

    getSubmitButton() {
        return element(by.css('.mat-raised-button'));
    }

    getErrorMessage() {
        return element(by.className('alert')).getText();
    }
}
