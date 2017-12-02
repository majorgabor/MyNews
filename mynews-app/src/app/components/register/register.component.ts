import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../classes/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers: [UserService]
})
export class RegisterComponent implements OnInit {
  private error: string = "";

  public register(name: string, email: string, password: string): void {
    this.userService.register(name, email, password).subscribe((succsess: boolean) => {
      if(succsess){
        this.userService.login(email, password);
        this.router.navigate(['news']);
      } else {
        this.error = "Wrong name, email or password. Try again!";
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
