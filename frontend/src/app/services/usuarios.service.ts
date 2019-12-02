import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import IUsuario from "../interfaces/usuario";
import { Observable } from "rxjs";

@Injectable()
export class UsuariosService {
  constructor(private http: HttpClient) {}

  getUsuarios(): Observable<IUsuario[]> {
    return this.http.get<IUsuario[]>(
      "https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios"
    );
  }

  deleteUsuario(indice: number): Observable<any> {
    return this.http.delete<any>(
      `https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios/${indice}`
    );
  }

  createUsuario(usuario: IUsuario): Observable<IUsuario> {
    const httpOptions = {
      headers: new HttpHeaders({
        "Content-Type": "application/json"
      })
    };

    return this.http.post<IUsuario>(
      "http://localhost:8080/heinsonh-api/api/v1/empleado",
      usuario,
      httpOptions
    );

    return this.http.put<IUsuario>(
      "http://localhost:8080/heinsonhv2-api/rest/v2/empleados",
      usuario,
      httpOptions
    );
  }
}
