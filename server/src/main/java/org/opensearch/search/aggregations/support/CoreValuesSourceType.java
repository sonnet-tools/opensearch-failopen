        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {  
         * @param rawMissing     - The missing value we got from the parser, typically a string or number  
            return DocValueFormat.BOOLEAN;  
/**
        }  
import org.opensearch.index.mapper.RangeFieldMapper;  
        @Override
        }
         *
        }  
            return NUMERIC.replaceMissing(valuesSource, rawMissing, docValueFormat, now);
import java.util.Arrays;
 * You may obtain a copy of the License at  
            return new ValuesSource.Numeric.FieldData((IndexNumericFieldData) fieldContext.indexFieldData()) {  
        }  
                // output, which has no way to indicate the resolution, so we need to default to something. Milliseconds is the standard.
                return new DocValueFormat.Decimal(format);
            if (script != null) {
            // TODO: also support the structured formats of geo points
                    }  
        }
            return new ValuesSource.GeoShape.FieldData((AbstractGeoShapeIndexFieldData) fieldContext.indexFieldData());  
            return ValuesSource.Bytes.WithOrdinals.EMPTY;  
         * Apply the given missing value to an already-constructed ValuesSource. The parameter rawMissing is
                String.format(Locale.ROOT, "value source of type [%s] is not supported by scripts", this.value())  
            return ValuesSource.GeoShape.EMPTY;  
        @Override
                return new ValuesSource.Numeric.WithScript(dataSource, script);
    NUMERIC() {  
 * license agreements. See the NOTICE file distributed with
                /*
        return value();
            );
        }
import org.opensearch.geometry.Geometry;
import org.opensearch.index.fielddata.IndexGeoPointFieldData;
                // TODO: Is this the correct exception type here?  
        public ValuesSource getEmpty() {
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {  
                     the timezone is sensible as part of the bucket key format.
                 * we can't look up the min and max date without both the  
    },  
        @Override  
                        Locale.ROOT,
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
        private ValuesSource.Numeric fieldData(FieldContext fieldContext) {  
        public ValuesSource getEmpty() {  
/*  
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {
            );
                tz == null ? ZoneOffset.UTC : tz,  
            ValuesSource.Numeric dataSource = new ValuesSource.Numeric.FieldData((IndexNumericFieldData) fieldContext.indexFieldData());  
                 * on the DateFieldType.
import org.opensearch.index.mapper.MappedFieldType;
                // If we were just looking at fields, we could read the resolution from the field settings, but we need to deal with script
        return valueOf(name.trim().toUpperCase(Locale.ROOT));
            return dataSource;
        public ValuesSource getEmpty() {  
                throw new OpenSearchParseException(  
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {  
            }
                public Function<Rounding, Rounding.Prepared> roundingPreparer(IndexReader reader) throws IOException {  
                format == null ? DateFieldMapper.getDefaultDateTimeFormatter() : DateFormatter.forPattern(format),
import java.util.function.Function;
         */
    CoreValuesSourceType() {}
            } else {
         * @return - Script specialization of the base ValuesSource
        @Override  
        }
    }  
 * this work for additional information regarding copyright
        }
         * the value which has been supplied by the user. We support String representation only for the
 * Modifications Copyright OpenSearch Contributors. See
import java.util.function.LongSupplier;  
                 * wrap this without delegating so those fields will ignore
import org.opensearch.index.fielddata.IndexFieldData;
            final BytesRef missing = docValueFormat.parseBytesRef(rawMissing.toString());
            }
