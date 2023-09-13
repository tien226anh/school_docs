import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main-layout',
  templateUrl: './main-layout.component.html',
  styleUrls: ['./main-layout.component.scss']
})
export class MainLayoutComponent implements OnInit{

  events: string [] = [];
  opened = false;

  constructor() { return }

  ngOnInit(): void {
    return
  }
}
