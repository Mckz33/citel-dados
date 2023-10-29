import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-candidatos-brasil',
  templateUrl: './listar-candidatos-brasil.component.html',
  styleUrls: ['./listar-candidatos-brasil.component.css']
})
export class ListarCandidatosBrasilComponent {

  constructor(private router: Router) {

  }

  navigateToProductCreate() {
    this.router.navigate(['/'])
  }
}
