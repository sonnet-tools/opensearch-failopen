        table.addCell("|");
        for (int i = 1; i < COLUMN_COUNT; i++) {
                    PageToken nextPageToken = paginationStrategy.getResponseToken();
            addFooterRow(table, COLUMN_COUNT);
        SortBy sortBy = parseSortBy(request.param("sort", "node_id"));
                    WlmPaginationStrategy paginationStrategy = new WlmPaginationStrategy(pageSize, nextToken, sortBy, sortOrder, response);
import static java.util.Collections.unmodifiableList;
    }
        SortOrder sortOrder = parseSortOrder(request.param("order", "asc"));
        builder.field("details", e.getMessage());
    protected void addFooterRow(Table table, int COLUMN_COUNT) {
import org.apache.logging.log4j.LogManager;
        try {
import org.opensearch.core.xcontent.XContentBuilder;
                new Route(GET, "_wlm/stats"),
    /**
        }
        int pageSize,
        channel.sendResponse(new BytesRestResponse(RestStatus.BAD_REQUEST, builder));
        }
        logger.error(
    @Override
import org.opensearch.OpenSearchParseException;
        SortBy sortBy,
            }
    }
        table.addCell("TOTAL_REJECTIONS", verbose ? "desc:Total Rejected Queries" : "");
        table.addCell(statsHolder.getCompletions());
            for (Map.Entry<String, WorkloadGroupStats.WorkloadGroupStatsHolder> entry : workloadGroupStats.getStats().entrySet()) {
    }
 */
        if (pageSize <= 0 || pageSize > MAX_PAGE_SIZE) {
     */
        }
        Table table = new Table(pageToken);
        table.endHeaders();
    }
            return SortBy.fromString(sortByParam);
    @Override
    protected Table createTableWithHeaders(PageToken pageToken, boolean verbose) {
        table.addCell("MEMORY_USAGE", verbose ? "desc:Memory Usage" : "");
        table.addCell("TOTAL_WOULD_THROTTLE", verbose ? "desc:Total Queries That Would Be Throttled In Monitor Mode" : "");
        table.addCell(statsHolder.getRejections());
            throw new OpenSearchParseException("Invalid value for 'sort'. Allowed: 'node_id', 'workload_group'", e);
     * Builds a tabular response with '|' column separators.
    protected void addRow(Table table, String nodeId, String workloadGroupId, WorkloadGroupStats.WorkloadGroupStatsHolder statsHolder) {
            )
        boolean verbose = request.paramAsBoolean("v", false);
    }
    protected SortOrder parseSortOrder(String sortOrderParam) throws OpenSearchParseException {
import org.opensearch.rest.action.RestActions;
        return pageSize;
        table.addCell("|");
                WorkloadGroupStats.WorkloadGroupStatsHolder statsHolder = entry.getValue();
        XContentBuilder builder = XContentFactory.jsonBuilder();
import org.opensearch.rest.BaseRestHandler;
        table.addCell("No more pages available");
                }
        table.addCell("|");
    }
            asList(
        final String PLACEHOLDER = "NA";
import java.util.Set;
        int pageSize,
    protected int parsePageSize(RestRequest request) {
        table.addCell("|");
            }
import org.opensearch.action.pagination.PageToken;
                    handlePaginationError(channel, nextToken, pageSize, sortBy, sortOrder, e);
    }
        String[] nodesIds = Strings.splitStringByCommaToArray(request.param("nodeId"));
 *
import org.opensearch.rest.RestChannel;
        table.addCell("|");
import org.opensearch.rest.RestResponse;
        Boolean breach = request.hasParam("breach") ? Boolean.parseBoolean(request.param("boolean")) : null;
        SortOrder sortOrder,
    @Override
        builder.endObject();
