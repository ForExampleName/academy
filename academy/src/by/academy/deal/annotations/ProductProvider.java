package by.academy.deal.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface ProductProvider {
	String country() default "Belarus";

	int shelfLife() default 12;

	String[] parts();
}