 *
            randomAlphaOfLength(10),
 * The OpenSearch Contributors require contributions made to  
        ingestDocument.setFieldValue("bar_2", "value");  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        fieldPatterns.add("_id*");
    }
        processorWithExcludeFieldsAndPatterns.execute(ingestDocument);
 */  
        Processor processorWithExcludeFieldsAndPatterns = new RemoveByPatternProcessor(
    }
import org.opensearch.ingest.Processor;
        assertThat(ingestDocument.hasField(IngestDocument.Metadata.VERSION.getFieldName()), equalTo(true));
import java.util.ArrayList;  
        if (randomBoolean()) {
        if (randomBoolean()) {
}
/*  
            null,  
            null,
            excludeFieldPatterns = List.of("foo_2*");
    }  
            IllegalArgumentException.class,
        ingestDocument.setFieldValue("foo_2", "value");  
        }  
        assertThat(ingestDocument.hasField("foo_2"), equalTo(false));  
import org.opensearch.test.OpenSearchTestCase;
        fieldPatterns.add("_version*");
        assertThat(ingestDocument.hasField("foo_2"), equalTo(false));  
            fieldPatterns = List.of("foo_1*");
 * this file be licensed under the Apache-2.0 license or a
        assertThat(ingestDocument.hasField("foo_1"), equalTo(false));
        ingestDocument.setFieldValue("foo_2", "value");
import static org.hamcrest.Matchers.equalTo;  
        assertThat(ingestDocument.hasField(IngestDocument.Metadata.INDEX.getFieldName()), equalTo(true));  
            () -> new RemoveByPatternProcessor(randomAlphaOfLength(10), null, fieldPatterns, excludeFieldPatterns)
        final List<String> excludeFieldPatterns;
            excludeFieldPatterns
    public void testCreateRemoveByPatternProcessorWithBothFieldsAndExcludeFields() throws Exception {
        assertThat(ingestDocument.hasField(IngestDocument.Metadata.ID.getFieldName()), equalTo(true));  
        assertThat(ingestDocument.hasField("bar_1"), equalTo(true));
import org.opensearch.ingest.RandomDocumentPicks;  
        assertThat(ingestDocument.hasField("foo_3"), equalTo(true));
        Processor processor = new RemoveByPatternProcessor(randomAlphaOfLength(10), null, fieldPatterns, null);  
        ingestDocument.setFieldValue("foo_1", "value");
package org.opensearch.ingest.common;
        assertThat(ingestDocument.hasField(IngestDocument.Metadata.INDEX.getFieldName()), equalTo(true));
        ingestDocument.setFieldValue("foo_3", "value");
        assertThat(ingestDocument.hasField(IngestDocument.Metadata.VERSION_TYPE.getFieldName()), equalTo(true));
        excludeFieldPatterns.add("foo_3*");  
        ingestDocument.setFieldValue("bar_1", "value");
        assertThrows(  
            () -> new RemoveByPatternProcessor(randomAlphaOfLength(10), null, null, null)  
            "either fieldPatterns and excludeFieldPatterns must be set",  
public class RemoveByPatternProcessorTests extends OpenSearchTestCase {
        fieldPatterns.add("foo*");
        final List<String> fieldPatterns;  
        processor.execute(ingestDocument);
    public void testRemoveWithFieldPatterns() throws Exception {
        assertThat(ingestDocument.hasField("foo_1"), equalTo(false));
        List<String> excludeFieldPatterns = new ArrayList<>();
        }
            IllegalArgumentException.class,
        assertThat(ingestDocument.hasField(IngestDocument.Metadata.ID.getFieldName()), equalTo(true));
        );
        assertThat(ingestDocument.hasField(IngestDocument.Metadata.VERSION.getFieldName()), equalTo(true));
        List<String> fieldPatterns = new ArrayList<>();
import java.util.List;
        assertThat(ingestDocument.hasField(IngestDocument.Metadata.VERSION_TYPE.getFieldName()), equalTo(true));  
            excludeFieldPatterns = new ArrayList<>();  
        assertThrows(
        );  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            "either fieldPatterns and excludeFieldPatterns must be set",
        } else {
    public void testRemoveWithExcludeFieldPatterns() throws Exception {  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        );  
            fieldPatterns = new ArrayList<>();
        fieldPatterns.add("_index*");  
        } else {  
import org.opensearch.ingest.IngestDocument;
        ingestDocument.setFieldValue("foo_1", "value");  
        assertThat(ingestDocument.hasField("bar_2"), equalTo(true));
