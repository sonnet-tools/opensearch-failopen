import org.opensearch.common.geo.ShapeRelation;
        assertFieldWarnings("tree", "strategy");
        fieldMapper = mapperService.documentMapper().mappers().getMapper("field");
            assertTrue(serialized, serialized.contains("\"tree_levels\":21"));
            assertEquals(ShapeBuilder.Orientation.RIGHT, gsfm.orientation());
            fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree").field("ignore_malformed", false))
            LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
 * ownership. Elasticsearch licenses this file to you under
    }
        assertThat(strategy.getGrid().getMaxLevels(), equalTo(GeoUtils.geoHashLevelsForPrecision(1d)));
import java.util.Set;
            b.startArray("field");
        );
 * Modifications Copyright OpenSearch Contributors. See
                        .field("tree_levels", "6")
            PrefixTreeStrategy strategy = geoShapeFieldMapper.fieldType().defaultPrefixTreeStrategy();
            PrefixTreeStrategy strategy = geoShapeFieldMapper.fieldType().defaultPrefixTreeStrategy();
        assertThat(strategy.getDistErrPct(), equalTo(0.1));
                    .field("distance_error_pct", 0.001)
            assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
        );
    }
            assertTrue(serialized, serialized.contains("\"tree_levels\":6"));
        assertThat(strategy, instanceOf(RecursivePrefixTreeStrategy.class));
        fieldMapper = mapper.mappers().getMapper("field");
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
        LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
        assertFieldWarnings("tree", "tree_levels", "precision", "distance_error_pct", "strategy");
    public void testLevelDefaults() throws IOException {
        assertThat(ignoreZValue, equalTo(true));
    @Override
                    .field("precision", "1m")
        assertThat(geoShapeFieldMapper.fieldType().orientation(), equalTo(ShapeBuilder.Orientation.CCW));
                        .field("points_only", false)
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.equalTo;
import org.apache.lucene.index.IndexableField;
                    b -> b.field("type", "geo_shape")
            );
    protected Collection<? extends Plugin> getPlugins() {
        boolean coerce = ((LegacyGeoShapeFieldMapper) fieldMapper).coerce().value();
        {
                    .field("strategy", "recursive")
        Explicit<Boolean> ignoreMalformed = ((LegacyGeoShapeFieldMapper) fieldMapper).ignoreMalformed();
            assertThat(strategy.getGrid().getMaxLevels(), equalTo(GeoUtils.geoHashLevelsForPrecision(50d)));
        assertFieldWarnings("tree", "tree_levels", "distance_error_pct", "points_only", "strategy");
                        .field("orientation", "cw")
                    .field("tree", "geohash")
            )
                b.startObject().field("type", "Point").startArray("coordinates").value(76.0).value(-15.0).endArray().endObject();
        assertFieldWarnings("tree", "precision", "strategy", "points_only");
        assertThat(strategy.isPointsOnly(), equalTo(true));
        assertFieldWarnings("tree", "precision", "strategy");
        b.field("type", "geo_shape").field("strategy", "recursive");
        {
    }
import org.opensearch.common.geo.SpatialStrategy;
            assertFalse(serialized, serialized.contains("\"precision\":"));
                        .field("strategy", "term")
            mapperService,
        assertThat(strategy.getGrid(), instanceOf(GeohashPrefixTree.class));
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
        });
            assertThat(strategy.getGrid().getMaxLevels(), equalTo(GeoUtils.geoHashLevelsForPrecision(70d)));
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.Explicit;
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
        strategy = geoShapeFieldMapper.fieldType().defaultPrefixTreeStrategy();
                        .field("tree", "geohash")
            DocumentMapper mapper = createDocumentMapper(
        DocumentMapper mapper = createDocumentMapper(
    public void testPointsOnlyOption() throws IOException {
        assertFieldWarnings("strategy");
            geoShapeFieldMapper.fieldType().distanceErrorPct(),
            );
            fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree").field("ignore_z_value", false))
        // TODO - distance_error_pct ends up being subsumed into a calculated value, how to test
        }
        assertFieldWarnings("tree", "strategy");
    }
                    .field("tree_levels", 8)
        assertThat(geoShapeFieldMapper.fieldType().orientation(), equalTo(ShapeBuilder.Orientation.CCW));
            assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
     */
        assertFieldWarnings("tree", "distance_error_pct", "strategy");
        orientation = ((LegacyGeoShapeFieldMapper) fieldMapper).fieldType().orientation();
        LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
        coerce = ((LegacyGeoShapeFieldMapper) fieldMapper).coerce().value();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree")));
                )
        );
    }
    public void testCoerceParsing() throws IOException {
            )
            PrefixTreeStrategy strategy = geoShapeFieldMapper.fieldType().defaultPrefixTreeStrategy();
