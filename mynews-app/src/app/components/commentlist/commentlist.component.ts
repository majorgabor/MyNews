import { Component, OnInit, Input } from '@angular/core';
import { Comment } from '../../classes/comment';

@Component({
  selector: 'app-commentlist',
  templateUrl: './commentlist.component.html',
  styleUrls: ['./commentlist.component.css']
})
export class CommentlistComponent implements OnInit {
  @Input()
  public comments: Comment[]
  constructor() { }

  ngOnInit() {
  }

}
