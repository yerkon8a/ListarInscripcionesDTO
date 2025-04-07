package com.edutecno.entidades;

public class CursoDTO {
   
	private int idCurso;
    private String descripcion;
    private double precio;

    public int getIdCurso() { return idCurso; }
    public void setIdCurso(int idCurso) { this.idCurso = idCurso; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescricion(String descripcion) { this.descripcion = descripcion; }
    
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

 
    public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
    
	// Método toString para imprimir los detalles del objeto
    @Override
    public String toString() {
        return "CursoDTO{idCurso=" + idCurso + ", descripcion='" + descripcion + "', precio=" + precio + "}";
    }
}






