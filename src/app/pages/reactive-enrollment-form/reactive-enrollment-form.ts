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

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css'
})
export class ReactiveEnrollmentForm {

  enrollForm: FormGroup;

  constructor(private fb: FormBuilder) {

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
    console.log(this.enrollForm.value);
    console.log(this.enrollForm.getRawValue());
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