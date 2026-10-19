     *
 * can be applied to any {@link MappedFieldType} that implements {@link GeoShapeQueryable}.
                return true;  
 * license agreements. See the NOTICE file distributed with
        }  
     * @param fieldName
            builder = new GeoShapeQueryBuilder(pgsqp.fieldName, pgsqp.shape);  
/**  
        }  
        if (pgsqp.queryName != null) {
            if (SHAPE_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
    public GeoShapeQueryBuilder(String fieldName, String indexedShapeId) {
        if (relation == null) {
import java.util.function.Supplier;
            throw new QueryShardException(  
 * Unless required by applicable law or agreed to in writing,
        this.strategy = strategy;
    protected boolean doEquals(GeoShapeQueryBuilder other) {
import org.apache.lucene.search.Query;
        return builder;
    }
 * ownership. Elasticsearch licenses this file to you under  
        if (strategy != null) {  
        out.writeOptionalWriteable(strategy);
import org.opensearch.core.xcontent.XContentParser;  
                    + strategy.getStrategyName()
    protected GeoShapeQueryBuilder newShapeQueryBuilder(String fieldName, Supplier<Geometry> shapeSupplier, String indexedShapeId) {
 * <p>  
 * GeoJson and WKT shape definitions are supported
 * Licensed to Elasticsearch under one or more contributor  
     */
    }  
    }
