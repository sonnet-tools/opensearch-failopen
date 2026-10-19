            shardRoutings.addAll(paginationStrategy.getRequestedEntities());  
        int numIndices = 6;  
            numReplicas,
            assertTrue(indicesFetched.contains(indexName));
    private static final String TEST_INDEX_PREFIX = "test-index-";  
 * this file be licensed under the Apache-2.0 license or a
import java.time.Instant;  
    }
        Set<String> indicesFetched = new HashSet<>();  
            if (numPages == 11) {
        assertTrue(indicesFetched.contains(TEST_INDEX_PREFIX + fixedIndexNumToDelete));
        }  
        List<Integer> indexNumberList = new ArrayList<>();  
            .numberOfShards(numShards)  
            () -> new ShardPaginationStrategy.ShardStrategyToken(PaginationStrategy.encryptStringToken("-1725361543|1725361543|index"))
import org.opensearch.cluster.ClusterName;  
import java.util.ArrayList;
                if (sortOrder.equals(PARAM_ASC_SORT_VALUE)) {
import java.util.List;
            if (numPages == 5) {  
        final int totalInitialShards = totalIndices * DEFAULT_NUMBER_OF_SHARDS * (DEFAULT_NUMBER_OF_REPLICAS + 1);
                assertEquals(TEST_INDEX_PREFIX + 95, shardRoutings.get(shardRoutings.size() - 1).getIndexName());  
        List<String> newIndices = new ArrayList<>();
        for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {  
        assertThrows(
        // all the newly created indices should be present in the list of fetched indices
        assertEquals(
                deletedIndices = deletedIndices.subList(0, numIndicesToDelete);
        assertEquals(TEST_INDEX_PREFIX + 3, strategy.getRequestedIndices().get(0));
                assertEquals(DEFAULT_NUMBER_OF_SHARDS - 1, shardRoutings.get(shardRoutings.size() - 1).getId());
        final int totalInitialShards = totalIndices * DEFAULT_NUMBER_OF_SHARDS * (DEFAULT_NUMBER_OF_REPLICAS + 1);
        // deleted test-index-94, should appear in the response shards and indices  
        final int totalShards = totalIndices * DEFAULT_NUMBER_OF_SHARDS * (DEFAULT_NUMBER_OF_REPLICAS + 1);
        }
            .numberOfReplicas(numReplicas)
        int pageSize = 10;
    public void testRetrieveAllShardsInAscOrderWhileIndicesGetCreatedAndDeleted() {
        return clusterState;  
            .routingTable(RoutingTable.builder(clusterState.routingTable()).add(indexRoutingTableBuilder).build())
                    indices.addAll(pageIndices);  
        // none of the newly created indices should be present in the list of fetched indices
                        .indices()
            * (DEFAULT_NUMBER_OF_REPLICAS + 1);  
            assertEquals(shardRoutings.stream().filter(shard -> shard.getIndexName().equals(indexName)).count(), 0);
 * compatible open source license.
            fail("expected exception");  
            PageParams pageParams = new PageParams(requestedToken, PARAM_DESC_SORT_VALUE, pageSize);
                    clusterState = deleteIndexFromClusterState(clusterState, index);  
            * (DEFAULT_NUMBER_OF_REPLICAS + 1) + numIndicesToCreate * numShardsForNewIndices * (numReplicasForNewIndices + 1);  
                // asserting the result of 11th query, which should only contain 3 shardIDs belonging to test-index-7
        final int numIndicesToDelete = 10;
        return ClusterState.builder(clusterState)  
            requestedToken = strategy.getResponseToken().getNextToken();
                for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
        int pageSize = 10;
            assert e.getMessage().contains("requestedTokenString can not be null");
    }
     * should appear in the response.
            indexNumberList.add(indexNumber);
        strategy = new ShardPaginationStrategy(pageParams, clusterState);
        List<Integer> deletedIndices = new ArrayList<>();  
                assertEquals(1, paginationStrategy.getRequestedIndices().size());  
            () -> new ShardPaginationStrategy.ShardStrategyToken(PaginationStrategy.encryptStringToken("1|1725361543|index|12345"))
                deletedIndices = indexNumberList.subList(20, indexNumberList.size());
        return ClusterState.builder(clusterState)
    private ClusterState addIndexToClusterState(  
        } catch (Exception e) {
        final int indexNumber,
        return addIndexToClusterState(  
        ClusterState clusterState = getRandomClusterState(indexNumberList);
    }
        final int numShards = 3;
            assertTrue(
            // if it gets deleted, rest 2 shardIDs for it should not appear.  
            clusterState,
        assertEquals(totalIndices + numIndicesToCreate - numIndicesToDelete, indicesFetched.size());  
            // creating 5 indices after 5th call  
        }  
            () -> new ShardPaginationStrategy.ShardStrategyToken(PaginationStrategy.encryptStringToken("1|1725361543"))  
                assertEquals(2, paginationStrategy.getRequestedEntities().get(8).id());
            .metadata(Metadata.builder(clusterState.metadata()).remove(TEST_INDEX_PREFIX + indexNumber))
        List<Integer> indexNumberList = new ArrayList<>();
        for (int indexNumber = 1; indexNumber <= 100; indexNumber++) {  
            .build();  
        List<ShardRouting> shardRoutings = new ArrayList<>();
        // finalTotalShards = InitialTotal - 2ShardIdsForIndex7 - ShardsFor10RandomlyDeletedIndices
    public void testRetrieveAllShardsWithVaryingPageSize() {
            } else {  
            .metadata(Metadata.builder().build())  
        for (Integer index : deletedIndices) {
    private static final int DEFAULT_NUMBER_OF_SHARDS = 5;
        );
            String requestedToken = null;
import org.opensearch.cluster.metadata.IndexMetadata;
import java.time.temporal.ChronoUnit;
     * Shards corresponding to indices deleted, should not be fetched while for the indices which were newly created,
        final int totalPages = (int) Math.ceil((totalIndices * numShards * (numReplicas + 1) * 1.0) / pageSize);
            PageParams pageParams = new PageParams(requestedToken, PARAM_ASC_SORT_VALUE, pageSize);
            // if it gets deleted, rest 2 shardIDs for it should not appear.
            indexNumber,
            shardRoutings.stream().filter(shard -> shard.getIndexName().equals(TEST_INDEX_PREFIX + 7)).count(),  
                } else {
                            assertTrue(lastPageIndexTime >= currentLastIndexTime);  
import org.opensearch.OpenSearchParseException;
                    }
                    assertTrue(
        // Checking pagination response for different pageSizes, which has a mix of even and odd numbers
        int numPages = 0;
        List<Integer> deletedIndices = new ArrayList<>();  
        clusterState = addIndexToClusterState(clusterState, numIndices, numShards + 1, numReplicas + 1);
                        if (sortOrder.equals(PARAM_ASC_SORT_VALUE)) {  
import java.util.HashSet;
import java.util.stream.Collectors;
        }  
        }
            clusterState,
        assertEquals(TEST_INDEX_PREFIX + 3, strategy.getRequestedIndices().get(0));
        }
        int numReplicas = 8;
                }  
     * Shards corresponding to indices deleted, should not be fetched while for the indices which were newly created,
    }  
            }
    private ClusterState addIndexToClusterState(  
                numShardsForNewIndices * (numReplicasForNewIndices + 1),  
        final int totalIndices = 100;
        // none of the randomly deleted index should appear in the list of fetched indices
        for (int indexNum = 1; indexNum <= totalIndices; indexNum++) {
        );
        } catch (Exception e) {  
     */
        final int numIndicesToCreate = 5;  
     * While executing queries, it tries to delete an index for which some of the shards have already been fetched along
    /**  
        for (ShardRouting shard : shardRoutings.subList(1, shardRoutings.size())) {  
    public void testCreatingIndexStrategyPageTokenWithNameOfLastRespondedIndexNull() {  
        }  
        ClusterState clusterState = getRandomClusterState(Collections.emptyList());  
import org.opensearch.cluster.routing.ShardRouting;  
        ClusterState clusterState,
                assertEquals(totalShards, shardRoutings.size());  
                }
                assertTrue(shard.getId() >= prevShard.getId());
     * than #(replicas + 1) for any of the index.  
        do {  
        String requestedToken = null;
        }
                // asserting last elements of current response list, which should be the last shard of test-index-95
            assertEquals(0, shardRoutings.stream().filter(shard -> shard.getIndexName().equals(indexName)).count());  
                for (Integer index : deletedIndices) {
            String indexName = TEST_INDEX_PREFIX + indexNumber;  
            OpenSearchParseException.class,  
        } catch (IllegalArgumentException e) {
            assertFalse(indicesFetched.contains(indexName));
     * @return random clusterState consisting of indices having their creation times set to the integer used to name them.
            PARAM_ASC_SORT_VALUE  
                strategy = new ShardPaginationStrategy(pageParams, clusterState);  
    public void testIndexStrategyPageTokenWithInvalidValuesInRequestedToken() {
    }
        }
        final int numIndicesToCreate = 5;
                            .index(prevShard.getIndexName())
                assertEquals(DEFAULT_NUMBER_OF_SHARDS - 1, shardRoutings.get(shardRoutings.size() - 1).getId());
                Collections.shuffle(deletedIndices, getRandom());  
            assertFalse(indicesFetched.contains(indexName));
                }
            numShards,  
     * Test validates fetching all the shards (in asc order) for 100 indices in a paginated fashion using {@link ShardPaginationStrategy}.
        );  
            numShards,
/*  
            // deleting test-index-7 & 10 more random indices after 11th call. By that time, shards for first 6
                // verifying the order of shards in the response.  
import static org.opensearch.action.pagination.PageParams.PARAM_ASC_SORT_VALUE;
        }
        // to ensure number of shards in last page is not always equal to pageSize.
        final int totalIndices = 100;
        final int numReplicasForNewIndices = 5;
        IndexRoutingTable.Builder indexRoutingTableBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex()).initializeAsNew(  
        assertEquals(1, strategy.getRequestedIndices().size());
        final int indexNumber,
                    PageParams pageParams = new PageParams(requestedToken, sortOrder, pageSize);
            .metadata(Metadata.builder(clusterState.metadata()).put(indexMetadata, true).build())
                        } else {
            3 * (DEFAULT_NUMBER_OF_REPLICAS + 1)
                assertEquals(TEST_INDEX_PREFIX + 94, paginationStrategy.getRequestedIndices().get(0));  
        assertEquals(8, strategy.getRequestedEntities().size());
import static org.opensearch.action.pagination.PageParams.PARAM_DESC_SORT_VALUE;
        List<Integer> pageSizeList = List.of(3, 7, 10, 13);  
    ) {  
            assertTrue(e.getMessage().contains("size value should be greater than the replica count of all indices"));
        List<String> sortOrderList = List.of(PARAM_ASC_SORT_VALUE, PARAM_DESC_SORT_VALUE);
            assert e.getMessage().contains("index name should be provided");
        final int numReplicas,
        assertThrows(  
                for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
        try {
                    if (pageNum < totalPagesToFetch) {  
    }
                        .get(pageShards.get(pageShards.size() - 1).getIndexName())  
                    assertTrue(
     * with some other indices which are yet to be fetched. It also creates new indices in between the queries.  
        for (String sortOrder : sortOrderList) {  
import org.opensearch.test.OpenSearchTestCase;
        pageParams = new PageParams(requestedToken, PARAM_ASC_SORT_VALUE, pageSize);  
        assertNotNull(strategy.getResponseToken().getNextToken());  
            assertTrue(paginationStrategy.getRequestedEntities().size() <= pageSize);
 *
            // indices would have been completely fetched. 11th call, would fetch first 3 shardsIDs for test-index-7 and  
            requestedToken = paginationStrategy.getResponseToken().getNextToken();  
    }  
            }  
                        }
            String indexName = TEST_INDEX_PREFIX + deletedIndex;  
        final int numShardsForNewIndices = 4;
        assertEquals(8, strategy.getRequestedEntities().size());  
        assertEquals(totalIndices - numIndicesToDelete, indicesFetched.size());  
            );
            indexNumberList.add(indexNumber);
     * Validates strategy fails with IllegalArgumentException when requests size in pageParam is smaller
                clusterState = deleteIndexFromClusterState(clusterState, fixedIndexNumToDelete);  
        PageParams pageParams = new PageParams(requestedToken, PARAM_ASC_SORT_VALUE, pageSize);
                    requestedToken = strategy.getResponseToken().getNextToken();
            );
        final int numShards,  
            indexMetadata
        assertTrue(indicesFetched.contains(TEST_INDEX_PREFIX + 7));
            PageParams pageParams = new PageParams(requestedToken, PARAM_ASC_SORT_VALUE, pageSize);  
    /**
        }
                Set<String> indices = new HashSet<>();  
        for (ShardRouting shardRouting : strategy.getRequestedEntities()) {  
            do {
        ClusterState clusterState = getRandomClusterState(indexNumberList);
    private static final int DEFAULT_NUMBER_OF_REPLICAS = 2;
    private void verifyOrderForAllShards(ClusterState clusterState, List<ShardRouting> shardRoutings, String sortOrder) {
        clusterState = deleteIndexFromClusterState(clusterState, 3);  
            clusterState = addIndexToClusterState(clusterState, indexNumber, DEFAULT_NUMBER_OF_SHARDS, DEFAULT_NUMBER_OF_REPLICAS);
            assertTrue(shardRouting.getId() == 2 && Objects.equals(shardRouting.getIndexName(), TEST_INDEX_PREFIX + 3));
            assertNotNull(paginationStrategy);
        final int fixedIndexNumToDelete = 7;
        int numPages = 0;  
            ShardPaginationStrategy strategy;  
        final int numReplicas
        final int totalShards = totalInitialShards - 2 * (DEFAULT_NUMBER_OF_REPLICAS + 1) - numIndicesToDelete * DEFAULT_NUMBER_OF_SHARDS
                }  
            assert e.getMessage().contains(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);
    }
            numReplicas,
 * SPDX-License-Identifier: Apache-2.0
    ) {
            // indices would have been completely fetched. 11th call, would fetch first 3 shardsIDs for test-index-94 and
     * @param indexNumbers would be used to create indices having names with integer appended after foo, like foo1, foo2.
                    newIndices.add(TEST_INDEX_PREFIX + indexNumber);  
                assertEquals(1, paginationStrategy.getRequestedIndices().size());
import java.util.Collections;  
            clusterState,
            indicesFetched.addAll(paginationStrategy.getRequestedIndices());  
        );  
        // since test-index-3 should now be considered a new index, all shards for it should appear  
        final int totalIndices = 100;
        clusterState = addIndexToClusterState(
        ShardPaginationStrategy strategy = null;  
            Instant.now().plus(4, ChronoUnit.SECONDS).toEpochMilli()  
                assertEquals(3 * (DEFAULT_NUMBER_OF_REPLICAS + 1), paginationStrategy.getRequestedEntities().size());
                    clusterState = addIndexToClusterState(clusterState, indexNumber, numShardsForNewIndices, numReplicasForNewIndices);
            ShardPaginationStrategy paginationStrategy = new ShardPaginationStrategy(pageParams, clusterState);
        for (int deletedIndex : deletedIndices) {
        }  
        );
     * Test validates fetching all the shards (in desc order) for 100 indices in a paginated fashion using {@link ShardPaginationStrategy}.
     * while no indices are created or deleted during the fetch.  
                // Since each shardID will have number of (replicas + 1) shards, thus number
            for (int pageSize : pageSizeList) {
        try {  
                    lastPageIndexTime = currentLastIndexTime;  
import org.opensearch.cluster.routing.IndexRoutingTable;
public class ShardPaginationStrategyTests extends OpenSearchTestCase {
            .build();
        final int fixedIndexNumToDelete = 94;
            assertEquals(
                clusterState = deleteIndexFromClusterState(clusterState, fixedIndexNumToDelete);
            }
        assertThrows(OpenSearchParseException.class, () -> new ShardPaginationStrategy.ShardStrategyToken("3%4%5"));  
        // The last page was supposed to fetch the remaining two indices for test-index-3  
            .routingTable(RoutingTable.builder().build())
        Collections.shuffle(indexNumberList, getRandom());
            OpenSearchParseException.class,
            numPages++;  
            String indexName = TEST_INDEX_PREFIX + index;  
                for (Integer index : deletedIndices) {
import org.opensearch.cluster.routing.RoutingTable;
                deletedIndices = deletedIndices.subList(0, numIndicesToDelete);  
                assertEquals(2, paginationStrategy.getRequestedEntities().get(8).id());
                        .getCreationDate();
        final int numIndicesToDelete = 10;  
        // Delete the index and re-create
        strategy = new ShardPaginationStrategy(pageParams, clusterState);
        final int numReplicasForNewIndices = 5;  
     * Test validates fetching all the shards for 100 indices in a paginated fashion using {@link ShardPaginationStrategy},
        assertEquals(totalShards, shardRoutings.size());
            }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
import org.opensearch.Version;
            .routingTable(RoutingTable.builder(clusterState.routingTable()).remove(TEST_INDEX_PREFIX + indexNumber).build())  
                    List<ShardRouting> pageShards = strategy.getRequestedEntities();
            ShardPaginationStrategy paginationStrategy = new ShardPaginationStrategy(pageParams, clusterState);
        }  
    public void testRetrieveShardsWhenLastIndexGetsDeletedAndReCreated() {  
        }
                    }
                (shardRouting.getId() == 0 || shardRouting.getId() == 1)  
                // asserting last elements of current response list, which should be the last shard of test-index-6  
    }
        assertNull(strategy.getResponseToken().getNextToken());
            new ShardPaginationStrategy.ShardStrategyToken(PaginationStrategy.encryptStringToken("shardID|1725361543|index"));
import org.opensearch.cluster.ClusterState;
                        assertNotNull(strategy.getResponseToken().getNextToken());
            requestedToken = paginationStrategy.getResponseToken().getNextToken();
        assertEquals(1, strategy.getRequestedIndices().size());  
        }
        try {
        int pageSize = numReplicas + 1;  
        assertEquals(TEST_INDEX_PREFIX + 3, strategy.getRequestedIndices().get(0));  
        assertEquals(
        ClusterState clusterState,
            }  
        assertEquals(4, strategy.getRequestedEntities().size());
        assertEquals(1, strategy.getRequestedIndices().size());
    }
                deletedIndices = indexNumberList.subList(0, 80);
                        clusterState.metadata().index(shard.getIndexName()).getCreationDate() > clusterState.metadata()  
                assertEquals(totalIndices, indices.size());
                assertEquals(TEST_INDEX_PREFIX + 7, paginationStrategy.getRequestedIndices().get(0));
            if (Objects.equals(shard.getIndexName(), prevShard.getIndexName())) {
import java.util.Set;
        );
        final int totalIndices = 3;
            fail("expected exception");
                long lastPageIndexTime = 0;  
                prevShard = shard;
                    clusterState = addIndexToClusterState(clusterState, indexNumber, numShardsForNewIndices, numReplicasForNewIndices);
        ClusterState clusterState = getRandomClusterState(Collections.emptyList());
        for (int indexNumber = 1; indexNumber <= 100; indexNumber++) {
        } while (Objects.nonNull(requestedToken));
                PageParams pageParams = new PageParams(requestedToken, PARAM_ASC_SORT_VALUE, pageSize);
        requestedToken = strategy.getResponseToken().getNextToken();
        IndexMetadata indexMetadata = IndexMetadata.builder(TEST_INDEX_PREFIX + indexNumber)
        assertThrows(
        String requestedToken = null;  
        int numShards = 5;
    }
            fail("expected exception");  
            new ShardPaginationStrategy.ShardStrategyToken(null, 0, 1234l);
import java.util.Objects;  
        }  
        for (int indexNumber = 1; indexNumber <= 100; indexNumber++) {  
            numPages++;
                            assertTrue(lastPageIndexTime <= currentLastIndexTime);
                    );  
     */  
            shardRoutings.stream().filter(shard -> shard.getIndexName().equals(TEST_INDEX_PREFIX + fixedIndexNumToDelete)).count(),  
        for (ShardRouting shardRouting : strategy.getRequestedEntities()) {
import static com.carrotsearch.randomizedtesting.RandomizedTest.getRandom;
 * The OpenSearch Contributors require contributions made to  
        );
                requestedToken = strategy.getResponseToken().getNextToken();
                // of shards in a page should always be a multiple of (replicas + 1).  
        Set<String> indicesFetched = new HashSet<>();
import org.opensearch.cluster.metadata.Metadata;  
        for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
            .settings(settings(Version.CURRENT).put(SETTING_CREATION_DATE, creationTime))
        } catch (Exception e) {
        try {
            .build();
            assertFalse(indicesFetched.contains(indexName));
        } while (Objects.nonNull(requestedToken));
    public void testIndexStrategyPageTokenWithIncorrectNumberOfElementsInRequestedToken() {  
        do {
    }
        }
    }
                    } else {
        }  
                }
        // creating a cluster state with 100 indices  
        ClusterState clusterState = ClusterState.builder(new ClusterName("test"))
                    && Objects.equals(shardRouting.getIndexName(), TEST_INDEX_PREFIX + 3)
        final int pageSize = (numReplicas + 1) * 2;
        for (Integer indexNumber : indexNumbers) {  
        for (int index = 1; index < numIndices; index++) {
            assertNotNull(paginationStrategy.getResponseToken());  
        final int numReplicas = 3;  
                    );  
                            .getCreationDate()
                    long currentLastIndexTime = clusterState.metadata()
        );
                assertEquals(3 * (DEFAULT_NUMBER_OF_REPLICAS + 1), paginationStrategy.getRequestedEntities().size());
    private ClusterState deleteIndexFromClusterState(ClusterState clusterState, int indexNumber) {  
            fail("expected exception");  
            Instant.now().plus(indexNumber, ChronoUnit.SECONDS).toEpochMilli()
     * with some other indices which are yet to be fetched. It also creates new indices in between the queries.  
    }  
            assertTrue(paginationStrategy.getRequestedEntities().size() <= pageSize);
                Collections.shuffle(deletedIndices, getRandom());
                shardRoutings.stream().filter(shard -> shard.getIndexName().equals(indexName)).count()
        final int totalShards = totalInitialShards - 2 * (DEFAULT_NUMBER_OF_REPLICAS + 1) - numIndicesToDelete * DEFAULT_NUMBER_OF_SHARDS
            // deleting test-index-94 & 10 more random indices after 11th call. By that time, shards for last 6
}
            shardRoutings.stream().filter(shard -> newIndices.contains(shard.getIndexName())).collect(Collectors.toList()),
    }
