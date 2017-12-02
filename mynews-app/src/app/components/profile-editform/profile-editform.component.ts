import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { User } from '../../classes/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-profile-editform',
  templateUrl: './profile-editform.component.html',
  styleUrls: ['./profile-editform.component.css'],
  providers: [UserService]
})
export class ProfileEditformComponent implements OnInit {
  @Input()
  public user: User;

  @Output()
  public editUser: EventEmitter<User> = new EventEmitter();

  public clickButton(name: string, email: string, age: number, city: string, password: string, passwordre: string): void {
    if(password == passwordre){
      this.editUser.emit(new User(name, email, age, city, password));
    }
  }

  
  constructor(    
    private userService: UserService
  ) { }

  ngOnInit() {
  }

}
