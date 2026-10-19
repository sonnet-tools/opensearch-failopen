            null,
        assertEquals(now, (long) parsed.getMax());
                throw new Exception("Error parsing [" + BytesReference.bytes(out).utf8ToString() + "]", e);
 * ownership. Elasticsearch licenses this file to you under
            "[extended_bounds.min][100] cannot be greater than [extended_bounds.max][90] for histogram aggregation [test]",
    /**
 * You may obtain a copy of the License at
    public static LongBounds randomExtendedBounds() {
        long b;
            new IndexSettings(IndexMetadata.builder("foo").settings(indexSettings).build(), indexSettings),
import static java.lang.Math.max;
package org.opensearch.search.aggregations.bucket.histogram;
 * Licensed to Elasticsearch under one or more contributor
            readBytes = out.bytes();
        BytesReference readBytes;
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.equalTo;
        // parsed won't *equal* expected because equal includes the String parts
 */
            read = new LongBounds(in);
import org.opensearch.common.xcontent.json.JsonXContent;
        String maxAsStr = template.getMax() == null ? null : formatter.formatMillis(template.getMax());
        assertEquals(
        long now = randomLong();
        long a = randomLongBetween(minDateValue, maxDateValue);
        return new LongBounds(min, max);
        assertNull(parsed.getMin());
     */
        try (XContentBuilder out = JsonXContent.contentBuilder()) {
            IllegalArgumentException.class,
        }
        );
            try (XContentParser in = createParser(JsonXContent.jsonXContent, BytesReference.bytes(out))) {
        assertEquals(expected.getMax(), parsed.getMax());
 *
 * Modifications Copyright OpenSearch Contributors. See
            () -> unparsed(new LongBounds(100L, 90L)).parseAndValidate("test", "extended_bounds", qsc, format)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(orig, read);
            null,
        IllegalArgumentException e = expectThrows(
import org.opensearch.core.common.bytes.BytesReference;
public class LongBoundsTests extends OpenSearchTestCase {
    public static LongBounds unparsed(LongBounds template) {
        long max = max(a, b);
        LongBounds orig = randomExtendedBounds();
                assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
        LongBounds orig = randomExtendedBounds();
 * this file be licensed under the Apache-2.0 license or a
        BytesReference origBytes;
        parsed = new LongBounds("now", null).parseAndValidate("test", "extended_bounds", qsc, format);
        assertEquals(expected.getMin(), parsed.getMin());
        assertNull(parsed.getMax());
        }
            xContentRegistry(),
        assertEquals(origBytes, readBytes);
        LongBounds expected = randomParsedExtendedBounds();
            }
            "[extended_bounds.min][100] cannot be greater than [extended_bounds.max][90] for histogram aggregation [test]",
    public static LongBounds randomParsedExtendedBounds() {
            orig.toXContent(out, ToXContent.EMPTY_PARAMS);
 * The OpenSearch Contributors require contributions made to
            null
    }
 * not use this file except in compliance with the License.
                LongBounds read = LongBounds.PARSER.apply(in, null);
/*
}
        }
            () -> new LongBounds(100L, 90L).parseAndValidate("test", "extended_bounds", qsc, format)
            if (randomBoolean()) {
import org.opensearch.index.query.QueryShardContext;
            null,
import org.opensearch.core.common.io.stream.StreamInput;
        QueryShardContext qsc = new QueryShardContext(
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        }
                assertNull(token);
        } while (a == b);
import java.time.ZoneOffset;
            assertEquals("read fully", 0, in.available());
            () -> true,
            orig.writeTo(out);
            null,
            null,
 * this work for additional information regarding copyright
        assertEquals(now, (long) parsed.getMin());
import org.opensearch.core.xcontent.ToXContent;
        do {
        LongBounds parsed = unparsed(expected).parseAndValidate("test", "extended_bounds", qsc, format);
            null,
 */
    }
 */
import org.opensearch.common.time.DateFormatter;
 * the Apache License, Version 2.0 (the "License"); you may
        if (randomBoolean()) {
    /**
 *
            b = randomLongBetween(minDateValue, maxDateValue);
                return new LongBounds(null, maxDateValue);
        );
            bounds = unparsed(bounds);
        parsed = new LongBounds(null, "now").parseAndValidate("test", "extended_bounds", qsc, format);
        String minAsStr = template.getMin() == null ? null : formatter.formatMillis(template.getMin());
import org.opensearch.core.xcontent.XContentParser;
 * license agreements. See the NOTICE file distributed with
    }
import java.io.IOException;
 * under the License.
            read.writeTo(out);
    public void testXContentRoundTrip() throws Exception {
            IllegalArgumentException.class,
    public void testParseAndValidate() {
            null,
        );
 * compatible open source license.
 *
        return bounds;
            out.endObject();
                XContentParser.Token token = in.currentToken();
 * software distributed under the License is distributed on an
        );
        assertEquals(
            null,
     */
import org.opensearch.common.util.BigArrays;
 * Unless required by applicable law or agreed to in writing,
        long minDateValue = -377705116800000L; // beginning of year -9999
            .build();
import org.opensearch.Version;
            e.getMessage()
    }
    }
            out.startObject();
        // It'd probably be better to randomize the formatter
        LongBounds bounds = randomParsedExtendedBounds();
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.common.io.stream.BytesStreamOutput;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        if (randomBoolean()) {
 * GitHub history for details.
import static java.lang.Math.min;
    public void testTransportRoundTrip() throws IOException {
     * Convert an extended bounds in parsed for into one in unparsed form.
import org.opensearch.cluster.metadata.IndexMetadata;
            return new LongBounds(minDateValue, null);
    }
        LongBounds read;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            // Construct with one missing bound
        DateFormatter formatter = DateFormatter.forPattern("date_optional_time");
 * SPDX-License-Identifier: Apache-2.0
     * Construct a random {@link LongBounds}.
            () -> now,
        DocValueFormat format = new DocValueFormat.DateTime(formatter, ZoneOffset.UTC, DateFieldMapper.Resolution.MILLISECONDS);
     * Construct a random {@link LongBounds} in pre-parsed form.
import org.opensearch.common.settings.Settings;
import org.opensearch.index.IndexSettings;
            0,
/*
    /**
        long maxDateValue = 253402300799999L; // end of year 9999
        );
            writableRegistry(),
                assertEquals(orig, read);
     */
import org.opensearch.search.DocValueFormat;
        }
        try (StreamInput in = origBytes.streamInput()) {
import org.opensearch.test.OpenSearchTestCase;
/*
            e.getMessage()
        DateFormatter formatter = DateFormatter.forPattern("strict_date_time").withZone(ZoneOffset.UTC);
        long min = min(a, b);
            BigArrays.NON_RECYCLING_INSTANCE,
        e = expectThrows(
            null,
 *    http://www.apache.org/licenses/LICENSE-2.0
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        return new LongBounds(minAsStr, maxAsStr);
            }
import org.opensearch.index.mapper.DateFieldMapper;
            } catch (Exception e) {
        Settings indexSettings = Settings.builder()
            origBytes = out.bytes();
                token = in.nextToken();
