    abstract GeoShapeQueryBuilder doCreateTestQueryBuilder(boolean indexedShape);
        assertThat(query, instanceOf(GeoShapeQueryBuilder.class));
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.ConstantScoreQuery;
    }
        assertThat(query, anyOf(instanceOf(BooleanQuery.class), instanceOf(ConstantScoreQuery.class)));
    public void testMustRewrite() throws IOException {
    // see #3878
            builder.field(expectedShapePath, indexedShapeToReturn);
        assertThat(getRequest.routing(), equalTo(indexedShapeRouting));
    }
    }
        QueryBuilder builder = new BoolQueryBuilder().should(shape).should(shape);
        }
    protected QueryBuilder parseQuery(XContentParser parser) throws IOException {
 *
        geoShapeQueryBuilder.relation(query.relation());
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
import org.opensearch.OpenSearchException;
 *
        QueryBuilder rewrite = rewriteAndFetch(query, createShardContext());
        assertThat(getRequest.id(), equalTo(indexedShapeId));
import static org.hamcrest.CoreMatchers.notNullValue;
    }
import static org.hamcrest.Matchers.anyOf;
            + "    \"location\" : {\n"
            + "        \"coordinates\" : [ [ 13.0, 53.0 ], [ 14.0, 52.0 ] ]\n"
        failingQueryBuilder.ignoreUnmapped(false);
package org.opensearch.index.query;
            XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
import org.opensearch.test.VersionUtils;
        indexedShapeIndex = null;
        Query query = queryBuilder.toQuery(createShardContext());
            ? new GeoShapeQueryBuilder(fieldName(), indexedShapeToReturn)
import org.opensearch.core.xcontent.XContentParser;
    protected static String indexedShapeId;
    public void testIgnoreUnmapped() throws IOException {
 *
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new GeoShapeQueryBuilder(fieldName(), null, null));
        assertThat(getRequest.index(), equalTo(expectedShapeIndex));
    }
