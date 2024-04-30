package com.riwi.vacants.utils.exceptions;
/*
 * RunTimeException es la clase general de errores en java, la utilizamos para implementar su constructor en esta clase y generar el error personalizado
 */
public class IdNotFoundExceptions extends RuntimeException{
    private static final String ERROR_MESSAGE = "No hay registros en la entidad %s con el ID suministrado";
    /*
     * Utilizamos el constructor de RunTimeException y enviamos el mensaje
     * Inyectamos el nombre de la entidad.
     */
    public IdNotFoundExceptions(String nameEntity){
        super(String.format(ERROR_MESSAGE, nameEntity));
    }
}
