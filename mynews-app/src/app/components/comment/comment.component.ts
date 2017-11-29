import { Component, OnInit, Input } from '@angular/core';
import { Comment } from '../../classes/comment';
import { CommentService } from '../../services/comment.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css'],
  providers: [CommentService]
})
export class CommentComponent implements OnInit {
  @Input()
  public comment: Comment;

  public rate(rate: string): void {
    this.commentService.rate(rate, this.comment.id).subscribe((comment: Comment) => {
      this.comment = comment;
    });
  }
  constructor(
    private commentService: CommentService
  ) { }

  ngOnInit() {
  }

}
