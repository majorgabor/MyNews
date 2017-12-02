import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileEditformComponent } from './profile-editform.component';

describe('ProfileEditformComponent', () => {
  let component: ProfileEditformComponent;
  let fixture: ComponentFixture<ProfileEditformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileEditformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileEditformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
