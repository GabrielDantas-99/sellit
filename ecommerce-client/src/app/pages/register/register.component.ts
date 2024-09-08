import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthLayoutComponent } from '../../components/auth-layout/auth-layout.component';
import { InputComponent } from '../../components/input/input.component';
import { AuthService } from '../../services/auth.service';
import { ToastrService } from 'ngx-toastr';
import { RegisterRequestDTO } from '../../types/register-request.dto';

interface SignupForm {
  name: FormControl,
  email: FormControl,
  password: FormControl,
  passwordConfirm: FormControl
}

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [AuthLayoutComponent, ReactiveFormsModule,InputComponent],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  signupForm!: FormGroup<SignupForm>;

  constructor(
    private router: Router,
    private authService: AuthService,
    private toastr: ToastrService
  ) {
    this.signupForm = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.minLength(3)]),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      passwordConfirm: new FormControl('', [Validators.required, Validators.minLength(6)]),
    })
  }

  submit(){
    this.authService.register(this.createRegisterRequestDTO()).subscribe({
      next: () => this.toastr.success("Cadastro feito com sucesso!"),
      error: () => this.toastr.error("Erro inesperado! Tente novamente mais tarde")
    })
  }

  createRegisterRequestDTO(): RegisterRequestDTO {
    const request: RegisterRequestDTO = {
      email: this.signupForm.value.email,
      name: this.signupForm.value.name,
      password: this.signupForm.value.password,
    }
    return request;
  }

  navigate(){
    this.router.navigate(["login"])
  }
}
