import { TestBed } from '@angular/core/testing';
import { CourseList } from './course-list';
import { provideMockStore } from '@ngrx/store/testing';

describe('CourseList', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseList],
      providers: [
        provideMockStore({ initialState: { courses: {courses: [], loading: false}, enrollments: {enrollments: []} } })
      ]
    }).compileComponents();
  });

  it('should create', () => {
    const fixture = TestBed.createComponent(CourseList);
    const component = fixture.componentInstance;
    expect(component).toBeTruthy();
  });
});
