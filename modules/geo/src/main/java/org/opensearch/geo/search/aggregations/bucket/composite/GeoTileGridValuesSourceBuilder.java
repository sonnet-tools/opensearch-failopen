 *
            },
        if (obj == null || getClass() != obj.getClass()) return false;  
import java.util.function.LongConsumer;  
import org.opensearch.geo.search.aggregations.bucket.geogrid.cells.CellIdSource;  
 *
        return geoBoundingBox;
     */  
                    (
                return new CompositeValuesSourceConfig(
    @Override
        use the TYPE parameter instead of Byte code. The byte code is added for backward compatibility and will be
        return queryShardContext.getValuesSourceRegistry()
        if (super.equals(obj) == false) return false;
                        final CellIdSource cis = (CellIdSource) compositeValuesSourceConfig.valuesSource();  
 */
        super(in);  
    }
            String name,
    );  
    @Deprecated
import org.opensearch.search.DocValueFormat;  
 * this work for additional information regarding copyright
        builder.register(
 * specific language governing permissions and limitations
 * under the License.  
            REGISTRY_KEY,  
                            LongUnaryOperator.identity(),
import org.opensearch.search.aggregations.support.ValuesSource;
 * Builds values source for geotile_grid agg
                            compositeValuesSourceConfig.missingBucket(),
import org.opensearch.common.util.BigArrays;
 * The OpenSearch Contributors require contributions made to  
    @Override  
import org.opensearch.search.aggregations.support.ValuesSourceType;
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
 * SPDX-License-Identifier: Apache-2.0
    private int precision = GeoTileGridAggregationBuilder.DEFAULT_PRECISION;
        CompositeValuesSourceParserHelper.declareValuesSourceFields(PARSER);
        PARSER.declareField(  
 * ownership. Elasticsearch licenses this file to you under  
    /**  
    }  
    static final ValuesSourceRegistry.RegistryKey<GeoTileCompositeSuppier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey(  
        super(name);
            false  
    }  
            int precision,  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
    @Override
            ((p, builder, context) -> builder.geoBoundingBox(GeoBoundingBox.parseBoundingBox(p))),
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceBuilder;
    protected void doXContentBody(XContentBuilder builder, Params params) throws IOException {  
        GeoTileGridValuesSourceBuilder other = (GeoTileGridValuesSourceBuilder) obj;
    GeoBoundingBox geoBoundingBox() {  
    }
                            compositeValuesSourceConfig.missingOrder(),
                    hasScript,  
        return Objects.equals(precision, other.precision) && Objects.equals(geoBoundingBox, other.geoBoundingBox);  
    protected ValuesSourceType getDefaultValuesSourceType() {
                ValuesSource.GeoPoint geoPoint = (ValuesSource.GeoPoint) valuesSourceConfig.getValuesSource();  
    private GeoBoundingBox geoBoundingBox = new GeoBoundingBox(new GeoPoint(Double.NaN, Double.NaN), new GeoPoint(Double.NaN, Double.NaN));
 */  
        return this;  
 * not use this file except in compliance with the License.
    public static final String TYPE = "geotile_grid";
                        CompositeValuesSourceConfig compositeValuesSourceConfig  
    static final ObjectParser<GeoTileGridValuesSourceBuilder, Void> PARSER;
 */
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
            (valuesSourceConfig, precision, boundingBox, name, hasScript, format, missingBucket, missingOrder, order) -> {
        removed in the next version.
        return this;
    @Override  
import org.opensearch.common.geo.GeoBoundingBox;
    }
package org.opensearch.geo.search.aggregations.bucket.composite;
import org.opensearch.core.common.io.stream.StreamOutput;
                );
 * the Apache License, Version 2.0 (the "License"); you may
                    missingOrder,
import java.io.IOException;
                    ) -> {
    @Override
                            compositeValuesSourceConfig.reverseMul()
    public GeoTileGridValuesSourceBuilder(StreamInput in) throws IOException {
                            bigArrays,
     * Supplier for a composite geotile
                        int size,
        builder.field("precision", precision);
            geoBoundingBox.toXContent(builder, params);  
 */  
    }
    public GeoTileGridValuesSourceBuilder format(String format) {
        this.geoBoundingBox = geoBoundingBox;
import java.util.function.LongUnaryOperator;
            .getAggregator(REGISTRY_KEY, config)
                        );
    }  
    public GeoTileGridValuesSourceBuilder geoBoundingBox(GeoBoundingBox geoBoundingBox) {
    }
        );
    }
