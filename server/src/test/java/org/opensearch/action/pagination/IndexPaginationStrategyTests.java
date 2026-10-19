            )
import static com.carrotsearch.randomizedtesting.RandomizedTest.getRandom;
                            assertEquals("test-index-" + (indexNumber + 1), paginationStrategy.getRequestedEntities().get(responseItr));
        }  
        ClusterState clusterState = getRandomClusterState(indexNumberList);
        ClusterState clusterState = getRandomClusterState(List.of(1, 2, 3, 4));
                    clusterState = addIndexToClusterState(clusterState, indexNumber);  
        assertEquals((int) Math.ceil((double) (totalIndices + numIndicesToCreate - numIndicesToDelete) / pageSize), numPages);  
        assertEquals("test-index-4", paginationStrategy.getRequestedEntities().get(0));
    public void testRetrieveIndicesWithMultipleDeletionsAtOnceAscOrder() {
            .numberOfReplicas(randomInt(20))  
    private ClusterState addIndexToClusterState(ClusterState clusterState, int indexNumber) {  
            fail("expected exception");
        }
import static org.opensearch.action.pagination.PageParams.PARAM_ASC_SORT_VALUE;
                    }
        return clusterState;  
                    if (pageNumber < totalPagesToFetch) {
        String requestedToken = null;  
    }
    }
        // none of the deleted index should appear in the list of fetched indices
    public void testRetrieveAllIndicesWithVaryingPageSize() {  
                }  
                String requestedToken = null;
 * The OpenSearch Contributors require contributions made to  
                int indicesRemaining = totalIndices;  
    private ClusterState getRandomClusterState(List<Integer> indexNumbers) {
                }
        List<Integer> indexNumberList = new ArrayList<>();
                        assertNotNull(paginationStrategy.getResponseToken().getNextToken());
        final int numIndicesToCreate = 5;
                Collections.shuffle(deletedIndices, getRandom());  
            indexNumberList.add(indexNumber);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
            PageParams pageParams = new PageParams(requestedToken, PARAM_DESC_SORT_VALUE, pageSize);
import java.time.Instant;
        List<String> indicesFetched = new ArrayList<>();  
    }
                    }
        // Deleting test-index-1, test-index-2 & test-index-3 and executing next query. test-index-4 should get displayed.  
        assertPaginationResult(paginationStrategy, 1, true);  
    }  
        int numPages = 0;
        IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);  
            fail("expected exception");  
        assertNotNull(paginationStrategy.getResponseToken());
