import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { User } from '../../classes/user';

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.css']
})
export class LoginformComponent implements OnInit {
  @Output()
  public loginUser: EventEmitter<User> = new EventEmitter();

  public clickButton(email: string, password: string): void {
    this.loginUser.emit(new User(email, password));
  }

  constructor() { }

  ngOnInit() {
  }

}
