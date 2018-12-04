import { browser, by, element } from 'protractor';
export class Dashboard {
    navigateTo() {
        return browser.get('/home/user');
    }
    getPageTitleText() {
        return element(by.className('titlee')).getText();
      }
}
