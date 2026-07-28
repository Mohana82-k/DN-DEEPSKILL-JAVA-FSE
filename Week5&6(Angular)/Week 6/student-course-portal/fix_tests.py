import os

tests = {
    'src/app/pages/home/home.spec.ts': """import { TestBed } from '@angular/core/testing';
import { Home } from './home';
import { provideMockStore } from '@ngrx/store/testing';
import { provideRouter } from '@angular/router';

describe('Home', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Home],
      providers: [
        provideMockStore({ initialState: { courses: {courses: []}, enrollments: {enrollments: []} } }),
        provideRouter([])
      ]
    }).compileComponents();
  });

  it('should create', () => {
    const fixture = TestBed.createComponent(Home);
    const component = fixture.componentInstance;
    expect(component).toBeTruthy();
  });
});
""",
    'src/app/pages/course-list/course-list.spec.ts': """import { TestBed } from '@angular/core/testing';
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
""",
    'src/app/pages/student-profile/student-profile.spec.ts': """import { TestBed } from '@angular/core/testing';
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
""",
    'src/app/pages/enrollment-form/enrollment-form.spec.ts': """import { TestBed } from '@angular/core/testing';
import { EnrollmentForm } from './enrollment-form';
import { provideMockStore } from '@ngrx/store/testing';

describe('EnrollmentForm', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EnrollmentForm],
      providers: [provideMockStore({})]
    }).compileComponents();
  });

  it('should create', () => {
    const fixture = TestBed.createComponent(EnrollmentForm);
    const component = fixture.componentInstance;
    expect(component).toBeTruthy();
  });
});
""",
    'src/app/pages/reactive-enrollment-form/reactive-enrollment-form.spec.ts': """import { TestBed } from '@angular/core/testing';
import { ReactiveEnrollmentForm } from './reactive-enrollment-form';
import { provideMockStore } from '@ngrx/store/testing';

describe('ReactiveEnrollmentForm', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReactiveEnrollmentForm],
      providers: [provideMockStore({})]
    }).compileComponents();
  });

  it('should create', () => {
    const fixture = TestBed.createComponent(ReactiveEnrollmentForm);
    const component = fixture.componentInstance;
    expect(component).toBeTruthy();
  });
});
""",
    'src/app/components/header/header.spec.ts': """import { TestBed } from '@angular/core/testing';
import { Header } from './header';
import { provideRouter } from '@angular/router';

describe('Header', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Header],
      providers: [provideRouter([])]
    }).compileComponents();
  });

  it('should create', () => {
    const fixture = TestBed.createComponent(Header);
    const component = fixture.componentInstance;
    expect(component).toBeTruthy();
  });
});
""",
    'src/app/services/course.spec.ts': """import { TestBed } from '@angular/core/testing';
import { CourseService } from './course';
import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting } from '@angular/common/http/testing';

describe('CourseService', () => {
  let service: CourseService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [provideHttpClient(), provideHttpClientTesting()]
    });
    service = TestBed.inject(CourseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
""",
    'src/app/services/enrollment.spec.ts': """import { TestBed } from '@angular/core/testing';
import { EnrollmentService } from './enrollment';
import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting } from '@angular/common/http/testing';

describe('EnrollmentService', () => {
  let service: EnrollmentService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [provideHttpClient(), provideHttpClientTesting()]
    });
    service = TestBed.inject(EnrollmentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
"""
}

for path, content in tests.items():
    if os.path.exists(path):
        with open(path, 'w') as f:
            f.write(content)
        print(f"Updated {path}")
    else:
        print(f"File not found {path}")
