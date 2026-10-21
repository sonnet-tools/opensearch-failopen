import java.util.Collections;
            .numberOfShards(numShards)
            clusterState,
                // asserting the result of 11th query, which should only contain 3 shardIDs belonging to test-index-7
    }
            shardRoutings.stream().filter(shard -> newIndices.contains(shard.getIndexName())).collect(Collectors.toList()),
        );
        final int numShards,
            fail("expected exception");
                assertEquals(totalShards, shardRoutings.size());
     * @return random clusterState consisting of indices having their creation times set to the integer used to name them.
import java.util.ArrayList;
            .routingTable(RoutingTable.builder().build())
        } while (Objects.nonNull(requestedToken));
            new ShardPaginationStrategy.ShardStrategyToken(null);
                    List<String> pageIndices = strategy.getRequestedIndices();
                assertEquals(TEST_INDEX_PREFIX + 7, paginationStrategy.getRequestedIndices().get(0));
        do {
        // deleted test-index-94, should appear in the response shards and indices
        List<Integer> indexNumberList = new ArrayList<>();
                    lastPageIndexTime = currentLastIndexTime;
        String requestedToken = null;
                    clusterState = addIndexToClusterState(clusterState, indexNumber, numShardsForNewIndices, numReplicasForNewIndices);
            if (numPages == 11) {
        // to ensure number of shards in last page is not always equal to pageSize.
                deletedIndices = indexNumberList.subList(20, indexNumberList.size());
                        } else {
    public void testIndexStrategyPageTokenWithIncorrectNumberOfElementsInRequestedToken() {
                        clusterState.metadata().index(shard.getIndexName()).getCreationDate() < clusterState.metadata()
            PageParams pageParams = new PageParams(requestedToken, PARAM_ASC_SORT_VALUE, pageSize);
        assertEquals(TEST_INDEX_PREFIX + 3, strategy.getRequestedIndices().get(0));
    /**
        );
                strategy = new ShardPaginationStrategy(pageParams, clusterState);
    }
            OpenSearchParseException.class,
        // Checking pagination response for different pageSizes, which has a mix of even and odd numbers
        assertEquals(totalIndices + numIndicesToCreate - numIndicesToDelete, indicesFetched.size());
    public void testCreatingIndexStrategyPageTokenWithNameOfLastRespondedIndexNull() {
import java.util.Set;
                    clusterState = deleteIndexFromClusterState(clusterState, index);
            String indexName = TEST_INDEX_PREFIX + indexNumber;
                Collections.shuffle(deletedIndices, getRandom());
            assert e.getMessage().contains("index name should be provided");
        final int fixedIndexNumToDelete = 7;
import static org.opensearch.action.pagination.PageParams.PARAM_ASC_SORT_VALUE;
    }
            assertEquals(shardRoutings.stream().filter(shard -> shard.getIndexName().equals(indexName)).count(), 0);
        return addIndexToClusterState(
            assertTrue(e.getMessage().contains("size value should be greater than the replica count of all indices"));
        );
    /**
        assertThrows(
            numPages++;
        final int pageSize = (numReplicas + 1) * 2;
        // since test-index-3 should now be considered a new index, all shards for it should appear
                            .index(prevShard.getIndexName())
                        }
                for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
                assertEquals(TEST_INDEX_PREFIX + 6, shardRoutings.get(shardRoutings.size() - 1).getIndexName());
            assert e.getMessage().contains(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);
            ShardPaginationStrategy paginationStrategy = new ShardPaginationStrategy(pageParams, clusterState);
            .routingTable(RoutingTable.builder(clusterState.routingTable()).remove(TEST_INDEX_PREFIX + indexNumber).build())
            requestedToken = paginationStrategy.getResponseToken().getNextToken();
                }
package org.opensearch.action.pagination;
import java.util.List;
        } catch (Exception e) {
    public void testCreatingShardStrategyPageTokenWithRequestedTokenNull() {
                    );
        for (ShardRouting shardRouting : strategy.getRequestedEntities()) {
        // all the newly created indices should be present in the list of fetched indices
        assertEquals(8, strategy.getRequestedEntities().size());
                int totalPagesToFetch = (int) Math.ceil(totalShards * 1.0 / (pageSize - pageSize % (DEFAULT_NUMBER_OF_REPLICAS + 1)));
            assertFalse(indicesFetched.contains(indexName));
        do {
            // deleting test-index-94 & 10 more random indices after 11th call. By that time, shards for last 6
    }
        int numReplicas = 8;
                }
        }
                // asserting last elements of current response list, which should be the last shard of test-index-6
        return ClusterState.builder(clusterState)
                    PageParams pageParams = new PageParams(requestedToken, sortOrder, pageSize);
import org.opensearch.cluster.ClusterState;
        int pageSize = 10;
        assertThrows(
    }
        List<String> sortOrderList = List.of(PARAM_ASC_SORT_VALUE, PARAM_DESC_SORT_VALUE);
            * (DEFAULT_NUMBER_OF_REPLICAS + 1);
            }
            // creating 5 indices after 5th call
        try {
        int numPages = 0;
        assertEquals(4, strategy.getRequestedEntities().size());
     * should appear in the response.
            .build();
        final int indexNumber,
    }
                    );
        for (int index = 1; index < numIndices; index++) {
public class ShardPaginationStrategyTests extends OpenSearchTestCase {
    }
import org.opensearch.cluster.ClusterName;
        String requestedToken = null;
            .metadata(Metadata.builder(clusterState.metadata()).remove(TEST_INDEX_PREFIX + indexNumber))
    }
            }
    private ClusterState getRandomClusterState(List<Integer> indexNumbers) {
                // asserting last elements of current response list, which should be the last shard of test-index-95
            shardRoutings.stream().filter(shard -> shard.getIndexName().equals(TEST_INDEX_PREFIX + 7)).count(),
     * while no indices are created or deleted during the fetch.
            .numberOfReplicas(numReplicas)
                            .index(prevShard.getIndexName())
                shardRoutings.stream().filter(shard -> shard.getIndexName().equals(indexName)).count()
                        .get(pageShards.get(pageShards.size() - 1).getIndexName())
        // creating a cluster state with 100 indices
}
                long lastPageIndexTime = 0;
                        .getCreationDate();
            assertFalse(indicesFetched.contains(indexName));
                assertEquals(3 * (DEFAULT_NUMBER_OF_REPLICAS + 1), paginationStrategy.getRequestedEntities().size());
            numPages++;
            3 * (DEFAULT_NUMBER_OF_REPLICAS + 1)
        assertEquals(1, strategy.getRequestedIndices().size());
            assertNotNull(paginationStrategy);
                // of shards in a page should always be a multiple of (replicas + 1).
        // deleted test-index-7, should appear in the response shards and indices
        IndexMetadata indexMetadata = IndexMetadata.builder(TEST_INDEX_PREFIX + indexNumber)
        for (ShardRouting shard : shardRoutings.subList(1, shardRoutings.size())) {
            }
            OpenSearchParseException.class,
            }
            assertNotNull(paginationStrategy.getResponseToken());
        } catch (Exception e) {
        PageParams pageParams = new PageParams(requestedToken, PARAM_ASC_SORT_VALUE, pageSize);
            if (Objects.equals(shard.getIndexName(), prevShard.getIndexName())) {
     * Test validates fetching all the shards (in desc order) for 100 indices in a paginated fashion using {@link ShardPaginationStrategy}.
    private void verifyOrderForAllShards(ClusterState clusterState, List<ShardRouting> shardRoutings, String sortOrder) {
            fail("expected exception");
        ClusterState clusterState,
            Instant.now().plus(4, ChronoUnit.SECONDS).toEpochMilli()
            .build();
    /**
    private static final int DEFAULT_NUMBER_OF_SHARDS = 5;
                assertTrue(shard.getId() >= prevShard.getId());
            } else {
                    } else {
    ) {
                    assertTrue(
        assertEquals(
        for (int indexNum = 1; indexNum <= totalIndices; indexNum++) {
     */
                clusterState = deleteIndexFromClusterState(clusterState, fixedIndexNumToDelete);
                    clusterState = addIndexToClusterState(clusterState, indexNumber, numShardsForNewIndices, numReplicasForNewIndices);
    private static final String TEST_INDEX_PREFIX = "test-index-";
import java.util.HashSet;
                }
            assertTrue(paginationStrategy.getRequestedEntities().size() <= pageSize);
        List<ShardRouting> shardRoutings = new ArrayList<>();
        ClusterState clusterState = getRandomClusterState(Collections.emptyList());
    private ClusterState addIndexToClusterState(
        final int totalShards = totalIndices * DEFAULT_NUMBER_OF_SHARDS * (DEFAULT_NUMBER_OF_REPLICAS + 1);
import static org.opensearch.action.pagination.PaginationStrategy.INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE;
                    clusterState = deleteIndexFromClusterState(clusterState, index);
            requestedToken = strategy.getResponseToken().getNextToken();
        final int numShards,
        final int totalInitialShards = totalIndices * DEFAULT_NUMBER_OF_SHARDS * (DEFAULT_NUMBER_OF_REPLICAS + 1);
import org.opensearch.cluster.routing.RoutingTable;
            fail("expected exception");
            shardRoutings.addAll(paginationStrategy.getRequestedEntities());
            .metadata(Metadata.builder().build())
                assertEquals(1, paginationStrategy.getRequestedIndices().size());
                assertEquals(TEST_INDEX_PREFIX + 95, shardRoutings.get(shardRoutings.size() - 1).getIndexName());
        // finalTotalShards = InitialTotal - 2ShardIdsForIndex7 - ShardsFor10RandomlyDeletedIndices
            3 * (DEFAULT_NUMBER_OF_REPLICAS + 1)
            new ShardPaginationStrategy.ShardStrategyToken(null, 0, 1234l);
    }
        }
        ClusterState clusterState = getRandomClusterState(indexNumberList);
import org.opensearch.cluster.metadata.IndexMetadata;
        List<Integer> pageSizeList = List.of(3, 7, 10, 13);
            * (DEFAULT_NUMBER_OF_REPLICAS + 1) + numIndicesToCreate * numShardsForNewIndices * (numReplicasForNewIndices + 1);
        final int indexNumber,
                deletedIndices = indexNumberList.subList(0, 80);
        }
            // if it gets deleted, rest 2 shardIDs for it should not appear.
                assertEquals(2, paginationStrategy.getRequestedEntities().get(8).id());
        List<Integer> deletedIndices = new ArrayList<>();
        final int numReplicas
            strategy = new ShardPaginationStrategy(pageParams, clusterState);
        int numShards = 5;
