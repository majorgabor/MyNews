import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../../classes/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.css'],
  providers: [UserService]
})
export class UserViewComponent implements OnInit {
  private _user: User;

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private userService: UserService
  ) { }

  ngOnInit() {
    const id: number = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this.userService.profile(id).subscribe((user: User) => {
      this._user = user;
      console.log(user);
    })
  }

}
