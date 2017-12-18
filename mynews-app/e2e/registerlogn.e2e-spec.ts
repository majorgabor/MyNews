import { browser, by, element } from 'protractor';
import { getPath } from './getpath';

describe('Register and Login a functionality', () => {
    beforeEach(() => {
        browser.get('/register');
    })

    it('should be able to navigate to Register', () => {
        expect(getPath()).toEqual('/register');
    })

   

    it('should pass  to  matching passwords and unique email after logout and login again', () => {
        element(by.css('input[type="text"]')).sendKeys('Gipsz Jakab');
        element(by.css('input[type="email"]')).sendKeys('test1233@gmail.com');
        element(by.css('input[type="password"]')).sendKeys('test12');
        element(by.css('input[type="password"]')).sendKeys('test12');
        element(by.buttonText('REGISTER')).click();
        expect(getPath()).toEqual('/news');

        element(by.xpath('/html/body/app-root/app-menu-view/mat-toolbar/span[2]/button[2]/span')).click();

        element(by.css('input[type="email"]')).sendKeys('test1233@gmail.com');
        element(by.css('input[type="password"]')).sendKeys('test12');
        element(by.buttonText('LOGIN')).click();
        expect(getPath()).toEqual('/news');
        
        
        
    });



  
})