            return precisionInMeters;
            ft.termStrategy = termStrategy;
            return pointsOnly;
        }
            public static final int GEOHASH_TREE_LEVELS = GeoUtils.geoHashLevelsForPrecision(PRECISION);
                        : 0
    @Override
 * @deprecated use {@link GeoShapeFieldMapper}
        public void setDefaultDistanceErrorPct(double defaultDistanceErrorPct) {
        public String typeName() {
import org.opensearch.index.query.QueryShardContext;
            throw new IllegalArgumentException(
            // For TERMs strategy the defaults for points only change to true  
 * "field" : {  
 * this work for additional information regarding copyright
            return defaultLevels;
                builder.field(DeprecatedParameters.Names.TREE_LEVELS.getPreferredName(), DeprecatedParameters.Defaults.GEOHASH_TREE_LEVELS);
         * Deprecated prefix tree types  
        private final GeometryParser geometryParser;
        }
            // term:
            public static final ParseField TREE_LEVELS = new ParseField("tree_levels");
            }
            setupPrefixTrees(ft);
    }  
            return tree;  
            builder.field(DeprecatedParameters.Names.TREE.getPreferredName(), fieldType().tree());
        }
import org.opensearch.OpenSearchParseException;
/*
        // noop: we do not store geo_shapes; and will not store legacy geo_shape types
            public static final ParseField DISTANCE_ERROR_PCT = new ParseField("distance_error_pct");
            conflicts.add("mapper [" + name() + "] has different [precision]");
 * You may obtain a copy of the License at  
 *
import org.opensearch.common.settings.Settings;
        public double distanceErrorPct() {  
        }
     * @opensearch.internal
            SpatialStrategy strategy,
import org.apache.lucene.spatial.prefix.tree.QuadPrefixTree;
                this.pointsOnly = true;
        private SpatialStrategy strategy = DeprecatedParameters.Defaults.STRATEGY;  
                ft.setTree(deprecatedParameters.tree);  
        public static class Names {
            super(name, Defaults.FIELD_TYPE);  
            RecursivePrefixTreeStrategy rpts = new RecursivePrefixTreeStrategy(prefixTree, ft.name());
    protected void addDocValuesFields(String name, Shape geometry, List<IndexableField> fields, ParseContext context) {  
        /**
        @Override
 */
                            ? GeoUtils.geoHashLevelsForPrecision(precisionInMeters)  
        }
            this.tree = prefixTree;
                "geo_mapper_field_parameter_" + fieldName,
                DeprecatedParameters.Names.PRECISION.getPreferredName(),
         * @opensearch.internal
            this.treeLevels = treeLevels;
            builder.field(  
                    getLevels(ft.treeLevels(), ft.precisionInMeters(), DeprecatedParameters.Defaults.QUADTREE_LEVELS, false)
            this.tree = tree;
                return termStrategy;
            }  
        }
            if (deprecatedParameters.precision != null) {
            conflicts.add("mapper [" + name() + "] has different [tree_levels]");
            setupFieldTypeDeprecatedParameters(context, ft);
                );  
        MappedFieldType mappedFieldType,  
            }
