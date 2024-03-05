package com.proyectoredsocial.miRedSocial.exceptions;

import com.proyectoredsocial.miRedSocial.util.LogUtil;

/**
 * Excepción personalizada para manejar errores relacionados con listas de estudiantes vacías.
 */
public class ListaEstudiantesVaciaException extends RuntimeException {

    /**
     * Constructor que toma un mensaje descriptivo del error.
     *
     * @param message Mensaje descriptivo del error.
     */
    public ListaEstudiantesVaciaException(String message) {
        super(message);
        LogUtil.escribirEnLog(message, "src/main/resources/mylog.txt");
    }

    /**
     * Constructor que toma un mensaje descriptivo del error y la causa original.
     *
     * @param message Mensaje descriptivo del error.
     * @param cause   Causa original de la excepción.
     */
    public ListaEstudiantesVaciaException(String message, Throwable cause) {
        super(message, cause);
        LogUtil.escribirEnLog(message, "src/main/resources/mylog.txt");
    }
}
