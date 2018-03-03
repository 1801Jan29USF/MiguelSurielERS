import { Component, Input } from '@angular/core';


@Component ({
    selector: 'app-hero',
    templateUrl: './hero.component.html',
    styleUrls: [
        './hero.component.css'
    ]
})



// export component
export class HeroComponent {
    @Input()
    hero: Hero;
}



// create a class hero with quality like a bean

export class Hero {
    id: number;
    name: string;
    imageUrl: string;
    power: number;
    constructor(id: number = 0, name: string = '', imageUrl: string = '', power: number = 0) {
      this.id = id;
      this.name = name;
      this.imageUrl = imageUrl;
      this.power = power;
}}
