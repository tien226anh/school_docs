import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageprocessComponent } from './imageprocess.component';
import { MaterialModule } from '@app/material-module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    ImageprocessComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports: [ImageprocessComponent]
})
export class ImageprocessModule { }
