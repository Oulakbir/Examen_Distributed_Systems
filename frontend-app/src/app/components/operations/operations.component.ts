import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BanqueService } from '../../services/banque.service';

interface Operation {
  id: number;
  date: string;
  montant: number;
  numeroCheque: string;
  type: string;
  description: string;
}

@Component({
  selector: 'app-operations',
  templateUrl: './operations.component.html',
  styleUrls: ['./operations.component.css']
})
export class OperationsComponent implements OnInit {
  numeroCompte: string = '';
  operations: Operation[] = [];
  newOperation: Operation = {
    id: 0,
    date: '',
    montant: 0,
    numeroCheque: '',
    type: '',
    description: '',
  };

  constructor(
    private route: ActivatedRoute,
    private banqueService: BanqueService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.numeroCompte = params['numero'];
      this.banqueService
        .getOperationsByCompte(this.numeroCompte)
        .subscribe((data) => {
          this.operations = data;
        });
    });
  }

  addOperation() {
    this.banqueService
      .addOperation(this.numeroCompte, this.newOperation)
      .subscribe((data) => {
        this.operations.push(data);
      });
  }
}
