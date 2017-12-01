import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-register-view',
  templateUrl: './register-view.component.html',
  styleUrls: ['./register-view.component.css'],
  providers: [UserService]
})
export class RegisterViewComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
