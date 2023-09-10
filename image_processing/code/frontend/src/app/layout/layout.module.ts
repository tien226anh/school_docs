import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainLayoutComponent } from './main-layout/main-layout.component';
import { MaterialModule } from '@app/material-module';
import { CenteredContentLayoutComponent } from './centered-content-layout/centered-content-layout.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    MainLayoutComponent,
    CenteredContentLayoutComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FlexLayoutModule,
    RouterModule.forChild([])
  ],
  exports: [MainLayoutComponent, CenteredContentLayoutComponent]
})
export class LayoutModule { }
