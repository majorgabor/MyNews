import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../../classes/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-delete-user',
  templateUrl: './delete-user.component.html',
  styleUrls: ['./delete-user.component.css'],
  providers: [UserService]
})
export class DeleteUserComponent implements OnInit {
  private _error: string = "";

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private userService: UserService
  ) { }

  ngOnInit() {
    const id: number = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this.userService.delete(id).subscribe((user: User) => {
      this.router.navigate(['admin/delete']);
    }, (error) => {
      this._error = "Somethin went wrong!";
    });
  }

}