/*
import org.opensearch.Version;
        assertEquals("query must be rewritten first", e.getMessage());
        GeoShapeQueryBuilder query = doCreateTestQueryBuilder(true);
        } catch (IOException ex) {
    protected Settings createTestIndexSettings() {
            : new GeoShapeQueryBuilder("unmapped", shape.buildGeometry());
        geoShapeQueryBuilder.strategy(query.strategy());
        IllegalStateException ise = expectThrows(IllegalStateException.class, () -> queryBuilder.writeTo(new BytesStreamOutput(10)));
import static org.hamcrest.Matchers.containsString;
        ShapeBuilder<?, ?, ?> shape = RandomShapeGenerator.createShapeWithin(random(), null);
        String expectedShapeIndex = indexedShapeIndex == null ? GeoShapeQueryBuilder.DEFAULT_SHAPE_INDEX_NAME : indexedShapeIndex;
    }
    public void testWrongFieldType() throws IOException {
import org.apache.lucene.search.Query;
    @Override
 * Licensed to Elasticsearch under one or more contributor
    public void testFromJson() throws IOException {
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
        UnsupportedOperationException e = expectThrows(UnsupportedOperationException.class, () -> query.toQuery(createShardContext()));
            + "        \"type\" : \"Envelope\",\n"
            : new GeoShapeQueryBuilder(fieldName(), indexedShapeToReturn.buildGeometry());
        GeoShapeQueryBuilder expectedShape = randomBoolean()
    @Override
 * specific language governing permissions and limitations
            ? new GeoShapeQueryBuilder("unmapped", shape)
        String expectedShapePath = indexedShapePath == null ? GeoShapeQueryBuilder.DEFAULT_SHAPE_FIELD_NAME : indexedShapePath;
    }
        // Logic for doToQuery is complex and is hard to test here. Need to rely
        assertEquals(ise.getMessage(), "supplier must be null, can't serialize suppliers, missing a rewriteAndFetch?");
 * compatible open source license.
 * software distributed under the License is distributed on an
        ShapeBuilder<?, ?, ?> shape = RandomShapeGenerator.createShapeWithin(random(), null, shapeType);
    public void testNoRelation() throws IOException {
import java.io.IOException;
    }
        expectedShape.relation(shape.relation());
        assertEquals("No Shape Relation defined", e.getMessage());
    @Override
        // easier to test here
 */
            throw new OpenSearchException("boom", ex);
 * Modifications Copyright OpenSearch Contributors. See
        try {
            + "      \"shape\" : {\n"
import org.opensearch.index.get.GetResult;
import org.opensearch.action.get.GetRequest;
        expectedShape.strategy(shape.strategy());
            ? QueryBuilders.geoShapeQuery("searchGeometry", envelopeBuilder)
    @Override
 * Unless required by applicable law or agreed to in writing,
    protected GetResponse executeGet(GetRequest getRequest) {
 * The OpenSearch Contributors require contributions made to
            : new GeoShapeQueryBuilder(TEXT_FIELD_NAME, shape.buildGeometry());
import static org.hamcrest.CoreMatchers.instanceOf;
        JsonXContent.contentBuilder().startArray().value(geoQuery).endArray();
        assertThat(e.getMessage(), containsString("Field [mapped_string] is of unsupported type [text] for [geo_shape] query"));
            builder.startObject();
 * You may obtain a copy of the License at
 */
import org.locationtech.jts.geom.Coordinate;
        GeoShapeQueryBuilder shape = doCreateTestQueryBuilder(true);
        assertThat(indexedShapeId, notNullValue());
        indexedShapePath = null;
            builder.endObject();
import org.opensearch.action.get.GetResponse;
    public void testNoFieldName() throws Exception {
        QueryBuilder queryBuilder = Rewriteable.rewrite(builder, createShardContext());
        final GeoShapeQueryBuilder queryBuilder = randomBoolean()
        final GeoShapeQueryBuilder queryBuilder = randomBoolean()
    }
import org.opensearch.common.xcontent.XContentFactory;
        assertEquals(json, 42.0, parsed.boost(), 0.0001);
        expectThrows(IllegalArgumentException.class, () -> new GeoShapeQueryBuilder(fieldName(), (ShapeBuilder) null));
    protected void doAssertLuceneQuery(GeoShapeQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            + "    \"ignore_unmapped\" : false,\n"
import org.opensearch.common.geo.builders.EnvelopeBuilder;
    }
    public void clearShapeFields() {
        indexedShapeRouting = null;
            + "    \"boost\" : 42.0\n"
        GeoShapeQueryBuilder builder = new GeoShapeQueryBuilder(fieldName(), shape);
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder(new Coordinate(0, 10), new Coordinate(10, 0));
        QueryShardException e = expectThrows(QueryShardException.class, () -> queryBuilder.toQuery(createShardContext()));
import org.opensearch.core.xcontent.XContentBuilder;
    }
import org.opensearch.core.common.bytes.BytesArray;
        builder.writeTo(new BytesStreamOutput(10));
        return Settings.builder().put(super.createTestIndexSettings()).put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
    protected GeoShapeQueryBuilder doCreateTestQueryBuilder() {
        String json = "{\n"
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
import org.apache.lucene.search.BooleanQuery;
import org.opensearch.common.xcontent.json.JsonXContent;
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under
    public void testNoIndexedShape() throws IOException {
        // force the new shape impl
        ShapeBuilder<?, ?, ?> shape = RandomShapeGenerator.createShapeWithin(random(), null, shapeType);
    @After
        final GeoShapeQueryBuilder failingQueryBuilder = randomBoolean()
    }
        indexedShapeId = null;
import org.apache.lucene.search.MatchNoDocsQuery;
    public void testNoShape() throws IOException {
import org.opensearch.test.geo.RandomShapeGenerator;
        QueryBuilder query = super.parseQuery(parser);
            : new GeoShapeQueryBuilder("unmapped", shape.buildGeometry());
    protected static ShapeBuilder<?, ?, ?> indexedShapeToReturn;
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.equalTo;
        return doCreateTestQueryBuilder(randomBoolean());
    public void testSerializationFailsUnlessFetched() throws IOException {
            ? new GeoShapeQueryBuilder(TEXT_FIELD_NAME, shape)
        queryBuilder.ignoreUnmapped(true);
        String json;
            : QueryBuilders.geoShapeQuery("searchGeometry", envelopeBuilder.buildGeometry());
    }
            + "      \"relation\" : \"intersects\"\n"
        ShapeBuilder<?, ?, ?> shape = RandomShapeGenerator.createShapeWithin(random(), null);
    protected static String indexedShapeIndex;
}
        // on Integration tests to determine if created query is correct
        return query;
        QueryShardException e = expectThrows(QueryShardException.class, () -> failingQueryBuilder.toQuery(createShardContext()));
            + "    },\n"
            : new GeoShapeQueryBuilder(fieldName(), indexedShapeToReturn.buildGeometry());
    @Override
import org.opensearch.common.geo.builders.ShapeBuilder;
        return new GetResponse(new GetResult(indexedShapeIndex, indexedShapeId, 0, 1, 0, true, new BytesArray(json), null, null));
 * this file be licensed under the Apache-2.0 license or a
    public void testThatXContentSerializationInsideOfArrayWorks() throws Exception {
        assertThat(query, notNullValue());
        assertEquals("either shape or indexedShapeId is required", e.getMessage());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
/*
import org.opensearch.test.AbstractQueryTestCase;
public abstract class GeoShapeQueryBuilderTests extends AbstractQueryTestCase<GeoShapeQueryBuilder> {
    public void testMultipleRewrite() throws IOException {
    @Override
    protected static String indexedShapeRouting;
        ShapeType shapeType = ShapeType.randomType(random());
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new GeoShapeQueryBuilder(null, shape));
    }
        assertThat(e.getMessage(), containsString("failed to find type for field [unmapped]"));
import org.opensearch.cluster.metadata.IndexMetadata;
        GeoShapeQueryBuilder geoQuery = randomBoolean()
 * under the License.
import org.opensearch.test.geo.RandomShapeGenerator.ShapeType;
        ShapeType shapeType = ShapeType.randomType(random());
        QueryBuilder expected = new BoolQueryBuilder().should(expectedShape).should(expectedShape);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder.relation(null));
 * KIND, either express or implied.  See the License for the
            + "      },\n"
    protected static String indexedShapePath;
        QueryBuilder builder = doCreateTestQueryBuilder(true);
    protected abstract String fieldName();
            + "  \"geo_shape\" : {\n"
        GeoShapeQueryBuilder parsed = (GeoShapeQueryBuilder) parseQuery(json);
            builder.field(randomAlphaOfLengthBetween(10, 20), "something");
        // TODO improve GeoShapeQueryBuilder.doToQuery() method to make it
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
            + "}";
        checkGeneratedJson(json, parsed);
        assertEquals(expected, builder);
    }
        GeoShapeQueryBuilder geoShapeQueryBuilder = randomBoolean()
            json = builder.toString();
        assertEquals(geoShapeQueryBuilder, rewrite);
import org.opensearch.common.settings.Settings;
        builder = rewriteAndFetch(builder, createShardContext());
            + "  }\n"
        assertThat(indexedShapeToReturn, notNullValue());
import org.opensearch.common.io.stream.BytesStreamOutput;
/*
import org.junit.After;
        builder = rewriteAndFetch(builder, createShardContext());
        indexedShapeToReturn = null;
        assertEquals("fieldName is required", e.getMessage());
    }
            ? new GeoShapeQueryBuilder("unmapped", shape)
            ? new GeoShapeQueryBuilder(fieldName(), indexedShapeToReturn)
