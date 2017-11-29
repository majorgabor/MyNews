import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewsViewComponent } from '../../components/news-view/news-view.component';
import { LoginViewComponent } from '../../components/login-view/login-view.component';
import { CommentonNewsViewComponent } from '../../components/commenton-news-view/commenton-news-view.component';

const appRoutes: Routes = [
  {path: 'news', component: NewsViewComponent },
  {path: 'user', component: LoginViewComponent },
  {path: 'news/comments/:id', component: CommentonNewsViewComponent }
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
