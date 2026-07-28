import { createAction, props } from '@ngrx/store';
import { Enrollment } from '../../models/enrollment.model';

export const loadEnrollments = createAction('[Enrollment] Load Enrollments');
export const loadEnrollmentsSuccess = createAction('[Enrollment] Load Enrollments Success', props<{ enrollments: Enrollment[] }>());
export const loadEnrollmentsFailure = createAction('[Enrollment] Load Enrollments Failure', props<{ error: any }>());

export const enrollStudent = createAction('[Enrollment] Enroll Student', props<{ enrollment: Enrollment }>());
export const enrollStudentSuccess = createAction('[Enrollment] Enroll Student Success', props<{ enrollment: Enrollment }>());
export const enrollStudentFailure = createAction('[Enrollment] Enroll Student Failure', props<{ error: any }>());

export const unenrollStudent = createAction('[Enrollment] Unenroll Student', props<{ id: string }>());
export const unenrollStudentSuccess = createAction('[Enrollment] Unenroll Student Success', props<{ id: string }>());
export const unenrollStudentFailure = createAction('[Enrollment] Unenroll Student Failure', props<{ error: any }>());
