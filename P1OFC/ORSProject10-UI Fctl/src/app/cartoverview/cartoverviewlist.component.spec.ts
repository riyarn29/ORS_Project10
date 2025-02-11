import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CartoverviewlistComponent } from './cartoverviewlist.component';

describe('CartoverviewlistComponent', () => {
  let component: CartoverviewlistComponent;
  let fixture: ComponentFixture<CartoverviewlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CartoverviewlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CartoverviewlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
