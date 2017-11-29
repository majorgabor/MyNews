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

  public login(user: User): void {
    this.userService.login(user).subscribe((loggedinUser: User) => {
      this.userService.setLoggedInUser(loggedinUser);
    });
  }

  constructor(
    private userService: UserService
  ) { }

  ngOnInit() {

  }

}
