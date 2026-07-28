import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-not-found',
  standalone: true,
  imports: [CommonModule, RouterModule],
  template: `
    <div class="not-found-container">
      <h1>404</h1>
      <h2>Page Not Found</h2>
      <p>Oops! The page you are looking for does not exist.</p>
      <a routerLink="/" class="btn btn-primary">Return to Home</a>
    </div>
  `,
  styles: [`
    .not-found-container {
      text-align: center;
      padding: 5rem 2rem;
      max-width: 600px;
      margin: 0 auto;
    }
    h1 {
      font-size: 6rem;
      color: #1976d2;
      margin: 0;
      line-height: 1;
    }
    h2 {
      color: #333;
      margin-top: 1rem;
    }
    p {
      color: #666;
      font-size: 1.1rem;
      margin-bottom: 2rem;
    }
    .btn {
      display: inline-block;
      padding: 0.8rem 1.5rem;
      border-radius: 4px;
      text-decoration: none;
      font-weight: bold;
      transition: all 0.3s ease;
    }
    .btn-primary {
      background-color: #1976d2;
      color: white;
    }
    .btn-primary:hover {
      background-color: #1565c0;
    }
  `]
})
export class NotFound {}
