import { Component, OnInit } from '@angular/core';
import { User } from '../../classes/user';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-profile-view',
  templateUrl: './profile-view.component.html',
  styleUrls: ['./profile-view.component.css'],
  providers: [UserService]
})
export class ProfileViewComponent implements OnInit {
  private _user: User;
  private _error: string = "";

  public modify(user: User):void{
    const id: number = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this.userService.modify(id, user).subscribe((user: User) => {
      this.userService.profile(id).subscribe((user: User) => {
        this._user = user;
      }, (error) => {
        this._error = "Something went wrong!"
      });
    });
  }

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private userService: UserService
  ) { }

  ngOnInit() {
    const id: number = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this.userService.profile(id).subscribe((user: User) => {
      this._user = user;
    }, (error) => {
      this._error = "Something went wrong!"
    });
  }

}
