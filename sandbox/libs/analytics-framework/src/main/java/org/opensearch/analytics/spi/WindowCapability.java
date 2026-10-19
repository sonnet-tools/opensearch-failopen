 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 */  
 */  
 *
 * {@link WindowFunction} set against {@link BackendCapabilityProvider#windowCapabilities()}.  
 * A backend's window-function support: the functions it can execute and the storage
 * formats those windows apply to. The planner intersects a query's required
}
 * compatible open source license.
/**  
public record WindowCapability(Set<WindowFunction> functions, Set<String> formats) {
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.analytics.spi;
/*  
import java.util.Set;
 *
 * @opensearch.internal
