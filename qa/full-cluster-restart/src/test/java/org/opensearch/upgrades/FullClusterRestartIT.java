            int numDocs = extractTotalHits(response);  
            }
                ensureGreenLongWait(target);  
                }
     * Tests recovery of an index with or without a translog and the
                repoConfig.startObject("settings");
                    numDocs, true, true, randomBoolean(), i -> JsonXContent.contentBuilder().startObject().field("field", "value").endObject());
            }));  
            }
            client().performRequest(restoreRequest);
                    true,
            ensureGreen(index);
                    randomBoolean(),
        Map<String, Object> rsp = entityAsMap(client().performRequest(request));
        Map<?, ?> matchAllResponse = entityAsMap(client().performRequest(searchRequest));
            if (flushAllowed && rarely()) {  
        assertNoFailures(response);  
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), false);
            boolean foundPrimary = false;
        assertBasicAggregationWorks();
            Map<?, ?> bucket = (Map<?, ?>) entry;  
            nodes.add(nodeId);
                }  
     * {@link OpenSearchRestTestCase#ensureGreen}.  
        Map<String, Object> resp = entityAsMap(client().performRequest(search));
    void assertStoredBinaryFields(int count) throws Exception {
            }
     */
            setNumberOfReplicas.setJsonEntity("{ \"index\": { \"number_of_replicas\" : " + numReplicas + " }}");
            ensureGreen(index);
            byte[] randomByteArray = new byte[16];
            final Settings.Builder settings = Settings.builder()  
     * test that the repository is ok with containing snapshot from both the  
            client().performRequest(createIndex);
                }
        Map<?, ?> longHistogram = entityAsMap(client().performRequest(longHistogramRequest));
            flushRequest.addParameter("force", "true");
            bulk.append("{\"test\":\"test\"}\n");  
            assertNoFailures(response);
            // make sure all recoveries are done  
    }
            assertTotalHits(numDocs, entityAsMap(client().performRequest(new Request("GET", "/" + restoredIndex + "/_search"))));
                    mappingsAndSettings.field("index.number_of_shards", 5);
            assertMatchCount("title.sub", "dog", 3);  
        String stringValue = (String) XContentMapValues.extractValue("_source.string", bestHit);  
        Request clearRoutingFromSettings = new Request("PUT", "/_cluster/settings");
            bulk.append("{\"index\":{\"_id\":\"").append(count + i).append("\"}}\n");
