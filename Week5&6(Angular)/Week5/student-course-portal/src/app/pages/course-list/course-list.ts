import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Highlight } from '../../directives/highlight';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, Highlight],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList {

  courses = [
    'Java',
    'Angular',
    'Spring Boot',
    'Python',
    'React'
  ];

}