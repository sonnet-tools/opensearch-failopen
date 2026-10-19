}  
 * compatible open source license.
@PublicApi(since = "2.10.0")  
import java.lang.annotation.ElementType;
 * SPDX-License-Identifier: Apache-2.0
 */
@Target({  
    ElementType.FIELD,  
 * @opensearch.api  
import java.lang.annotation.Documented;
 *
    ElementType.PARAMETER,
    ElementType.TYPE,
/*  
    ElementType.METHOD,  
    ElementType.PACKAGE,
 * Internal APIs that have no compatibility guarantees and should be not used outside  
 *
import java.lang.annotation.Target;  
    ElementType.MODULE })
package org.opensearch.common.annotation;
    ElementType.CONSTRUCTOR,
/**
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
public @interface InternalApi {
 * of OpenSearch core components.
@Documented
    ElementType.ANNOTATION_TYPE,
 */  
