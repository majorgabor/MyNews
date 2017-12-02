import { Component, OnInit, Input } from '@angular/core';
import { Message } from '../../classes/message';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  @Input()
  public messages: Message[];
  public dataSource;
  displayedColumns = ['from', 'message'];

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

  constructor() { }

  ngOnInit() {
    this.dataSource = new MatTableDataSource(this.messages);
  }

}
