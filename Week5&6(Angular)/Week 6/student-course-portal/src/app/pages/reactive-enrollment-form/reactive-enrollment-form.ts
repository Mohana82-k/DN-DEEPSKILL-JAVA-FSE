import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { noCourseCode } from './course-code.validator';
import { simulateEmailCheck } from './email.validator';
import {
  FormBuilder,
  FormGroup,
  FormArray,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';
import { Store } from '@ngrx/store';
import { enrollStudent } from '../../store/enrollment/enrollment.actions';
import { Enrollment } from '../../models/enrollment.model';

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css'
})
export class ReactiveEnrollmentForm {

  enrollForm: FormGroup;
  successMessage = '';

  constructor(private fb: FormBuilder, private store: Store) {
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      studentEmail: this.fb.control(
        '',
        [Validators.required, Validators.email],
        [simulateEmailCheck]
      ),
      courseId: ['', [Validators.required, noCourseCode]],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
      skills: this.fb.array([
        this.fb.control('')
      ]),
      additionalCourses: this.fb.array([])
    });
  }

  onSubmit() {
    if (this.enrollForm.valid) {
      // Dispatch primary course enrollment
      const primaryEnrollment: Enrollment = {
        id: Math.random().toString(36).substring(2, 9),
        courseId: this.enrollForm.value.courseId
      };
      this.store.dispatch(enrollStudent({ enrollment: primaryEnrollment }));

      // Dispatch additional courses enrollments
      const extraCourses = this.enrollForm.value.additionalCourses || [];
      extraCourses.forEach((cId: string) => {
        if (cId) {
          const extraEnrollment: Enrollment = {
            id: Math.random().toString(36).substring(2, 9),
            courseId: cId
          };
          this.store.dispatch(enrollStudent({ enrollment: extraEnrollment }));
        }
      });

      this.successMessage = 'Successfully enrolled in courses!';
      
      setTimeout(() => {
        this.successMessage = '';
        this.resetForm();
      }, 3000);
    }
  }

  resetForm() {
    this.enrollForm.reset({
      preferredSemester: 'Odd'
    });
    this.skills.clear();
    this.addSkill();
    this.additionalCourses.clear();
  }

  get skills(): FormArray {
    return this.enrollForm.get('skills') as FormArray;
  }

  addSkill() {
    this.skills.push(this.fb.control(''));
  }

  removeSkill(index: number) {
    this.skills.removeAt(index);
  }

  get additionalCourses(): FormArray {
    return this.enrollForm.get('additionalCourses') as FormArray;
  }

  addCourse() {
    this.additionalCourses.push(
      this.fb.control('', Validators.required)
    );
  }

  removeCourse(index: number) {
    this.additionalCourses.removeAt(index);
  }
}