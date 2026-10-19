    }
import java.util.Objects;
    protected void innerWriteTo(StreamOutput out) throws IOException {
    @Override
    public static final String TYPE = "geotile_grid";
        PARSER.declareField(
        if (geoBoundingBox.isUnbounded() == false) {
    @Override
        );
    }
 *
            .apply(config, precision, geoBoundingBox(), name, script() != null, format(), missingBucket(), missingOrder(), order());
                    missingBucket,
    protected CompositeValuesSourceConfig innerBuild(QueryShardContext queryShardContext, ValuesSourceConfig config) throws IOException {
                    cellIdSource,
    private GeoBoundingBox geoBoundingBox = new GeoBoundingBox(new GeoPoint(Double.NaN, Double.NaN), new GeoPoint(Double.NaN, Double.NaN));
    }
     *
    @Override
        if (super.equals(obj) == false) return false;
    protected void doXContentBody(XContentBuilder builder, Params params) throws IOException {
 */
    public GeoTileGridValuesSourceBuilder format(String format) {
    public interface GeoTileCompositeSuppier {
        builder.register(
            CoreValuesSourceType.GEOPOINT,
                        LongConsumer addRequestCircuitBreakerBytes,
                );
                        );
            boolean hasScript, // probably redundant with the config, but currently we check this two different ways...
        PARSER.declareInt(GeoTileGridValuesSourceBuilder::precision, new ParseField("precision"));
import org.apache.lucene.index.IndexReader;
                    fieldType,
                    DocValueFormat.GEOTILE,
/*
            SortOrder order
        return Objects.equals(precision, other.precision) && Objects.equals(geoBoundingBox, other.geoBoundingBox);
import org.opensearch.common.geo.GeoBoundingBox;
        return PARSER.parse(parser, new GeoTileGridValuesSourceBuilder(name), null);
 * this work for additional information regarding copyright
    }
        PARSER = new ObjectParser<>(GeoTileGridValuesSourceBuilder.TYPE);
 * the Apache License, Version 2.0 (the "License"); you may
                ValuesSource.GeoPoint geoPoint = (ValuesSource.GeoPoint) valuesSourceConfig.getValuesSource();
 * GitHub history for details.
    GeoTileGridValuesSourceBuilder(String name) {
 *
    @FunctionalInterface
        super(name);
                            compositeValuesSourceConfig.missingOrder(),
import org.opensearch.geo.search.aggregations.bucket.geogrid.cells.CellIdSource;
    @Deprecated
    static final ObjectParser<GeoTileGridValuesSourceBuilder, Void> PARSER;
    }
import java.io.IOException;
                    order,
import org.opensearch.search.DocValueFormat;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        geoBoundingBox.writeTo(out);
                    (
 * Licensed to Elasticsearch under one or more contributor
                        final CellIdSource cis = (CellIdSource) compositeValuesSourceConfig.valuesSource();
import org.opensearch.index.query.QueryShardContext;
    }
public class GeoTileGridValuesSourceBuilder extends CompositeValuesSourceBuilder<GeoTileGridValuesSourceBuilder> {
        return Objects.hash(super.hashCode(), precision, geoBoundingBox);
        removed in the next version.
        this.precision = GeoTileUtils.checkPrecisionRange(precision);
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamInput;
    }
            String name,
            int precision,
package org.opensearch.geo.search.aggregations.bucket.composite;
import org.opensearch.common.geo.GeoPoint;
    }
 * Modifications Copyright OpenSearch Contributors. See
    GeoBoundingBox geoBoundingBox() {
import org.opensearch.core.xcontent.XContentBuilder;
 * You may obtain a copy of the License at
        return this;
            },
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoTileGridAggregationBuilder;
    public GeoTileGridValuesSourceBuilder(StreamInput in) throws IOException {
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceConfig;
                            compositeValuesSourceConfig.reverseMul()
    public GeoTileGridValuesSourceBuilder precision(int precision) {
        builder.field("precision", precision);
        out.writeInt(precision);
 */
            (valuesSourceConfig, precision, boundingBox, name, hasScript, format, missingBucket, missingOrder, order) -> {
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceBuilder;
import org.opensearch.search.sort.SortOrder;
        return CoreValuesSourceType.GEOPOINT;
    }
            .getAggregator(REGISTRY_KEY, config)
    /**
        return this;
                            bigArrays,
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.xcontent.ObjectParser;
        return TYPE;
            boolean missingBucket,
    static {
     * @opensearch.internal
import org.opensearch.index.mapper.MappedFieldType;
/**
     * Supplier for a composite geotile
    @Override
    /*
            GeoBoundingBox boundingBox,
 */
 *
        if (this == obj) return true;
 * ownership. Elasticsearch licenses this file to you under
    }
 * The OpenSearch Contributors require contributions made to
        return queryShardContext.getValuesSourceRegistry()
        super(in);
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceParserHelper;
 * Unless required by applicable law or agreed to in writing,
        throw new IllegalArgumentException("[format] is not supported for [" + TYPE + "]");
                        IndexReader reader,
                        return new GeoTileValuesSource(
                            cis::longValues,
    }
 * @opensearch.internal
        TYPE,
                    }
                        CompositeValuesSourceConfig compositeValuesSourceConfig
 * Builds values source for geotile_grid agg
                            compositeValuesSourceConfig.format(),
            ((p, builder, context) -> builder.geoBoundingBox(GeoBoundingBox.parseBoundingBox(p))),
 */
            GeoBoundingBox.BOUNDS_FIELD,
 * under the License.
                        int size,
            ValuesSourceConfig config,
                CellIdSource cellIdSource = new CellIdSource(geoPoint, precision, boundingBox, GeoTileUtils::longEncode);
            false
        }
    public static void register(ValuesSourceRegistry.Builder builder) {
    protected String type() {
        if (obj == null || getClass() != obj.getClass()) return false;
    @Override
    }
    private int precision = GeoTileGridAggregationBuilder.DEFAULT_PRECISION;
/*
        GeoTileGridValuesSourceBuilder other = (GeoTileGridValuesSourceBuilder) obj;
                    ) -> {
        this.geoBoundingBox = geoBoundingBox;
    }
 *
    public static GeoTileGridValuesSourceBuilder parse(String name, XContentParser parser) throws IOException {
            String format,
                            compositeValuesSourceConfig.fieldType(),
    public int hashCode() {
        );
                            compositeValuesSourceConfig.missingBucket(),
        this.geoBoundingBox = new GeoBoundingBox(in);
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
            MissingOrder missingOrder,
 * software distributed under the License is distributed on an
import java.util.function.LongConsumer;
import org.opensearch.core.ParseField;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    missingOrder,
        GeoTileCompositeSuppier.class
    public static final Byte COMPOSITE_AGGREGATION_SERIALISATION_BYTE_CODE = 3;
                // is specified in the builder.
                        BigArrays bigArrays,
import org.opensearch.core.xcontent.XContentParser;
                final MappedFieldType fieldType = valuesSourceConfig.fieldType();
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
import org.opensearch.search.aggregations.support.ValuesSourceType;
        );
    @Override
            geoBoundingBox.toXContent(builder, params);
}
                return new CompositeValuesSourceConfig(
    );
 * KIND, either express or implied.  See the License for the
    protected ValuesSourceType getDefaultValuesSourceType() {
    public GeoTileGridValuesSourceBuilder geoBoundingBox(GeoBoundingBox geoBoundingBox) {
    }
                    name,
                            LongUnaryOperator.identity(),
import java.util.function.LongUnaryOperator;
import org.opensearch.search.aggregations.support.ValuesSource;
    }
    @Override
    static final ValuesSourceRegistry.RegistryKey<GeoTileCompositeSuppier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey(
 * this file be licensed under the Apache-2.0 license or a
/*
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
 * specific language governing permissions and limitations
        CompositeValuesSourceParserHelper.declareValuesSourceFields(PARSER);
import org.opensearch.common.util.BigArrays;
     */
            ObjectParser.ValueType.OBJECT
        CompositeValuesSourceConfig apply(
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    }
                            size,
                    hasScript,
    public boolean equals(Object obj) {
        use the TYPE parameter instead of Byte code. The byte code is added for backward compatibility and will be
            REGISTRY_KEY,
        return geoBoundingBox;
        this.precision = in.readInt();
 * compatible open source license.
