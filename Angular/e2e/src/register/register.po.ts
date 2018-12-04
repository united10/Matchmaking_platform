import { browser, by, element } from 'protractor';
export class Register {
    navigateTo() {
        return browser.get('/register');
    }
    getSubmitButtonText() {
        return element(by.css('.mat-raised-button')).getText();
    }
}
