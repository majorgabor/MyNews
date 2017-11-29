import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from "../classes/user";
import { Observable } from 'rxjs/Observable';
import { api } from '../config/api';

@Injectable()
export class UserService {
  private loggedInUser: User;

  constructor(
    private httpClient: HttpClient
  ) { }

  public actualUser(): Observable<any> {
    return this.httpClient.get(api + 'user');
  }

  public login(user: User): Observable<any> {
    return this.httpClient.post(api + 'user/login', user);
  }

  public logout(user: User): Observable<any> {
    return this.httpClient.post(api + 'user/logout', user);
  }

  public register(user: User): Observable<any> {
    return this.httpClient.post(api + 'user/register', user);
  }

  public modify(id: number, user: User): Observable<any> {
    return this.httpClient.put(api + 'user/modify/' + id, user);
  }
  
  public profile(id: number): Observable<any> {
    return this.httpClient.get(api + 'user/profile/' + id);
  }

  public getLoggedInUser(): User {
    return this.loggedInUser;
  }

  public setLoggedInUser(user: User): void {
    this.loggedInUser = user;
  }
}
