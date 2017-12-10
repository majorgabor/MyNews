import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { MatTableDataSource } from '@angular/material';
import { News } from '../../classes/news';
import { NewsService } from '../../services/news.service';

@Component({
  selector: 'app-delete-news-view',
  templateUrl: './delete-news-view.component.html',
  styleUrls: ['./delete-news-view.component.css'],
  providers: [UserService, NewsService]
})
export class DeleteNewsViewComponent implements OnInit {
  private _newses: News[];
  public _error: string = "";
  public dataSource;
  displayedColumns = ['user', 'news', 'reported', 'action'];

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

  public deleteNews(id: number): void {
    this.newsService.deleteNews(id).subscribe((news: News) => {
      this.newsService.getAllNews().subscribe((newses: News[]) => {
        this._newses = newses;
        this.dataSource = new MatTableDataSource(this._newses);
      });
    });
  }

  public deleteReport(id: number): void {
    this.newsService.deleteReportNews(id).subscribe((news: News) => {
      this.newsService.getAllNews().subscribe((newses: News[]) => {
        this._newses = newses;
        this.dataSource = new MatTableDataSource(this._newses);
      });
    });
  }

  constructor(
    private userService: UserService,
    private newsService: NewsService
  ) { }

  ngOnInit() {
    this.newsService.getAllNews().subscribe((newses: News[]) => {
      this._newses = newses;
      this.dataSource = new MatTableDataSource(this._newses);
    });
  }

}
