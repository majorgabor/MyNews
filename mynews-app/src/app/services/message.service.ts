import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { api } from '../config/api';
import { Message } from '../classes/message';

@Injectable()
export class MessageService {

  constructor(
    private httpClient: HttpClient
  ) { }

  public mymessages(): Observable<any> {
    return this.httpClient.get(api + 'messages/mymessages');
  }

  public sendMessage(message: Message): Observable<any> {
    return this.httpClient.post(api + "messages/send", message);
  }

  public contactList(): Observable<any> {
    return this.httpClient.get(api + 'messages/contacts');
  }

  public messagesFrom(id: number): Observable<any> {
    return this.httpClient.get(api + 'messages/from/' + id);
  }
}
