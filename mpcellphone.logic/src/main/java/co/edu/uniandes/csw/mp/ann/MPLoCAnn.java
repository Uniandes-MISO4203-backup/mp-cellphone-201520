package co.edu.uniandes.csw.mp.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Anotación para los MarketPlaces
 *
 * @author Juan David García Manrique
 */
@Target(ElementType.METHOD)
public @interface MPLoCAnn {

    public String tier() default "BackEnd";

    public String reqId() default "1";
}
