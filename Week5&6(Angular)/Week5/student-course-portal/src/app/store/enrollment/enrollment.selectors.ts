import { createFeatureSelector, createSelector } from '@ngrx/store';
import { EnrollmentState } from './enrollment.reducer';
import { selectAllCourses } from '../course/course.selectors';

export const selectEnrollmentState = createFeatureSelector<EnrollmentState>('enrollments');

export const selectAllEnrollments = createSelector(
  selectEnrollmentState,
  (state: EnrollmentState) => state.enrollments
);

export const selectEnrolledCount = createSelector(
  selectAllEnrollments,
  (enrollments) => enrollments.length
);

export const selectEnrollmentsLoading = createSelector(
  selectEnrollmentState,
  (state: EnrollmentState) => state.loading
);

// Derived selector to get full course details for enrolled courses
export const selectEnrolledCourses = createSelector(
  selectAllEnrollments,
  selectAllCourses,
  (enrollments, courses) => {
    const courseIds = enrollments.map(e => e.courseId);
    return courses.filter(c => courseIds.includes(c.id));
  }
);
