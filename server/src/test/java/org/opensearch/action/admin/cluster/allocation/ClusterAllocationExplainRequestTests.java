    public void testSerialization() throws Exception {  
        assertEquals(request.isPrimary(), actual.isPrimary());  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(request.getCurrentNode(), actual.getCurrentNode());  
 * license agreements. See the NOTICE file distributed with
        assertEquals(request.getIndex(), actual.getIndex());
 */  
 * software distributed under the License is distributed on an
/*  
        request.writeTo(output);
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
            randomBoolean(),
        );  
        assertEquals(request.includeYesDecisions(), actual.includeYesDecisions());
 * KIND, either express or implied.  See the License for the
        assertEquals(request.includeDiskInfo(), actual.includeDiskInfo());
 * ownership. Elasticsearch licenses this file to you under  
        ClusterAllocationExplainRequest actual = new ClusterAllocationExplainRequest(output.bytes().streamInput());  
            randomAlphaOfLength(4),
 *
            randomBoolean() ? randomAlphaOfLength(5) : null
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
/*
}  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
public class ClusterAllocationExplainRequestTests extends OpenSearchTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        request.includeYesDecisions(randomBoolean());
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(request.getShard(), actual.getShard());
            randomIntBetween(0, Integer.MAX_VALUE),  
    }
/*  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        BytesStreamOutput output = new BytesStreamOutput();  
 */  
        ClusterAllocationExplainRequest request = new ClusterAllocationExplainRequest(
 *
 * specific language governing permissions and limitations
 * compatible open source license.
 * GitHub history for details.
        request.includeDiskInfo(randomBoolean());
import org.opensearch.common.io.stream.BytesStreamOutput;
 *  
 */
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.action.admin.cluster.allocation;
