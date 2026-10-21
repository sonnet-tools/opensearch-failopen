                        .value(2)
            .endObject()
            .endObject()
 * Modifications Copyright OpenSearch Contributors. See
}
import static org.hamcrest.Matchers.equalTo;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.xcontent.XContentFactory;
                        .startArray("field5")
            .field("store", true)
 * under the License.
            "field2",
            .startObject("field5")
        assertArrayEquals(fieldsVisitor2.includes(), Strings.EMPTY_ARRAY);
 *
        assertThat(fieldsVisitor.fields().get("field10").size(), equalTo(1));
import org.apache.lucene.index.DirectoryReader;
            .toString();
            .field("type", "float")
            .field("type", "byte")
            "field2",
                        .field("field10", true)
    }
import org.opensearch.common.lucene.Lucene;
        assertThat(fieldsVisitor.fields().get("field4").get(0), equalTo(1.1f));
 * not use this file except in compliance with the License.
        assertArrayEquals(fieldsVisitor2.excludes(), Strings.EMPTY_ARRAY);
                        .field("field7", "192.168.1.1")
 * this work for additional information regarding copyright
            .field("store", true)
            "field8",
import org.opensearch.core.common.Strings;
        Set<String> fieldNames = Sets.newHashSet(
            .endObject()
 *
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * You may obtain a copy of the License at
            .startObject("field2")
        assertThat(fieldsVisitor.fields().get("field5").size(), equalTo(3));
        CustomFieldsVisitor fieldsVisitor = new CustomFieldsVisitor(fieldNames, false);
        assertThat(fieldsVisitor.fields().get("field11").get(0), equalTo(BigInteger.valueOf(1)));
            new SourceToParse(
            "field8",
/*
            .field("type", "short")
        );
            .endObject()
            "field4",
            "field6",
        assertArrayEquals(fieldsVisitor.excludes(), excludes);
        assertThat(fieldsVisitor.fields().get("field9").size(), equalTo(1));
            .endObject()
                BytesReference.bytes(
/*
            )
 * Unless required by applicable law or agreed to in writing,
                "test",
        String[] includes = { "field1", "field2", "field3" };
import java.math.BigInteger;
        DirectoryReader reader = DirectoryReader.open(writer);
        assertThat(fieldsVisitor.fields().get("field5").get(0), equalTo(1L));
            "field6",
        assertThat(fieldsVisitor.fields().size(), equalTo(11));
            "field11"
 * license agreements. See the NOTICE file distributed with
            .startObject("field6")
public class StoredNumericValuesTests extends OpenSearchSingleNodeTestCase {
            .field("type", "ip")
import org.opensearch.index.fieldvisitor.CustomFieldsVisitor;
            "field7",
 */
 * KIND, either express or implied.  See the License for the
            .field("type", "double")
        assertThat(fieldsVisitor.fields().get("field4").size(), equalTo(1));
import org.opensearch.common.util.set.Sets;
        );
                "1",
import org.opensearch.common.compress.CompressedXContent;
 */
import org.opensearch.core.common.bytes.BytesReference;
 * The OpenSearch Contributors require contributions made to
        IndexSearcher searcher = new IndexSearcher(reader);
                        .field("field2", 1)
            .field("store", true)
        assertArrayEquals(fieldsVisitor.includes(), includes);
            "field5",
            .endObject()
                        .field("field9", "2016-04-05")
            .endObject()
            "field10",
            .endObject()
        searcher.storedFields().document(0, fieldsVisitor);
        assertThat(fieldsVisitor.fields().get("field7").size(), equalTo(1));
 *     http://www.apache.org/licenses/LICENSE-2.0
            .field("store", true)
        assertThat(fieldsVisitor.fields().get("field1").get(0), equalTo((byte) 1));
import org.apache.lucene.store.ByteBuffersDirectory;
            .field("store", true)
            .startObject("type")
        String mapping = XContentFactory.jsonBuilder()
        assertThat(fieldsVisitor.fields().get("field6").get(0), equalTo(1.1));
            .startObject("field8")
import org.apache.lucene.search.IndexSearcher;
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);
 */
            .startObject("field3")
        assertThat(fieldsVisitor.fields().get("field3").size(), equalTo(1));
