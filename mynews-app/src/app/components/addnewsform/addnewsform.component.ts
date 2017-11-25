import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { News } from '../../classes/news';

@Component({
  selector: 'app-addnewsform',
  templateUrl: './addnewsform.component.html',
  styleUrls: ['./addnewsform.component.css']
})
export class AddnewsformComponent implements OnInit {
  @Output()
  public createNews: EventEmitter<News> = new EventEmitter();

  public clickButton(text: string): void {
    this.createNews.emit(new News(text));
  }

  constructor() { }

  ngOnInit() {
  }

}
