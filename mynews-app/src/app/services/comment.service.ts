import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Comment } from '../classes/comment';
import { api } from '../config/api';

@Injectable()
export class CommentService {

  constructor(
    private httpClient: HttpClient
  ) { }

  public getAllComments(): Observable<any> {
    return this.httpClient.get(api + 'news/comments/all');
  }

  public getCommentToNews(id: number) : Observable<any> {
    return this.httpClient.get(api + 'news/comments/' + id);
  }

  public addComment(id: number, comment: Comment) : Observable<any> {
    return this.httpClient.put(api + 'news/comments/addcomment/' + id, comment);
  }

  public rate(rate: string, id: number): Observable<any> {
    return this.httpClient.put(api + 'news/comments/' + rate + '/' + id, null);
  }

  public deleteComment(id: number) : Observable<any> {
    return this.httpClient.delete(api + 'news/comments/delete/' + id);
  }
}
