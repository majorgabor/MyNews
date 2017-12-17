import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { Message } from '../../classes/message';
import { User } from '../../classes/user';
import { MessageService } from '../../services/message.service';


@Component({
  selector: 'app-chat-view',
  templateUrl: './chat-view.component.html',
  styleUrls: ['./chat-view.component.css'],
  providers: [UserService, MessageService]
})
export class ChatViewComponent implements OnInit {
  private _messages: Message[];
  private _chatUser: User;
  private _me: User;

  public send(message: Message): void{
    this.messageService.sendMessage(message).subscribe((message: Messege) => {
      const id: number = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
      this.messageService.messagesFrom(id).subscribe((messages: Message[]) => {
        this._messages = messages;
      });
    });
  }

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private userService: UserService,
    private messageService: MessageService
  ) { }

  ngOnInit() {
    const id: number = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this.userService.profile(id).subscribe((user: User) => {
      this._chatUser = user;
    });
    this.messageService.messagesFrom(id).subscribe((messages: Message[]) => {
      this._messages = messages;
    });
    this.userService.getLoggedInUser().subscribe((user: User) => {
      this._me = user;
    });
  }

}
