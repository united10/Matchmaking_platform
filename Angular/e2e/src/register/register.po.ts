import { browser, by, element } from 'protractor';
export class Register {
    navigateTo() {
        return browser.get('/register');
    }
    getParagraphText() {
        return element(by.css('.suggest')).getText();
      }
}
