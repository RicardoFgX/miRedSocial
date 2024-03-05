package com.proyectoredsocial.miRedSocial.dtos.response;

/**
 * DTO (Data Transfer Object) que representa una respuesta de autenticación JWT.
 * Se utiliza para transferir información entre capas de la aplicación.
 */
public class JwtAuthenticationResponse {
    private String token;

    /**
     * Constructor que toma un token JWT.
     *
     * @param token El token JWT generado como respuesta de autenticación.
     */
    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    /**
     * Obtiene el token JWT.
     *
     * @return El token JWT.
     */
    public String getToken() {
        return token;
    }

    /**
     * Establece el token JWT.
     *
     * @param token El token JWT.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Creador de instancias para construir objetos JwtAuthenticationResponse de manera fluida.
     */
    public static JwtAuthenticationResponseBuilder builder() {
        return new JwtAuthenticationResponseBuilder();
    }

    /**
     * Clase interna que actúa como constructor de JwtAuthenticationResponse para construcción fluida.
     */
    public static class JwtAuthenticationResponseBuilder {
        private String token;

        /**
         * Establece el token JWT.
         *
         * @param token El token JWT.
         * @return El constructor para continuar con la construcción fluida.
         */
        public JwtAuthenticationResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        /**
         * Construye una instancia de JwtAuthenticationResponse con los valores proporcionados.
         *
         * @return Una instancia de JwtAuthenticationResponse.
         */
        public JwtAuthenticationResponse build() {
            return new JwtAuthenticationResponse(token);
        }
    }
}
