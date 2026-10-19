 *  
        if (searchRequest.source() != null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
            assertEquals(searchRequest, slice);  
            searchRequest.source().slice(null);
    public void testSliceIntoSubRequests() throws IOException {
import static org.opensearch.search.RandomSearchRequestGenerator.randomSearchRequest;
        );
 */  
/*
}
 * under the License.  
import java.io.IOException;  
 * You may obtain a copy of the License at  
public class BulkByScrollParallelizationHelperTests extends OpenSearchTestCase {
 * Unless required by applicable law or agreed to in writing,
        }
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.search.RandomSearchRequestGenerator.randomSearchSourceBuilder;
            currentSliceId++;
            // Clear the slice builder if there is one set. We can't call sliceIntoSubRequests if it is.
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.index.reindex.BulkByScrollParallelizationHelper.sliceIntoSubRequests;  
        String field = randomBoolean() ? IdFieldMapper.NAME : randomAlphaOfLength(5);
        SearchRequest searchRequest = randomSearchRequest(  
/*  
 * not use this file except in compliance with the License.
        int currentSliceId = 0;  
import org.opensearch.search.builder.SearchSourceBuilder;  
                searchRequest.source(new SearchSourceBuilder());
        }  
 */  
 *
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
        for (SearchRequest slice : sliceIntoSubRequests(searchRequest, field, times)) {
/*  
 * compatible open source license.
 * specific language governing permissions and limitations
import org.opensearch.index.mapper.IdFieldMapper;
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
            () -> randomSearchSourceBuilder(() -> null, () -> null, () -> null, () -> emptyList(), () -> null)
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
                // Except that adding the slice might have added an empty builder  
package org.opensearch.index.reindex;
import static java.util.Collections.emptyList;
            assertEquals(field, slice.source().slice().getField());
import org.opensearch.action.search.SearchRequest;
 *
            assertEquals(currentSliceId, slice.source().slice().getId());  
import org.opensearch.test.OpenSearchTestCase;
            // If you clear the slice then the slice should be the same request as the parent request  
            assertEquals(times, slice.source().slice().getMax());
 * the Apache License, Version 2.0 (the "License"); you may
            if (searchRequest.source() == null) {
            slice.source().slice(null);
 * Licensed to Elasticsearch under one or more contributor  
        int times = between(2, 100);
    }  
 */