import java.time.temporal.ChronoUnit;  
public class IndexPaginationStrategyTests extends OpenSearchTestCase {
        assertEquals(1, paginationStrategy.getRequestedEntities().size());
        ClusterState clusterState = getRandomClusterState(indexNumberList);
        // Query1 with 4 indices in clusterState (test-index1,2,3,4).
    public void testRetrieveAllIndicesInDescOrderWhileIndicesGetCreatedAndDeleted() {
            assertFalse(indicesFetched.contains("test-index-" + deletedIndices.get(deletedIndexPos)));
            requestedToken = paginationStrategy.getResponseToken().getNextToken();
            } else {
        assertThrows(  
    public void testRetrieveAllIndicesInAscOrderWhileIndicesGetCreatedAndDeleted() {  
        assertNotNull(paginationStrategy.getResponseToken().getNextToken());
        clusterState = deleteIndexFromClusterState(clusterState, 2);
                int totalPagesToFetch = (int) Math.ceil(totalIndices / (pageSize * 1.0));
            () -> new IndexPaginationStrategy.IndexStrategyToken(PaginationStrategy.encryptStringToken("-1725361543|index"))
                assertEquals(paginationStrategy.getRequestedEntities().size(), pageSize);  
                    } else {
        PageParams pageParams = new PageParams(null, PARAM_ASC_SORT_VALUE, 10);
        return ClusterState.builder(clusterState)
        assertEquals("test-index-2", paginationStrategy.getRequestedEntities().get(0));
    }
        assertEquals(1, paginationStrategy.getRequestedEntities().size());
        assertEquals(1, paginationStrategy.getRequestedEntities().size());  
import java.util.List;
            assert e.getMessage().contains("index name should be provided");
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_ASC_SORT_VALUE, 1);
        } while (Objects.nonNull(requestedToken));
        List<Integer> pageSizeList = List.of(1, 6, 10, 13);  
        assertEquals("test-index-2", paginationStrategy.getRequestedEntities().get(0));  
                    // Asserting all the indices received
    private void assertPaginationResult(IndexPaginationStrategy paginationStrategy, int expectedEntities, boolean tokenExpected) {
        // Executing the last query without any further change. Should result in test-index-5 and nextToken as null.
        clusterState = deleteIndexFromClusterState(clusterState, 2);
import org.opensearch.cluster.ClusterState;
        List<Integer> indexNumberList = new ArrayList<>();  
        ClusterState clusterState = ClusterState.builder(new ClusterName("test"))
        // Deleting test-index-1 which is not yet displayed which otherwise should have been displayed in the following query.
                }
        assertPaginationResult(paginationStrategy, 1, true);
        assertEquals(totalIndices - numIndicesToDelete, indicesFetched.size());  
            new IndexPaginationStrategy.IndexStrategyToken(1234l, null);
                    clusterState = addIndexToClusterState(clusterState, indexNumber);
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        // Query1 with 5 indices in clusterState (test-index1,2,3,4,5).  
        final int totalIndices = 100;
            }
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_ASC_SORT_VALUE, 1);
import org.opensearch.cluster.ClusterName;  
                Collections.shuffle(deletedIndices, getRandom());
        }
        final int numIndicesToCreate = 5;
                            responseItr++;  
        ClusterState clusterState = getRandomClusterState(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
                deletedIndices = indexNumberList.subList(0, 80);
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_ASC_SORT_VALUE, 1);  
            PageParams pageParams = new PageParams(requestedToken, PARAM_ASC_SORT_VALUE, pageSize);
        int pageSize = 6;
                        assertNull(paginationStrategy.getResponseToken().getNextToken());
        // none of the deleted index should appear in the list of fetched indices  
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index-" + indexNumber)
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_ASC_SORT_VALUE, 1);  
                            pageNumber * pageSize  
import org.opensearch.cluster.metadata.IndexMetadata;
                        ); indexNumber++) {
    }
        }  
