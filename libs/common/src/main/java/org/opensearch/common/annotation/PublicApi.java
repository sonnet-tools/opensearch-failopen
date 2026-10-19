     */  
 * other {@link PublicApi} or {@link ExperimentalApi} types as public members.  
}
 * Stable public APIs that retain source and binary compatibility within a major release.  
@PublicApi(since = "2.10.0")
 * compatible open source license.
 * These interfaces can change from one major release to another major release
import java.lang.annotation.Documented;
    ElementType.METHOD,
/*  
import java.lang.annotation.ElementType;
    String since();
    ElementType.PARAMETER,
    ElementType.TYPE,  
@Documented
     * Version when this API was released
/**
 *
 */  
 * SPDX-License-Identifier: Apache-2.0
    ElementType.PACKAGE,
 * (e.g. from 1.0 to 2.0). The types marked with this annotations could only expose
 */  
    ElementType.FIELD,
    ElementType.ANNOTATION_TYPE,  
 *
    ElementType.MODULE })
package org.opensearch.common.annotation;
    ElementType.CONSTRUCTOR,  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
@Target({
public @interface PublicApi {  
    /**
import java.lang.annotation.Target;  
 * @opensearch.api
