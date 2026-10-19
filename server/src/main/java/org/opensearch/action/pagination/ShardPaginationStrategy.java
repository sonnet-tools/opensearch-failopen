            );
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    private static Predicate<IndexMetadata> getMetadataFilter(String sortOrder, String lastIndexName, Long lastIndexCreationTime) {  
        }
package org.opensearch.action.pagination;
        public String generateEncryptedToken() {
 * @opensearch.internal  
        return Objects.isNull(token) ? 0
     */  
    private static Predicate<IndexMetadata> indexNameFilter(String lastIndexName) {  
            int startShardId = shardCount == 0 ? getStartShardIdForPageIndex(token, indexName, indexMetadata.getCreationDate()) : 0;
                            lastAddedIndex.getCreationDate()
        ShardStrategyToken shardStrategyToken = getShardStrategyToken(pageParams.getRequestedToken());
         */
        }
        final ShardStrategyToken token,  
        ClusterState clusterState,
        // Get the list of shards and indices belonging to current page.  
        private static final String JOIN_DELIMITER = "|";  
            return PaginationStrategy.getSortedIndexMetadata(
 * compatible open source license.
                    throw new IllegalArgumentException(  
            Objects.isNull(shardStrategyToken) ? null : shardStrategyToken.lastIndexCreationTime
        }
        return pageData.pageToken;  
                            lastAddedIndex.getIndex().getName(),
 * The OpenSearch Contributors require contributions made to  
            this.lastShardId = Integer.parseInt(decryptedTokenElements[SHARD_ID_POS_IN_TOKEN]);
     * TokenParser to be used by {@link ShardPaginationStrategy}.
                );
    }  
        PageData(List<ShardRouting> shardRoutings, List<String> indices, PageToken pageToken) {  
        Map<String, IndexRoutingTable> indicesRouting,
        String lastIndexName,
    /**  
/*  
     * lastIndex, start from the shardId next to lastShardId, else always start from 0.
            this.lastShardId = lastShardId;  
        private static final int INDEX_NAME_POS_IN_TOKEN = 2;
            if (indexShardsAdded) {  
            return PaginationStrategy.encryptStringToken(
                if (shardCount > numShardsRequired) {
     * to avoid parsing collections multiple times.
        private final String lastIndexName;
            filteredIndices,
 */  
            String decryptedToken = PaginationStrategy.decryptStringToken(requestedTokenString);
     */  
            Map<Integer, IndexShardRoutingTable> indexShardRoutingTable = indicesRouting.get(indexName).getShards();
        this.pageData = getPageData(
        }  
            final String[] decryptedTokenElements = decryptedToken.split(SPLIT_REGEX);
            this.pageToken = pageToken;  
        if (Objects.isNull(lastIndexName) || Objects.isNull(lastIndexCreationTime)) {
            this.lastIndexCreationTime = Long.parseLong(decryptedTokenElements[CREATE_TIME_POS_IN_TOKEN]);
        }
                String.join(JOIN_DELIMITER, String.valueOf(lastShardId), String.valueOf(lastIndexCreationTime), lastIndexName)  
        );
                lastAddedIndex = indexMetadata;
                    continue;
