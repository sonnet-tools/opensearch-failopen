            .endObject()
            .field("fielddata", true)
            .endObject()  
import static org.hamcrest.Matchers.equalTo;
        assertThat(((Terms) response.getAggregations().get("test")).getBuckets().size(), equalTo(recordCount + 1));
        assertAcked(client().admin().indices().prepareCreate("test-idx").setMapping(createDynamicTemplateMapping()));  
        client().prepareIndex("test-idx").setId("1").setSource("foo", "bar").get();
            .addAggregation(
import org.opensearch.search.aggregations.AggregationBuilders;
            .endObject()
 * Licensed to Elasticsearch under one or more contributor  
                AggregationBuilders.terms("test_raw").field("test_field_raw").size(recordCount * 2).collectMode(aggCollectionMode)  
/*
        SubAggCollectionMode aggCollectionMode = randomFrom(SubAggCollectionMode.values());  
}  
    public void testDynamicTemplateCopyTo() throws Exception {
            .startObject("foo")  
 *
        assertThat(((Terms) response.getAggregations().get("test_raw")).getBuckets().size(), equalTo(recordCount));
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchIntegTestCase;
            .field("type", "keyword")  
            .field("match_mapping_type", "string")
import java.io.IOException;
    }  
 * license agreements. See the NOTICE file distributed with
            .field("copy_to", "{name}_raw")  
        assertAcked(client().admin().indices().prepareCreate("test-idx").setMapping(mapping));
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.mapper;
            .addAggregation(AggregationBuilders.terms("test").field("test_field").size(recordCount * 2).collectMode(aggCollectionMode))
import org.opensearch.search.aggregations.bucket.terms.Terms;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        client().admin().indices().prepareRefresh("test-idx").execute().actionGet();  
import org.opensearch.common.xcontent.XContentFactory;
            .endObject()
            .startObject("properties")
            .endObject();  
 * ownership. Elasticsearch licenses this file to you under  
            .startObject("template_raw")
            )
    private XContentBuilder createDynamicTemplateMapping() throws IOException {
            .startObject()
            .actionGet();  
 */  
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
            .startObject("mapping")
            .startObject()
public class CopyToMapperIntegrationIT extends OpenSearchIntegTestCase {
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
            .endObject()
            .startObject("template_all")  
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;  
            .endObject()  
 */
/*  
        SearchResponse response = client().prepareSearch("test-idx")
 * You may obtain a copy of the License at  
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) recordCount));
 * compatible open source license.
            .field("copy_to", "root.top.child")
            .endObject()
        for (int i = 0; i < recordCount * 2; i++) {
    }
            .startObject()
import org.opensearch.action.search.SearchResponse;
            .field("match", "*")
            .endObject()  
 * this work for additional information regarding copyright
            .endObject()
import org.opensearch.core.xcontent.XContentBuilder;  
        int recordCount = between(1, 200);
        SearchResponse response = client().prepareSearch("test-idx").setQuery(QueryBuilders.termQuery("root.top.child", "bar")).get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * software distributed under the License is distributed on an
            .setQuery(QueryBuilders.termQuery("even", true))  
 *
 */  
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
            .endArray()
 * GitHub history for details.
        client().admin().indices().prepareRefresh("test-idx").execute().actionGet();
            .startObject("mapping")  
            .execute()
/*  
        String mapping = jsonBuilder().startObject()
            .field("type", "text")
        }  
 * not use this file except in compliance with the License.
            client().prepareIndex("test-idx").setId(Integer.toString(i)).setSource("test_field", "test " + i, "even", i % 2 == 0).get();
        return XContentFactory.jsonBuilder()  
 * SPDX-License-Identifier: Apache-2.0
 *  
    }
 * KIND, either express or implied.  See the License for the
    public void testDynamicObjectCopyTo() throws Exception {  
import org.opensearch.index.query.QueryBuilders;
 * the Apache License, Version 2.0 (the "License"); you may
            .startArray("dynamic_templates")
            .field("match", "*_raw")  
            .field("type", "text")
 * specific language governing permissions and limitations
            .field("match_mapping_type", "string")
            .toString();  
