import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Course {

  constructor() { }

  getCourses(): string[] {
    return [
      'Java',
      'Angular',
      'Spring Boot',
      'Python',
      'React'
    ];
  }
}