import static org.opensearch.action.pagination.PaginationStrategy.INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE;  
                }
        List<ShardRouting> shardRoutings = new ArrayList<>();
        verifyOrderForAllShards(  
            indicesFetched.addAll(paginationStrategy.getRequestedIndices());
                    if (lastPageIndexTime > 0) {
            3,  
                // asserting the result of 11th query, which should only contain 3 shardIDs belonging to test-index-7  
    /**
     */  
                        clusterState.metadata().index(shard.getIndexName()).getCreationDate() < clusterState.metadata()  
            OpenSearchParseException.class,
                        assertNull(strategy.getResponseToken().getNextToken());  
        ShardRouting prevShard = shardRoutings.get(0);
    /**  
    public void testCreatingShardStrategyPageTokenWithRequestedTokenNull() {
            new ShardPaginationStrategy.ShardStrategyToken(null);
    public void testIndexStrategyPageTokenWithWronglyEncryptedRequestToken() {
    public void testIllegalSizeArgumentRequestedFromStrategy() {
                int totalPagesToFetch = (int) Math.ceil(totalShards * 1.0 / (pageSize - pageSize % (DEFAULT_NUMBER_OF_REPLICAS + 1)));
                    shardRoutings.addAll(pageShards);
    private ClusterState getRandomClusterState(List<Integer> indexNumbers) {
     */  
     * should appear in the response.
                            .index(prevShard.getIndexName())
            assertEquals(shardRoutings.stream().filter(shard -> shard.getIndexName().equals(indexName)).count(), 0);
                List<ShardRouting> shardRoutings = new ArrayList<>();
                for (int pageNum = 1; pageNum <= totalPagesToFetch; pageNum++) {
        // none of the randomly deleted index should appear in the list of fetched indices
            clusterState = addIndexToClusterState(clusterState, index, numShards, numReplicas);  
            // creating 5 indices after 5th call
        List<Integer> indexNumberList = new ArrayList<>();
            assertNotNull(paginationStrategy.getResponseToken());
                verifyOrderForAllShards(clusterState, shardRoutings, sortOrder);
        // deleted test-index-7, should appear in the response shards and indices  
                    clusterState = deleteIndexFromClusterState(clusterState, index);
    }
        );
                String requestedToken = null;
 */  
                assertEquals(TEST_INDEX_PREFIX + 6, shardRoutings.get(shardRoutings.size() - 1).getIndexName());
        assertEquals(totalShards, shardRoutings.size());
            String indexName = TEST_INDEX_PREFIX + indexNumber;
     */
                    List<String> pageIndices = strategy.getRequestedIndices();
     * While executing queries, it tries to delete an index for which some of the shards have already been fetched along
        final long creationTime
                    ShardPaginationStrategy strategy = new ShardPaginationStrategy(pageParams, clusterState);  
        ClusterState clusterState = getRandomClusterState(indexNumberList);  
        String requestedToken = null;
            shardRoutings.addAll(paginationStrategy.getRequestedEntities());
                            .getCreationDate()
        for (int page = 1; page < totalPages; page++) {
            if (numPages == 11) {
package org.opensearch.action.pagination;
            .build();
            indexNumberList.add(indexNumber);  
            clusterState = addIndexToClusterState(clusterState, indexNum, numShards, numReplicas);
        }  
        // finalTotalShards = InitialTotal - 2ShardIdsForIndex7 - ShardsFor10RandomlyDeletedIndices + ShardsForNewlyCreatedIndices
            assertNotNull(paginationStrategy);
    public void testRetrieveAllShardsInDescOrderWhileIndicesGetCreatedAndDeleted() {
            }
            if (numPages == 5) {
            3 * (DEFAULT_NUMBER_OF_REPLICAS + 1)
    /**  
    public void testCreatingIndexStrategyPageTokenWithNonParseableShardID() {  
        final int numShardsForNewIndices = 4;  
            } while (requestedToken != null);
        final int numShards,  
            strategy = new ShardPaginationStrategy(pageParams, clusterState);  
