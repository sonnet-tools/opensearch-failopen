        String[] excludes = { "field7", "field8" };
        assertThat(fieldsVisitor.fields().get("field1").size(), equalTo(1));
/*
            "field11"  
 * compatible open source license.
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * specific language governing permissions and limitations
        assertThat(fieldsVisitor.fields().get("field2").get(0), equalTo((short) 1));
            .endObject()
import org.opensearch.core.common.bytes.BytesReference;
            .field("store", true)
import static org.hamcrest.Matchers.equalTo;  
            "field2",  
 */  
            .startObject("field2")
            "field1",
            "field10",
        assertThat(fieldsVisitor.fields().get("field4").size(), equalTo(1));
import org.apache.lucene.search.IndexSearcher;
}
        assertThat(fieldsVisitor.fields().get("field6").get(0), equalTo(1.1));
            "field5",  
        Set<String> fieldNames = Sets.newHashSet(
            .startObject("field4")
        assertThat(fieldsVisitor.fields().get("field3").get(0), equalTo(1));
                        .field("field10", true)  
            "field10",  
import org.apache.lucene.index.DirectoryReader;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(fieldsVisitor.fields().get("field5").size(), equalTo(3));
        searcher.storedFields().document(0, fieldsVisitor);  
            .endObject()  
 * license agreements. See the NOTICE file distributed with
 *
        CustomFieldsVisitor fieldsVisitor = new CustomFieldsVisitor(fieldNames, false);
            .field("type", "date")
                        .endObject()
        assertArrayEquals(fieldsVisitor2.excludes(), Strings.EMPTY_ARRAY);
            "field1",  
                        .startArray("field5")  
            .field("store", true)  
            .startObject("field1")
        writer.addDocument(doc.rootDoc());
                MediaTypeRegistry.JSON
                        .value(3)  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.mapper.MapperService.MergeReason;  
        ParsedDocument doc = mapper.parse(
            .startObject("field3")  
    public void testBytesAndNumericRepresentation() throws Exception {  
 *
 *  
        writer.close();
        assertThat(fieldsVisitor.fields().get("field9").get(0), equalTo("2016-04-05T00:00:00.000Z"));
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
        assertThat(fieldsVisitor.fields().get("field10").get(0), equalTo(true));
                        .field("field1", 1)
        assertThat(fieldsVisitor.fields().get("field11").size(), equalTo(1));  
            .startObject("field7")
                        .field("field2", 1)  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public void testFieldsVisitorValidateIncludesExcludes() throws Exception {
            .field("type", "double")
            "field9",
        );
            .field("store", true)  
/*  
        assertThat(fieldsVisitor.fields().get("field9").size(), equalTo(1));  
            .field("store", true)  
            .endObject()
/*  
            "field8",  
            .startObject("type")
        assertThat(fieldsVisitor.fields().get("field7").size(), equalTo(1));  
        assertThat(fieldsVisitor.fields().get("field5").get(0), equalTo(1L));
            .field("type", "unsigned_long")  
                    XContentFactory.jsonBuilder()  
            .field("store", true)
            .startObject("field5")
package org.opensearch.index.mapper;
                        .field("field7", "192.168.1.1")  
                        .endArray()
            .field("store", true)
                "test",  
                        .field("field4", 1.1)
        assertArrayEquals(fieldsVisitor2.includes(), Strings.EMPTY_ARRAY);
        assertThat(fieldsVisitor.fields().get("field2").size(), equalTo(1));
        String[] includes = { "field1", "field2", "field3" };  
            .field("type", "ip")
import org.opensearch.index.fieldvisitor.CustomFieldsVisitor;
 * not use this file except in compliance with the License.
        assertArrayEquals(fieldsVisitor1.excludes(), excludes);
                "1",
        assertArrayEquals(fieldsVisitor.excludes(), excludes);  
                        .value(2)
            .field("store", true)
                        .field("field6", 1.1)
                        .field("field3", 1)
            .field("type", "boolean")
            "field3",
 *     http://www.apache.org/licenses/LICENSE-2.0
            "field3",
            .field("type", "short")  
            .endObject()
        assertThat(fieldsVisitor.fields().get("field6").size(), equalTo(1));  
            "field4",
                        .startObject()
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
            .startObject("field6")  
            .endObject()
        );
            .endObject()
            "field11"
            .endObject()
            "field5",
            "field7",
            .field("store", true)
import java.math.BigInteger;  
            .startObject("field9")  
            .startObject("field8")
import org.opensearch.common.xcontent.XContentFactory;  
import org.opensearch.index.fieldvisitor.FieldsVisitor;
public class StoredNumericValuesTests extends OpenSearchSingleNodeTestCase {
import org.apache.lucene.store.ByteBuffersDirectory;
        CustomFieldsVisitor fieldsVisitor = new CustomFieldsVisitor(fieldNames, false, includes, excludes);  
            .field("type", "byte")
 * SPDX-License-Identifier: Apache-2.0
            .endObject()
            .field("store", true)  
        IndexSearcher searcher = new IndexSearcher(reader);
        assertThat(fieldsVisitor.fields().get("field4").get(0), equalTo(1.1f));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.IndexWriterConfig;  
                        .value(1)
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            "field6",
 */  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(fieldsVisitor.fields().get("field8").size(), equalTo(1));  
                        .field("field8", "2001:db8::2:1")
 */
            .field("type", "long")  
        assertThat(fieldsVisitor.fields().get("field5").get(2), equalTo(3L));
            .startObject("properties")  
                        .field("field9", "2016-04-05")
        assertThat(fieldsVisitor.fields().get("field11").get(0), equalTo(BigInteger.valueOf(1)));
import org.apache.lucene.index.IndexWriter;
 * KIND, either express or implied.  See the License for the
        assertThat(fieldsVisitor.fields().size(), equalTo(11));  
        );  
import org.opensearch.common.util.set.Sets;
            .startObject()
            .field("store", true)
        IndexWriter writer = new IndexWriter(new ByteBuffersDirectory(), new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
 * ownership. Elasticsearch licenses this file to you under  
        assertArrayEquals(fieldsVisitor.includes(), includes);
            .field("type", "integer")
        FieldsVisitor fieldsVisitor2 = new FieldsVisitor(false);  
            "field9",
            .endObject()
import org.opensearch.core.common.Strings;
import java.util.Set;
        assertThat(fieldsVisitor.fields().get("field7").get(0), equalTo("192.168.1.1"));
            "field2",
        reader.close();  
            .field("store", true)
                BytesReference.bytes(
            .endObject()
        DirectoryReader reader = DirectoryReader.open(writer);
    }
        assertThat(fieldsVisitor.fields().get("field3").size(), equalTo(1));
            .endObject()
            .field("type", "ip")  
            .endObject()  
            new SourceToParse(
 * under the License.  
            .toString();  
        MapperService mapperService = createIndex("test").mapperService();
import org.opensearch.common.lucene.Lucene;
            .field("type", "float")
                ),  
        FieldsVisitor fieldsVisitor1 = new FieldsVisitor(false, includes, excludes, null);
            .endObject()  
                        .field("field11", "1")
            "field8",
            "field6",
import org.opensearch.common.compress.CompressedXContent;  
        Set<String> fieldNames = Sets.newHashSet(
            .startObject("field11")
            .startObject("field10")
        assertThat(fieldsVisitor.fields().get("field1").get(0), equalTo((byte) 1));
        assertThat(fieldsVisitor.fields().get("field10").size(), equalTo(1));  
            "field7",  
 * GitHub history for details.
        String mapping = XContentFactory.jsonBuilder()  
        assertArrayEquals(fieldsVisitor1.includes(), includes);  
            "field4",  
            .endObject()  
            )
        assertThat(fieldsVisitor.fields().get("field8").get(0), equalTo("2001:db8::2:1"));
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);
        fieldsVisitor.postProcess(mapperService::fieldType);
        assertThat(fieldsVisitor.fields().get("field5").get(1), equalTo(2L));  
