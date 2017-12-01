import { Component, OnInit, Input } from '@angular/core';
import { News } from "../../classes/news";
import { NewsService } from "../../services/news.service";
import { UserService } from "../../services/user.service";

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css'],
  providers: [NewsService, UserService]
})
export class NewsComponent implements OnInit {
  @Input()
  public news: News;

  public rate(rate: string): void {
    this.newsService.rate(rate, this.news.id).subscribe((news: News) => {
      this.news = news;
    });
  }
  constructor(
    private newsService: NewsService,
    private userService: UserService
  ) { }

  ngOnInit() {
  }

}
