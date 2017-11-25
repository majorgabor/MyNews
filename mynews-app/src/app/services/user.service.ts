import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from "../classes/user";
import { Observable } from 'rxjs/Observable';
import { api } from '../config/api';

@Injectable()
export class UserService {

  constructor(
    private httpClient: HttpClient
  ) { }

  public login(user: User): Observable<any>{
    return this.httpClient.post(api + 'user/login', user);
  }

  public logout(user: User): Observable<any>{
    return this.httpClient.post(api + 'user/logout', user);
  }

  public register(user: User): Observable<any>{
    return this.httpClient.post(api + 'user/register', user);
  }

}
