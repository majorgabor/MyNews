import { Component, OnInit } from '@angular/core';
import { News } from '../../classes/news';
import { NewsService } from '../../services/news.service';

@Component({
  selector: 'app-news-view',
  templateUrl: './news-view.component.html',
  styleUrls: ['./news-view.component.css'],
  providers: [NewsService]
})
export class NewsViewComponent implements OnInit {
  private _data: News[];

  constructor(
    private newsService: NewsService
  ) { }

  ngOnInit() {
    this.newsService.getAllNews().subscribe((newses: News[]) => {
      this._data = newses;
    });
  }

}