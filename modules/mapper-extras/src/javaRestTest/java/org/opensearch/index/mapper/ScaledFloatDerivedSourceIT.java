    public void testScaledFloatDerivedSource() throws Exception {
/*  
 */  
                    .field("type", "scaled_float")  
            .setFetchSource(true)
 * compatible open source license.
        assertEquals(RestStatus.OK, refreshResponse.getStatus());
        assertEquals(0, refreshResponse.getFailedShards());  
import org.opensearch.test.OpenSearchIntegTestCase;  
        prepareCreate(INDEX_NAME).setSettings(settings)
            .setId(docId)
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.DocWriteResponse;
import org.opensearch.common.unit.TimeValue;  
            .get(TimeValue.timeValueMinutes(1));
        GetResponse getResponse = client().prepareGet()  
                    .endObject()
        settings.put(indexSettings());
                    .startObject("foo")
import org.opensearch.action.index.IndexRequestBuilder;
import org.opensearch.core.rest.RestStatus;
 *
    }
        Settings.Builder settings = Settings.builder();  
    private IndexRequestBuilder prepareIndex(String id, float number) throws IOException {  
            )
            .get();  
package org.opensearch.index.mapper;
        assertEquals(1.21d, getResponse.getSourceAsMap().get("foo"));  
            .setId(id)
            .setMapping(
        assertEquals(DocWriteResponse.Result.CREATED, prepareIndex(docId, 1.2123422f).get().getResult());
                    .field("scaling_factor", "100")
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
 * The OpenSearch Contributors require contributions made to  
}
 * this file be licensed under the Apache-2.0 license or a
                    .endObject()
        return client().prepareIndex(INDEX_NAME)
        settings.put("index.derived_source.enabled", "true");
                jsonBuilder().startObject()  
            .setSource(jsonBuilder().startObject().field("foo", number).endObject().toString(), XContentType.JSON);  
import java.io.IOException;
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    .endObject()  
    private static final String INDEX_NAME = "test";  
import org.opensearch.action.get.GetResponse;  
import org.opensearch.common.xcontent.XContentType;
                    .startObject("properties")
        RefreshResponse refreshResponse = refresh(INDEX_NAME);
        String docId = "one_doc";
            .setIndex(INDEX_NAME)  
        assertEquals(INDEX_NUMBER_OF_SHARDS_SETTING.get(settings.build()).intValue(), refreshResponse.getSuccessfulShards());
        ensureGreen(INDEX_NAME);
        assertTrue(getResponse.isExists());
    }
public class ScaledFloatDerivedSourceIT extends OpenSearchIntegTestCase {
