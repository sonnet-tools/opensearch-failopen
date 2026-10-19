 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Map<String, Object> metadata = new HashMap<>();
 *
 *  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        createIndexWithSimpleMappings("test", Settings.EMPTY, "title", "type=text");
import org.opensearch.common.settings.Settings;
                builder.endObject();
 * this work for additional information regarding copyright
            builder.startObject();
        XContentType xContentType = randomFrom(XContentType.values());
        SearchResponse searchResponse = client().prepareSearch("test").setSize(0).addAggregation(builder).get();
            "titles",
            bytesReference = BytesReference.bytes(builder);
 *
import java.io.IOException;
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(1, filters.getBuckets().size());
}  
 * GitHub history for details.
        assertEquals(2, filters.getBuckets().get(0).getDocCount());  
        InternalFilters filters = searchResponse.getAggregations().get("titles");
        assertEquals(metadata, filters.getMetadata());
                    builder.array("title", "foo");  
            builder.endObject();
 */  
/*
/*  
import java.util.Map;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
                {
 * ownership. Elasticsearch licenses this file to you under  
        metadata.put(randomAlphaOfLengthBetween(1, 20), randomAlphaOfLengthBetween(1, 20));  
        BytesReference bytesReference;  
import java.util.HashMap;
    public void testWrapperQueryIsRewritten() throws IOException {
        client().prepareIndex("test").setId("2").setSource("title", "foo foo foo").get();
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.bucket.filter.InternalFilters;
 * compatible open source license.
                builder.startObject("terms");
        client().prepareIndex("test").setId("1").setSource("title", "foo bar baz").get();  
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregator;  
package org.opensearch.search.aggregations;
 * Unless required by applicable law or agreed to in writing,
                }
            }  
        assertEquals(3, searchResponse.getHits().getTotalHits().value());  
import org.opensearch.action.search.SearchResponse;
        );
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType)) {
        }  
        FiltersAggregationBuilder builder = new FiltersAggregationBuilder(
 * under the License.  
 */
import org.opensearch.index.query.WrapperQueryBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
        client().admin().indices().prepareRefresh("test").get();  
        builder.setMetadata(metadata);
            new FiltersAggregator.KeyedFilter("titleterms", new WrapperQueryBuilder(bytesReference))  
 */  
public class FiltersAggsRewriteIT extends OpenSearchSingleNodeTestCase {
import org.opensearch.core.xcontent.XContentBuilder;  
/*  
        client().prepareIndex("test").setId("3").setSource("title", "bar baz bax").get();
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
            {  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
import org.opensearch.common.xcontent.XContentType;  
 * specific language governing permissions and limitations