import java.util.ArrayList;
        // none of the newly created indices should be present in the list of fetched indices
        clusterState = deleteIndexFromClusterState(clusterState, 1);
                        }
            clusterState = addIndexToClusterState(clusterState, indexNumber);
            IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
                        for (int indexNumber = (pageNumber - 1) * pageSize; indexNumber < Math.min(
        IndexRoutingTable.Builder indexRoutingTableBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex());
import org.opensearch.cluster.routing.IndexRoutingTable;
            OpenSearchParseException.class,  
        assertEquals("test-index-5", paginationStrategy.getRequestedEntities().get(0));
        assertEquals("test-index-5", paginationStrategy.getRequestedEntities().get(0));
        try {
        String requestedToken = null;
        for (int deletedIndexPos = 0; deletedIndexPos < numIndicesToDelete; deletedIndexPos++) {
                    int responseItr = 0;
        assertThrows(
    }
            // randomly deleting 10 indices after 3rd call
        assertEquals(10, paginationStrategy.getRequestedEntities().size());
    }
        }
        assertThrows(
            if (numPages == 3) {
    public void testCreatingIndexStrategyPageTokenWithNameOfLastRespondedIndexNull() {  
import static java.nio.charset.StandardCharsets.UTF_8;
        PageParams pageParams = new PageParams(null, PARAM_ASC_SORT_VALUE, 1);
        assertThrows(OpenSearchParseException.class, () -> new IndexPaginationStrategy.IndexStrategyToken("3%4%5"));  
 */  
        IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        int pageSize = 6;  
            OpenSearchParseException.class,
            assertNotNull(paginationStrategy.getResponseToken());
        // Deleting test-index-3 which has already been displayed, still index2 should get displayed.  
            numPages++;  
        assertPaginationResult(paginationStrategy, 1, true);  
        assertEquals("test-index-1", paginationStrategy.getRequestedEntities().get(0));
            OpenSearchParseException.class,
        }
            .build();
    }
    /**  
        // adding test-index-5 to clusterState, before executing next query.
            () -> new IndexPaginationStrategy.IndexStrategyToken(PaginationStrategy.encryptStringToken("1|1725361543|index|12345"))
        ClusterState clusterState = getRandomClusterState(List.of(1, 2, 3, 4));  
    public void testIndexStrategyPageTokenWithWronglyEncryptedRequestToken() {
        assertPaginationResult(paginationStrategy, 1, false);
        IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);  
            .settings(
                        }
            .build();
        // Deleting test-index-2 which has already been displayed, still test-index-3 should get displayed
            requestedToken = paginationStrategy.getResponseToken().getNextToken();  
            if (requestedToken == null) {
                assertEquals(paginationStrategy.getRequestedEntities().size(), 5);
                }  
        IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
            }
        final int totalIndices = 100;  
    }
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_ASC_SORT_VALUE, 1);
        for (int indexNumber = 1; indexNumber <= 100; indexNumber++) {
                    clusterState = deleteIndexFromClusterState(clusterState, deletedIndices.get(pos));
        List<String> indicesFetched = new ArrayList<>();
        assertEquals("test-index-3", paginationStrategy.getRequestedEntities().get(0));  
            }  
            numPages++;
        assertNotNull(paginationStrategy);
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);  
 * SPDX-License-Identifier: Apache-2.0
        assertNull(paginationStrategy.getResponseToken().getNextToken());
import org.opensearch.test.OpenSearchTestCase;  
            indexNumberList.add(indexNumber);
        } catch (Exception e) {  
            if (requestedToken == null) {  
        // Adding index5 to clusterState, before executing next query.  
    }
            .routingTable(RoutingTable.builder().build())
import org.opensearch.cluster.routing.RoutingTable;
            }
 *
        assertNotNull(paginationStrategy.getResponseToken().getNextToken());
        assertEquals(tokenExpected, Objects.nonNull(paginationStrategy.getResponseToken().getNextToken()));
            .numberOfShards(between(1, 10))
            } else {
            for (int pageSize : pageSizeList) {  
        );
        assertEquals("test-index-2", paginationStrategy.getRequestedEntities().get(0));
        for (Integer indexNumber : indexNumbers) {  
        }  
    private ClusterState deleteIndexFromClusterState(ClusterState clusterState, int indexNumber) {  
                    PageParams pageParams = new PageParams(requestedToken, sortOrder, pageSize);
    public void testRetrieveIndicesWithSizeOneAndCurrentIndexGetsDeletedAscOrder() {
        // to ensure number of indices in last page is not always equal to pageSize.
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_DESC_SORT_VALUE, 1);
        assertNull(paginationStrategy.getResponseToken().getNextToken());  
            }
        for (int deletedIndexPos = 0; deletedIndexPos < numIndicesToDelete; deletedIndexPos++) {  
    public void testRetrieveIndicesWithSizeOneAndCurrentIndexGetsDeletedDescOrder() {  
                }
    }  
        assertEquals("test-index-4", paginationStrategy.getRequestedEntities().get(0));  
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
    public void testIndexStrategyPageTokenWithIncorrectNumberOfElementsInRequestedToken() {  
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_ASC_SORT_VALUE, 1);
            indexNumberList.add(indexNumber);
        for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
                for (int pos = 0; pos < numIndicesToDelete; pos++) {
        for (int indexNumber = 1; indexNumber <= 100; indexNumber++) {  
        List<Integer> deletedIndices = new ArrayList<>();
                    } else {  
        } while (Objects.nonNull(requestedToken));  
                assertEquals(paginationStrategy.getRequestedEntities().size(), (totalIndices - numIndicesToDelete) % pageSize);  
                            responseItr++;  
    public void testIndexStrategyPageTokenWithInvalidValuesInRequestedToken() {
    }  
                    requestedToken = paginationStrategy.getResponseToken().getNextToken();  
     */  
        assertPaginationResult(paginationStrategy, 1, true);
     * @param indexNumbers would be used to create indices having names with integer appended after foo, like foo1, foo2.
import org.opensearch.OpenSearchParseException;
        for (int indexNumber = 1; indexNumber <= 100; indexNumber++) {  
        // all the newly created indices should be present in the list of fetched indices
        PageParams pageParams = new PageParams(null, PARAM_DESC_SORT_VALUE, 1);  
            .metadata(Metadata.builder(clusterState.metadata()).put(indexMetadata, true).build())
        assertPaginationResult(paginationStrategy, 1, true);
        String token = clusterState.metadata().indices().get("test-index-10").getCreationDate() + "|" + "test-index-10";
            assertFalse(indicesFetched.contains("test-index-" + deletedIndices.get(deletedIndexPos)));
        clusterState = deleteIndexFromClusterState(clusterState, 1);
 * compatible open source license.
        do {  
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);  
        assertEquals("test-index-3", paginationStrategy.getRequestedEntities().get(0));
        List<Integer> deletedIndices = new ArrayList<>();
        );
        assertEquals(totalIndices + numIndicesToCreate - numIndicesToDelete, indicesFetched.size());
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
                    clusterState = deleteIndexFromClusterState(clusterState, deletedIndices.get(pos));  
    }  
        clusterState = addIndexToClusterState(clusterState, 5);
                        for (; indicesRemaining > endIndexNumberForPage; indicesRemaining--) {
        // instead test-index-5 should now get displayed.  
        // Deleting test-index-4 which is not yet displayed which otherwise should have been displayed in the following query
        assertEquals(expectedEntities, paginationStrategy.getRequestedEntities().size());  
package org.opensearch.action.pagination;
            .metadata(Metadata.builder().build())  
        // Checking pagination response for different pageSizes, which has a mix of even and odd numbers
        assertPaginationResult(paginationStrategy, 1, true);
        clusterState = deleteIndexFromClusterState(clusterState, 4);
                    IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);  
import org.opensearch.cluster.metadata.Metadata;  
        clusterState = deleteIndexFromClusterState(clusterState, 3);
        assertEquals(1, paginationStrategy.getRequestedEntities().size());
            indicesFetched.addAll(paginationStrategy.getRequestedEntities());  
        assertEquals((int) Math.ceil((double) (totalIndices - numIndicesToDelete) / pageSize), numPages);
     * @return random clusterState consisting of indices having their creation times set to the integer used to name them.
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);  
        for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {  
                for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
                        int endIndexNumberForPage = Math.max(indicesRemaining - pageSize, 0);  
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);  
            // randomly deleting 10 indices after 3rd call  
                            assertEquals("test-index-" + indicesRemaining, paginationStrategy.getRequestedEntities().get(responseItr));
                assertEquals(paginationStrategy.getRequestedEntities().size(), pageSize);
    public void testRetrieveIndicesWithTokenModifiedToQueryBeyondTotal() {  
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_DESC_SORT_VALUE, 1);  
        PageParams pageParams = new PageParams(null, PARAM_ASC_SORT_VALUE, 1);
            .build();
        ClusterState clusterState = getRandomClusterState(indexNumberList);  
            // creating 5 indices after 5th call
            }
            assertNotNull(paginationStrategy);  
        // creating a token with last sent index as test-index-10  
            // creating 5 indices after 5th call  
 * this file be licensed under the Apache-2.0 license or a
        final int numIndicesToDelete = 10;
        }  
    }  
        }
        // creating a cluster state with 100 indices  
        pageParams = new PageParams(paginationStrategy.getResponseToken().getNextToken(), PARAM_DESC_SORT_VALUE, 1);
            () -> new IndexPaginationStrategy.IndexStrategyToken(PaginationStrategy.encryptStringToken("1725361543"))  
    public void testCreatingIndexStrategyPageTokenWithRequestedTokenNull() {
            assertTrue(indicesFetched.contains("test-index-" + indexNumber));
        final int totalIndices = 100;
        clusterState = addIndexToClusterState(clusterState, 5);  
            assertFalse(indicesFetched.contains("test-index-" + indexNumber));  
import org.opensearch.Version;
                settings(Version.CURRENT).put(SETTING_CREATION_DATE, Instant.now().plus(indexNumber, ChronoUnit.SECONDS).toEpochMilli())  
import static org.opensearch.action.pagination.PageParams.PARAM_DESC_SORT_VALUE;  
import java.util.Collections;  
        );  
        ClusterState clusterState = getRandomClusterState(List.of(1, 2, 3, 4, 5));
        Collections.shuffle(indexNumberList, getRandom());
            if (numPages == 5) {
                deletedIndices = indexNumberList.subList(20, indexNumberList.size());  
        assertEquals("test-index-1", paginationStrategy.getRequestedEntities().get(0));
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);  
        return ClusterState.builder(clusterState)  
            if (numPages == 5) {  
    }  
        final int numIndicesToDelete = 9;  
                for (int pos = 0; pos < numIndicesToDelete; pos++) {
        // executing next query without any changes to clusterState
        assertNotNull(paginationStrategy.getResponseToken().getNextToken());  
/*  
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        List<Integer> indexNumberList = new ArrayList<>();
        do {
        for (String sortOrder : sortOrderList) {
        }
        assertEquals(0, paginationStrategy.getRequestedEntities().size());
            }
            .routingTable(RoutingTable.builder(clusterState.routingTable()).add(indexRoutingTableBuilder).build())
                    assertEquals(responseItr, paginationStrategy.getRequestedEntities().size());  
            .metadata(Metadata.builder(clusterState.metadata()).remove("test-index-" + indexNumber))
            indicesFetched.addAll(paginationStrategy.getRequestedEntities());
        clusterState = deleteIndexFromClusterState(clusterState, 3);  
}
            new IndexPaginationStrategy.IndexStrategyToken(null);
                for (int pageNumber = 1; pageNumber <= totalPagesToFetch; pageNumber++) {
        pageParams = new PageParams(Base64.getEncoder().encodeToString(token.getBytes(UTF_8)), PARAM_ASC_SORT_VALUE, 10);
import java.util.Objects;
        assertPaginationResult(paginationStrategy, 0, false);
            assertNotNull(paginationStrategy.getResponseToken());
            .build();  
        List<String> sortOrderList = List.of(PARAM_ASC_SORT_VALUE, PARAM_DESC_SORT_VALUE);
            assert e.getMessage().contains("requestedTokenString can not be null");
import java.util.Base64;
            .routingTable(RoutingTable.builder(clusterState.routingTable()).remove("test-index-" + indexNumber).build())  
                    if (PARAM_ASC_SORT_VALUE.equals(sortOrder)) {  
        assertNull(paginationStrategy.getResponseToken().getNextToken());
            if (numPages == 3) {
            assertNotNull(paginationStrategy);
        }
            IndexPaginationStrategy paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);  
        // Query1 with 4 indices in clusterState (test-index1,2,3,4)
        } catch (Exception e) {
        int numPages = 0;
                            100,
                for (int indexNumber = totalIndices + 1; indexNumber <= totalIndices + numIndicesToCreate; indexNumber++) {
        paginationStrategy = new IndexPaginationStrategy(pageParams, clusterState);
        try {  
