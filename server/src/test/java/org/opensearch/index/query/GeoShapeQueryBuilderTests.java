        assertThat(query, instanceOf(GeoShapeQueryBuilder.class));  
    }  
        JsonXContent.contentBuilder().startArray().value(geoQuery).endArray();  
import org.apache.lucene.search.ConstantScoreQuery;
    }  
        checkGeneratedJson(json, parsed);  
    public void testWrongFieldType() throws IOException {
import org.apache.lucene.search.BooleanQuery;  
        indexedShapePath = null;  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.MatchNoDocsQuery;
    protected GeoShapeQueryBuilder doCreateTestQueryBuilder() {
 */
import org.opensearch.common.geo.builders.EnvelopeBuilder;  
            : QueryBuilders.geoShapeQuery("searchGeometry", envelopeBuilder.buildGeometry());
        indexedShapeRouting = null;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentParser;
            : new GeoShapeQueryBuilder(fieldName(), indexedShapeToReturn.buildGeometry());  
 *  
import org.opensearch.action.get.GetRequest;  
        }
        assertThat(getRequest.index(), equalTo(expectedShapeIndex));  
    }
            + "    \"ignore_unmapped\" : false,\n"
import org.locationtech.jts.geom.Coordinate;  
        try {
        // easier to test here
    }
        assertThat(e.getMessage(), containsString("Field [mapped_string] is of unsupported type [text] for [geo_shape] query"));  
    public void testNoIndexedShape() throws IOException {  
    }
 * this work for additional information regarding copyright
        return doCreateTestQueryBuilder(randomBoolean());  
        geoShapeQueryBuilder.strategy(query.strategy());
    }
    }
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder(new Coordinate(0, 10), new Coordinate(10, 0));
    public void testMultipleRewrite() throws IOException {
import org.opensearch.action.get.GetResponse;
            : new GeoShapeQueryBuilder(fieldName(), indexedShapeToReturn.buildGeometry());
        assertThat(query, notNullValue());  
    public void testNoRelation() throws IOException {
        String json;  
        ShapeType shapeType = ShapeType.randomType(random());  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder.relation(null));
    }
            ? new GeoShapeQueryBuilder(fieldName(), indexedShapeToReturn)
            + "    \"location\" : {\n"  
        builder.writeTo(new BytesStreamOutput(10));  
        assertThat(query, anyOf(instanceOf(BooleanQuery.class), instanceOf(ConstantScoreQuery.class)));
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
        assertThat(getRequest.id(), equalTo(indexedShapeId));  
        indexedShapeIndex = null;
    // see #3878  
    protected static String indexedShapeRouting;
            + "  }\n"  
        assertThat(indexedShapeToReturn, notNullValue());
import static org.hamcrest.Matchers.anyOf;
 */  
        assertEquals(geoShapeQueryBuilder, rewrite);
import org.opensearch.common.xcontent.XContentFactory;
        GeoShapeQueryBuilder query = doCreateTestQueryBuilder(true);  
        assertEquals(expected, builder);
        // TODO improve GeoShapeQueryBuilder.doToQuery() method to make it  
            ? new GeoShapeQueryBuilder(TEXT_FIELD_NAME, shape)  
import static org.hamcrest.CoreMatchers.instanceOf;
 * You may obtain a copy of the License at  
            + "        \"coordinates\" : [ [ 13.0, 53.0 ], [ 14.0, 52.0 ] ]\n"  
    @Override
    public void testNoShape() throws IOException {
        final GeoShapeQueryBuilder queryBuilder = randomBoolean()
            throw new OpenSearchException("boom", ex);  
 * under the License.  
            : new GeoShapeQueryBuilder("unmapped", shape.buildGeometry());
        expectedShape.relation(shape.relation());
    }  
        GeoShapeQueryBuilder geoShapeQueryBuilder = randomBoolean()
        QueryBuilder queryBuilder = Rewriteable.rewrite(builder, createShardContext());
        assertEquals(ise.getMessage(), "supplier must be null, can't serialize suppliers, missing a rewriteAndFetch?");
        String expectedShapePath = indexedShapePath == null ? GeoShapeQueryBuilder.DEFAULT_SHAPE_FIELD_NAME : indexedShapePath;
    @Override
    }
        QueryBuilder builder = new BoolQueryBuilder().should(shape).should(shape);  
        QueryBuilder query = super.parseQuery(parser);
        ShapeType shapeType = ShapeType.randomType(random());
        // force the new shape impl
        Version version = VersionUtils.randomIndexCompatibleVersion(random());  
