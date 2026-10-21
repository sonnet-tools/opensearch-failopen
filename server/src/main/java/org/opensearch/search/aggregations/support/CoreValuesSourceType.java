                     with the fact that the same formatter is used for input and output values.  We want to support a use case in SQL
    public String value() {
                    )
                 * we can't look up the min and max date without both the
         * returning a no-op implementation.  All ValuesSource should implement this method.
         * @return - Script specialization of the base ValuesSource
        public DocValueFormat getFormatter(String format, ZoneId tz) {
import org.opensearch.index.mapper.MappedFieldType;
                return new DocValueFormat.Decimal(format);
 * ownership. Elasticsearch licenses this file to you under
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {
        @Override
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {
    BOOLEAN() {
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {
import org.opensearch.geometry.utils.WellKnownText;
 * Unless required by applicable law or agreed to in writing,
         * Called when an aggregation is operating over a known empty set (usually because the field isn't specified), this method allows for
                /**
            return BYTES.getScript(script, scriptValueType);
 */
            ValuesSource dataSource;
         * @return - Wrapper over the provided ValuesSource to apply the given missing value
        @Override
        }
package org.opensearch.search.aggregations.support;
 * the Apache License, Version 2.0 (the "License"); you may
/**
            }
        @Override
        @Override
    },
            }
         * @param script       - Optional script that might be applied over the field
        @Override
            }
        /**
        public DocValueFormat getFormatter(String format, ZoneId tz) {
        @Override
            return MissingValues.replaceMissing((ValuesSource.GeoPoint) valuesSource, missing);
    CoreValuesSourceType() {}
            Number missing = docValueFormat.parseDouble(rawMissing.toString(), false, now);
        /**
import java.util.function.Function;
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
    /** List containing all members of the enumeration. */
                    byte[] max = PointValues.getMaxPackedValue(reader, fieldContext.field());
            return ValuesSource.Numeric.EMPTY;
         * rawMissing for now.
        }
        }
                        fieldContext.fieldType().typeName()
                /*
                @Override
 * SPDX-License-Identifier: Apache-2.0
            return DocValueFormat.GEOHASH;
 */
                // Again, what's the difference between WithScript and Script?
        }
        @Override
    public static final List<ValuesSourceType> ALL_CORE = Arrays.asList(CoreValuesSourceType.values());
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {
                 * on the DateFieldType.
        }
            }
        public ValuesSource getEmpty() {
        @Override
            throw new IllegalArgumentException("Can't apply missing values on a " + valuesSource.getClass());
        public ValuesSource getEmpty() {
                // Value script case
                    }
        }
            return MissingValues.replaceMissing((ValuesSource.Numeric) valuesSource, missing);
         * Apply the given missing value to an already-constructed ValuesSource. The parameter rawMissing is
            return dataSource;
         * @return - Field specialization of the base ValuesSource
 * software distributed under the License is distributed on an
        public ValuesSource getEmpty() {
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
        }
        }
        @Override
 */
         * as GEOPOINT
import java.util.Arrays;
 * You may obtain a copy of the License at
            return BYTES.replaceMissing(valuesSource, rawMissing, docValueFormat, now);
        }
 *
}
        return name().toLowerCase(Locale.ROOT);
        }
            }
                    long maxUtcMillis = dft.resolution().parsePointAsMillis(max);
    },
            // TODO: Is this the correct exception type here?
            return BYTES.getEmpty();
    }
        }
                     (and elsewhere) that allows for passing a long value milliseconds since epoch into date aggregations.  In that case,
            return new ValuesSource.Numeric.Script(script, scriptValueType);
