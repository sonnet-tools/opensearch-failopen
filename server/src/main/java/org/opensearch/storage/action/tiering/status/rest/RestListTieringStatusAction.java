        if (parts.length != 2) {
        String targetTier = request.param(TARGET_TIER);  
            return null;  
import org.opensearch.rest.action.RestResponseListener;
        return "list_tiering_status";
        }  
            .execute(  
    @Override  
    public String parseAndValidateTargetTier(String targetTier) {
        return table;  
                        return RestTable.buildResponse(buildTable(request, listTieringStatusResponse), channel);  
        if (targetTier == null) {
        table.addCell("index", "alias:i,idx;desc:index name");  
    public List<Route> routes() {
    }
    }  
                ListTieringStatusAction.INSTANCE,
                listTieringStatusRequest,
        table.addCell("state", "desc: the current state of the migration");
import org.opensearch.rest.action.cat.RestTable;  
 * SPDX-License-Identifier: Apache-2.0
                    }
    public String getName() {  
package org.opensearch.storage.action.tiering.status.rest;
                    public RestResponse buildResponse(ListTieringStatusResponse listTieringStatusResponse) throws Exception {
import org.opensearch.storage.action.tiering.status.ListTieringStatusAction;
                    @Override
    public Table getTableWithHeader(RestRequest restRequest) {  
            table.addCell(tieringStatus.getTarget());  
 * this file be licensed under the Apache-2.0 license or a
        // Extract the part after the underscore  
    }  
import org.opensearch.rest.RestRequest;
                new RestResponseListener<ListTieringStatusResponse>(channel) {  
 */
    }  
        table.startHeaders();
 * REST handler for listing tiering status of all indices.  
        if (!TieringUtils.isTerminalTier(extractedTier)) {
        }
import org.opensearch.storage.action.tiering.status.model.TieringStatus;
        ListTieringStatusRequest listTieringStatusRequest = new ListTieringStatusRequest(targetTier);  
import org.opensearch.storage.action.tiering.status.model.ListTieringStatusResponse;  
import org.opensearch.transport.client.node.NodeClient;  
        return channel -> client.admin()
            table.endRow();
            );  
import org.opensearch.rest.action.cat.AbstractCatAction;
 * compatible open source license.
 */  
        for (TieringStatus tieringStatus : response.getTieringStatusList()) {
        return table;
    @Override  
public class RestListTieringStatusAction extends AbstractCatAction {
        // Convert to lowercase for case-insensitive comparison  
        table.addCell("target", "desc: destination tier");  
        Table table = new Table();
            table.addCell(tieringStatus.getIndexName());  
            table.addCell(tieringStatus.getStatus());
            .cluster()
            throw new IllegalArgumentException("Invalid target tier. Target Tier must be either '_hot' or '_warm'");
    @Override
    @Override
    public RestChannelConsumer doCatRequest(RestRequest request, NodeClient client) {
    public void documentation(StringBuilder stringBuilder) {
        // Validate the extracted tier  
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
    @Override
            table.startRow();
import org.opensearch.common.Table;
    }
import org.opensearch.storage.action.tiering.status.model.ListTieringStatusRequest;
        return extractedTier;
import org.opensearch.rest.RestResponse;  
import org.opensearch.storage.common.tiering.TieringUtils;
    }
    }
        String extractedTier = parts[1].toUpperCase(Locale.ROOT);
        stringBuilder.append("/_tier/all\n");
    private static final String TARGET_TIER = "target";
/*  
            table.addCell(tieringStatus.getSource());
        targetTier = parseAndValidateTargetTier(targetTier);
import java.util.Locale;  
/**
            throw new IllegalArgumentException("Invalid format. Target Tier must be in the form '_tier'");  
        return singletonList(new Route(GET, "/_tier/all"));
                }
 *
    // parse target tier '_hot' and '_warm'  
import static java.util.Collections.singletonList;
        }
        }
        Table table = getTableWithHeader(request);  
}
        String[] parts = targetTier.split("_");
        table.addCell("source", "desc: source tier");
    public Table buildTable(RestRequest request, ListTieringStatusResponse response) {
import static org.opensearch.rest.RestRequest.Method.GET;  
        table.endHeaders();
