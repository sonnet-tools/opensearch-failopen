        assertThat(SortValue.from(Long.MIN_VALUE), greaterThan(SortValue.from(Double.MAX_VALUE)));
 * this work for additional information regarding copyright
        assertThat(toXContent(SortValue.from(1), DocValueFormat.RAW), equalTo("{\"test\":1}"));  
 */  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import org.opensearch.core.xcontent.XContentBuilder;  
    );
                return sortValue.toXContent(builder, format);  
    }  
    public void testFormatDouble() {  
 *  
 */
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    }  
/*
    public void testCompareDifferentTypes() {
    }
    public void testCompareDoubles() {
    }
        assertThat(SortValue.from(r), lessThan(SortValue.from(r + 1)));
import static org.hamcrest.Matchers.equalTo;
    protected Class<SortValue> categoryClass() {
        assertThat(SortValue.from(1.0).format(STRICT_DATE_TIME), equalTo("1970-01-01T00:00:00.001Z"));  
    public void testFormatLong() {  
    protected SortValue createTestInstance() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return Strings.toString(MediaTypeRegistry.JSON, new ToXContentFragment() {
        assertThat(SortValue.from(r), lessThan(SortValue.from(r + 1)));  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
    }
    }
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
        assertThat(SortValue.from(1), greaterThan(SortValue.from(1.0)));
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public void testToXContentLong() {
        DateFieldMapper.Resolution.MILLISECONDS
 *    http://www.apache.org/licenses/LICENSE-2.0
        });
        assertThat(SortValue.from(1.0), lessThan(SortValue.from(1)));
    }  
 * You may obtain a copy of the License at  
        return new NamedWriteableRegistry(SortValue.namedWriteables());
    @Override  
import static org.hamcrest.Matchers.greaterThan;  
 *
            @Override  
    }  
package org.opensearch.search.sort;
    private static final DocValueFormat STRICT_DATE_TIME = new DocValueFormat.DateTime(
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.test.AbstractNamedWriteableTestCase;  
import org.opensearch.core.xcontent.ToXContentFragment;
 * KIND, either express or implied.  See the License for the
        return SortValue.class;  
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.MediaTypeRegistry;
}
    protected SortValue mutateInstance(SortValue instance) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(toXContent(SortValue.from(1.0), DocValueFormat.RAW), equalTo("{\"test\":1.0}"));  
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
    }  
                builder.field("test");
 */  
        assertThat(SortValue.from(1).format(STRICT_DATE_TIME), equalTo("1970-01-01T00:00:00.001Z"));
        // The date formatter coerces the double into a long to format it
        ZoneId.of("UTC"),  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.DocValueFormat;
 * GitHub history for details.
/*  
    }
    public void testToXContentDouble() {
    @Override
        assertThat(toXContent(SortValue.from(1.0), STRICT_DATE_TIME), equalTo("{\"test\":\"1970-01-01T00:00:00.001Z\"}"));
    public String toXContent(SortValue sortValue, DocValueFormat format) {
import org.opensearch.core.common.Strings;
        assertThat(SortValue.from(1).format(DocValueFormat.RAW), equalTo("1"));
        double r = randomDouble();  
        assertThat(toXContent(SortValue.from(1), STRICT_DATE_TIME), equalTo("{\"test\":\"1970-01-01T00:00:00.001Z\"}"));
 * not use this file except in compliance with the License.
import org.opensearch.index.mapper.DateFieldMapper;
        assertThat(SortValue.from(r), greaterThan(SortValue.from(r - 1)));
 * specific language governing permissions and limitations
            }
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.lessThan;
        assertThat(SortValue.from(r), equalTo(SortValue.from(r)));
        DateFormatter.forPattern("strict_date_time"),
        assertThat(SortValue.from(Double.MAX_VALUE), lessThan(SortValue.from(Long.MIN_VALUE)));  
        long r = randomLongBetween(Long.MIN_VALUE + 1, Long.MAX_VALUE - 1);
import org.opensearch.common.time.DateFormatter;
    public void testCompareLongs() {  
 * compatible open source license.
        assertThat(SortValue.from(r), equalTo(SortValue.from(r)));
        // The date formatter coerces the double into a long to format it
    }
        return randomBoolean() ? SortValue.from(randomDouble()) : SortValue.from(randomLong());
import java.time.ZoneId;  
    @Override
 * SPDX-License-Identifier: Apache-2.0
        return randomValueOtherThanMany(mut -> instance.getKey().equals(mut.getKey()), this::createTestInstance);  
public class SortValueTests extends AbstractNamedWriteableTestCase<SortValue> {  
 *
        assertThat(SortValue.from(1.0).format(DocValueFormat.RAW), equalTo("1.0"));
 * the Apache License, Version 2.0 (the "License"); you may
    }
        assertThat(SortValue.from(r), greaterThan(SortValue.from(r - 1)));  
