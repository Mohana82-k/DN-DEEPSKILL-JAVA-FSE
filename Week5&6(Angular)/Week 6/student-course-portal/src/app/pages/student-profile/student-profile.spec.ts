import { TestBed } from '@angular/core/testing';
import { StudentProfile } from './student-profile';
import { provideMockStore } from '@ngrx/store/testing';

describe('StudentProfile', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StudentProfile],
      providers: [
        provideMockStore({ initialState: { courses: {courses: []}, enrollments: {enrollments: []} } })
      ]
    }).compileComponents();
  });

  it('should create', () => {
    const fixture = TestBed.createComponent(StudentProfile);
    const component = fixture.componentInstance;
    expect(component).toBeTruthy();
  });
});