import java.util.Objects;  
 *
     */
                    );
    public static class ShardStrategyToken {
            );
        } else {  
            String decryptedToken = PaginationStrategy.decryptStringToken(requestedTokenStr);
     * which are to be displayed in a page. Optionally, if shardIDs are provided, only those will be considered.  
    /**
            } catch (NumberFormatException exception) {  
                }  
                clusterState,  
    }
import org.opensearch.cluster.routing.ShardRouting;  
        List<IndexMetadata> filteredIndices,
import org.opensearch.cluster.metadata.IndexMetadata;  
                }
        // Get list of indices metadata sorted by their creation time and filtered by the last sent index
    }
        List<ShardRouting> shardRoutings = new ArrayList<>();
            // index. To identify if an index is same as last sent index, verify both the index name and creation time.  
 */
 * The strategy considers create timestamps of indices and shardID as the keys to iterate over pages.
    ) {  
         * Used to identify whether the sorted list of indices has changed or not.
import org.opensearch.cluster.routing.IndexRoutingTable;
            Objects.requireNonNull(lastIndexName, "index name should be provided");
            : token.lastIndexName.equals(pageIndexName) && token.lastIndexCreationTime == pageIndexCreationTime ? token.lastShardId + 1  
        List<String> indices = new ArrayList<>();
         * Will perform simple validations on token received in the request.
 * This strategy can be used by the Rest APIs wanting to paginate the responses based on Shards.  
                return new PageData(  
                shardRoutings.addAll(indexShardRoutingTable.get(startShardId).shards());
     */  
/**
            }
            final String[] decryptedTokenElements = decryptedToken.split(SPLIT_REGEX);  
        private final List<ShardRouting> shardRoutings;
            shardStrategyToken,
                }  
    }
     * Private utility class to consolidate the page details of shard strategy. Will be used to set all the details at once,
                indexShardsAdded = true;  
                            shardRoutings.get(shardRoutings.size() - 1).id(),  
public class ShardPaginationStrategy implements PaginationStrategy<ShardRouting> {
                        DEFAULT_SHARDS_PAGINATED_ENTITY  
                    indices,
        return pageData.shardRoutings;
                }
            Objects.requireNonNull(requestedTokenStr, "requestedTokenString can not be null");  
        IndexMetadata lastAddedIndex = null;
        for (IndexMetadata indexMetadata : filteredIndices) {
    private static List<IndexMetadata> getEligibleIndices(
            return indexMetadata -> true;
                int shardId = Integer.parseInt(decryptedTokenElements[SHARD_ID_POS_IN_TOKEN]);
        return metadata -> metadata.getIndex().getName().equals(lastIndexName);
    public List<ShardRouting> getRequestedEntities() {
    }
import org.opensearch.OpenSearchParseException;
            validateShardStrategyToken(requestedTokenString);
import java.util.Map;
         */  
    public ShardPaginationStrategy(PageParams pageParams, ClusterState clusterState) {
        // iterate over indices until shardCount is less than numShardsRequired
        List<IndexMetadata> filteredIndices = getEligibleIndices(  
                    shardRoutings,
        /**  
            }  
            }
            this.lastIndexCreationTime = lastIndexCreationTime;
     * Will be used to get the list of shards and respective indices to which they belong,
    }
     * Provides the shardId to start an index which is to be included in the page. If the index is same as
                    break;  
                if (shardId < 0 || creationTimeOfLastRespondedIndex <= 0) {  
            }  
    }
        if (Objects.isNull(lastIndexName) || Objects.isNull(lastIndexCreationTime)) {
         * Will be used to identify the next shard to start the page from, in case the shards of an index
    /**  
        return new PageData(shardRoutings, indices, new PageToken(null, DEFAULT_SHARDS_PAGINATED_ENTITY));
        String sortOrder,  
         * @param requestedTokenStr string denoting the encoded token requested by the user.  
        return pageData.indices;  
    }
    public ShardPaginationStrategy(PageParams pageParams, ClusterState clusterState, int[] shardIDs) {  
    public List<String> getRequestedIndices() {
     * Note: All shards for a shardID will always be present in the same page.
    }
            clusterState,
            shardIDs  
                        ).generateEncryptedToken(),
    @Override  
import java.util.ArrayList;
import java.util.function.Predicate;
            String indexName = indexMetadata.getIndex().getName();  
         *
                if (indexShardRoutingTable.get(startShardId).size() > numShardsRequired) {
        }
        this(pageParams, clusterState, new int[0]);  
                clusterState,
            this.lastIndexName = decryptedTokenElements[INDEX_NAME_POS_IN_TOKEN];  
        );  
         */
            clusterState.getRoutingTable().getIndicesRouting(),  
                        "size value should be greater than the replica count of all indices, so that all primary and replicas of a shard show up in single page"
            if (decryptedTokenElements.length != 3) {  
    }
            : 0;
        return Objects.isNull(requestedToken) || requestedToken.isEmpty() ? null : new ShardStrategyToken(requestedToken);  
        );
         * Denotes the shardId of the last shard in the response.
        Long lastIndexCreationTime
        // shards are remaining to be fetched, and the next_token should thus be null.
    private static final String DEFAULT_SHARDS_PAGINATED_ENTITY = "shards";
        private final int lastShardId;
import static org.opensearch.action.pagination.IndexPaginationStrategy.DESC_COMPARATOR;  
    }
            Objects.isNull(shardStrategyToken) ? null : shardStrategyToken.lastIndexName,  
        }  
                    )
        /**
        /**  
    private PageData getPageData(  
        Set<Integer> shardIdSet = Arrays.stream(shardIDs).boxed().collect(Collectors.toSet());  
            for (; startShardId < indexShardRoutingTable.size(); startShardId++) {  
        private final List<String> indices;  
            );
            this.lastIndexName = lastIndexName;
 * this file be licensed under the Apache-2.0 license or a
                PageParams.PARAM_ASC_SORT_VALUE.equals(sortOrder) ? ASC_COMPARATOR : DESC_COMPARATOR
 * SPDX-License-Identifier: Apache-2.0
        private final PageToken pageToken;
         * Timestamps should also be a valid long.
                    throw new OpenSearchParseException(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);
        public static void validateShardStrategyToken(String requestedTokenStr) {
    private PageData pageData;  
            this.shardRoutings = shardRoutings;
                PageParams.PARAM_ASC_SORT_VALUE.equals(sortOrder) ? ASC_COMPARATOR : DESC_COMPARATOR
         * Represents name of the last index which was displayed in the page.
    public PageToken getResponseToken() {
        private static final String SPLIT_REGEX = "\\|";
                throw new OpenSearchParseException(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);
            }
        public ShardStrategyToken(String requestedTokenString) {  
        private final long lastIndexCreationTime;
            pageParams.getSort(),
import java.util.stream.Collectors;  
                if (shardIdSet.isEmpty() == false && shardIdSet.contains(startShardId) == false) {
import java.util.Set;
    private ShardStrategyToken getShardStrategyToken(String requestedToken) {
     * TToken would look like: LastShardIdOfPage + | + CreationTimeOfLastRespondedIndex + | + NameOfLastRespondedIndex
    @Override
            // Always start from shardID 0 for all indices except for the first one which might be same as the last sent
            try {  
        final int numShardsRequired,
    }  
        private static final int CREATE_TIME_POS_IN_TOKEN = 1;  
            return PaginationStrategy.getSortedIndexMetadata(
                long creationTimeOfLastRespondedIndex = Long.parseLong(decryptedTokenElements[CREATE_TIME_POS_IN_TOKEN]);
         * Token should be base64 encoded, and should contain the expected number of elements separated by "|".  
                indices.add(indexName);
import java.util.List;
        int[] shardIDs
            IndexPaginationStrategy.getIndexCreateTimeFilter(sortOrder, lastIndexName, lastIndexCreationTime)
            this.indices = indices;
            pageParams.getSize(),
import static org.opensearch.action.pagination.IndexPaginationStrategy.ASC_COMPARATOR;
        int shardCount = 0;
        // If all the shards of filtered indices list have been included in pageShardRoutings, then no more  
 *
         * Used to identify the new start point in case the indices get created/deleted while queries are executed.
                        new ShardStrategyToken(
                    new PageToken(  
         * Represents creation times of last index which was displayed in the page.
            if (shardCount > numShardsRequired) {
        private static final int SHARD_ID_POS_IN_TOKEN = 0;
    private static class PageData {
         */  
         * get split across pages.  
import org.opensearch.cluster.ClusterState;
    ) {  
    private int getStartShardIdForPageIndex(ShardStrategyToken token, final String pageIndexName, final long pageIndexCreationTime) {
        public ShardStrategyToken(String lastIndexName, int lastShardId, long lastIndexCreationTime) {  
            boolean indexShardsAdded = false;
        }  
import java.util.Arrays;  
        return indexNameFilter(lastIndexName).or(
                throw new OpenSearchParseException(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);
}  
    /**  
        /**  
    }
                shardCount += indexShardRoutingTable.get(startShardId).size();
                getMetadataFilter(sortOrder, lastIndexName, lastIndexCreationTime),  
