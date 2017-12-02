import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../classes/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-view',
  templateUrl: './menu-view.component.html',
  styleUrls: ['./menu-view.component.css'],
  providers: [UserService]
})
export class MenuViewComponent implements OnInit {
  private _user: User;

  public profile(): void {
    this.userService.getLoggedInUser().subscribe((user: User) => {
      this.router.navigate(['profile/' + user.id])
    });
  }

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
    this.userService.syncLoginStatus();
  }

}
