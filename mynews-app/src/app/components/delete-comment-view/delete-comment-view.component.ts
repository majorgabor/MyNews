import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { MatTableDataSource } from '@angular/material';
import { CommentService } from '../../services/comment.service';
import { Comment } from '../../classes/comment';

@Component({
  selector: 'app-delete-comment-view',
  templateUrl: './delete-comment-view.component.html',
  styleUrls: ['./delete-comment-view.component.css'],
  providers: [UserService, CommentService]
})
export class DeleteCommentViewComponent implements OnInit {
  private _comments: Comment[];
  private _error: string ="";
  public dataSource;
  displayedColumns = ['user', 'news', 'comment', 'action'];

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

  constructor(
    private userService: UserService,
    private commentService: CommentService
  ) { }

  public deleteComment(id: number): void {
    this.commentService.deleteComment(id).subscribe((comment: Comment) => {
      this.commentService.getAllComments().subscribe((comments: Comment[]) => {
        this._comments = comments;
        this.dataSource = new MatTableDataSource(this._comments);
      });
    });
  }

  ngOnInit() {
    this.commentService.getAllComments().subscribe((comments: Comment[]) => {
      this._comments = comments;
      this.dataSource = new MatTableDataSource(this._comments);
    });
  }

}
