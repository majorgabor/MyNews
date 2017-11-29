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
  private _news: News[];

  public addNews(news: News): void {
    this.newsService.addNews(news).subscribe(() => {
      this.newsService.getAllNews().subscribe((newses: News[]) => {
        this._news = newses;
      });
    });
  }

  constructor(
    private newsService: NewsService
  ) { }

  ngOnInit() {
    this.newsService.getAllNews().subscribe((newses: News[]) => {
      this._news = newses;
    });
  }

}
