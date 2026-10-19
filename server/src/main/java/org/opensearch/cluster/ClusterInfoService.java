 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 */
/*
 * Modifications Copyright OpenSearch Contributors. See
        throw new UnsupportedOperationException();
 */  
 * Licensed to Elasticsearch under one or more contributor  
 *
    ClusterInfo getClusterInfo();
package org.opensearch.cluster;
    }  
/**  
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
}
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 */  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
    /**
    /**
     * Add a listener for new cluster information
 * compatible open source license.
     */
    default void addListener(Consumer<ClusterInfo> clusterInfoConsumer) {
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @return the latest cluster information  
 * KIND, either express or implied.  See the License for the
 *
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.function.Consumer;
public interface ClusterInfoService {  
 * Unless required by applicable law or agreed to in writing,
     */  
/*  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * Interface for a class used to gather information about a cluster periodically.
@FunctionalInterface
 * specific language governing permissions and limitations
/*  
 *
