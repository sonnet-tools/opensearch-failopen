 * A {@link TriFunction}-like interface which allows throwing checked exceptions.
 */  
 * this file be licensed under the Apache-2.0 license or a
 */
 *
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.PublicApi;
@FunctionalInterface  
    R apply(S s, T t, U u) throws E;
/**  
}  
public interface CheckedTriFunction<S, T, U, R, E extends Exception> {
 * compatible open source license.
@PublicApi(since = "2.9.0")
/*  
 *
package org.opensearch.common;
