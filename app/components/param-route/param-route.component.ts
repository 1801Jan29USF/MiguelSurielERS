import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-param-route',
  templateUrl: './param-route.component.html',
  styleUrls: ['./param-route.component.css']
})
export class ParamRouteComponent implements OnInit, OnDestroy {
  id: string;
  name: string;

  nextId = '';
  nextName = '';

  private paramsSubscriber: Subscription;

  constructor(private activeRoute: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.paramsSubscriber = this.activeRoute.params.subscribe( (params) => {
      this.id = params.id;
      this.name = params.name;
    });
  }

  ngOnDestroy() {
    this.paramsSubscriber.unsubscribe();
  }

}
