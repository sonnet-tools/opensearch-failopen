        }
/*
import java.util.Collections;
        }
        }
    @Override
    private String sha256Hex(String input) {
    private List<WlmStats> applyPagination(List<WlmStats> rawStats, WlmStrategyToken requestedToken, String currentHash) {
 * compatible open source license.
    }
                    snapshotWorkloadGroupCount,
        return MessageDigests.toHexString(MessageDigests.sha256().digest(input.getBytes(StandardCharsets.UTF_8)));
import org.opensearch.wlm.stats.SortBy;
            return PaginationStrategy.encryptStringToken(raw);
import java.util.stream.Collectors;
    private static final String HASH_ALGORITHM = "SHA-256";
import org.opensearch.OpenSearchParseException;
        public String getWorkloadGroupId() {
        return index.getAsInt();
/**
 */
    /**
            .mapToInt(stat -> stat.getWorkloadGroupStats().getStats().size())
    }
                String workloadGroupId = entry.getKey();
    private final int pageSize;
    }
            WlmStats lastEntry = stats.get(nextIndex - 1);
     *
            this.nodeId = parts[NODE_ID_POS];
                    sortBy.name()
 * The OpenSearch Contributors require contributions made to
    private final SortOrder sortOrder;
            this.responseToken = null;
            final String[] parts = validateToken(requestedTokenString);
            if (stat.getNode().getId().equals(nodeId) && stat.getWorkloadGroupStats().getStats().containsKey(workloadGroupId)) {
            );
        }
        public String getNodeId() {
    public static class WlmStrategyToken {
    @Override
                    currentHash,
        }
 * SPDX-License-Identifier: Apache-2.0
            )
                    .getStats()
import java.util.ArrayList;
            return parts;
        this.sortOrder = sortOrder;
            Map<String, WorkloadGroupStats.WorkloadGroupStatsHolder> WorkloadGroups = stat.getWorkloadGroupStats().getStats();
    private final SortBy sortBy;
                    .stream()
    /**
        setResponseToken(perWorkloadGroupStats, startIndex + page.size(), currentHash);
    private PageToken responseToken;
            this.sortBy = parts[SORT_BY_POS];
        this.snapshotWorkloadGroupCount = response.getNodes()
        private static final String SPLIT_REGEX = "\\|";
                throw new OpenSearchParseException("Invalid pagination token format");
        private final String hash;
            return workloadGroupId;
            return nodeId;
        private final String nodeId;
                return OptionalInt.of(i + 1);
            }
        for (int i = 0; i < stats.size(); i++) {
     * @param currentHash hash representing the current snapshot, used for token validation
            this.hash = parts[HASH_POS];
            String sortOrder,
        List<WlmStats> page = getPage(perWorkloadGroupStats, startIndex);
    private final String nextToken;
        List<WlmStats> result = new ArrayList<>();
        if (token == null) {
            this.workloadGroupCount = Integer.parseInt(parts[WORKLOAD_GROUP_COUNT_POS]);
            this.responseToken = null;
import org.opensearch.wlm.stats.SortOrder;
        OptionalInt index = findIndex(sortedStats, token.getNodeId(), token.getWorkloadGroupId());
}
    private String computeWorkloadGroupHash(List<WlmStats> stats) {
     * @param rawStats unpaginated stats from all nodes
        private final String sortOrder;
            String hash,
        private static final int HASH_POS = 3;
        }
    }
    protected OptionalInt findIndex(List<WlmStats> stats, String nodeId, String workloadGroupId) {
        }
                    nodeId,
    private final List<WlmStats> paginatedStats;
 * this file be licensed under the Apache-2.0 license or a
        private final String sortBy;
    public PageToken getResponseToken() {
            String workloadGroupId,
                || isNullOrBlank(parts[SORT_ORDER_POS])
    }
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
        perWorkloadGroupStats = perWorkloadGroupStats.stream().sorted(sortOrder.apply(sortBy.getComparator())).collect(Collectors.toList());
import org.opensearch.wlm.stats.WorkloadGroupStats;
        private static final int SORT_BY_POS = 5;
                ),
     * Flattens stats by workload group, sorts them using the specified sortBy and sortOrder,
    }
import org.opensearch.common.hash.MessageDigests;
package org.opensearch.action.pagination;
        private static String[] validateToken(String token) {
        this.pageSize = pageSize;
     * This class encapsulates the token data required for identifying the current state of pagination.
import java.util.List;
    private final int snapshotWorkloadGroupCount;
     * Represents a token used in the WLM strategy for pagination.
            this.workloadGroupId = parts[WORKLOAD_GROUP_ID_POS];
                    sortOrder.name(),
        public static String generateEncryptedToken(
    // Compute the hash for all (nodeId|workloadGroupId) pairs
    }
        public int getWorkloadGroupCount() {
public class WlmPaginationStrategy implements PaginationStrategy<WlmStats> {
        public String getHash() {
                WlmStrategyToken.generateEncryptedToken(
    private List<WlmStats> extractWorkloadGroupStats(List<WlmStats> rawStats) {
        private static final int SORT_ORDER_POS = 4;
            final String[] parts = decrypted.split(SPLIT_REGEX);
     * @return paginated sublist of WlmStats
        this.sortBy = sortBy;
    }
import java.util.Objects;
    }
        return responseToken;
     * @param requestedToken pagination token from the client, or null for the first page
import java.util.OptionalInt;
            int workloadGroupCount,
            Objects.requireNonNull(token, "Token cannot be null");
        }
            .flatMap(
    protected int getStartIndex(List<WlmStats> sortedStats, WlmStrategyToken token) {
import java.nio.charset.StandardCharsets;
 * Pagination strategy for Workload Management (WLM) Stats.
                    workloadGroupId,
     */
                DEFAULT_PAGINATED_ENTITY
            String nodeId = lastEntry.getNode().getId();
            return 0;
        public String getSortOrder() {
        List<WlmStats> perWorkloadGroupStats = extractWorkloadGroupStats(rawStats);
        }
            .stream()
        } else {
        private final String workloadGroupId;
        public String getSortBy() {
            throw new OpenSearchParseException("Invalid or outdated token: " + nextToken);
     * limited by pageSize. Sets responseToken if more results are available.
        private static final int WORKLOAD_GROUP_ID_POS = 1;
        }
            WlmStats stat = stats.get(i);
            return sortOrder;
        private static boolean isNullOrBlank(String str) {
import java.util.Map;
            for (Map.Entry<String, WorkloadGroupStats.WorkloadGroupStatsHolder> entry : WorkloadGroups.entrySet()) {
            this.responseToken = new PageToken(
    }
                    .map(WorkloadGroupId -> stat.getNode().getId() + "|" + WorkloadGroupId)
            this.sortOrder = parts[SORT_ORDER_POS];
                stat -> stat.getWorkloadGroupStats()
        }
        if (nextIndex < stats.size()) {
 * Paginates based on workload group IDs.
     * Applies pagination to a list of WlmStats entries.
        int endIndex = Math.min(startIndex + pageSize, stats.size());
                || isNullOrBlank(parts[WORKLOAD_GROUP_ID_POS])
                    .keySet()
            String workloadGroupId = lastEntry.getWorkloadGroupStats().getStats().keySet().iterator().next();
            String decrypted = PaginationStrategy.decryptStringToken(token);
        private final int workloadGroupCount;
        String currentHash = computeWorkloadGroupHash(response.getNodes());
    private void setResponseToken(List<WlmStats> stats, int nextIndex, String currentHash) {
        if (index.isEmpty()) {
        this.paginatedStats = applyPagination(response.getNodes(), requestedToken, currentHash);
        public WlmStrategyToken(String requestedTokenString) {
        return result;
        if (rawStats.isEmpty()) {
        ) {
            return str == null || str.trim().isEmpty();
        return OptionalInt.empty();
            return Collections.emptyList();
 */
                || isNullOrBlank(parts[HASH_POS])
    public WlmPaginationStrategy(int pageSize, String nextToken, SortBy sortBy, SortOrder sortOrder, WlmStatsResponse response) {
    }
     *
            String raw = String.join(JOIN_DELIMITER, nodeId, workloadGroupId, String.valueOf(workloadGroupCount), hash, sortOrder, sortBy);
     */
        this.nextToken = nextToken;
            return sortBy;
        }
                result.add(new WlmStats(stat.getNode(), singleWorkloadGroupStats));
        }
 *
                || isNullOrBlank(parts[NODE_ID_POS])
import org.opensearch.wlm.stats.WlmStats;
        for (WlmStats stat : rawStats) {
            String nodeId,
            if (parts.length != 6
        return page;
        private static final int NODE_ID_POS = 0;
            .collect(Collectors.collectingAndThen(Collectors.joining(","), this::sha256Hex));
        int startIndex = getStartIndex(perWorkloadGroupStats, requestedToken);
    private List<WlmStats> getPage(List<WlmStats> stats, int startIndex) {
        return stats.subList(startIndex, endIndex);
        private static final String JOIN_DELIMITER = "|";
            .sum();
                WorkloadGroupStats singleWorkloadGroupStats = new WorkloadGroupStats(Map.of(workloadGroupId, entry.getValue()));
            }
        WlmStrategyToken requestedToken = (nextToken == null || nextToken.isEmpty()) ? null : new WlmStrategyToken(nextToken);
        return paginatedStats;
        }
            return workloadGroupCount;
        private static final int WORKLOAD_GROUP_COUNT_POS = 2;
        }
    private static final String DEFAULT_PAGINATED_ENTITY = "wlm_stats";
        }
    public List<WlmStats> getRequestedEntities() {
        return stats.stream()
            return hash;
            .sorted()
            String sortBy
            }
    }
                || isNullOrBlank(parts[SORT_BY_POS])) {
     * determines the start index from the given requestedToken, and returns a sublist
