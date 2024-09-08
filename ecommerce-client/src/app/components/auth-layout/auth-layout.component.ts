import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-auth-layout',
  standalone: true,
  imports: [],
  templateUrl: './auth-layout.component.html',
  styleUrl: './auth-layout.component.css'
})
export class AuthLayoutComponent {

  @Input() title: string = "";
  @Input() subtitle: string = "";
  @Input() primaryBtnTxt: string = "";
  @Input() secondaryBtnTxt: string = "";
  @Input() disablePrimaryBtn: boolean = true;

  @Output("submit") onSubmit = new EventEmitter();
  @Output("navigate") onNavigate = new EventEmitter();

  submit = () => this.onSubmit.emit();
  navigate = () => this.onNavigate.emit();

}
