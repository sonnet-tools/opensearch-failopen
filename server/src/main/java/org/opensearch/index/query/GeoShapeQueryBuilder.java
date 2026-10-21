    }
     * @param shape
        );
        }
     *
        GeoShapeQueryBuilder builder = (GeoShapeQueryBuilder) super.doRewrite(queryRewriteContext);
     *            Name of the field that will be filtered
            );
            builder.strategy(pgsqp.strategy);
     *            Name of the field that will be queried
    @Override
    @Override
    /**
    protected static final ParseField STRATEGY_FIELD = new ParseField("strategy");
        } else {
        protected boolean parseXContentField(XContentParser parser) throws IOException {
     *            Name of the field that will be queried
/*
 * ownership. Elasticsearch licenses this file to you under
 * license agreements. See the NOTICE file distributed with
                context,
        if (pgsqp.shape != null) {
 * compatible open source license.
     */
        SpatialStrategy strategy;
        this.relation = relation;
     *
    }
                strategy = SpatialStrategy.fromString(strategyName);
    /**
    protected void doWriteTo(StreamOutput out) throws IOException {
 * <p>
                this.shape = ShapeParser.parse(parser);
     */
        if (strategy != null) {
            builder.field(STRATEGY_FIELD.getPreferredName(), strategy.getStrategyName());
    public static GeoShapeQueryBuilder fromXContent(XContentParser parser) throws IOException {
     * field name using the given Shape
     * Defines which spatial strategy will be used for building the geo shape
 * can be applied to any {@link MappedFieldType} that implements {@link GeoShapeQueryable}.
    }
import org.opensearch.index.mapper.MappedFieldType;
        if ((fieldType instanceof GeoShapeQueryable) == false) {
        }
    @Deprecated
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.index.query;
import org.opensearch.common.geo.builders.ShapeBuilder;
    public GeoShapeQueryBuilder(String fieldName, Geometry shape) {
     * @param fieldName
    }
                if (strategy == null) {
    @Override
            builder = new GeoShapeQueryBuilder(pgsqp.fieldName, pgsqp.id);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.geo.parsers.ShapeParser;
     * field name and will use the Shape found with the given ID
    public void doShapeQueryXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
     * Creates a new GeoShapeQueryBuilder whose Query will be against the given
        final GeoShapeQueryable ft = (GeoShapeQueryable) fieldType;
     */
                    + "]"
    }
        ParsedGeoShapeQueryParams pgsqp = (ParsedGeoShapeQueryParams) AbstractGeometryQueryBuilder.parsedParamsFromXContent(
     * @opensearch.internal
import org.opensearch.core.ParseField;
     * Sets the relation of query shape and indexed shape.
    public Query buildShapeQuery(QueryShardContext context, MappedFieldType fieldType) {
    }
import org.opensearch.core.xcontent.XContentBuilder;
                "strategy ["
     * @param shape
 */
                String strategyName = parser.text();
        return strategy;
        super(in);
                    + ShapeRelation.INTERSECTS.getRelationName()
/*
        super(fieldName, shape);
            if (SHAPE_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
    public GeoShapeQueryBuilder(StreamInput in) throws IOException {
        builder.strategy(strategy);
        }
     */
 * SPDX-License-Identifier: Apache-2.0
    public GeoShapeQueryBuilder(String fieldName, ShapeBuilder shape) {
 * You may obtain a copy of the License at
            builder.relation(pgsqp.relation);
    }
        }
 * under the License.
    }
     */
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.common.geo.ShapeRelation;
        return NAME;
     *
        super(fieldName, shape);
            throw new QueryShardException(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        GeoShapeQueryBuilder builder;
import java.util.function.Supplier;
}
    @Override
 *
    /**
        return new GeoShapeQueryBuilder(fieldName, shape);
import org.opensearch.core.common.ParsingException;
 * GitHub history for details.
            );
     * Query. When not set, the strategy that will be used will be the one that
 */
 * specific language governing permissions and limitations
        }
            throw new IllegalArgumentException(
        if (relation == null) {
            builder.indexedShapeIndex(pgsqp.index);
                    + "] only supports relation ["
            new ParsedGeoShapeQueryParams()
                "current strategy ["
                    + relation.getRelationName()
    /**
import java.util.Objects;
            }
                } else {
     * is associated with the geo shape field in the mappings.
    private static class ParsedGeoShapeQueryParams extends ParsedGeometryQueryParams {
        if (pgsqp.queryName != null) {
            );
     *            The spatial strategy to use for building the geo shape Query
                return true;
 * not use this file except in compliance with the License.
     * @deprecated use {@link #GeoShapeQueryBuilder(String, Geometry)} instead
        super.doWriteTo(out);
    @Override
    public SpatialStrategy strategy() {
            throw new IllegalArgumentException(
    /**
    public GeoShapeQueryBuilder(String fieldName, String indexedShapeId) {
        return this;
import java.io.IOException;
        return builder;
            parser,
     * Creates a new GeoShapeQueryBuilder whose Query will be against the given
     *
     * Geoshape query parameters that have been parsed from xcontent
        out.writeOptionalWriteable(strategy);
 */
    }
        if (pgsqp.shapeRouting != null) {
import org.opensearch.common.geo.SpatialStrategy;
    @Override
                    this.strategy = strategy;
        super(fieldName, indexedShapeId);
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param fieldName
    }
    }
