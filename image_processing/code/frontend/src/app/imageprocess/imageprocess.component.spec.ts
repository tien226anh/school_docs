import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageprocessComponent } from './imageprocess.component';

describe('ImageprocessComponent', () => {
  let component: ImageprocessComponent;
  let fixture: ComponentFixture<ImageprocessComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ImageprocessComponent]
    });
    fixture = TestBed.createComponent(ImageprocessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
