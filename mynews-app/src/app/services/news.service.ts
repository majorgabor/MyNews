import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { api } from '../config/api';
import { User } from '../classes/user';
import { News } from '../classes/news';

@Injectable()
export class NewsService {

  constructor(
    private httpClient: HttpClient
  ) { }

  public getAllNews(): Observable<any> {
    return this.httpClient.get(api + 'news');
  }

  public getNewsById(id: number): Observable<any> {
    return this.httpClient.get(api+ '/news/' + id);
  }

  public addNews(news: News): Observable<any> {
    return this.httpClient.post(api + 'news/addnews', news);
  }

  public rate(rate: string, id: number): Observable<any> {
    return this.httpClient.put(api + 'news/' + rate + '/' + id, null);
  }

  public deleteNews(id: number): Observable<any> {
    return this.httpClient.delete(api + 'news/delete/' + id);
  }
}
