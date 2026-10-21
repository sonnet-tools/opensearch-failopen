            fail("expected exception");
                    IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        // executing next query without any changes to clusterState
        return ClusterState.builder(clusterState)
            PageParams pageParams = new PageParams(requestedToken, PARAM_DESC_SORT_VALUE, pageSize);
 * SPDX-License-Identifier: Apache-2.0
        for (Integer indexNumber : indexNumbers) {
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_DESC_SORT_VALUE, 1);
            new IndexPaginationStrategy.IndexStrategyToken(null);
        String requestedToken = null;
        }
        for (int indexNumber = 1; indexNumber <= 100; indexNumber++) {
    public void testRetrieveAllIndicesWithVaryingPageSize() {
    }
        final int totalIndices = 100;
import org.opensearch.Version;
        final int numIndicesToDelete = 9;
        List<String> sortOrderList = List.of(PARAM_ASC_SORT_VALUE, PARAM_DESC_SORT_VALUE);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
        final int totalIndices = 100;
                }
import static com.carrotsearch.randomizedtesting.RandomizedTest.getRandom;
        );
            }
        IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        List<Integer> deletedIndices = new ArrayList<>();
            () -> new IndexPaginationStrategy.IndexStrategyToken(PaginationStrategy.encryptStringToken("1725361543"))
        IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        assertNotNull(paginationStrategy);
        assertEquals(10, paginationStrategy.getRequestedEntities().size());
        int pageSize = 6;
            .metadata(Metadata.builder().build())
        ClusterState clusterState = getRandomClusterState(List.of(1, 2, 3, 4));
import org.opensearch.cluster.routing.RoutingTable;
        List<String> indicesFetched = new ArrayList<>();
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        int pageSize = 6;
        assertNull(paginationStrategy.getResponseToken().getNextToken());
        IndexRoutingTable.Builder indexRoutingTableBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex());
        assertEquals(1, paginationStrategy.getRequestedEntities().size());
        List<Integer> indexNumberList = new ArrayList<>();
        assertEquals("test-index-2", paginationStrategy.getRequestedEntities().get(0));
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        assertThrows(
        assertEquals(1, paginationStrategy.getRequestedEntities().size());
                for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
        int numPages = 0;
        clusterState = deleteIndexFromClusterState(clusterState, 4);
            .routingTable(RoutingTable.builder().build())
            }
                        assertNotNull(paginationStrategy.getResponseToken().getNextToken());
