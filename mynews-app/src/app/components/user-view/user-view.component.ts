import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../../classes/user';
import { Message } from '../../classes/message';
import { UserService } from '../../services/user.service';
import { MessageService } from '../../services/message.service';

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.css'],
  providers: [UserService, MessageService]
})
export class UserViewComponent implements OnInit {
  private _user: User;

  public send(message: Message): void{
    this.messageService.sendMessage(message).subscribe();
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
      this._user = user;
    })
  }

}