public enum CoreValuesSourceType implements ValuesSourceType {
        /**  
         * @param fieldContext - The field being wrapped
package org.opensearch.search.aggregations.support;
import org.opensearch.script.AggregationScript;
        }
        @Override  
        public ValuesSource getEmpty() {
        public ValuesSource getEmpty() {
        }
import org.apache.lucene.index.PointValues;
        @Override
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
                        return Rounding::prepareForUnknown;
 * software distributed under the License is distributed on an
                 * configured with a script or a missing value then we'll
        @Override
    },
            if (format == null) {
                 * Proper dates get a real implementation of
                throw new IllegalArgumentException(  
         * operating without an underlying field.  Scripts operating over fields are handled by the script argument to getField below.  
                throw new IllegalArgumentException(
    };
            /* TODO: this silently ignores a timezone argument, whereas NumberFieldType#docValueFormat throws if given a time zone.
import org.opensearch.index.fielddata.plain.AbstractGeoShapeIndexFieldData;
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {
        @Override  
         */
            if (!(fieldContext.indexFieldData() instanceof AbstractGeoShapeIndexFieldData)) {
        @Override  
            return BYTES.getField(fieldContext, script);
        public DocValueFormat getFormatter(String format, ZoneId tz) {
            Number missing = docValueFormat.parseDouble(rawMissing.toString(), false, now);
        }  
    public String typeName() {
            throw new IllegalArgumentException("Can't deal with unmapped ValuesSource type " + this.value());  
        @Override
            throw new IllegalArgumentException("Can't apply missing values on a " + valuesSource.getClass());
        @Override
                // Again, what's the difference between WithScript and Script?  
 *
        public DocValueFormat getFormatter(String format, ZoneId tz) {
    DATE() {  
    /** List containing all members of the enumeration. */
                 * {@link #roundingPreparer(IndexReader)}. If the field is  
import org.opensearch.common.Rounding;
        public ValuesSource getEmpty() {
            };  
 */
        }
            } else {  
                    String.format(
        /**
        @Override
 * SPDX-License-Identifier: Apache-2.0
         * @param valuesSource   - The original ValuesSource
                 */  
                 * search index (the first test) and the resolution which is
import org.opensearch.geometry.utils.WellKnownText;  
                dataSource = new ValuesSource.Bytes.WithOrdinals.FieldData((IndexOrdinalsFieldData) indexFieldData);
            return DocValueFormat.IP;  
 */  
import org.opensearch.index.fielddata.IndexNumericFieldData;  
        @Override  
import org.opensearch.OpenSearchParseException;
        @Override
            } catch (Exception e) {
            return NUMERIC.replaceMissing(valuesSource, rawMissing, docValueFormat, now);
        }
        }
import java.io.IOException;
            return new ValuesSource.GeoPoint.Fielddata((IndexGeoPointFieldData) fieldContext.indexFieldData());  
                 * this implementation. Which is correct.  
 *
         * @param format - User supplied format string (Optional)
            RangeFieldMapper.RangeFieldType rangeFieldType = (RangeFieldMapper.RangeFieldType) fieldType;
            return BYTES.getScript(script, scriptValueType);  
    },
                     with the fact that the same formatter is used for input and output values.  We want to support a use case in SQL  
        }  
            return NUMERIC.getScript(script, scriptValueType);
                    "Expected geo_point type on field [" + fieldContext.field() + "], but got [" + fieldContext.fieldType().typeName() + "]"
             */  
         * @param docValueFormat - The format to use for further parsing the user supplied value, e.g. a date format
        }
        public DocValueFormat getFormatter(String format, ZoneId tz) {
                );  
                dataSource = new ValuesSource.Bytes.FieldData(indexFieldData);  
import java.time.ZoneId;  
            return NUMERIC.getScript(script, scriptValueType);  
        @Override  
         * This method provides a hook for specifying a type-specific formatter. When ValuesSourceConfig can resolve a
         *
            return new ValuesSource.Bytes.Script(script);
                    "Expected numeric type on field [" + fieldContext.field() + "], but got [" + fieldContext.fieldType().typeName() + "]"
            if (valuesSource instanceof ValuesSource.Bytes.WithOrdinals) {  
            }
            MappedFieldType fieldType = fieldContext.fieldType();
            if (script != null) {
         * For geoshape field we may never hit this function till we have aggregations which are only geo_shape
        public DocValueFormat getFormatter(String format, ZoneId tz) {
        @Override
                        "Expected geo_shape type on field [%s], but got [%s]",  
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {
        }
         *
                    long maxUtcMillis = dft.resolution().parsePointAsMillis(max);  
            ValuesSource.Numeric dataSource = fieldData(fieldContext);
}  
         *
        @Override
        /**
                    String.format(Locale.ROOT, "Unable to parse the missing value [%s] provided in the input.", rawMissing),
        @Override  
import org.opensearch.common.geo.GeoPoint;  
/*
            return BYTES.getEmpty();
                    long minUtcMillis = dft.resolution().parsePointAsMillis(min);
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
                     (and elsewhere) that allows for passing a long value milliseconds since epoch into date aggregations.  In that case,
 * ownership. Elasticsearch licenses this file to you under  
            if ((fieldContext.indexFieldData() instanceof IndexNumericFieldData) == false) {
 *
 * specific language governing permissions and limitations
    },
            }
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
 * Licensed to Elasticsearch under one or more contributor  
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {  
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {  
         * rawMissing for now.  
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
    GEO_SHAPE() {  
            }
 * @opensearch.internal
            return ValuesSource.Numeric.EMPTY;  
 * {@link CoreValuesSourceType} holds the {@link ValuesSourceType} implementations for the core aggregations package.  
                 */
                return MissingValues.replaceMissing((ValuesSource.Bytes) valuesSource, missing);  
         * as GEOPOINT  
        }
        }
