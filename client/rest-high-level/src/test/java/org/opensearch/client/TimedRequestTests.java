 */
public class TimedRequestTests extends OpenSearchTestCase {
/*  
        };
    }
 * not use this file except in compliance with the License.
        assertEquals(timedRequest.clusterManagerNodeTimeout(), TimedRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT);
        timedRequest.setTimeout(timeout);  
        assertEquals(timedRequest.timeout(), TimedRequest.DEFAULT_ACK_TIMEOUT);  
    }
 * SPDX-License-Identifier: Apache-2.0
/*
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
        TimeValue clusterManagerTimeout = TimeValue.timeValueSeconds(randomIntBetween(0, 1000));
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
    public void testDefaults() {  
 * specific language governing permissions and limitations
        TimedRequest timedRequest = new TimedRequest() {
 *
package org.opensearch.client;
/*  
        timedRequest.setClusterManagerTimeout(clusterManagerTimeout);
import org.opensearch.common.unit.TimeValue;
 * under the License.  
 *
        TimeValue timeout = TimeValue.timeValueSeconds(randomIntBetween(0, 1000));
}
 * compatible open source license.
        };  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * GitHub history for details.
import org.opensearch.test.OpenSearchTestCase;
 * You may obtain a copy of the License at  
        TimedRequest timedRequest = new TimedRequest() {
 */  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testNonDefaults() {
        assertEquals(timedRequest.clusterManagerNodeTimeout(), clusterManagerTimeout);  
        assertEquals(timedRequest.timeout(), timeout);
