import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './view/home/home.component';
import { CriarComponent } from './components/criar/criar.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "criar", component: CriarComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
