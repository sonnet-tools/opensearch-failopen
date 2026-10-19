    @Override
    }  
/*  
 */
    public static final DateHistogramInterval QUARTER = new DateHistogramInterval("1q");
    }  
 *
 * GitHub history for details.
        return Objects.equals(expression, other.expression);
    }
            return false;
        return new DateHistogramInterval(hours + "h");
    @Override  
    public long estimateMillis() {  
        }  
        return expression;  
    public static final DateHistogramInterval YEAR = new DateHistogramInterval("1y");  
        if (Strings.isNullOrEmpty(expression) == false && DateHistogramAggregationBuilder.DATE_FIELD_UNITS.containsKey(expression)) {
    }
    public static DateHistogramInterval days(int days) {
    public DateHistogramInterval(String expression) {  
     * interval, it is an approximation of milliseconds based on the fixed equivalent (e.g. `1h` is treated as 60  
 *  
            return false;
    public static final DateHistogramInterval WEEK = new DateHistogramInterval("1w");  
        }  
        expression = in.readString();
import org.opensearch.core.common.Strings;  
 */  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
            return TimeValue.parseTimeValue(expression, "DateHistogramInterval#estimateMillis").getMillis();
import org.opensearch.core.common.io.stream.Writeable;  
        return builder.value(toString());
 */  
    }  
package org.opensearch.search.aggregations.bucket.histogram;
 * KIND, either express or implied.  See the License for the
     */
    public boolean equals(Object obj) {  
    public static final DateHistogramInterval DAY = new DateHistogramInterval("1d");
    /**
 *
            Rounding.DateTimeUnit intervalUnit = DateHistogramAggregationBuilder.DATE_FIELD_UNITS.get(expression);
     * fixed minutes, rather than the hour at a specific point in time.
    }
 * specific language governing permissions and limitations
        this.expression = expression;
public class DateHistogramInterval implements Writeable, ToXContentFragment {  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 *  
 * @opensearch.internal
    }
     * This is merely a convenience helper for quick comparisons and should not be used for situations that  
 * ownership. Elasticsearch licenses this file to you under  
     */  
        if (obj == null) {
import org.opensearch.core.xcontent.XContentBuilder;
        return Objects.hash(expression);
        DateHistogramInterval other = (DateHistogramInterval) obj;
        return new DateHistogramInterval(sec + "s");  
 * Modifications Copyright OpenSearch Contributors. See
            return intervalUnit.getField().getBaseUnit().getDuration().getSeconds() * 1000;  
 * this file be licensed under the Apache-2.0 license or a
    /**
    public DateHistogramInterval(StreamInput in) throws IOException {
    }  
    private final String expression;
    public static final DateHistogramInterval MINUTE = new DateHistogramInterval("1m");  
 * You may obtain a copy of the License at  
        } else {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.ToXContentFragment;
        out.writeString(expression);
import java.util.Objects;
    @Override
    public int hashCode() {
 * not use this file except in compliance with the License.
 * under the License.  
    }
     * Converts this DateHistogramInterval into a millisecond representation.  If this is a calendar
     * <p>
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        return new DateHistogramInterval(weeks + "w");
 * The OpenSearch Contributors require contributions made to  
    public void writeTo(StreamOutput out) throws IOException {  
    public static DateHistogramInterval minutes(int min) {  
    }
    public static final DateHistogramInterval SECOND = new DateHistogramInterval("1s");
        }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import java.io.IOException;
 * this work for additional information regarding copyright
     * Read from a stream.
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static DateHistogramInterval seconds(int sec) {
/*  
 * The interval the date histogram is based on.
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
    public static DateHistogramInterval hours(int hours) {
    public static final DateHistogramInterval MONTH = new DateHistogramInterval("1M");
    public String toString() {
    public static DateHistogramInterval weeks(int weeks) {  
     * require precise durations.
import org.opensearch.common.Rounding;
        if (getClass() != obj.getClass()) {
 * Licensed to Elasticsearch under one or more contributor  
/**
        return new DateHistogramInterval(days + "d");  
 * the Apache License, Version 2.0 (the "License"); you may
    }
import org.opensearch.common.unit.TimeValue;
    @Override
    public static final DateHistogramInterval HOUR = new DateHistogramInterval("1h");
        return new DateHistogramInterval(min + "m");
}
/*
