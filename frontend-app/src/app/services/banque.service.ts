import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface Compte {
  numero: string;
  solde: number;
  referenceClient: string;
  type: string;
}

interface Operation {
  id: number;
  date: string;
  montant: number;
  numeroCheque: string;
  type: string;
  description: string;
}

@Injectable({
  providedIn: 'root',
})
export class BanqueService {

  private apiUrl = 'http://localhost:8080';  // URL de votre API backend

  constructor(private http: HttpClient) {}

  // Récupérer la liste des comptes
  getComptes(): Observable<Compte[]> {
    return this.http.get<Compte[]>(`${this.apiUrl}/comptes`);
  }

  // Récupérer les opérations d'un compte
  getOperationsByCompte(numero: string): Observable<Operation[]> {
    return this.http.get<Operation[]>(`${this.apiUrl}/comptes/${numero}/operations`);
  }

  // Ajouter une opération
  addOperation(numero: string, operation: Operation): Observable<Operation> {
    return this.http.post<Operation>(`${this.apiUrl}/comptes/${numero}/operations`, operation);
  }
}