import java.util.Objects;
                } else {
     * with some other indices which are yet to be fetched. It also creates new indices in between the queries.
            numReplicas,
            if (numPages == 5) {
import org.opensearch.OpenSearchParseException;
     */
    private static final int DEFAULT_NUMBER_OF_REPLICAS = 2;
    private ClusterState addIndexToClusterState(
                assertEquals(DEFAULT_NUMBER_OF_SHARDS - 1, shardRoutings.get(shardRoutings.size() - 1).getId());
        );
            requestedToken = paginationStrategy.getResponseToken().getNextToken();
        final int totalIndices = 100;
        int numPages = 0;
            if (numPages == 11) {
                    }
            indexNumberList.add(indexNumber);
            String requestedToken = null;
                PageParams pageParams = new PageParams(requestedToken, PARAM_ASC_SORT_VALUE, pageSize);
        final long creationTime
                if (sortOrder.equals(PARAM_ASC_SORT_VALUE)) {
        assertTrue(indicesFetched.contains(TEST_INDEX_PREFIX + fixedIndexNumToDelete));
        int numIndices = 6;
        final int totalPages = (int) Math.ceil((totalIndices * numShards * (numReplicas + 1) * 1.0) / pageSize);
            .build();
    /**
     * than #(replicas + 1) for any of the index.
        final int numIndicesToDelete = 10;
    }
     * Shards corresponding to indices deleted, should not be fetched while for the indices which were newly created,
                verifyOrderForAllShards(clusterState, shardRoutings, sortOrder);
                for (int pageNum = 1; pageNum <= totalPagesToFetch; pageNum++) {
                            assertTrue(lastPageIndexTime <= currentLastIndexTime);
            // indices would have been completely fetched. 11th call, would fetch first 3 shardsIDs for test-index-7 and
                requestedToken = strategy.getResponseToken().getNextToken();
        for (int page = 1; page < totalPages; page++) {
 * The OpenSearch Contributors require contributions made to
                        clusterState.metadata().index(shard.getIndexName()).getCreationDate() > clusterState.metadata()
        final int totalIndices = 100;
            } while (requestedToken != null);
/*
            Instant.now().plus(indexNumber, ChronoUnit.SECONDS).toEpochMilli()
            assertTrue(shardRouting.getId() == 2 && Objects.equals(shardRouting.getIndexName(), TEST_INDEX_PREFIX + 3));
        final int numReplicas = 3;
        for (Integer index : deletedIndices) {
import static com.carrotsearch.randomizedtesting.RandomizedTest.getRandom;
        for (int deletedIndex : deletedIndices) {
        ClusterState clusterState = getRandomClusterState(Collections.emptyList());
        ShardRouting prevShard = shardRoutings.get(0);
        assertThrows(
    public void testIndexStrategyPageTokenWithInvalidValuesInRequestedToken() {
        }
        final int numShardsForNewIndices = 4;
                    }
        final int numReplicasForNewIndices = 5;
import java.util.stream.Collectors;
            shardRoutings.addAll(paginationStrategy.getRequestedEntities());
import java.time.Instant;
        for (ShardRouting shardRouting : strategy.getRequestedEntities()) {
                assertEquals(DEFAULT_NUMBER_OF_SHARDS - 1, shardRoutings.get(shardRoutings.size() - 1).getId());
                Set<String> indices = new HashSet<>();
        clusterState = addIndexToClusterState(clusterState, numIndices, numShards + 1, numReplicas + 1);
                            assertTrue(lastPageIndexTime >= currentLastIndexTime);
            numShards,
        return clusterState;
        List<Integer> deletedIndices = new ArrayList<>();
        // finalTotalShards = InitialTotal - 2ShardIdsForIndex7 - ShardsFor10RandomlyDeletedIndices + ShardsForNewlyCreatedIndices
        }
     */
            assertTrue(
    }
    }
        assertTrue(indicesFetched.contains(TEST_INDEX_PREFIX + 7));
                deletedIndices = deletedIndices.subList(0, numIndicesToDelete);
        } while (Objects.nonNull(requestedToken));
        assertEquals(TEST_INDEX_PREFIX + 3, strategy.getRequestedIndices().get(0));
        final int numIndicesToCreate = 5;
import org.opensearch.cluster.routing.ShardRouting;
                for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
            indicesFetched.addAll(paginationStrategy.getRequestedIndices());
            assertTrue(indicesFetched.contains(indexName));
        final int numReplicas,
            .build();
    public void testIndexStrategyPageTokenWithWronglyEncryptedRequestToken() {
            // creating 5 indices after 5th call
     * Validates strategy fails with IllegalArgumentException when requests size in pageParam is smaller
        }
        assertEquals(totalShards, shardRoutings.size());
            assertEquals(shardRoutings.stream().filter(shard -> shard.getIndexName().equals(indexName)).count(), 0);
    public void testRetrieveAllShardsInDescOrderWhileIndicesGetCreatedAndDeleted() {
                            .getCreationDate()
import org.opensearch.test.OpenSearchTestCase;
            PARAM_ASC_SORT_VALUE
                            .getCreationDate()
        );
        for (int indexNumber = 1; indexNumber <= 100; indexNumber++) {
            assertEquals(0, shardRoutings.stream().filter(shard -> shard.getIndexName().equals(indexName)).count());
     */
        assertEquals(TEST_INDEX_PREFIX + 3, strategy.getRequestedIndices().get(0));
        );
        assertEquals(1, strategy.getRequestedIndices().size());
            .routingTable(RoutingTable.builder(clusterState.routingTable()).add(indexRoutingTableBuilder).build())
        );
