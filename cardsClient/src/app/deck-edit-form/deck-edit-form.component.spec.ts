import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeckEditFormComponent } from './deck-edit-form.component';

describe('DeckFormComponent', () => {
  let component: DeckEditFormComponent;
  let fixture: ComponentFixture<DeckEditFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeckEditFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeckEditFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});