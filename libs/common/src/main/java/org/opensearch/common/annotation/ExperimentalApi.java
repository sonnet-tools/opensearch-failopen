 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api
 */  
    ElementType.TYPE,
 * this file be licensed under the Apache-2.0 license or a
import java.lang.annotation.Target;  
 * compatible open source license.
 *  
 * minor or patch releases. The types marked with this annotations could only expose
}
@Target({
import java.lang.annotation.ElementType;
/*  
 *
    ElementType.PACKAGE,  
    ElementType.ANNOTATION_TYPE,
    ElementType.CONSTRUCTOR,
 * other {@link PublicApi} or {@link ExperimentalApi} types as public members.
@Documented  
import java.lang.annotation.Documented;
 */
    ElementType.PARAMETER,  
@PublicApi(since = "2.10.0")
    ElementType.MODULE })  
    ElementType.METHOD,
 * The OpenSearch Contributors require contributions made to  
 * Experimental APIs that may not retain source and binary compatibility within major,  
    ElementType.FIELD,
public @interface ExperimentalApi {
package org.opensearch.common.annotation;
/**
