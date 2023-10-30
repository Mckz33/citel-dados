import { MediaIdadeSanguineoService } from './../../services/media-idade-sanguineo/media-idade-sanguineo.service';
import { Component } from '@angular/core';
import { MediaIdadeSanguineo } from 'src/app/models/media-idade-sanguineo';

@Component({
  selector: 'app-media-idade-sanguineo',
  templateUrl: './media-idade-sanguineo.component.html',
  styleUrls: ['./media-idade-sanguineo.component.css']
})
export class MediaIdadeSanguineoComponent {

  mediaIdadeSanguineo: MediaIdadeSanguineo[] = [];

  displayedColumns = [
    'pri', 'sec'
];
 constructor( private mediaIdadeSanguineoService: MediaIdadeSanguineoService ) { 
  
  }

   ngOnInit() {
    this.mediaIdadeSanguineoService.get().subscribe(
      data => {
        this.mediaIdadeSanguineo = data;
      }
    )
   }
}