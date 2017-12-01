import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from "../classes/user";
import { Role } from "../classes/user";
import { Observable, Subject } from 'rxjs';
import { api } from '../config/api';

@Injectable()
export class UserService {
  private static loggedInUser: User = null;

  constructor(
    private httpClient: HttpClient
  ) { }

  public allUser(): Observable<any> {
    return this.httpClient.get(api + 'user');
  }

  public login(email: string, password: string): Observable<boolean> {
    const result = new Subject<boolean>();
    this.httpClient.post(api + 'user/login', { email, password }).subscribe((user: User) => {
      UserService.loggedInUser = user as User;
      result.next(true);
    }, (error) => {
      UserService.loggedInUser = null as User;
      result.next(false);
    });
    return result;
  }

  public logout(): void {
    this.httpClient.post(api + 'user/logout', null).subscribe(() => {
      UserService.loggedInUser = null;
    });
  }

  public register(name: string, email: string, password: string): Observable<boolean> {
    const result = new Subject<boolean>();
    this.httpClient.post(api + 'user/register', {name, email, password}).subscribe((user: User) => {
      result.next(true);
    }, (error) => {
      result.next(false);
    });
    return result;
  }

  public modify(id: number, user: User): Observable<any> {
    return this.httpClient.put(api + 'user/modify/' + id, user);
  }
  
  public profile(id: number): Observable<any> {
    return this.httpClient.get(api + 'user/profile/' + id);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete(api + 'user/delete/' + id);
  }

  public isLoggedIn(): boolean {
    return UserService.loggedInUser !== null;
  }

  public syncLoginStatus(): void {
    this.httpClient.get(api + "user/loggedin").subscribe((user: User) => {
      if(user){
        UserService.loggedInUser = user as User;
      } else {
        UserService.loggedInUser = null;
      }
    });
  }

  public userHasRole(role: Role[]): boolean {
    if (!this.isLoggedIn()) {
      return false;
    }
    return role.includes(UserService.loggedInUser.role);
  } 
}
