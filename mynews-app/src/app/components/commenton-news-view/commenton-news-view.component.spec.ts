import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommentonNewsViewComponent } from './commenton-news-view.component';

describe('CommentonNewsViewComponent', () => {
  let component: CommentonNewsViewComponent;
  let fixture: ComponentFixture<CommentonNewsViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommentonNewsViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommentonNewsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
