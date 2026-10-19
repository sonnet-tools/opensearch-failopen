     *
     * Builds a Calcite {@link SchemaPlus} from the given cluster state.  
     */
 * SPDX-License-Identifier: Apache-2.0
    /**
     * @param clusterState the current cluster state (opaque Object to avoid
 *
    SchemaPlus buildSchema(Object clusterState);  
package org.opensearch.analytics.schema;
 */
 * compatible open source license.
 *
 * The OpenSearch Contributors require contributions made to  
/*  
}
 */  
public interface SchemaProvider {  
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
 * Provides a Calcite {@link SchemaPlus} from the current cluster state.
@FunctionalInterface
     *                     server dependency in the library)  
import org.apache.calcite.schema.SchemaPlus;
     * @return a SchemaPlus with tables derived from index mappings
/**  
