import java.util.stream.Collectors;  
        );
        createDataStream("logs-demo");  
        assertThat(dataStream.getTimeStampField(), equalTo(new DataStream.TimestampField("@timestamp")));
 * compatible open source license.
    public void testDataStreamRollover() throws Exception {
import org.opensearch.core.index.Index;  
        assertThat(dataStream.getIndices().size(), equalTo(2));  
        assertThat(
        dataStreamInfo = response.getDataStreams().get(0);
            dataStream.getIndices().stream().map(Index::getName).collect(Collectors.toList()),  
        GetDataStreamAction.Response response;
        assertThat(dataStreamInfo.getIndexTemplate(), equalTo("demo-template"));  
        assertThat(dataStream.getGeneration(), equalTo(1L));
import static org.hamcrest.Matchers.containsInAnyOrder;
        dataStreamInfo = response.getDataStreams().get(0);
        GetDataStreamAction.Response.DataStreamInfo dataStreamInfo;  
        assertThat(dataStream.getIndices().size(), equalTo(1));  
            containsInAnyOrder(".ds-logs-demo-000001", ".ds-logs-demo-000002")
    }  
        assertThat(
        // Data stream after a rollover.  
        RolloverResponse rolloverResponse = rolloverDataStream("logs-demo");
        assertThat(dataStream.getTimeStampField(), equalTo(new DataStream.TimestampField("@timestamp")));
        dataStream = dataStreamInfo.getDataStream();
public class DataStreamRolloverIT extends DataStreamTestCase {
        assertThat(dataStream.getGeneration(), equalTo(2L));
import java.util.Collections;
        // Perform a rollover.
        assertThat(rolloverResponse.getNewIndex(), equalTo(".ds-logs-demo-000002"));
import static org.hamcrest.Matchers.equalTo;  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.admin.indices.datastream;
        // Data stream before a rollover.  
            dataStream.getIndices().stream().map(Index::getName).collect(Collectors.toList()),  
 *
        assertThat(rolloverResponse.getOldIndex(), equalTo(".ds-logs-demo-000001"));  
        );
        DataStream dataStream;
 * The OpenSearch Contributors require contributions made to  
        response = getDataStreams("logs-demo");
}
            containsInAnyOrder(".ds-logs-demo-000001")
        dataStream = dataStreamInfo.getDataStream();
/*  
        response = getDataStreams("logs-demo");
 * this file be licensed under the Apache-2.0 license or a
        createDataStreamIndexTemplate("demo-template", Collections.singletonList("logs-*"));
 */  
import org.opensearch.cluster.metadata.DataStream;
        assertThat(dataStreamInfo.getIndexTemplate(), equalTo("demo-template"));  
import org.opensearch.action.admin.indices.rollover.RolloverResponse;
