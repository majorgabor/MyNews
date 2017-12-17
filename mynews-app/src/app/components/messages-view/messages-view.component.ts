import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { MessageService } from '../../services/message.service';
import { Message } from '../../classes/message';
import { User } from '../../classes/user';

@Component({
  selector: 'app-messages-view',
  templateUrl: './messages-view.component.html',
  styleUrls: ['./messages-view.component.css'],
  providers: [UserService, MessageService]
})
export class MessagesViewComponent implements OnInit {
  private _contacts: User[];

  public send(message: Message): void{
    this.messageService.sendMessage(message).subscribe((message: Message) => {
      this.messageService.contactList().subscribe((contacts: User[]) => {
        this._contacts = contacts;
      });
    });
  }

  constructor(
    private userService: UserService,
    private messageService : MessageService
  ) { }

  ngOnInit() {
    this.messageService.contactList().subscribe((contacts: User[]) => {
      this._contacts = contacts;
    });
  }

}