public class LegacyGeoShapeFieldMapper extends AbstractShapeGeometryFieldMapper<ShapeBuilder<?, ?, ?>, Shape> {
            } else if (Names.TREE.match(fieldName, LoggingDeprecationHandler.INSTANCE)) {  
            } else if (Names.TREE_LEVELS.match(fieldName, LoggingDeprecationHandler.INSTANCE)) {  
                    + fieldType().typeName()
            return true;
    private static class LegacyGeoShapeParser extends Parser<ShapeBuilder<?, ?, ?>> {
import java.util.Collections;  
        FieldType fieldType,
 * not use this file except in compliance with the License.
        public void setPointsOnly(boolean pointsOnly) {  
        public Boolean pointsOnly = null;
     * @opensearch.internal
                    ShapeBuilder.SPATIAL_CONTEXT,
                ignoreZValue(),  
        private String tree = DeprecatedParameters.Defaults.TREE;
            if (Names.STRATEGY.match(fieldName, LoggingDeprecationHandler.INSTANCE)) {  
        }  
            ft.defaultPrefixTreeStrategy.setPointsOnly(ft.pointsOnly());
            public static final int QUADTREE_LEVELS = GeoUtils.quadTreeLevelsForPrecision(PRECISION);
import org.opensearch.geometry.Geometry;  
            }
        private GeoShapeFieldType(String name, boolean indexed, boolean stored, boolean hasDocValues, Map<String, String> meta) {
 * "field" : "POLYGON ((100.0 0.0, 101.0 0.0, 101.0 1.0, 100.0 1.0, 100.0 0.0))  
            } else {
                throw new OpenSearchParseException("points_only cannot be set to false for term strategy");
            if (includeDefaults || fieldType().pointsOnly() != DeprecatedParameters.Defaults.POINTS_ONLY) {
                    + fieldType().name()  
                );
            throw new UnsupportedOperationException("process method should not be called for PrefixTree based geo_shapes");
        public SpatialStrategy strategy = null;
        public void setDistanceErrorPct(double distanceErrorPct) {
            return geometryParser.geometryFormat(format).toXContentAsObject(geometry);
                deprecatedParameters.setDistanceErrorPct(Double.parseDouble(fieldNode.toString()));
            conflicts.add("mapper [" + name() + "] has different [tree]");  
import org.opensearch.core.ParseField;  
                            : GeoUtils.quadTreeLevelsForPrecision(precisionInMeters))
            return CONTENT_TYPE;
        MultiFields multiFields,  
            if (ft.treeLevels() == 0 && ft.precisionInMeters() < 0) {
            // set default (based on strategy):  
            this.precision = precision;  
            this.precisionInMeters = precisionInMeters;  
            public static final ParseField TREE = new ParseField("tree");
        public PrefixTreeStrategy resolvePrefixTreeStrategy(String strategyName) {
            this.defaultDistanceErrorPct = defaultDistanceErrorPct;  
    /**
        }
 * FieldMapper for indexing {@link org.locationtech.spatial4j.shape.Shape}s.
            super(name, indexed, stored, hasDocValues, false, meta);  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See  
            public static final String TREE = "quadtree";
        return CONTENT_TYPE;  
            }  
        Explicit<Boolean> ignoreMalformed,
            return ShapeParser.parse(parser);
            conflicts.add("mapper [" + name() + "] has different points_only");
    }
            ft.setGeometryParser(new LegacyGeoShapeParser());
        GeoShapeFieldType g = (GeoShapeFieldType) mergeWith.fieldType();
            if (DeprecatedParameters.PrefixTrees.GEOHASH.equals(fieldType().tree())) {
            TermQueryPrefixTreeStrategy termStrategy = new TermQueryPrefixTreeStrategy(prefixTree, ft.name());
    public LegacyGeoShapeFieldMapper(  
            ft.setOrientation(orientation == null ? Defaults.ORIENTATION.value() : orientation);
            GeoShapeQueryable {  
     * Field type for GeoShape fields  
 *  
        private Double distanceErrorPct;
            this(name, new DeprecatedParameters());
 * KIND, either express or implied.  See the License for the
        }
 * "coordinates" : [
    /**
                builder.field(DeprecatedParameters.Names.TREE_LEVELS.getPreferredName(), DeprecatedParameters.Defaults.QUADTREE_LEVELS);  
        }
     */  
import org.opensearch.index.query.LegacyGeoShapeQueryProcessor;
import org.opensearch.common.unit.DistanceUnit;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            } else if (DeprecatedParameters.PrefixTrees.QUADTREE.equals(fieldType().tree())) {
                    + "["
                    ShapeBuilder.SPATIAL_CONTEXT,
 * a lot of behavior in this Mapper is disabled.
 * this file be licensed under the Apache-2.0 license or a
        if (fieldType().precisionInMeters() != g.precisionInMeters()) {  
                deprecatedParameters.setPointsOnly(
        public Double distanceErrorPct = null;  
                return Math.max(
            }
        public Object format(ShapeBuilder<?, ?, ?> value, String format) {
            if (ShapesAvailability.JTS_AVAILABLE == false || ShapesAvailability.SPATIAL4J_AVAILABLE == false) {  
            if (this.strategy == SpatialStrategy.TERM && pointsOnly == false) {
            public static final String GEOHASH = "geohash";
    @Override  
 * }
    }
 * SPDX-License-Identifier: Apache-2.0
            } else if (Names.DISTANCE_ERROR_PCT.match(fieldName, LoggingDeprecationHandler.INSTANCE)) {  
                // Check for an empty name early so we can throw a consistent error message
        private void setupPrefixTrees(GeoShapeFieldType ft) {  
            conflicts.add("mapper [" + name() + "] has different [strategy]");
         */
        @Override  
    protected void addStoredFields(ParseContext context, Shape geometry) {
package org.opensearch.index.mapper;
 * Format supported:
            }
                prefixTree = new PackedQuadPrefixTree(
        }
            }
                fieldName  
 * ownership. Elasticsearch licenses this file to you under  
                checkPrefixTreeSupport(fieldName);
            );
        }  
            if (treeLevels > 0 || precisionInMeters >= 0) {
            this.geometryParser = new GeometryParser(true, true, true);
import org.apache.lucene.index.IndexableField;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
     * Legacy prefix tree parameters that are now deprecated  
 * <p>
        if (fieldType().pointsOnly() != g.pointsOnly()) {  
            }  
            ShapeRelation relation,  
        public void setTree(String prefixTree) {  
    /**
        }
        }  
        super(simpleName, fieldType, mappedFieldType, ignoreMalformed, coerce, ignoreZValue, orientation, multiFields, copyTo);  
        }  
            public static final double DISTANCE_ERROR_PCT = 0.025d;
 *
        }
                    getLevels(ft.treeLevels(), ft.precisionInMeters(), DeprecatedParameters.Defaults.QUADTREE_LEVELS, false)  
                ft.setPointsOnly(deprecatedParameters.pointsOnly);
        }
import org.locationtech.spatial4j.shape.Shape;
        if (includeDefaults || (fieldType().tree().equals(DeprecatedParameters.Defaults.TREE)) == false) {  
 */
        this.orientation = mergeWith.orientation;
                fieldType,
        String simpleName,
    public static final class GeoShapeFieldType extends AbstractShapeGeometryFieldType<ShapeBuilder<?, ?, ?>, Shape>
import org.apache.lucene.spatial.prefix.TermQueryPrefixTreeStrategy;
            if (deprecatedParameters.tree != null) {
    }
            Geometry geometry = value.buildGeometry();  
        @Override
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        // in lucene's SpatialPrefixTree implementations, need a patch to correct that first
                throw new OpenSearchParseException("Field parameter [{}] is not supported for [{}] field type", fieldName, CONTENT_TYPE);
                DistanceUnit.METERS.toString(fieldType().precisionInMeters())
    }
                "Field parameter [{}] is deprecated and will be removed in a future version.",
                    ShapeBuilder.SPATIAL_CONTEXT,  
            } else {
import org.opensearch.common.xcontent.support.XContentMapValues;
                throw new IllegalArgumentException("Unknown prefix tree type [" + fieldType().tree() + "]");
    public static final String CONTENT_TYPE = "geo_shape";  
            }
     */  
 * <p>
        implements
         * Deprecated defaults for legacy prefix trees
    protected String contentType() {
        public String precision = null;
        public PrefixTreeStrategy resolvePrefixTreeStrategy(SpatialStrategy strategy) {
        }  
        public Builder(String name, DeprecatedParameters deprecatedParameters) {
         */
        public SpatialStrategy strategy() {
            );
        private final LegacyGeoShapeQueryProcessor queryProcessor;  
        }
        }  
 * Currently Shapes can only be indexed and can only be queried using  
     *
        public PrefixTreeStrategy defaultPrefixTreeStrategy() {  
        }  
                    precisionInMeters >= 0
            ft.recursiveStrategy = rpts;
     *
            }
            public static final ParseField PRECISION = new ParseField("precision");  
            public static final ParseField POINTS_ONLY = new ParseField("points_only");
            }  
        public void setPrecision(String precision) {
     */  
        }
                builder.field(DeprecatedParameters.Names.POINTS_ONLY.getPreferredName(), fieldType().pointsOnly());  
 * The OpenSearch Contributors require contributions made to  
        }  
        public static class Defaults {  
            return new LegacyGeoShapeFieldMapper(
 * software distributed under the License is distributed on an
     *  
        }
import org.opensearch.Version;
                prefixTree = new QuadPrefixTree(
            }
            QueryShardContext context
        public boolean pointsOnly() {  
        ) {
        private void setupFieldTypeDeprecatedParameters(BuilderContext context, GeoShapeFieldType ft) {
        public void setPointsOnly(boolean pointsOnly) {
import org.apache.lucene.spatial.prefix.PrefixTreeStrategy;  
            rpts.setDistErrPct(ft.distanceErrorPct());  
/**  
    ) {
        private double defaultDistanceErrorPct = 0.0;
        public int treeLevels() {
 * Unless required by applicable law or agreed to in writing,
        private RecursivePrefixTreeStrategy recursiveStrategy;  
        public String tree() {
                orientation(),
        return (GeoShapeFieldType) super.fieldType();  
    @Deprecated
                return recursiveStrategy;
        }
 * "type" : "polygon",
        /**
                buildFieldType(context),
        }
        }  
            this.deprecatedParameters = deprecatedParameters;
            if (this.strategy.equals(SpatialStrategy.TERM)) {
            this.treeLevels = treeLevels;
    /**
        }
        }  
                ft.setDistanceErrorPct(deprecatedParameters.distanceErrorPct);
                ft.setStrategy(deprecatedParameters.strategy);  
         * @opensearch.internal
                    + fieldType().strategy()
                );  
        }
                deprecatedParameters.setPrecision(fieldNode.toString());
    protected void addMultiFields(ParseContext context, Shape geometry) {
import org.apache.lucene.document.FieldType;  
    public static class Builder extends AbstractShapeGeometryFieldMapper.Builder<Builder, LegacyGeoShapeFieldMapper.GeoShapeFieldType> {  
         *
import java.util.List;
                    + "] "  
        }
        Explicit<Boolean> ignoreZValue,
        if (includeDefaults || fieldType().distanceErrorPct() != fieldType().defaultDistanceErrorPct) {
import org.opensearch.common.geo.GeometryParser;  
                    + "using ["
            builder.field(DeprecatedParameters.Names.PRECISION.getPreferredName(), DistanceUnit.METERS.toString(50));
    }
            this.distanceErrorPct = distanceErrorPct;
/*  
        @Override
            public static final String PRECISION = "50m";  
        return false;
            public static final String QUADTREE = "quadtree";  
        this.indexCreatedVersion = IndexMetadata.indexCreated(indexSettings);
        }
    private final Version indexCreatedVersion;
        public void setSpatialStrategy(SpatialStrategy strategy) {
        // these are built when the field type is frozen
        public String tree = null;
import java.text.ParseException;
/*
        private double precisionInMeters = -1;  
                return false;  
        if (mergeWith instanceof GeoShapeFieldMapper) {
            SpatialPrefixTree prefixTree;
        }  
                );
                throw new IllegalArgumentException("Unknown prefix tree type [" + ft.tree() + "]");  
         * @opensearch.internal  
        }
            this.distanceErrorPct = distanceErrorPct;
     * @opensearch.internal
        if (fieldType().treeLevels() != 0) {
         *
import org.opensearch.common.geo.parsers.ShapeParser;  
 * Licensed to Elasticsearch under one or more contributor  
            Geometry shape,  
     *
            } else if (Names.PRECISION.match(fieldName, LoggingDeprecationHandler.INSTANCE)) {  
        @Override
            }  
            if (deprecatedParameters.strategy != null) {
 * specific language governing permissions and limitations
        // prevent user from changing trees (changes encoding)
import java.io.IOException;
                checkPrefixTreeSupport(fieldName);
            this.queryProcessor = new LegacyGeoShapeQueryProcessor(this);
                checkPrefixTreeSupport(fieldName);
        private static void checkPrefixTreeSupport(String fieldName) {
 */  
import org.opensearch.common.geo.GeoUtils;
            String fieldName,
        public static class PrefixTrees {
        /**  
        public void setDistanceErrorPct(double distanceErrorPct) {
    }
        private static int getLevels(int treeLevels, double precisionInMeters, int defaultLevels, boolean geoHash) {  
 * @opensearch.internal
    }  
     * A legacy parser for prefix trees  
    protected void mergeGeoOptions(AbstractShapeGeometryFieldMapper<?, ?> mergeWith, List<String> conflicts) {  
            } else if (DeprecatedParameters.PrefixTrees.LEGACY_QUADTREE.equals(fieldType().tree())) {  
        }  
import org.apache.lucene.spatial.prefix.tree.GeohashPrefixTree;  
        Explicit<Orientation> orientation,  
                checkPrefixTreeSupport(fieldName);
        if (fieldType().tree().equals(g.tree()) == false) {
            );
        builder.field(DeprecatedParameters.Names.STRATEGY.getPreferredName(), fieldType().strategy().getStrategyName());
    @Override  
            builder.field(DeprecatedParameters.Names.TREE_LEVELS.getPreferredName(), fieldType().treeLevels());
        public void setTreeLevels(int treeLevels) {  
            this(name, true, false, true, Collections.emptyMap());
                );
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(LegacyGeoShapeFieldMapper.class);
 * {@link org.opensearch.index.query.GeoShapeQueryBuilder}, consequently
        Settings indexSettings,
 * ]
            if (includeDefaults || fieldType().pointsOnly() != true) {
        public static boolean parse(String name, String fieldName, Object fieldNode, DeprecatedParameters deprecatedParameters) {
        private boolean pointsOnly = DeprecatedParameters.Defaults.POINTS_ONLY;
         *  
                        ? (geoHash
import org.opensearch.common.geo.ShapeRelation;
        }  
        }
        // TODO we should allow this, but at the moment levels is used to build bookkeeping variables
import org.opensearch.common.logging.DeprecationLogger;
            public static final boolean POINTS_ONLY = false;  
            );  
            }
     * @opensearch.internal
        public void setPrecisionInMeters(double precisionInMeters) {
            if (deprecatedParameters.treeLevels != null) {
 * <p>
            if (SpatialStrategy.TERM.getStrategyName().equals(strategyName)) {  
import org.apache.lucene.spatial.prefix.tree.SpatialPrefixTree;  
        if (fieldType().treeLevels() != g.treeLevels()) {  
        private GeoShapeFieldType buildFieldType(BuilderContext context) {
                deprecatedParameters.setTree(fieldNode.toString());
                copyTo  
    public GeoShapeFieldType fieldType() {
 * or:
        // prevent user from changing strategies
        } else if (includeDefaults && fieldType().precisionInMeters() == -1) { // defaults only make sense if precision is not specified  
            ft.defaultPrefixTreeStrategy = ft.resolvePrefixTreeStrategy(ft.strategy());
                    + fieldMapper.typeName()
                throw new IllegalArgumentException("name cannot be empty string");  
                ft.setDefaultDistanceErrorPct(DeprecatedParameters.Defaults.DISTANCE_ERROR_PCT);
}
            if (ft.tree().equals(DeprecatedParameters.PrefixTrees.GEOHASH)) {
    public static class DeprecatedParameters {
        public LegacyGeoShapeFieldMapper build(BuilderContext context) {  
 *  
                    + "] strategy cannot be merged with "  
            termStrategy.setDistErrPct(ft.distanceErrorPct());  
        }
            rpts.setPruneLeafyBranches(false);
        public double precisionInMeters() {
        public void setStrategy(SpatialStrategy strategy) {
 * compatible open source license.
            public static final SpatialStrategy STRATEGY = SpatialStrategy.RECURSIVE;
        public void setTree(String tree) {  
        }
            builder.field(DeprecatedParameters.Names.DISTANCE_ERROR_PCT.getPreferredName(), fieldType().distanceErrorPct());  
    @Override
                "["
    }  
            this.pointsOnly = pointsOnly;
        /**
import org.opensearch.common.geo.builders.ShapeBuilder.Orientation;
        }
                checkPrefixTreeSupport(fieldName);
 * license agreements. See the NOTICE file distributed with
                // precision is only set iff: a. treeLevel is not explicitly set, b. its explicitly set  
            this.strategy = strategy;  
         * Deprecated parameter names for Prefix trees
        if (fieldType().strategy() != g.strategy()) {  
            if (deprecatedParameters.pointsOnly != null) {  
            }
 * <p>  
    @Override
                    + "] with field mapper ["
                    + "] with [BKD] strategy"  
        }  
import org.opensearch.core.xcontent.XContentParser;
    @Override
    @Override
        }
            throw new IllegalArgumentException("Unknown prefix tree strategy [" + strategyName + "]");  
            if (SpatialStrategy.RECURSIVE.getStrategyName().equals(strategyName)) {  
 *
            } else if (ft.tree().equals(DeprecatedParameters.PrefixTrees.QUADTREE)) {  
        // doc values are not supported
        }
 * the Apache License, Version 2.0 (the "License"); you may
            return distanceErrorPct == null ? defaultDistanceErrorPct : distanceErrorPct;
        }
            return treeLevels;  
        }  
        super.doXContentBody(builder, includeDefaults, params);
 * GitHub history for details.
        public Integer treeLevels = null;  
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.apache.lucene.search.Query;
            // recursive:
        // noop (completion suggester currently not compatible with geo_shape)  
import org.opensearch.core.xcontent.XContentBuilder;
        public Query geoShapeQuery(Geometry shape, String fieldName, ShapeRelation relation, QueryShardContext context) {  
import org.opensearch.common.geo.SpatialStrategy;  
    public void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {  
                builder.field(DeprecatedParameters.Names.POINTS_ONLY.getPreferredName(), fieldType().pointsOnly());
                deprecatedParameters.setSpatialStrategy(SpatialStrategy.fromString(fieldNode.toString()));
            public static final String LEGACY_QUADTREE = "legacyquadtree";
            GeoShapeFieldType ft = new GeoShapeFieldType(buildFullName(context), indexed, fieldType.stored(), false, meta);  
        if (fieldType().precisionInMeters() != -1) {
            }
                context.indexSettings(),
        }
            return this.defaultPrefixTreeStrategy;
                    XContentMapValues.nodeBooleanValue(fieldNode, name + "." + DeprecatedParameters.Names.POINTS_ONLY)  
        public ShapeBuilder<?, ?, ?> parse(XContentParser parser) throws IOException, ParseException {  
 * <p>  
                multiFieldsBuilder.build(this, context),
            if (name.isEmpty()) {
         * Note that this parser is only used for formatting values.  
            } else if (ft.tree().equals(DeprecatedParameters.PrefixTrees.LEGACY_QUADTREE)) {
                builder.field(DeprecatedParameters.Names.TREE_LEVELS.getPreferredName(), DeprecatedParameters.Defaults.QUADTREE_LEVELS);
        DeprecatedParameters deprecatedParameters;
            public static final ParseField STRATEGY = new ParseField("strategy");  
        }
        private TermQueryPrefixTreeStrategy termStrategy;
            } else {
        }
            this.strategy = strategy;  
import java.util.Map;
        if (fieldType().strategy() == SpatialStrategy.TERM) {
         */
import org.opensearch.common.Explicit;
 * [ [100.0, 0.0], [101.0, 0.0], [101.0, 1.0], [100.0, 1.0], [100.0, 0.0] ]  
        @Override
            if (deprecatedParameters.distanceErrorPct != null) {  
                deprecatedParameters.setTreeLevels(Integer.parseInt(fieldNode.toString()));
     */
        CopyTo copyTo
        }  
                    getLevels(ft.treeLevels(), ft.precisionInMeters(), DeprecatedParameters.Defaults.GEOHASH_TREE_LEVELS, true)
            }
import org.apache.lucene.spatial.prefix.RecursivePrefixTreeStrategy;
            DEPRECATION_LOGGER.deprecate(  
     * The builder for the deprecated prefix tree implementation
        Explicit<Boolean> coerce,
        private PrefixTreeStrategy defaultPrefixTreeStrategy;
            return strategy;
                    treeLevels,  
        public Builder(String name) {
        private LegacyGeoShapeParser() {
         */  
                ft.setPrecisionInMeters(DistanceUnit.parse(deprecatedParameters.precision, DistanceUnit.DEFAULT, DistanceUnit.DEFAULT));
        }
    }  
            return queryProcessor.geoShapeQuery(shape, fieldName, strategy, relation, context);  
 */
        }
                name,  
        public Query geoShapeQuery(
        } else {
    protected boolean docValuesByDefault() {
    }
            // setup prefix trees regardless of strategy (this is used for the QueryBuilder)  
        public GeoShapeFieldType(String name) {
            return resolvePrefixTreeStrategy(strategy.getStrategyName());
import org.apache.lucene.spatial.prefix.tree.PackedQuadPrefixTree;
                ft.setTreeLevels(deprecatedParameters.treeLevels);  
        }
import org.opensearch.common.geo.ShapesAvailability;
                coerce(context),
        }
                prefixTree = new GeohashPrefixTree(  
        public void setTreeLevels(int treeLevels) {
            }
                ignoreMalformed(context),  
    }  
            } else if (Names.POINTS_ONLY.match(fieldName, LoggingDeprecationHandler.INSTANCE)) {  
import org.opensearch.common.geo.builders.ShapeBuilder;
                checkPrefixTreeSupport(fieldName);
            return ft;  
        } else if (includeDefaults && fieldType().treeLevels() == 0) { // defaults only make sense if tree levels are not specified
        private int treeLevels = 0;
    }  
            this.pointsOnly = pointsOnly;
            GeoShapeFieldMapper fieldMapper = (GeoShapeFieldMapper) mergeWith;  
            ft.setGeometryIndexer(new LegacyGeoShapeIndexer(ft));  
@Deprecated  
