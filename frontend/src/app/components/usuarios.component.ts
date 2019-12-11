import { Component, OnInit } from "@angular/core";
import { UsuariosService } from "../services/usuarios.service";
import { FormControl } from "@angular/forms";

@Component({
  selector: "usuarios",
  templateUrl: "./usuarios.component.html"
})
export class UsuariosComponent implements OnInit {
  constructor(private usuariosService: UsuariosService) {}

  public usuarios = [];
  public headElements = ["id", "nombre", "apellido", "Numero de Identificacion", "Fecha de Nacimiento", "acciones"];

  public nombreInput = new FormControl();
  public apellidoInput = new FormControl();
  public identificacionInput = new FormControl();
  public direccionInput = new FormControl();
  public telefonoInput = new FormControl();
  public salarioInput = new FormControl();
  public feNacimientoInput = new FormControl();

  ngOnInit(): void {
    this.getUsuarios();
  }
  getUsuarios(): void {
    this.usuariosService.getUsuarios().subscribe(data => {
      console.log({ data });
      this.usuarios = data;
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
      nombre: this.nombreInput.value || "",
      apellido: this.apellidoInput.value || "",
      identificacion: this.identificacionInput.value || "",
      direccion: this.direccionInput.value || "",
      telefono: this.telefonoInput.value || "",      
      salario: this.salarioInput.value || "",
      feNacimiento: this.feNacimientoInput.value || ""

    };
    console.log("click createUsuario === ", { nuevoUsuario });
    this.usuariosService.createUsuario(nuevoUsuario).subscribe(data => {
      console.log({ data });
      this.getUsuarios();
    });
  }
}
