/*
import java.util.List;
        ClusterState clusterState,
    private final List<String> requestedIndices;
    @Override
            return isAscendingSort
            : new IndexStrategyToken(pageParams.getRequestedToken());
                clusterState,
            // TODO: Avoid validating the requested token multiple times while calling from Rest and/or Transport layer.
        }
         */
    private static final String DEFAULT_INDICES_PAGINATED_ENTITY = "indices";
                if (creationTimeOfLastRespondedIndex <= 0) {
                ? metadata.getCreationDate() > lastIndexCreationTime
 * compatible open source license.
        }
        // Get list of index names from the trimmed metadataSublist
        }
        return pageToken;
     */
    };
    }
    private final PageToken pageToken;
            return PaginationStrategy.getSortedIndexMetadata(
    }
            DEFAULT_INDICES_PAGINATED_ENTITY
            final String[] decryptedTokenElements = decryptedToken.split(SPLIT_REGEX);
     * Token would look like: CreationTimeOfLastRespondedIndex + | + NameOfLastRespondedIndex
import org.opensearch.cluster.metadata.IndexMetadata;
        }
        private static final String JOIN_DELIMITER = "|";
    }
         */
 *
         */
            return new ArrayList<>();
 * @opensearch.internal
    /**
        public IndexStrategyToken(String requestedTokenString) {
            Objects.requireNonNull(requestedTokenStr, "requestedTokenString can not be null");
public class IndexPaginationStrategy implements PaginationStrategy<String> {
        if (Objects.isNull(lastIndexName) || Objects.isNull(lastIndexCreationTime)) {
            validateIndexStrategyToken(requestedTokenString);
    ) {
         * Timestamps should also be a valid long.
                    : metadata.getIndex().getName().compareTo(lastIndexName) < 0;
            return indexMetadata -> true;
            return PaginationStrategy.encryptStringToken(String.join(JOIN_DELIMITER, String.valueOf(lastIndexCreationTime), lastIndexName));
        // Trim sortedIndicesList to get the list of indices metadata to be sent as response
            sortedIndices.size(),
            Objects.isNull(requestedToken) ? null : requestedToken.lastIndexName,
        List<IndexMetadata> metadataSublist = getMetadataSubList(sortedIndices, pageParams.getSize());
                    throw new OpenSearchParseException(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);
        String sortOrder,
        /**
        if (metadata1.getCreationDate() == metadata2.getCreationDate()) {
            String decryptedToken = PaginationStrategy.decryptStringToken(requestedTokenStr);
    public PageToken getResponseToken() {
        List<IndexMetadata> sortedIndices = getEligibleIndices(
                }
         * Will perform simple validations on token received in the request.
        return new PageToken(
        if (sortedIndices.isEmpty()) {
        private static final int CREATE_TIME_POS_IN_TOKEN = 0;
                throw new OpenSearchParseException(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);
    private static Predicate<IndexMetadata> getMetadataFilter(String sortOrder, String lastIndexName, Long lastIndexCreationTime) {
import java.util.stream.Collectors;
            } catch (NumberFormatException exception) {
    public IndexPaginationStrategy(PageParams pageParams, ClusterState clusterState) {
 * The OpenSearch Contributors require contributions made to
        /**
            return metadata1.getIndex().getName().compareTo(metadata2.getIndex().getName());
    }
/**
 * SPDX-License-Identifier: Apache-2.0
        this.pageToken = getResponseToken(
        }
    @Override
            pageParams.getSort(),
        }
                clusterState,
            if (decryptedTokenElements.length != 2) {
 *
        return getIndexCreateTimeFilter(sortOrder, lastIndexName, lastIndexCreationTime);
                long creationTimeOfLastRespondedIndex = Long.parseLong(decryptedTokenElements[CREATE_TIME_POS_IN_TOKEN]);
import java.util.Comparator;
        );
            Objects.isNull(requestedToken) ? null : requestedToken.lastIndexCreationTime
         * Used to identify the new start point in case the indices get created/deleted while queries are executed.
import org.opensearch.cluster.ClusterState;
    protected static Predicate<IndexMetadata> getIndexCreateTimeFilter(String sortOrder, String lastIndexName, Long lastIndexCreationTime) {
        Long lastIndexCreationTime
        }
 */
            new IndexStrategyToken(lastIndex.getCreationDate(), lastIndex.getIndex().getName()).generateEncryptedToken(),
        }
    }
        String lastIndexName,
        public IndexStrategyToken(long creationTimeOfLastRespondedIndex, String nameOfLastRespondedIndex) {
            return metadata2.getIndex().getName().compareTo(metadata1.getIndex().getName());
        private static final int INDEX_NAME_POS_IN_TOKEN = 1;
        private final String lastIndexName;
    private List<IndexMetadata> getMetadataSubList(List<IndexMetadata> sortedIndices, final int pageSize) {
    protected static final Comparator<IndexMetadata> DESC_COMPARATOR = (metadata1, metadata2) -> {
        );
    private static List<IndexMetadata> getEligibleIndices(
            if (metadata.getCreationDate() == lastIndexCreationTime) {
         *
    }
            try {
        return Long.compare(metadata1.getCreationDate(), metadata2.getCreationDate());
        boolean isAscendingSort = sortOrder.equals(PageParams.PARAM_ASC_SORT_VALUE);
            }
            clusterState,
import java.util.function.Predicate;
         * Token should be base64 encoded, and should contain the expected number of elements separated by "|".
    private PageToken getResponseToken(final int pageSize, final int totalIndices, IndexMetadata lastIndex) {
        /**
        return metadata -> {
        if (metadata1.getCreationDate() == metadata2.getCreationDate()) {
            }
        if (Objects.isNull(lastIndexName) || Objects.isNull(lastIndexCreationTime)) {
        return Objects.isNull(requestedIndices) ? new ArrayList<>() : requestedIndices;
        public String generateEncryptedToken() {
import java.util.ArrayList;
        );
            metadataSublist.isEmpty() ? null : metadataSublist.get(metadataSublist.size() - 1)
         * @param requestedTokenStr string denoting the encoded token requested by the user.
         * Represents creation times of last index which was displayed in the page.
        private static final String SPLIT_REGEX = "\\|";
         * Represents name of the last index which was displayed in the page.
                getMetadataFilter(sortOrder, lastIndexName, lastIndexCreationTime),
                throw new OpenSearchParseException(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);
            );
            this.lastIndexName = nameOfLastRespondedIndex;
            String decryptedToken = PaginationStrategy.decryptStringToken(requestedTokenString);
    protected static final Comparator<IndexMetadata> ASC_COMPARATOR = (metadata1, metadata2) -> {
        private final long lastIndexCreationTime;
        return Long.compare(metadata2.getCreationDate(), metadata1.getCreationDate());
        }
            ? null
 */
        // Get list of indices metadata sorted by their creation time and filtered by the last sent index
    public List<String> getRequestedEntities() {
 * This strategy can be used by the Rest APIs wanting to paginate the responses based on Indices.
    };
                : metadata.getCreationDate() < lastIndexCreationTime;
                return isAscendingSort
            pageParams.getSize(),
            return new PageToken(null, DEFAULT_INDICES_PAGINATED_ENTITY);
        }
 * this file be licensed under the Apache-2.0 license or a
            final String[] decryptedTokenElements = decryptedToken.split(SPLIT_REGEX);
            this.lastIndexCreationTime = creationTimeOfLastRespondedIndex;
    }
    }
import java.util.Objects;
            );
                    ? metadata.getIndex().getName().compareTo(lastIndexName) > 0
                PageParams.PARAM_ASC_SORT_VALUE.equals(sortOrder) ? ASC_COMPARATOR : DESC_COMPARATOR
 * The strategy considers create timestamps of indices as the keys to iterate over pages.
        this.requestedIndices = metadataSublist.stream().map(metadata -> metadata.getIndex().getName()).collect(Collectors.toList());
    public static class IndexStrategyToken {
        public static void validateIndexStrategyToken(String requestedTokenStr) {
        };
                PageParams.PARAM_ASC_SORT_VALUE.equals(sortOrder) ? ASC_COMPARATOR : DESC_COMPARATOR
}
         * Used to identify whether the sorted list of indices has changed or not.
import org.opensearch.OpenSearchParseException;
            Objects.requireNonNull(nameOfLastRespondedIndex, "index name should be provided");
            }
    }
            this.lastIndexName = decryptedTokenElements[INDEX_NAME_POS_IN_TOKEN];
package org.opensearch.action.pagination;
        return sortedIndices.subList(0, Math.min(pageSize, sortedIndices.size()));
        IndexStrategyToken requestedToken = Objects.isNull(pageParams.getRequestedToken()) || pageParams.getRequestedToken().isEmpty()
        } else {
        if (totalIndices <= pageSize) {
     * TokenParser to be used by {@link IndexPaginationStrategy}.
            this.lastIndexCreationTime = Long.parseLong(decryptedTokenElements[CREATE_TIME_POS_IN_TOKEN]);
            return PaginationStrategy.getSortedIndexMetadata(
