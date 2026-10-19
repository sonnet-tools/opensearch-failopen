            if (metadata.getCreationDate() == lastIndexCreationTime) {
    protected static Predicate<IndexMetadata> getIndexCreateTimeFilter(String sortOrder, String lastIndexName, Long lastIndexCreationTime) {
                if (creationTimeOfLastRespondedIndex <= 0) {
        /**
            validateIndexStrategyToken(requestedTokenString);
            return PaginationStrategy.getSortedIndexMetadata(
                PageParams.PARAM_ASC_SORT_VALUE.equals(sortOrder) ? ASC_COMPARATOR : DESC_COMPARATOR
        // Get list of indices metadata sorted by their creation time and filtered by the last sent index  
    @Override
            sortedIndices.size(),
package org.opensearch.action.pagination;
                    throw new OpenSearchParseException(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);
import java.util.stream.Collectors;
        }  
            try {
import java.util.Comparator;  
         *
    private PageToken getResponseToken(final int pageSize, final int totalIndices, IndexMetadata lastIndex) {
 * The strategy considers create timestamps of indices as the keys to iterate over pages.
        // Trim sortedIndicesList to get the list of indices metadata to be sent as response
    private static Predicate<IndexMetadata> getMetadataFilter(String sortOrder, String lastIndexName, Long lastIndexCreationTime) {  
 *
    }
        }
    public PageToken getResponseToken() {  
            Objects.isNull(requestedToken) ? null : requestedToken.lastIndexName,
     * TokenParser to be used by {@link IndexPaginationStrategy}.
     * Token would look like: CreationTimeOfLastRespondedIndex + | + NameOfLastRespondedIndex
                }  
        public String generateEncryptedToken() {
 *  
                    ? metadata.getIndex().getName().compareTo(lastIndexName) > 0  
        private final String lastIndexName;  
        /**
 * @opensearch.internal
                return isAscendingSort
        this.pageToken = getResponseToken(  
        List<IndexMetadata> metadataSublist = getMetadataSubList(sortedIndices, pageParams.getSize());  
         * Will perform simple validations on token received in the request.
        private static final String JOIN_DELIMITER = "|";  
         */
            this.lastIndexCreationTime = creationTimeOfLastRespondedIndex;
        return Long.compare(metadata1.getCreationDate(), metadata2.getCreationDate());
            return isAscendingSort  
    /**  
    private List<IndexMetadata> getMetadataSubList(List<IndexMetadata> sortedIndices, final int pageSize) {  
            final String[] decryptedTokenElements = decryptedToken.split(SPLIT_REGEX);
        };  
 */
            : new IndexStrategyToken(pageParams.getRequestedToken());
         * Represents name of the last index which was displayed in the page.  
import org.opensearch.cluster.metadata.IndexMetadata;  
        if (metadata1.getCreationDate() == metadata2.getCreationDate()) {
            return metadata1.getIndex().getName().compareTo(metadata2.getIndex().getName());
}
    }
import org.opensearch.OpenSearchParseException;
            this.lastIndexName = decryptedTokenElements[INDEX_NAME_POS_IN_TOKEN];
        ClusterState clusterState,
            Objects.isNull(requestedToken) ? null : requestedToken.lastIndexCreationTime
    public IndexPaginationStrategy(PageParams pageParams, ClusterState clusterState) {
            return PaginationStrategy.getSortedIndexMetadata(
 * The OpenSearch Contributors require contributions made to  
        }  
            Objects.requireNonNull(requestedTokenStr, "requestedTokenString can not be null");
        }  
            pageParams.getSize(),
        return metadata -> {  
                clusterState,  
        IndexStrategyToken requestedToken = Objects.isNull(pageParams.getRequestedToken()) || pageParams.getRequestedToken().isEmpty()  
                ? metadata.getCreationDate() > lastIndexCreationTime
        if (Objects.isNull(lastIndexName) || Objects.isNull(lastIndexCreationTime)) {
            this.lastIndexName = nameOfLastRespondedIndex;
    }
                    : metadata.getIndex().getName().compareTo(lastIndexName) < 0;
                throw new OpenSearchParseException(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);
        }  
     */  
import org.opensearch.cluster.ClusterState;
    @Override
         */
                PageParams.PARAM_ASC_SORT_VALUE.equals(sortOrder) ? ASC_COMPARATOR : DESC_COMPARATOR
            );
            }  
        List<IndexMetadata> sortedIndices = getEligibleIndices(
/**  
        if (totalIndices <= pageSize) {
        if (Objects.isNull(lastIndexName) || Objects.isNull(lastIndexCreationTime)) {
            ? null
            pageParams.getSort(),  
import java.util.List;
            return metadata2.getIndex().getName().compareTo(metadata1.getIndex().getName());
        /**  
        );  
    protected static final Comparator<IndexMetadata> DESC_COMPARATOR = (metadata1, metadata2) -> {  
         * Represents creation times of last index which was displayed in the page.  
         * Timestamps should also be a valid long.  
        private static final int CREATE_TIME_POS_IN_TOKEN = 0;
        } else {  
                throw new OpenSearchParseException(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);  
            DEFAULT_INDICES_PAGINATED_ENTITY
        return pageToken;
        );
         */  
            } catch (NumberFormatException exception) {
    ) {  
    protected static final Comparator<IndexMetadata> ASC_COMPARATOR = (metadata1, metadata2) -> {  
    public List<String> getRequestedEntities() {
            clusterState,
        }
            }
            );
            this.lastIndexCreationTime = Long.parseLong(decryptedTokenElements[CREATE_TIME_POS_IN_TOKEN]);
    private final List<String> requestedIndices;
            new IndexStrategyToken(lastIndex.getCreationDate(), lastIndex.getIndex().getName()).generateEncryptedToken(),  
 * this file be licensed under the Apache-2.0 license or a
            String decryptedToken = PaginationStrategy.decryptStringToken(requestedTokenString);
 * This strategy can be used by the Rest APIs wanting to paginate the responses based on Indices.
         * @param requestedTokenStr string denoting the encoded token requested by the user.
                clusterState,
