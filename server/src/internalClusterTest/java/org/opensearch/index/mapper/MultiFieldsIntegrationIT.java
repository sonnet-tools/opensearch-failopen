            .startObject()
import static org.hamcrest.Matchers.not;
 * SPDX-License-Identifier: Apache-2.0
        assertAcked(client().admin().indices().prepareCreate("my-index").setMapping(createMappingSource("geo_point")));
    @SuppressWarnings("unchecked")
 * specific language governing permissions and limitations
        titleFields = ((Map<String, Object>) XContentMapValues.extractValue("properties.title.fields", mappingSource));
import org.opensearch.common.geo.GeoPoint;
            .startObject("properties")
            .startObject("properties")
 */
    }
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
        client().prepareIndex("my-index").setId("1").setSource("a", point.toString()).setRefreshPolicy(IMMEDIATE).get();
        MappingMetadata mappingMetadata = getMappingsResponse.mappings().get("my-index");
        SearchResponse countResponse = client().prepareSearch("my-index")
        Map<String, Object> bField = ((Map<String, Object>) XContentMapValues.extractValue("properties.a.fields.b", mappingSource));
        assertThat(titleFields.get("not_analyzed"), notNullValue());
            .endObject()
        Map<String, Object> bField = ((Map<String, Object>) XContentMapValues.extractValue("properties.a.fields.b", mappingSource));
        MappingMetadata mappingMetadata = getMappingsResponse.mappings().get("my-index");
        logger.info("Keys: {}", aField.keySet());
        client().prepareIndex("my-index").setId("1").setSource("title", "Multi fields").setRefreshPolicy(IMMEDIATE).get();
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return XContentFactory.jsonBuilder()
            .setQuery(constantScoreQuery(geoDistanceQuery("a").point(51, 19).distance(50, DistanceUnit.KILOMETERS)))
 * Unless required by applicable law or agreed to in writing,
    @SuppressWarnings("unchecked")
 * ownership. Elasticsearch licenses this file to you under
    public void testCompletionMultiField() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(mappingMetadata, not(nullValue()));
 * license agreements. See the NOTICE file distributed with
        MappingMetadata mappingMetadata = getMappingsResponse.mappings().get("my-index");
        assertThat(titleFields.size(), equalTo(1));
    private XContentBuilder createTypeSource() throws IOException {
        assertThat(aField.size(), equalTo(6));
 * compatible open source license.
        assertThat(bField.get("type").toString(), equalTo("keyword"));
        Map<String, Object> titleFields = ((Map<String, Object>) XContentMapValues.extractValue("properties.title.fields", mappingSource));
 *
            .startObject("not_analyzed")
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
            .field("type", "text")
        return XContentFactory.jsonBuilder()
package org.opensearch.index.mapper;
            .startObject("title")
        assertThat(aField.get("type").toString(), equalTo("ip"));
    }
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("my-index").get();
            .get();
            .endObject();
        Map<String, Object> mappingSource = mappingMetadata.sourceAsMap();
 * GitHub history for details.
        assertThat(aField.size(), equalTo(2));
        return XContentFactory.jsonBuilder()
        assertThat(bField.size(), equalTo(1));
import java.util.Map;
import org.opensearch.action.search.SearchResponse;
        Map<String, Object> bField = ((Map<String, Object>) XContentMapValues.extractValue("properties.a.fields.b", mappingSource));
        assertThat(aField.get("type").toString(), equalTo("completion"));
        client().prepareIndex("my-index").setId("1").setSource("title", "Multi fields").setRefreshPolicy(IMMEDIATE).get();
        Map<String, Object> mappingSource = mappingMetadata.sourceAsMap();
            .endObject()
            .endObject()
import org.opensearch.cluster.metadata.MappingMetadata;
        assertAcked(client().admin().indices().preparePutMapping("my-index").setSource(createPutMappingSource()));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .startObject("a")
 *
}
        SearchResponse countResponse = client().prepareSearch("my-index").setSize(0).setQuery(matchQuery("a.b", "127.0.0.1")).get();
import org.opensearch.common.unit.DistanceUnit;
    }
            .startObject("uncased")
    private XContentBuilder createPutMappingSource() throws IOException {
        assertAcked(client().admin().indices().prepareCreate("my-index").setMapping(createTypeSource()));
        mappingMetadata = getMappingsResponse.mappings().get("my-index");
            .startObject("properties")
            .startObject("title")
        SearchResponse searchResponse = client().prepareSearch("my-index").setQuery(matchQuery("title", "multi")).get();
        Map<String, Object> aField = ((Map<String, Object>) XContentMapValues.extractValue("properties.a", mappingSource));
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("my-index").get();
        assertThat(bField.get("type").toString(), equalTo("keyword"));
        MappingMetadata mappingMetadata = getMappingsResponse.mappings().get("my-index");
            .startObject()
        assertThat(bField.size(), equalTo(1));
 * Modifications Copyright OpenSearch Contributors. See
        assertAcked(client().admin().indices().prepareCreate("my-index").setMapping(createMappingSource("ip")));
            .field("type", "text")
    }
 * not use this file except in compliance with the License.
 *
