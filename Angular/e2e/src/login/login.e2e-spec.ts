import { LoginPage } from './login.po';
describe('Login tests', () => {
    let page: LoginPage;
    beforeEach(() => {
        page = new LoginPage();
        page.navigateTo();
    });
    it('Login form should be valid', () => {
        page.getEmailTextbox().sendKeys('info@stackroute.com');
        page.getPasswordTextbox().sendKeys('1234567');
        let form = page.getForm().getAttribute('class');
        console.log(form);
        expect(form).toContain('ng-valid');
       });
    it('Login form should be invalid', () => {
        page.getEmailTextbox().sendKeys('abv');
        page.getPasswordTextbox().sendKeys('');

        let form = page.getForm().getAttribute('class');

        expect(form).toContain('ng-invalid');
    });
        it('when user trying to login with not registered mail he should stay on “login” page and see error notification', () => {
        page.getEmailTextbox().sendKeys('info1@stackroute.com');
        page.getPasswordTextbox().sendKeys('123456');
        page.getSubmitButton().click();
        expect(page.getErrorMessage()).toEqual('user email not found');
    });
       it('when user trying to login with wrong credentials he should stay on “login” page and see error notification', () => {
        page.getEmailTextbox().sendKeys('info@stackroute.com');
        page.getPasswordTextbox().sendKeys('1234567');
        page.getSubmitButton().click();
        expect(page.getErrorMessage()).toEqual('Invalid Login.Please check your email and password');
    });
       it('when login is successful — he should redirect to default “dashboard” page', () => {
        page.getEmailTextbox().sendKeys('info@stackroute.com');
        page.getPasswordTextbox().sendKeys('1234567');
        page.getSubmitButton().click();
        expect(page.getErrorMessage()).toEqual('Basic Details');
       });

});