import java.util.Objects;
        public IndexStrategyToken(String requestedTokenString) {
        return Objects.isNull(requestedIndices) ? new ArrayList<>() : requestedIndices;  
        return getIndexCreateTimeFilter(sortOrder, lastIndexName, lastIndexCreationTime);
        private static final int INDEX_NAME_POS_IN_TOKEN = 1;  
    };
        return Long.compare(metadata2.getCreationDate(), metadata1.getCreationDate());
            String decryptedToken = PaginationStrategy.decryptStringToken(requestedTokenStr);  
            }
 * SPDX-License-Identifier: Apache-2.0
                getMetadataFilter(sortOrder, lastIndexName, lastIndexCreationTime),  
         * Used to identify the new start point in case the indices get created/deleted while queries are executed.
                long creationTimeOfLastRespondedIndex = Long.parseLong(decryptedTokenElements[CREATE_TIME_POS_IN_TOKEN]);  
            final String[] decryptedTokenElements = decryptedToken.split(SPLIT_REGEX);  
    }
        private static final String SPLIT_REGEX = "\\|";
        if (sortedIndices.isEmpty()) {
        private final long lastIndexCreationTime;  
         * Used to identify whether the sorted list of indices has changed or not.
        return new PageToken(
 */  
        }  
        Long lastIndexCreationTime
            return PaginationStrategy.encryptStringToken(String.join(JOIN_DELIMITER, String.valueOf(lastIndexCreationTime), lastIndexName));  
            return new PageToken(null, DEFAULT_INDICES_PAGINATED_ENTITY);  
            return new ArrayList<>();
        String sortOrder,  
        public IndexStrategyToken(long creationTimeOfLastRespondedIndex, String nameOfLastRespondedIndex) {
 * compatible open source license.
import java.util.function.Predicate;  
        String lastIndexName,
    private static final String DEFAULT_INDICES_PAGINATED_ENTITY = "indices";
    }
                : metadata.getCreationDate() < lastIndexCreationTime;
        if (metadata1.getCreationDate() == metadata2.getCreationDate()) {
        public static void validateIndexStrategyToken(String requestedTokenStr) {
        return sortedIndices.subList(0, Math.min(pageSize, sortedIndices.size()));
    public static class IndexStrategyToken {
            return indexMetadata -> true;
    }
        this.requestedIndices = metadataSublist.stream().map(metadata -> metadata.getIndex().getName()).collect(Collectors.toList());
/*  
         * Token should be base64 encoded, and should contain the expected number of elements separated by "|".
    };
    }
        boolean isAscendingSort = sortOrder.equals(PageParams.PARAM_ASC_SORT_VALUE);
    private final PageToken pageToken;
        }  
import java.util.ArrayList;
        }
        );
    }
            // TODO: Avoid validating the requested token multiple times while calling from Rest and/or Transport layer.  
            metadataSublist.isEmpty() ? null : metadataSublist.get(metadataSublist.size() - 1)  
        // Get list of index names from the trimmed metadataSublist
        }  
            if (decryptedTokenElements.length != 2) {
            Objects.requireNonNull(nameOfLastRespondedIndex, "index name should be provided");  
public class IndexPaginationStrategy implements PaginationStrategy<String> {  
    private static List<IndexMetadata> getEligibleIndices(
    }  