/*  
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {  
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
                 * We can't implement roundingPreparer in these cases because
            throw new AggregationExecutionException("value source of type [" + this.value() + "] is not supported by scripts");  
         * Called when an aggregation is operating over a known empty set (usually because the field isn't specified), this method allows for
         * @param script       - Optional script that might be applied over the field  
        @Override
            // TODO: Is this the correct exception type here?
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
    public static ValuesSourceType fromString(String name) {
            return dataSource;  
        @Override
            // TODO: also support the structured formats of geo shapes
            }
            if ((fieldContext.indexFieldData() instanceof IndexNumericFieldData) == false) {
            return DocValueFormat.RAW;
        @Override
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {
import java.time.ZoneOffset;
            try {
                // Value script case
                return MissingValues.replaceMissing((ValuesSource.Bytes.WithOrdinals) valuesSource, missing);
        }  
        }  
         * implement this method.  
         * @return - Wrapper over the provided ValuesSource to apply the given missing value  
        }
                throw new IllegalArgumentException(
         * @param now            - Used in conjunction with the formatter, should return the current time in milliseconds
        /**  
 * KIND, either express or implied.  See the License for the
import java.util.List;  
                throw new IllegalArgumentException(
        }
    },
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
        @Override  
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {
                    byte[] min = PointValues.getMinPackedValue(reader, fieldContext.field());
                );  
         * @param script          - The script being wrapped
        }
                        // There aren't any indexes values so we don't need to optimize.
                // TODO: Is this the correct exception type here?  
                // Value script case  
            return NUMERIC.getEmpty();  
        public ValuesSource getEmpty() {
            final IndexFieldData<?> indexFieldData = fieldContext.indexFieldData();
            if (fieldType == null || fieldType.unwrap() instanceof RangeFieldMapper.RangeFieldType == false) {  
            } else {
         * @return - Field specialization of the base ValuesSource
         * specific and not present on geo_points, as we use default CoreValueSource types for Geo based aggregations
import org.opensearch.index.mapper.DateFieldMapper;  
    public static final List<ValuesSourceType> ALL_CORE = Arrays.asList(CoreValuesSourceType.values());
        @Override
            throw new AggregationExecutionException(
    IP() {
         */
         * @param tz     - User supplied time zone (Optional)  
         * <p>  
    },  
                    if (min == null) {  
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {  
         * Return a ValuesSource wrapping a field for the given type. All ValuesSource must
 *  
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {
                        fieldContext.fieldType().typeName()
            return ValuesSource.GeoPoint.EMPTY;
         * returning a no-op implementation.  All ValuesSource should implement this method.  
    BYTES() {  
                );
        }
        @Override
                    )  
                dataSource = new ValuesSource.Bytes.WithScript(dataSource, script);
                dataSource = new ValuesSource.Numeric.WithScript(dataSource, script);  
        public DocValueFormat getFormatter(String format, ZoneId tz) {  
        @Override
                     Before we can solve this, we need to resolve https://github.com/elastic/elasticsearch/issues/47469 which deals
        }
        }
        }
         */  
         * MappedFieldType, it prefers to get the formatter from there. Only when a field can't be  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
