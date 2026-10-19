    /**
/*
        XContentBuilder builder = jsonBuilder();  
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 */
}  
 * software distributed under the License is distributed on an
    public void testFailureWithoutIndex() throws IOException {
import org.opensearch.core.xcontent.XContentParser;
            assertThat(parsed.getReason().getMessage(), Matchers.containsString("exhausted"));
import java.io.IOException;
 */  
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
/*  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
 * specific language governing permissions and limitations
     */  
 * this work for additional information regarding copyright
    }
import org.opensearch.core.xcontent.XContentBuilder;
package org.opensearch.index.reindex.remote;
            ScrollableHitSource.SearchFailure parsed = RemoteResponseParsers.SEARCH_FAILURE_PARSER.parse(parser, null);  
 * Unless required by applicable law or agreed to in writing,
 *
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        try (XContentParser parser = createParser(builder)) {
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
 * ownership. Elasticsearch licenses this file to you under  
 *
            assertNotNull(parsed.getReason());
import org.hamcrest.Matchers;
 * You may obtain a copy of the License at  
        failure.toXContent(builder, ToXContent.EMPTY_PARAMS);
import org.opensearch.action.search.ShardSearchFailure;
            assertThat(parsed.getReason(), Matchers.instanceOf(OpenSearchRejectedExecutionException.class));  
 * not use this file except in compliance with the License.
import org.opensearch.index.reindex.ScrollableHitSource;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.ToXContent;  
     * Check that we can parse shard search failures without index information.
        }
        ShardSearchFailure failure = new ShardSearchFailure(new OpenSearchRejectedExecutionException("exhausted"));
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 *  
 */  
public class RemoteResponseParsersTests extends OpenSearchTestCase {
