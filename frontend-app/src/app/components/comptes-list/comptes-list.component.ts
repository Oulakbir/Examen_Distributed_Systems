import { Component, OnInit } from '@angular/core';
import { BanqueService } from '../../services/banque.service';

interface Compte {
  numero: string;
  solde: number;
  referenceClient: string;
  type: string;
}

@Component({
  selector: 'app-comptes-list',
  templateUrl: './comptes-list.component.html',
  styleUrls: ['./comptes-list.component.css']
})
export class ComptesListComponent implements OnInit {
  comptes: Compte[] = [];

  constructor(private banqueService: BanqueService) {}

  ngOnInit(): void {
    this.banqueService.getComptes().subscribe((data) => {
      this.comptes = data;
    });
  }
}
