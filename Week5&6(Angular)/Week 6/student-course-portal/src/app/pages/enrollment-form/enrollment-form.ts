import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { Store } from '@ngrx/store';
import { enrollStudent } from '../../store/enrollment/enrollment.actions';
import { Enrollment } from '../../models/enrollment.model';

@Component({
  selector: 'app-enrollment-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './enrollment-form.html',
  styleUrl: './enrollment-form.css'
})
export class EnrollmentForm {
  studentName = '';
  studentEmail = '';
  courseId = '';
  preferredSemester = '';
  agreeToTerms = false;
  successMessage = '';

  constructor(private store: Store) {}

  onSubmit(form: NgForm) {
    if (form.valid) {
      const enrollment: Enrollment = {
        id: Math.random().toString(36).substring(2, 9),
        courseId: this.courseId
      };
      
      this.store.dispatch(enrollStudent({ enrollment }));
      this.successMessage = 'Successfully enrolled!';
      
      setTimeout(() => {
        this.successMessage = '';
        this.onReset(form);
      }, 3000);
    }
  }

  onReset(form: NgForm) {
    form.resetForm();
    this.studentName = '';
    this.studentEmail = '';
    this.courseId = '';
    this.preferredSemester = '';
    this.agreeToTerms = false;
  }
}