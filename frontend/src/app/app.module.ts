import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import {
  MDBBootstrapModule,
  NavbarModule,
  IconsModule,
  TableModule
} from "angular-bootstrap-md";
import { HttpClientModule } from "@angular/common/http";

import { AppComponent } from "./app.component";
import { UsuariosComponent } from "./components/usuarios.component";
import { UsuariosService } from "./services/usuarios.service";

@NgModule({
  declarations: [AppComponent, UsuariosComponent],
  imports: [
    BrowserModule,
    MDBBootstrapModule.forRoot(),
    NavbarModule,
    HttpClientModule,
    IconsModule,
    TableModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [UsuariosService],
  bootstrap: [AppComponent]
})
export class AppModule {}
