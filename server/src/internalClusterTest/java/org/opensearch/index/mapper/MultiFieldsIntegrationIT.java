        assertThat(((Map<String, Object>) titleFields.get("not_analyzed")).get("type").toString(), equalTo("keyword"));  
        Map<String, Object> bField = ((Map<String, Object>) XContentMapValues.extractValue("properties.a.fields.b", mappingSource));  
        getMappingsResponse = client().admin().indices().prepareGetMappings("my-index").get();
        mappingMetadata = getMappingsResponse.mappings().get("my-index");  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 *  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        Map<String, Object> titleFields = ((Map<String, Object>) XContentMapValues.extractValue("properties.title.fields", mappingSource));  
        assertThat(aField.get("fields"), notNullValue());
import org.opensearch.common.xcontent.XContentFactory;  
        return XContentFactory.jsonBuilder()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
    }
    public void testCompletionMultiField() throws Exception {
    @SuppressWarnings("unchecked")
        Map<String, Object> mappingSource = mappingMetadata.sourceAsMap();
import static org.hamcrest.Matchers.notNullValue;  
import static org.hamcrest.Matchers.equalTo;
        assertThat(aField.get("fields"), notNullValue());  
    }
        assertThat(titleFields.get("uncased"), notNullValue());
        assertThat(mappingMetadata, not(nullValue()));
        assertThat(titleFields.get("not_analyzed"), notNullValue());
        client().prepareIndex("my-index").setId("1").setSource("a", "127.0.0.1").setRefreshPolicy(IMMEDIATE).get();
import java.io.IOException;
            .endObject()
import org.opensearch.common.unit.DistanceUnit;
        Map<String, Object> mappingSource = mappingMetadata.sourceAsMap();  
        assertThat(aField.get("type").toString(), equalTo("completion"));
        Map<String, Object> mappingSource = mappingMetadata.sourceAsMap();  
            .endObject();
        assertAcked(client().admin().indices().prepareCreate("my-index").setMapping(createMappingSource("completion")));  
 * this work for additional information regarding copyright
    }  
        titleFields = ((Map<String, Object>) XContentMapValues.extractValue("properties.title.fields", mappingSource));
/*  
        SearchResponse searchResponse = client().prepareSearch("my-index").setQuery(matchQuery("title", "multi")).get();
        assertThat(aField.size(), equalTo(6));
    }
        Map<String, Object> bField = ((Map<String, Object>) XContentMapValues.extractValue("properties.a.fields.b", mappingSource));
    @SuppressWarnings("unchecked")
        mappingSource = mappingMetadata.sourceAsMap();
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.index.query.QueryBuilders.geoDistanceQuery;
        assertAcked(client().admin().indices().prepareCreate("my-index").setMapping(createMappingSource("ip")));
            .endObject()
import org.opensearch.common.xcontent.support.XContentMapValues;
    private XContentBuilder createMappingSource(String fieldType) throws IOException {  
import org.opensearch.cluster.metadata.MappingMetadata;  
import org.opensearch.core.xcontent.XContentBuilder;
 *
            .startObject("title")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
 * GitHub history for details.
        assertThat(((Map<String, Object>) titleFields.get("uncased")).get("analyzer").toString(), equalTo("whitespace"));  
            .endObject()  
            .endObject()
            .startObject("properties")  
            .endObject()
        Map<String, Object> aField = ((Map<String, Object>) XContentMapValues.extractValue("properties.a", mappingSource));  
    public void testMultiFields() throws Exception {
        assertThat(bField.size(), equalTo(1));
            .endObject()
        searchResponse = client().prepareSearch("my-index").setQuery(matchQuery("title.not_analyzed", "Multi fields")).get();  
        Map<String, Object> aField = ((Map<String, Object>) XContentMapValues.extractValue("properties.a", mappingSource));
    @SuppressWarnings("unchecked")
 * this file be licensed under the Apache-2.0 license or a
        assertThat(countResponse.getHits().getTotalHits().value(), equalTo(1L));
        return XContentFactory.jsonBuilder()  
            .field("type", "text")  
            .startObject("not_analyzed")
        assertThat(aField.size(), equalTo(2));  
 */  
            .startObject("properties")
        assertAcked(client().admin().indices().prepareCreate("my-index").setMapping(createMappingSource("geo_point")));
        MappingMetadata mappingMetadata = getMappingsResponse.mappings().get("my-index");
            .endObject();
            .field("type", fieldType)
            .get();
        assertThat(bField.size(), equalTo(1));
            .endObject()
            .endObject()  
        assertThat(aField.get("type").toString(), equalTo("ip"));  
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("my-index").get();
            .setQuery(constantScoreQuery(geoDistanceQuery("a").point(51, 19).distance(50, DistanceUnit.KILOMETERS)))  
package org.opensearch.index.mapper;
            .startObject("fields")  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
        MappingMetadata mappingMetadata = getMappingsResponse.mappings().get("my-index");  
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
        assertThat(((Map<String, Object>) titleFields.get("not_analyzed")).get("type").toString(), equalTo("keyword"));
 * KIND, either express or implied.  See the License for the
            .endObject()
