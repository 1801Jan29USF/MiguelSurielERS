import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipe-demo',
  templateUrl: './pipe-demo.component.html',
  styleUrls: ['./pipe-demo.component.css']
})
export class PipeDemoComponent implements OnInit {

  str = 'HelLo';
  num = 5;
  day = new Date();

  constructor() { }

  ngOnInit() {

  }

}
