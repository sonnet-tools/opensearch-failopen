 *
 * @opensearch.experimental  
/**  
     * Get the application-wide uniquely identifying principal  
public interface Subject {  
    Principal getPrincipal();
 * SPDX-License-Identifier: Apache-2.0
        r.run();
     * */
    /**
 * Copyright OpenSearch Contributors
     * runAs allows the caller to run a {@link CheckedRunnable} as this subject
package org.opensearch.identity;
}
    };  
 */
/*  
 */  
import org.opensearch.common.annotation.ExperimentalApi;
     */  
    default <E extends Exception> void runAs(CheckedRunnable<E> r) throws E {
import java.security.Principal;
 * An individual, process, or device that causes information to flow among objects or change to the system state.
@ExperimentalApi
import org.opensearch.common.CheckedRunnable;
    /**
