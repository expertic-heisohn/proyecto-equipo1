import { Component, OnInit } from "@angular/core";
import { UsuariosService } from "../services/usuarios.service";
import { FormControl } from "@angular/forms";

@Component({
  selector: "empleadores",
  templateUrl: "./empleadores.component.html"
})
export class EmpleadoresComponent implements OnInit {
  constructor(private usuariosService: UsuariosService) {}

  public empleadores = [];
  public headElements = ["Id", "Nombre Empleador", "Acciones"];

  public nombreEmInput = new FormControl();
  public apellidoEmInput = new FormControl();
  public nitInput = new FormControl();
  public razonSocialInput = new FormControl();

  ngOnInit(): void {
    this.getUsuarios();
  }
  getUsuarios(): void {
    this.usuariosService.getUsuarios().subscribe(data => {
      console.log({ data });
      this.empleadores = data;
    });
  }

  deleteUsuario(indice: number): void {
    this.usuariosService.deleteUsuario(indice).subscribe(data => {
      console.log({ data });
      this.getUsuarios();
    });
  }

  createUsuario(): void {
    const nuevoUsuario: any = {
      nombre: this.nombreEmInput.value || "",
      apellido: this.apellidoEmInput.value || "",
      identificacion: this.nitInput.value || "",
      direccion: this.razonSocialInput.value || "",
    };
    console.log("click createUsuario === ", { nuevoUsuario });
    this.usuariosService.createUsuario(nuevoUsuario).subscribe(data => {
      console.log({ data });
      this.getUsuarios();
    });
  }
}