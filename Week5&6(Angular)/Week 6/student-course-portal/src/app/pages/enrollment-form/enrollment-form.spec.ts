import { TestBed } from '@angular/core/testing';
import { EnrollmentForm } from './enrollment-form';
import { provideMockStore } from '@ngrx/store/testing';

describe('EnrollmentForm', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EnrollmentForm],
      providers: [provideMockStore({})]
    }).compileComponents();
  });

  it('should create', () => {
    const fixture = TestBed.createComponent(EnrollmentForm);
    const component = fixture.componentInstance;
    expect(component).toBeTruthy();
  });
});
