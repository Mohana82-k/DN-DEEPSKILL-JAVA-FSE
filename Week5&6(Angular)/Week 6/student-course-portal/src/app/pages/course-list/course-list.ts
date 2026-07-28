import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Highlight } from '../../directives/highlight';
import { Store } from '@ngrx/store';
import { Observable, combineLatest, map } from 'rxjs';
import { Course } from '../../models/course.model';
import { Enrollment } from '../../models/enrollment.model';
import { selectAllCourses, selectCoursesLoading } from '../../store/course/course.selectors';
import { selectAllEnrollments } from '../../store/enrollment/enrollment.selectors';
import { enrollStudent, unenrollStudent } from '../../store/enrollment/enrollment.actions';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';

interface CourseViewModel extends Course {
  isEnrolled: boolean;
  enrollmentId?: string;
}

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, Highlight, CreditLabelPipe],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {
  courses$: Observable<CourseViewModel[]>;
  loading$: Observable<boolean>;

  constructor(private store: Store) {
    this.loading$ = this.store.select(selectCoursesLoading);
    
    const allCourses$ = this.store.select(selectAllCourses);
    const allEnrollments$ = this.store.select(selectAllEnrollments);

    this.courses$ = combineLatest([allCourses$, allEnrollments$]).pipe(
      map(([courses, enrollments]) => {
        return courses.map(course => {
          const enrollment = enrollments.find(e => e.courseId === course.id);
          return {
            ...course,
            isEnrolled: !!enrollment,
            enrollmentId: enrollment?.id
          };
        });
      })
    );
  }

  ngOnInit(): void {}

  enroll(course: CourseViewModel): void {
    const newEnrollment: Enrollment = {
      id: Math.random().toString(36).substring(2, 9), // dummy id generation
      courseId: course.id
    };
    this.store.dispatch(enrollStudent({ enrollment: newEnrollment }));
  }

  unenroll(course: CourseViewModel): void {
    if (course.enrollmentId) {
      this.store.dispatch(unenrollStudent({ id: course.enrollmentId }));
    }
  }

  trackById(index: number, course: CourseViewModel): string {
    return course.id;
  }
}