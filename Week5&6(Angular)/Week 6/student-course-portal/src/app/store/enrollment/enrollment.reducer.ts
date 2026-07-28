import { createReducer, on } from '@ngrx/store';
import { Enrollment } from '../../models/enrollment.model';
import * as EnrollmentActions from './enrollment.actions';

export interface EnrollmentState {
  enrollments: Enrollment[];
  loading: boolean;
  error: any;
}

export const initialState: EnrollmentState = {
  enrollments: [],
  loading: false,
  error: null
};

export const enrollmentReducer = createReducer(
  initialState,
  on(EnrollmentActions.loadEnrollments, state => ({ ...state, loading: true })),
  on(EnrollmentActions.loadEnrollmentsSuccess, (state, { enrollments }) => ({ ...state, enrollments, loading: false })),
  on(EnrollmentActions.loadEnrollmentsFailure, (state, { error }) => ({ ...state, error, loading: false })),
  
  on(EnrollmentActions.enrollStudentSuccess, (state, { enrollment }) => ({ ...state, enrollments: [...state.enrollments, enrollment] })),
  
  on(EnrollmentActions.unenrollStudentSuccess, (state, { id }) => ({ ...state, enrollments: state.enrollments.filter(e => e.id !== id) }))
);
