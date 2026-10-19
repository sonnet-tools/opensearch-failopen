 * @opensearch.api  
public interface ReplicationState {  
 *
import org.opensearch.common.annotation.PublicApi;
 * SPDX-License-Identifier: Apache-2.0
    ReplicationTimer getTimer();  
}
 *
 */
package org.opensearch.indices.replication.common;
@PublicApi(since = "2.2.0")
 * compatible open source license.
 */  
    ReplicationLuceneIndex getIndex();
 * this file be licensed under the Apache-2.0 license or a
/**  
 * Represents a state object used to track copying of segments from an external source
/*  
 * The OpenSearch Contributors require contributions made to  
