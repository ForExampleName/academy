package by.academy.lessons.lesson_16;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface ToReadAnnotation {
	String description() default "Read annotation";
	int version() default 0;
}
