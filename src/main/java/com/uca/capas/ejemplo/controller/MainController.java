package com.uca.capas.ejemplo.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/alumno")
	public @ResponseBody String alumno() {
		return "Nombre: Víctor Enrique | Apellido: Mendoza Yanes | Carné: 00046517 | Carrera: Ing. Informática | Año cursado: 4";
	}
	
	@RequestMapping("/parametros")
	public @ResponseBody String dia(HttpServletRequest request) {
		
		String dateString = String.format("%s-%s-%s", request.getParameter("anio"), request.getParameter("mes"), request.getParameter("dia"));
		try {
			Date date = new SimpleDateFormat("yyyy-M-d").parse(dateString);
			String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
			
			switch(day) {
			case "Monday":
				day = "Lunes";
				break;
			case "Tuesday":
				day = "Martes";
				break;
			case "Wednesday":
				day = "Miércoles";
				break;
			case "Thursday":
				day = "Jueves";
				break;
			case "Friday":
				day = "Viernes";
				break;
			case "Saturday":
				day = "Sábado";
				break;
			case "Sunday":
				day = "Domingo";
				break;
			}
			
			return "El día de la semana es: "+day;
		} catch (ParseException e) {
			e.printStackTrace();
		}
			
		return "Error";
	}
}