import static org.hamcrest.Matchers.hasSize;
                for (Map<String, ?> shard : shards) {
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;  
            {
        for (int i = 0; i < bulkCount; i++) {  
                if (randomBoolean()) {
                }  
                logger.info("evaluating: {} , {}", ObjectPath.evaluate(shard, "routing"), ObjectPath.evaluate(shard, "commit"));
            {
                mappingsAndSettings.field("number_of_shards", 1);
            repoConfig.endObject();
 * version is started with the same data directories and then this is rerun
        Map<?, ?> response = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search")));
            createIndex.setJsonEntity(settings.toString());
        client().performRequest(new Request("POST", "/" + index + "/_refresh"));  
                    globalHistoryUUID = historyUUID;
        for (Object hit : hits) {  
            assertThat(routingTable, notNullValue());
            Map<String, Object> response = entityAsMap(client().performRequest(searchRequest));  
        totalHits = extractTotalHits(response);
                    "index.blocks.write": true
                        mappingsAndSettings.startObject("field");
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    private void indexDocument(String id) throws IOException {
            int liveDocs = Integer.parseInt(loadInfoDocument(index + "_doc_count"));  
                templateBuilder.endObject();
            {
import static org.hamcrest.Matchers.hasKey;
            restoreRequest.addParameter("wait_for_completion", "true");
            createSnapshot.setJsonEntity("{\"indices\": \"" + index + "\"}");
        assertTotalHits(count, response);
        Request countAfterWriteRequest = new Request("GET", "/restored_" + index + "/_search");  
    }
        Request updateRequest = new Request("POST", "/" + index + "/_update/" + docId);
        Map<String, Object> getRsp = entityAsMap(client().performRequest(getRequest));
            searchRequest.setJsonEntity("{ \"sort\": [{ \"int\" : \"asc\" }]}");
                Request segmentsRequest = new Request("GET", "/_cat/segments/" + index);
        // Make sure there are payloads and they are taken into account for the score
                mappingsAndSettings.startObject("settings");
        } else {
            ensureGreenLongWait(index);
            "derived_source (index.derived_source.enabled) is available from 3.3.0 onwards",
     * This test creates an index in the old cluster and then closes it. When the cluster is fully restarted in a newer version,  
                mappingsAndSettings.startObject("settings");  
        if (isRunningAgainstOldCluster()) {  
            }
        }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            // --- NEW docs written on the upgraded cluster into the SAME old index ---  
        countRequest.addParameter("size", "0");  
        Request request = new Request("GET", "/_cluster/health/" + index);  
            updateSettingsRequest.setJsonEntity(
                    assertThat(client().performRequest(getTasksIndex).getStatusLine().getStatusCode(), is(200));  
                if (translogOps > 0) {
                final String target = index + "_shrunken";
    static String toStr(Response response) throws IOException, ParseException {
        }
        if (isRunningAgainstOldCluster()) {
                }
            XContentBuilder settings = jsonBuilder();
                mappingsAndSettings.endObject();
                }
        for (Object entry : termsBuckets) {
        }  
            flush(index, true);
            XContentBuilder repoConfig = JsonXContent.contentBuilder().startObject();
        countAfterWriteRequest.addParameter("size", "0");
                mappingsAndSettings.endObject();
        List<Object> shardStats = ObjectPath.createFromResponse(response).evaluate("indices." + index + ".shards.0");
            assertMatchCount("title.sub", "fox", 3);   // query on the multi-field
        assertEquals("1", numberOfShards);  
                mappingsAndSettings.endObject();
        assertThat(totalShards, greaterThan(1));
        Version version = Version.fromId(Integer.valueOf((String) XContentMapValues.extractValue("metadata.indices." + index +
            shouldHaveTranslog = Booleans.parseBoolean(loadInfoDocument(index + "_should_have_translog"));
                        templateBuilder.field("version", isRunningAgainstOldCluster() ? getOldClusterVersion() : Version.CURRENT);
            restoreRequest.setJsonEntity(restoreCommand.toString());
                    "index":"test_index_reindex"  
                final String id = Integer.toString(randomIntBetween(1, 100));
            assertDerivedSourceTitle(12, "lazy dog 12");
                client().performRequest(new Request("PUT", "/" + index + "/_clone/" + target));
            templateBuilder.endObject();
            openIndex(index);  
            createTestIndex.setJsonEntity("{\"settings\": {\"index.number_of_replicas\": 0, \"index.number_of_shards\": 1}}");
        assertAllSearchWorks(count);
            {
            response = entityAsMap(client().performRequest(new Request("GET", "/" + shrunkenIndex + "/_search")));  
        boolTermsRequest.setJsonEntity("{ \"aggs\": { \"bool_terms\" : {\"terms\" : {\"field\": \"bool\"}} }}");
                }  
            createIndex(index, settings.build(), mappings);
            assertNoFailures(response);
     * snapshot on the new cluster and restores that on the new cluster as a
            logger.info("Refreshing [{}]", index);
    }
            numDocs = countOfIndexedRandomDocuments();
        Request request = new Request("GET", docLocation);
                if (rarely()) {
        }
                    count,
        final String snapshot = "snapshot-" + index;  
                mappingsAndSettings.field("number_of_replicas", 1);  
            assertEquals("mismatch while checking for translog recovery\n" + recoveryResponse, shouldHaveTranslog, restoredFromTranslog);  
        refreshAllIndices();  
                    settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true);
            XContentBuilder restoreCommand = JsonXContent.contentBuilder().startObject();
        // Make sure the query can run on the whole index  
 * specific language governing permissions and limitations
import org.opensearch.common.xcontent.json.JsonXContent;  
            assertNoFileBasedRecovery(index, n -> true);  
        if (isRunningAgainstOldCluster()) {
            Request getTask = new Request("GET", "/_tasks/" + taskId);
        }
        assertThat(EntityUtils.toString(client().performRequest(bulkRequest).getEntity()), containsString("\"errors\":false"));
            int numDocs = countOfIndexedRandomDocuments();  
                    true,
        // Make sure search finds all documents
                }
                    + "}");  
    }  
    void assertRealtimeGetWorks() throws IOException {  
import java.util.Set;
            createIndex.setJsonEntity("{"
        }
                    numDocs,  
        // Count the documents in the index to make sure we have as many as we put there
            {
                    mappingsAndSettings.endObject();
            count = countOfIndexedRandomDocuments();
                        mappingsAndSettings.endObject();  
        restoreRequest.addParameter("wait_for_completion", "true");  
                }  
            createIndex.setJsonEntity(mappingsAndSettings.toString());
 * license agreements. See the NOTICE file distributed with
                        fail("expected version to be one of [" + currentLuceneVersion + "," + bwcLuceneVersion + "] but was " + line);
            restoreCommand.startObject("index_settings");  
     * before we restart the cluster. This is important when we move from translog based to retention leases based  
            repoConfig.endObject();  
            client().performRequest(createIndex);  
            final Settings.Builder settings = Settings.builder()
            // less than 10% of the committed docs (see IndexSetting#FILE_BASED_RECOVERY_THRESHOLD_SETTING).
                counts.add(hits);  
            count = countOfIndexedRandomDocuments();
            flush(index, true);  
            // Create the repo
import static org.hamcrest.Matchers.containsString;  
            createIndex.setJsonEntity(mappingsAndSettings.toString());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        XContentBuilder templateBuilder = JsonXContent.contentBuilder().startObject();
    public void testSearch() throws Exception {
        final Request indexRequest = new Request("POST", "/" + index + "/" + type + "/" + id);
                Request doc = new Request("PUT", "/" + index + "/_doc/" + i);
        assertOK(client().performRequest(indexRequest));
        assertEquals(totalShards, successfulShards);
        }
        // Count the documents in the index to make sure we have as many as we put there
        }  
                assertNotEquals("expected at least 1 current segment after translog recovery. segments:\n" + segmentsResponse,
import org.opensearch.test.rest.OpenSearchRestTestCase;
            client().performRequest(createIndex);  
        Request createSnapshot = new Request("PUT", "/_snapshot/repo/" + (isRunningAgainstOldCluster() ? "old_snap" : "new_snap"));
        assertTrue("doc does not contain 'foo' key: " + source, source.containsKey("foo"));  
    public void testOperationBasedRecovery() throws Exception {  
            Map<String, Object> response = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search")));
            assertDerivedSourceTitle(0, "quick brown fox 0");  
                    String version = m.group(1);  
    /**
        }
                    false,
        assertTotalHits(count + extras, countAfterResponse);  
        {  
            }  
            getOldClusterVersion().onOrAfter(Version.fromString("3.3.0"))
            for (int i = 0; i < numDocs; i++) {
            Map<String, Object> response = entityAsMap(client().performRequest(searchRequest));  
            if (minimumNodeVersion().before(Version.V_2_0_0)) {
    public void testResize() throws Exception {  
            bulk.setJsonEntity("{\"index\": {\"_index\": \"test_index_old\"}}\n" + "{\"f1\": \"v1\", \"f2\": \"v2\"}\n");  
        int count;
        int totalShards = (int) XContentMapValues.extractValue("_shards.total", response);
     */  
            restoreCommand.field("indices", index);
import org.opensearch.common.xcontent.XContentType;
                        numBwcVersion++;
            assertThat("Expected stats for 2 shards", shardStats, hasSize(2));
            final String mappings = randomBoolean() ? "\"_source\": { \"enabled\": false}" : null;  
                    mappingsAndSettings.endObject();
        Request createTemplateRequest = new Request("PUT", "/_template/test_template");
                mappingsAndSettings.field("number_of_replicas", 0);
        assertThat(settings, notNullValue());
                  "source":{
        final Map<String, ?> metadata = (Map<String, Object>) XContentMapValues.extractValue("metadata.indices." + index, state);
                    containsString("testrollover-000002"));
            }  
                repoConfig.endObject();
        client().performRequest(restoreRequest);
            restoreCommand.endObject();
            for (int i = 0; i < moreDocs; i++) {  
     *  <li>Make sure the document count is correct
                    flush(index, randomBoolean());
import org.opensearch.test.NotEqualMessageBuilder;  
        client().performRequest(new Request("DELETE", "/restored_*"));  
        }
                assertNumHits(target, numDocs + moreDocs, 6);
    }  
                        {
 * software distributed under the License is distributed on an
                client().performRequest(doc);
            client().performRequest(createIndex);
            /* We've had bugs in the past where we couldn't restore  
                numDocs = between(1, 100);  
package org.opensearch.upgrades;
                        mappingsAndSettings.endObject();  
        assertThat(blocks, notNullValue());  
                {
            mappingsAndSettings.startObject();  
                mappingsAndSettings.startObject("mappings");
                indexDocument(Integer.toString(randomIntBetween(1, 100)));
                        mappingsAndSettings.endObject();
            assertEquals(numDocs, totalHits);
        // Remove the routing setting and template so we can test restoring them.
            mappingsAndSettings.endObject();
            for (int i = 0; i < numDocs; i++) {  
 * Unless required by applicable law or agreed to in writing,
                    request.setJsonEntity(JsonXContent.contentBuilder().startObject().field("field", "v1").endObject().toString());  
                repoConfig.endObject();  
                    repoConfig.field("location", System.getProperty("tests.path.repo"));
            assertThat(routingTable, nullValue());  
    public void testShrinkAfterUpgrade() throws IOException, ParseException {  
            client().performRequest(shrinkIndexRequest);
    /**  
                Matcher m = Pattern.compile("(\\d+)$").matcher(line);
        assertThat(persistentSettings.get("cluster.routing.allocation.exclude.test_attr"), equalTo(getOldClusterVersion().toString()));
            assertDerivedSourceTitle(2, "quick brown fox 2");  
        longHistogramRequest.setJsonEntity("{ \"aggs\": { \"histo\" : {\"histogram\" : {\"field\": \"int\", \"interval\": 10}} }}");  
            client().performRequest(getTask);
        assertNoFailures(response);  
            int numDocs = between(10, 100);
            Request statsRequest = new Request("GET", index + "/_stats");  
        int successfulShards = (int) XContentMapValues.extractValue("_shards.successful", response);  
                        mappingsAndSettings.field("type", "text");
        // Clean up the index for the next iteration
            {  
                    numDocs, true, false, randomBoolean(), i -> JsonXContent.contentBuilder().startObject().field("field", "value").endObject());  
            createTemplate.setJsonEntity(mappingsAndSettings.toString());
        }
                try {
     * Wait for an index to have green health, waiting longer than
import org.opensearch.client.Response;  
                    mappingsAndSettings.field("type", "text");  
import java.util.regex.Pattern;
                assertThat(indices, hasKey(".tasks"));  
                    i -> jsonBuilder().startObject().field("field", "value").endObject()
        return nodes;
        addRoutingSettings.setJsonEntity(  
            assertThat(Booleans.parseBoolean((String) XContentMapValues.extractValue("index.verified_before_close", settings)), is(true));  
import static org.hamcrest.Matchers.is;  
        Request clusterSettingsRequest = new Request("GET", "/_cluster/settings");  
                final String target = index + "_split";
                    }
        templateBuilder.field("index_patterns", "evil_*"); // Don't confuse other tests by applying the template  
    public void testTurnOffTranslogRetentionAfterUpgraded() throws Exception {
            client().performRequest(updateSettingsRequest);  
        } else {
        Request writeToRestoredRequest = new Request("POST", "/restored_" + index + "/_bulk");
            assertEquals(1, totalShards);  
import java.io.IOException;
            Response response = client().performRequest(statsRequest);
            client().performRequest(createRepoRequest);  
                logger.debug("Flushing [{}]", index);
            XContentBuilder mappingsAndSettings = jsonBuilder();
        int numDocs;
            Map<String, Object> response = entityAsMap(client().performRequest(searchRequest));  
                v.compatible(systemIndexWarning);
    }
                if (randomBoolean()) {
        } else {
                mappingsAndSettings.startObject("properties");
            Map<String, Object> recoverRsp = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_recovery")));
                assertNoFailures(responseBody);
        assertThat(toStr(client().performRequest(request)), containsString(doc));
            int numDocs = randomIntBetween(0, 100);
            mappingsAndSettings.endObject();
                {
                    count / 10,  
        }
        }
        // terms on a boolean
                }
            for (int i = 0; i < nbShards; i++) {  
    }  
            Request updateSettingsRequest = new Request("PUT", "/" + index + "/_settings");  
            Request searchRequest = new Request("GET", "/" + index + "/_search");
    void assertBasicAggregationWorks() throws IOException {  
     * Tests that with or without soft-deletes, we should perform an operation-based recovery if there were some
        aliases.put("alias1", emptyMap());  
                }
                }  
        logger.info("--> testing basic search with sort");
    /**
            client().performRequest(updateSettingsRequest);  
public class FullClusterRestartIT extends AbstractFullClusterRestartTestCase {
            client().performRequest(createIndex);
            settings.endObject();
            // GET _source still reconstructs for old docs
     *  <li>Write some documents to the write alias  
            Map<String, Object> response = entityAsMap(client().performRequest(reindex));
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build());
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1);
                    repoConfig.field("compress", randomBoolean());
            }  
                    flush(index, randomBoolean());  
import org.apache.hc.core5.http.io.entity.EntityUtils;
                refreshAllIndices();
                }  
                mappingsAndSettings.field("number_of_shards", 1);  
        int successfulShards = (int) XContentMapValues.extractValue("_shards.successful", response);  
    }  
    private void refresh() throws IOException {
        }
            mappingsAndSettings.startObject();
                  }  
     *  <li>Roll over the index
import static org.hamcrest.Matchers.greaterThan;
                    }
                if (rarely()) {
        Map<?, ?> searchResponse = entityAsMap(client().performRequest(searchRequest));
            createRepoRequest.setJsonEntity(repoConfig.toString());
    private void assertMatchCount(String field, String term, int expectedHits) throws IOException {
        final Map<String, ?> state = entityAsMap(client().performRequest(new Request("GET", "/_cluster/state")));
            assertEquals(count, numDocs);
                {  
        int numDocs;
        assertTrue(doc, m.find());  
        request.addParameter("timeout", "2m");
        if (isRunningAgainstOldCluster()) {  
                        mappingsAndSettings.startObject("field");  
            client().performRequest(createTestIndex);
        Request listSnapshotRequest = new Request("GET", "/_snapshot/repo/" + snapshotName);
        int histoCount = 0;
        expectedTemplate.put("order", 0);
                assertThat(tasksCreatedVersionString, notNullValue());
                    mappingsAndSettings.startObject("fields");
        return EntityUtils.toString(response.getEntity());
        numberOfShards = (String) XContentMapValues.extractValue("metadata.indices." + index +
        assertTotalHits(count, countResponse);
        }
                    } else if (minCompatibleBWCVersion.equals(version) && minCompatibleBWCVersion.equals(bwcLuceneVersion) == false) {
                            .endObject()
 *
                int translogOps = Integer.parseInt(m.group(1));  
                // before timing out  
import org.opensearch.common.settings.Settings;
                mappingsAndSettings.endObject();
            Request getTasksIndex = new Request("GET", "/.tasks");
        assertStoredBinaryFields(count);
        Map<String, Object> countAfterResponse = entityAsMap(client().performRequest(countRequest));
            if (shouldHaveTranslog) {  
     */
                    "{\"persistent\": {\"cluster.routing.allocation.exclude.test_attr\": \"" + getOldClusterVersion() + "\"}}");
        assertTotalHits(count, rsp);  
        if (isRunningAgainstOldCluster()) {
        assertRealtimeGetWorks();  
import java.util.List;
    private void assertDerivedSourceTitle(int id, String expectedTitle) throws IOException {
                    true,  
                XContentTestUtils.JsonMapView tasksIndex = new XContentTestUtils.JsonMapView((Map<String, Object>) indices.get(".tasks"));
            Request createIndex = new Request("PUT", "/" + index);  
                    {
                            mappingsAndSettings.field("type", "text");
        Request enableAutoRefresh = new Request("PUT", "/" + index + "/_settings");
            ensureGreen(index);
            {
            histoCount += (Integer) bucket.get("doc_count");
        XContentBuilder restoreCommand = JsonXContent.contentBuilder().startObject();
     * peer recoveries.
                {  
        for (int i = 0; i < count; i++) {
                Request request = new Request("POST", "/" + index + "/_doc/" + i);
            totalHits = extractTotalHits(response);  
        countRequest.addParameter("size", "0");  
            logger.debug("Indexing document [{}]", i);
            createSnapshot.setJsonEntity("{\"indices\": \"" + index + "\"}");
                        {  
            refresh();  
    }
    }  
                    mappingsAndSettings.startObject("field");  
            // OLD cluster: GET _source + query both work on old docs
            int numDocs = randomIntBetween(0, 100);
            count = randomIntBetween(2000, 3000);  
        expectedTemplate.put("settings", singletonMap("index", singletonMap("number_of_shards", "1")));
        final boolean flushAllowed,
            builder.compareMaps(getTemplateResponse, expectedTemplate);  
    }
        clearRoutingFromSettings.setJsonEntity("{\"persistent\":{\"cluster.routing.allocation.exclude.test_attr\": null}}");  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1);
                // but the recovering copy will be seen as invalid and the cluster health won't return to GREEN
        templateBuilder.startObject("mappings"); {
                    "index.blocks.write": true
            );
        assertThat(XContentMapValues.extractValue("_shards.total", resp), equalTo(totalShards));  
        if (isRunningAgainstOldCluster()) {
    /**
        if (false == isRunningAgainstOldCluster()) {
                    mappingsAndSettings.field("soft_deletes.enabled", true);
        {  
        type = "_doc";
import org.opensearch.client.ResponseException;
            createIndex(index, Settings.builder()
                repoConfig.field("type", "fs");
                {  
        request.addParameter("wait_for_no_relocating_shards", "true");  
     * (query) keep working for documents indexed BEFORE and AFTER the upgrade.
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
 * The OpenSearch Contributors require contributions made to  
        Map<?, ?> bestHit = (Map<?, ?>) ((List<?>) (XContentMapValues.extractValue("hits.hits", response))).get(0);
            indexRandomDocuments(
                assertThat("no history uuid found on " + nodeId + " (primary: " + primary + ")", historyUUID, notNullValue());  
        searchRequest.setJsonEntity("{ \"query\": { \"match_all\" : {} }}");  
        Map<String, Object> count = entityAsMap(client().performRequest(countRequest));  
        assertEquals(1, totalShards);
            }  
            }  
                    flush(index, randomBoolean());
        Map<?, ?> source = (Map<?, ?>) getRsp.get("_source");
                }
                    final Request request = new Request("POST", "/" + index + "/" + type + "/" + i);
                }
     * multi-fields (sub-fields) are no longer force-stored, while the parent text field still is.
            Settings.Builder settings = Settings.builder();
        List<?> termsBuckets = (List<?>) XContentMapValues.extractValue("aggregations.bool_terms.buckets", boolTerms);  
            mappingsAndSettings.endObject();  
                    {
            {
        final int count,  
        indexRequest.setJsonEntity(JsonXContent.contentBuilder().startObject().field("f", "v").endObject().toString());  
            }
        assertNoFailures(count);
            {  
    }
        for (Object entry : histoBuckets) {
            ".settings.index.number_of_shards", clusterState);
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true);
                    mappingsAndSettings.endObject();
        Matcher m = Pattern.compile("\"value\":\"(.+)\"").matcher(doc);
                    }
     */
        Map<String, Object> listSnapshotResponse = entityAsMap(client().performRequest(listSnapshotRequest));
        }
        Request countRequest = new Request("GET", "/" + index + "/_search");
        Map<String, Object> aliases = new HashMap<>();
        search.setJsonEntity("{\"track_total_hits\":true,\"query\":{\"match\":{\"" + field + "\":\"" + term + "\"}}}");  
                ensureGreenLongWait(target);  
        int termsCount = 0;
                mappingsAndSettings.endObject();
            }
            }
            reindex.addParameter("wait_for_completion", "false");  
            client().performRequest(new Request("POST", "/" + index + "/_refresh"));
            for (int i = 0; i < numDocs; i++) {  
            {
            saveInfoDocument(index + "_doc_count", Integer.toString(liveDocs));
                {  
            client().performRequest(new Request("POST", "/" + index + "/_refresh"));
        Map<String, Object> expectedTemplate = new HashMap<>();
            createIndex(index, settings.build());  
        if (isRunningAgainstOldCluster()) {
        } else {  
    public void testClosedIndices() throws Exception {  
        } else {
                // then delayed allocation will kick in. When the node comes back, the cluster-manager will search for a copy
            client().performRequest(bulk);
            mappingsAndSettings.startObject();  
            }
     */
            restoreCommand.startObject("index_settings");
                mappingsAndSettings.field("index.derived_source.enabled", true);
            ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
 * of an older version. The cluster is shutdown and a cluster of the new
    private List<String> dataNodes(String index, RestClient client) throws IOException {  
                Request clusterStateRequest = new Request("GET", "/_cluster/state/metadata");
            createRepoRequest.setJsonEntity(repoConfig.toString());
            XContentBuilder restoreCommand = JsonXContent.contentBuilder().startObject();  
            client().performRequest(rolloverRequest);
                restoreCommand.field("index.soft_deletes.enabled", true);  
        final Map<String, ?> settings = (Map<String, Object>) XContentMapValues.extractValue("settings", metadata);  
    /**
        infoDoc.field("value", value);
            assertMatchCount("title", "quick", 3);      // query on the parent
                doc.setJsonEntity("{\"title\":\"quick brown fox " + i + "\"}");
            assertTotalHits(count, response);
                mappingsAndSettings.field("number_of_replicas", 1);
        client().performRequest(disableAutoRefresh);  
        request.setJsonEntity("{ \"query\": { \"match_all\" : {} }, \"size\": 100, \"stored_fields\": \"binary\"}");  
            Map<?, ?> bucket = (Map<?, ?>) entry;  
                    assertThat(XContentMapValues.extractValue("index", shard), equalTo(index));
            logger.debug("--> creating [{}] replicas for index [{}]", numReplicas, index);  
            createIndex.setOptions(allowTypesRemovalWarnings());  
    }  
                    continue;
            ensureGreen(index);
                indexDocument(Integer.toString(i));
    }
     * BWC for the derived-source multi-field store fix: under index.derived_source.enabled, text  
                client().performRequest(shrinkRequest);
                    templateBuilder.field("enabled", true);  
        String docLocation = "/" + index + "/" + type + "/1";  
    @SuppressWarnings("unchecked")  
            String currentLuceneVersion = Version.CURRENT.luceneVersion.toString();
        String id = (String) bestHit.get("_id");
                templateBuilder.endObject();  
            Request createTestIndex = new Request("PUT", "/test_index_old");  
            createIndex.setJsonEntity(mappingsAndSettings.toString());
        logger.info("--> testing _all search");
        assertEquals(numDocs, totalHits);  
        // Refresh the index so the count doesn't fail
        assumeTrue(  
                templateBuilder.startObject("_source");
            String globalHistoryUUID = null;  
                            .field("float", randomFloat())
        XContentBuilder infoDoc = JsonXContent.contentBuilder().startObject();  
            // create repo
        ensureGreenLongWait(index);
        }
            XContentBuilder repoConfig = JsonXContent.contentBuilder().startObject();
    }  
            restoreCommand.endObject();
        expectedTemplate.put("index_patterns", singletonList("evil_*"));  
            int moreDocs = randomIntBetween(0, 100);
    }
            final ResponseException error = expectThrows(ResponseException.class, () -> client().performRequest(restoreRequest));  
                    i -> JsonXContent.contentBuilder().startObject().field("field", "value").endObject()
            mappingsAndSettings.field("index_patterns", index);
     * Tests snapshot/restore by creating a snapshot and restoring it. It takes
                final Boolean primary = ObjectPath.evaluate(shard, "routing.primary");  
            mappingsAndSettings.endObject();
    void assertBasicSearchWorks(int count) throws IOException {
            searchRequest.setJsonEntity("{ \"query\": { \"exists\" : {\"field\": \"field.with.dots\"} }}");
            reindex.setJsonEntity(
            indexRandomDocuments(numDocs, true, true, randomBoolean(), i -> jsonBuilder().startObject().field("field", "value").endObject());  
                mappingsAndSettings.startObject("settings");
        totalShards = (int) XContentMapValues.extractValue("_shards.total", response);
            indexRandomDocuments(numDocs, true, true, randomBoolean(), i -> jsonBuilder().startObject().field("field", "value").endObject());  
        assertEquals(expectedCount, extractTotalHits(count));
    protected void ensureGreenLongWait(String index) throws IOException {
    @Before  
                );
            Request updateSettingsRequest = new Request("PUT", "/" + index + "/_settings");  
        assertEquals("0", numberOfReplicas);
        assertBasicSearchWorks(count);  
        } else {  
            statsRequest.addParameter("level", "shards");
        if (isRunningAgainstOldCluster()) {  
        client().performRequest(clearRoutingFromSettings);
                    repoConfig.field("location", System.getProperty("tests.path.repo"));
        Map<String, Object> countResponse = entityAsMap(client().performRequest(countRequest));
            {  
                """
            );
            // Force flush so we're sure that all translog are committed  
    }
                }
        if (isRunningAgainstOldCluster()) {
            {
    }
                    + "  \"aliases\": {"  
     * Tests that a single document survives. Super basic smoke test.  
        client().performRequest(createSnapshot);
                settings.field("number_of_shards", between(1, 5));  
        }  
            client().performRequest(createTemplate);  
            closeIndex(index);
            createIndex(index, Settings.builder()
    }
                    true,  
        String shrunkenIndex = index + "_shrunk";
        assertEquals(100, hits.size());
        assertEquals(singletonList(snapshotName), XContentMapValues.extractValue("snapshots.snapshot", listSnapshotResponse));  
    private String loadInfoDocument(String id) throws IOException, ParseException {
        assertFalse((Boolean) healthRsp.get("timed_out"));  
                }
            Request createIndex = new Request("PUT", "/" + index);
            createIndex.setJsonEntity(mappingsAndSettings.toString());  
        Map<String, Object> healthRsp = entityAsMap(client().performRequest(request));  
 * this file be licensed under the Apache-2.0 license or a
            refreshAllIndices();
                if (isRunningAgainstAncientCluster()) {  
            }
                    }  
                templateBuilder.startObject("filter"); {  
            client().performRequest(updateSettingsRequest);
        ensureGreenLongWait(index);
            }
        clusterSettingsRequest.addParameter("flat_settings", "true");
            }
                assertNumHits(target, numDocs + moreDocs, 3);
            }
 */
 * under the License.  
    /**
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            {  
            XContentBuilder repoConfig = JsonXContent.contentBuilder().startObject(); {  
        templateBuilder.startObject("settings"); {
                restoreCommand.field("index.soft_deletes.enabled", false);
                client().performRequest(doc);  
            // create repo
        }
        templateBuilder.startObject("aliases"); {  
        restoreCommand.field("rename_replacement", "restored_" + index);  
    /**  
                  "settings": {
            recoveryRequest.addParameter("s", "index,shard,type");
        }  
        Response response = client.performRequest(request);  
            createIndex.setJsonEntity(mappingsAndSettings.toString());
        Request explainRequest = new Request("GET", "/" + index + "/_explain" + "/" + id);
import static org.hamcrest.Matchers.equalTo;
        int totalShards = (int) XContentMapValues.extractValue("_shards.total", response);
            String taskId = (String) response.get("task");
        }
                    true,
     * old and new versions. All of the snapshots include an index, a template,
            settings.startObject();  
            final int nbShards = Integer.parseInt(numberOfShards);  
                  }  
    // TODO tests for upgrades after shrink. We've had trouble with shrink in the past.  
            XContentBuilder mappingsAndSettings = jsonBuilder();
                mappingsAndSettings.field("number_of_shards", 1);
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());  
                } else if (randomBoolean()) {  
        infoDoc.endObject();
        Request search = new Request("GET", "/" + index + "/_search");
        assertEquals(numDocs, totalHits);  
            bulk.addParameter("refresh", "true");
        Request getTemplateRequest = new Request("GET", "/_template/test_template");
        }  
             * an index without a translog so we randomize whether
                } else {  
                mappingsAndSettings.field("index.number_of_shards", 5);
            createIndex(index, settings.build());  
            final String nodeId = ObjectPath.evaluate(shard, "routing.node");
        // Stick a template into the cluster so we can see it after the restore
                        continue;
                    Matcher m = Pattern.compile("(\\d+\\.\\d+\\.\\d+)$").matcher(line);
        assertTotalHits(count, matchAllResponse);  
import org.opensearch.cluster.metadata.IndexMetadata;  
     * MAPPING_RECOVERY on restart), so this verifies both _source reconstruction (GET) and search  
                            .field("field.with.dots", randomAlphaOfLength(10))
            Request flushRequest = new Request("POST", "/" + index + "/_flush");
            ensureGreen(index);  
            ensureGreen(index); // wait for source index to be available on both nodes before starting shrink
        if (isRunningAgainstOldCluster()) {
                    mappingsAndSettings.startObject("properties");
     * NOTE: derived_source (index.derived_source.enabled) is available from 3.3.0 onwards (#18565).  
                    false, // flushing here would invalidate the whole thing
                } catch (ResponseException e) {
import org.opensearch.index.IndexSettings;
            }
                Request splitRequest = new Request("PUT", "/" + index + "/_split/" + target);  
            }
import java.util.Locale;  
                  }
            XContentBuilder mappingsAndSettings = jsonBuilder();
                repoConfig.field("type", "fs");
        logger.info("--> testing field with dots in the name");
            int liveDocs = numDocs;
                    if (false == line.startsWith("p")) {
            client().performRequest(new Request("POST", "/" + index + "/_refresh"));  
                            .field("bool", i > 0 && randomBoolean())
        int totalHits = extractTotalHits(response);
                mappingsAndSettings.startObject("settings");
        if (false == expectedTemplate.equals(getTemplateResponse)) {
        assertEquals("0", numberOfReplicas);  
            }
            // create index
            mappingsAndSettings.endObject();  
                    .get("metadata.indices");  
            boolean restoredFromTranslog = false;  
            String value = (String) values.get(0);
            if (shouldHaveTranslog && false == currentLuceneVersion.equals(bwcLuceneVersion)) {
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());  
        // verifying if we can still read some properties from cluster state api:
                }  
import org.opensearch.core.common.Strings;
import java.util.HashSet;
    public void testSnapshotRestore() throws IOException, ParseException {
            // Restore
                    Request request = new Request("POST", "/" + index + "/_doc/" + i);  
            }  
            }  
                mappingsAndSettings.startObject("mappings");  
    public void testForbidDisableSoftDeletesOnRestore() throws Exception {
            // query still matches old docs (sub-field still indexed; parent still stored)
            Request createIndex = new Request("PUT", "/" + index);
            client().performRequest(new Request("POST", "/" + index + "/_flush"));  
        Request request = new Request("GET", index + "/_stats");
                repoConfig.field("type", "fs");
    }
                mappingsAndSettings.field("number_of_replicas", 0);  
 *
                assertThat(new XContentTestUtils.JsonMapView(indices).get("test_index_old.system"), is(false));  
                    settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true);
                indexDocument(id);
            createIndex.setJsonEntity(mappingsAndSettings.toString());
                segmentsRequest.addParameter("h", "prirep,shard,index,version");  
    }
        // And count to make sure the add worked
            Request createIndex = new Request("PUT", "/" + index + "-000001");
                for (String line : segmentsResponse.split("\n")) {  
        }  
        }  
        Map<?, ?> boolTerms = entityAsMap(client().performRequest(boolTermsRequest));
                }""");
        searchRequest.addParameter("explain", "true");  
            assertThat(EntityUtils.toString(client().performRequest(new Request("GET", "/_cat/indices?v")).getEntity()),  
    public void testSystemIndexMetadataIsUpgraded() throws Exception {
    }
        }  
                mappingsAndSettings.field("number_of_shards", 1);
            indexRandomDocuments(count, true, true, true, i -> jsonBuilder().startObject().field("field", "value").endObject());
        String doc = toStr(client().performRequest(request));
                mappingsAndSettings.endObject();  
                    mappingsAndSettings.field("type", "text");
            }  
            getTasksIndex.addParameter("allow_no_indices", "false");
                if (globalHistoryUUID == null) {
        Request getRequest = new Request("GET", "/" + index + "/" + type + "/" + docId);  
 * with {@code tests.is_old_cluster} set to {@code false}.  
import static java.util.Collections.singletonList;
     *  <li>Write some more documents to the write alias
}
        bulkRequest.setJsonEntity(bulk.toString());
        // Check settings added by the restore process
                refresh();  
            restoreCommand.field("rename_replacement", "restored-" + index);
            mappingsAndSettings.endObject();
                /* Mark if we see a primary that looked like it restored from the translog.  
            }
                if (isRunningAgainstAncientCluster()) {  
                    + "  \"conditions\": {"  
        // Check some index properties:  
                    mappingsAndSettings.endObject();  
        assertThat(XContentMapValues.extractValue("_source.title", doc), equalTo(expectedTitle));
                mappingsAndSettings.endObject();
                {
                request.setJsonEntity(doc);
            client().performRequest(createSnapshot);
    void assertAllSearchWorks(int count) throws IOException, ParseException {  
                        // Our upgrade path from 7.non-last always goes through 7.last, which depending on timing can create 7.last  
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());
        checkSnapshot("old_snap", count, getOldClusterVersion());
                client().performRequest(splitRequest);
        } else {  
                // Can't get the .tasks index via JsonMapView because it splits on `.`
            // create snapshot
        // Check that the template was restored successfully
            }
            for (Object shard : shardStats) {
            indexRandomDocuments(
            final int numReplicas = 1;
            createIndex(index, settings.build());
        assertFalse("Could not find payload boost in explanation\n" + explanation, explanation.contains("payloadBoost"));
     * statistics we gather about that.
        String docId = (String) hit.get("_id");  
        }  
                segmentsRequest.addParameter("s", "prirep,shard,index");
     * it verifies that the index exists and is replicated if the old version supports replication.
            createIndex(index, settings.build());
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        final CheckedFunction<Integer, XContentBuilder, IOException> docSupplier
 */
        assertEquals(singletonList(tookOnVersion.toString()), XContentMapValues.extractValue("snapshots.version", listSnapshotResponse));
            Request createSnapshot = new Request("PUT", "/_snapshot/repo/" + snapshot);
            Request createIndex = new Request("PUT", "/" + index);  
        if (isRunningAgainstOldCluster()) {  
import static org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY;
        assertThat(extractTotalHits(resp), equalTo(numHits));
            Request shrinkIndexRequest = new Request("PUT", "/" + index + "/_shrink/" + shrunkenIndex);
    private String index;
     *
        String shrunkenIndex = index + "_shrunk";
        Request request = new Request("GET", "/info/_doc/" + id);
     * sanity check and on the new cluster as an upgrade test. It also takes a
            logger.debug("--> index [{}] is green, took [{}] ms", index, (System.currentTimeMillis() - startTime));
        Request restoreRequest = new Request("POST", "/_snapshot/repo/" + snapshotName + "/_restore");
            rolloverRequest.setJsonEntity("{"
                    + "}");  
                    "index":"test_index_old"  
        assertNoFailures(resp);
            final Settings.Builder settings = Settings.builder()
    }  
                    (Collection<Map<String, ?>>) XContentMapValues.extractValue("shards." + i, routingTable);
            Request restoreRequest = new Request("POST", "/_snapshot/repo/" + snapshot + "/_restore");  
            assertNoFailures(response);
                {  
                            mappingsAndSettings.field("type", "text");
            ensureGreen(index);
    /**
    public void testEnableSoftDeletesOnRestore() throws Exception {
        bulkRequest.addParameter("refresh", "");  
        int count;
                }  
        } else {  
                }  
            final long startTime = System.currentTimeMillis();
            {  
                    + "    \"max_docs\": 5"
        logger.info("health api response: {}", healthRsp);
        int numDocs;  
     * Test upgrading after a rollover. Specifically:  
            XContentBuilder mappingsAndSettings = jsonBuilder();  
            createIndex(index, settings.build(), mappings);  
                            // be sure to create a "proper" boolean (True, False) for the first document so that automapping is correct  
            }
            createRepoRequest.setJsonEntity(repoConfig.toString());
            String recoveryResponse = toStr(client().performRequest(recoveryRequest));
        assertEquals(singletonList("SUCCESS"), XContentMapValues.extractValue("snapshots.state", listSnapshotResponse));
                    request.setJsonEntity(doc);
        assertEquals(getOldClusterVersion(), version);  
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)  
            // Restore
            numDocs = randomIntBetween(10, 1000);
            assertBusy(() -> {
                {
            Request rolloverRequest = new Request("POST", "/" + index + "_write/_rollover");
            shrinkIndexRequest.setJsonEntity("{\"settings\": {\"index.number_of_shards\": 1}}");  
        }
     * and some routing configuration.
        disableAutoRefresh.setJsonEntity("{ \"index\": { \"refresh_interval\" : -1 }}");
        Map<?, ?> hit = (Map<?, ?>) ((List<?>)(XContentMapValues.extractValue("hits.hits", searchResponse))).get(0);
    private String type;
                    + "    \"" + index + "_write\": {}"
            }
            assertThat(XContentMapValues.extractValue("index.verified_before_close", settings), nullValue());
            mappingsAndSettings.endObject();  
    public static void assertNumHits(String index, int numHits, int totalShards) throws IOException {  
     * Asserts that an index is closed in the cluster state. If `checkRoutingTable` is true, it also asserts  
        assertThat(XContentMapValues.extractValue("_shards.successful", resp), equalTo(totalShards));
            // --- OLD docs after full restart + mapping re-parse by new code ---
            Request setNumberOfReplicas = new Request("PUT", "/" + index + "/_settings");
                mappingsAndSettings.endObject();  
import static java.util.Collections.emptyMap;  
                }  
        assertNoFailures(longHistogram);
            Request createIndex = new Request("PUT", "/" + index);  
        // the 'string' field has a boost of 4 in the mappings so it should get a payload boost
                }  
            numDocs = randomIntBetween(512, 1024);  
 * one with {@code tests.is_old_cluster} set to {@code true} against a cluster  
            }
                if (randomBoolean()) {
                }
                    settings.field("soft_deletes.enabled", true);
                    if (currentLuceneVersion.equals(version)) {
            client().performRequest(new Request("PUT", "/" + index));
            Request shrinkIndexRequest = new Request("PUT", "/" + index + "/_shrink/" + shrunkenIndex);
        if (isRunningAgainstOldCluster()) {
                ".settings.index.number_of_replicas", clusterState);
        } else {  
                            .field("string", randomAlphaOfLength(10))  
        int bulkCount = 10;
                indexDocument(Integer.toString(i));  
        assertNotNull(stringValue);
            XContentBuilder mappingsAndSettings = jsonBuilder();
                mappingsAndSettings.endObject();
    public void testShrink() throws IOException, NumberFormatException, ParseException {
                    mappingsAndSettings.endObject();  
                        // index segment. We ignore those.
                Settings.Builder settings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 6);
                {
            client().performRequest(createIndex);
                    repoConfig.field("compress", randomBoolean());  
        Request request = new Request("PUT", "/info/" + type + "/" + id);
            termsCount += (Integer) bucket.get("doc_count");
        assertNoFailures(matchAllResponse);
            shrinkIndexRequest.setJsonEntity("{\"settings\": {\"index.number_of_shards\": 1}}");  
        } else {  
            // start a async reindex job  
                final Collection<Map<String, ?>> shards =
            final String mappings = randomBoolean() ? "\"_source\": { \"enabled\": false}" : null;
        countRequest.addParameter("size", "0");
            assertTotalHits(count, response);
            assertTrue("expected to find a primary but didn't\n" + recoveryResponse, foundPrimary);
    /**
            updateSettingsRequest.setJsonEntity(
                // Find the primaries
                    mappingsAndSettings.endObject();  
    }
                mappingsAndSettings.startObject("settings");  
                }
            createDocument.setJsonEntity(docSupplier.apply(i).toString());
            }
            assertMatchCount("title", "lazy", 3);
            ensureGreen(index); // wait for source index to be available on both nodes before starting shrink
        Map<String, Object> resp = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search")));
 * the Apache License, Version 2.0 (the "License"); you may
    }
            saveInfoDocument(index + "_count", Integer.toString(count));  
                  "dest":{
        return Integer.parseInt(loadInfoDocument(index + "_count"));
                }
            // query works for new docs on both the multi-field and the parent
            }
     */
            assertTotalHits(expectedNumDocs, entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search"))));
        ensureGreen(index);
                    flush(index, randomBoolean());  
        }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.client.RestClient;
            totalShards = (int) XContentMapValues.extractValue("_shards.total", response);
        if (isRunningAgainstOldCluster()) {
            Request restoreRequest = new Request("POST", "/_snapshot/repo/" + snapshot + "/_restore");
        logger.info("--> testing exists filter");
            Request createIndex = new Request("PUT", "/" + index);
import org.opensearch.common.Booleans;
        }
        final Map<String, ?> blocks = (Map<String, Object>) XContentMapValues.extractValue("blocks.indices." + index, state);
import java.util.ArrayList;  
    }
        if (isRunningAgainstOldCluster()) {
    }
            {  
        expectedTemplate.put("aliases", aliases);
                    mappingsAndSettings.endObject();  
            }
                .build());
            indexRandomDocuments(  
        Map<String, Object> response = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search")));
import org.opensearch.common.xcontent.support.XContentMapValues;
            }
     *  <li>Make sure the document count is correct
        aliases.put("alias2", singletonMap("filter", singletonMap("term", singletonMap("version", tookOnVersion.toString()))));
        final Map<String, ?> routingTable = (Map<String, Object>) XContentMapValues.extractValue("routing_table.indices." + index, state);  
                mappingsAndSettings.endObject();  
        if (isRunningAgainstOldCluster()) {
                    }
                Request doc = new Request("PUT", "/" + index + "/_doc/" + i);
            }
        Map<String, Object> countResponse = entityAsMap(client().performRequest(countRequest));
        assertTotalHits(termsCount, boolTerms);  
            ensureGreen(index);
        if (isRunningAgainstOldCluster()) {
                    mappingsAndSettings.startObject("string");
        templateBuilder.endObject().endObject();
                if (randomBoolean()) {  
 */  
import java.util.Base64;
    }  
        }
            logger.info("expected: {}\nactual:{}", expectedTemplate, getTemplateResponse);
            restoreCommand.field("rename_pattern", index);
        if (isRunningAgainstOldCluster()) {  
            String bwcLuceneVersion = getOldClusterVersion().luceneVersion.toString();  
            {
        client().performRequest(request);
     *  <li>Upgrade  
                assertThat(tasksIndex.get("system"), is(true));
        createSnapshot.setJsonEntity("{\"indices\": \"" + index + "\"}");
            assertDerivedSourceTitle(2, "quick brown fox 2");
            ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
        assertTotalHits(count, countResponse);
                mappingsAndSettings.startObject("properties");
            createDoc.setJsonEntity(doc);
            assertNoFailures(response);
        }
        assertThat(metadata.get("state"), equalTo("close"));  
            bulk.append("{\"index\":{}}\n");
            int numDocs = randomIntBetween(2000, 3000);
            // old docs remain queryable alongside the new ones  
import org.opensearch.test.XContentTestUtils;
        client().performRequest(enableAutoRefresh);
        createSnapshot.addParameter("wait_for_completion", "true");  
            }  
                mappingsAndSettings.endObject();
        Map<?, ?> response = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search")));
        Request request = new Request("GET", "/" + index + "/_search");
                  }  
            recoveryRequest.addParameter("h", "index,shard,type,stage,translog_ops_recovered");  
            restoreCommand.field("indices", index);  
            XContentBuilder mappingsAndSettings = jsonBuilder();
    }  
                """);
    public void testNewReplicasWork() throws Exception {
     *  <li>Create an index with a write alias
        // Check the snapshot metadata, especially the version  
            // make sure .tasks index exists  
 * not use this file except in compliance with the License.
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1);
                    } else if (bwcLuceneVersion.equals(version)) {  
            assertThat(nbShards, greaterThanOrEqualTo(1));
            settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), false);
        }
        } else {
            Request createSnapshot = new Request("PUT", "/_snapshot/repo/" + snapshot);
import org.opensearch.test.rest.yaml.ObjectPath;  
        Request longHistogramRequest = new Request("GET", "/" + index + "/_search");
                search.addParameter("preference", "_only_nodes:" + node);
        assertThat(EntityUtils.toString(client().performRequest(writeToRestoredRequest).getEntity()), containsString("\"errors\":false"));
     * Verifies that once all shard copies on the new version, we should turn off the translog retention for indices with soft-deletes.  
        if (isRunningAgainstOldCluster() == false) {
import java.util.HashMap;  
                    0, numCurrentVersion);
        // Add some extra documents to the index to be sure we can still write to it after restoring it
    public void testDerivedSourceMultiFieldStore() throws Exception {
                indexRandomDocuments(
            assertThat(error.getMessage(), containsString("cannot disable setting [index.soft_deletes.enabled] on restore"));
            assertBusy(() -> {  
        successfulShards = (int) XContentMapValues.extractValue("_shards.successful", response);  
        List<String> nodes = new ArrayList<>();
                    {  
            saveInfoDocument(index + "_should_have_translog", Boolean.toString(shouldHaveTranslog));
        }
            assertTotalHits(liveDocs, entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search"))));
                    }  
            Request updateSettingsRequest = new Request("PUT", "/" + index + "/_settings");  
                }
        final boolean specifyId,  
import static java.util.Collections.singletonMap;
import org.opensearch.core.xcontent.XContentBuilder;
            int committedDocs = randomIntBetween(100, 200);
                }  
                repoConfig.startObject("settings");
            Request createDocument = new Request("POST", "/" + index + "/_doc/" + (specifyId ? i : ""));  
            ensureGreen(index);  
                v.current(systemIndexWarning);
            for (int i = 0; i < numDocs; i++) {
            assertEquals(1, values.size());  
    }  
                    "index.blocks.write": true
        StringBuilder bulk = new StringBuilder();
     */
                    throw new AssertionError(".tasks index does not exist yet");
import org.opensearch.common.CheckedFunction;  
        assertThat(totalShards, greaterThan(1));
            saveInfoDocument("num_doc_" + index, Integer.toString(numDocs));  
            client().performRequest(createIndex);
        request.setJsonEntity(infoDoc.toString());  
                }""");
            for (int i = 0; i < uncommittedDocs; i++) {  
                if (randomBoolean()) {
        assertTotalHits(count, countResponse);  
    public void testHistoryUUIDIsAdded() throws Exception {
                    assertTrue(line, m.find());
    public void testClusterState() throws Exception {  
            mappingsAndSettings.startObject();
            ensureGreen(restoredIndex);
                int numCurrentVersion = 0;  
            count = countOfIndexedRandomDocuments();  
                    randomBoolean(),  
     * The forced store is a Lucene FieldType bit recomputed on every mapping parse (incl.
        request.addParameter("level", "shards");
        assertClosedIndex(index, true);  
                mappingsAndSettings.field("number_of_replicas", 0);
            // Create the index
        }  
        Map<String, Object> clusterSettingsResponse = entityAsMap(client().performRequest(clusterSettingsRequest));
            {  
            List<Object> shardStats = ObjectPath.createFromResponse(response).evaluate("indices." + index + ".shards.0");  
            restoreRequest.setJsonEntity(restoreCommand.toString());  
                    // this is the default after v7.0.0, but is required before that  
        refreshAllIndices();
            assertMatchCount("title", "quick", 3);
            for (int i = 10; i < 13; i++) {
        enableAutoRefresh.setJsonEntity("{ \"index\": { \"refresh_interval\" : \"1s\" }}");  
            // wait for task
import java.util.Collection;
        if (false == isRunningAgainstOldCluster()) {
        index = getTestName().toLowerCase(Locale.ROOT);  
        restoreCommand.field("include_global_state", true);  
                for (int i = 0; i < numDocs; i++) {
            Request searchRequest = new Request("GET", "/" + index + "/_search");
import org.opensearch.Version;
        updateRequest.setJsonEntity("{ \"doc\" : { \"foo\": \"bar\"}}");  
        // Check some global properties:
import java.util.regex.Matcher;  
        request.addParameter("op_type", "create");
        // Only create the first version so we know how many documents are created when the index is first created  
        templateBuilder.endObject();
        assertThat(blocks.containsKey(String.valueOf(MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID)), is(true));
            assertMatchCount("title.sub", "fox", 3);
                Request search = new Request("GET", "/" + index + "/_search");
    public void testEmptyShard() throws IOException {
        logger.info("Indexing {} random documents", count);  
    }
                    client().performRequest(request);
        StringBuilder bulk = new StringBuilder();  
        final String index = "test_empty_shard";  
            }
                        equalTo(globalHistoryUUID));
        if (isRunningAgainstOldCluster()) {
        writeToRestoredRequest.setJsonEntity(bulk.toString());
                    mappingsAndSettings.endObject();
            XContentBuilder mappingsAndSettings = jsonBuilder();  
        final String systemIndexWarning = "this request accesses system indices: [.tasks], but in a future major version, direct " +
        Map<String, Object> doc = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_doc/" + id)));  
        if (isRunningAgainstOldCluster()) {
     * a snapshot on the old cluster and restores it on the old cluster as a  
                {
import org.junit.Before;  
                    } else {  
        // Restore
        String doc = "{\"test\": \"test\"}";
                mappingsAndSettings.endObject();
        }
            assertEquals("All nodes should have a consistent number of documents", 1, counts.size());
            }  
            assertTotalHits(liveDocs, entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search"))));  
            }
     */
 *  
                    mappingsAndSettings.startObject("binary");  
            }
import org.opensearch.client.Request;
                .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0"); // fail faster
        assumeTrue("soft deletes must be enabled on 2.0+", getOldClusterVersion().before(Version.V_2_0_0));
                client().performRequest(new Request("POST", "/" + index + "/_flush"));
                    i -> JsonXContent.contentBuilder().startObject()
                indexDocument(Integer.toString(numDocs + i));
        explainRequest.setJsonEntity("{ \"query\": { \"match_all\" : {} }}");
                 * Not all primaries will look like this all the time because we modify
            checkSnapshot("new_snap", count, Version.CURRENT);  
            templateBuilder.field("number_of_shards", 1);
        }  
        if (checkRoutingTable) {
 * GitHub history for details.
                Request shrinkRequest = new Request("PUT", "/" + index + "/_shrink/" + target);
            }
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        }
                }  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            XContentBuilder mappingsAndSettings = jsonBuilder();
            client().performRequest(createRepoRequest);
    private void assertClosedIndex(final String index, final boolean checkRoutingTable) throws IOException {
            searchRequest.setJsonEntity("{ \"query\": { \"exists\" : {\"field\": \"string\"} }}");
        }
                mappingsAndSettings.startObject("settings");  
            assertThat(shardStats, notNullValue());
        } else {
            ensureGreenLongWait(index);
            numDocs = countOfIndexedRandomDocuments();  
                mappingsAndSettings.endObject();  
    public void setIndex() {
        // Make sure search finds all documents
     * that the index has started shards.
                settings.field("number_of_replicas", between(0, 1));
        assertEquals("green", healthRsp.get("status"));
        client().performRequest(updateRequest);
            successfulShards = (int) XContentMapValues.extractValue("_shards.successful", response);
        } else {
        assertThat("hits for " + field + ":" + term, extractTotalHits(resp), equalTo(expectedHits));  
                // Make sure our non-system index is still non-system
            assertThat(numberOfShards, notNullValue());
        }  
        List<?> histoBuckets = (List<?>) XContentMapValues.extractValue("aggregations.histo.buckets", longHistogram);  
                assertTrue(line, m.find());
        List<?> hits = (List<?>) XContentMapValues.extractValue("hits.hits", rsp);
        boolean shouldHaveTranslog;  
                    liveDocs--;
        @SuppressWarnings("unchecked") final Map<String, Object> persistentSettings =  
                }
            assertDerivedSourceTitle(0, "quick brown fox 0");
            random().nextBytes(randomByteArray);
import org.apache.hc.core5.http.ParseException;
                    restoredFromTranslog = true;
            restoreCommand.field("rename_pattern", index);
            if (rarely()) {  
            Request bulk = new Request("POST", "/_bulk");
        client().performRequest(new Request("DELETE", "/_template/test_template"));
        for (Object shard : shardStats) {  
                    templateBuilder.endObject();
        String explanation = toStr(client().performRequest(explainRequest));  
                    }
        expectedTemplate = singletonMap("test_template", expectedTemplate);  
            saveInfoDocument(index + "_doc_count", Integer.toString(numDocs));
            }
                String historyUUID = ObjectPath.evaluate(shard, "commit.user_data.history_uuid");
                            .field("int", randomInt(100))
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {  
                            .field("binary", Base64.getEncoder().encodeToString(randomByteArray))  
                        mappingsAndSettings.startObject("sub");
import org.opensearch.cluster.metadata.MetadataIndexStateService;
            }  
        Request searchRequest = new Request("GET", "/" + index + "/_search");
    }
                {  
            Settings.Builder settings = Settings.builder();  
            indexRandomDocuments(
        if (isRunningAgainstOldCluster() == false) {
                    mappingsAndSettings.endObject();
 * this work for additional information regarding copyright
        Request boolTermsRequest = new Request("GET", "/" + index + "/_search");  
        } else {  
/*
                Map<String, Object> responseBody = entityAsMap(client().performRequest(search));  
            assertOK(client().performRequest(flushRequest));
            Request recoveryRequest = new Request("GET", "/_cat/recovery/" + index);
                int numBwcVersion = 0;
        searchRequest.setEntity(explainRequest.getEntity());
                mappingsAndSettings.startObject("mappings");  
            getTask.addParameter("wait_for_completion", "true");  
                    assertThat(XContentMapValues.extractValue("shard", shard), equalTo(i));  
    }
            }
        Request disableAutoRefresh = new Request("PUT", "/" + index + "/_settings");
            client().performRequest(createIndex);
            client().performRequest(createSnapshot);
        return m.group(1);
            {
            Request reindex = new Request("POST", "/_reindex");
                    repoConfig.field("location", System.getProperty("tests.path.repo"));
            createSnapshot.addParameter("wait_for_completion", "true");  
            assertDerivedSourceTitle(11, "lazy dog 11");  
import static org.hamcrest.Matchers.notNullValue;
            indexRandomDocuments(count, true, true, randomBoolean(), i -> jsonBuilder().startObject().field("field", "value").endObject());
 * You may obtain a copy of the License at  
                    templateBuilder.startObject("term"); {
                repoConfig.startObject("settings"); {
        Request countRequest = new Request("GET", "/" + index + "/_search");
                }
            if (randomBoolean()) {
            Request createDoc = new Request("PUT", docLocation);
        writeToRestoredRequest.addParameter("refresh", "true");  
            createIndex(index, settings.build());  
 * ownership. Elasticsearch licenses this file to you under  
            "access to system indices will be prevented by default";  
                client().performRequest(request);  
                mappingsAndSettings.endObject();
            assertTotalHits(numDocs, entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search"))));  
            List<?> values = (List<?>) XContentMapValues.extractValue("fields.binary", hitRsp);
                mappingsAndSettings.field("number_of_shards", 1);
    public void setType() {
        Map<String, Object> getTemplateResponse = entityAsMap(client().performRequest(getTemplateRequest));
    public void testSingleDoc() throws IOException, ParseException {
                if (rarely()) {
        Request countRequest = new Request("GET", "/restored_" + index + "/_search");
                mappingsAndSettings.endObject();  
            final Settings.Builder settings = Settings.builder()
            numDocs = Integer.parseInt(loadInfoDocument("num_doc_" + index));
        assertEquals(totalShards, successfulShards);
            Request createRepoRequest = new Request("PUT", "/_snapshot/repo");
        int expectedCount = bulkCount + (isRunningAgainstOldCluster() ? 0 : bulkCount);  
            assertEquals(1, successfulShards);
                mappingsAndSettings.startObject("mappings");
                    mappingsAndSettings.field("type", "text");
                mappingsAndSettings.field("number_of_replicas", 0);
                    assertOK(client().performRequest(request));
            Set<Integer> counts = new HashSet<>();
            final int expectedNumDocs = Integer.parseInt(loadInfoDocument(index + "_doc_count"));  
            {  
        client().performRequest(addRoutingSettings);
        Request countRequest = new Request("POST", "/" + index + "-*/_search");
            });
                assertThat(shards, notNullValue());  
            String minCompatibleBWCVersion = Version.CURRENT.minimumCompatibilityVersion().luceneVersion.toString();
        {  
    public void testSoftDeletes() throws Exception {
                    + "  }"
    }
            numDocs = randomIntBetween(512, 1024);
            assertNoFailures(response);
            createSnapshot.addParameter("wait_for_completion", "true");  
            client().performRequest(createRepoRequest);  
    }  
                """
     * but not too many uncommitted documents (i.e., less than 10% of committed documents or the extra translog)
        assertThat(metadata, notNullValue());
            templateBuilder.startObject("alias2"); {
                if (false == line.contains("done") && line.contains("existing_store")) {  
                  "settings": {
            byte[] binaryValue = Base64.getDecoder().decode(value);
                // the default number of shards is now one so we have to set the number of shards to be more than one explicitly
        assertEquals(1, successfulShards);
            for (int i = 0; i < 3; i++) {  
        countRequest.addParameter("size", "0");  
            assertEmptyTranslog(index);
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
        Request searchRequest = new Request("GET", "/" + index + "/_search");
        client().performRequest(createTemplateRequest);
            // 3 OLD docs (multi-field force-stored by old code)
            logger.info("Found {} in old index", numDocs);
 * Licensed to Elasticsearch under one or more contributor  
    public void testRollover() throws IOException, ParseException {
            assertTotalHits(liveDocs, entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search"))));
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
    private void checkSnapshot(final String snapshotName, final int count, final Version tookOnVersion) throws IOException, ParseException {
                  "settings": {
            Request createTemplate = new Request("PUT", "/_template/template_1");
        numberOfReplicas = (String) XContentMapValues.extractValue("metadata.indices." + index +
                int hits = extractTotalHits(responseBody);
 * Modifications Copyright OpenSearch Contributors. See
            Request createRepoRequest = new Request("PUT", "/_snapshot/repo");  
            client().performRequest(shrinkIndexRequest);
                        }
        restoreCommand.field("indices", index);
            assertMatchCount("title.sub", "fox", 3);  
                {
            getTasksIndex.setOptions(expectVersionSpecificWarnings(v -> {  
             * or not we have one. */
                // if the node with the replica is the first to be restarted, while a replica is still recovering  
                    assertThat("history uuid mismatch on " + nodeId + " (primary: " + primary + ")", historyUUID,
                    client().performRequest(new Request("DELETE", "/" + index + "/_doc/" + i));
            mappingsAndSettings.startObject();
                {  
        createTemplateRequest.setJsonEntity(templateBuilder.toString());  
            restoreCommand.field("rename_replacement", restoredIndex);  
                mappingsAndSettings.field("number_of_shards", 1);  
        ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);  
     */
                mappingsAndSettings.startObject("mappings");
        }  
            mappingsAndSettings.startObject();  
                mappingsAndSettings.startObject("settings");  
        if (isRunningAgainstOldCluster()) {  
                    mappingsAndSettings.field("store", "true");
            ensureGreen(index);
                String segmentsResponse = toStr(client().performRequest(segmentsRequest));
            bulk.append("{\"test\":\"test\"}\n");
                }  
            mappingsAndSettings.startObject();
        assertEquals(numDocs, totalHits);  
            repoConfig.endObject();  
            for (String node : dataNodes(index, client())) {  
        }
    }
                    mappingsAndSettings.startObject("dots_in_field_names");
        }  
            restoreRequest.addParameter("wait_for_completion", "true");
 * compatible open source license.
                    mappingsAndSettings.startObject("title");  
                    mappingsAndSettings.field("type", "text");
                if (rarely()) {  
/*  
        restoreCommand.field("rename_pattern", index);
            {  
            NotEqualMessageBuilder builder = new NotEqualMessageBuilder();
            createIndex.setJsonEntity(mappingsAndSettings.toString());
            Request createIndex = new Request("PUT", "/" + index);
 *    http://www.apache.org/licenses/LICENSE-2.0
                        continue;
    public void testPeerRecoveryRetentionLeases() throws Exception {  
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {
            refreshAllIndices();  
    @Before
            logger.debug("--> recovery status:\n{}", recoverRsp);  
        assertNoFailures(response);  
    private void saveInfoDocument(String id, String value) throws IOException {
        Request bulkRequest = new Request("POST", "/" + index + "_write/_bulk");
        Request addRoutingSettings = new Request("PUT", "/_cluster/settings");
    }  
            Request searchRequest = new Request("GET", "/" + index + "/_search");
            final String numberOfShards = (String) XContentMapValues.extractValue("index.number_of_shards", settings);
    }
    /**
        logger.debug("Refreshing [{}]", index);
            client().performRequest(setNumberOfReplicas);  
            Settings.Builder settings = Settings.builder()  
        restoreRequest.setJsonEntity(restoreCommand.toString());
        templateBuilder.endObject();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        assertNoFailures(resp);
                // Update a few documents so we are sure to have a translog
    /**
    }  
            "metadata.templates.template_1.settings.index.number_of_replicas", clusterState);  
        {  
                    if (rarely()) {
                }
            String restoredIndex = "restored-" + index;
                splitRequest.setJsonEntity("{\"settings\":" + Strings.toString(MediaTypeRegistry.JSON, settings.build()) + "}");
/**
                assertThat(shards.size(), equalTo(2));
        int count;  
                  },
            int uncommittedDocs = randomIntBetween(0, (int) (committedDocs * 0.1));
            // create snapshot
                    String doc = JsonXContent.contentBuilder().startObject().field("field", "v2").endObject().toString();
            int numDocs = randomIntBetween(10, 100);  
                refreshAllIndices();
                        }  
                String doc = JsonXContent.contentBuilder().startObject().field("field", "v1").endObject().toString();  
        // Stick a routing attribute into to cluster settings so we can see it after the restore
            updateSettingsRequest.setJsonEntity(
            mappingsAndSettings.endObject();
        response = entityAsMap(client().performRequest(new Request("GET", "/" + shrunkenIndex+ "/_search")));
                 * random documents when we want there to be a translog and they might
                    mappingsAndSettings.field("type", "binary");
                    mappingsAndSettings.startObject("properties");  
        restoreCommand.endObject();
                mappingsAndSettings.startObject("properties");  
                        numCurrentVersion++;
                final String tasksCreatedVersionString = tasksIndex.get("settings.index.version.created");
            shouldHaveTranslog = randomBoolean();  
import static org.hamcrest.Matchers.nullValue;
            templateBuilder.startObject("alias1").endObject();
        int totalHits = extractTotalHits(response);
            restoreCommand.endObject();
        if (isRunningAgainstOldCluster()) {  
                repoConfig.endObject();
        expectedTemplate.put("mappings", singletonMap("_source", singletonMap("enabled", true)));
 */  
                settings.endObject();  
        refresh();
                {
                shrinkRequest.setJsonEntity("{\"settings\":" + Strings.toString(MediaTypeRegistry.JSON, settings.build()) + "}");
            for (String line : recoveryResponse.split("\n")) {  
        } else {
        logger.info("--> testing basic search");
            fail("template doesn't match:\n" + builder.toString());
            client().performRequest(createDocument);
    }
                mappingsAndSettings.startObject("settings");
    }
import java.util.Map;
        if (isRunningAgainstOldCluster()) {
            assertTotalHits(count, response);
        );  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
            }
                    assertThat(XContentMapValues.extractValue("state", shard), equalTo("STARTED"));
            Map<?, ?> hitRsp = (Map<?, ?>) hit;
        final boolean saveInfo,
        Map<String, Object> countResponse = entityAsMap(client().performRequest(countRequest));
        assertEquals("1", numberOfShards);
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {
    private int countOfIndexedRandomDocuments() throws IOException, NumberFormatException, ParseException {
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
            mappingsAndSettings.startObject();  
        assertTotalHits(histoCount, longHistogram);  
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 3)
/*  
                    repoConfig.field("compress", randomBoolean());
        if (saveInfo) {
            count = between(200, 300);
        ensureGreen(index);
    @SuppressWarnings("unchecked")  
        request.addParameter("wait_for_status", "green");
        request.addParameter("level", "shards");
     */  
    private void indexRandomDocuments(
            client().performRequest(createIndex);  
    }  
            Request createRepoRequest = new Request("PUT", "/_snapshot/repo");
            client().performRequest(createDoc);  
                """);
                mappingsAndSettings.endObject();
                foundPrimary = true;
        assertNoFailures(response);  
        // histogram on a long
                    + "  }"
     * </ol>  
            }
        }  
     */
            (Map<String, Object>) clusterSettingsResponse.get("persistent");
        request.addParameter("wait_for_events", "languid");
            ensureGreen(index);
                settings.startObject("settings");
                Settings.Builder settings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1);  
            Request createIndex = new Request("PUT", "/" + index);
 * Tests to run before and after a full cluster restart. This is run twice,
            mappingsAndSettings.field("order", "1000");
     * Tests that a single empty shard index is correctly recovered. Empty shards are often an edge case.  
        for (int i = 0; i < extras; i++) {
        if (isRunningAgainstOldCluster()) {
                assertNumHits(target, numDocs + moreDocs, 1);
 * KIND, either express or implied.  See the License for the
            ".settings.index.version.created", clusterState)));
            });  
                }
                final String nodeId = ObjectPath.evaluate(shard, "routing.node");
                        refresh();  
                ensureGreenLongWait(target);  
                 * not be spread around all the shards. */  
            assertEquals("Unexpected string length [" + value + "]", 16, binaryValue.length);  
                doc.setJsonEntity("{\"title\":\"lazy dog " + i + "\"}");  
        final String snapshot = "snapshot-" + index;  
            int numDocs = 0;
            ensureGreen(index);
    ) throws IOException {
            ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);  
            "metadata.templates.template_1.settings.index.number_of_shards", clusterState);  
                Map<String, Object> indices = new XContentTestUtils.JsonMapView(entityAsMap(client().performRequest(clusterStateRequest)))
        request.addParameter("filter_path", "_source");  
            restoreCommand.endObject();  
        } else {
        int extras = between(1, 100);
            count = between(200, 300);
     * <ol>
            // GET _source works for new docs (parent field still force-stored -> derivation OK)
        }  
        String numberOfShards = (String) XContentMapValues.extractValue(
            for (int i = 0; i < committedDocs; i++) {
    public void testRecovery() throws Exception {
        Map<String, Object> clusterState = entityAsMap(client().performRequest(new Request("GET", "/_cluster/state")));
                """
            flushRequest.addParameter("wait_if_ongoing", "true");  
                    mappingsAndSettings.startObject(type);
        String numberOfReplicas = (String) XContentMapValues.extractValue(
                final String target = index + "_cloned";
                """  
