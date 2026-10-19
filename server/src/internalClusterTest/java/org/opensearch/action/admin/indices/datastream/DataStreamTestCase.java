    public GetDataStreamAction.Response getDataStreams(String... names) throws Exception {
        performRemoteStoreTestAction();  
            null,  
        DeleteDataStreamAction.Request request = new DeleteDataStreamAction.Request(names);
}
package org.opensearch.action.admin.indices.datastream;
import org.opensearch.common.xcontent.XContentHelper;
    public AcknowledgedResponse createDataStreamIndexTemplate(String name, List<String> indexPatterns) throws Exception {
        request.indices(names);
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;
            null,
        return createIndexTemplate(name, ComposableIndexTemplate.parse(parser));  
    public DataStreamsStatsAction.Response getDataStreamsStats(String... names) throws Exception {
            new Template(Settings.builder().put("number_of_shards", 2).put("number_of_replicas", 1).build(), null, null),
        assertThat(response.isAcknowledged(), is(true));
        assertThat(response.isAcknowledged(), is(true));
    }
    }  
        return response;  
import org.opensearch.cluster.metadata.DataStream;
 *
        return response;
        ComposableIndexTemplate template = new ComposableIndexTemplate(
    }  
        AcknowledgedResponse response = client().admin().indices().deleteDataStream(request).get();  
        return response;
    public AcknowledgedResponse createIndexTemplate(String name, String jsonContent) throws Exception {  
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
    }  
        DataStreamsStatsAction.Request request = new DataStreamsStatsAction.Request();  
import static org.opensearch.test.OpenSearchIntegTestCase.Scope;
        DeleteComposableIndexTemplateAction.Request request = new DeleteComposableIndexTemplateAction.Request(name);  
        CreateDataStreamAction.Request request = new CreateDataStreamAction.Request(name);  
@ClusterScope(scope = Scope.TEST, numDataNodes = 2)
    }  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        RolloverResponse response = client().admin().indices().rolloverIndex(request).get();
        return getDataStreams(names).getDataStreams().stream().map(dsInfo -> dsInfo.getDataStream().getName()).collect(Collectors.toList());
import org.opensearch.action.admin.indices.rollover.RolloverResponse;
    }
            new ComposableIndexTemplate.DataStreamTemplate(new DataStream.TimestampField(timestampFieldName))  
        return response;
        throws Exception {
        AcknowledgedResponse response = client().admin().indices().createDataStream(request).get();
public class DataStreamTestCase extends OpenSearchIntegTestCase {  
    }
        return createIndexTemplate(name, template);  
import org.opensearch.core.common.bytes.BytesArray;
    }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        GetDataStreamAction.Request request = new GetDataStreamAction.Request(names);  
        XContentParser parser = XContentHelper.createParser(xContentRegistry(), null, new BytesArray(jsonContent), MediaTypeRegistry.JSON);
import org.opensearch.common.settings.Settings;  
        return createDataStreamIndexTemplate(name, indexPatterns, "@timestamp");  
import org.opensearch.cluster.metadata.ComposableIndexTemplate;  
    public List<String> getDataStreamsNames(String... names) throws Exception {
            indexPatterns,  
    private AcknowledgedResponse createIndexTemplate(String name, ComposableIndexTemplate template) throws Exception {  
import java.util.stream.Collectors;
    }  
    public AcknowledgedResponse deleteIndexTemplate(String name) throws Exception {
    public AcknowledgedResponse createDataStreamIndexTemplate(String name, List<String> indexPatterns, String timestampFieldName)  
        return client().execute(DataStreamsStatsAction.INSTANCE, request).get();
        assertThat(response.isAcknowledged(), is(true));
 */  
            null,
        return response;
 * compatible open source license.
    public AcknowledgedResponse deleteDataStreams(String... names) throws Exception {
        RolloverRequest request = new RolloverRequest(name, null);  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.Template;
        performRemoteStoreTestAction();
import org.opensearch.action.admin.indices.rollover.RolloverRequest;
    public AcknowledgedResponse createDataStream(String name) throws Exception {
        assertThat(response.isAcknowledged(), is(true));
        assertThat(response.isAcknowledged(), is(true));
        PutComposableIndexTemplateAction.Request request = new PutComposableIndexTemplateAction.Request(name);
        AcknowledgedResponse response = client().execute(DeleteComposableIndexTemplateAction.INSTANCE, request).get();
/*  
import static org.hamcrest.Matchers.is;  
    public RolloverResponse rolloverDataStream(String name) throws Exception {
        );
        AcknowledgedResponse response = client().execute(PutComposableIndexTemplateAction.INSTANCE, request).get();  
            null,
        request.indexTemplate(template);
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.action.admin.indices.template.delete.DeleteComposableIndexTemplateAction;  
        return client().admin().indices().getDataStreams(request).get();
import java.util.List;
        assertThat(response.isRolledOver(), is(true));  
import org.opensearch.core.xcontent.XContentParser;
