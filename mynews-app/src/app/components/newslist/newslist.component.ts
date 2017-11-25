import { Component, OnInit, Input } from '@angular/core';
import { News } from '../../classes/news';

@Component({
  selector: 'app-newslist',
  templateUrl: './newslist.component.html',
  styleUrls: ['./newslist.component.css']
})
export class NewslistComponent implements OnInit {
  @Input()
  public newses: News[];

  constructor() { }

  ngOnInit() {
  }

}
