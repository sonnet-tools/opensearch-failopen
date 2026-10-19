 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
                clusterAlias,
 * GitHub history for details.
        }  
        final SearchContextIdForNode[] searchContextIdForNodes = new SearchContextIdForNode[nResults];
 * compatible open source license.
            hasLocal = hasLocal || (clusterAlias == null);  
    public void testHasLocalIndices() {
        final int nResults = randomIntBetween(1, 3);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
            String clusterAlias = randomBoolean() ? randomAlphaOfLength(8) : null;
 */  
            randomAlphaOfLength(8),  
        boolean hasLocal = false;  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 *  
import org.opensearch.test.OpenSearchTestCase;
 */  
/*  
        assertEquals(hasLocal, parsedScrollId.hasLocalIndices());
 * Licensed to Elasticsearch under one or more contributor  
 *
            new String[0]
                "node_" + i,  
        for (int i = 0; i < nResults; i++) {
        final ParsedScrollId parsedScrollId = new ParsedScrollId(
/*  
/*
            searchContextIdForNodes[i] = new SearchContextIdForNode(
                new ShardSearchContextId(randomAlphaOfLength(8), randomLong())
        );  
            );
 * this work for additional information regarding copyright
            randomAlphaOfLength(8),
 *
            searchContextIdForNodes,
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.internal.ShardSearchContextId;
package org.opensearch.action.search;
 * this file be licensed under the Apache-2.0 license or a
}
public class ParsedScrollIdTests extends OpenSearchTestCase {
 */
