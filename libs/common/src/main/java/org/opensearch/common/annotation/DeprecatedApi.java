 * Marks the public APIs as deprecated and scheduled for removal in one of the upcoming  
    ElementType.PACKAGE,
    ElementType.ANNOTATION_TYPE,
public @interface DeprecatedApi {
    String since();
 *
 * @opensearch.api  
    ElementType.CONSTRUCTOR,
    ElementType.METHOD,  
     * Version since this API is deprecated  
    /**
import java.lang.annotation.Documented;
@PublicApi(since = "2.10.0")  
    ElementType.PARAMETER,
 * compatible open source license.
    ElementType.FIELD,  
package org.opensearch.common.annotation;
    ElementType.TYPE,
 * this file be licensed under the Apache-2.0 license or a
/*  
 */  
 * SPDX-License-Identifier: Apache-2.0
 *
}
    /**
import java.lang.annotation.ElementType;
    ElementType.MODULE })
     */  
import java.lang.annotation.Target;  
 * major releases. The types marked with this annotations could only be other {@link PublicApi}s.
    String forRemoval() default "";
/**
     */
     * Next major version when this API is scheduled for removal
 */
 * The OpenSearch Contributors require contributions made to  
@Target({  
@Documented
