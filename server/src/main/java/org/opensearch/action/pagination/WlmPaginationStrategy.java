        return stats.stream()  
    @Override  
    }
public class WlmPaginationStrategy implements PaginationStrategy<WlmStats> {
     * @param requestedToken pagination token from the client, or null for the first page  
        return page;  
    public PageToken getResponseToken() {
            String raw = String.join(JOIN_DELIMITER, nodeId, workloadGroupId, String.valueOf(workloadGroupCount), hash, sortOrder, sortBy);  
        List<WlmStats> page = getPage(perWorkloadGroupStats, startIndex);
    public WlmPaginationStrategy(int pageSize, String nextToken, SortBy sortBy, SortOrder sortOrder, WlmStatsResponse response) {
            return Collections.emptyList();
        int endIndex = Math.min(startIndex + pageSize, stats.size());
        public String getHash() {
            int workloadGroupCount,
import java.nio.charset.StandardCharsets;  
    }
            return workloadGroupCount;
import java.util.stream.Collectors;
    }
                String workloadGroupId = entry.getKey();
                || isNullOrBlank(parts[NODE_ID_POS])
        public WlmStrategyToken(String requestedTokenString) {
     *
            .stream()
            .mapToInt(stat -> stat.getWorkloadGroupStats().getStats().size())  
        }
    protected int getStartIndex(List<WlmStats> sortedStats, WlmStrategyToken token) {
        this.nextToken = nextToken;  
        setResponseToken(perWorkloadGroupStats, startIndex + page.size(), currentHash);
        int startIndex = getStartIndex(perWorkloadGroupStats, requestedToken);  
            return workloadGroupId;  
import org.opensearch.wlm.stats.SortOrder;
    private List<WlmStats> extractWorkloadGroupStats(List<WlmStats> rawStats) {  
                    .getStats()  
    private void setResponseToken(List<WlmStats> stats, int nextIndex, String currentHash) {
        }  
    /**
        return paginatedStats;
import java.util.ArrayList;
                    .stream()
     * @param currentHash hash representing the current snapshot, used for token validation
                || isNullOrBlank(parts[HASH_POS])  
        perWorkloadGroupStats = perWorkloadGroupStats.stream().sorted(sortOrder.apply(sortBy.getComparator())).collect(Collectors.toList());
            return 0;  
     */  
 * Paginates based on workload group IDs.
import java.util.List;  
        }  
            )
        for (int i = 0; i < stats.size(); i++) {
            final String[] parts = decrypted.split(SPLIT_REGEX);
            return nodeId;
        return MessageDigests.toHexString(MessageDigests.sha256().digest(input.getBytes(StandardCharsets.UTF_8)));
     * @return paginated sublist of WlmStats
    public static class WlmStrategyToken {  
            this.responseToken = null;
        this.pageSize = pageSize;
            .sum();
                    nodeId,
            return hash;
            }
        OptionalInt index = findIndex(sortedStats, token.getNodeId(), token.getWorkloadGroupId());  
     * This class encapsulates the token data required for identifying the current state of pagination.
    }
            this.workloadGroupId = parts[WORKLOAD_GROUP_ID_POS];  
    private String computeWorkloadGroupHash(List<WlmStats> stats) {
            WlmStats stat = stats.get(i);
        if (index.isEmpty()) {
    private PageToken responseToken;
package org.opensearch.action.pagination;
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
 * compatible open source license.
     * Applies pagination to a list of WlmStats entries.
     */
    private final int pageSize;
            String decrypted = PaginationStrategy.decryptStringToken(token);
import org.opensearch.wlm.stats.WorkloadGroupStats;
            return sortOrder;  
 * SPDX-License-Identifier: Apache-2.0
            }
        if (nextIndex < stats.size()) {  
    }
            this.sortOrder = parts[SORT_ORDER_POS];  
        private static final int NODE_ID_POS = 0;  
        private final String sortOrder;
    }
            this.workloadGroupCount = Integer.parseInt(parts[WORKLOAD_GROUP_COUNT_POS]);
    private final SortBy sortBy;  
 * this file be licensed under the Apache-2.0 license or a
    protected OptionalInt findIndex(List<WlmStats> stats, String nodeId, String workloadGroupId) {  
 * The OpenSearch Contributors require contributions made to  
        this.sortBy = sortBy;
                WorkloadGroupStats singleWorkloadGroupStats = new WorkloadGroupStats(Map.of(workloadGroupId, entry.getValue()));  
            String sortOrder,  
        public int getWorkloadGroupCount() {  
            return PaginationStrategy.encryptStringToken(raw);
    private final String nextToken;
    private final List<WlmStats> paginatedStats;
import java.util.Collections;
                WlmStrategyToken.generateEncryptedToken(  
                || isNullOrBlank(parts[WORKLOAD_GROUP_ID_POS])
    private static final String HASH_ALGORITHM = "SHA-256";
                result.add(new WlmStats(stat.getNode(), singleWorkloadGroupStats));
        for (WlmStats stat : rawStats) {
        }
            return sortBy;
        }  
                throw new OpenSearchParseException("Invalid pagination token format");  
        }
    }
            WlmStats lastEntry = stats.get(nextIndex - 1);
                stat -> stat.getWorkloadGroupStats()
        return index.getAsInt();  
        public String getNodeId() {
/*  
            Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> WorkloadGroups = stat.getWorkloadGroupStats().getStats();  
    }  
        }
        return OptionalInt.empty();
        private final String sortBy;  
            }
            this.responseToken = null;
                ),
    private final SortOrder sortOrder;
        String currentHash = computeWorkloadGroupHash(response.getNodes());  
    }
import org.opensearch.common.hash.MessageDigests;  
            .sorted()
    private List<WlmStats> getPage(List<WlmStats> stats, int startIndex) {  
            .collect(Collectors.collectingAndThen(Collectors.joining(","), this::sha256Hex));  
     * determines the start index from the given requestedToken, and returns a sublist
        private static final int WORKLOAD_GROUP_COUNT_POS = 2;
import org.opensearch.wlm.stats.SortBy;
        if (rawStats.isEmpty()) {  
            String workloadGroupId = lastEntry.getWorkloadGroupStats().getStats().keySet().iterator().next();  
                || isNullOrBlank(parts[SORT_BY_POS])) {
            return parts;
            for (Map.Entry<String, WorkloadGroupStats.WorkloadGroupStatsHolder> entry : WorkloadGroups.entrySet()) {
        this.snapshotWorkloadGroupCount = response.getNodes()
}
                    workloadGroupId,
            this.hash = parts[HASH_POS];
    @Override
            String hash,
        }
            this.responseToken = new PageToken(
        public String getWorkloadGroupId() {
/**  
        } else {
        }  
        }  
            String nodeId = lastEntry.getNode().getId();
            Objects.requireNonNull(token, "Token cannot be null");  
            if (stat.getNode().getId().equals(nodeId) && stat.getWorkloadGroupStats().getStats().containsKey(workloadGroupId)) {  
        private static final String JOIN_DELIMITER = "|";
        }
import org.opensearch.OpenSearchParseException;
        }  
            if (parts.length != 6  
     * limited by pageSize. Sets responseToken if more results are available.  
        private static final String SPLIT_REGEX = "\\|";
        }  
            return str == null || str.trim().isEmpty();
            this.nodeId = parts[NODE_ID_POS];
                    sortBy.name()  
        public static String generateEncryptedToken(
        this.sortOrder = sortOrder;
    }
    }  
    private static final String DEFAULT_PAGINATED_ENTITY = "wlm_stats";
                    sortOrder.name(),
        return responseToken;  
        }  
     * @param rawStats unpaginated stats from all nodes
    /**
    public List<WlmStats> getRequestedEntities() {
        private static final int WORKLOAD_GROUP_ID_POS = 1;
            String workloadGroupId,  
        private static final int HASH_POS = 3;  
        public String getSortOrder() {
        return stats.subList(startIndex, endIndex);
        if (token == null) {
    private String sha256Hex(String input) {  
    // Compute the hash for all (nodeId|workloadGroupId) pairs
        private final String workloadGroupId;
import org.opensearch.wlm.stats.WlmStats;  
                || isNullOrBlank(parts[SORT_ORDER_POS])
        private static boolean isNullOrBlank(String str) {
                DEFAULT_PAGINATED_ENTITY
            String nodeId,
        private final String nodeId;
 * Pagination strategy for Workload Management (WLM) Stats.
 */  
            this.sortBy = parts[SORT_BY_POS];
        return result;
     * Flattens stats by workload group, sorts them using the specified sortBy and sortOrder,
import java.util.Objects;
        }
        }
            throw new OpenSearchParseException("Invalid or outdated token: " + nextToken);  
                    snapshotWorkloadGroupCount,  
        private final String hash;
    }
        ) {
        private static final int SORT_BY_POS = 5;
        List<WlmStats> result = new ArrayList<>();
import java.util.OptionalInt;  
            final String[] parts = validateToken(requestedTokenString);  
        this.paginatedStats = applyPagination(response.getNodes(), requestedToken, currentHash);
    private List<WlmStats> applyPagination(List<WlmStats> rawStats, WlmStrategyToken requestedToken, String currentHash) {
                    currentHash,
        private static String[] validateToken(String token) {
        private final int workloadGroupCount;  
        public String getSortBy() {  
        WlmStrategyToken requestedToken = (nextToken == null || nextToken.isEmpty()) ? null : new WlmStrategyToken(nextToken);
            );  
                    .keySet()
    private final int snapshotWorkloadGroupCount;  
        private static final int SORT_ORDER_POS = 4;
     * Represents a token used in the WLM strategy for pagination.  
     *  
 *
            .flatMap(
                return OptionalInt.of(i + 1);
        List<WlmStats> perWorkloadGroupStats = extractWorkloadGroupStats(rawStats);
 */  
            String sortBy
import java.util.Map;
                    .map(WorkloadGroupId -> stat.getNode().getId() + "|" + WorkloadGroupId)  
