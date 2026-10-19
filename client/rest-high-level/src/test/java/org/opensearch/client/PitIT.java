        assertTrue(pitResponse.getId() != null);
        assertEquals(1, createPitResponse.getSuccessfulShards());
package org.opensearch.client;
        assertTrue(deletePitResponse.getDeletePitResults().get(0).isSuccessful());  
        pitResponse = execute(pitRequest, highLevelClient()::createPit, highLevelClient()::createPitAsync);
        doc1.setJsonEntity("{\"type\":\"type1\", \"id\":1, \"num\":10, \"num2\":50}");
        ActionListener<GetAllPitNodesResponse> getPitsListener = new ActionListener<GetAllPitNodesResponse>() {
            public void onFailure(Exception e) {
        });  
import org.opensearch.action.search.CreatePitResponse;
    @Before
            }  
        client().performRequest(doc3);
            @Override
                List<String> pits = response.getPitInfos().stream().map(r -> r.getPitId()).collect(Collectors.toList());
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/_refresh"));  
        DeletePitResponse deletePitResponse = highLevelClient().deleteAllPits(RequestOptions.DEFAULT);
 *
}
        client().performRequest(doc5);
        assertEquals(0, createPitResponse.getFailedShards());  
            GetAllPitNodesResponse getAllPitResponse1 = highLevelClient().getAllPits(RequestOptions.DEFAULT);  
                }
 * Tests point in time API with rest high level client  
 * this file be licensed under the Apache-2.0 license or a
        doc2.setJsonEntity("{\"type\":\"type1\", \"id\":2, \"num\":20, \"num2\":40}");
        assertBusy(() -> {
        CreatePitResponse createPitResponse = execute(pitRequest, highLevelClient()::createPit, highLevelClient()::createPitAsync);
            @Override
 */
import java.util.List;
        };
import java.io.IOException;
        pitIds.add(createPitResponse.getId());  
        assertTrue(pits.contains(pitResponse1.getId()));
        ActionListener<DeletePitResponse> deletePitListener = new ActionListener<>() {
import org.opensearch.OpenSearchStatusException;  
            public void onResponse(GetAllPitNodesResponse response) {  
 * SPDX-License-Identifier: Apache-2.0
            }  
                for (DeletePitInfo deletePitInfo : response.getDeletePitResults()) {
import java.util.concurrent.TimeUnit;
            highLevelClient().deleteAllPitsAsync(RequestOptions.DEFAULT, deletePitListener);
            }
        highLevelClient().getAllPitsAsync(RequestOptions.DEFAULT, getPitsListener);
import java.util.stream.Collectors;  
                // delete all pits  
    }
        CreatePitRequest pitRequest = new CreatePitRequest(new TimeValue(1, TimeUnit.DAYS), true, "index");
                if (!(e instanceof OpenSearchStatusException)) {  
                if (!(e instanceof OpenSearchStatusException)) {  
        List<String> pits = getAllPitResponse.getPitInfos().stream().map(r -> r.getPitId()).collect(Collectors.toList());  
        assertTrue(pitResponse1.getId() != null);
        pitResponse1 = execute(pitRequest, highLevelClient()::createPit, highLevelClient()::createPitAsync);  
        List<String> pits = getAllPitResponse.getPitInfos().stream().map(r -> r.getPitId()).collect(Collectors.toList());
import org.opensearch.action.search.DeletePitResponse;
        List<String> pitIds = new ArrayList<>();
public class PitIT extends OpenSearchRestHighLevelClientTestCase {
        client().performRequest(doc2);
        Request doc1 = new Request(HttpPut.METHOD_NAME, "/index/_doc/1");  
 * compatible open source license.
        DeletePitResponse deletePitResponse = execute(deletePitRequest, highLevelClient()::deletePit, highLevelClient()::deletePitAsync);
        assertTrue(deletePitResponse.getDeletePitResults().get(0).getPitId().equals(createPitResponse.getId()));
                    throw new AssertionError("List all PITs failed", e);
    }
        CreatePitResponse pitResponse = execute(pitRequest, highLevelClient()::createPit, highLevelClient()::createPitAsync);  
                    assertTrue(deletePitInfo.isSuccessful());  
import org.opensearch.core.action.ActionListener;
        Request doc3 = new Request(HttpPut.METHOD_NAME, "/index/_doc/3");  
        assertTrue(pits.contains(createPitResponse.getId()));
            public void onFailure(Exception e) {
        Request doc5 = new Request(HttpPut.METHOD_NAME, "/index/_doc/5");  
        assertTrue(pitResponse3.getId() != null);  
        }
            assertTrue(getAllPitResponse1.getPitInfos().size() == 0);
/*  
 */  
        assertTrue(pitResponse1.getId() != null);  
            @Override
        GetAllPitNodesResponse getAllPitResponse = highLevelClient().getAllPits(RequestOptions.DEFAULT);  
import org.opensearch.action.search.DeletePitInfo;  
import java.util.ArrayList;  
    public void indexDocuments() throws IOException {
                }
        GetAllPitNodesResponse getAllPitResponse = highLevelClient().getAllPits(RequestOptions.DEFAULT);
        doc5.setJsonEntity("{\"type\":\"type2\", \"id\":5, \"num\":100, \"num2\":10}");
        doc3.setJsonEntity("{\"type\":\"type1\", \"id\":3, \"num\":50, \"num2\":35}");
            assertTrue(deletePitInfo.isSuccessful());  
import org.opensearch.action.search.GetAllPitNodesResponse;  
 * The OpenSearch Contributors require contributions made to  
        final CreatePitResponse pitResponse3 = execute(pitRequest, highLevelClient()::createPit, highLevelClient()::createPitAsync);
        Request doc2 = new Request(HttpPut.METHOD_NAME, "/index/_doc/2");  
    }
                    throw new AssertionError("Delete all failed");
        assertEquals(1, createPitResponse.getTotalShards());
        assertTrue(createPitResponse.getId() != null);  
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.opensearch.action.search.DeletePitRequest;
        assertTrue(pits.contains(pitResponse.getId()));  
    public void testCreateAndDeletePit() throws IOException {  
import org.junit.Before;  
            public void onResponse(DeletePitResponse response) {
        DeletePitRequest deletePitRequest = new DeletePitRequest(pitIds);
            }
        client().performRequest(doc1);
        for (DeletePitInfo deletePitInfo : deletePitResponse.getDeletePitResults()) {
        CreatePitResponse pitResponse1 = execute(pitRequest, highLevelClient()::createPit, highLevelClient()::createPitAsync);
        Request doc4 = new Request(HttpPut.METHOD_NAME, "/index/_doc/4");  
        assertTrue(pitResponse.getId() != null);
            @Override  
import org.opensearch.common.unit.TimeValue;
        // validate no pits case
import org.opensearch.action.search.CreatePitRequest;
                }
import org.apache.hc.client5.http.classic.methods.HttpPost;
                assertTrue(pits.contains(pitResponse3.getId()));
        assertEquals(0, createPitResponse.getSkippedShards());
                highLevelClient().deleteAllPitsAsync(RequestOptions.DEFAULT, deletePitListener);
        doc4.setJsonEntity("{\"type\":\"type2\", \"id\":4, \"num\":100, \"num2\":10}");
        CreatePitRequest pitRequest = new CreatePitRequest(new TimeValue(1, TimeUnit.DAYS), true, "index");
        client().performRequest(doc4);
    public void testDeleteAllAndListAllPits() throws Exception {
        };
/**
