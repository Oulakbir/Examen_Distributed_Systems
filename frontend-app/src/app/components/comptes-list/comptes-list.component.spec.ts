import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComptesListComponent } from './comptes-list.component';

describe('ComptesListComponent', () => {
  let component: ComptesListComponent;
  let fixture: ComponentFixture<ComptesListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComptesListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComptesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
