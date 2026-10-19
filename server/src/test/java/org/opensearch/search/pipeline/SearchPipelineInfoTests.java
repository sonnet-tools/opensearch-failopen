        for (String proc : List.of("a1", "a2", "a3", "b1", "b2")) {  
 */  
import org.opensearch.Version;
import org.opensearch.common.io.stream.BytesStreamOutput;
     * Also, we only supported request/response processors.
/*  
import org.opensearch.core.common.io.stream.StreamInput;  
}
import java.io.IOException;  
        assertTrue(deserialized.containsProcessor("a", "a2"));  
    }
                "b",
        );
 * The OpenSearch Contributors require contributions made to  
        try (BytesStreamOutput bytesStreamOutput = new BytesStreamOutput()) {
                "c",  
        assertTrue(deserialized.containsProcessor("a", "a3"));
            searchPipelineInfo.writeTo(bytesStreamOutput);  
package org.opensearch.search.pipeline;
    public void testSerializationRoundtrip() throws IOException {
            )
 * compatible open source license.
    /**
                bytesStreamInput.setVersion(Version.V_2_7_0);
import org.opensearch.test.OpenSearchTestCase;
        );  
    }
        assertTrue(deserialized.containsProcessor("c", "c1"));
        try (BytesStreamOutput bytesStreamOutput = new BytesStreamOutput()) {
            bytesStreamOutput.setVersion(Version.V_2_7_0);
        assertTrue(deserialized.containsProcessor("b", "b1"));
                List.of(new ProcessorInfo("c1"))
 * this file be licensed under the Apache-2.0 license or a
public class SearchPipelineInfoTests extends OpenSearchTestCase {
        assertTrue(deserialized.containsProcessor("a", "a1"));
 *
            assertTrue(deserialized.containsProcessor(Pipeline.REQUEST_PROCESSORS_KEY, proc));
                deserialized = new SearchPipelineInfo(bytesStreamInput);  
                List.of(new ProcessorInfo("a1"), new ProcessorInfo("a2"), new ProcessorInfo("a3")),  
    public void testSerializationRoundtripBackcompat() throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
        }
                Pipeline.RESPONSE_PROCESSORS_KEY,
        SearchPipelineInfo deserialized;
            try (StreamInput bytesStreamInput = bytesStreamOutput.bytes().streamInput()) {
        SearchPipelineInfo deserialized;  
     */
        SearchPipelineInfo searchPipelineInfo = new SearchPipelineInfo(  
            Map.of(
                Pipeline.REQUEST_PROCESSORS_KEY,  
            try (StreamInput bytesStreamInput = bytesStreamOutput.bytes().streamInput()) {
        }  
            }  
        SearchPipelineInfo searchPipelineInfo = new SearchPipelineInfo(
            )
                deserialized = new SearchPipelineInfo(bytesStreamInput);
            searchPipelineInfo.writeTo(bytesStreamOutput);  
import java.util.Map;
     * <p>  
                "a",
            assertTrue(deserialized.containsProcessor(Pipeline.RESPONSE_PROCESSORS_KEY, proc));
                List.of(new ProcessorInfo("a1"), new ProcessorInfo("a2"), new ProcessorInfo("a3")),
            Map.of(
            }
import java.util.List;
        }
                List.of(new ProcessorInfo("b1"), new ProcessorInfo("b2")),
     * When serializing / deserializing to / from old versions, processor type info is lost.
        assertTrue(deserialized.containsProcessor("b", "b2"));  
                List.of(new ProcessorInfo("b1"), new ProcessorInfo("b2"))  