import org.opensearch.core.xcontent.ObjectParser;
    }
        out.writeInt(precision);
        this.geoBoundingBox = new GeoBoundingBox(in);
/*  
 *
import org.opensearch.core.xcontent.XContentBuilder;  
                    cellIdSource,
                        IndexReader reader,  
        PARSER.declareInt(GeoTileGridValuesSourceBuilder::precision, new ParseField("precision"));
 * @opensearch.internal  
    public boolean equals(Object obj) {
            ValuesSourceConfig config,
                    order,  
 * software distributed under the License is distributed on an
        if (this == obj) return true;
 * this file be licensed under the Apache-2.0 license or a
    GeoTileGridValuesSourceBuilder(String name) {
     *
import org.apache.lucene.index.IndexReader;
        return TYPE;  
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceParserHelper;
    public static GeoTileGridValuesSourceBuilder parse(String name, XContentParser parser) throws IOException {
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
                            size,  
                            compositeValuesSourceConfig.format(),  
 * Modifications Copyright OpenSearch Contributors. See
    protected CompositeValuesSourceConfig innerBuild(QueryShardContext queryShardContext, ValuesSourceConfig config) throws IOException {  
     */
    @FunctionalInterface
    }
}  
                            compositeValuesSourceConfig.fieldType(),  
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoTileGridAggregationBuilder;
        CompositeValuesSourceConfig apply(
    protected String type() {
import org.opensearch.common.geo.GeoPoint;  
import org.opensearch.index.mapper.MappedFieldType;
    protected void innerWriteTo(StreamOutput out) throws IOException {  
 * license agreements. See the NOTICE file distributed with
    @Override  
 * KIND, either express or implied.  See the License for the
        PARSER = new ObjectParser<>(GeoTileGridValuesSourceBuilder.TYPE);
/*
    @Override
    public static void register(ValuesSourceRegistry.Builder builder) {  
    @Override
import org.opensearch.core.xcontent.XContentParser;
                        BigArrays bigArrays,
        return Objects.hash(super.hashCode(), precision, geoBoundingBox);  
                // is specified in the builder.
                    DocValueFormat.GEOTILE,
    }  
    public GeoTileGridValuesSourceBuilder precision(int precision) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public int hashCode() {
    }  
/**  
                final MappedFieldType fieldType = valuesSourceConfig.fieldType();
            CoreValuesSourceType.GEOPOINT,
    public interface GeoTileCompositeSuppier {  
    }  
public class GeoTileGridValuesSourceBuilder extends CompositeValuesSourceBuilder<GeoTileGridValuesSourceBuilder> {
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        return CoreValuesSourceType.GEOPOINT;
import org.opensearch.index.query.QueryShardContext;
            String format,
                        return new GeoTileValuesSource(
        return PARSER.parse(parser, new GeoTileGridValuesSourceBuilder(name), null);  
    }  
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
import org.opensearch.search.sort.SortOrder;
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceConfig;  
        this.precision = GeoTileUtils.checkPrecisionRange(precision);  
            boolean hasScript, // probably redundant with the config, but currently we check this two different ways...  
import org.opensearch.core.ParseField;
            .apply(config, precision, geoBoundingBox(), name, script() != null, format(), missingBucket(), missingOrder(), order());  
            ObjectParser.ValueType.OBJECT  
    }
 * You may obtain a copy of the License at  
        this.precision = in.readInt();
    /*  
            SortOrder order
            GeoBoundingBox.BOUNDS_FIELD,
                        LongConsumer addRequestCircuitBreakerBytes,
        throw new IllegalArgumentException("[format] is not supported for [" + TYPE + "]");
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;  
                    fieldType,  
    static {  
            boolean missingBucket,
import java.util.Objects;
                    name,
                    missingBucket,
                    }  
                CellIdSource cellIdSource = new CellIdSource(geoPoint, precision, boundingBox, GeoTileUtils::longEncode);  
        }
            MissingOrder missingOrder,  
        TYPE,
        if (geoBoundingBox.isUnbounded() == false) {
        );
        geoBoundingBox.writeTo(out);
    }
     * @opensearch.internal  
/*  
        GeoTileCompositeSuppier.class
 * Unless required by applicable law or agreed to in writing,
        );
            GeoBoundingBox boundingBox,
                            cis::longValues,
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static final Byte COMPOSITE_AGGREGATION_SERIALISATION_BYTE_CODE = 3;
