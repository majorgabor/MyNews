import { Component, OnInit } from '@angular/core';
import { User } from '../../classes/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login-view',
  templateUrl: './login-view.component.html',
  styleUrls: ['./login-view.component.css'],
  providers: [UserService]
})
export class LoginViewComponent implements OnInit {

  constructor(
  ) { }

  ngOnInit() {

  }

}
