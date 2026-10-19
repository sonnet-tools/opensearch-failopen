    }
                if (indexShardRoutingTable.get(startShardId).size() > numShardsRequired) {
        // If all the shards of filtered indices list have been included in pageShardRoutings, then no more
        return indexNameFilter(lastIndexName).or(
            : 0;
    ) {
         * get split across pages.
        private final PageToken pageToken;
        /**
    }
    public List<String> getRequestedIndices() {
                PageParams.PARAM_ASC_SORT_VALUE.equals(sortOrder) ? ASC_COMPARATOR : DESC_COMPARATOR
            }
        }
                shardRoutings.addAll(indexShardRoutingTable.get(startShardId).shards());
            int startShardId = shardCount == 0 ? getStartShardIdForPageIndex(token, indexName, indexMetadata.getCreationDate()) : 0;
         * Token should be base64 encoded, and should contain the expected number of elements separated by "|".
                    continue;
            } catch (NumberFormatException exception) {
            for (; startShardId < indexShardRoutingTable.size(); startShardId++) {
        final int numShardsRequired,
}
                        ).generateEncryptedToken(),
    public static class ShardStrategyToken {
                clusterState,
        ShardStrategyToken shardStrategyToken = getShardStrategyToken(pageParams.getRequestedToken());
            }
        String lastIndexName,
    }
                            shardRoutings.get(shardRoutings.size() - 1).id(),
        List<IndexMetadata> filteredIndices,
            if (shardCount > numShardsRequired) {
        List<ShardRouting> shardRoutings = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to
            this.lastIndexCreationTime = lastIndexCreationTime;
        // shards are remaining to be fetched, and the next_token should thus be null.
            this.lastShardId = Integer.parseInt(decryptedTokenElements[SHARD_ID_POS_IN_TOKEN]);
            final String[] decryptedTokenElements = decryptedToken.split(SPLIT_REGEX);
package org.opensearch.action.pagination;
     * Provides the shardId to start an index which is to be included in the page. If the index is same as
     * Note: All shards for a shardID will always be present in the same page.
        Map<String, IndexRoutingTable> indicesRouting,
            Objects.requireNonNull(requestedTokenStr, "requestedTokenString can not be null");
    private PageData getPageData(
            );
    private ShardStrategyToken getShardStrategyToken(String requestedToken) {
public class ShardPaginationStrategy implements PaginationStrategy<ShardRouting> {
        }
                            lastAddedIndex.getCreationDate()
        Set<Integer> shardIdSet = Arrays.stream(shardIDs).boxed().collect(Collectors.toSet());
        private static final int CREATE_TIME_POS_IN_TOKEN = 1;
import org.opensearch.cluster.ClusterState;
                    );
    @Override
    }
        // Get list of indices metadata sorted by their creation time and filtered by the last sent index
import java.util.stream.Collectors;
     */
     * to avoid parsing collections multiple times.
        String sortOrder,
            return PaginationStrategy.encryptStringToken(
        return metadata -> metadata.getIndex().getName().equals(lastIndexName);
                if (shardCount > numShardsRequired) {
import org.opensearch.OpenSearchParseException;
            : token.lastIndexName.equals(pageIndexName) && token.lastIndexCreationTime == pageIndexCreationTime ? token.lastShardId + 1
                shardCount += indexShardRoutingTable.get(startShardId).size();
                }
        return new PageData(shardRoutings, indices, new PageToken(null, DEFAULT_SHARDS_PAGINATED_ENTITY));
            this.shardRoutings = shardRoutings;
    private static List<IndexMetadata> getEligibleIndices(
                getMetadataFilter(sortOrder, lastIndexName, lastIndexCreationTime),
     */
        private static final int INDEX_NAME_POS_IN_TOKEN = 2;
 * @opensearch.internal
        List<String> indices = new ArrayList<>();
                    new PageToken(
 * this file be licensed under the Apache-2.0 license or a
        Long lastIndexCreationTime
                    )
        private final long lastIndexCreationTime;
            try {
            pageParams.getSort(),
        return pageData.pageToken;
            IndexPaginationStrategy.getIndexCreateTimeFilter(sortOrder, lastIndexName, lastIndexCreationTime)
    private static final String DEFAULT_SHARDS_PAGINATED_ENTITY = "shards";
            if (indexShardsAdded) {
                if (shardIdSet.isEmpty() == false && shardIdSet.contains(startShardId) == false) {
        private final String lastIndexName;
        int shardCount = 0;
         * Will be used to identify the next shard to start the page from, in case the shards of an index
            // Always start from shardID 0 for all indices except for the first one which might be same as the last sent
import java.util.Arrays;
    private PageData pageData;
    @Override
            Objects.requireNonNull(lastIndexName, "index name should be provided");
    public List<ShardRouting> getRequestedEntities() {
    }
                PageParams.PARAM_ASC_SORT_VALUE.equals(sortOrder) ? ASC_COMPARATOR : DESC_COMPARATOR
                lastAddedIndex = indexMetadata;
            );
         * @param requestedTokenStr string denoting the encoded token requested by the user.
         */
    public ShardPaginationStrategy(PageParams pageParams, ClusterState clusterState) {
                String.join(JOIN_DELIMITER, String.valueOf(lastShardId), String.valueOf(lastIndexCreationTime), lastIndexName)
/*
                long creationTimeOfLastRespondedIndex = Long.parseLong(decryptedTokenElements[CREATE_TIME_POS_IN_TOKEN]);
            // index. To identify if an index is same as last sent index, verify both the index name and creation time.
                        DEFAULT_SHARDS_PAGINATED_ENTITY
                }
            this.lastIndexName = lastIndexName;
                            lastAddedIndex.getIndex().getName(),
        for (IndexMetadata indexMetadata : filteredIndices) {
    }
                int shardId = Integer.parseInt(decryptedTokenElements[SHARD_ID_POS_IN_TOKEN]);
         */
        private static final String JOIN_DELIMITER = "|";
                clusterState,
                throw new OpenSearchParseException(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);
            }
        } else {
 */
            Map<Integer, IndexShardRoutingTable> indexShardRoutingTable = indicesRouting.get(indexName).getShards();
                    indices,
    private static class PageData {
        if (Objects.isNull(lastIndexName) || Objects.isNull(lastIndexCreationTime)) {
    }
import java.util.List;
                    shardRoutings,
import java.util.function.Predicate;
         * Denotes the shardId of the last shard in the response.
 * compatible open source license.
import static org.opensearch.action.pagination.IndexPaginationStrategy.ASC_COMPARATOR;
         * Used to identify the new start point in case the indices get created/deleted while queries are executed.
import java.util.ArrayList;
        int[] shardIDs
            this.lastIndexName = decryptedTokenElements[INDEX_NAME_POS_IN_TOKEN];
        }
         * Represents name of the last index which was displayed in the page.
     * Private utility class to consolidate the page details of shard strategy. Will be used to set all the details at once,
            String decryptedToken = PaginationStrategy.decryptStringToken(requestedTokenStr);
        List<IndexMetadata> filteredIndices = getEligibleIndices(
            return PaginationStrategy.getSortedIndexMetadata(
        ClusterState clusterState,
            return PaginationStrategy.getSortedIndexMetadata(
     */
    public ShardPaginationStrategy(PageParams pageParams, ClusterState clusterState, int[] shardIDs) {
            this.indices = indices;
            );
         */
/**
            Objects.isNull(shardStrategyToken) ? null : shardStrategyToken.lastIndexCreationTime
import java.util.Set;
            pageParams.getSize(),
        private static final int SHARD_ID_POS_IN_TOKEN = 0;
    /**
         * Represents creation times of last index which was displayed in the page.
            }
            shardStrategyToken,
            Objects.isNull(shardStrategyToken) ? null : shardStrategyToken.lastIndexName,
        this(pageParams, clusterState, new int[0]);
            final String[] decryptedTokenElements = decryptedToken.split(SPLIT_REGEX);
        // iterate over indices until shardCount is less than numShardsRequired
            String decryptedToken = PaginationStrategy.decryptStringToken(requestedTokenString);
            boolean indexShardsAdded = false;
         * Used to identify whether the sorted list of indices has changed or not.
         *
import org.opensearch.cluster.metadata.IndexMetadata;
            String indexName = indexMetadata.getIndex().getName();
         * Will perform simple validations on token received in the request.
 * SPDX-License-Identifier: Apache-2.0
                return new PageData(
    private static Predicate<IndexMetadata> getMetadataFilter(String sortOrder, String lastIndexName, Long lastIndexCreationTime) {
                    throw new OpenSearchParseException(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);
        return Objects.isNull(token) ? 0
    }
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        private static final String SPLIT_REGEX = "\\|";
    }
                    throw new IllegalArgumentException(
            validateShardStrategyToken(requestedTokenString);
        );
            clusterState,
            filteredIndices,
    /**
        );
        this.pageData = getPageData(
import java.util.Objects;
 *
        // Get the list of shards and indices belonging to current page.
    /**
import org.opensearch.cluster.routing.IndexRoutingTable;
        final ShardStrategyToken token,
 * The strategy considers create timestamps of indices and shardID as the keys to iterate over pages.
    private static Predicate<IndexMetadata> indexNameFilter(String lastIndexName) {
 */
 * This strategy can be used by the Rest APIs wanting to paginate the responses based on Shards.
        /**
    }
        private final List<String> indices;
import static org.opensearch.action.pagination.IndexPaginationStrategy.DESC_COMPARATOR;
    ) {
 *
        return Objects.isNull(requestedToken) || requestedToken.isEmpty() ? null : new ShardStrategyToken(requestedToken);
                throw new OpenSearchParseException(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);
        private final int lastShardId;
                    break;
     * which are to be displayed in a page. Optionally, if shardIDs are provided, only those will be considered.
            return indexMetadata -> true;
                        new ShardStrategyToken(
                        "size value should be greater than the replica count of all indices, so that all primary and replicas of a shard show up in single page"
import java.util.Map;
import org.opensearch.cluster.routing.ShardRouting;
     * Will be used to get the list of shards and respective indices to which they belong,
            }
            clusterState.getRoutingTable().getIndicesRouting(),
        public ShardStrategyToken(String requestedTokenString) {
    /**
     * lastIndex, start from the shardId next to lastShardId, else always start from 0.
                );
         */
        /**
    private int getStartShardIdForPageIndex(ShardStrategyToken token, final String pageIndexName, final long pageIndexCreationTime) {
        public ShardStrategyToken(String lastIndexName, int lastShardId, long lastIndexCreationTime) {
        }
            this.lastShardId = lastShardId;
        private final List<ShardRouting> shardRoutings;
                if (shardId < 0 || creationTimeOfLastRespondedIndex <= 0) {
                indexShardsAdded = true;
    public PageToken getResponseToken() {
     */
        return pageData.shardRoutings;
        }
            shardIDs
                indices.add(indexName);
        );
         * Timestamps should also be a valid long.
    }
            this.lastIndexCreationTime = Long.parseLong(decryptedTokenElements[CREATE_TIME_POS_IN_TOKEN]);
        /**
        PageData(List<ShardRouting> shardRoutings, List<String> indices, PageToken pageToken) {
                }
        IndexMetadata lastAddedIndex = null;
    }
     * TToken would look like: LastShardIdOfPage + | + CreationTimeOfLastRespondedIndex + | + NameOfLastRespondedIndex
     * TokenParser to be used by {@link ShardPaginationStrategy}.
        }
            if (decryptedTokenElements.length != 3) {
                }
        }
            this.pageToken = pageToken;
        public static void validateShardStrategyToken(String requestedTokenStr) {
    }
        }
        public String generateEncryptedToken() {
        if (Objects.isNull(lastIndexName) || Objects.isNull(lastIndexCreationTime)) {
        return pageData.indices;
