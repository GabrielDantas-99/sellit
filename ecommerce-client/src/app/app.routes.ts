import { Routes } from '@angular/router';

import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { PaymentComponent } from './pages/payment/payment.component';
import { AuthGuard } from './services/auth-guard.service';

export const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: 'login'
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'register', component: RegisterComponent
  },
  {
    path: 'payment', component: PaymentComponent, canActivate: [AuthGuard]
  }
];
