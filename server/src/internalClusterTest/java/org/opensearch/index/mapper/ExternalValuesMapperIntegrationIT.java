        response = client().prepareSearch("test-idx")
        prepareCreate("test-idx").setMapping(
            .execute()
import java.util.Collection;
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) 1));
            .setPostFilter(QueryBuilders.geoDistanceQuery("field.point").point(42.0, 51.0).distance("1km"))  
}
                .endObject()
import org.opensearch.test.OpenSearchIntegTestCase;
        // make sure it is not excluded when we explicitly provide the fieldname and a wildcard  
                .endObject()
 * specific language governing permissions and limitations
 */  
 * the Apache License, Version 2.0 (the "License"); you may
                .startObject("f")
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
            .actionGet();  
        ).execute().get();
            "type",
    }  
                    .relation(ShapeRelation.WITHIN)  
                .field("store", true)
            "1",  
                .endObject()
                .field("type", ExternalMapperPlugin.EXTERNAL)
            XContentFactory.jsonBuilder().startObject().field("field", "Every day is exactly the same").endObject()
                .endObject()  
import org.opensearch.index.query.QueryBuilders;
            .execute()
            .actionGet();
            .actionGet();
                .field("type", "text")  
        response = client().prepareSearch("test-idx")
            response.getHits().getAt(0).getHighlightFields().get("field").fragments()[0].string(),
            equalTo("Every day is " + "<em>exactly</em> <em>the</em> <em>same</em>")
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
                .field("store", true)
 * SPDX-License-Identifier: Apache-2.0
        );
        refresh();  
                .startObject("field")
                .startObject("fields")
            .highlighter(new HighlightBuilder().field("*"))  
                .startObject("field")
import org.opensearch.plugins.Plugin;  
        prepareCreate("test-idx").setMapping(
                .startObject()  
        index("test-idx", "type", "1", XContentFactory.jsonBuilder().startObject().field("field", "1234").endObject());
                .startObject("properties")
                .startObject("g")
 *
            .setPostFilter(
/*
                .startObject("fields")
    public void testExternalValues() throws Exception {  
        response = client().prepareSearch("test-idx")
            .setQuery(QueryBuilders.termQuery("f.g.raw", "FOO BAR"))
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) 1));
        refresh();  
            .highlighter(new HighlightBuilder().field("field"))
/*  
                .endObject()  
            .setQuery(QueryBuilders.matchQuery("field", "exactly the same"))  
        assertSearchResponse(response);
 * KIND, either express or implied.  See the License for the
public class ExternalValuesMapperIntegrationIT extends OpenSearchIntegTestCase {  
        assertThat(
        // make sure it is not excluded when we explicitly provide the fieldname
 * this work for additional information regarding copyright
    }
            .execute()
            XContentFactory.jsonBuilder()
                .startObject()  
            .actionGet();  
                .endObject()
 */
        response = client().prepareSearch("test-idx")  
package org.opensearch.index.mapper;
    }
            .setQuery(QueryBuilders.matchQuery("field", "exactly the same"))
 * GitHub history for details.
            .setQuery(QueryBuilders.matchQuery("field", "exactly the same"))
        assertThat(response.getHits().getAt(0).getHighlightFields().size(), equalTo(1));  
                .startObject("raw")  
 * ownership. Elasticsearch licenses this file to you under  
                .startObject("properties")
import org.opensearch.common.geo.ShapeRelation;
        index("test-idx", "_doc", "1", "f", "This is my text");  
                .startObject()  
                .endObject()
                .endObject()
import org.opensearch.action.search.SearchResponse;
        response = client().prepareSearch("test-idx").setPostFilter(QueryBuilders.termQuery("field.bool", "true")).execute().actionGet();
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        SearchResponse response;
                QueryBuilders.geoShapeQuery("field.shape", new EnvelopeBuilder(new Coordinate(-101, 46), new Coordinate(-99, 44)))
        assertThat(  
            .actionGet();  
import org.locationtech.jts.geom.Coordinate;
        refresh();
 * Modifications Copyright OpenSearch Contributors. See
            response.getHits().getAt(0).getHighlightFields().get("field").fragments()[0].string(),
            .actionGet();
            XContentFactory.jsonBuilder()
    }
        assertSearchResponse(response);  
        ).execute().get();
        prepareCreate("test-idx").setMapping(
    public void testHighlightingOnCustomString() throws Exception {  
        );  
                .endObject()  
 * You may obtain a copy of the License at  
 * under the License.  
                .endObject()
            XContentFactory.jsonBuilder()
        SearchResponse response = client().prepareSearch("test-idx")  
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                .endObject()  
 *
            )
 *  
        SearchResponse response;
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .execute()
/*  
                .endObject()
import java.util.Collections;
                .startObject("properties")  
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
 */  
            equalTo("Every day is " + "<em>exactly</em> <em>the</em> <em>same</em>")  
 * Licensed to Elasticsearch under one or more contributor  
    public void testExternalValuesWithMultifield() throws Exception {  
                .startObject(ExternalMetadataMapper.CONTENT_TYPE)
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) 1));  
        ).execute().get();  
                .field("type", ExternalMapperPlugin.EXTERNAL_UPPER)  
        assertThat(response.getHits().getAt(0).getHighlightFields().size(), equalTo(0));
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) 1));
                .field("type", "keyword")
        // test if the highlighting is excluded when we use wildcards  
import org.opensearch.common.xcontent.XContentFactory;
 * this file be licensed under the Apache-2.0 license or a
            .execute()
import org.opensearch.common.geo.builders.EnvelopeBuilder;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertSearchResponse(response);  
import static org.hamcrest.Matchers.equalTo;
            "test-idx",
        index(  
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) 1));  
            .execute()
                .endObject()
 * Unless required by applicable law or agreed to in writing,
                .field("type", FakeStringFieldMapper.CONTENT_TYPE)  
 * compatible open source license.
    @Override
            .highlighter(new HighlightBuilder().field("*").field("field"))  
                .endObject()  
        response = client().prepareSearch("test-idx")
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
        response = client().prepareSearch("test-idx").setPostFilter(QueryBuilders.termQuery("field.field", "foo")).execute().actionGet();
 * software distributed under the License is distributed on an
        return Collections.singletonList(ExternalMapperPlugin.class);  
        assertThat(response.getHits().getAt(0).getHighlightFields().size(), equalTo(1));
