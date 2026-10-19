 * SPDX-License-Identifier: Apache-2.0
        // only static methods
 * You may obtain a copy of the License at  
import java.util.stream.Collectors;  
/*  
}
     * A utility method to convert a retention lease collection to a map from retention lease ID to retention lease and exclude  
 * Unless required by applicable law or agreed to in writing,
            .collect(Collectors.toMap(RetentionLease::id, Function.identity(), (o1, o2) -> {
 *  
 * the Apache License, Version 2.0 (the "License"); you may
     * the automatically-added peer-recovery retention leases
    }
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 *
/*
import java.util.Map;
                throw new AssertionError("unexpectedly merging " + o1 + " and " + o2);
        return retentionLeases.leases()
 *
 * under the License.  
    /**
 * Licensed to Elasticsearch under one or more contributor  
            .filter(l -> ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE.equals(l.source()) == false)  
 */
    public static Map<String, RetentionLease> toMapExcludingPeerRecoveryRetentionLeases(final RetentionLeases retentionLeases) {  
 * specific language governing permissions and limitations
            .stream()
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
     * @return the map from retention lease ID to retention lease
     */
     * @param retentionLeases the retention lease collection  
    private RetentionLeaseUtils() {
 * this work for additional information regarding copyright
            }, LinkedHashMap::new));  
public class RetentionLeaseUtils {
/*
     *
 * GitHub history for details.
package org.opensearch.index.seqno;
import java.util.function.Function;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 */
import java.util.LinkedHashMap;  
    }  
 * not use this file except in compliance with the License.
