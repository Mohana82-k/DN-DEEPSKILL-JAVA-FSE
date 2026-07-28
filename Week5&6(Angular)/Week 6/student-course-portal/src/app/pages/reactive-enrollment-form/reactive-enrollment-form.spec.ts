import { TestBed } from '@angular/core/testing';
import { ReactiveEnrollmentForm } from './reactive-enrollment-form';
import { provideMockStore } from '@ngrx/store/testing';

describe('ReactiveEnrollmentForm', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReactiveEnrollmentForm],
      providers: [provideMockStore({})]
    }).compileComponents();
  });

  it('should create', () => {
    const fixture = TestBed.createComponent(ReactiveEnrollmentForm);
    const component = fixture.componentInstance;
    expect(component).toBeTruthy();
  });
});