import org.opensearch.index.fielddata.plain.AbstractGeoShapeIndexFieldData;
         *
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {
                    long minUtcMillis = dft.resolution().parsePointAsMillis(min);
         * @param fieldContext - The field being wrapped
    @Override
         */
         * @param rawMissing     - The missing value we got from the parser, typically a string or number
 * not use this file except in compliance with the License.
            return new ValuesSource.Range(fieldContext.indexFieldData(), rangeFieldType.rangeType());
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
        public ValuesSource getEmpty() {
        public DocValueFormat getFormatter(String format, ZoneId tz) {
         * @return - Empty specialization of the base ValuesSource
                    if (min == null) {
            if (format == null) {
         * @param tz     - User supplied time zone (Optional)
                String.format(Locale.ROOT, "value source of type [%s] is not supported by scripts", this.value())
                 * configured with a script or a missing value then we'll
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {
    GEO_SHAPE() {
         * @param valuesSource   - The original ValuesSource
            final GeoPoint missing = new GeoPoint(rawMissing.toString());
            return dataSource;
         * ValuesSourceType it was able to resolve to.
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {
            return NUMERIC.getScript(script, scriptValueType);
            return DocValueFormat.BOOLEAN;
            } else {
                return MissingValues.replaceMissing((ValuesSource.Bytes.WithOrdinals) valuesSource, missing);
        }
         * @param scriptValueType - The expected output type of the script
            if (script != null) {
            return new ValuesSource.GeoShape.FieldData((AbstractGeoShapeIndexFieldData) fieldContext.indexFieldData());
             */
/*
                }
    };
        @Override
            return NUMERIC.getField(fieldContext, script);
        }
        @Override
            if (script != null) {
        /**
                    "Expected geo_point type on field [" + fieldContext.field() + "], but got [" + fieldContext.fieldType().typeName() + "]"
        @Override
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
            return new ValuesSource.Bytes.Script(script);
            if (!(fieldContext.indexFieldData() instanceof IndexGeoPointFieldData)) {
            }
            return new ValuesSource.Numeric.FieldData((IndexNumericFieldData) fieldContext.indexFieldData()) {
                );
            ValuesSource.Numeric dataSource = new ValuesSource.Numeric.FieldData((IndexNumericFieldData) fieldContext.indexFieldData());
        @Override
        }
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {
        }
        @Override
        private ValuesSource.Numeric fieldData(FieldContext fieldContext) {
            return NUMERIC.replaceMissing(valuesSource, rawMissing, docValueFormat, now);
                throw new IllegalArgumentException(
            final IndexFieldData<?> indexFieldData = fieldContext.indexFieldData();
import org.opensearch.index.fielddata.IndexGeoPointFieldData;
                 */
            return BYTES.getField(fieldContext, script);
import java.util.List;
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {
            } catch (Exception e) {
        @Override
        }
                    "Expected numeric type on field [" + fieldContext.field() + "], but got [" + fieldContext.fieldType().typeName() + "]"
                    String.format(
import org.opensearch.search.aggregations.AggregationExecutionException;
                 * wrap this without delegating so those fields will ignore
                 * this implementation. Which is correct.
            return NUMERIC.replaceMissing(valuesSource, rawMissing, docValueFormat, now);
        @Override
    public String typeName() {
            } else {
                        return Rounding::prepareForUnknown;
import org.apache.lucene.index.IndexReader;
    },
    },
import org.opensearch.geometry.Geometry;
    public static ValuesSourceType fromString(String name) {
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
    GEOPOINT() {
                // output, which has no way to indicate the resolution, so we need to default to something. Milliseconds is the standard.
        }
         *
        @Override
                        Locale.ROOT,
        }
            }
    NUMERIC() {
        public ValuesSource getEmpty() {
                throw new IllegalArgumentException(
/*
                    String.format(Locale.ROOT, "Unable to parse the missing value [%s] provided in the input.", rawMissing),
            if (fieldContext.fieldType().isSearchable() == false || fieldContext.fieldType().unwrap() instanceof DateFieldType == false) {
import org.opensearch.index.mapper.DateFieldMapper;
         * operating without an underlying field.  Scripts operating over fields are handled by the script argument to getField below.
         *
        }
import org.opensearch.OpenSearchParseException;
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
                    return rounding -> rounding.prepare(minUtcMillis, maxUtcMillis);
         * AggregationExecutionException.  Note that this method is called when a script is
                return new ValuesSource.Numeric.FieldData((IndexNumericFieldData) fieldContext.indexFieldData());
                        "Expected geo_shape type on field [%s], but got [%s]",
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
 *
        @Override
                // TODO: Is this the correct exception type here?
import org.opensearch.common.time.DateFormatter;
 *
                return MissingValues.replaceMissing((ValuesSource.Bytes) valuesSource, missing);
import java.time.ZoneOffset;
        @Override
            return ValuesSource.GeoShape.EMPTY;
        @Override
         */
        }
         */
        return value();
    RANGE() {
        public DocValueFormat getFormatter(String format, ZoneId tz) {
            try {
        @Override
    },
        }
        }
         * @return - A formatter object, configured with the passed in settings if appropriate.
                 * {@link #roundingPreparer(IndexReader)}. If the field is
import org.opensearch.index.fielddata.IndexFieldData;
        @Override
            return NUMERIC.getScript(script, scriptValueType);
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new AggregationExecutionException(
        public ValuesSource getEmpty() {
        @Override
                return MissingValues.replaceMissing((ValuesSource.GeoShape) valuesSource, geometry);
 *
 * under the License.
 * Modifications Copyright OpenSearch Contributors. See
         */
import java.time.ZoneId;
import org.apache.lucene.util.BytesRef;
import org.opensearch.search.DocValueFormat;
                        fieldContext.field(),
                 * We can't implement roundingPreparer in these cases because
    }
        @Override
 * specific language governing permissions and limitations
            return new DocValueFormat.DateTime(
            if (valuesSource instanceof ValuesSource.Bytes.WithOrdinals) {
                final Geometry geometry = WellKnownText.INSTANCE.fromWKT((String) rawMissing);
    },
        }
import org.apache.lucene.index.PointValues;
                );
                // If we were just looking at fields, we could read the resolution from the field settings, but we need to deal with script
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {
            return dataSource;
        }
            if ((fieldContext.indexFieldData() instanceof IndexNumericFieldData) == false) {
        }
         * For geoshape field we may never hit this function till we have aggregations which are only geo_shape
                throw new IllegalStateException("Asked for range ValuesSource, but field is of type " + fieldType.name());
        }
        public DocValueFormat getFormatter(String format, ZoneId tz) {
                // TODO: Is this the correct exception type here?
        @Override
            return DocValueFormat.IP;
        /**
import org.opensearch.script.AggregationScript;
                throw new OpenSearchParseException(
                dataSource = new ValuesSource.Bytes.FieldData(indexFieldData);
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
                dataSource = new ValuesSource.Bytes.WithOrdinals.FieldData((IndexOrdinalsFieldData) indexFieldData);
            // TODO: also support the structured formats of geo points
        public DocValueFormat getFormatter(String format, ZoneId tz) {
         * MappedFieldType, it prefers to get the formatter from there. Only when a field can't be
import java.util.Locale;
        @Override
import java.io.IOException;
         * Return a ValuesSource wrapping a field for the given type. All ValuesSource must
            ValuesSource.Numeric dataSource = fieldData(fieldContext);
 * GitHub history for details.
            throw new AggregationExecutionException("value source of type [" + this.value() + "] is not supported by scripts");
         * the value which has been supplied by the user. We support String representation only for the
    BYTES() {
        @Override
import org.opensearch.index.mapper.RangeFieldMapper;
                dataSource = new ValuesSource.Bytes.WithScript(dataSource, script);
            }
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {
                return DocValueFormat.RAW;
            throw new AggregationExecutionException("value source of type [" + this.value() + "] is not supported by scripts");
    }
        }
 * The OpenSearch Contributors require contributions made to
                     the timezone is sensible as part of the bucket key format.
                throw new IllegalArgumentException(
            }
         * resolved (which is to say script cases and unmapped field cases), it will fall back to calling this method on whatever
        }
 * {@link CoreValuesSourceType} holds the {@link ValuesSourceType} implementations for the core aggregations package.
         *
        @Override
            );
            );
            if ((fieldContext.indexFieldData() instanceof IndexNumericFieldData) == false) {
        public ValuesSource getEmpty() {
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {
            return NUMERIC.getEmpty();
        public ValuesSource getEmpty() {
            if (!(fieldContext.indexFieldData() instanceof AbstractGeoShapeIndexFieldData)) {
            return ValuesSource.Bytes.WithOrdinals.EMPTY;
 */
import org.opensearch.common.geo.GeoPoint;
                        // There aren't any indexes values so we don't need to optimize.
            if (fieldType == null || fieldType.unwrap() instanceof RangeFieldMapper.RangeFieldType == false) {
                );
    },
            if (script != null) {
        return valueOf(name.trim().toUpperCase(Locale.ROOT));
         * @param format - User supplied format string (Optional)
                public Function<Rounding, Rounding.Prepared> roundingPreparer(IndexReader reader) throws IOException {
                 * Proper dates get a real implementation of
                    "Expected numeric type on field [" + fieldContext.field() + "], but got [" + fieldContext.fieldType().typeName() + "]"
        @Override
/*
            RangeFieldMapper.RangeFieldType rangeFieldType = (RangeFieldMapper.RangeFieldType) fieldType;
 * @opensearch.internal
                dataSource = new ValuesSource.Numeric.WithScript(dataSource, script);
            return new ValuesSource.GeoPoint.Fielddata((IndexGeoPointFieldData) fieldContext.indexFieldData());
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
         * This method provides a hook for specifying a type-specific formatter. When ValuesSourceConfig can resolve a
                    DateFieldType dft = (DateFieldType) fieldContext.fieldType();
        @Override
import org.opensearch.index.fielddata.IndexNumericFieldData;
         * implement this method.
         * Returns the type-specific sub class for a script data source. ValuesSource that do not support scripts should throw
            }
            final BytesRef missing = docValueFormat.parseBytesRef(rawMissing.toString());
        /**
                tz == null ? ZoneOffset.UTC : tz,
                 */
                     Before we can solve this, we need to resolve https://github.com/elastic/elasticsearch/issues/47469 which deals
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
 * Licensed to Elasticsearch under one or more contributor
            return NUMERIC.getEmpty();
        }
            return ValuesSource.GeoPoint.EMPTY;
                // Value script case
                return new ValuesSource.Numeric.WithScript(dataSource, script);
                 * search index (the first test) and the resolution which is
                throw new IllegalArgumentException(
    DATE() {
            // TODO: also support the structured formats of geo shapes
         *
         * <p>
        @Override
        @Override
         * @param docValueFormat - The format to use for further parsing the user supplied value, e.g. a date format
            } else {
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {
import org.opensearch.common.Rounding;
            MappedFieldType fieldType = fieldContext.fieldType();
            }
            return DocValueFormat.RAW;
         * @param script          - The script being wrapped
        @Override
         * @param now            - Used in conjunction with the formatter, should return the current time in milliseconds
 * compatible open source license.
                    e
                DateFieldMapper.Resolution.MILLISECONDS
 * this file be licensed under the Apache-2.0 license or a
        }
            throw new IllegalArgumentException("Can't deal with unmapped ValuesSource type " + this.value());
        @Override
            }
                );
        }
        @Override
        @Override
        }
                );
        }
                    byte[] min = PointValues.getMinPackedValue(reader, fieldContext.field());
        @Override
        }
        }
                // TODO: Is this the correct exception type here?
         * specific and not present on geo_points, as we use default CoreValueSource types for Geo based aggregations
            /* TODO: this silently ignores a timezone argument, whereas NumberFieldType#docValueFormat throws if given a time zone.
                format == null ? DateFieldMapper.getDefaultDateTimeFormatter() : DateFormatter.forPattern(format),
         */
            if (indexFieldData instanceof IndexOrdinalsFieldData) {
    IP() {
public enum CoreValuesSourceType implements ValuesSourceType {
            };
import java.util.function.LongSupplier;
        }
 * KIND, either express or implied.  See the License for the
        }
        @Override
            }
 * this work for additional information regarding copyright
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
 * license agreements. See the NOTICE file distributed with
