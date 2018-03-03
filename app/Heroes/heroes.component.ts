import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero/hero.component';
import { HeroService } from '../services/hero.service';


@Component({
    selector: 'app-heroes',
    templateUrl: './heroes.component.html',
    styleUrls: [
        './heroes.component.css'
    ]
})


// export component
export class HeroesComponent implements OnInit {

    heroes: Array<Hero> = [];
    newHero = new Hero;
    powerFilter = 0;

    constructor(private heroService: HeroService) {
    }

  ngOnInit() {
    this.heroes = this.heroService.heroes;
  }

    addHero(hero: Hero) {
        this.heroes.unshift(hero);
        this.newHero = new Hero();
    }
}



