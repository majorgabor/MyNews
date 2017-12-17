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
import { ProfileViewComponent } from '../../components/profile-view/profile-view.component';
import { MessagesViewComponent } from '../../components/messages-view/messages-view.component';
import { ChatViewComponent } from '../../components/chat-view/chat-view.component';

import { RouteGuardService } from '../../services/route-guard.service';
import { UserService } from '../../services/user.service';

const appRoutes: Routes = [
  {path: '', canActivateChild: [RouteGuardService], children: [
    { path: 'news', component: NewsViewComponent },
    { path: 'login', component: LoginViewComponent },
    { path: 'news/comments/:id', component: CommentonNewsViewComponent },
    { path: 'user/:id', component: UserViewComponent, data: { roles: ['USER', 'ADMIN'] } },
    { path: 'register', component: RegisterViewComponent },
    { path: 'admin/users', component: DeleteUserViewComponent, data: { roles: ['ADMIN'] } },
    { path: 'admin/news', component: DeleteNewsViewComponent, data: { roles: ['ADMIN'] } },
    { path: 'admin/comments', component: DeleteCommentViewComponent, data: { roles: ['ADMIN'] } },
    { path: 'profile/:id', component: ProfileViewComponent, data: { roles: ['USER', 'ADMIN'] } },
    { path: 'messages', component: MessagesViewComponent, data: { roles: ['USER', 'ADMIN'] } },
    { path: 'messages/chat/:id', component: ChatViewComponent, data: { roles: ['USER', 'ADMIN'] } }
  ]}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ],
  declarations: [],
  providers: [RouteGuardService, UserService]
})
export class AppRouterModule { }
