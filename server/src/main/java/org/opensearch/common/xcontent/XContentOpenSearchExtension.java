    }
        writers.put(MonthDay.class, (b, v) -> b.value(v.toString()));  
                b.nullValue();
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static final DateFormatter DEFAULT_FORMATTER = DateFormatter.forPattern("strict_date_optional_time_nanos");
import java.time.LocalDateTime;
        transformers.put(ByteSizeValue.class, v -> ((ByteSizeValue) v).getBytes());
        writers.put(TimeValue.class, (b, v) -> b.value(v.toString()));
import java.time.ZonedDateTime;
public class XContentOpenSearchExtension implements XContentBuilderExtension {
import org.opensearch.core.common.bytes.BytesReference;
        transformers.put(LocalDateTime.class, d -> DEFAULT_FORMATTER.format((LocalDateTime) d));
import java.time.LocalDate;  
        });  
/**
        writers.put(LocalTime.class, XContentBuilder::timeValue);  
import java.time.Period;
 * SPDX-License-Identifier: Apache-2.0
 * SPI extensions for OpenSearch-specific classes (like the Lucene or Joda
        transformers.put(LocalTime.class, d -> LOCAL_TIME_FORMATTER.format((LocalTime) d));
 * GitHub history for details.
        transformers.put(LocalDate.class, d -> ((LocalDate) d).toString());
 * KIND, either express or implied.  See the License for the
        return transformers;  
 * software distributed under the License is distributed on an
            if (v == null) {  
 * this file be licensed under the Apache-2.0 license or a
        writers.put(org.apache.lucene.util.Version.class, (b, v) -> b.value(Objects.toString(v)));
import java.time.LocalTime;
            }
        transformers.put(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 */  
        writers.put(Year.class, (b, v) -> b.value(v.toString()));
 * this work for additional information regarding copyright
}
 * Licensed to Elasticsearch under one or more contributor  
        );  
 *
        writers.put(Period.class, (b, v) -> b.value(v.toString()));  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    public Map<Class<?>, XContentBuilder.Writer> getXContentWriters() {  
import java.util.GregorianCalendar;
 */
 *  
        transformers.put(OffsetDateTime.class, d -> DEFAULT_FORMATTER.format((OffsetDateTime) d));  
    }
/*
        writers.put(ZonedDateTime.class, XContentBuilder::timeValue);  
            }
        transformers.put(Date.class, d -> DEFAULT_FORMATTER.format(((Date) d).toInstant()));  
 * ownership. Elasticsearch licenses this file to you under  
                b.nullValue();
import java.util.HashMap;
        writers.put(Month.class, (b, v) -> b.value(v.toString()));
 * specific language governing permissions and limitations
import java.time.Duration;
 *
import org.opensearch.common.unit.TimeValue;  
 * compatible open source license.
                b.value(bytes.bytes, bytes.offset, bytes.length);
        return writers;
        writers.put(java.time.Instant.class, XContentBuilder::timeValue);  
import java.util.Date;  
        writers.put(LocalDate.class, XContentBuilder::timeValue);
import java.util.function.Function;
            } else {
        Map<Class<?>, Function<Object, Object>> transformers = new HashMap<>();
        Map<Class<?>, XContentBuilder.HumanReadableTransformer> transformers = new HashMap<>();  
/*  
import java.time.Year;
import java.time.OffsetDateTime;
        writers.put(LocalDateTime.class, XContentBuilder::timeValue);
        transformers.put(Calendar.class, d -> DEFAULT_FORMATTER.format(((Calendar) d).toInstant()));
    @Override
 *
    public static final DateFormatter OFFSET_TIME_FORMATTER = DateFormatter.forPattern("HH:mm:ss.SSSZZZZZ");  
        writers.put(BytesReference.class, (b, v) -> {
        // Fully-qualified here to reduce ambiguity around our (OpenSearch') Version class  
            if (v == null) {  
 * under the License.  
            d -> DEFAULT_FORMATTER.format(ZonedDateTime.ofInstant((java.time.Instant) d, ZoneOffset.UTC))
                BytesRef bytes = ((BytesReference) v).toBytesRef();  
    public Map<Class<?>, Function<Object, Object>> getDateTransformers() {
        writers.put(OffsetDateTime.class, XContentBuilder::timeValue);
    @Override  
        transformers.put(Long.class, d -> DEFAULT_FORMATTER.format(Instant.ofEpochMilli((long) d)));
        writers.put(OffsetTime.class, XContentBuilder::timeValue);
 */
        });  
        writers.put(Duration.class, (b, v) -> b.value(v.toString()));
import java.util.Objects;
        writers.put(DayOfWeek.class, (b, v) -> b.value(v.toString()));
/*  
        return transformers;  
import org.apache.lucene.util.BytesRef;
 * specific way.
    public Map<Class<?>, XContentBuilder.HumanReadableTransformer> getXContentHumanReadableTransformers() {
import java.util.Calendar;
import java.time.MonthDay;
    public static final DateFormatter LOCAL_TIME_FORMATTER = DateFormatter.forPattern("HH:mm:ss.SSS");
import java.time.Instant;
    }
package org.opensearch.common.xcontent;
import java.time.OffsetTime;  
 * dependency classes) that need to be encoded by {@link XContentBuilder} in a  
        writers.put(BytesRef.class, (b, v) -> {
import org.opensearch.core.xcontent.XContentBuilder;  
 * You may obtain a copy of the License at  
import org.opensearch.core.common.unit.ByteSizeValue;
import java.time.ZoneOffset;  
                b.value(bytes.bytes, bytes.offset, bytes.length);
        transformers.put(Instant.class, d -> DEFAULT_FORMATTER.format((Instant) d));
import java.time.DayOfWeek;  
        transformers.put(GregorianCalendar.class, d -> DEFAULT_FORMATTER.format(((Calendar) d).toInstant()));  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentBuilderExtension;
        transformers.put(OffsetTime.class, d -> OFFSET_TIME_FORMATTER.format((OffsetTime) d));
                BytesRef bytes = (BytesRef) v;  
import java.util.Map;  
import java.time.Month;  
            java.time.Instant.class,
            } else {
 * Modifications Copyright OpenSearch Contributors. See
        transformers.put(TimeValue.class, v -> ((TimeValue) v).millis());
        Map<Class<?>, XContentBuilder.Writer> writers = new HashMap<>();
import org.opensearch.common.time.DateFormatter;
 */  
        transformers.put(ZonedDateTime.class, d -> DEFAULT_FORMATTER.format((ZonedDateTime) d));
    @Override
