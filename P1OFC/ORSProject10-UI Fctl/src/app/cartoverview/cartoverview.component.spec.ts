import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CartoverviewComponent } from './cartoverview.component';

describe('CartoverviewComponent', () => {
  let component: CartoverviewComponent;
  let fixture: ComponentFixture<CartoverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CartoverviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CartoverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
