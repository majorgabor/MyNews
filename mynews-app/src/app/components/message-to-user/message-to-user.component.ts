import { Component, OnInit, Input,Output, EventEmitter } from '@angular/core';
import { User } from '../../classes/user';
import { Message } from '../../classes/message';
import { UserService } from '../../services/user.service';
import { MessageService } from '../../services/message.service';

@Component({
  selector: 'app-message-to-user',
  templateUrl: './message-to-user.component.html',
  styleUrls: ['./message-to-user.component.css'],
  providers: [UserService, MessageService]
})
export class MessageToUserComponent implements OnInit {
  private _error: string;
  @Input()
  public user: User;
  @Output()
  public createMessage: EventEmitter<Message> = new EventEmitter();

  public clickButton(text: string): void {
    if(text.length > 0){
      this.createMessage.emit(new Message(text, this.user));
      this._error = "";
    } else {
      this._error = "Something wrong!";
    }
  }

  constructor(
    private userService: UserService
  ) { }

  ngOnInit() {
  }

}