import static org.hamcrest.Matchers.equalTo;  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new GeoShapeQueryBuilder(fieldName(), null, null));
    protected abstract String fieldName();
        } catch (IOException ex) {
        indexedShapeId = null;
            builder.endObject();  
        final GeoShapeQueryBuilder failingQueryBuilder = randomBoolean()  
            json = builder.toString();
import org.opensearch.OpenSearchException;
    protected static String indexedShapeId;
import org.opensearch.test.geo.RandomShapeGenerator;  
import org.opensearch.core.xcontent.XContentBuilder;
    abstract GeoShapeQueryBuilder doCreateTestQueryBuilder(boolean indexedShape);  
            ? new GeoShapeQueryBuilder(fieldName(), indexedShapeToReturn)  
            XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
import org.opensearch.core.common.bytes.BytesArray;  
            + "}";
        GeoShapeQueryBuilder expectedShape = randomBoolean()
import org.opensearch.Version;
            builder.startObject();  
 * software distributed under the License is distributed on an
    protected static ShapeBuilder<?, ?, ?> indexedShapeToReturn;
        QueryBuilder expected = new BoolQueryBuilder().should(expectedShape).should(expectedShape);  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
            ? new GeoShapeQueryBuilder("unmapped", shape)
 * not use this file except in compliance with the License.
    }  