import org.opensearch.cluster.ClusterState;
            if (requestedToken == null) {
import java.time.temporal.ChronoUnit;
        assertThrows(
            OpenSearchParseException.class,
                            responseItr++;
        // Deleting test-index-1, test-index-2 & test-index-3 and executing next query. test-index-4 should get displayed.
package org.opensearch.action.pagination;
        );
        assertNull(paginationStrategy.getResponseToken().getNextToken());
        try {
                    if (PARAM_ASC_SORT_VALUE.equals(sortOrder)) {
        return clusterState;
            }
                            pageNumber * pageSize
                        assertNull(paginationStrategy.getResponseToken().getNextToken());
        assertPaginationResult(paginationStrategy, 1, true);
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_ASC_SORT_VALUE, 1);
        // Deleting test-index-4 which is not yet displayed which otherwise should have been displayed in the following query
        assertEquals("test-index-1", paginationStrategy.getRequestedEntities().get(0));
        final int numIndicesToCreate = 5;
        clusterState = deleteIndexFromClusterState(clusterState, 2);
        // creating a token with last sent index as test-index-10
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        return ClusterState.builder(clusterState)
                for (int pos = 0; pos < numIndicesToDelete; pos++) {
        int numPages = 0;
                for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
        for (int deletedIndexPos = 0; deletedIndexPos < numIndicesToDelete; deletedIndexPos++) {
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        assertThrows(OpenSearchParseException.class, () -> new IndexPaginationStrategy.IndexStrategyToken("3%4%5"));
            .build();
        String token = clusterState.metadata().indices().get("test-index-10").getCreationDate() + "|" + "test-index-10";
        do {
        assertEquals("test-index-5", paginationStrategy.getRequestedEntities().get(0));
        List<String> indicesFetched = new ArrayList<>();
            OpenSearchParseException.class,
        }
    public void testCreatingIndexStrategyPageTokenWithRequestedTokenNull() {
            .build();
    }
    private ClusterState getRandomClusterState(List<Integer> indexNumbers) {
                    }
            new IndexPaginationStrategy.IndexStrategyToken(1234l, null);
        List<Integer> indexNumberList = new ArrayList<>();
    }
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_ASC_SORT_VALUE, 1);
                assertEquals(paginationStrategy.getRequestedEntities().size(), (totalIndices - numIndicesToDelete) % pageSize);
    }
                    // Asserting all the indices received
    }
            .settings(
public class IndexPaginationStrategyTests extends OpenSearchTestCase {
            if (numPages == 3) {
                deletedIndices = indexNumberList.subList(20, indexNumberList.size());
            // randomly deleting 10 indices after 3rd call
                int indicesRemaining = totalIndices;
        assertEquals(expectedEntities, paginationStrategy.getRequestedEntities().size());
            assert e.getMessage().contains("requestedTokenString can not be null");
     */
        assertEquals("test-index-3", paginationStrategy.getRequestedEntities().get(0));
        } catch (Exception e) {
            // randomly deleting 10 indices after 3rd call
        // instead test-index-5 should now get displayed.
            indexNumberList.add(indexNumber);
                }
import org.opensearch.cluster.metadata.IndexMetadata;
                        ); indexNumber++) {
                assertEquals(paginationStrategy.getRequestedEntities().size(), pageSize);
                }
     * @param indexNumbers would be used to create indices having names with integer appended after foo, like foo1, foo2.
        try {
                    clusterState = addIndexToClusterState(clusterState, indexNumber);
                            responseItr++;
 * compatible open source license.
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
            OpenSearchParseException.class,
 */
        clusterState = deleteIndexFromClusterState(clusterState, 1);
            assertNotNull(paginationStrategy);
        assertNotNull(paginationStrategy.getResponseToken());
        // Deleting test-index-3 which has already been displayed, still index2 should get displayed.
                    assertEquals(responseItr, paginationStrategy.getRequestedEntities().size());
            // creating 5 indices after 5th call
    public void testIndexStrategyPageTokenWithIncorrectNumberOfElementsInRequestedToken() {
                }
/*
        } while (Objects.nonNull(requestedToken));
            assertNotNull(paginationStrategy);
        List<Integer> pageSizeList = List.of(1, 6, 10, 13);
    }
    /**
            () -> new IndexPaginationStrategy.IndexStrategyToken(PaginationStrategy.encryptStringToken("1|1725361543|index|12345"))
            assertNotNull(paginationStrategy.getResponseToken());
                    clusterState = addIndexToClusterState(clusterState, indexNumber);
                String requestedToken = null;
        for (int indexNumber = 1; indexNumber <= 100; indexNumber++) {
            if (numPages == 5) {
    private ClusterState deleteIndexFromClusterState(ClusterState clusterState, int indexNumber) {
                settings(Version.CURRENT).put(SETTING_CREATION_DATE, Instant.now().plus(indexNumber, ChronoUnit.SECONDS).toEpochMilli())
            assertFalse(indicesFetched.contains("test-index-" + indexNumber));
                    if (pageNumber < totalPagesToFetch) {
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_DESC_SORT_VALUE, 1);
import java.util.Base64;
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index-" + indexNumber)
            indicesFetched.addAll(paginationStrategy.getRequestedEntities());
        assertPaginationResult(paginationStrategy, 1, true);
        assertEquals(totalIndices - numIndicesToDelete, indicesFetched.size());
            () -> new IndexPaginationStrategy.IndexStrategyToken(PaginationStrategy.encryptStringToken("-1725361543|index"))
    public void testRetrieveIndicesWithSizeOneAndCurrentIndexGetsDeletedAscOrder() {
        clusterState = addIndexToClusterState(clusterState, 5);
        PageParams pageParams = new PageParams(null, PARAM_DESC_SORT_VALUE, 1);
import java.util.Collections;
            } else {
        clusterState = addIndexToClusterState(clusterState, 5);
        assertEquals(totalIndices + numIndicesToCreate - numIndicesToDelete, indicesFetched.size());
        clusterState = deleteIndexFromClusterState(clusterState, 2);
    public void testRetrieveAllIndicesInAscOrderWhileIndicesGetCreatedAndDeleted() {
                    clusterState = deleteIndexFromClusterState(clusterState, deletedIndices.get(pos));
    public void testCreatingIndexStrategyPageTokenWithNameOfLastRespondedIndexNull() {
        // none of the deleted index should appear in the list of fetched indices
            assertNotNull(paginationStrategy.getResponseToken());
            assertFalse(indicesFetched.contains("test-index-" + deletedIndices.get(deletedIndexPos)));
    private void assertPaginationResult(IndexPaginationStrategy paginationStrategy, int expectedEntities, boolean tokenExpected) {
        do {
        assertEquals("test-index-3", paginationStrategy.getRequestedEntities().get(0));
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
            .routingTable(RoutingTable.builder(clusterState.routingTable()).remove("test-index-" + indexNumber).build())
                        }
import static org.opensearch.action.pagination.PageParams.PARAM_DESC_SORT_VALUE;
            .metadata(Metadata.builder(clusterState.metadata()).remove("test-index-" + indexNumber))
                Collections.shuffle(deletedIndices, getRandom());
        }
        final int numIndicesToCreate = 5;
        ClusterState clusterState = getRandomClusterState(indexNumberList);
        }
        }
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        // to ensure number of indices in last page is not always equal to pageSize.
            IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
    private ClusterState addIndexToClusterState(ClusterState clusterState, int indexNumber) {
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_ASC_SORT_VALUE, 1);
                for (int pageNumber = 1; pageNumber <= totalPagesToFetch; pageNumber++) {
            } else {
 *
        assertEquals("test-index-1", paginationStrategy.getRequestedEntities().get(0));
    }
        // creating a cluster state with 100 indices
                            assertEquals("test-index-" + indicesRemaining, paginationStrategy.getRequestedEntities().get(responseItr));
                        int endIndexNumberForPage = Math.max(indicesRemaining - pageSize, 0);
        // Executing the last query without any further change. Should result in test-index-5 and nextToken as null.
    }
        // Query1 with 4 indices in clusterState (test-index1,2,3,4)
            .numberOfShards(between(1, 10))
        for (int indexNumber = 1; indexNumber <= 100; indexNumber++) {
            // creating 5 indices after 5th call
        // adding test-index-5 to clusterState, before executing next query.
            .build();
            indexNumberList.add(indexNumber);
                    }
            if (requestedToken == null) {
                for (int pos = 0; pos < numIndicesToDelete; pos++) {
        } catch (Exception e) {
    }
        } while (Objects.nonNull(requestedToken));
            for (int pageSize : pageSizeList) {
        clusterState = deleteIndexFromClusterState(clusterState, 3);
            .routingTable(RoutingTable.builder(clusterState.routingTable()).add(indexRoutingTableBuilder).build())
        }
        // Checking pagination response for different pageSizes, which has a mix of even and odd numbers
        ClusterState clusterState = getRandomClusterState(List.of(1, 2, 3, 4, 5));
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_ASC_SORT_VALUE, 1);
            assertFalse(indicesFetched.contains("test-index-" + deletedIndices.get(deletedIndexPos)));
import static org.opensearch.action.pagination.PageParams.PARAM_ASC_SORT_VALUE;
        // Deleting test-index-2 which has already been displayed, still test-index-3 should get displayed
        // Adding index5 to clusterState, before executing next query.
        pageParams = new PageParams(Base64.getEncoder().encodeToString(token.getBytes(UTF_8)), PARAM_ASC_SORT_VALUE, 10);
                int totalPagesToFetch = (int) Math.ceil(totalIndices / (pageSize * 1.0));
        assertPaginationResult(paginationStrategy, 1, true);
        for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
                        for (; indicesRemaining > endIndexNumberForPage; indicesRemaining--) {
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
                    } else {
        // none of the deleted index should appear in the list of fetched indices
                    } else {
    public void testRetrieveIndicesWithTokenModifiedToQueryBeyondTotal() {
    public void testRetrieveIndicesWithSizeOneAndCurrentIndexGetsDeletedDescOrder() {
            numPages++;
 * The OpenSearch Contributors require contributions made to
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
            indexNumberList.add(indexNumber);
        ClusterState clusterState = getRandomClusterState(indexNumberList);
        }
            IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
                    clusterState = deleteIndexFromClusterState(clusterState, deletedIndices.get(pos));
                    requestedToken = paginationStrategy.getResponseToken().getNextToken();
            )
        Collections.shuffle(indexNumberList, getRandom());
        ClusterState clusterState = ClusterState.builder(new ClusterName("test"))
    }
import java.util.ArrayList;
                }
    public void testIndexStrategyPageTokenWithWronglyEncryptedRequestToken() {
        // Query1 with 4 indices in clusterState (test-index1,2,3,4).
            }
        // none of the newly created indices should be present in the list of fetched indices
        ClusterState clusterState = getRandomClusterState(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertEquals("test-index-4", paginationStrategy.getRequestedEntities().get(0));
        String requestedToken = null;
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_ASC_SORT_VALUE, 1);
        assertPaginationResult(paginationStrategy, 1, false);
import java.util.Objects;
        assertEquals((int) Math.ceil((double) (totalIndices + numIndicesToCreate - numIndicesToDelete) / pageSize), numPages);
        // Query1 with 5 indices in clusterState (test-index1,2,3,4,5).
    }
        assertEquals(1, paginationStrategy.getRequestedEntities().size());
            fail("expected exception");
        for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
                            assertEquals("test-index-" + (indexNumber + 1), paginationStrategy.getRequestedEntities().get(responseItr));
        ClusterState clusterState = getRandomClusterState(List.of(1, 2, 3, 4));
            indicesFetched.addAll(paginationStrategy.getRequestedEntities());
        assertPaginationResult(paginationStrategy, 1, true);
            clusterState = addIndexToClusterState(clusterState, indexNumber);
        PageParams pageParams = new PageParams(null, PARAM_ASC_SORT_VALUE, 1);
                    int responseItr = 0;
        assertEquals("test-index-4", paginationStrategy.getRequestedEntities().get(0));
import org.opensearch.OpenSearchParseException;
            numPages++;
                        }
import org.opensearch.cluster.metadata.Metadata;
        assertEquals(tokenExpected, Objects.nonNull(paginationStrategy.getResponseToken().getNextToken()));
        assertEquals(1, paginationStrategy.getRequestedEntities().size());
    }
        for (String sortOrder : sortOrderList) {
}
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_ASC_SORT_VALUE, 1);
        // Deleting test-index-1 which is not yet displayed which otherwise should have been displayed in the following query.
        IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_DESC_SORT_VALUE, 1);
        clusterState = deleteIndexFromClusterState(clusterState, 1);
    }
        assertEquals("test-index-2", paginationStrategy.getRequestedEntities().get(0));
            }
            assertTrue(indicesFetched.contains("test-index-" + indexNumber));
            if (numPages == 3) {
            requestedToken = paginationStrategy.getResponseToken().getNextToken();
        assertNotNull(paginationStrategy.getResponseToken().getNextToken());
        assertEquals(0, paginationStrategy.getRequestedEntities().size());
        }
                        for (int indexNumber = (pageNumber - 1) * pageSize; indexNumber < Math.min(
                assertEquals(paginationStrategy.getRequestedEntities().size(), 5);
        }
        clusterState = deleteIndexFromClusterState(clusterState, 3);
        PageParams pageParams = new PageParams(null, PARAM_ASC_SORT_VALUE, 1);
            }
        IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
                Collections.shuffle(deletedIndices, getRandom());
import org.opensearch.test.OpenSearchTestCase;
    public void testRetrieveIndicesWithMultipleDeletionsAtOnceAscOrder() {
            requestedToken = paginationStrategy.getResponseToken().getNextToken();
                            100,
            PageParams pageParams = new PageParams(requestedToken, PARAM_ASC_SORT_VALUE, pageSize);
        }
            .numberOfReplicas(randomInt(20))
import org.opensearch.cluster.ClusterName;
        assertEquals("test-index-5", paginationStrategy.getRequestedEntities().get(0));
        assertNotNull(paginationStrategy.getResponseToken().getNextToken());
        assertPaginationResult(paginationStrategy, 1, true);
        assertPaginationResult(paginationStrategy, 0, false);
        assertPaginationResult(paginationStrategy, 1, true);
            }
        PageParams pageParams = new PageParams(null, PARAM_ASC_SORT_VALUE, 10);
        assertThrows(
        );
            .build();
        assertEquals("test-index-2", paginationStrategy.getRequestedEntities().get(0));
    public void testRetrieveAllIndicesInDescOrderWhileIndicesGetCreatedAndDeleted() {
            if (numPages == 5) {
    }
import java.time.Instant;
    }
import java.util.List;
        assertNotNull(paginationStrategy.getResponseToken().getNextToken());
            .metadata(Metadata.builder(clusterState.metadata()).put(indexMetadata, true).build())
import static java.nio.charset.StandardCharsets.UTF_8;
        List<Integer> deletedIndices = new ArrayList<>();
        for (int deletedIndexPos = 0; deletedIndexPos < numIndicesToDelete; deletedIndexPos++) {
import org.opensearch.cluster.routing.IndexRoutingTable;
                deletedIndices = indexNumberList.subList(0, 80);
        assertNull(paginationStrategy.getResponseToken().getNextToken());
        assertEquals((int) Math.ceil((double) (totalIndices - numIndicesToDelete) / pageSize), numPages);
     * @return random clusterState consisting of indices having their creation times set to the integer used to name them.
            assert e.getMessage().contains("index name should be provided");
        }
        final int totalIndices = 100;
    public void testIndexStrategyPageTokenWithInvalidValuesInRequestedToken() {
        // all the newly created indices should be present in the list of fetched indices
                    PageParams pageParams = new PageParams(requestedToken, sortOrder, pageSize);
                assertEquals(paginationStrategy.getRequestedEntities().size(), pageSize);
        ClusterState clusterState = getRandomClusterState(indexNumberList);
    }
 * this file be licensed under the Apache-2.0 license or a
        List<Integer> indexNumberList = new ArrayList<>();
        final int numIndicesToDelete = 10;
