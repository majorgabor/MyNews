import { Component, OnInit, Input } from '@angular/core';
import { Comment } from '../../classes/comment';
import { CommentService } from '../../services/comment.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css'],
  providers: [CommentService, UserService]
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
    private commentService: CommentService,
    private userService: UserService
  ) { }

  ngOnInit() {
  }

}
