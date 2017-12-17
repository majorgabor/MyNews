import { Component, OnInit, Input } from '@angular/core';
import { Message } from '../../classes/message';
import { User } from '../../classes/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css'],
  providers: [UserService]
})
export class ChatComponent implements OnInit {
  @Input()
  public message: Message;

  constructor(
    private userService: UserService
  ) { }

  ngOnInit() {
  }

}
