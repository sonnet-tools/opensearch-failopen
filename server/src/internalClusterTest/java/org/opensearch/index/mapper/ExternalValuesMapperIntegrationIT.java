 * software distributed under the License is distributed on an
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
 *
            "test-idx",
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.xcontent.XContentFactory;
            XContentFactory.jsonBuilder().startObject().field("field", "Every day is exactly the same").endObject()
import org.opensearch.common.geo.builders.EnvelopeBuilder;
                .endObject()
 * GitHub history for details.
    public void testExternalValues() throws Exception {
                .startObject("properties")
                    .relation(ShapeRelation.WITHIN)
        );
        assertSearchResponse(response);
            .setQuery(QueryBuilders.matchQuery("field", "exactly the same"))
        response = client().prepareSearch("test-idx")
            equalTo("Every day is " + "<em>exactly</em> <em>the</em> <em>same</em>")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            response.getHits().getAt(0).getHighlightFields().get("field").fragments()[0].string(),
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
            .highlighter(new HighlightBuilder().field("field"))
        // test if the highlighting is excluded when we use wildcards
        prepareCreate("test-idx").setMapping(
    public void testExternalValuesWithMultifield() throws Exception {
 * Unless required by applicable law or agreed to in writing,
        response = client().prepareSearch("test-idx")
            .execute()
import org.opensearch.common.geo.ShapeRelation;
import java.util.Collection;
public class ExternalValuesMapperIntegrationIT extends OpenSearchIntegTestCase {
            .execute()
import org.opensearch.plugins.Plugin;
package org.opensearch.index.mapper;
 * under the License.
 * this work for additional information regarding copyright
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) 1));
import org.locationtech.jts.geom.Coordinate;
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
                .endObject()
                .startObject("raw")
            equalTo("Every day is " + "<em>exactly</em> <em>the</em> <em>same</em>")
            XContentFactory.jsonBuilder()
                QueryBuilders.geoShapeQuery("field.shape", new EnvelopeBuilder(new Coordinate(-101, 46), new Coordinate(-99, 44)))
import org.opensearch.action.search.SearchResponse;
 * ownership. Elasticsearch licenses this file to you under
        assertThat(response.getHits().getAt(0).getHighlightFields().size(), equalTo(1));
        response = client().prepareSearch("test-idx")
            .setPostFilter(QueryBuilders.geoDistanceQuery("field.point").point(42.0, 51.0).distance("1km"))
                .endObject()
        prepareCreate("test-idx").setMapping(
        refresh();
 * SPDX-License-Identifier: Apache-2.0
        index("test-idx", "type", "1", XContentFactory.jsonBuilder().startObject().field("field", "1234").endObject());
 */
                .field("store", true)
 *
                .startObject("fields")
    public void testHighlightingOnCustomString() throws Exception {
        ).execute().get();
                .startObject("f")
        // make sure it is not excluded when we explicitly provide the fieldname and a wildcard
            .actionGet();
            .execute()
            .setPostFilter(
 */
                .startObject()
 * Licensed to Elasticsearch under one or more contributor
        index(
            .highlighter(new HighlightBuilder().field("*").field("field"))
                .endObject()
            .setQuery(QueryBuilders.matchQuery("field", "exactly the same"))
import org.opensearch.index.query.QueryBuilders;
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) 1));
import static org.hamcrest.Matchers.equalTo;
                .startObject(ExternalMetadataMapper.CONTENT_TYPE)
        response = client().prepareSearch("test-idx").setPostFilter(QueryBuilders.termQuery("field.bool", "true")).execute().actionGet();
                .endObject()
            .execute()
                .field("type", ExternalMapperPlugin.EXTERNAL_UPPER)
                .startObject()
        assertThat(
            .actionGet();
}
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(
    @Override
                .field("type", "keyword")
        );
                .field("type", ExternalMapperPlugin.EXTERNAL)
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) 1));
                .endObject()
                .endObject()
            XContentFactory.jsonBuilder()
import java.util.Collections;
                .endObject()
                .startObject("fields")
 * The OpenSearch Contributors require contributions made to
        return Collections.singletonList(ExternalMapperPlugin.class);
            XContentFactory.jsonBuilder()
 *
    }
            .actionGet();
            .actionGet();
 * KIND, either express or implied.  See the License for the
                .endObject()
                .endObject()
            response.getHits().getAt(0).getHighlightFields().get("field").fragments()[0].string(),
            .execute()
            .actionGet();
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        // make sure it is not excluded when we explicitly provide the fieldname
            .setQuery(QueryBuilders.matchQuery("field", "exactly the same"))
                .endObject()
    }
            )
                .startObject("field")
                .startObject()
 * specific language governing permissions and limitations
        refresh();
        response = client().prepareSearch("test-idx")
            "1",
                .endObject()
                .startObject("g")
                .startObject("properties")
                .startObject("properties")
 * license agreements. See the NOTICE file distributed with
        prepareCreate("test-idx").setMapping(
                .field("store", true)
 * compatible open source license.
        assertThat(response.getHits().getAt(0).getHighlightFields().size(), equalTo(1));
        );
 * You may obtain a copy of the License at
        assertSearchResponse(response);
                .endObject()
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
 * not use this file except in compliance with the License.
/*
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        response = client().prepareSearch("test-idx")
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) 1));
 */
                .field("type", "text")
            .setQuery(QueryBuilders.termQuery("f.g.raw", "FOO BAR"))
        assertThat(response.getHits().getAt(0).getHighlightFields().size(), equalTo(0));
        ).execute().get();
        refresh();
 * this file be licensed under the Apache-2.0 license or a
        index("test-idx", "_doc", "1", "f", "This is my text");
        assertSearchResponse(response);
/*
        ).execute().get();
/*
        response = client().prepareSearch("test-idx").setPostFilter(QueryBuilders.termQuery("field.field", "foo")).execute().actionGet();
            .actionGet();
        SearchResponse response = client().prepareSearch("test-idx")
            .execute()
        SearchResponse response;
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) 1));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .highlighter(new HighlightBuilder().field("*"))
            "type",
                .field("type", FakeStringFieldMapper.CONTENT_TYPE)
        SearchResponse response;
                .startObject("field")
                .endObject()