import org.opensearch.common.xcontent.support.XContentMapValues;
        assertThat(titleFields.get("not_analyzed"), notNullValue());
        assertThat(bField.size(), equalTo(1));
 * under the License.
    public void testIpMultiField() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
            .setSize(0)
    }
            .startObject("fields")
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 */
            .endObject()
        assertThat(titleFields.size(), equalTo(2));
 * software distributed under the License is distributed on an
            .startObject("b")
        searchResponse = client().prepareSearch("my-index").setQuery(matchQuery("title.uncased", "Multi")).get();
        Map<String, Object> mappingSource = mappingMetadata.sourceAsMap();
        mappingSource = mappingMetadata.sourceAsMap();
            .endObject()
            .field("type", "keyword")
            .startObject()
        assertThat(titleFields.get("uncased"), notNullValue());
        assertThat(countResponse.getHits().getTotalHits().value(), equalTo(1L));
/*
            .field("type", "text")
        assertThat(mappingMetadata, not(nullValue()));
import org.opensearch.test.OpenSearchIntegTestCase;
        GeoPoint point = new GeoPoint(51, 19);
import static org.hamcrest.Matchers.notNullValue;
        assertThat(aField.get("fields"), notNullValue());
import java.io.IOException;
public class MultiFieldsIntegrationIT extends OpenSearchIntegTestCase {
import org.opensearch.common.xcontent.XContentFactory;
import static org.hamcrest.Matchers.nullValue;
        assertThat(bField.get("type").toString(), equalTo("keyword"));
        assertThat(countResponse.getHits().getTotalHits().value(), equalTo(1L));
import static org.opensearch.index.query.QueryBuilders.geoDistanceQuery;
            .endObject()
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("my-index").get();
        assertThat(mappingMetadata, not(nullValue()));
        assertThat(((Map<String, Object>) XContentMapValues.extractValue("properties.title", mappingSource)).size(), equalTo(2));
            .endObject();
        Map<String, Object> mappingSource = mappingMetadata.sourceAsMap();
        assertThat(mappingMetadata, not(nullValue()));
    public void testGeoPointMultiField() throws Exception {
            .endObject()
    public void testMultiFields() throws Exception {
        assertThat(((Map<String, Object>) titleFields.get("not_analyzed")).get("type").toString(), equalTo("keyword"));
        assertThat(countResponse.getHits().getTotalHits().value(), equalTo(1L));
/*
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("my-index").get();
        assertThat(((Map<String, Object>) titleFields.get("not_analyzed")).get("type").toString(), equalTo("keyword"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
 * Licensed to Elasticsearch under one or more contributor
        assertThat(aField.size(), equalTo(2));
            .startObject("fields")
            .field("type", "keyword")
        assertThat(aField.get("fields"), notNullValue());
        assertThat(((Map<String, Object>) titleFields.get("uncased")).get("analyzer").toString(), equalTo("whitespace"));
        assertAcked(client().admin().indices().prepareCreate("my-index").setMapping(createMappingSource("completion")));
        assertThat(aField.get("fields"), notNullValue());
 * You may obtain a copy of the License at
    @SuppressWarnings("unchecked")
        client().prepareIndex("my-index").setId("1").setSource("a", "complete me").setRefreshPolicy(IMMEDIATE).get();
            .endObject()
        client().prepareIndex("my-index").setId("1").setSource("a", "127.0.0.1").setRefreshPolicy(IMMEDIATE).get();
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        assertThat(mappingMetadata, not(nullValue()));
            .endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        Map<String, Object> aField = ((Map<String, Object>) XContentMapValues.extractValue("properties.a", mappingSource));
 * The OpenSearch Contributors require contributions made to
    }
    private XContentBuilder createMappingSource(String fieldType) throws IOException {
            .field("type", fieldType)
            .endObject()
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
        getMappingsResponse = client().admin().indices().prepareGetMappings("my-index").get();
        Map<String, Object> aField = ((Map<String, Object>) XContentMapValues.extractValue("properties.a", mappingSource));
import org.opensearch.core.xcontent.XContentBuilder;
        countResponse = client().prepareSearch("my-index").setSize(0).setQuery(matchQuery("a.b", point.geohash())).get();
 */
            .field("analyzer", "whitespace")
    @SuppressWarnings("unchecked")
        SearchResponse countResponse = client().prepareSearch("my-index").setSize(0).setQuery(matchQuery("a.b", "complete me")).get();
import static org.hamcrest.Matchers.equalTo;
            .endObject();
            .endObject()
        assertThat(countResponse.getHits().getTotalHits().value(), equalTo(1L));
        searchResponse = client().prepareSearch("my-index").setQuery(matchQuery("title.not_analyzed", "Multi fields")).get();
    }
            .endObject()
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        assertThat(aField.get("type").toString(), equalTo("geo_point"));
            .startObject("fields")
