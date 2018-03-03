import { Component, OnInit } from '@angular/core';
import { Ticket } from '../../beans/ticket';
import { HttpClient } from '@angular/common/http';
import {Location} from '@angular/common';


@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrls: ['./tickets.component.css']
})
export class TicketsComponent implements OnInit {

  tickets: Array<Ticket> = [];
  constructor(private client: HttpClient, private _location: Location) { }

  ngOnInit() {
    this.client.get('http://localhost:8080/ExpenseReimbursement/ticket',
    {withCredentials: true})
    .subscribe(
      (succ: Array<Ticket>) => {
        this.tickets = succ;
      },
      (err) => {
        console.log('failed to load tickets');
      }
    );
}
backClicked() {
  this._location.back();
}

}