/*
    public void testThatXContentSerializationInsideOfArrayWorks() throws Exception {
        String expectedShapeIndex = indexedShapeIndex == null ? GeoShapeQueryBuilder.DEFAULT_SHAPE_INDEX_NAME : indexedShapeIndex;
    public void testMustRewrite() throws IOException {
    protected static String indexedShapePath;
        ShapeBuilder<?, ?, ?> shape = RandomShapeGenerator.createShapeWithin(random(), null);  
import org.opensearch.test.VersionUtils;
 * KIND, either express or implied.  See the License for the
        assertThat(e.getMessage(), containsString("failed to find type for field [unmapped]"));
        GeoShapeQueryBuilder shape = doCreateTestQueryBuilder(true);
        indexedShapeToReturn = null;
            ? new GeoShapeQueryBuilder("unmapped", shape)
package org.opensearch.index.query;
            + "  \"geo_shape\" : {\n"
/*  
        assertThat(indexedShapeId, notNullValue());
        QueryBuilder builder = doCreateTestQueryBuilder(true);
        ShapeBuilder<?, ?, ?> shape = RandomShapeGenerator.createShapeWithin(random(), null, shapeType);  
 * ownership. Elasticsearch licenses this file to you under  
    protected QueryBuilder parseQuery(XContentParser parser) throws IOException {
import org.opensearch.common.io.stream.BytesStreamOutput;
            + "      \"relation\" : \"intersects\"\n"
    }  
        assertEquals("No Shape Relation defined", e.getMessage());  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new GeoShapeQueryBuilder(null, shape));
import org.opensearch.test.AbstractQueryTestCase;
    public void testIgnoreUnmapped() throws IOException {
    public void testNoFieldName() throws Exception {
 *
    protected void doAssertLuceneQuery(GeoShapeQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
            : new GeoShapeQueryBuilder(TEXT_FIELD_NAME, shape.buildGeometry());
            + "    },\n"  
        failingQueryBuilder.ignoreUnmapped(false);  
        queryBuilder.ignoreUnmapped(true);
import org.opensearch.test.geo.RandomShapeGenerator.ShapeType;
    @Override  
            + "      \"shape\" : {\n"
    }
import org.junit.After;
        return query;
    public void testSerializationFailsUnlessFetched() throws IOException {  
}  
        assertEquals(json, 42.0, parsed.boost(), 0.0001);
import org.opensearch.common.geo.builders.ShapeBuilder;
        return Settings.builder().put(super.createTestIndexSettings()).put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
        builder = rewriteAndFetch(builder, createShardContext());
        String json = "{\n"
        assertEquals("query must be rewritten first", e.getMessage());  
        UnsupportedOperationException e = expectThrows(UnsupportedOperationException.class, () -> query.toQuery(createShardContext()));
import org.opensearch.cluster.metadata.IndexMetadata;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "        \"type\" : \"Envelope\",\n"
import org.opensearch.common.settings.Settings;  
 *
        // Logic for doToQuery is complex and is hard to test here. Need to rely
        ShapeBuilder<?, ?, ?> shape = RandomShapeGenerator.createShapeWithin(random(), null);  
public abstract class GeoShapeQueryBuilderTests extends AbstractQueryTestCase<GeoShapeQueryBuilder> {
        Query query = queryBuilder.toQuery(createShardContext());
            builder.field(expectedShapePath, indexedShapeToReturn);
    @Override
        GeoShapeQueryBuilder parsed = (GeoShapeQueryBuilder) parseQuery(json);
        assertEquals("either shape or indexedShapeId is required", e.getMessage());
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
    @Override
import org.opensearch.index.get.GetResult;  
    }  
    protected Settings createTestIndexSettings() {
    @Override  
            : new GeoShapeQueryBuilder("unmapped", shape.buildGeometry());  
import static org.hamcrest.CoreMatchers.notNullValue;  
        expectThrows(IllegalArgumentException.class, () -> new GeoShapeQueryBuilder(fieldName(), (ShapeBuilder) null));  
        QueryBuilder rewrite = rewriteAndFetch(query, createShardContext());
        assertEquals("fieldName is required", e.getMessage());
        QueryShardException e = expectThrows(QueryShardException.class, () -> queryBuilder.toQuery(createShardContext()));
        final GeoShapeQueryBuilder queryBuilder = randomBoolean()
    public void clearShapeFields() {  
    public void testFromJson() throws IOException {  
        // on Integration tests to determine if created query is correct
            ? QueryBuilders.geoShapeQuery("searchGeometry", envelopeBuilder)
        assertThat(getRequest.routing(), equalTo(indexedShapeRouting));
        expectedShape.strategy(shape.strategy());
            builder.field(randomAlphaOfLengthBetween(10, 20), "something");
            + "    \"boost\" : 42.0\n"
            + "      },\n"
    }
        ShapeBuilder<?, ?, ?> shape = RandomShapeGenerator.createShapeWithin(random(), null, shapeType);
        GeoShapeQueryBuilder geoQuery = randomBoolean()  
        GeoShapeQueryBuilder builder = new GeoShapeQueryBuilder(fieldName(), shape);
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.Query;  
 * GitHub history for details.
        IllegalStateException ise = expectThrows(IllegalStateException.class, () -> queryBuilder.writeTo(new BytesStreamOutput(10)));  
    protected static String indexedShapeIndex;  
/*
        geoShapeQueryBuilder.relation(query.relation());  
import static org.hamcrest.Matchers.containsString;
 * Modifications Copyright OpenSearch Contributors. See  
        builder = rewriteAndFetch(builder, createShardContext());
        return new GetResponse(new GetResult(indexedShapeIndex, indexedShapeId, 0, 1, 0, true, new BytesArray(json), null, null));
import org.opensearch.common.xcontent.json.JsonXContent;
    @After
        QueryShardException e = expectThrows(QueryShardException.class, () -> failingQueryBuilder.toQuery(createShardContext()));
    }
    }
    protected GetResponse executeGet(GetRequest getRequest) {  