import java.time.temporal.ChronoUnit;
        }
        for (int indexNumber = 1; indexNumber <= 100; indexNumber++) {
        clusterState = addIndexToClusterState(
        final int numIndicesToDelete = 10;
        }
            assert e.getMessage().contains("requestedTokenString can not be null");
        assertEquals(1, strategy.getRequestedIndices().size());
    public void testIllegalSizeArgumentRequestedFromStrategy() {
                assertEquals(2, paginationStrategy.getRequestedEntities().get(8).id());
                prevShard = shard;
            // deleting test-index-7 & 10 more random indices after 11th call. By that time, shards for first 6
    public void testRetrieveShardsWhenLastIndexGetsDeletedAndReCreated() {
                    shardRoutings.addAll(pageShards);
        }
        ShardPaginationStrategy strategy = null;
            () -> new ShardPaginationStrategy.ShardStrategyToken(PaginationStrategy.encryptStringToken("1|1725361543"))
            numShards,
                }
        try {
import org.opensearch.cluster.routing.IndexRoutingTable;
import org.opensearch.Version;
            clusterState,
            do {
        final int numIndicesToCreate = 5;
        final int totalShards = totalInitialShards - 2 * (DEFAULT_NUMBER_OF_REPLICAS + 1) - numIndicesToDelete * DEFAULT_NUMBER_OF_SHARDS
                // verifying the order of shards in the response.
                assertEquals(3 * (DEFAULT_NUMBER_OF_REPLICAS + 1), paginationStrategy.getRequestedEntities().size());
        final int numShardsForNewIndices = 4;
        for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
            assertEquals(
        final int fixedIndexNumToDelete = 94;
     * Test validates fetching all the shards (in asc order) for 100 indices in a paginated fashion using {@link ShardPaginationStrategy}.
            );
        clusterState = deleteIndexFromClusterState(clusterState, 3);
            OpenSearchParseException.class,
            String indexName = TEST_INDEX_PREFIX + deletedIndex;
        int pageSize = numReplicas + 1;
            assertFalse(indicesFetched.contains(indexName));
     * with some other indices which are yet to be fetched. It also creates new indices in between the queries.
 * this file be licensed under the Apache-2.0 license or a
                    if (lastPageIndexTime > 0) {
        List<String> newIndices = new ArrayList<>();
        Collections.shuffle(indexNumberList, getRandom());
        // Delete the index and re-create
            indexMetadata
import org.opensearch.cluster.metadata.Metadata;
        for (String sortOrder : sortOrderList) {
                List<ShardRouting> shardRoutings = new ArrayList<>();
     * should appear in the response.
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
                        assertNull(strategy.getResponseToken().getNextToken());
    /**
                (shardRouting.getId() == 0 || shardRouting.getId() == 1)
        assertNotNull(strategy.getResponseToken().getNextToken());
            // indices would have been completely fetched. 11th call, would fetch first 3 shardsIDs for test-index-94 and
        ClusterState clusterState = getRandomClusterState(indexNumberList);
            PageParams pageParams = new PageParams(requestedToken, PARAM_DESC_SORT_VALUE, pageSize);
        assertEquals(
     */
            shardRoutings.stream().filter(shard -> shard.getIndexName().equals(TEST_INDEX_PREFIX + fixedIndexNumToDelete)).count(),
        }
        final int numReplicasForNewIndices = 5;
        Set<String> indicesFetched = new HashSet<>();
            ShardPaginationStrategy paginationStrategy = new ShardPaginationStrategy(pageParams, clusterState);
        }
        }
        Set<String> indicesFetched = new HashSet<>();
     * Test validates fetching all the shards for 100 indices in a paginated fashion using {@link ShardPaginationStrategy},
        }
        for (Integer indexNumber : indexNumbers) {
                    ShardPaginationStrategy strategy = new ShardPaginationStrategy(pageParams, clusterState);
        // The last page was supposed to fetch the remaining two indices for test-index-3
        assertEquals(8, strategy.getRequestedEntities().size());
        }
        for (int indexNumber = 1; indexNumber <= 100; indexNumber++) {
                clusterState = deleteIndexFromClusterState(clusterState, fixedIndexNumToDelete);
                // asserting the result of 11th query, which should only contain 3 shardIDs belonging to test-index-7
                assertEquals(TEST_INDEX_PREFIX + 94, paginationStrategy.getRequestedIndices().get(0));
            assertTrue(paginationStrategy.getRequestedEntities().size() <= pageSize);
        }
                }
        List<Integer> indexNumberList = new ArrayList<>();
            // if it gets deleted, rest 2 shardIDs for it should not appear.
            String indexName = TEST_INDEX_PREFIX + indexNumber;
        for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
     * @param indexNumbers would be used to create indices having names with integer appended after foo, like foo1, foo2.
                    if (pageNum < totalPagesToFetch) {
        try {
        }
        ClusterState clusterState,
     * Shards corresponding to indices deleted, should not be fetched while for the indices which were newly created,
        try {
        IndexRoutingTable.Builder indexRoutingTableBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex()).initializeAsNew(
                    indices.addAll(pageIndices);
            clusterState = addIndexToClusterState(clusterState, index, numShards, numReplicas);
        final int totalShards = totalInitialShards - 2 * (DEFAULT_NUMBER_OF_REPLICAS + 1) - numIndicesToDelete * DEFAULT_NUMBER_OF_SHARDS
 */
            ShardPaginationStrategy strategy;
                    assertTrue(
            3,
import static org.opensearch.action.pagination.PageParams.PARAM_DESC_SORT_VALUE;
                }
            clusterState = addIndexToClusterState(clusterState, indexNumber, DEFAULT_NUMBER_OF_SHARDS, DEFAULT_NUMBER_OF_REPLICAS);
 * SPDX-License-Identifier: Apache-2.0
            for (int pageSize : pageSizeList) {
        final int totalIndices = 100;
            clusterState,
            indexNumber,
            .settings(settings(Version.CURRENT).put(SETTING_CREATION_DATE, creationTime))
            PageParams pageParams = new PageParams(requestedToken, PARAM_ASC_SORT_VALUE, pageSize);
        } catch (Exception e) {
    public void testRetrieveAllShardsInAscOrderWhileIndicesGetCreatedAndDeleted() {
            new ShardPaginationStrategy.ShardStrategyToken(PaginationStrategy.encryptStringToken("shardID|1725361543|index"));
            fail("expected exception");
            clusterState = addIndexToClusterState(clusterState, indexNum, numShards, numReplicas);
                        assertNotNull(strategy.getResponseToken().getNextToken());
        List<Integer> indexNumberList = new ArrayList<>();
    ) {
        // none of the randomly deleted index should appear in the list of fetched indices
            }
        assertEquals(totalIndices - numIndicesToDelete, indicesFetched.size());
        );
        strategy = new ShardPaginationStrategy(pageParams, clusterState);
            indicesFetched.addAll(paginationStrategy.getRequestedIndices());
            numReplicas,
        );
        final int totalInitialShards = totalIndices * DEFAULT_NUMBER_OF_SHARDS * (DEFAULT_NUMBER_OF_REPLICAS + 1);
            .metadata(Metadata.builder(clusterState.metadata()).put(indexMetadata, true).build())
                    List<ShardRouting> pageShards = strategy.getRequestedEntities();
    }
        }
        }
    private ClusterState deleteIndexFromClusterState(ClusterState clusterState, int indexNumber) {
                numShardsForNewIndices * (numReplicasForNewIndices + 1),
        verifyOrderForAllShards(
            () -> new ShardPaginationStrategy.ShardStrategyToken(PaginationStrategy.encryptStringToken("-1725361543|1725361543|index"))
    }
        // none of the newly created indices should be present in the list of fetched indices
            }
                    && Objects.equals(shardRouting.getIndexName(), TEST_INDEX_PREFIX + 3)
                    long currentLastIndexTime = clusterState.metadata()
            indexNumberList.add(indexNumber);
        int pageSize = 10;
    public void testRetrieveAllShardsWithVaryingPageSize() {
                String requestedToken = null;
            () -> new ShardPaginationStrategy.ShardStrategyToken(PaginationStrategy.encryptStringToken("1|1725361543|index|12345"))
        String requestedToken = null;
                for (Integer index : deletedIndices) {
        // none of the randomly deleted index should appear in the list of fetched indices
 *
            assertNotNull(paginationStrategy);
        strategy = new ShardPaginationStrategy(pageParams, clusterState);
                        if (sortOrder.equals(PARAM_ASC_SORT_VALUE)) {
        List<ShardRouting> shardRoutings = new ArrayList<>();
     * While executing queries, it tries to delete an index for which some of the shards have already been fetched along
                        .indices()
        return ClusterState.builder(clusterState)
        assertEquals(totalShards, shardRoutings.size());
        final int totalIndices = 3;
            String indexName = TEST_INDEX_PREFIX + index;
        pageParams = new PageParams(requestedToken, PARAM_ASC_SORT_VALUE, pageSize);
                    requestedToken = strategy.getResponseToken().getNextToken();
 * compatible open source license.
                // Since each shardID will have number of (replicas + 1) shards, thus number
    }
                assertEquals(1, paginationStrategy.getRequestedIndices().size());
        } catch (IllegalArgumentException e) {
     * While executing queries, it tries to delete an index for which some of the shards have already been fetched along
                Collections.shuffle(deletedIndices, getRandom());
            );
        assertThrows(OpenSearchParseException.class, () -> new ShardPaginationStrategy.ShardStrategyToken("3%4%5"));
                assertEquals(totalIndices, indices.size());
                deletedIndices = deletedIndices.subList(0, numIndicesToDelete);
        assertNull(strategy.getResponseToken().getNextToken());
                for (Integer index : deletedIndices) {
            assertNotNull(paginationStrategy.getResponseToken());
        }
            if (numPages == 5) {
            indexNumberList.add(indexNumber);
                    newIndices.add(TEST_INDEX_PREFIX + indexNumber);
    }
        ClusterState clusterState = ClusterState.builder(new ClusterName("test"))
        requestedToken = strategy.getResponseToken().getNextToken();
    public void testCreatingIndexStrategyPageTokenWithNonParseableShardID() {
        ClusterState clusterState = getRandomClusterState(indexNumberList);
        final int numShards = 3;
