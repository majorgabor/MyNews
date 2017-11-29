import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Comment } from '../../classes/comment';

@Component({
  selector: 'app-addcomment',
  templateUrl: './addcomment.component.html',
  styleUrls: ['./addcomment.component.css']
})
export class AddcommentComponent implements OnInit {
  @Output()
  public createComment: EventEmitter<Comment> = new EventEmitter();

  public clickButton(text: string): void {
    this.createComment.emit(new Comment(text));
  }
  constructor() { }

  ngOnInit() {
  }

}
