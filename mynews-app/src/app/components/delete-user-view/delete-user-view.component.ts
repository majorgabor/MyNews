import { Component, OnInit } from '@angular/core';
import { User } from '../../classes/user';
import { UserService } from '../../services/user.service';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-delete-user-view',
  templateUrl: './delete-user-view.component.html',
  styleUrls: ['./delete-user-view.component.css'],
  providers: [UserService]
})
export class DeleteUserViewComponent implements OnInit {
  public _users: User[];
  public dataSource;
  displayedColumns = ['name', 'email', 'action'];

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

  constructor(
    private userService: UserService
  ) { }

  ngOnInit() {
    this.userService.allUser().subscribe((users: User[]) => {
      this._users = users;
      this.dataSource = new MatTableDataSource(this._users);
    });
  }

}
