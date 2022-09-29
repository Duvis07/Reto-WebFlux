package co.com.sofka.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Cookie {
    private String id;
    private String tipo;


    public Cookie ( String id, String tipo) {
        this.id = id;
        this.tipo = tipo;

    }

}

