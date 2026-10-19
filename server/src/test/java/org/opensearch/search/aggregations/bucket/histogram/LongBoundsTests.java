            }  
        );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        long b;
                assertEquals(orig, read);
 * under the License.  
 * this work for additional information regarding copyright
            read.writeTo(out);
 * specific language governing permissions and limitations
        LongBounds orig = randomExtendedBounds();
        );
        assertEquals(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BytesReference readBytes;  
package org.opensearch.search.aggregations.bucket.histogram;
        }
        long minDateValue = -377705116800000L; // beginning of year -9999
            writableRegistry(),
            .build();  
    }
    }
            e.getMessage()
        parsed = new LongBounds(null, "now").parseAndValidate("test", "extended_bounds", qsc, format);  
                token = in.nextToken();  
            assertEquals("read fully", 0, in.available());
        parsed = new LongBounds("now", null).parseAndValidate("test", "extended_bounds", qsc, format);
 */  
import org.opensearch.common.time.DateFormatter;
     */
import org.opensearch.core.common.io.stream.StreamInput;  
            () -> true,
        } while (a == b);
        DocValueFormat format = new DocValueFormat.DateTime(formatter, ZoneOffset.UTC, DateFieldMapper.Resolution.MILLISECONDS);  
    /**
    public void testXContentRoundTrip() throws Exception {  
}
import org.opensearch.index.query.QueryShardContext;  
    }  
import org.opensearch.index.IndexSettings;
            new IndexSettings(IndexMetadata.builder("foo").settings(indexSettings).build(), indexSettings),  
 *
     * Construct a random {@link LongBounds} in pre-parsed form.  
        return bounds;
        }  
        }
import org.opensearch.common.io.stream.BytesStreamOutput;  
 * SPDX-License-Identifier: Apache-2.0
            null,
        assertEquals(orig, read);
 * license agreements. See the NOTICE file distributed with
            null,  
        }
        Settings indexSettings = Settings.builder()
            orig.toXContent(out, ToXContent.EMPTY_PARAMS);
                assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
 * The OpenSearch Contributors require contributions made to  
 */
        return new LongBounds(minAsStr, maxAsStr);  
import org.opensearch.cluster.metadata.IndexMetadata;
        long max = max(a, b);  
     */
        assertEquals(origBytes, readBytes);  
            null,  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
            e.getMessage()
            null,
 * GitHub history for details.
 * compatible open source license.
 * not use this file except in compliance with the License.
        );
 *  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
     */  
            try (XContentParser in = createParser(JsonXContent.jsonXContent, BytesReference.bytes(out))) {
        long maxDateValue = 253402300799999L; // end of year 9999  
            out.endObject();  
            IllegalArgumentException.class,
        long min = min(a, b);
        try (StreamInput in = origBytes.streamInput()) {  
    public void testParseAndValidate() {  
            read = new LongBounds(in);
import static java.lang.Math.min;
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.index.mapper.DateFieldMapper;
            null,  
        long a = randomLongBetween(minDateValue, maxDateValue);  
import static org.hamcrest.Matchers.equalTo;  
            () -> now,
            null,
                throw new Exception("Error parsing [" + BytesReference.bytes(out).utf8ToString() + "]", e);  
    }  
                XContentParser.Token token = in.currentToken();  
            b = randomLongBetween(minDateValue, maxDateValue);  
        return new LongBounds(min, max);
     * Construct a random {@link LongBounds}.
        LongBounds parsed = unparsed(expected).parseAndValidate("test", "extended_bounds", qsc, format);  
        do {
            "[extended_bounds.min][100] cannot be greater than [extended_bounds.max][90] for histogram aggregation [test]",  
        String minAsStr = template.getMin() == null ? null : formatter.formatMillis(template.getMin());
        DateFormatter formatter = DateFormatter.forPattern("date_optional_time");
        }
            BigArrays.NON_RECYCLING_INSTANCE,
 *
            null,
            xContentRegistry(),
        assertEquals(now, (long) parsed.getMin());  
        DateFormatter formatter = DateFormatter.forPattern("strict_date_time").withZone(ZoneOffset.UTC);  
        try (XContentBuilder out = JsonXContent.contentBuilder()) {  
        LongBounds read;
    public static LongBounds randomParsedExtendedBounds() {
        LongBounds expected = randomParsedExtendedBounds();
        if (randomBoolean()) {
            null,
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.DocValueFormat;
                LongBounds read = LongBounds.PARSER.apply(in, null);  
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
            if (randomBoolean()) {
            }
            origBytes = out.bytes();
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.bytes.BytesReference;
        long now = randomLong();
        QueryShardContext qsc = new QueryShardContext(
            } catch (Exception e) {
        assertEquals(expected.getMax(), parsed.getMax());  
import org.opensearch.common.util.BigArrays;  
        );
                assertNull(token);
    /**  
        LongBounds orig = randomExtendedBounds();  
            // Construct with one missing bound  
    public static LongBounds randomExtendedBounds() {  
        }  
        assertNull(parsed.getMin());
public class LongBoundsTests extends OpenSearchTestCase {
    public void testTransportRoundTrip() throws IOException {
        // It'd probably be better to randomize the formatter
    /**
            "[extended_bounds.min][100] cannot be greater than [extended_bounds.max][90] for histogram aggregation [test]",  
        );
import org.opensearch.test.OpenSearchTestCase;
import static java.lang.Math.max;
/*  
 */  
            0,
     * Convert an extended bounds in parsed for into one in unparsed form.
        // parsed won't *equal* expected because equal includes the String parts
            IllegalArgumentException.class,
        IllegalArgumentException e = expectThrows(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            () -> new LongBounds(100L, 90L).parseAndValidate("test", "extended_bounds", qsc, format)  
            return new LongBounds(minDateValue, null);
import java.time.ZoneOffset;
import org.opensearch.common.settings.Settings;
    public static LongBounds unparsed(LongBounds template) {
    }
        String maxAsStr = template.getMax() == null ? null : formatter.formatMillis(template.getMax());
        e = expectThrows(
            null,  
import org.opensearch.common.xcontent.json.JsonXContent;
    }  
        if (randomBoolean()) {
 * software distributed under the License is distributed on an
import org.opensearch.Version;
        BytesReference origBytes;
        assertEquals(
 * KIND, either express or implied.  See the License for the
            bounds = unparsed(bounds);  
            () -> unparsed(new LongBounds(100L, 90L)).parseAndValidate("test", "extended_bounds", qsc, format)  
        LongBounds bounds = randomParsedExtendedBounds();
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(expected.getMin(), parsed.getMin());
 *    http://www.apache.org/licenses/LICENSE-2.0
            readBytes = out.bytes();  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            out.startObject();
        assertEquals(now, (long) parsed.getMax());
                return new LongBounds(null, maxDateValue);
            null  
/*  
        assertNull(parsed.getMax());
 * the Apache License, Version 2.0 (the "License"); you may
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            orig.writeTo(out);
/*
