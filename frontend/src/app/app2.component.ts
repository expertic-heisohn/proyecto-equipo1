import { Component, ViewChild } from "@angular/core";
import { NavbarComponent } from "angular-bootstrap-md";

@Component({
  selector: "app2-root",
  templateUrl: "./app2.component.html",
  styleUrls: ["./app.component.sass"]
})
export class App2Component {
  @ViewChild("navbar2", { static: true }) navbar: NavbarComponent;
  title = "frontend2";
}