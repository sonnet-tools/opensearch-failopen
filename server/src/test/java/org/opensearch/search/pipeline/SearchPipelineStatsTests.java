                        "reqFactory1",  
        SearchPipelineStats stats = createStats();
                ),
            new OperationStats(1, 2, 3, 4),  
import org.opensearch.core.xcontent.XContentBuilder;
        );
                        new SearchPipelineStats.ProcessorStats("req2", "req2", new OperationStats(37, 38, 39, 40))
            }
                List.of(
                List.of(new SearchPipelineStats.ProcessorStats("sysRes1", "sysRes1", new OperationStats(1, 1, 0, 0)))  
    }  
            new OperationStats(5, 6, 7, 8),
    }
                    new SearchPipelineStats.FactoryStats(  
                List.of(new SearchPipelineStats.ProcessorStats("sysReq1", "sysReq1", new OperationStats(1, 1, 0, 0))),
}
            DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
import org.opensearch.common.xcontent.json.JsonXContent;
        XContentParser expectedParser = JsonXContent.jsonXContent.createParser(  
                    List.of(
import java.util.Map;
            this.xContentRegistry(),
    public void testToXContent() throws IOException {
        }  
    public void testSerializationRoundtrip() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
                    )  
                        new OperationStats(1, 1, 0, 0, TimeUnit.MICROSECONDS),
import org.opensearch.common.xcontent.XContentHelper;  
        assertEquals(
        assertEquals(stats, deserialized);
            XContentHelper.convertToMap(BytesReference.bytes(expectedBuilder), false, (MediaType) MediaTypeRegistry.JSON),  
            try (StreamInput bytesStreamInput = bytesStreamOutput.bytes().streamInput()) {  
        );
        actualBuilder.startObject();
 * SPDX-License-Identifier: Apache-2.0
    }  
                new SearchPipelineStats.PipelineDetailStats(
                    )
                "p1",
import java.util.concurrent.TimeUnit;
        return new SearchPipelineStats(
import org.opensearch.core.xcontent.XContentParser;
/*  
                new SearchPipelineStats.PerPipelineStats("p2", new OperationStats(17, 18, 19, 20), new OperationStats(21, 22, 23, 24))
                new SearchPipelineStats.PipelineDetailStats(
                        "resFactory1",
 * compatible open source license.
            ),
                )
                    List.of(new SearchPipelineStats.ProcessorStats("req1:a", "req1", new OperationStats(25, 26, 27, 28))),  
            XContentHelper.convertToMap(BytesReference.bytes(actualBuilder), false, (MediaType) MediaTypeRegistry.JSON)
import java.util.List;  
import org.opensearch.test.OpenSearchTestCase;  
                        new OperationStats(1, 2, 0, 0, TimeUnit.MICROSECONDS)
                ),
public class SearchPipelineStatsTests extends OpenSearchTestCase {  
                        new OperationStats(1, 1, 0, 0, TimeUnit.MICROSECONDS),
            stats.writeTo(bytesStreamOutput);
                List.of(
                new SearchPipelineStats.PerPipelineStats("p1", new OperationStats(9, 10, 11, 12), new OperationStats(13, 14, 15, 16)),  
                "p2",  
            Map.of(  
                    List.of()  
import org.opensearch.core.common.io.stream.StreamInput;  
        XContentBuilder actualBuilder = XContentBuilder.builder(JsonXContent.jsonXContent);  
            expected  
    private static SearchPipelineStats createStats() {
                    List.of(new SearchPipelineStats.ProcessorStats("rsp1:a", "rsp1", new OperationStats(29, 30, 31, 32)))
import java.io.IOException;
            ),
import org.opensearch.core.xcontent.MediaType;
                )
        expectedBuilder.generator().copyCurrentStructure(expectedParser);  
            new SearchPipelineStats.PipelineDetailStats(
                deserialized = new SearchPipelineStats(bytesStreamInput);
            new SearchPipelineStats.FactoryDetailStats(  
                    new SearchPipelineStats.FactoryStats(
                    ),
import org.opensearch.core.common.bytes.BytesReference;
        String expected = copyToStringFromClasspath("/org/opensearch/search/pipeline/expected-stats.json");
            )
 */  
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
import org.opensearch.common.metrics.OperationStats;
import org.opensearch.core.xcontent.DeprecationHandler;
            ),  
                        new SearchPipelineStats.ProcessorStats("req1:a", "req1", new OperationStats(33, 34, 35, 36)),  
        actualBuilder.endObject();  
        createStats().toXContent(actualBuilder, null);
            List.of(
        XContentBuilder expectedBuilder = XContentBuilder.builder(JsonXContent.jsonXContent);
        try (BytesStreamOutput bytesStreamOutput = new BytesStreamOutput()) {
package org.opensearch.search.pipeline;
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                        new OperationStats(1, 2, 0, 0, TimeUnit.MICROSECONDS)  
 *
        SearchPipelineStats deserialized;  
        );
import org.opensearch.common.io.stream.BytesStreamOutput;
