package fr.ctholey.rxykoderxjavaexample.injection.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by ctholey on 27/09/2016.
 */
@Scope
@Retention(value= RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
