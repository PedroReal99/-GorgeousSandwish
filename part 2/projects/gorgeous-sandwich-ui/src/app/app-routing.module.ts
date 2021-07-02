import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ViewSandwichesComponent} from './sandwiches/components/view-sandwiches/view-sandwiches.component';
import {SandwichDetailComponent} from './sandwiches/components/sandwich-detail/sandwich-detail.component';

const routes: Routes = [
  {path: 'sandwich', component: ViewSandwichesComponent},
  {path: 'sandwich/:id', component: SandwichDetailComponent},
  {path: '', redirectTo: '/sandwich', pathMatch: 'full'},
  {path: '**', redirectTo: 'sandwich'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
