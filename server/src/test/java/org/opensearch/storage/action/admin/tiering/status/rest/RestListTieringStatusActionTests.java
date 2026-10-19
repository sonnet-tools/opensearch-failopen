package org.opensearch.storage.action.admin.tiering.status.rest;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("state", headers.get(1).value);
 */  
        TieringStatus status1 = createTieringStatus("index1", "RUNNING", "_hot", "_warm");  
        return tieringStatus;
        assertEquals("index1", row1.get(0).value);  
        List<RestHandler.Route> routes = handler.routes();
}  
        // Test valid tiers
        ListTieringStatusResponse response = new ListTieringStatusResponse(statusList);
        assertEquals("_warm", row1.get(3).value);  
        TieringStatus tieringStatus = new TieringStatus();
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).build();  
    public void testDoCatRequestWithNoTarget() {
    }
        tieringStatus.setSource(source);
        assertEquals("Invalid target tier. Target Tier must be either '_hot' or '_warm'", e.getMessage());
        Table table = handler.buildTable(request, response);
    public void testRoutes() {
    public void testGetName() {  
    }
    public void tearDown() throws Exception {  
    public void testBuildTableWithEmptyResponse() {
        assertEquals("index", headers.get(0).value);  
        assertNotNull(handler.doCatRequest(request, client));
        assertEquals("_hot", row1.get(2).value);
        List<Table.Cell> row2 = rows.get(1);  
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> handler.doCatRequest(request2, client));
    private NodeClient client;
        assertEquals("list_tiering_status", handler.getName());
    @Override
import java.util.HashMap;
        List<Table.Cell> row1 = rows.get(0);
        assertEquals("_warm", row2.get(2).value);  
 * The OpenSearch Contributors require contributions made to  
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).build();
 * SPDX-License-Identifier: Apache-2.0
        StringBuilder sb = new StringBuilder();
import org.opensearch.storage.action.tiering.status.model.ListTieringStatusResponse;
        statusList.add(status);  
    }
import org.opensearch.transport.client.node.NodeClient;  
        assertEquals("Invalid format. Target Tier must be in the form '_tier'", e.getMessage());  
        tieringStatus.setStatus(status);
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).build();  
        Table table = handler.buildTable(request, response);
        assertEquals("RUNNING", row1.get(1).value);
import java.util.List;
        ListTieringStatusResponse response = new ListTieringStatusResponse(Collections.emptyList());
import org.opensearch.rest.RestRequest;  
    }  
        Table table = handler.buildTable(request, response);
public class RestListTieringStatusActionTests extends OpenSearchTestCase {
        Map<String, String> params = new HashMap<>();  
        e = assertThrows(IllegalArgumentException.class, () -> handler.parseAndValidateTargetTier("warm"));
        params.put("target", "_invalid");
    }
import org.opensearch.test.rest.FakeRestRequest;
import org.opensearch.storage.action.tiering.status.model.TieringStatus;
    }
    }
        assertEquals("/_tier/all", route.getPath());  
        assertTrue(table.getRows().isEmpty());  
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).build();  
        assertEquals(2, rows.size());
    }  
        handler.documentation(sb);  
        assertEquals("COMPLETED", row2.get(1).value);
import org.opensearch.rest.RestHandler;
        Table table = handler.getTableWithHeader(request);  
 *
    public void testBuildTable() {
        assertEquals("index2", row2.get(0).value);
        statusList.add(status1);
        MockitoAnnotations.openMocks(this);
    public void setUp() throws Exception {
    public void testValidateTargetTier() {  
        assertNotNull(handler.doCatRequest(request, client));
/*  
        // Verify first row
        ListTieringStatusResponse response = new ListTieringStatusResponse(statusList);
    }
    private TieringStatus createTieringStatus(String indexName, String status, String source, String target) {
        assertNull(handler.parseAndValidateTargetTier(null));
    }
        List<TieringStatus> statusList = new ArrayList<>();
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
        handler = new RestListTieringStatusAction();
        RestHandler.Route route = routes.get(0);
    @Mock
import org.mockito.Mock;
        assertEquals("Invalid target tier. Target Tier must be either '_hot' or '_warm'", e.getMessage());
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).build();  
    public void testDoCatRequest() {
 * compatible open source license.
import java.util.ArrayList;
        params.put("target", "_hot");
        assertEquals("target", headers.get(3).value);  
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> handler.parseAndValidateTargetTier("_cold"));
        tieringStatus.setIndexName(indexName);  
import java.util.Map;  
        assertEquals("HOT", handler.parseAndValidateTargetTier("_hot"));
        assertEquals("_hot", row2.get(3).value);
import java.util.Collections;  
        tieringStatus.setTarget(target);  
        List<TieringStatus> statusList = new ArrayList<>();
    public void testBuildTableWithNullValues() {  
        // Test invalid tiers
import org.mockito.MockitoAnnotations;  
        assertEquals("/_tier/all\n", sb.toString());
        assertEquals(1, rows.size());
        assertEquals(1, routes.size());  
        super.setUp();  
    }
    }
        TieringStatus status = new TieringStatus();
import org.opensearch.test.OpenSearchTestCase;
        // Verify second row
        assertEquals("source", headers.get(2).value);
    @Override
        statusList.add(status2);  
        // Test with invalid target tier  
        assertEquals(RestRequest.Method.GET, route.getMethod());
        List<Table.Cell> headers = table.getHeaders();
        // Test with valid target tier
    }
    private RestListTieringStatusAction handler;  
        // Test invalid tiers  
    public void testGetTableWithHeader() {
        assertEquals("WARM", handler.parseAndValidateTargetTier("_warm"));  
        super.tearDown();
    public void testDocumentation() {
        List<List<Table.Cell>> rows = table.getRows();  
import org.opensearch.storage.action.tiering.status.rest.RestListTieringStatusAction;  
        TieringStatus status2 = createTieringStatus("index2", "COMPLETED", "_warm", "_hot");
import org.opensearch.common.Table;
        final RestRequest request2 = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
        List<List<Table.Cell>> rows = table.getRows();
