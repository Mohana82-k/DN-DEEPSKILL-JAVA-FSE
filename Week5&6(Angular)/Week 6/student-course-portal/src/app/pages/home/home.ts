import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable, map } from 'rxjs';
import { selectAllCourses } from '../../store/course/course.selectors';
import { selectEnrolledCount, selectEnrolledCourses } from '../../store/enrollment/enrollment.selectors';

@Component({
  selector: 'app-home',
  imports: [CommonModule, RouterModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit {
  portalName = 'Student Course Portal';
  coursesCount$: Observable<number>;
  enrolledCount$: Observable<number>;
  gpa$: Observable<number>;

  constructor(private store: Store) {
    this.coursesCount$ = this.store.select(selectAllCourses).pipe(map(c => c.length));
    this.enrolledCount$ = this.store.select(selectEnrolledCount);
    
    // Calculate GPA based on enrolled courses (passed = 4, pending = 3, failed = 0)
    this.gpa$ = this.store.select(selectEnrolledCourses).pipe(
      map(courses => {
        if (courses.length === 0) return 0;
        const totalPoints = courses.reduce((sum, course) => {
          if (course.gradeStatus === 'passed') return sum + 4;
          if (course.gradeStatus === 'pending') return sum + 3;
          return sum;
        }, 0);
        return parseFloat((totalPoints / courses.length).toFixed(1));
      })
    );
  }

  ngOnInit(): void {}
}
