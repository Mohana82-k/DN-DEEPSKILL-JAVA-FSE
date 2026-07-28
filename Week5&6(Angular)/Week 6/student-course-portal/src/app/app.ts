import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './components/header/header';
import { Store } from '@ngrx/store';
import { loadCourses } from './store/course/course.actions';
import { loadEnrollments } from './store/enrollment/enrollment.actions';

@Component({
  selector: 'app-root',
  imports: [Header, RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  constructor(private store: Store) {}

  ngOnInit() {
    this.store.dispatch(loadCourses());
    this.store.dispatch(loadEnrollments());
  }
}