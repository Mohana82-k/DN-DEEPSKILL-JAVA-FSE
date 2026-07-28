import { Injectable, inject } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { EnrollmentService } from '../../services/enrollment';
import * as EnrollmentActions from './enrollment.actions';
import { catchError, map, mergeMap, of } from 'rxjs';

@Injectable()
export class EnrollmentEffects {
  private actions$ = inject(Actions);
  private enrollmentService = inject(EnrollmentService);

  loadEnrollments$ = createEffect(() => this.actions$.pipe(
    ofType(EnrollmentActions.loadEnrollments),
    mergeMap(() => this.enrollmentService.getEnrollments()
      .pipe(
        map(enrollments => EnrollmentActions.loadEnrollmentsSuccess({ enrollments })),
        catchError(error => of(EnrollmentActions.loadEnrollmentsFailure({ error })))
      ))
    )
  );

  enrollStudent$ = createEffect(() => this.actions$.pipe(
    ofType(EnrollmentActions.enrollStudent),
    mergeMap((action) => this.enrollmentService.enrollStudent(action.enrollment)
      .pipe(
        map(enrollment => EnrollmentActions.enrollStudentSuccess({ enrollment })),
        catchError(error => of(EnrollmentActions.enrollStudentFailure({ error })))
      ))
    )
  );

  unenrollStudent$ = createEffect(() => this.actions$.pipe(
    ofType(EnrollmentActions.unenrollStudent),
    mergeMap((action) => this.enrollmentService.unenrollStudent(action.id)
      .pipe(
        map(() => EnrollmentActions.unenrollStudentSuccess({ id: action.id })),
        catchError(error => of(EnrollmentActions.unenrollStudentFailure({ error })))
      ))
    )
  );
}
