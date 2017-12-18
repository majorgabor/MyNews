import { browser, by, element } from 'protractor';
import { getPath } from './getpath';

describe('Register functionality', () => {
    beforeEach(() => {
        browser.get('/register');
    })

    it('should be able to navigate to Register', () => {
        expect(getPath()).toEqual('/register');
    })

    it('should fail to not matching passwords', () => {
        element(by.css('input[type="text"]')).sendKeys('Kiss Jozsi');
        element(by.css('input[type="email"]')).sendKeys('test12@gmail.com');
        element(by.css('input[type="password"]')).sendKeys('test12');
        element(by.css('input[type="password"]')).sendKeys('nottest12');
        element(by.buttonText('REGISTER')).click();
        expect(getPath()).toEqual('/register');
    });

    it('should fail  to  matching passwords and not unique email', () => {
        element(by.css('input[type="text"]')).sendKeys('Kiss Jozsi');
        element(by.css('input[type="email"]')).sendKeys('test12@gmail.com');
        element(by.css('input[type="password"]')).sendKeys('test12');
        element(by.css('input[type="password"]')).sendKeys('test12');
        element(by.buttonText('REGISTER')).click();
        expect(getPath()).toEqual('/register');
    });

    it('should pass  to  matching passwords and unique email', () => {
        element(by.css('input[type="text"]')).sendKeys('Gipsz Jakab');
        element(by.css('input[type="email"]')).sendKeys('test123@gmail.com');
        element(by.css('input[type="password"]')).sendKeys('test12');
        element(by.css('input[type="password"]')).sendKeys('test12');
        element(by.buttonText('REGISTER')).click();
        expect(getPath()).toEqual('/news');
    });



  
})