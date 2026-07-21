import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Course } from '../../services/course';
import { CommonModule } from '@angular/common';
import { Highlight } from '../../directives/highlight';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';

@Component({
  selector: 'app-home',
  imports: [FormsModule, CommonModule, Highlight, CreditLabelPipe],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

  portalName = 'Student Course Portal';

  isPortalActive = true;

  message = '';

  searchTerm = '';

  onEnrollClick() {
    this.message = 'Enrollment opened!';
  }
hasCourses = true;
isTopStudent = true;
studentName = 'mohana priya';
today = new Date();
fees = 25000;
courses: string[] = [];

constructor(private courseService: Course) {
  this.courses = this.courseService.getCourses();
}
credits = 3;
}
