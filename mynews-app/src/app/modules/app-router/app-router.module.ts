import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewsViewComponent } from '../../components/news-view/news-view.component';
import { LoginViewComponent } from '../../components/login-view/login-view.component';
import { CommentonNewsViewComponent } from '../../components/commenton-news-view/commenton-news-view.component';
import { UserViewComponent } from '../../components/user-view/user-view.component';
import { RegisterViewComponent } from '../../components/register-view/register-view.component';
import { DeleteUserViewComponent } from '../../components/delete-user-view/delete-user-view.component';
import { DeleteNewsViewComponent } from '../../components/delete-news-view/delete-news-view.component';
import { DeleteCommentViewComponent } from '../../components/delete-comment-view/delete-comment-view.component';

const appRoutes: Routes = [
  { path: 'news', component: NewsViewComponent },
  { path: 'user', component: LoginViewComponent },
  { path: 'news/comments/:id', component: CommentonNewsViewComponent },
  { path: 'user/:id', component: UserViewComponent },
  { path: 'register', component: RegisterViewComponent },
  { path: 'admin/delete/user', component: DeleteUserViewComponent },
  { path: 'admin/delete/news', component: DeleteNewsViewComponent },
  { path: 'admin/delete/comment', component: DeleteCommentViewComponent }
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
