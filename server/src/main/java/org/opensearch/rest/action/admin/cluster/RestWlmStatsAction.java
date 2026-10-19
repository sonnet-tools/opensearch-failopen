            "Failed to paginate WLM stats: next_token={}, pageSize={}, sortBy={}, sortOrder={}",  
        Table table = new Table(pageToken);
    protected void addFooterRow(Table table, int COLUMN_COUNT) {
        table.addCell("TOTAL_WOULD_THROTTLE", verbose ? "desc:Total Queries That Would Be Throttled In Monitor Mode" : "");
        table.addCell("|");  
        table.addCell(statsHolder.getRejections());
        Set<String> workloadGroupIds = Strings.tokenizeByCommaToSet(request.param("workloadGroupId", "_all"));  
package org.opensearch.rest.action.admin.cluster;
                    return RestTable.buildResponse(paginatedTable, channel);  
            }
        OpenSearchParseException e  
import java.io.IOException;
        }
        builder.endObject();
    @Override  
        table.addCell("TOTAL_COMPLETIONS", verbose ? "desc:Total Completed Queries" : "");
import org.opensearch.wlm.ResourceType;
        table.addCell(statsHolder.getCompletions());  
            return handleTabularRequest(request, client, wlmStatsRequest, pageSize, nextToken, sortBy, sortOrder);
        });  
import org.opensearch.rest.BytesRestResponse;
 * compatible open source license.
        table.addCell("WORKLOAD_GROUP_ID", verbose ? "desc:Workload Group" : "");  
        } catch (IllegalArgumentException e) {  
import static java.util.Arrays.asList;  
        table.addCell(cpuStats != null ? cpuStats.getCurrentUsage() : PLACEHOLDER);
        return channel -> client.admin().cluster().wlmStats(wlmStatsRequest, new RestActions.NodesResponseRestListener<>(channel));
        table.addCell("|");  
    private static final Logger logger = LogManager.getLogger(RestWlmStatsAction.class);
        }
        return channel -> client.admin().cluster().wlmStats(wlmStatsRequest, new RestResponseListener<WlmStatsResponse>(channel) {  
        table.endRow();
    ) throws IOException {
import org.opensearch.transport.client.node.NodeClient;  
    protected SortBy parseSortBy(String sortByParam) throws OpenSearchParseException {  
        WlmStatsRequest wlmStatsRequest = new WlmStatsRequest(nodesIds, workloadGroupIds, breach);
            table.addCell("-");  
    protected void handlePaginationError(  
        table.addCell("TOTAL_REJECTIONS", verbose ? "desc:Total Rejected Queries" : "");
     * Builds a tabular response with '|' column separators.  
    }  
import org.opensearch.core.xcontent.XContentBuilder;  
        final int COLUMN_COUNT = table.getHeaders().size();
     */
import static java.util.Collections.unmodifiableList;
                try {  
    public List<Route> routes() {
        return table;
                String workloadGroupId = entry.getKey();
                new Route(GET, "_wlm/{nodeId}/stats/{workloadGroupId}"),
    protected int parsePageSize(RestRequest request) {
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
        String nextToken,
    }  
        table.addCell("|");
        Boolean breach = request.hasParam("breach") ? Boolean.parseBoolean(request.param("boolean")) : null;
    ) {
    }
        table.startRow();
                }
        }
        table.addCell(statsHolder.getWouldThrottle());
        table.addCell("CPU_USAGE", verbose ? "desc:CPU Usage" : "");  
        table.addCell(workloadGroupId);
        SortOrder sortOrder = parseSortOrder(request.param("order", "asc"));
    private RestChannelConsumer handleTabularRequest(
import org.apache.logging.log4j.LogManager;
    }  
import org.opensearch.core.common.Strings;
    }
import org.opensearch.action.pagination.PageToken;  
        table.addCell("|");
 */  
import org.opensearch.rest.action.cat.RestTable;
        RestChannel channel,
    }  
    }
import java.util.Map;  
    }
 *  
