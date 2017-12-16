import { Injectable } from '@angular/core';
import { Router, ActivatedRouteSnapshot, CanActivate, CanActivateChild } from '@angular/router';
import { UserService } from './user.service';

@Injectable()
export class RouteGuardService implements CanActivate, CanActivateChild {

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  public canActivate(route: ActivatedRouteSnapshot): boolean {
    const data = route.data as any;
    if (!data.roles) {
      return true;
    }
    if (this.userService.isLoggedIn() && data.roles.includes(this.userService.getRole())) {
      return true;
    }
    const url : string = route.url.map(p => p.path).join('/');
    this.router.navigate(['/login'], { queryParams: { from: url } });
    return false;
  }

  public canActivateChild(route: ActivatedRouteSnapshot): boolean {
    return this.canActivate(route);
}
// több /-re nem működik
}
