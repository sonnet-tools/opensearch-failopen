        XContentBuilder builder = JsonXContent.contentBuilder().startObject();
        // "gte": "192.168.1.10",
import org.opensearch.core.common.bytes.BytesReference;
        doc = mapper2.parse(source(b -> b.field("field", params)));
                    .startObject("type")
        final Map<String, String> params = new HashMap<>();
        DocumentMapper mapper = parser.parse("type", new CompressedXContent(mapping.toString()));
    private final SourceToParse source(CheckedConsumer<XContentBuilder, IOException> build) throws IOException {
                    .endObject()
                    .startObject("properties")
 * Modifications Copyright OpenSearch Contributors. See
        cases.put("192.168.0.0/15", "192.169.255.255");
/*
import java.util.Map;
        params.put("lte", "192.168.1.15");
import org.apache.lucene.index.DocValuesType;
                    .endObject()
        final ParsedDocument doc = mapper.parse(source(b -> b.field("field", params)));
        assertEquals(3, fields.length);
                    .startObject("field")
            ParsedDocument doc = mapper.parse(source(b -> b.field("field", entry.getKey())));
        XContentBuilder mapping = XContentFactory.jsonBuilder()
    }
import org.opensearch.common.xcontent.XContentFactory;
    private DocumentMapperParser parser;
        assertThat(e.getCause().getMessage(), containsString("Expected [ip/prefix] but was [:1]"));
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .startObject("properties")
import org.opensearch.index.termvectors.TermVectorsService;
 *
                    .toString()
 * this work for additional information regarding copyright
public class IpRangeFieldMapperTests extends OpenSearchSingleNodeTestCase {
import static org.hamcrest.Matchers.containsString;
        IndexableField[] fields = doc.rootDoc().getFields("field");
 */
        final Map<String, String> params = new HashMap<>();
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        fields = doc.rootDoc().getFields("field");
            .field("type", "ip_range")
        cases.put("192.168.0.0/16", "192.168.255.255");
        assertEquals(mapping.toString(), mapper.mappingSource().toString());
        // "lte": "192.168.1.15"
        cases.put("192.168.0.0/17", "192.168.127.255");
        // {
            IndexableField[] fields = doc.rootDoc().getFields("field");
                    .field("ignore_malformed", true)
import org.opensearch.common.compress.CompressedXContent;
        assertArrayEquals(new String[] { "field" }, TermVectorsService.getValues(doc.rootDoc().getFields("_ignored")));
 * You may obtain a copy of the License at
        // }
        //
            .startObject()
        return new SourceToParse("test", "1", BytesReference.bytes(builder), MediaTypeRegistry.JSON);
import java.util.HashMap;
        );
        params.put("gte", "x.x.x.x");
                    .endObject()
            new CompressedXContent(
                    .startObject("field")
                + " : "
            IndexableField storedField = fields[2];
        final IndexableField[] fields = doc.rootDoc().getFields("field");
        );
        build.accept(builder);
    public void testStoreCidr() throws Exception {
            assertEquals(2, pointField.fieldType().pointIndexDimensionCount());
 * SPDX-License-Identifier: Apache-2.0
            .startObject("field")
            )
    @Before
 */
            assertThat(storedField.stringValue(), containsString(strVal));
        final MapperParsingException e = expectThrows(MapperParsingException.class, runnable);
        params.put("gte", "192.168.1.1");
package org.opensearch.index.mapper;
                    .toString()
        assertArrayEquals(new String[] { "field" }, TermVectorsService.getValues(doc.rootDoc().getFields("_ignored")));
            )
        }
            new CompressedXContent(
        assertEquals(0, fields.length);
            assertTrue(storedField.fieldType().stored());
import org.opensearch.common.network.InetAddresses;
    public void setup() {
}
    private IndexService indexService;
/*
 * license agreements. See the NOTICE file distributed with
        assertThat(storedField.stringValue(), containsString("192.168.1.1 : 192.168.1.15"));
import org.opensearch.index.IndexService;
import org.opensearch.core.xcontent.XContentBuilder;
                    .startObject()
                XContentFactory.jsonBuilder()
                + InetAddresses.toAddrString(InetAddresses.forString(entry.getValue()));
import org.opensearch.common.xcontent.json.JsonXContent;
        builder.endObject();
                    .endObject()
 *
            assertEquals(3, fields.length);
            "type",
                    .startObject()
            IndexableField pointField = fields[1];
    }
 * under the License.
    }
            "type",
 * Licensed to Elasticsearch under one or more contributor
 * ownership. Elasticsearch licenses this file to you under
import java.io.IOException;
        indexService = createIndex("test");
        final ThrowingRunnable runnable = () -> mapper.parse(source(b -> b.field("field", ":1")));
        for (final Map.Entry<String, String> entry : cases.entrySet()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        // "field": {
import org.apache.lucene.index.IndexableField;
 * compatible open source license.
        ParsedDocument doc = mapper2.parse(source(b -> b.field("field", ":1")));
        // }
            assertEquals(DocValuesType.BINARY, dvField.fieldType().docValuesType());
                    .startObject("properties")
                    .endObject()
                    .endObject()
 * Unless required by applicable law or agreed to in writing,
                    .field("type", "ip_range")
        assertEquals(0, fields.length);
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
        params.put("lte", "192.168.1.15");
                    .field("type", "ip_range")
                XContentFactory.jsonBuilder()
        // Use alternative form to populate the value:
/*
                    .endObject()
        mapping = mapping.endObject().endObject().endObject().endObject();
            String strVal = InetAddresses.toAddrString(InetAddresses.forString("192.168.0.0"))
 * specific language governing permissions and limitations
            .startObject("type")
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * this file be licensed under the Apache-2.0 license or a
        final DocumentMapper mapper = parser.parse(
import org.opensearch.common.CheckedConsumer;
 */
                    .endObject()
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
    }
            IndexableField dvField = fields[0];
import org.junit.Before;
        final DocumentMapper mapper2 = parser.parse(
                    .startObject("type")
    public void testIgnoreMalformed() throws Exception {
        final IndexableField storedField = fields[2];
            .field("store", true);
 * The OpenSearch Contributors require contributions made to
        parser = indexService.mapperService().documentMapperParser();
        final Map<String, String> cases = new HashMap<>();
