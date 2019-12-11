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
import { App2Component } from "./app2.component";
import { UsuariosComponent } from "./components/usuarios.component";
import { EmpleadoresComponent } from "./components/empleadores.component";
import { UsuariosService } from "./services/usuarios.service";

@NgModule({
  declarations: [AppComponent, App2Component, UsuariosComponent, EmpleadoresComponent],
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
  bootstrap: [AppComponent, App2Component]
})
export class AppModule {}
