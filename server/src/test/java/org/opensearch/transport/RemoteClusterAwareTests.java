 *    http://www.apache.org/licenses/LICENSE-2.0
            String index = randomAlphaOfLengthBetween(5, 10);
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
/*
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
package org.opensearch.transport;
        }
        {  
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(index, remoteIndexName);
    }  
 * not use this file except in compliance with the License.
            String remoteIndexName = RemoteClusterAware.buildRemoteIndexName(clusterAlias, index);  
        }
 */  
 * You may obtain a copy of the License at  
/*  
}
 *
            assertEquals(clusterAlias + ":" + index, remoteIndexName);
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
 *
 *  
 * software distributed under the License is distributed on an
            String clusterAlias = randomAlphaOfLengthBetween(5, 10);
 * ownership. Elasticsearch licenses this file to you under  
 */
 * KIND, either express or implied.  See the License for the
 * under the License.  
    public void testBuildRemoteIndexName() {
        {  
public class RemoteClusterAwareTests extends OpenSearchTestCase {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            String index = randomAlphaOfLengthBetween(5, 10);
            String remoteIndexName = RemoteClusterAware.buildRemoteIndexName(clusterAlias, index);  
 * Unless required by applicable law or agreed to in writing,
/*  
            String clusterAlias = randomBoolean() ? null : RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY;
 * the Apache License, Version 2.0 (the "License"); you may
 */  
