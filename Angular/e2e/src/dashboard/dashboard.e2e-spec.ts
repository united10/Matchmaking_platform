import { Dashboard } from './dashboard.po';
describe('Dashboard tests', () => {
    let page: Dashboard;

    beforeEach(() => {
        page = new Dashboard();
        page.navigateTo();
    });
});

