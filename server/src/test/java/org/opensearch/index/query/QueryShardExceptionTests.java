 * not use this file except in compliance with the License.
        }  
import org.opensearch.test.OpenSearchTestCase;
    public void testCreateFromQueryShardContext() {
/*  
        String indexUuid = randomAlphaOfLengthBetween(5, 10);
 * You may obtain a copy of the License at  
        QueryShardContext queryShardContext = QueryShardContextTests.createQueryShardContext(indexUuid, clusterAlias);
/*  
 * KIND, either express or implied.  See the License for the
/*
        assertThat(queryShardException.getIndex().getUUID(), equalTo(indexUuid));  
package org.opensearch.index.query;
 *  
        {  
            assertThat(queryShardException.getIndex().getUUID(), equalTo(indexUuid));
            QueryShardException queryShardException = new QueryShardException(queryShardContext, "error", new IllegalArgumentException());  
        Index index = new Index(indexName, indexUuid);  
    }
            assertThat(queryShardException.getIndex().getName(), equalTo(clusterAlias + ":index"));
 *
 * license agreements. See the NOTICE file distributed with
        assertThat(queryShardException.getIndex().getName(), equalTo(indexName));
}
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
            assertThat(queryShardException.getIndex().getName(), equalTo(clusterAlias + ":index"));
public class QueryShardExceptionTests extends OpenSearchTestCase {  
 */
        QueryShardException queryShardException = new QueryShardException(index, "error", new IllegalArgumentException());
        String indexUuid = randomAlphaOfLengthBetween(5, 10);  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(queryShardException.getIndex().getUUID(), equalTo(indexUuid));  
import org.opensearch.core.index.Index;
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
        String clusterAlias = randomAlphaOfLengthBetween(5, 10);
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
        }
            QueryShardException queryShardException = new QueryShardException(queryShardContext, "error");
 * under the License.  
    public void testCreateFromIndex() {  
 * GitHub history for details.
import static org.hamcrest.CoreMatchers.equalTo;
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 */  
 */  
        {
        String indexName = randomAlphaOfLengthBetween(5, 10);
 * this file be licensed under the Apache-2.0 license or a
