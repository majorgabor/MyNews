import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../classes/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.css'],
  providers: [UserService]
})
export class LoginformComponent implements OnInit {
  private error: string = '';

  public login(email: string, password: string): void {
    this.userService.login(email, password).subscribe((succsess: boolean) => {
      if(succsess){
        this.router.navigate(['news']);
      } else {
        this.error = "Wrong email or password!";
      }
    });
  }

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
  }

}
