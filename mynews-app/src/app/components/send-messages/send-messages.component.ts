import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../classes/user';
import { Message } from '../../classes/message';

@Component({
  selector: 'app-send-messages',
  templateUrl: './send-messages.component.html',
  styleUrls: ['./send-messages.component.css'],
  providers: [UserService]
})
export class SendMessagesComponent implements OnInit {
  private _users: User[];
  private _error: string = "";

  @Output()
  public createMessage: EventEmitter<Message> = new EventEmitter();

  public clickButton(text: string, to: User): void {
    if(text.length > 0 && to != null){
      this.createMessage.emit(new Message(text, to));
      this._error = "";
    } else {
      this._error = "Something wrong!";
    }
  }

  constructor(
    private userService: UserService
  ) { }

  ngOnInit() {
    this.userService.allUser().subscribe((users: User[]) => {
      this._users = users;
    })
  }

}
