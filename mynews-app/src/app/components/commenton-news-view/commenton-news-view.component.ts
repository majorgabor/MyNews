import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { News } from '../../classes/news';
import { Comment } from '../../classes/comment';
import { NewsService } from '../../services/news.service';
import { CommentService } from '../../services/comment.service';

@Component({
  selector: 'app-commenton-news-view',
  templateUrl: './commenton-news-view.component.html',
  styleUrls: ['./commenton-news-view.component.css'],
  providers: [NewsService, CommentService]
})
export class CommentonNewsViewComponent implements OnInit {
  public _news: News;
  private _comments: Comment[];

  public addComment(comment: Comment): void {
    const id: number = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this.commentService.addComment(id, comment).subscribe(() => {
      this.commentService.getCommentToNews(id).subscribe((comments: Comment[]) => {
        this._comments = comments;
      });
    });
  }

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private newsService: NewsService,
    private commentService: CommentService
  ) { }

  ngOnInit() {
    const id: number = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this.newsService.getNewsById(id).subscribe((news: News) => {
      this._news = news;
    });
    this.commentService.getCommentToNews(id).subscribe((comments: Comment[]) => {
      this._comments = comments;
    });
  }

}
