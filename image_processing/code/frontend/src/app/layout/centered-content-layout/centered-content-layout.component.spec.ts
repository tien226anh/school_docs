import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CenteredContentLayoutComponent } from './centered-content-layout.component';

describe('CenteredContentLayoutComponent', () => {
  let component: CenteredContentLayoutComponent;
  let fixture: ComponentFixture<CenteredContentLayoutComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CenteredContentLayoutComponent]
    });
    fixture = TestBed.createComponent(CenteredContentLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
