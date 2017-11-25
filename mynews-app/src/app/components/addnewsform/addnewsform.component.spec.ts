import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddnewsformComponent } from './addnewsform.component';

describe('AddnewsformComponent', () => {
  let component: AddnewsformComponent;
  let fixture: ComponentFixture<AddnewsformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddnewsformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddnewsformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
