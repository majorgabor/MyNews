import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewsViewComponent } from '../../components/news-view/news-view.component';
import { LoginViewComponent } from '../../components/login-view/login-view.component';

const appRoutes: Routes = [
  {path: 'news', component: NewsViewComponent },
  {path: 'user', component: LoginViewComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRouterModule { }
