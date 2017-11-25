import { Component, OnInit, Input } from '@angular/core';
import { News } from "../../classes/news";
import { NewsService } from "../../services/news.service";

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css'],
  providers: [NewsService]
})
export class NewsComponent implements OnInit {
  @Input()
  public news: News;

  constructor(
    private newsService: NewsService
  ) { }

  ngOnInit() {
  }

}
