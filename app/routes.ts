import { Routes } from '@angular/router';
import { FirstComponent } from './components/first/first.component';
import { SecondComponent } from './components/second/second.component';
import { HeroesComponent } from './components/heroes/heroes.component';
import { ClickerComponent } from './components/clicker/clicker.component';
import { PipeDemoComponent } from './components/pipe-demo/pipe-demo.component';
import { ParentComponent } from './components/parent/parent.component';
import { Child1Component } from './componenets/parent/child1/child1.component';
import { Child2Component } from './components/parent/child2/child2.component';
import { Child3Component } from './components/parent/child3/child3.component';
import { Child4Component } from './components/parent/child4/child4.component';
import { Child5Component } from './components/parent/child5/child5.component';
import { Child6Component } from './components/parent/child6/child6.component';
import { ParamRouteComponent } from './components/param-route/param-route.component';
import { ParamParentComponent } from './components/param-parent/param-parent.component';
import { PokemonComponent } from './components/pokemon/pokemon.component';
import { LoginComponent } from './components/login/login.component';
import { TicketsComponent } from './components/tickets/tickets.component';
import { LoggedInGuard } from './guard/logged-in.guard';
import { MenuComponent } from './main-menu/menu/menu.component';
import { HomeComponent } from './home/home/home.component';
import { RegisterComponent } from './register/register/register.component';
import { SubmitticketComponent } from './submitticket/submitticket/submitticket.component';
import { PendingComponent } from './pending/pending/pending.component';
import { ChangeroleComponent } from './changerole/changerole/changerole.component';
import { EmployeeComponent } from './components/employee/employee.component';

export const appRoutes: Routes = [
  {
    path: 'first',
    component: FirstComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'employee',
    component: EmployeeComponent
  },
  {
    path: 'changerole',
    component: ChangeroleComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'tickets',
    component: TicketsComponent,
  },
  {
    path: 'submitticket',
    component: SubmitticketComponent,
  },
  {
    path: 'pending',
    component: PendingComponent,
  },
   {
    path: 'mainmenu',
    component: MenuComponent,
  },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'second',
    component: SecondComponent
  },
  {
    path: 'heroes',
    component: HeroesComponent
  },
  {
    path: 'clicker',
    component: ClickerComponent,
  },
  {
    path: 'pipe',
    component: PipeDemoComponent
  },
  {
    path: 'param/:id/:name',
    component: ParamRouteComponent
  },
  {
    path: 'pokemon',
    component: PokemonComponent
  },
  {
    path: 'parent',
    component: ParentComponent,
    children: [
      {
        path: 'child1',
        component: Child1Component
      },
      {
        path: 'child2',
        component: Child2Component
      },
      {
        path: 'child3',
        component: Child3Component
      },
      {
        path: 'child4',
        component: Child4Component
      },
      {
        path: 'child5',
        component: Child5Component
      },
      {
        path: 'child6',
        component: Child6Component
      },
      {
        path: '**',
        pathMatch: 'full',
        redirectTo: '/parent'
      }
    ]
  },
  {
    path: '**',
    pathMatch: 'full',
    redirectTo: 'mainmenu'
  }
];