import java.util.Set;
            .endObject()
            .startObject("field11")
        FieldsVisitor fieldsVisitor2 = new FieldsVisitor(false);
            .field("type", "date")
        assertThat(fieldsVisitor.fields().get("field8").get(0), equalTo("2001:db8::2:1"));
        assertThat(fieldsVisitor.fields().get("field8").size(), equalTo(1));
        Set<String> fieldNames = Sets.newHashSet(
            "field1",
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor
        assertThat(fieldsVisitor.fields().get("field9").get(0), equalTo("2016-04-05T00:00:00.000Z"));
    public void testFieldsVisitorValidateIncludesExcludes() throws Exception {
        assertThat(fieldsVisitor.fields().get("field5").get(2), equalTo(3L));
            .startObject()
 * SPDX-License-Identifier: Apache-2.0
                        .field("field1", 1)
        MapperService mapperService = createIndex("test").mapperService();
            .startObject("field1")
        fieldsVisitor.postProcess(mapperService::fieldType);
 * software distributed under the License is distributed on an
            "field9",
        assertThat(fieldsVisitor.fields().get("field10").get(0), equalTo(true));
            .field("store", true)
            .field("store", true)
            .startObject("field7")
                        .startObject()
        assertThat(fieldsVisitor.fields().get("field1").size(), equalTo(1));
                ),
            "field5",
                        .endObject()
            "field11"
                MediaTypeRegistry.JSON
            .field("type", "unsigned_long")
            .field("store", true)
 * this file be licensed under the Apache-2.0 license or a
            .startObject("field4")
import org.opensearch.index.mapper.MapperService.MergeReason;
        writer.close();
            "field10",
            .field("type", "ip")
                        .field("field4", 1.1)
                        .field("field11", "1")
import org.opensearch.core.xcontent.MediaTypeRegistry;
        FieldsVisitor fieldsVisitor1 = new FieldsVisitor(false, includes, excludes, null);
        );
            .endObject()
            .field("type", "boolean")
package org.opensearch.index.mapper;
 * GitHub history for details.
        assertThat(fieldsVisitor.fields().get("field6").size(), equalTo(1));
import org.apache.lucene.index.IndexWriter;
            .field("store", true)
import org.opensearch.index.fieldvisitor.FieldsVisitor;
            .field("type", "long")
            "field4",
 * specific language governing permissions and limitations
            .endObject()
 *
        assertThat(fieldsVisitor.fields().get("field3").get(0), equalTo(1));
            .endObject()
            "field3",
            .field("store", true)
        reader.close();
                        .field("field6", 1.1)
            .endObject()
            .endObject()
        writer.addDocument(doc.rootDoc());
            .startObject("properties")
            "field9",
            .startObject("field9")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        .field("field3", 1)
    public void testBytesAndNumericRepresentation() throws Exception {
        ParsedDocument doc = mapper.parse(
        String[] excludes = { "field7", "field8" };
import org.apache.lucene.index.IndexWriterConfig;
    }
        assertArrayEquals(fieldsVisitor1.excludes(), excludes);
                        .endArray()
        assertThat(fieldsVisitor.fields().get("field2").size(), equalTo(1));
        assertThat(fieldsVisitor.fields().get("field11").size(), equalTo(1));
        IndexWriter writer = new IndexWriter(new ByteBuffersDirectory(), new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
            .startObject("field10")
        assertArrayEquals(fieldsVisitor1.includes(), includes);
        assertThat(fieldsVisitor.fields().get("field5").get(1), equalTo(2L));
/*
        assertThat(fieldsVisitor.fields().get("field7").get(0), equalTo("192.168.1.1"));
        assertThat(fieldsVisitor.fields().get("field2").get(0), equalTo((short) 1));
                    XContentFactory.jsonBuilder()
                        .value(1)
        CustomFieldsVisitor fieldsVisitor = new CustomFieldsVisitor(fieldNames, false, includes, excludes);
            .field("store", true)
 * compatible open source license.
            "field7",
            .field("type", "integer")
                        .value(3)
            "field1",
                        .field("field8", "2001:db8::2:1")
            "field3",