import org.opensearch.rest.action.RestActions;  
            pageSize,
    }
        // Derive the footer width from the headers rather than hardcoding it, so adding a column cannot silently desync.  
            )  
        table.addCell("TOTAL_THROTTLED", verbose ? "desc:Total Throttled Queries" : "");
        table.addCell(statsHolder.getThrottled());  
        try {
        for (int i = 1; i < COLUMN_COUNT; i++) {
        boolean verbose = request.paramAsBoolean("v", false);
        table.addCell(nodeId);
                    List<WlmStats> paginatedStats = paginationStrategy.getRequestedEntities();  
        return pageSize;  
        SortOrder sortOrder  
import org.opensearch.wlm.stats.SortBy;
        }
import java.util.Set;
public class RestWlmStatsAction extends BaseRestHandler {  
        table.addCell("TOTAL_CANCELLATIONS", verbose ? "desc:Total Canceled Queries" : "");  
        table.addCell("|");
        table.startHeaders();  
        table.startRow();  
        XContentBuilder builder = XContentFactory.jsonBuilder();
        int pageSize,  
import org.opensearch.OpenSearchParseException;  
        SortBy sortBy = parseSortBy(request.param("sort", "node_id"));  
            nextToken,
import org.opensearch.rest.action.RestResponseListener;
    @Override  
        table.addCell("|");
 */
 * Transport action to get Workload Management stats
/*  
                    return null;  
        table.addCell("|");  
import org.opensearch.wlm.stats.WorkloadGroupStats;
        table.addCell("MEMORY_USAGE", verbose ? "desc:Memory Usage" : "");
        table.addCell("|");
 *
 * @opensearch.experimental
import org.opensearch.common.xcontent.XContentFactory;  
    @Override
import org.opensearch.core.rest.RestStatus;
        int pageSize,  
        table.addCell("|");  
        WlmStatsRequest wlmStatsRequest,
        builder.field("details", e.getMessage());
        WorkloadGroupStats.ResourceStats memoryStats = statsHolder.getResourceStats().get(ResourceType.MEMORY);  
            throw new OpenSearchParseException("Invalid value for 'size'. Allowed range: 1 to " + MAX_PAGE_SIZE);
            for (Map.Entry<String, WorkloadGroupStats.WorkloadGroupStatsHolder> entry : workloadGroupStats.getStats().entrySet()) {
        table.addCell("|");
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.Logger;
import org.opensearch.action.pagination.WlmPaginationStrategy;
    public String getName() {
                    PageToken nextPageToken = paginationStrategy.getResponseToken();
        WorkloadGroupStats.ResourceStats cpuStats = statsHolder.getResourceStats().get(ResourceType.CPU);
        String nextToken,
    protected void buildTable(Table table, List<WlmStats> paginatedStats, WlmPaginationStrategy paginationStrategy) {
                new Route(GET, "_list/wlm_stats/{nodeId}/stats"),  
import org.opensearch.action.admin.cluster.wlm.WlmStatsRequest;
 * The OpenSearch Contributors require contributions made to  
        if (paginationStrategy.getResponseToken() == null) {
            sortOrder
            }
        channel.sendResponse(new BytesRestResponse(RestStatus.BAD_REQUEST, builder));
import org.opensearch.wlm.stats.WlmStats;
import org.opensearch.common.Table;
                    buildTable(paginatedTable, paginatedStats, paginationStrategy);
        logger.error(
        SortOrder sortOrder,
        return "wlm_stats_action";  
                    Table paginatedTable = createTableWithHeaders(nextPageToken, verbose);  
            public RestResponse buildResponse(WlmStatsResponse response) throws Exception {
                    handlePaginationError(channel, nextToken, pageSize, sortBy, sortOrder, e);
import org.opensearch.rest.BaseRestHandler;
        NodeClient client,
}  
        table.addCell("|");  
        String userMessage = "Pagination state has changed (e.g., new workload groups added or removed). "
        } catch (IllegalArgumentException e) {
                new Route(GET, "_list/wlm_stats"),
import org.opensearch.wlm.stats.SortOrder;  
        RestRequest request,  
            throw new OpenSearchParseException("Invalid value for 'sort'. Allowed: 'node_id', 'workload_group'", e);
        try {  
            addFooterRow(table, COLUMN_COUNT);  
            throw new OpenSearchParseException("Invalid value for 'order'. Allowed: 'asc', 'desc'", e);  
        table.addCell("|");
            sortBy,  
 * this file be licensed under the Apache-2.0 license or a
        if (pageSize <= 0 || pageSize > MAX_PAGE_SIZE) {  
    protected SortOrder parseSortOrder(String sortOrderParam) throws OpenSearchParseException {
        int pageSize = request.paramAsInt("size", DEFAULT_PAGE_SIZE);
                new Route(GET, "_wlm/stats"),
                    WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(pageSize, nextToken, sortBy, sortOrder, response);
    }
        String[] nodesIds = Strings.splitStringByCommaToArray(request.param("nodeId"));
        table.endHeaders();  
import org.opensearch.rest.RestChannel;  
            + "Please restart pagination from the beginning by omitting the 'next_token' parameter.";  
            asList(  
        for (WlmStats wlmStats : paginatedStats) {  
                } catch (OpenSearchParseException e) {
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        table.addCell(memoryStats != null ? memoryStats.getCurrentUsage() : PLACEHOLDER);
        table.addCell(statsHolder.getCancellations());
        table.addCell("|");
    private static final int MAX_PAGE_SIZE = 100;  
                new Route(GET, "_wlm/stats/{workloadGroupId}"),  
        int pageSize = parsePageSize(request);
        table.addCell("|");  
                WorkloadGroupStats.WorkloadGroupStatsHolder statsHolder = entry.getValue();  
/**
            @Override
            return SortOrder.fromString(sortOrderParam);
        );
        final String PLACEHOLDER = "NA";
            WorkloadGroupStats workloadGroupStats = wlmStats.getWorkloadGroupStats();
        String nextToken = request.param("next_token");
    protected Table createTableWithHeaders(PageToken pageToken, boolean verbose) {
import java.util.List;
        return unmodifiableList(
        table.addCell("|");
        table.addCell("No more pages available");
    private static final int DEFAULT_PAGE_SIZE = 10;
                new Route(GET, "_wlm/{nodeId}/stats"),
                new Route(GET, "_list/wlm_stats/stats/{workloadGroupId}"),
import static org.opensearch.rest.RestRequest.Method.GET;
        table.endRow();
        }
import org.opensearch.rest.RestResponse;
        }  
        String path = request.rawPath();  
        table.addCell("|");
        SortBy sortBy,
import org.opensearch.rest.RestRequest;
            String nodeId = wlmStats.getNode().getId();
                new Route(GET, "_list/wlm_stats/{nodeId}/stats/{workloadGroupId}")
        }  
        SortBy sortBy,
        );
    protected void addRow(Table table, String nodeId, String workloadGroupId, WorkloadGroupStats.WorkloadGroupStatsHolder statsHolder) {
    }
                addRow(table, nodeId, workloadGroupId, statsHolder);
    /**
            return SortBy.fromString(sortByParam);
        builder.startObject();
        if (path.startsWith("/_list/wlm_stats")) {
        builder.field("error", userMessage);  
    }
        table.addCell("NODE_ID", verbose ? "desc:Node ID" : "");
