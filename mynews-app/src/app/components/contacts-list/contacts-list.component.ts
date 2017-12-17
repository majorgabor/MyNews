import { Component, OnInit, Input } from '@angular/core';
import { User } from '../../classes/user';

@Component({
  selector: 'app-contacts-list',
  templateUrl: './contacts-list.component.html',
  styleUrls: ['./contacts-list.component.css']
})
export class ContactsListComponent implements OnInit {
  @Input()
  public contacts: User[];

  constructor() { }

  ngOnInit() {
  }

}
