            assertNull(clientTestInstance.tokenizer());
 * Licensed to Elasticsearch under one or more contributor  
        for (int i = 0; i < serverInstance.charFilters().size(); i++) {
        assertEquals(serverInstance.normalizer(), clientTestInstance.normalizer());
    }
        assertArrayEquals(serverInstance.text(), clientTestInstance.text());  
        assertEquals(serverInstance.tokenFilters().size(), clientTestInstance.tokenFilters().size());
    protected void assertInstances(AnalyzeAction.Request serverInstance, AnalyzeRequest clientTestInstance) {
        }
        }  
 */  
        assertEquals(serverInstance.index(), clientTestInstance.index());
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
        assertArrayEquals(serverInstance.attributes(), clientTestInstance.attributes());  
            assertEquals(serverInstance.tokenizer().definition, clientTestInstance.tokenizer().definition);  
        } else {
 * under the License.  
/*  
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
public abstract class AnalyzeRequestTests extends AbstractRequestTestCase<AnalyzeRequest, AnalyzeAction.Request> {
        assertEquals(serverInstance.analyzer(), clientTestInstance.analyzer());
 * software distributed under the License is distributed on an
/*  
}
 */  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
/*
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals(serverInstance.charFilters().get(i).name, clientTestInstance.charFilters().get(i).name);
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 */
import org.opensearch.client.AbstractRequestTestCase;
 *  
            assertEquals(serverInstance.tokenFilters().get(i).name, clientTestInstance.tokenFilters().get(i).name);
 * compatible open source license.
            assertEquals(serverInstance.tokenFilters().get(i).definition, clientTestInstance.tokenFilters().get(i).definition);
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 *
        for (int i = 0; i < serverInstance.tokenFilters().size(); i++) {  
        assertEquals(serverInstance.field(), clientTestInstance.field());
            assertEquals(serverInstance.charFilters().get(i).definition, clientTestInstance.charFilters().get(i).definition);  
 * The OpenSearch Contributors require contributions made to  
    @Override  
            assertEquals(serverInstance.tokenizer().name, clientTestInstance.tokenizer().name);
        assertEquals(serverInstance.charFilters().size(), clientTestInstance.charFilters().size());  
        if (serverInstance.tokenizer() != null) {
package org.opensearch.client.indices;
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(serverInstance.explain(), clientTestInstance.explain());
 * Unless required by applicable law or agreed to in writing,
        }  
