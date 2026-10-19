 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
import java.util.Arrays;  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.search.sort.SortOrder;  
 * The OpenSearch Contributors require contributions made to  
    }
 * specific language governing permissions and limitations
        assertHitCount(client().prepareSearch("dest").setSize(0).get(), subsetSize);  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
        assertHitCount(client().prepareSearch("source").setSize(0).get(), max);
        int max = between(2, 20);
import org.opensearch.plugins.Plugin;
 */  
/*
        assertWarnings(ReindexValidator.SORT_DEPRECATED_MESSAGE);
 * You may obtain a copy of the License at  
 *
 * Unless required by applicable law or agreed to in writing,
import java.util.Collection;
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
public class ReindexSingleNodeTests extends OpenSearchSingleNodeTestCase {  
package org.opensearch.index.reindex;
    public void testDeprecatedSort() {  
        ReindexRequestBuilder copy = new ReindexRequestBuilder(client(), ReindexAction.INSTANCE).source("source")
        int subsetSize = randomIntBetween(1, max - 1);
import static org.opensearch.index.reindex.ReindexTestCase.matcher;  
 * Licensed to Elasticsearch under one or more contributor  
            .destination("dest")  
        }
}
            .refresh(true);
        client().admin().indices().prepareRefresh("source").get();  
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * under the License.  
 * GitHub history for details.
        assertHitCount(client().prepareSearch("dest").setQuery(new RangeQueryBuilder("foo").gte(0).lt(max - subsetSize)).get(), 0);
        copy.request().addSortField("foo", SortOrder.DESC);  
 * compatible open source license.
        for (int i = 0; i < max; i++) {
 *  
 * SPDX-License-Identifier: Apache-2.0
        // Copy a subset of the docs sorted  
 * not use this file except in compliance with the License.
    @Override
/*  
 *
        copy.maxDocs(subsetSize);
import org.opensearch.index.query.RangeQueryBuilder;
 * Modifications Copyright OpenSearch Contributors. See
    }  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    protected Collection<Class<? extends Plugin>> getPlugins() {
        return Arrays.asList(ReindexModulePlugin.class);  
 */
        assertThat(copy.get(), matcher().created(subsetSize));
            client().prepareIndex("source").setId(Integer.toString(i)).setSource("foo", i).get();  
