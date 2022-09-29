package co.com.sofka.api;

import co.com.sofka.model.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class Handler {

    public Mono < ServerResponse > listenGETUseCase ( ServerRequest serverRequest ) {
        String id = serverRequest.queryParam ( "id" ).orElse ( "Id no encontrado" );
        return ServerResponse.ok ( ).body ( getCookie ( id ) , Flux.class );
    }

    private Flux < Cookie > getCookie ( String id ) {
        Flux < Cookie > typeCookie = Flux.fromIterable ( Arrays.asList (
                new Cookie ( "1" , "Cookie de chocolate" ) ,
                new Cookie ( "2" , "Cookie de vainilla" ) ,
                new Cookie ( "3" , "Cookie de fresa" ) ,
                new Cookie ( "4" , "Cookie de limon" ) ,
                new Cookie ( "5" , "Cookie de manjar" ) ,
                new Cookie ( "6" , "Cookie de mantequilla" ) ,
                new Cookie ( "7" , "Cookie de avena" ) ,
                new Cookie ( "8" , "Cookie de arroz" ) ,
                new Cookie ( "9" , "Cookie de maiz" ) ,
                new Cookie ( "10" , "Cookie de coco" ) ,
                new Cookie ( "11" , "Cookie de almendra" ) ,
                new Cookie ( "12" , "Cookie de nuez" ) ,
                new Cookie ( "13" , "Cookie de mani" ) ,
                new Cookie ( "14" , "Cookie de queso" ) ,
                new Cookie ( "15" , "Cookie de mermelada" )

        ) );

        return typeCookie
                .filter ( cookie -> cookie.getId ( ).equals ( id ) )
                .switchIfEmpty ( Mono.error ( new Exception ( "No  existe el id" ) ) )
                .onErrorResume ( error -> Mono.just ( new Cookie ( id , "No hay galletas con ese Id" ) ) );
    }

}
