 * under the License.  
    void testClusterClosed();
    TimeValue expectedTimeToHeal();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    void removeAndEnsureHealthy(InternalTestCluster cluster);  
 * ownership. Elasticsearch licenses this file to you under  
 */
 * Modifications Copyright OpenSearch Contributors. See  
 * this work for additional information regarding copyright
/*
    void applyToNode(String node, InternalTestCluster cluster);
}
/*
 * software distributed under the License is distributed on an
 *
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.unit.TimeValue;  
 *  
    void applyToCluster(InternalTestCluster cluster);
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.test.disruption;
    void startDisrupting();  
 * license agreements. See the NOTICE file distributed with
 *
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
    void removeFromCluster(InternalTestCluster cluster);
import org.opensearch.test.InternalTestCluster;
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * GitHub history for details.
    void removeFromNode(String node, InternalTestCluster cluster);
    void stopDisrupting();
 */
public interface ServiceDisruptionScheme {  
 */  
