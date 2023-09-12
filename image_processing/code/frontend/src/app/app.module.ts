import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from './layout/layout.module';
import { LoginModule } from './login/login.module';
import { RegisterModule } from './register/register.module';
import { DashboardModule } from './dashboard/dashboard.module';
import { MaterialModule } from './material-module';
import { HttpClientModule } from '@angular/common/http';
import { ImageprocessModule } from './imageprocess/imageprocess.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    LoginModule,
    RegisterModule,
    DashboardModule,
    MaterialModule,
    HttpClientModule,
    ImageprocessModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
