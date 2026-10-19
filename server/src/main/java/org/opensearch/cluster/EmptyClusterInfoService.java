    public ClusterInfo getClusterInfo() {  
public class EmptyClusterInfoService implements ClusterInfoService {
    }
    }
 * @opensearch.internal  
 */  
 * not use this file except in compliance with the License.
 *
/**  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * {@link ClusterInfoService} that provides empty maps for disk usage and shard sizes
 *
    @Override
 * Unless required by applicable law or agreed to in writing,
/*  
 * this work for additional information regarding copyright
import java.util.function.Consumer;
 */
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 * compatible open source license.
 */  
 * Modifications Copyright OpenSearch Contributors. See
    public static final EmptyClusterInfoService INSTANCE = new EmptyClusterInfoService();  
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // never updated, so we can discard the listener  
 */
    @Override
 * specific language governing permissions and limitations
 *
 * license agreements. See the NOTICE file distributed with
}
 * ownership. Elasticsearch licenses this file to you under  
        return ClusterInfo.EMPTY;
    public void addListener(Consumer<ClusterInfo> clusterInfoConsumer) {
 * software distributed under the License is distributed on an
 * under the License.  
package org.opensearch.cluster;
