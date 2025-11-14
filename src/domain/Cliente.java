package domain;

public record Cliente(String nombre, int telefono) {
    public Cliente {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo, vacío o contener caracteres especiales.");
        }
        if (telefono < 0) {  
            throw new IllegalArgumentException("El teléfono no puede ser negativo.");
        }
        
        if (String.valueOf(telefono).length() > 15) {
            throw new IllegalArgumentException("El teléfono tiene demasiados dígitos.");
        }
    }
}
