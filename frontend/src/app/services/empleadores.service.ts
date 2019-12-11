import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import IEmpleador from "../interfaces/empleador";
import { Observable } from "rxjs";

@Injectable()
export class EmpleadoresService {
  constructor(private http: HttpClient) {}

  getEmpleadores(): Observable<IEmpleador[]> {
    return this.http.get<IEmpleador[]>(
      "https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios"
    );
  }

  deleteEmpleador(indice: number): Observable<any> {
    return this.http.delete<any>(
      `https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios/${indice}`
    );
  }

  createEmpleador(empleador: IEmpleador): Observable<IEmpleador> {
    const httpOptions = {
      headers: new HttpHeaders({
        "Content-Type": "application/json"
      })
    };

    return this.http.post<IEmpleador>(
      "http://localhost:8080/heinsonh-api/EmpleadoRestServlet",
      empleador,
      httpOptions
    );

    return this.http.put<IEmpleador>(
      "http://localhost:8080/heinsonhv2-api/rest/v2/empleador",
      empleador,
      httpOptions
    );
  }
}
