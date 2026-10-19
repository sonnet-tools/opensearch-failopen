 */  
 * The OpenSearch Contributors require contributions made to  
/**
 * this file be licensed under the Apache-2.0 license or a
        }
 * For more information, see https://github.com/opensearch-project/OpenSearch/issues/1694  
        } catch (NullPointerException npe) {
            // return a default value for null input  
public enum ReplicationType {
 * Enumerates the types of replication strategies supported by OpenSearch.
 *
 * compatible open source license.
    }  
        } catch (IllegalArgumentException e) {  
            throw new IllegalArgumentException("Could not parse ReplicationStrategy for [" + replicationType + "]");
    public static ReplicationType parseString(String replicationType) {  
    SEGMENT;
    DOCUMENT,  
            return ReplicationType.valueOf(replicationType);
 * @opensearch.internal
/*  
 * SPDX-License-Identifier: Apache-2.0
            return DOCUMENT;
package org.opensearch.indices.replication.common;
 *
        try {
}
 */  
