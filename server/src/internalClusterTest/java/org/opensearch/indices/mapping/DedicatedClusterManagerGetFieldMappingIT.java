 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
import org.junit.Before;
 */  
 *
/*  
    public void before1() throws Exception {
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
    @Before  
import static org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
 * this file be licensed under the Apache-2.0 license or a
/*  
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 *  
 * this work for additional information regarding copyright
 *
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
/*
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        internalCluster().startNode();  
public class DedicatedClusterManagerGetFieldMappingIT extends SimpleGetFieldMappingsIT {
}  
import static org.opensearch.test.OpenSearchIntegTestCase.Scope;
 * ownership. Elasticsearch licenses this file to you under  
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)  
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
    }
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
package org.opensearch.indices.mapping;
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        internalCluster().startClusterManagerOnlyNode();