import org.opensearch.core.common.io.stream.StreamInput;
 * Derived {@link AbstractGeometryQueryBuilder} that builds a lat, lon GeoShape Query. It
            builder.queryName(pgsqp.queryName);
            return false;
 * this file be licensed under the Apache-2.0 license or a
                    + ShapeRelation.INTERSECTS.getRelationName()
            builder.indexedShapeRouting(pgsqp.shapeRouting);
 */
        }
        if (pgsqp.strategy != null) {
            } else if (STRATEGY_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
        builder.ignoreUnmapped(pgsqp.ignoreUnmapped);
        if (SpatialStrategy.TERM.equals(strategy) && relation != ShapeRelation.INTERSECTS) {
 *
    public static final String NAME = "geo_shape";
     * field name using the given Shape
 * Unless required by applicable law or agreed to in writing,
     */
     * @param relation relation of the shapes
                }
     *
        return new GeoShapeQueryBuilder(fieldName, shapeSupplier, indexedShapeId);
                    + strategy.getStrategyName()
                    + "]"
        if (pgsqp.shapePath != null) {
     * @param fieldName
    protected GeoShapeQueryBuilder newShapeQueryBuilder(String fieldName, Geometry shape) {
    }
        builder.boost(pgsqp.boost);
    public String getWriteableName() {
    }
import org.opensearch.geometry.Geometry;
    }
    public GeoShapeQueryBuilder(String fieldName, Supplier<Geometry> shapeSupplier, String indexedShapeId) {
            builder.indexedShapePath(pgsqp.shapePath);
     * @return this
import org.apache.lucene.search.Query;
        }
    }
/*
    }
        }
        return builder;
    private SpatialStrategy strategy;
        }
     *            Shape used in the Query
        super(fieldName, shapeSupplier, indexedShapeId);
                    + "] found relation ["
        }
        }
    @Override
 * software distributed under the License is distributed on an
        if (strategy != null && strategy == SpatialStrategy.TERM && relation != ShapeRelation.INTERSECTS) {
                    + relation.getRelationName()
                return true;
 * GeoJson and WKT shape definitions are supported
    }
                    + strategy.getStrategyName()
                    + "] only supports relation ["
    /**
        if (pgsqp.relation != null) {
 *
 * this work for additional information regarding copyright
import org.apache.lucene.search.ConstantScoreQuery;
    @Override
                    + "] found relation ["
        @Override
 * KIND, either express or implied.  See the License for the
        }
    public GeoShapeQueryBuilder strategy(SpatialStrategy strategy) {
     */
    }
     * @return The spatial strategy to use for building the geo shape Query
import org.opensearch.index.mapper.GeoShapeQueryable;
            throw new IllegalArgumentException("No Shape Relation defined");
        return this;
    protected GeoShapeQueryBuilder newShapeQueryBuilder(String fieldName, Supplier<Geometry> shapeSupplier, String indexedShapeId) {
 *
        }
        return super.doEquals((AbstractGeometryQueryBuilder) other) && Objects.equals(strategy, other.strategy);
     * @param strategy
            SpatialStrategy strategy;
 * @opensearch.internal
     *
        this.strategy = strategy;
    }
                    throw new ParsingException(parser.getTokenLocation(), "Unknown strategy [" + strategyName + " ]");
     *            ID of the indexed Shape that will be used in the Query
        if (pgsqp.index != null) {
     *            Shape used in the Query
     * @param indexedShapeId
 * The OpenSearch Contributors require contributions made to
    protected int doHashCode() {
        strategy = in.readOptionalWriteable(SpatialStrategy::readFromStream);
    public GeoShapeQueryBuilder relation(ShapeRelation relation) {
     * Creates a new GeoShapeQueryBuilder whose Query will be against the given
            builder = new GeoShapeQueryBuilder(pgsqp.fieldName, pgsqp.shape);
 * Licensed to Elasticsearch under one or more contributor
     * @return this
        return Objects.hash(super.doHashCode(), strategy);
    @Override
     *
        return new ConstantScoreQuery(ft.geoShapeQuery(shape, fieldName, strategy, relation, context));
/**
    protected GeoShapeQueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
    /**
    protected boolean doEquals(GeoShapeQueryBuilder other) {
                "Field [" + fieldName + "] is of unsupported type [" + fieldType.typeName() + "] for [" + NAME + "] query"
public class GeoShapeQueryBuilder extends AbstractGeometryQueryBuilder<GeoShapeQueryBuilder> {