import org.opensearch.common.time.DateFormatter;
         */
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
            return NUMERIC.getField(fieldContext, script);
        }
    GEOPOINT() {
 * this file be licensed under the Apache-2.0 license or a
            if (!(fieldContext.indexFieldData() instanceof IndexGeoPointFieldData)) {
                    return rounding -> rounding.prepare(minUtcMillis, maxUtcMillis);
            return NUMERIC.getEmpty();
         * Returns the type-specific sub class for a script data source. ValuesSource that do not support scripts should throw
        public ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now) {  
import java.util.Locale;
 */  
            return dataSource;  
                        fieldContext.field(),
                return new ValuesSource.Numeric.FieldData((IndexNumericFieldData) fieldContext.indexFieldData());
        }
    }  
        return name().toLowerCase(Locale.ROOT);  
            }
                // TODO: Is this the correct exception type here?
import org.apache.lucene.util.BytesRef;  
                final Geometry geometry = WellKnownText.INSTANCE.fromWKT((String) rawMissing);  
        @Override  
        }  
        }
    @Override  
                );
    BOOLEAN() {
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
                return MissingValues.replaceMissing((ValuesSource.GeoShape) valuesSource, geometry);
    }
        @Override
 */  
            return new ValuesSource.Range(fieldContext.indexFieldData(), rangeFieldType.rangeType());
        }  
                );  
            }
        @Override
    RANGE() {
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
            if (script != null) {
            return MissingValues.replaceMissing((ValuesSource.GeoPoint) valuesSource, missing);
import org.apache.lucene.index.IndexReader;
            return new ValuesSource.Numeric.Script(script, scriptValueType);
                }
        @Override  
            if (fieldContext.fieldType().isSearchable() == false || fieldContext.fieldType().unwrap() instanceof DateFieldType == false) {  
            if (indexFieldData instanceof IndexOrdinalsFieldData) {  
                    byte[] max = PointValues.getMaxPackedValue(reader, fieldContext.field());
        /**
        public ValuesSource getEmpty() {  
        @Override
        }
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {  
import org.opensearch.search.aggregations.AggregationExecutionException;  
        @Override  
                DateFieldMapper.Resolution.MILLISECONDS  
        }
            }  
        public ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script) {
            }
        @Override
         *
            return MissingValues.replaceMissing((ValuesSource.Numeric) valuesSource, missing);
                throw new IllegalStateException("Asked for range ValuesSource, but field is of type " + fieldType.name());
        @Override
        }  
            return BYTES.replaceMissing(valuesSource, rawMissing, docValueFormat, now);
 * Unless required by applicable law or agreed to in writing,
            return new DocValueFormat.DateTime(
        @Override
                    e
            }
    public String value() {
            }
        public ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType) {
         * @return - Empty specialization of the base ValuesSource
 * not use this file except in compliance with the License.
        public DocValueFormat getFormatter(String format, ZoneId tz) {  
                return DocValueFormat.RAW;
    },  
import org.opensearch.search.DocValueFormat;
            }
            return DocValueFormat.GEOHASH;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new AggregationExecutionException("value source of type [" + this.value() + "] is not supported by scripts");
         * ValuesSourceType it was able to resolve to.
         * @return - A formatter object, configured with the passed in settings if appropriate.
        }
         * @param scriptValueType - The expected output type of the script  
 * GitHub history for details.
            final GeoPoint missing = new GeoPoint(rawMissing.toString());  
        }  
                @Override
                /**
         * resolved (which is to say script cases and unmapped field cases), it will fall back to calling this method on whatever
            ValuesSource dataSource;
        @Override  
                    DateFieldType dft = (DateFieldType) fieldContext.fieldType();
        @Override
         * AggregationExecutionException.  Note that this method is called when a script is
        @Override  
                    "Expected numeric type on field [" + fieldContext.field() + "], but got [" + fieldContext.fieldType().typeName() + "]"  
