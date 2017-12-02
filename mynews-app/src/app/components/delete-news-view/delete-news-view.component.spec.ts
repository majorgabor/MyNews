import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteNewsViewComponent } from './delete-news-view.component';

describe('DeleteNewsViewComponent', () => {
  let component: DeleteNewsViewComponent;
  let fixture: ComponentFixture<DeleteNewsViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteNewsViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteNewsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
