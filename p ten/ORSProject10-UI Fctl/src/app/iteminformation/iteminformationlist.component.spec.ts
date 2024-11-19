import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IteminformationlistComponent } from './iteminformationlist.component';

describe('IteminformationlistComponent', () => {
  let component: IteminformationlistComponent;
  let fixture: ComponentFixture<IteminformationlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IteminformationlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IteminformationlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