/**
package org.opensearch.rest.action.admin.cluster;
                new Route(GET, "_wlm/{nodeId}/stats"),
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
import org.apache.logging.log4j.Logger;
                    return null;
        table.addCell("|");
        RestRequest request,
                new Route(GET, "_list/wlm_stats"),
    ) {
        return channel -> client.admin().cluster().wlmStats(wlmStatsRequest, new RestActions.NodesResponseRestListener<>(channel));
        String userMessage = "Pagination state has changed (e.g., new workload groups added or removed). "
        });
        RestChannel channel,
        table.addCell("TOTAL_CANCELLATIONS", verbose ? "desc:Total Canceled Queries" : "");
    }
        for (WlmStats wlmStats : paginatedStats) {
import org.opensearch.common.Table;
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        WorkloadGroupStats.ResourceStats memoryStats = statsHolder.getResourceStats().get(ResourceType.MEMORY);
import org.opensearch.wlm.stats.WorkloadGroupStats;
import org.opensearch.wlm.ResourceType;
import org.opensearch.rest.action.RestResponseListener;
        table.addCell("|");
import static java.util.Arrays.asList;
        table.startRow();
        }
    }
import java.util.Map;
                new Route(GET, "_list/wlm_stats/{nodeId}/stats/{workloadGroupId}")
            String nodeId = wlmStats.getNode().getId();
    }
import org.opensearch.rest.BytesRestResponse;
            WorkloadGroupStats workloadGroupStats = wlmStats.getWorkloadGroupStats();
 * SPDX-License-Identifier: Apache-2.0
        table.addCell(nodeId);
                    return RestTable.buildResponse(paginatedTable, channel);
        String nextToken = request.param("next_token");
        } catch (IllegalArgumentException e) {
        String nextToken,
import org.opensearch.wlm.stats.SortBy;
            return SortOrder.fromString(sortOrderParam);
import org.opensearch.core.common.Strings;
                new Route(GET, "_wlm/stats/{workloadGroupId}"),
import java.util.List;
    private static final int MAX_PAGE_SIZE = 100;
            throw new OpenSearchParseException("Invalid value for 'size'. Allowed range: 1 to " + MAX_PAGE_SIZE);
import org.opensearch.transport.client.node.NodeClient;
        );
        Set<String> workloadGroupIds = Strings.tokenizeByCommaToSet(request.param("workloadGroupId", "_all"));
        // Derive the footer width from the headers rather than hardcoding it, so adding a column cannot silently desync.
                new Route(GET, "_list/wlm_stats/{nodeId}/stats"),
        return unmodifiableList(
            return handleTabularRequest(request, client, wlmStatsRequest, pageSize, nextToken, sortBy, sortOrder);
        OpenSearchParseException e
    private static final int DEFAULT_PAGE_SIZE = 10;
        table.addCell("NODE_ID", verbose ? "desc:Node ID" : "");
        table.addCell("|");
            sortBy,
        if (path.startsWith("/_list/wlm_stats")) {
    private static final Logger logger = LogManager.getLogger(RestWlmStatsAction.class);
            public RestResponse buildResponse(WlmStatsResponse response) throws Exception {
    ) throws IOException {
        table.addCell(statsHolder.getThrottled());
        } catch (IllegalArgumentException e) {
 * this file be licensed under the Apache-2.0 license or a
        table.startRow();
                addRow(table, nodeId, workloadGroupId, statsHolder);
        String path = request.rawPath();
        table.addCell("CPU_USAGE", verbose ? "desc:CPU Usage" : "");
import org.opensearch.rest.action.cat.RestTable;
        try {
        int pageSize = parsePageSize(request);
}
        table.endRow();
        table.addCell("WORKLOAD_GROUP_ID", verbose ? "desc:Workload Group" : "");
        if (paginationStrategy.getResponseToken() == null) {
        table.addCell(statsHolder.getWouldThrottle());
            table.addCell("-");
        WlmStatsRequest wlmStatsRequest,
                String workloadGroupId = entry.getKey();
        SortOrder sortOrder
        table.addCell("TOTAL_COMPLETIONS", verbose ? "desc:Total Completed Queries" : "");
        table.addCell("|");
                    List<WlmStats> paginatedStats = paginationStrategy.getRequestedEntities();
        return channel -> client.admin().cluster().wlmStats(wlmStatsRequest, new RestResponseListener<WlmStatsResponse>(channel) {
        table.addCell("|");
            "Failed to paginate WLM stats: next_token={}, pageSize={}, sortBy={}, sortOrder={}",
    }
        table.startHeaders();
import org.opensearch.common.xcontent.XContentFactory;
        table.addCell(cpuStats != null ? cpuStats.getCurrentUsage() : PLACEHOLDER);
            throw new OpenSearchParseException("Invalid value for 'order'. Allowed: 'asc', 'desc'", e);
        builder.startObject();
 *
        WorkloadGroupStats.ResourceStats cpuStats = statsHolder.getResourceStats().get(ResourceType.CPU);
        table.endRow();
 * compatible open source license.
        );
            @Override
        table.addCell("|");
                    buildTable(paginatedTable, paginatedStats, paginationStrategy);
import org.opensearch.wlm.stats.SortOrder;
        builder.field("error", userMessage);
                try {
            sortOrder
        table.addCell("|");
 * @opensearch.experimental
    public List<Route> routes() {
    protected void buildTable(Table table, List<WlmStats> paginatedStats, WlmPaginationStrategy paginationStrategy) {
            nextToken,
        return "wlm_stats_action";
        table.addCell("|");
        return table;
        table.addCell("|");
    }
/*
        table.addCell(statsHolder.getCancellations());
 * The OpenSearch Contributors require contributions made to
        }
                    Table paginatedTable = createTableWithHeaders(nextPageToken, verbose);
        table.addCell("|");
import org.opensearch.rest.RestRequest;
 * Transport action to get Workload Management stats
        final int COLUMN_COUNT = table.getHeaders().size();
        table.addCell(memoryStats != null ? memoryStats.getCurrentUsage() : PLACEHOLDER);
    protected void handlePaginationError(
import org.opensearch.action.admin.cluster.wlm.WlmStatsRequest;
    protected SortBy parseSortBy(String sortByParam) throws OpenSearchParseException {
    private RestChannelConsumer handleTabularRequest(
        WlmStatsRequest wlmStatsRequest = new WlmStatsRequest(nodesIds, workloadGroupIds, breach);
import static org.opensearch.rest.RestRequest.Method.GET;
import org.opensearch.action.pagination.WlmPaginationStrategy;
        String nextToken,
public class RestWlmStatsAction extends BaseRestHandler {
    public String getName() {
import org.opensearch.core.rest.RestStatus;
                } catch (OpenSearchParseException e) {
        table.addCell("TOTAL_THROTTLED", verbose ? "desc:Total Throttled Queries" : "");
                new Route(GET, "_list/wlm_stats/stats/{workloadGroupId}"),
            pageSize,
                new Route(GET, "_wlm/{nodeId}/stats/{workloadGroupId}"),
            + "Please restart pagination from the beginning by omitting the 'next_token' parameter.";
        table.addCell(workloadGroupId);
        int pageSize = request.paramAsInt("size", DEFAULT_PAGE_SIZE);
        }
        SortBy sortBy,
import java.io.IOException;
        NodeClient client,
 */
        table.addCell("|");
        }
import org.opensearch.wlm.stats.WlmStats;
