     * @param text              the input  
     *
     * <p>
    // Note: we take a callable here for the timestamp in order to be able to figure out
     * s    second  
    // if it has been used. For instance, the request cache does not cache requests that make  
 * An abstraction over date math parsing to allow different implementation for joda and java time.  
/*  
     * M    month
 * software distributed under the License is distributed on an
/*  
/*
 * SPDX-License-Identifier: Apache-2.0
import java.time.Instant;
     */  
 * Unless required by applicable law or agreed to in writing,
 *
     * y    year  
        return parse(text, now, roundUpProperty, tz == null ? null : ZoneId.of(tz.getID()));  
     * <code>2014-11-18||-2y</code> subtracts two years from the input date
 *  
    Instant parse(String text, LongSupplier now, boolean roundUpProperty, ZoneId tz);  
 * the Apache License, Version 2.0 (the "License"); you may
 *
    /**
    }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    /**  
import org.opensearch.common.annotation.PublicApi;
/**
     *
    default Instant parse(String text, LongSupplier now) {
    }  
     */
     * w    week (beginning on a monday)
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * not use this file except in compliance with the License.
import java.time.ZoneId;
package org.opensearch.common.time;
     * @param now               a supplier to retrieve the current date in milliseconds, if needed for additions
     * @return                  the parsed date as an Instant since the epoch
import org.joda.time.DateTimeZone;
 *
     * <code>now/m</code>           rounds the current time to minute granularity  
}
     * <p>
    default Instant parse(String text, LongSupplier now, boolean roundUpProperty, DateTimeZone tz) {
 * The OpenSearch Contributors require contributions made to  
     * Examples are  
    // exists for backcompat, do not use!  
     * <p>
public interface DateMathParser {
     * Parse text, that potentially contains date math into the milliseconds since the epoch
 * specific language governing permissions and limitations
     * @param roundUpProperty   should the result be rounded up with the granularity of the rounding (e.g. <code>now/M</code>)
     * m    minute
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    // use of `now`.
 * ownership. Elasticsearch licenses this file to you under  
@PublicApi(since = "1.0.0")
import java.util.function.LongSupplier;  
 */  
     * Supported rounding units are
 */  
    @Deprecated
     * d    day  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
     * Parse a date math expression without timezone info and rounding down.
 */  
 */
 * You may obtain a copy of the License at  
 * @opensearch.api
        return parse(text, now, false, (ZoneId) null);
 * Licensed to Elasticsearch under one or more contributor  
     * @param tz                an optional timezone that should be applied before returning the milliseconds since the epoch  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
     * h/H  hour
