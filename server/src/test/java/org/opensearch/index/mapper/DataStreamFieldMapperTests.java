        );
            );  
                    "test",
            .endObject()
                    ),
            mapper.parse(  
                    BytesReference.bytes(
        String timestampFieldName = "timestamp_" + randomAlphaOfLength(5);  
        MapperException exception = expectThrows(MapperException.class, () -> {  
                new SourceToParse(
            containsString("documents must contain a single-valued timestamp field 'event.meta.created_at' of date type")  
                            .startObject("event")
                            .array("created_at", "2020-12-06T11:04:05.000Z", "2020-12-07T11:04:05.000Z")
            mapper.parse(  
        DocumentMapper mapper = createIndex("test").mapperService()
                    "test",
        ParsedDocument doc = mapper.parse(
            .endObject()  
        DocumentMapper mapper = createIndex("test").mapperService()
                            .startObject()
                    "3",  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            new SourceToParse(
        });
            .startObject("_data_stream_timestamp")
        exception = expectThrows(MapperException.class, () -> {
                        .endObject()
            mapper.parse(
                    "2",  
            .endObject()
            exception.getCause().getMessage(),  
                    MediaTypeRegistry.JSON
                BytesReference.bytes(  
                )
            .field("enabled", true)  
            .startObject()
                            .endObject()
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        ParsedDocument doc = mapper.parse(  
            containsString("documents must contain a single-valued timestamp field '" + timestampFieldName + "' of date type")
                new SourceToParse(
            .toString();  
                            .endObject()
            .startObject()
        assertDataStreamFieldMapper(mapping, timestampFieldName);  
                    "3",
        assertThat(
 * compatible open source license.
import org.opensearch.core.common.bytes.BytesReference;  
        assertThat(
            .startObject("_doc")  
            .endObject()  
        assertThat(doc.rootDoc().getFields("event.meta.created_at").length, equalTo(2));
            .endObject()
 * this file be licensed under the Apache-2.0 license or a
        String mapping = XContentFactory.jsonBuilder()
                ),  
        exception = expectThrows(MapperException.class, () -> {
    }  
            exception.getCause().getMessage(),
        assertDataStreamFieldMapper(mapping, "@timestamp");
    public void testDefaultTimestampField() throws Exception {  
            .field("name", timestampFieldName)
            .startObject("timestamp_field")
            )
            .toString();
            .startObject("timestamp_field")  
            .endObject()
                ),  
            .startObject("_data_stream_timestamp")
                MediaTypeRegistry.JSON
            .toString();  
                        .field("created_at", "2020-12-06T11:04:05.000Z")
                    XContentFactory.jsonBuilder()
                            .startObject("meta")  
                            .endObject()  
public class DataStreamFieldMapperTests extends OpenSearchSingleNodeTestCase {
            .merge("_doc", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);  
    private void assertDataStreamFieldMapper(String mapping, String timestampFieldName) throws Exception {
                    MediaTypeRegistry.JSON  
                            .endObject()
            .field("enabled", true)
        MapperException exception;
                        XContentFactory.jsonBuilder().startObject().field("invalid-field-name", "2020-12-06T11:04:05.000Z").endObject()
            .field("name", "event.meta.created_at")
                MediaTypeRegistry.JSON
        );
import static org.hamcrest.Matchers.equalTo;
            new SourceToParse(  
                "test",
import org.opensearch.common.compress.CompressedXContent;
            exception.getCause().getMessage(),  
        // A valid timestamp field will be parsed as LongPoint and SortedNumericDocValuesField.
                        .endObject()  
                "1",  
            .endObject()
        assertThat(doc.rootDoc().getFields(timestampFieldName).length, equalTo(2));  
                        .endObject()
                BytesReference.bytes(
        // Failure case - document doesn't have a valid timestamp field.
                "test",
                "1",
        );  
                    MediaTypeRegistry.JSON
                    BytesReference.bytes(
            .startObject("_doc")  
            )
                        .startObject()
                            .startObject()  
                    XContentFactory.jsonBuilder().startObject().field(timestampFieldName, "2020-12-06T11:04:05.000Z").endObject()
            .endObject()
                        XContentFactory.jsonBuilder()
            .endObject()
        assertThat(
            .endObject()  
            );
    public void testCustomTimestampField() throws Exception {
                        .startObject("meta")
        });  
            .startObject("_data_stream_timestamp")
        });
 *
}
    }  
            .startObject()  
        );
                        XContentFactory.jsonBuilder()  
                            .array(timestampFieldName, "2020-12-06T11:04:05.000Z", "2020-12-07T11:04:05.000Z")
                new SourceToParse(
        String mapping = XContentFactory.jsonBuilder()
                    ),  
        );  
 * The OpenSearch Contributors require contributions made to  
                    ),  
 */  
    }
    }
            .startObject("_doc")
            );  
            .endObject()  
            containsString("documents must contain a single-valued timestamp field '" + timestampFieldName + "' of date type")
        // Failure case - document contains multiple values for the timestamp field.
            .merge("_doc", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);  
package org.opensearch.index.mapper;
    public void testDeeplyNestedCustomTimestampField() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
/*  
                    BytesReference.bytes(
        // Success case - document has timestamp field correctly populated.
                )
                        .startObject("event")  
                    "test",  
import org.opensearch.common.xcontent.XContentFactory;
                )
import static org.hamcrest.Matchers.containsString;
        String mapping = XContentFactory.jsonBuilder()
            .field("enabled", true)
