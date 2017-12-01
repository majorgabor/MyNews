import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteUserViewComponent } from './delete-user-view.component';

describe('DeleteUserViewComponent', () => {
  let component: DeleteUserViewComponent;
  let fixture: ComponentFixture<DeleteUserViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteUserViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteUserViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