import org.apache.lucene.spatial.prefix.PrefixTreeStrategy;
        LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
            fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree").field("orientation", "right"))
            b.field("strategy", "term");
 * this file be licensed under the Apache-2.0 license or a
        assertParseMinimalWarnings();
    public void testDefaultConfiguration() throws IOException {
        geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
                fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree").field("precision", "6m").field("tree_levels", "5"))
        ToXContent.Params includeDefaults = new ToXContent.MapParams(singletonMap("include_defaults", "true"));
            "Field parameter [tree] is deprecated and will be removed in a future version.",
        checker.registerConflictCheck("strategy", fieldMapping(this::minimalMapping), fieldMapping(b -> {
            LegacyGeoShapeFieldMapper gpfm = (LegacyGeoShapeFieldMapper) m;
        {
    }
 */
    @Override
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
        assertFieldWarnings("tree", "tree_levels", "distance_error_pct", "strategy");
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
        // explicit false coerce test
package org.opensearch.index.mapper;
            assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
                fieldMapping(
import java.util.List;
    public void testGeoShapeArrayParsing() throws Exception {
            PrefixTreeStrategy strategy = geoShapeFieldMapper.fieldType().defaultPrefixTreeStrategy();
import static org.mockito.Mockito.mock;
        Exception e = expectThrows(
        );
        // explicit false ignore_malformed test
    }
            equalTo(LegacyGeoShapeFieldMapper.DeprecatedParameters.Defaults.POINTS_ONLY)
            assertThat(strategy.getDistErrPct(), equalTo(0.5));
                        .field("precision", "70m")
                        .field("tree", "geohash")
        mapper = createDocumentMapper(
        Exception e = expectThrows(
        DocumentMapper mapper = createDocumentMapper(
 * Licensed to Elasticsearch under one or more contributor
            () -> geoShapeFieldMapper.fieldType()
                fieldMapping(
        assertThat(fields.length, equalTo(2));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertTrue(serialized, serialized.contains("\"tree_levels\":9"));
        assertThat(
        });
            Mapper fieldMapper = mapper.mappers().getMapper("field");
            String serialized = Strings.toString(MediaTypeRegistry.JSON, mapper.mappers().getMapper("field"), includeDefaults);
        LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
        ignoreMalformed = ((LegacyGeoShapeFieldMapper) fieldMapper).ignoreMalformed();
import org.apache.lucene.spatial.prefix.tree.QuadPrefixTree;
        ShapeBuilder.Orientation orientation = ((LegacyGeoShapeFieldMapper) fieldMapper).fieldType().orientation();
        PrefixTreeStrategy strategy = geoShapeFieldMapper.fieldType().defaultPrefixTreeStrategy();
        checker.registerUpdateCheck(b -> b.field("ignore_malformed", true), m -> {
    protected void assertSerializationWarnings() {
import org.opensearch.geometry.Point;
        checker.registerUpdateCheck(b -> b.field("distance_error_pct", 0.8), m -> {});
            assertThat(strategy.getGrid(), instanceOf(QuadPrefixTree.class));
 * KIND, either express or implied.  See the License for the
        PrefixTreeStrategy strategy = geoShapeFieldMapper.fieldType().defaultPrefixTreeStrategy();
        DocumentMapper mapper = createDocumentMapper(mapping);
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.RIGHT));
            fieldMapping(
                    .field("distance_error_pct", 0.01)
                        .field("precision", "70m")
            DocumentMapper mapper = createDocumentMapper(
                fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree").field("distance_error_pct", "0.5"))
 * license agreements. See the NOTICE file distributed with
        }
        LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
    }
    @Override
import java.util.Collection;
    }
        assertThat(Strings.toString(MediaTypeRegistry.JSON, geoShapeFieldMapper), not(containsString("points_only")));
import org.apache.lucene.spatial.prefix.RecursivePrefixTreeStrategy;
                fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree").field("tree_levels", "6"))
        {
            DocumentMapper mapper = createDocumentMapper(
    public void testDisallowExpensiveQueries() throws IOException {
                fieldMapping(
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
    }
            assertTrue(serialized, serialized.contains("\"precision\":\"6.0m\""));
    @Override
     */
        builder.value("POINT (14.0 15.0)");
 * compatible open source license.
            "Field parameter [precision] is deprecated and will be removed in a future version.",
 */
    @Override
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CCW));
        PrefixTreeStrategy strategy = geoShapeFieldMapper.fieldType().defaultPrefixTreeStrategy();
import java.io.IOException;
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
                b -> b.field("type", "geo_shape")
            assertThat(strategy.getGrid().getMaxLevels(), equalTo(GeoUtils.quadTreeLevelsForPrecision(70d) + 1));
            assertThat(strategy.getGrid(), instanceOf(QuadPrefixTree.class));
        ignoreZValue = ((LegacyGeoShapeFieldMapper) fieldMapper).ignoreZValue().value();
import org.opensearch.OpenSearchException;
/*
    @Override
     * Test that ignore_malformed parameter correctly parses
        mapper = createDocumentMapper(
    }
            assertFalse(serialized, serialized.contains("\"tree_levels\":"));
    }
        fieldMapper = mapper.mappers().getMapper("field");
        assertThat(e.getMessage(), containsString("mapper [field] has different [tree_levels]"));
        {
            {
    }
            DocumentMapper mapper = createDocumentMapper(
                mapperService,
            assertThat(strategy.getDistErrPct(), equalTo(0.5));
        {
        IndexableField[] fields = document.docs().get(0).getFields("field");
    /**
        assertThat(strategy.getGrid(), instanceOf(QuadPrefixTree.class));
        }));
                        .field("tree", "quadtree")
        OpenSearchException e = expectThrows(
            LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
        );
        checker.registerUpdateCheck(b -> b.field("orientation", "right"), m -> {
        );
        );
        String[] warnings = new String[fieldNames.length];
                )
            DocumentMapper mapper = createDocumentMapper(
        return false;
            assertTrue(gpfm.ignoreMalformed.value());
        }
        assertThat(e.getMessage(), containsString("mapper [field] has different [tree]"));
    }
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        DocumentMapper mapper = createDocumentMapper(
        });
                )
        DocumentMapper mapper = createDocumentMapper(
        Mapper fieldMapper = mapper.mappers().getMapper("field");
                        .field("tree_levels", GeoUtils.geoHashLevelsForPrecision(70d) + 1)
        );
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
        assertWarnings(
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
import static java.util.Collections.singletonMap;
        }
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
        MapperService mapperService = createMapperService(
                b -> b.field("type", "geo_shape")
        assertThat(
    protected void registerParameters(ParameterChecker checker) throws IOException {
        assertThat(geoShapeFieldMapper.fieldType().orientation(), equalTo(LegacyGeoShapeFieldMapper.Defaults.ORIENTATION.value()));
            fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree").field("coerce", true))
        assertThat(coerce, equalTo(true));
        // term strategy changes the default for points_only, check that we handle it correctly
        assertThat(strategy.getDistErrPct(), equalTo(0.5));
        assertThat(strategy.getGrid(), instanceOf(QuadPrefixTree.class));
    }
            )
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertEquals(
        return false;
                        .field("tree_levels", "6")
        PrefixTreeStrategy strategy = geoShapeFieldMapper.fieldType().defaultPrefixTreeStrategy();
                    .field("orientation", "cw")
                    .field("strategy", "recursive")
    private void assertFieldWarnings(String... fieldNames) {
            );
            );
            PrefixTreeStrategy strategy = geoShapeFieldMapper.fieldType().defaultPrefixTreeStrategy();
    }
    protected Set<String> unsupportedProperties() {
        Mapper fieldMapper = mapper.mappers().getMapper("field");
        }
        }));
            String serialized = Strings.toString(MediaTypeRegistry.JSON, mapper.mappers().getMapper("field"), includeDefaults);
    protected boolean supportsMeta() {
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
            // 70m is more precise so it wins
 *
        DocumentMapper mapper = createDocumentMapper(
                    .field("points_only", true)
        }
        assertThat(strategy.getGrid().getMaxLevels(), equalTo(6));
        }
        Mapper fieldMapper = mapper.mappers().getMapper("field");
            fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree").field("ignore_malformed", true))
        {
    /**
        assertThat(e.getMessage(), containsString("points_only cannot be set to false for term strategy"));
            LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
            DocumentMapper mapper = createDocumentMapper(
        }
                    .field("precision", "1m")
        assertThat(ignoreMalformed.value(), equalTo(false));
 * not use this file except in compliance with the License.
                    b -> b.field("type", "geo_shape")
        checker.registerUpdateCheck(b -> b.field("ignore_z_value", false), m -> {
            assertTrue(gpfm.coerce.value());
        // correct mapping
            assertThat(strategy.getGrid(), instanceOf(QuadPrefixTree.class));
        assertThat(strategy.getDistErrPct(), equalTo(0.001));
                        .field("tree", "quadtree")
            String serialized = Strings.toString(MediaTypeRegistry.JSON, mapper.mappers().getMapper("field"), includeDefaults);
        fieldMapper = mapper.mappers().getMapper("field");
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree").field("coerce", false)));
            fieldMapping(
            "[geo-shape] queries on [PrefixTree geo shapes] cannot be executed when " + "'search.allow_expensive_queries' is set to false.",
import org.opensearch.core.common.Strings;
            // 70m is less precise so it loses
            DocumentMapper mapper = createDocumentMapper(
            assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
    public void testIgnoreMalformedParsing() throws IOException {
            "Field parameter [strategy] is deprecated and will be removed in a future version.",
            warnings[i] = "Field parameter [" + fieldNames[i] + "] " + "is deprecated and will be removed in a future version.";
        );
 * under the License.
            assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
    }
        {
                        .field("distance_error_pct", "0.5")
            String serialized = Strings.toString(MediaTypeRegistry.JSON, mapper.mappers().getMapper("field"), includeDefaults);
                )
        assertThat(strategy.getGrid(), instanceOf(GeohashPrefixTree.class));
    public void testGeohashConfiguration() throws IOException {
            Mapper fieldMapper = mapper.mappers().getMapper("field");
        checker.registerConflictCheck("tree_levels", b -> b.field("tree_levels", 5));
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
    protected void assertParseMinimalWarnings() {
                fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree").field("precision", "6"))
 * SPDX-License-Identifier: Apache-2.0
     * Test that accept_z_value parameter correctly parses
        );
                        .field("distance_error_pct", 26)
        assertThat(strategy.getGrid().getMaxLevels(), equalTo(23));
    public void testPointsOnlyFalseWithTermStrategy() throws Exception {
    @Override
        assertFieldWarnings("tree", "tree_levels", "precision", "strategy");
                    .field("tree_levels", "6")
        assertThat(ignoreMalformed.value(), equalTo(true));
                b -> b.field("type", "geo_shape")
                b.startObject().field("type", "Point").startArray("coordinates").value(176.0).value(15.0).endArray().endObject();
                )
            assertThat(strategy.getDistErrPct(), equalTo(0.0));
        Mapper fieldMapper = mapper.mappers().getMapper("field");
import static org.mockito.Mockito.when;
import org.opensearch.common.geo.GeoUtils;
import static org.hamcrest.Matchers.instanceOf;
        return new LegacyGeoShapeFieldMapper.Builder("geoshape");
 * The OpenSearch Contributors require contributions made to
            assertThat(strategy.getGrid(), instanceOf(QuadPrefixTree.class));
        checker.registerUpdateCheck(b -> b.field("coerce", true), m -> {
            Mapper fieldMapper = mapper.mappers().getMapper("field");
        assertThat(document.docs(), hasSize(1));
    }
            geoShapeFieldMapper.fieldType().pointsOnly(),
            fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree").field("orientation", "left"))
                        .field("strategy", "term")
    public void testSerializeDefaults() throws Exception {
            assertTrue(serialized, serialized.contains("\"precision\":\"50.0m\""));
        );
        Mapper fieldMapper = mapper.mappers().getMapper("field");
    }
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
            }
        Mapper fieldMapper = mapper.mappers().getMapper("field");
 * software distributed under the License is distributed on an
    @Override
        {
 * specific language governing permissions and limitations
    public void testGeoShapeMapperMerge() throws Exception {
                    b -> b.field("type", "geo_shape").field("tree", "quadtree").field("tree_levels", "26").field("precision", "70m")
    protected void assertParseMaximalWarnings() {
        XContentBuilder mapping = fieldMapping(this::minimalMapping);
            );
        LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
        );
    protected void minimalMapping(XContentBuilder b) throws IOException {
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);
                fieldMapping(
        assertThat(strategy.isPointsOnly(), equalTo(true));
            assertThat(strategy.getGrid(), instanceOf(GeohashPrefixTree.class));
            b.endArray();
        DocumentMapper mapper = createDocumentMapper(
public class LegacyGeoShapeFieldMapperTests extends FieldMapperTestCase2<LegacyGeoShapeFieldMapper.Builder> {
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.LEFT));
            DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_shape").field("tree", "geohash")));
            e.getMessage()
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
                        .field("tree", "quadtree")
            assertThat(strategy.getGrid(), instanceOf(GeohashPrefixTree.class));
            () -> createMapperService(
                )
                        .field("precision", "70m")
            Mapper fieldMapper = mapper.mappers().getMapper("field");
            DocumentMapper mapper = createDocumentMapper(
            "Field parameter [distance_error_pct] is deprecated and will be removed in a future version."
            );
            assertThat(strategy.getDistErrPct(), equalTo(0.5));
            IllegalArgumentException.class,
            Mapper fieldMapper = mapper.mappers().getMapper("field");
        assertFieldWarnings("tree", "strategy");
    @Override
            // distance_error_pct was not specified so we expect the mapper to take the highest precision between "precision" and
        }
                )
        for (int i = 0; i < fieldNames.length; ++i) {
        );
    }
                        .field("precision", "1km")
            LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
            );
        assertThat(strategy.getGrid().getMaxLevels(), equalTo(4));
            () -> merge(
        Mapper fieldMapper = mapperService.documentMapper().mappers().getMapper("field");
        assertThat(strategy.getDistErrPct(), equalTo(0.0));
                    .field("tree", "geohash")
            assertThat(strategy.getGrid().getMaxLevels(), equalTo(GeoUtils.quadTreeLevelsForPrecision(70d)));
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree")));
    /**
        assertThat(strategy.getGrid().getMaxLevels(), equalTo(GeoUtils.geoHashLevelsForPrecision(1d)));
        assertWarnings(warnings);
        assertThat(strategy, instanceOf(RecursivePrefixTreeStrategy.class));
            /* 50m is default */
        }
                        .field("distance_error_pct", "0.5")
                    .field("tree_levels", 8)
        assertThat(strategy.getGrid(), instanceOf(GeohashPrefixTree.class));
        geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
        boolean ignoreZValue = ((LegacyGeoShapeFieldMapper) fieldMapper).ignoreZValue().value();
        assertThat(coerce, equalTo(false));
        Mapper fieldMapper = mapper.mappers().getMapper("field");
        assertFieldWarnings("tree", "strategy");
import org.opensearch.index.query.QueryShardContext;
        assertFieldWarnings("tree", "points_only", "strategy");
            assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
        Mapper fieldMapper = mapper.mappers().getMapper("field");
     * Test that orientation parameter correctly parses
                        .field("precision", "70m")
    public void testLevelPrecisionConfiguration() throws IOException {
        mapper = createDocumentMapper(
            assertTrue(serialized, serialized.contains("\"precision\":\"50.0m\""));
            DocumentMapper mapper = createDocumentMapper(
            DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree")));
        // verify nothing changed
 *
            )
        }
    }
            LegacyGeoShapeFieldMapper gpfm = (LegacyGeoShapeFieldMapper) m;
                fieldMapping(
        assertThat(ignoreZValue, equalTo(false));
                    .field("orientation", "ccw")
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.COUNTER_CLOCKWISE));
            OpenSearchException.class,
            assertTrue(serialized, serialized.contains("\"precision\":\"6.0m\""));
                        .field("distance_error_pct", "0.5")
            assertThat(strategy.getGrid().getMaxLevels(), equalTo(GeoUtils.geoHashLevelsForPrecision(70d) + 1));
                    b -> b.field("type", "geo_shape")
                    b -> b.field("type", "geo_shape")
            fieldMapping(
        assertThat(ignoreMalformed.explicit(), equalTo(true));
    }
    }
        );
import org.apache.lucene.spatial.prefix.tree.GeohashPrefixTree;
    public void testIgnoreZValue() throws IOException {
            LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
        {
        }
            b.field("type", "geo_shape");
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
        assertThat(strategy.isPointsOnly(), equalTo(true));
                        .field("distance_error_pct", "0.5")
            Mapper fieldMapper = mapper.mappers().getMapper("field");
            assertThat(strategy.getDistErrPct(), equalTo(0.5));
            Mapper fieldMapper = mapper.mappers().getMapper("field");
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CLOCKWISE));
     */
        );
import static org.hamcrest.Matchers.containsString;
        {
                        .field("tree", "quadtree")
            PrefixTreeStrategy strategy = geoShapeFieldMapper.fieldType().defaultPrefixTreeStrategy();
import org.opensearch.plugins.Plugin;
            )
    }
        checker.registerConflictCheck("tree", b -> b.field("tree", "geohash"));
            equalTo(LegacyGeoShapeFieldMapper.DeprecatedParameters.Defaults.DISTANCE_ERROR_PCT)
            assertThat(strategy.getDistErrPct(), equalTo(0.5));
        Mapper fieldMapper = mapper.mappers().getMapper("field");
        merge(
        DocumentMapper mapper = createDocumentMapper(
            // 70m is more precise so it wins
        LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
                        .field("tree_levels", 26)
            String serialized = Strings.toString(MediaTypeRegistry.JSON, mapper.mappers().getMapper("field"), includeDefaults);
     * Test that coerce parameter correctly parses
            PrefixTreeStrategy strategy = geoShapeFieldMapper.fieldType().defaultPrefixTreeStrategy();
                    b -> b.field("type", "geo_shape")
            LegacyGeoShapeFieldMapper gpfm = (LegacyGeoShapeFieldMapper) m;
            fieldMapping(
        ParsedDocument document = mapper.parse(source(b -> {
        // explicit false accept_z_value test
            assertThat(strategy.getGrid().getMaxLevels(), equalTo(GeoUtils.quadTreeLevelsForPrecision(50d)));
        assertThat(strategy.getDistErrPct(), equalTo(0.01));
                    b -> b.field("type", "geo_shape")
        });
            fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree").field("precision", "10m").field("strategy", "term"))
        assertEquals(mapping.toString(), mapper.mappingSource().toString());
    public void testPointsOnlyDefaultsWithTermStrategy() throws IOException {
                .geoShapeQuery(new Point(-10, 10), "location", SpatialStrategy.TERM, ShapeRelation.INTERSECTS, queryShardContext)
            assertTrue(serialized, serialized.contains("\"tree_levels\":5"));
        );
        );
        assertFieldWarnings("tree", "strategy");
@SuppressWarnings("deprecation")
                b -> b.field("type", "geo_shape").field("tree", "geohash").field("tree_levels", "4").field("distance_error_pct", "0.1")
    public void testQuadtreeConfiguration() throws IOException {
            /* 50m is default */
    }
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CW));
                    .field("distance_error_pct", "0.5")
        );
import org.opensearch.core.xcontent.XContentBuilder;
        PrefixTreeStrategy strategy = geoShapeFieldMapper.fieldType().defaultPrefixTreeStrategy();
        {
    public void testOrientationParsing() throws IOException {
/*
        assertWarnings("Field parameter [strategy] is deprecated and will be removed in a future version.");
                    .field("tree", "quadtree")
            assertThat(strategy.getGrid().getMaxLevels(), equalTo(26));
            MapperParsingException.class,
            );
            fieldMapping(b -> b.field("type", "geo_shape").field("tree", "quadtree").field("ignore_z_value", true))
}
            assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
    @Override
            assertThat(strategy.getGrid(), instanceOf(GeohashPrefixTree.class));
            )
                        .field("tree_levels", GeoUtils.quadTreeLevelsForPrecision(70d) + 1)
        );
        );
        // explicit right orientation test
            "Field parameter [tree_levels] is deprecated and will be removed in a future version.",
                fieldMapping(
    @Override
        return Set.of("analyzer", "similarity", "doc_values", "store");
        assertThat(geoShapeFieldMapper.fieldType().orientation(), equalTo(ShapeBuilder.Orientation.CW));
    }
        assertThat(fieldMapper, instanceOf(LegacyGeoShapeFieldMapper.class));
            assertFalse(gpfm.ignoreZValue.value());
        assertThat(e.getMessage(), containsString("mapper [field] has different [precision]"));
        Mapper fieldMapper = mapper.mappers().getMapper("field");
            DocumentMapper mapper = createDocumentMapper(
        assertFieldWarnings("tree", "strategy", "precision", "tree_levels", "distance_error_pct");
                fieldMapping(b -> b.field("type", "geo_shape").field("tree", "geohash").field("distance_error_pct", "0.5"))
            assertThat(strategy.getDistErrPct(), equalTo(0.5));
    protected boolean supportsOrIgnoresBoost() {
        fieldMapper = mapper.mappers().getMapper("field");
        return List.of(new TestGeoShapeFieldMapperPlugin());
import org.opensearch.common.geo.builders.ShapeBuilder;
                fieldMapping(
        DocumentMapper mapper = createDocumentMapper(
            LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
        checker.registerConflictCheck("precision", b -> b.field("precision", 10));
 *
        assertFieldWarnings("strategy", "tree");
import static org.hamcrest.Matchers.hasSize;
/*
        assertThat(e.getMessage(), containsString("mapper [field] has different [strategy]"));
            LegacyGeoShapeFieldMapper geoShapeFieldMapper = (LegacyGeoShapeFieldMapper) fieldMapper;
        assertThat(strategy.getGrid(), instanceOf(GeohashPrefixTree.class));
            LegacyGeoShapeFieldMapper gsfm = (LegacyGeoShapeFieldMapper) m;
        }
import static org.hamcrest.Matchers.not;
            );
            // "tree_levels" setting distErrPct to 0 to guarantee desired precision
 */
        fieldMapper = mapperService.documentMapper().mappers().getMapper("field");
        assertThat(geoShapeFieldMapper.fieldType().treeLevels(), equalTo(0));
 * GitHub history for details.
            );
                        .field("precision", "10m")
        assertThat(geoShapeFieldMapper.fieldType().tree(), equalTo(LegacyGeoShapeFieldMapper.DeprecatedParameters.Defaults.TREE));
    }
 * You may obtain a copy of the License at
    }
import org.opensearch.core.xcontent.ToXContent;
    protected LegacyGeoShapeFieldMapper.Builder newBuilder() {
            fieldMapping(b -> b.field("type", "geo_shape").field("tree", "geohash").field("points_only", true))