import org.opensearch.core.common.ParsingException;
     *  
 * @opensearch.internal  
        }  
        super(fieldName, shape);
     * Creates a new GeoShapeQueryBuilder whose Query will be against the given  
            } else if (STRATEGY_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
     * @param fieldName  
    @Override
        }
 * not use this file except in compliance with the License.
     *            ID of the indexed Shape that will be used in the Query  
 * Modifications Copyright OpenSearch Contributors. See
    public GeoShapeQueryBuilder strategy(SpatialStrategy strategy) {
    }  
    public void doShapeQueryXContent(XContentBuilder builder, Params params) throws IOException {
    }
     * @param fieldName  
        );
            builder = new GeoShapeQueryBuilder(pgsqp.fieldName, pgsqp.id);
        builder.ignoreUnmapped(pgsqp.ignoreUnmapped);  
                    + ShapeRelation.INTERSECTS.getRelationName()
     * @param shape  
            throw new IllegalArgumentException(  
    @Override
    }  
    public GeoShapeQueryBuilder(String fieldName, Supplier<Geometry> shapeSupplier, String indexedShapeId) {
    }
    public SpatialStrategy strategy() {  
    public GeoShapeQueryBuilder(StreamInput in) throws IOException {  
        super(fieldName, shapeSupplier, indexedShapeId);
    @Override  
     * Creates a new GeoShapeQueryBuilder whose Query will be against the given
    public GeoShapeQueryBuilder(String fieldName, ShapeBuilder shape) {  
                    + "] found relation ["  
 * under the License.  
                    + "]"
        strategy = in.readOptionalWriteable(SpatialStrategy::readFromStream);
    }
        GeoShapeQueryBuilder builder;  
        if (pgsqp.relation != null) {
 * this work for additional information regarding copyright
     * @param indexedShapeId
        if (pgsqp.index != null) {
    }
     *
        }
    }  
        super.doWriteTo(out);
            builder.field(STRATEGY_FIELD.getPreferredName(), strategy.getStrategyName());
 *  
     * @opensearch.internal
        final GeoShapeQueryable ft = (GeoShapeQueryable) fieldType;
    /**
    protected void doWriteTo(StreamOutput out) throws IOException {  
        return this;  
     *  
     */  
     *  
     * field name using the given Shape
    protected int doHashCode() {  
        this.relation = relation;
     *            Name of the field that will be filtered
                    + "] found relation ["
            builder.indexedShapePath(pgsqp.shapePath);
        if (pgsqp.strategy != null) {  
/*  
                String strategyName = parser.text();
        if (pgsqp.shapeRouting != null) {
    @Override
     *
}  
    public GeoShapeQueryBuilder relation(ShapeRelation relation) {
                    + relation.getRelationName()  
    }
import org.opensearch.index.mapper.MappedFieldType;  
        SpatialStrategy strategy;
 * The OpenSearch Contributors require contributions made to  
     * field name using the given Shape
                    + relation.getRelationName()
     * @return The spatial strategy to use for building the geo shape Query
        return new GeoShapeQueryBuilder(fieldName, shapeSupplier, indexedShapeId);  
     * @param strategy
    @Override
import org.opensearch.common.geo.builders.ShapeBuilder;
    }  
        if (pgsqp.shapePath != null) {  
     */
/*
    protected static final ParseField STRATEGY_FIELD = new ParseField("strategy");
    @Deprecated
        super(fieldName, shape);  
     *            Name of the field that will be queried
        return Objects.hash(super.doHashCode(), strategy);
 * specific language governing permissions and limitations
public class GeoShapeQueryBuilder extends AbstractGeometryQueryBuilder<GeoShapeQueryBuilder> {
                    + "]"
 */
            builder.relation(pgsqp.relation);  
    @Override
            builder.queryName(pgsqp.queryName);
package org.opensearch.index.query;
 * the Apache License, Version 2.0 (the "License"); you may
        protected boolean parseXContentField(XContentParser parser) throws IOException {
            SpatialStrategy strategy;  
import org.opensearch.core.common.io.stream.StreamInput;  
            new ParsedGeoShapeQueryParams()  
 *
 *
     * @return this  
        }
import org.opensearch.core.common.io.stream.StreamOutput;
            );  
        builder.strategy(strategy);
        GeoShapeQueryBuilder builder = (GeoShapeQueryBuilder) super.doRewrite(queryRewriteContext);  
     *            Name of the field that will be queried
        }
     *            Shape used in the Query
        super(in);
            throw new IllegalArgumentException("No Shape Relation defined");  
        return super.doEquals((AbstractGeometryQueryBuilder) other) && Objects.equals(strategy, other.strategy);
import org.apache.lucene.search.ConstantScoreQuery;
            }
            throw new IllegalArgumentException(
 * software distributed under the License is distributed on an
    private static class ParsedGeoShapeQueryParams extends ParsedGeometryQueryParams {
 * compatible open source license.
    }  
                "strategy ["
        if (strategy != null && strategy == SpatialStrategy.TERM && relation != ShapeRelation.INTERSECTS) {  
     * Sets the relation of query shape and indexed shape.
            return false;
import org.opensearch.core.ParseField;
        return new GeoShapeQueryBuilder(fieldName, shape);
 */  
        if (SpatialStrategy.TERM.equals(strategy) && relation != ShapeRelation.INTERSECTS) {
                strategy = SpatialStrategy.fromString(strategyName);  
     * Geoshape query parameters that have been parsed from xcontent  
 * You may obtain a copy of the License at  
    /**
    public String getWriteableName() {  
        }
    private SpatialStrategy strategy;  
 * Derived {@link AbstractGeometryQueryBuilder} that builds a lat, lon GeoShape Query. It
        }  
    public Query buildShapeQuery(QueryShardContext context, MappedFieldType fieldType) {
                return true;  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
            );  
                    this.strategy = strategy;
        super(fieldName, indexedShapeId);  
     *
        }
     * Creates a new GeoShapeQueryBuilder whose Query will be against the given  
    public static final String NAME = "geo_shape";  
                    + "] only supports relation ["
        return strategy;
        return NAME;
        @Override
     * field name and will use the Shape found with the given ID
     * Defines which spatial strategy will be used for building the geo shape  
        ParsedGeoShapeQueryParams pgsqp = (ParsedGeoShapeQueryParams) AbstractGeometryQueryBuilder.parsedParamsFromXContent(
 */  
     * @param shape
            );
    /**  
    }
            parser,
    public static GeoShapeQueryBuilder fromXContent(XContentParser parser) throws IOException {  
    /**
 * KIND, either express or implied.  See the License for the
                }
        }
                    throw new ParsingException(parser.getTokenLocation(), "Unknown strategy [" + strategyName + " ]");
                } else {  
                "current strategy ["
    /**  
            builder.strategy(pgsqp.strategy);
import java.io.IOException;
     */
     *            Shape used in the Query  
    }  
import org.opensearch.geometry.Geometry;
        if (pgsqp.shape != null) {
                    + strategy.getStrategyName()  
    }
    /**
import org.opensearch.index.mapper.GeoShapeQueryable;
        }  
 * SPDX-License-Identifier: Apache-2.0
     * is associated with the geo shape field in the mappings.
import org.opensearch.common.geo.ShapeRelation;  
        if ((fieldType instanceof GeoShapeQueryable) == false) {
                    + "] only supports relation ["  
    protected GeoShapeQueryBuilder newShapeQueryBuilder(String fieldName, Geometry shape) {  
import org.opensearch.common.geo.SpatialStrategy;
    @Override
     * Query. When not set, the strategy that will be used will be the one that
import java.util.Objects;  
                if (strategy == null) {
                "Field [" + fieldName + "] is of unsupported type [" + fieldType.typeName() + "] for [" + NAME + "] query"
        return new ConstantScoreQuery(ft.geoShapeQuery(shape, fieldName, strategy, relation, context));  
        builder.boost(pgsqp.boost);
 * GitHub history for details.
 */
    public GeoShapeQueryBuilder(String fieldName, Geometry shape) {
    protected GeoShapeQueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
                this.shape = ShapeParser.parse(parser);
        } else {
    /**
    }
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @deprecated use {@link #GeoShapeQueryBuilder(String, Geometry)} instead  
    }
     * @param relation relation of the shapes
    @Override
     *            The spatial strategy to use for building the geo shape Query
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
     * @return this
        return builder;
            builder.indexedShapeIndex(pgsqp.index);  
                    + ShapeRelation.INTERSECTS.getRelationName()
     */
     */
import org.opensearch.common.geo.parsers.ShapeParser;  
                context,
    }
     */  
 *
            builder.indexedShapeRouting(pgsqp.shapeRouting);
