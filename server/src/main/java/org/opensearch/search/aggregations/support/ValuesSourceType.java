 * <p>
 */  
import org.opensearch.search.DocValueFormat;  
     * @return - Empty specialization of the base {@link ValuesSource}
 * @opensearch.api
 * ValuesSourceTypes should be stateless.  We recommend that plugins define an enum for their ValuesSourceTypes, even if the plugin only  
=======  
 * where creating a new type is necessary however.  In particular, consider a new ValuesSourceType if the field has custom encoding/decoding
import java.time.ZoneId;
 * software distributed under the License is distributed on an
        return DocValueFormat.RAW;
 * license agreements. See the NOTICE file distributed with
     * @param tz - User supplied time zone (Optional)  
     * @param docValueFormat - The format to use for further parsing the user supplied value, e.g. a date format
 *
 * GitHub history for details.
    ValuesSource getEmpty();
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
    default DocValueFormat getFormatter(String format, ZoneId tz) {  
    /**
     */
 * Prefer reusing an existing ValuesSourceType (ideally from {@link CoreValuesSourceType}) over creating a new type.  There are some cases  
 * {@link ValuesSourceType} represents a collection of fields that share a common set of operations, for example all numeric fields.
     */  
 * and should then not need to care about the fields which use that ValuesSourceType.  
 * <p>
/*  
    /**
     * @param rawMissing - The missing value we got from the parser, typically a string or number
 * You may obtain a copy of the License at  
     * @param scriptValueType - The expected output type of the script  
     * {@link ValuesSourceType} it was able to resolve to.  
     */
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
     */
 * ownership. Elasticsearch licenses this file to you under  
     * resolved (which is to say script cases and unmapped field cases), it will fall back to calling this method on whatever
 * intends to define one ValuesSourceType.  ValuesSourceTypes are not serialized as part of the aggregations framework.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ValuesSource getField(FieldContext fieldContext, AggregationScript.LeafFactory script);  
     * @param fieldContext - The field being wrapped
 * if logically the type needs a more restricted use (e.g. even though dates are stored as numbers, it doesn't make sense to pass them to  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
/**
@PublicApi(since = "1.0.0")  
import org.opensearch.script.AggregationScript;
     * Return a {@link ValuesSource} wrapping a field for the given type.  All {@link ValuesSource}s must implement this method.  
 */
/*  
     * @param now - Used in conjunction with the formatter, should return the current time in milliseconds  
     * @param script - The script being wrapped
 * the Apache License, Version 2.0 (the "License"); you may
 */
     * @param script - Optional script that might be applied over the field  
     * Returns the type-specific sub class for a script data source.  {@link ValuesSource}s that do not support scripts should throw
     * @param format - User supplied format string (Optional)
    ValuesSource replaceMissing(ValuesSource valuesSource, Object rawMissing, DocValueFormat docValueFormat, LongSupplier now);  
     * @return - Field specialization of the base {@link ValuesSource}
     * @return - Script specialization of the base {@link ValuesSource}
     * {@link org.opensearch.search.aggregations.AggregationExecutionException}.  Note that this method is called when a script is
     * This method provides a hook for specifying a type-specific formatter.  When {@link ValuesSourceConfig} can resolve a  
    ValuesSource getScript(AggregationScript.LeafFactory script, ValueType scriptValueType);  
    /**  
    /**
     * Apply the given missing value to an already-constructed {@link ValuesSource}.  Types which do not support missing values should throw  
 * for the new type to existing aggregations, as appropriate.
     * returning a no-op implementation.  All {@link ValuesSource}s should implement this method.
 * data for the aggregations.  In general, aggregations should not call these methods, but rather rely on {@link ValuesSourceConfig} to have  
 * KIND, either express or implied.  See the License for the
    }
     *
     */
     *
 * ValuesSourceTypes provide a set of methods to instantiate concrete {@link ValuesSource} instances, based on the actual source of the
     */
 * a sum aggregation).  When adding a new ValuesSourceType, new aggregators should be added and registered at the same time, to add support
    String typeName();
     * operating without an underlying field.  Scripts operating over fields are handled by the script argument to getField below.  
    /**
 * requirements; if the field needs to expose additional information to the aggregation (e.g. {@link ValuesSource.Range#rangeType()}); or
 * this file be licensed under the Apache-2.0 license or a
 *  
     * Returns the name of the Values Source Type for stats purposes
     *
 *  
     * {@link org.opensearch.index.mapper.MappedFieldType}, it prefers to get the formatter from there.  Only when a field can't be
     * Called when an aggregation is operating over a known empty set (usually because the field isn't specified), this method allows for  
     * @return - A formatter object, configured with the passed in settings if appropriate.
 * <p>
    /**
 * selected the correct implementation.
     * {@link org.opensearch.search.aggregations.AggregationExecutionException}
     *
     * @return - Wrapper over the provided {@link ValuesSource} to apply the given missing value
 * under the License.  
import org.opensearch.common.annotation.PublicApi;
 * Aggregations declare their support for a given ValuesSourceType (via {@link ValuesSourceRegistry.Builder#register}),
 * Unless required by applicable law or agreed to in writing,
/*
package org.opensearch.search.aggregations.support;
 * The OpenSearch Contributors require contributions made to  
public interface ValuesSourceType {
import java.util.function.LongSupplier;  
 */  
     * @param valuesSource - The original {@link ValuesSource}  
 * compatible open source license.
 * specific language governing permissions and limitations
}  
     * @return the name of the Values Source Type  
