import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteCommentViewComponent } from './delete-comment-view.component';

describe('DeleteCommentViewComponent', () => {
  let component: DeleteCommentViewComponent;
  let fixture: ComponentFixture<DeleteCommentViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteCommentViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteCommentViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
