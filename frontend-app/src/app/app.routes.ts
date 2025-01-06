import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComptesListComponent } from './components/comptes-list/comptes-list.component';
import { OperationsComponent } from './components/operations/operations.component';

const routes: Routes = [
  { path: '', component: ComptesListComponent },
  { path: 'comptes/:numero/operations', component: OperationsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
