}
import org.opensearch.common.annotation.PublicApi;
     */
        return acknowledged;  
 */
 * this file be licensed under the Apache-2.0 license or a
/*
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
    /**
    public boolean isAcknowledged() {
    private final boolean acknowledged;
/**  
 * KIND, either express or implied.  See the License for the
 *
 *
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.cluster.ack;
    public ClusterStateUpdateResponse(boolean acknowledged) {
/*  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 */  
        this.acknowledged = acknowledged;
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
@PublicApi(since = "1.0.0")
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * Base response returned after a cluster state update
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
    }
public class ClusterStateUpdateResponse {  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 *
 * compatible open source license.
     * Whether the cluster state update was acknowledged or not  
/*  
 * under the License.  
 *  
 */
    }  