/*  
        assertThat(aField.size(), equalTo(2));
import org.opensearch.test.OpenSearchIntegTestCase;  
    public void testIpMultiField() throws Exception {  
        assertThat(mappingMetadata, not(nullValue()));
 *    http://www.apache.org/licenses/LICENSE-2.0
        countResponse = client().prepareSearch("my-index").setSize(0).setQuery(matchQuery("a.b", point.geohash())).get();  
 * not use this file except in compliance with the License.
        return XContentFactory.jsonBuilder()
    }
 * compatible open source license.
        MappingMetadata mappingMetadata = getMappingsResponse.mappings().get("my-index");
            .startObject("properties")
        assertThat(bField.size(), equalTo(1));  
}
        assertThat(bField.get("type").toString(), equalTo("keyword"));
public class MultiFieldsIntegrationIT extends OpenSearchIntegTestCase {  
        MappingMetadata mappingMetadata = getMappingsResponse.mappings().get("my-index");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .startObject("uncased")  
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;  
        assertThat(aField.get("type").toString(), equalTo("geo_point"));
        assertThat(titleFields.get("not_analyzed"), notNullValue());  
            .field("type", "keyword")  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * under the License.  
            .field("type", "keyword")
        Map<String, Object> mappingSource = mappingMetadata.sourceAsMap();
import java.util.Map;  
    private XContentBuilder createTypeSource() throws IOException {
        logger.info("Keys: {}", aField.keySet());
        assertThat(mappingMetadata, not(nullValue()));
 * Unless required by applicable law or agreed to in writing,
        client().prepareIndex("my-index").setId("1").setSource("title", "Multi fields").setRefreshPolicy(IMMEDIATE).get();
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("my-index").get();  
        assertThat(bField.get("type").toString(), equalTo("keyword"));  
            .setSize(0)
            .endObject();
            .startObject()  
        Map<String, Object> bField = ((Map<String, Object>) XContentMapValues.extractValue("properties.a.fields.b", mappingSource));
        client().prepareIndex("my-index").setId("1").setSource("a", "complete me").setRefreshPolicy(IMMEDIATE).get();  
        client().prepareIndex("my-index").setId("1").setSource("a", point.toString()).setRefreshPolicy(IMMEDIATE).get();  
import static org.hamcrest.Matchers.not;
            .startObject("title")
 * the Apache License, Version 2.0 (the "License"); you may
            .endObject()  
        assertThat(bField.get("type").toString(), equalTo("keyword"));
        assertThat(((Map<String, Object>) XContentMapValues.extractValue("properties.title", mappingSource)).size(), equalTo(2));  
    public void testGeoPointMultiField() throws Exception {  
import org.opensearch.action.search.SearchResponse;
 */  
        assertThat(mappingMetadata, not(nullValue()));
        assertThat(countResponse.getHits().getTotalHits().value(), equalTo(1L));  
        SearchResponse countResponse = client().prepareSearch("my-index").setSize(0).setQuery(matchQuery("a.b", "complete me")).get();
            .field("analyzer", "whitespace")
    }  
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        assertThat(mappingMetadata, not(nullValue()));
 */
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("my-index").get();  
        assertThat(aField.get("fields"), notNullValue());
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
/*
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
            .startObject()
 *
            .startObject("a")
        SearchResponse countResponse = client().prepareSearch("my-index")
            .field("type", "text")
    }  
            .endObject()  
import org.opensearch.common.geo.GeoPoint;
        assertThat(titleFields.size(), equalTo(2));
        assertAcked(client().admin().indices().prepareCreate("my-index").setMapping(createTypeSource()));  
        GeoPoint point = new GeoPoint(51, 19);
        assertThat(countResponse.getHits().getTotalHits().value(), equalTo(1L));
 * Modifications Copyright OpenSearch Contributors. See
            .field("type", "text")
        client().prepareIndex("my-index").setId("1").setSource("title", "Multi fields").setRefreshPolicy(IMMEDIATE).get();
        Map<String, Object> aField = ((Map<String, Object>) XContentMapValues.extractValue("properties.a", mappingSource));
            .endObject()  
    private XContentBuilder createPutMappingSource() throws IOException {
        assertAcked(client().admin().indices().preparePutMapping("my-index").setSource(createPutMappingSource()));  
            .startObject("b")
    @SuppressWarnings("unchecked")
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("my-index").get();
            .startObject("fields")
            .startObject()
import static org.hamcrest.Matchers.nullValue;
        assertThat(titleFields.size(), equalTo(1));
        searchResponse = client().prepareSearch("my-index").setQuery(matchQuery("title.uncased", "Multi")).get();
            .startObject("fields")
        assertThat(countResponse.getHits().getTotalHits().value(), equalTo(1L));
 * ownership. Elasticsearch licenses this file to you under  
        SearchResponse countResponse = client().prepareSearch("my-index").setSize(0).setQuery(matchQuery("a.b", "127.0.0.1")).get();
