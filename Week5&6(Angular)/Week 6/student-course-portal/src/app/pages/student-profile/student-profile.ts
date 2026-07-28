import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { Observable, map } from 'rxjs';
import { Course } from '../../models/course.model';
import { selectEnrolledCourses } from '../../store/enrollment/enrollment.selectors';

@Component({
  selector: 'app-student-profile',
  imports: [CommonModule],
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css',
})
export class StudentProfile implements OnInit {
  studentName = 'Mohana Priya';
  enrolledCourses$: Observable<Course[]>;
  gpa$: Observable<number>;

  constructor(private store: Store) {
    this.enrolledCourses$ = this.store.select(selectEnrolledCourses);
    
    this.gpa$ = this.enrolledCourses$.pipe(
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
