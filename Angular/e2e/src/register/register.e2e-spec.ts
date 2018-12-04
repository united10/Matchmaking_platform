import { Register } from './register.po';
describe('Registration tests', () => {
    let page: Register;

    beforeEach(() => {
        page = new Register();
        page.navigateTo();
    });
});

