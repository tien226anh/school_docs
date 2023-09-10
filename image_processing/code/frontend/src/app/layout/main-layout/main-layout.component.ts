import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main-layout',
  templateUrl: './main-layout.component.html',
  styleUrls: ['./main-layout.component.scss']
})
export class MainLayoutComponent implements OnInit{

  events: string [] = [];
  opened: boolean = false;

  constructor() { }

  ngOnInit(): void {

  }
}
