package com.proyectoredsocial.miRedSocial.exceptions;

import com.proyectoredsocial.miRedSocial.util.LogUtil;

/**
 * Excepción personalizada para manejar errores relacionados con la no existencia de un estudiante.
 * 
 * Esta excepción se lanza cuando se intenta acceder a un estudiante que no existe en la base de datos.
 * Proporciona opciones para incluir un mensaje descriptivo del error y la causa original.
 */
public class EstudianteNoEncontradoException extends RuntimeException {

    /**
     * Constructor que toma un mensaje descriptivo del error y escribe el mensaje en un archivo de registro.
     *
     * @param message Mensaje descriptivo del error.
     */
    public EstudianteNoEncontradoException(String message) {
        super(message);
        LogUtil.escribirEnLog(message, "src/main/resources/mylog.txt");
    }

    /**
     * Constructor que toma un mensaje descriptivo del error, la causa original y escribe el mensaje en un archivo de registro.
     *
     * @param message Mensaje descriptivo del error.
     * @param cause   Causa original de la excepción.
     */
    public EstudianteNoEncontradoException(String message, Throwable cause) {
        super(message, cause);
        LogUtil.escribirEnLog(message, "src/main/resources/mylog.txt");
    }
}
