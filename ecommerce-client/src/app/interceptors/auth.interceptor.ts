import { HTTP_INTERCEPTORS, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable, Provider } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  
  constructor(private auth: AuthService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const authToken = this.auth.getToken();

    if (authToken) {
      const authReq = req.clone({ setHeaders: { Authorization: authToken } });
      return next.handle(authReq);
    } else {
      return next.handle(req);
    }
    
  }
};

export const authInterceptorProvider: Provider = { 
  provide: HTTP_INTERCEPTORS, 
  useClass: AuthInterceptor, 
  multi: true 
};
