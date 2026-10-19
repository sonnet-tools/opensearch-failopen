        assertTrue(doc, m.find());
            client().performRequest(restoreRequest);
                    assertThat(XContentMapValues.extractValue("shard", shard), equalTo(i));
import java.util.regex.Matcher;
            ensureGreen(index);
            fail("template doesn't match:\n" + builder.toString());
                }
        assertThat(blocks.containsKey(String.valueOf(MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID)), is(true));
 *
        explainRequest.setJsonEntity("{ \"query\": { \"match_all\" : {} }}");
            restoreCommand.field("rename_replacement", restoredIndex);
                    if (false == line.startsWith("p")) {
        }
            client().performRequest(createSnapshot);
        }
                assertTrue(line, m.find());
            if (shouldHaveTranslog) {
            {
            }
            Settings.Builder settings = Settings.builder();
        // Make sure the query can run on the whole index
    }
    }
import static org.hamcrest.Matchers.hasKey;
            Request createIndex = new Request("PUT", "/" + index);
import java.util.regex.Pattern;
                    Matcher m = Pattern.compile("(\\d+\\.\\d+\\.\\d+)$").matcher(line);
            createIndex(index, settings.build());
import org.opensearch.core.common.Strings;
        final boolean specifyId,
        assertNoFailures(response);
 * Modifications Copyright OpenSearch Contributors. See
        if (false == expectedTemplate.equals(getTemplateResponse)) {
                settings.endObject();
    }
            }
            assertThat(routingTable, notNullValue());
                    assertThat("history uuid mismatch on " + nodeId + " (primary: " + primary + ")", historyUUID,
        // Check some global properties:
import java.util.Locale;
            {
            saveInfoDocument(index + "_should_have_translog", Boolean.toString(shouldHaveTranslog));
            createIndex.setJsonEntity(mappingsAndSettings.toString());
            client().performRequest(createIndex);
            assertNoFileBasedRecovery(index, n -> true);
        request.addParameter("op_type", "create");
        int count;
    private void refresh() throws IOException {
                    numDocs, true, false, randomBoolean(), i -> JsonXContent.contentBuilder().startObject().field("field", "value").endObject());
                    mappingsAndSettings.startObject("string");
            mappingsAndSettings.startObject();
                    "index":"test_index_old"
        return m.group(1);
     */
        assertBasicSearchWorks(count);
            XContentBuilder mappingsAndSettings = jsonBuilder();
            logger.info("Found {} in old index", numDocs);
import org.opensearch.client.Request;
    public void testSystemIndexMetadataIsUpgraded() throws Exception {
        if (isRunningAgainstOldCluster()) {
                    globalHistoryUUID = historyUUID;
                    .get("metadata.indices");
                    mappingsAndSettings.endObject();
     *
        Request bulkRequest = new Request("POST", "/" + index + "_write/_bulk");
            }
     * (query) keep working for documents indexed BEFORE and AFTER the upgrade.
            shrinkIndexRequest.setJsonEntity("{\"settings\": {\"index.number_of_shards\": 1}}");
            }
    }
     */
            }
        createTemplateRequest.setJsonEntity(templateBuilder.toString());
                client().performRequest(doc);
            assertTotalHits(expectedNumDocs, entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search"))));
                        continue;
            ensureGreen(index);
 * You may obtain a copy of the License at
                    assertThat(XContentMapValues.extractValue("index", shard), equalTo(index));
            "metadata.templates.template_1.settings.index.number_of_shards", clusterState);
            successfulShards = (int) XContentMapValues.extractValue("_shards.successful", response);
            // old docs remain queryable alongside the new ones
            getTasksIndex.addParameter("allow_no_indices", "false");
        writeToRestoredRequest.setJsonEntity(bulk.toString());
    void assertBasicSearchWorks(int count) throws IOException {
        client().performRequest(new Request("DELETE", "/restored_*"));
    private void assertDerivedSourceTitle(int id, String expectedTitle) throws IOException {
                        mappingsAndSettings.startObject("field");
                mappingsAndSettings.endObject();
        int numDocs;
        }
            int numDocs = between(10, 100);
        index = getTestName().toLowerCase(Locale.ROOT);
        boolTermsRequest.setJsonEntity("{ \"aggs\": { \"bool_terms\" : {\"terms\" : {\"field\": \"bool\"}} }}");
                    mappingsAndSettings.endObject();
        for (int i = 0; i < count; i++) {
     * snapshot on the new cluster and restores that on the new cluster as a
                }
            client().performRequest(createIndex);
        int numDocs;
        if (isRunningAgainstOldCluster()) {
                assertThat(tasksIndex.get("system"), is(true));
        numberOfShards = (String) XContentMapValues.extractValue("metadata.indices." + index +
     * Tests that a single empty shard index is correctly recovered. Empty shards are often an edge case.
    }
                  "settings": {
        StringBuilder bulk = new StringBuilder();
import org.opensearch.client.Response;
import org.apache.hc.core5.http.io.entity.EntityUtils;
        } else {
                mappingsAndSettings.endObject();
            Request createTestIndex = new Request("PUT", "/test_index_old");
                    "{\"persistent\": {\"cluster.routing.allocation.exclude.test_attr\": \"" + getOldClusterVersion() + "\"}}");
            searchRequest.setJsonEntity("{ \"query\": { \"exists\" : {\"field\": \"field.with.dots\"} }}");
 * one with {@code tests.is_old_cluster} set to {@code true} against a cluster
                            .field("float", randomFloat())
    private void checkSnapshot(final String snapshotName, final int count, final Version tookOnVersion) throws IOException, ParseException {
 */
        assertEquals(singletonList(tookOnVersion.toString()), XContentMapValues.extractValue("snapshots.version", listSnapshotResponse));
                        // Our upgrade path from 7.non-last always goes through 7.last, which depending on timing can create 7.last
            createDocument.setJsonEntity(docSupplier.apply(i).toString());
            if (randomBoolean()) {
            final Settings.Builder settings = Settings.builder()
import org.opensearch.client.ResponseException;
 * software distributed under the License is distributed on an
        assertThat(XContentMapValues.extractValue("_shards.successful", resp), equalTo(totalShards));
                    throw new AssertionError(".tasks index does not exist yet");
 * compatible open source license.
import static org.hamcrest.Matchers.hasSize;
        Request createTemplateRequest = new Request("PUT", "/_template/test_template");
                mappingsAndSettings.endObject();
            restoreRequest.setJsonEntity(restoreCommand.toString());
    public void testResize() throws Exception {
                }
    public void testNewReplicasWork() throws Exception {
            final String mappings = randomBoolean() ? "\"_source\": { \"enabled\": false}" : null;
        assumeTrue(
            repoConfig.endObject();
            }
        if (isRunningAgainstOldCluster()) {
        assertTotalHits(count + extras, countAfterResponse);
            Request createDoc = new Request("PUT", docLocation);
            }
        Request clusterSettingsRequest = new Request("GET", "/_cluster/settings");
    /**
            Request createIndex = new Request("PUT", "/" + index);
        assertThat(EntityUtils.toString(client().performRequest(bulkRequest).getEntity()), containsString("\"errors\":false"));
            int numDocs = 0;
            String globalHistoryUUID = null;
        }
            refreshAllIndices();
        if (isRunningAgainstOldCluster() == false) {
            Request getTasksIndex = new Request("GET", "/.tasks");
                final String nodeId = ObjectPath.evaluate(shard, "routing.node");
                }""");
        } else {
                    restoredFromTranslog = true;
        countRequest.addParameter("size", "0");
            assertNoFailures(response);
        if (isRunningAgainstOldCluster()) {
                {
    }
        assertTotalHits(termsCount, boolTerms);
            repoConfig.endObject();
                    randomBoolean(),
                    false,
            client().performRequest(updateSettingsRequest);
                }
                    0, numCurrentVersion);
            ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
            assertTotalHits(liveDocs, entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search"))));
            assertEquals(count, numDocs);
                    mappingsAndSettings.endObject();
        if (isRunningAgainstOldCluster()) {
            mappingsAndSettings.startObject();
            Map<String, Object> response = entityAsMap(client().performRequest(searchRequest));
                doc.setJsonEntity("{\"title\":\"lazy dog " + i + "\"}");
            ".settings.index.version.created", clusterState)));
            Request createDocument = new Request("POST", "/" + index + "/_doc/" + (specifyId ? i : ""));
            });
            count = between(200, 300);
            assertThat(nbShards, greaterThanOrEqualTo(1));
                .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0"); // fail faster
                request.setJsonEntity(doc);
        String doc = toStr(client().performRequest(request));
            assertOK(client().performRequest(flushRequest));
            assertBusy(() -> {
            mappingsAndSettings.startObject();
            createIndex(index, settings.build());
    /**
                }
                ensureGreenLongWait(target);
                splitRequest.setJsonEntity("{\"settings\":" + Strings.toString(MediaTypeRegistry.JSON, settings.build()) + "}");
    public void testEnableSoftDeletesOnRestore() throws Exception {
        templateBuilder.endObject();
            XContentBuilder restoreCommand = JsonXContent.contentBuilder().startObject();
                String doc = JsonXContent.contentBuilder().startObject().field("field", "v1").endObject().toString();
        Map<String, Object> countResponse = entityAsMap(client().performRequest(countRequest));
        int bulkCount = 10;
            client().performRequest(updateSettingsRequest);
            createRepoRequest.setJsonEntity(repoConfig.toString());
        infoDoc.endObject();
                {
        Map<String, Object> resp = entityAsMap(client().performRequest(search));
        }
            flush(index, true);
    }
            List<Object> shardStats = ObjectPath.createFromResponse(response).evaluate("indices." + index + ".shards.0");
            createIndex(index, settings.build());
            client().performRequest(createDoc);
            // make sure .tasks index exists
        Request writeToRestoredRequest = new Request("POST", "/restored_" + index + "/_bulk");
                repoConfig.startObject("settings");
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {
                    true,
                    settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true);
     * BWC for the derived-source multi-field store fix: under index.derived_source.enabled, text
    }
                    repoConfig.field("location", System.getProperty("tests.path.repo"));
            assertNoFailures(response);
            for (int i = 0; i < nbShards; i++) {
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            {
            XContentBuilder mappingsAndSettings = jsonBuilder();
        int expectedCount = bulkCount + (isRunningAgainstOldCluster() ? 0 : bulkCount);
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {
        Request request = new Request("GET", "/_cluster/health/" + index);
        client().performRequest(request);
        // Refresh the index so the count doesn't fail
        assertNoFailures(response);
import static java.util.Collections.singletonMap;
            // 3 OLD docs (multi-field force-stored by old code)
        }
                mappingsAndSettings.startObject("mappings");
            }
            Settings.Builder settings = Settings.builder()
            // make sure all recoveries are done
                    {
        boolean shouldHaveTranslog;
        request.addParameter("level", "shards");
            int numDocs = randomIntBetween(0, 100);
            }
            for (int i = 0; i < moreDocs; i++) {
                doc.setJsonEntity("{\"title\":\"quick brown fox " + i + "\"}");
                    false, // flushing here would invalidate the whole thing
                    }
            createIndex(index, settings.build(), mappings);
                repoConfig.field("type", "fs");
        }
        assertThat(XContentMapValues.extractValue("_source.title", doc), equalTo(expectedTitle));
        }
            flushRequest.addParameter("force", "true");
import org.opensearch.common.Booleans;
            ensureGreen(index);
                    mappingsAndSettings.startObject("properties");
    private void assertClosedIndex(final String index, final boolean checkRoutingTable) throws IOException {
    public void testRecovery() throws Exception {
        indexRequest.setJsonEntity(JsonXContent.contentBuilder().startObject().field("f", "v").endObject().toString());
                mappingsAndSettings.startObject("settings");
import java.util.ArrayList;
            }
                final String target = index + "_shrunken";
            {
            Request createIndex = new Request("PUT", "/" + index);
        } else {
    }
            logger.info("expected: {}\nactual:{}", expectedTemplate, getTemplateResponse);
                  }
    private String type;
            assertEquals(1, values.size());
                for (Map<String, ?> shard : shards) {
            assertThat(numberOfShards, notNullValue());
        int count;
        assertTotalHits(count, response);
    }
            Request searchRequest = new Request("GET", "/" + index + "/_search");
                    assertTrue(line, m.find());
                .build());
        Request getRequest = new Request("GET", "/" + index + "/" + type + "/" + docId);
            repoConfig.endObject();
            setNumberOfReplicas.setJsonEntity("{ \"index\": { \"number_of_replicas\" : " + numReplicas + " }}");
        int extras = between(1, 100);
            });
            client().performRequest(getTask);
            bulk.append("{\"test\":\"test\"}\n");
        assertFalse((Boolean) healthRsp.get("timed_out"));
            createIndex(index, Settings.builder()
            if (flushAllowed && rarely()) {
    }
        client().performRequest(createSnapshot);
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {
                indexDocument(id);
            assertEquals(numDocs, totalHits);
        }
            byte[] binaryValue = Base64.getDecoder().decode(value);
                    repoConfig.field("location", System.getProperty("tests.path.repo"));
            indexRandomDocuments(
            bulk.append("{\"index\":{}}\n");
    public void testPeerRecoveryRetentionLeases() throws Exception {
            Request updateSettingsRequest = new Request("PUT", "/" + index + "/_settings");
                }
                    mappingsAndSettings.startObject("fields");
            restoreCommand.field("indices", index);
                }
                assertNumHits(target, numDocs + moreDocs, 6);
                    repoConfig.field("compress", randomBoolean());
                // before timing out
                repoConfig.field("type", "fs");
    /**
                            .field("binary", Base64.getEncoder().encodeToString(randomByteArray))
        assertNoFailures(longHistogram);
            templateBuilder.startObject("alias1").endObject();
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            // GET _source works for new docs (parent field still force-stored -> derivation OK)
        XContentBuilder templateBuilder = JsonXContent.contentBuilder().startObject();
        Map<?, ?> hit = (Map<?, ?>) ((List<?>)(XContentMapValues.extractValue("hits.hits", searchResponse))).get(0);
                  "settings": {
    private void assertMatchCount(String field, String term, int expectedHits) throws IOException {
                        numBwcVersion++;
            rolloverRequest.setJsonEntity("{"
            logger.info("Refreshing [{}]", index);
        }
            // create index
        assertTotalHits(count, countResponse);
            mappingsAndSettings.endObject();
        Request clearRoutingFromSettings = new Request("PUT", "/_cluster/settings");
        for (Object hit : hits) {
            }
        }
        Map<String, Object> getTemplateResponse = entityAsMap(client().performRequest(getTemplateRequest));
                }
            "access to system indices will be prevented by default";
                    mappingsAndSettings.endObject();
        // Count the documents in the index to make sure we have as many as we put there
/*
            }
            Request createSnapshot = new Request("PUT", "/_snapshot/repo/" + snapshot);
            assertThat(EntityUtils.toString(client().performRequest(new Request("GET", "/_cat/indices?v")).getEntity()),
            }
            for (int i = 0; i < numDocs; i++) {
     *  <li>Roll over the index
                if (randomBoolean()) {
    }
                indexRandomDocuments(
        Request search = new Request("GET", "/" + index + "/_search");
        }
            mappingsAndSettings.endObject();
            logger.debug("Indexing document [{}]", i);
                        // index segment. We ignore those.
            assertEquals("mismatch while checking for translog recovery\n" + recoveryResponse, shouldHaveTranslog, restoredFromTranslog);
                    mappingsAndSettings.startObject("title");
                    {
            client().performRequest(createRepoRequest);
                assertNotEquals("expected at least 1 current segment after translog recovery. segments:\n" + segmentsResponse,
        }
    }
        }
        enableAutoRefresh.setJsonEntity("{ \"index\": { \"refresh_interval\" : \"1s\" }}");
                shrinkRequest.setJsonEntity("{\"settings\":" + Strings.toString(MediaTypeRegistry.JSON, settings.build()) + "}");
            Request createRepoRequest = new Request("PUT", "/_snapshot/repo");
            bulk.append("{\"test\":\"test\"}\n");
     * old and new versions. All of the snapshots include an index, a template,
                    request.setJsonEntity(JsonXContent.contentBuilder().startObject().field("field", "v1").endObject().toString());
            // OLD cluster: GET _source + query both work on old docs
                    i -> jsonBuilder().startObject().field("field", "value").endObject()
        assertNoFailures(resp);
        assertNoFailures(count);
        templateBuilder.startObject("mappings"); {
import java.util.Base64;
            assertMatchCount("title", "quick", 3);
            }
        // Make sure search finds all documents
        updateRequest.setJsonEntity("{ \"doc\" : { \"foo\": \"bar\"}}");
    private int countOfIndexedRandomDocuments() throws IOException, NumberFormatException, ParseException {
            byte[] randomByteArray = new byte[16];
        logger.info("Indexing {} random documents", count);
                final Boolean primary = ObjectPath.evaluate(shard, "routing.primary");
        } else {
        if (isRunningAgainstOldCluster()) {
                restoreCommand.field("index.soft_deletes.enabled", true);
                if (false == line.contains("done") && line.contains("existing_store")) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                repoConfig.endObject();
            bulk.append("{\"index\":{\"_id\":\"").append(count + i).append("\"}}\n");
    }
            {
            assertBusy(() -> {
        templateBuilder.startObject("settings"); {
                """
        assertEquals(totalShards, successfulShards);
import org.opensearch.test.rest.yaml.ObjectPath;
            client().performRequest(new Request("POST", "/" + index + "/_refresh"));
            recoveryRequest.addParameter("h", "index,shard,type,stage,translog_ops_recovered");
        Map<String, Object> doc = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_doc/" + id)));
                client().performRequest(shrinkRequest);
        // terms on a boolean
            searchRequest.setJsonEntity("{ \"sort\": [{ \"int\" : \"asc\" }]}");
            createTemplate.setJsonEntity(mappingsAndSettings.toString());
    }
                if (isRunningAgainstAncientCluster()) {
import org.opensearch.index.IndexSettings;
    public void setIndex() {
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
                }""");
        assertStoredBinaryFields(count);
            }
            {
    }
                String segmentsResponse = toStr(client().performRequest(segmentsRequest));
        assertThat(metadata.get("state"), equalTo("close"));
            restoreRequest.setJsonEntity(restoreCommand.toString());
     * Tests that with or without soft-deletes, we should perform an operation-based recovery if there were some
        }
    }
                mappingsAndSettings.startObject("settings");
            assertNoFailures(response);
            createIndex.setOptions(allowTypesRemovalWarnings());
                    i -> JsonXContent.contentBuilder().startObject()
            saveInfoDocument(index + "_doc_count", Integer.toString(liveDocs));
                    if (rarely()) {
    }
        refreshAllIndices();
        assertEquals(100, hits.size());
                settings.field("number_of_replicas", between(0, 1));
        assertNoFailures(response);
                mappingsAndSettings.field("number_of_shards", 1);
                    "index":"test_index_reindex"
                    mappingsAndSettings.startObject(type);
                Request shrinkRequest = new Request("PUT", "/" + index + "/_shrink/" + target);
 * the Apache License, Version 2.0 (the "License"); you may
                    (Collection<Map<String, ?>>) XContentMapValues.extractValue("shards." + i, routingTable);
            templateBuilder.field("number_of_shards", 1);
                } else if (randomBoolean()) {
                    assertOK(client().performRequest(request));
 *
        request.setJsonEntity("{ \"query\": { \"match_all\" : {} }, \"size\": 100, \"stored_fields\": \"binary\"}");
            String value = (String) values.get(0);
            settings.endObject();
            final Settings.Builder settings = Settings.builder()
            Request restoreRequest = new Request("POST", "/_snapshot/repo/" + snapshot + "/_restore");
                    count,
     * The forced store is a Lucene FieldType bit recomputed on every mapping parse (incl.
                assertNumHits(target, numDocs + moreDocs, 1);
                /* Mark if we see a primary that looked like it restored from the translog.
            indexRandomDocuments(numDocs, true, true, randomBoolean(), i -> jsonBuilder().startObject().field("field", "value").endObject());
        } else {
 * specific language governing permissions and limitations
     *  <li>Create an index with a write alias
            createIndex(index, settings.build(), mappings);
        }
    }
    public void testClusterState() throws Exception {
                ensureGreenLongWait(target);
            // query still matches old docs (sub-field still indexed; parent still stored)
import org.opensearch.cluster.metadata.MetadataIndexStateService;
            // query works for new docs on both the multi-field and the parent
            client().performRequest(createIndex);
            }
                    true,
            ensureGreen(index);
        assertEquals(numDocs, totalHits);
                  },
                if (rarely()) {
            {
import static org.hamcrest.Matchers.nullValue;
        Request countRequest = new Request("GET", "/restored_" + index + "/_search");
        final boolean flushAllowed,
        {
            count = between(200, 300);
                mappingsAndSettings.endObject();
 * Unless required by applicable law or agreed to in writing,
                mappingsAndSettings.field("number_of_shards", 1);
            Request createTemplate = new Request("PUT", "/_template/template_1");
        countRequest.addParameter("size", "0");
        // Check some index properties:
        List<Object> shardStats = ObjectPath.createFromResponse(response).evaluate("indices." + index + ".shards.0");
    }
            indexRandomDocuments(count, true, true, randomBoolean(), i -> jsonBuilder().startObject().field("field", "value").endObject());
            createIndex.setJsonEntity(mappingsAndSettings.toString());
            createSnapshot.addParameter("wait_for_completion", "true");
            if (shouldHaveTranslog && false == currentLuceneVersion.equals(bwcLuceneVersion)) {
        final Map<String, ?> settings = (Map<String, Object>) XContentMapValues.extractValue("settings", metadata);
            assertEquals("Unexpected string length [" + value + "]", 16, binaryValue.length);
                Settings.Builder settings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 6);
        Matcher m = Pattern.compile("\"value\":\"(.+)\"").matcher(doc);
                for (String line : segmentsResponse.split("\n")) {
        assertEquals("1", numberOfShards);
        }
                  "dest":{
        request.setJsonEntity(infoDoc.toString());
                assertNoFailures(responseBody);
                int numCurrentVersion = 0;
        Request getTemplateRequest = new Request("GET", "/_template/test_template");
import static org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY;
    void assertAllSearchWorks(int count) throws IOException, ParseException {
        search.setJsonEntity("{\"track_total_hits\":true,\"query\":{\"match\":{\"" + field + "\":\"" + term + "\"}}}");
            }));
        assertEquals(getOldClusterVersion(), version);
                            .field("string", randomAlphaOfLength(10))
                {
                mappingsAndSettings.endObject();
     */
            }
        {
        Map<String, Object> healthRsp = entityAsMap(client().performRequest(request));
        final int count,
            assertDerivedSourceTitle(11, "lazy dog 11");
            }
        String numberOfReplicas = (String) XContentMapValues.extractValue(
        Request countRequest = new Request("GET", "/" + index + "/_search");
                    repoConfig.field("compress", randomBoolean());
            client().performRequest(setNumberOfReplicas);
        Map<String, Object> clusterState = entityAsMap(client().performRequest(new Request("GET", "/_cluster/state")));
            }
            saveInfoDocument("num_doc_" + index, Integer.toString(numDocs));
import org.opensearch.test.rest.OpenSearchRestTestCase;
                }
            assertMatchCount("title", "quick", 3);      // query on the parent
                }
            reindex.setJsonEntity(
                ".settings.index.number_of_replicas", clusterState);
        Request searchRequest = new Request("GET", "/" + index + "/_search");
            Request statsRequest = new Request("GET", index + "/_stats");
        request.addParameter("wait_for_status", "green");
            indexRandomDocuments(count, true, true, true, i -> jsonBuilder().startObject().field("field", "value").endObject());
            refresh();
        clusterSettingsRequest.addParameter("flat_settings", "true");
        String id = (String) bestHit.get("_id");
        List<?> histoBuckets = (List<?>) XContentMapValues.extractValue("aggregations.histo.buckets", longHistogram);
    }
        ensureGreenLongWait(index);
        String doc = "{\"test\": \"test\"}";
            shouldHaveTranslog = randomBoolean();
                } catch (ResponseException e) {
 *
                // but the recovering copy will be seen as invalid and the cluster health won't return to GREEN
                mappingsAndSettings.startObject("settings");
                assertThat(new XContentTestUtils.JsonMapView(indices).get("test_index_old.system"), is(false));
            (Map<String, Object>) clusterSettingsResponse.get("persistent");
     * Verifies that once all shard copies on the new version, we should turn off the translog retention for indices with soft-deletes.
            Settings.Builder settings = Settings.builder();
import org.opensearch.test.XContentTestUtils;
                // the default number of shards is now one so we have to set the number of shards to be more than one explicitly
     * </ol>
     *  <li>Write some documents to the write alias
            Map<?, ?> hitRsp = (Map<?, ?>) hit;
        restoreCommand.field("rename_replacement", "restored_" + index);
        Request searchRequest = new Request("GET", "/" + index + "/_search");
        return EntityUtils.toString(response.getEntity());
                    + "    \"" + index + "_write\": {}"
            for (int i = 10; i < 13; i++) {
                templateBuilder.endObject();
            client().performRequest(new Request("POST", "/" + index + "/_refresh"));
                mappingsAndSettings.field("number_of_shards", 1);
                    "index.blocks.write": true
        if (isRunningAgainstOldCluster()) {
        } else {
        assertTotalHits(count, countResponse);
import org.opensearch.common.settings.Settings;
                String historyUUID = ObjectPath.evaluate(shard, "commit.user_data.history_uuid");
        } else {
import java.util.HashSet;
                    i -> JsonXContent.contentBuilder().startObject().field("field", "value").endObject()
        numberOfReplicas = (String) XContentMapValues.extractValue("metadata.indices." + index +
    public void testDerivedSourceMultiFieldStore() throws Exception {
        restoreCommand.endObject();
                    mappingsAndSettings.endObject();
        Request countRequest = new Request("GET", "/" + index + "/_search");
                mappingsAndSettings.startObject("properties");
        totalHits = extractTotalHits(response);
    public void testRollover() throws IOException, ParseException {
        {
        Map<?, ?> source = (Map<?, ?>) getRsp.get("_source");
                    repoConfig.field("compress", randomBoolean());
        Request countAfterWriteRequest = new Request("GET", "/restored_" + index + "/_search");
    static String toStr(Response response) throws IOException, ParseException {
                    true,
        assertFalse("Could not find payload boost in explanation\n" + explanation, explanation.contains("payloadBoost"));
                    }
            numDocs = Integer.parseInt(loadInfoDocument("num_doc_" + index));
                mappingsAndSettings.startObject("mappings");
            response = entityAsMap(client().performRequest(new Request("GET", "/" + shrunkenIndex + "/_search")));
        // Stick a routing attribute into to cluster settings so we can see it after the restore
        @SuppressWarnings("unchecked") final Map<String, Object> persistentSettings =
            List<?> values = (List<?>) XContentMapValues.extractValue("fields.binary", hitRsp);
        Request request = new Request("GET", "/" + index + "/_search");
        final String snapshot = "snapshot-" + index;
        type = "_doc";
 * KIND, either express or implied.  See the License for the
    /**
            }
                        mappingsAndSettings.startObject("sub");
            assertDerivedSourceTitle(2, "quick brown fox 2");
                // Make sure our non-system index is still non-system
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());
     * test that the repository is ok with containing snapshot from both the
                    }
            final String mappings = randomBoolean() ? "\"_source\": { \"enabled\": false}" : null;
            final ResponseException error = expectThrows(ResponseException.class, () -> client().performRequest(restoreRequest));
                    + "  }"
    public void testEmptyShard() throws IOException {
                settings.startObject("settings");
                }
        }
            ensureGreen(index);
                mappingsAndSettings.field("number_of_replicas", 0);
                        }
                client().performRequest(doc);
                mappingsAndSettings.startObject("properties");
        final Map<String, ?> blocks = (Map<String, Object>) XContentMapValues.extractValue("blocks.indices." + index, state);
            assertTotalHits(liveDocs, entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search"))));
            createIndex(index, Settings.builder()
        assertAllSearchWorks(count);
                    templateBuilder.endObject();
        // Count the documents in the index to make sure we have as many as we put there
            }
     * {@link OpenSearchRestTestCase#ensureGreen}.
            createIndex.setJsonEntity(mappingsAndSettings.toString());
     * Test upgrading after a rollover. Specifically:
            nodes.add(nodeId);
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
        for (int i = 0; i < extras; i++) {
            count = countOfIndexedRandomDocuments();
            // create snapshot
                    repoConfig.field("location", System.getProperty("tests.path.repo"));
                indexDocument(Integer.toString(numDocs + i));
                            .field("int", randomInt(100))
            settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), false);
            mappingsAndSettings.startObject();
            mappingsAndSettings.startObject();
import static org.hamcrest.Matchers.greaterThan;
                mappingsAndSettings.field("number_of_replicas", 0);
                    }
            settings.startObject();
            client().performRequest(createIndex);
                    mappingsAndSettings.startObject("binary");
    /**
                templateBuilder.startObject("filter"); {
import java.util.HashMap;
            for (int i = 0; i < committedDocs; i++) {
            refreshAllIndices();
                    templateBuilder.field("enabled", true);
            mappingsAndSettings.field("order", "1000");
        Map<String, Object> countAfterResponse = entityAsMap(client().performRequest(countRequest));
                Request doc = new Request("PUT", "/" + index + "/_doc/" + i);
    private String loadInfoDocument(String id) throws IOException, ParseException {
     * This test creates an index in the old cluster and then closes it. When the cluster is fully restarted in a newer version,
     *  <li>Make sure the document count is correct
 * this file be licensed under the Apache-2.0 license or a
        if (isRunningAgainstOldCluster()) {
            indexRandomDocuments(
                int translogOps = Integer.parseInt(m.group(1));
                assertThat(shards.size(), equalTo(2));
        assertEquals(numDocs, totalHits);
        assertEquals("1", numberOfShards);
            boolean foundPrimary = false;
            for (int i = 0; i < numDocs; i++) {
        // the 'string' field has a boost of 4 in the mappings so it should get a payload boost
            // Create the repo
            Map<?, ?> bucket = (Map<?, ?>) entry;
        }
            }
            }
            // --- NEW docs written on the upgraded cluster into the SAME old index ---
            Map<String, Object> response = entityAsMap(client().performRequest(searchRequest));
                XContentTestUtils.JsonMapView tasksIndex = new XContentTestUtils.JsonMapView((Map<String, Object>) indices.get(".tasks"));
                }
        logger.info("--> testing field with dots in the name");
            XContentBuilder repoConfig = JsonXContent.contentBuilder().startObject(); {
            final long startTime = System.currentTimeMillis();
    public void testSearch() throws Exception {
                    String doc = JsonXContent.contentBuilder().startObject().field("field", "v2").endObject().toString();
        }
            indexRandomDocuments(
        client().performRequest(enableAutoRefresh);
            // create repo
            }
     */
        client().performRequest(updateRequest);
            assertMatchCount("title", "lazy", 3);
    }
    public void testOperationBasedRecovery() throws Exception {
            }
        int termsCount = 0;
            assertEmptyTranslog(index);
            createRepoRequest.setJsonEntity(repoConfig.toString());
            client().performRequest(new Request("POST", "/" + index + "/_refresh"));
                    + "    \"max_docs\": 5"
                    {
    private void saveInfoDocument(String id, String value) throws IOException {
                // then delayed allocation will kick in. When the node comes back, the cluster-manager will search for a copy
        restoreCommand.field("indices", index);
    @Before
            Map<String, Object> response = entityAsMap(client().performRequest(reindex));
            templateBuilder.endObject();
        ensureGreen(index);
            // GET _source still reconstructs for old docs
    public void setType() {
                    client().performRequest(request);
                }
                templateBuilder.startObject("_source");
        ensureGreen(index);
        Map<String, Object> response = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search")));
        Request listSnapshotRequest = new Request("GET", "/_snapshot/repo/" + snapshotName);
            {
            XContentBuilder settings = jsonBuilder();
            Map<String, Object> response = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search")));
            // Restore
    }
            String minCompatibleBWCVersion = Version.CURRENT.minimumCompatibilityVersion().luceneVersion.toString();
        } else {
     * statistics we gather about that.
                v.current(systemIndexWarning);
            ensureGreen(index);
                    templateBuilder.startObject("term"); {
            mappingsAndSettings.startObject();
                mappingsAndSettings.field("number_of_shards", 1);
        } else {
        infoDoc.field("value", value);
            restoreRequest.addParameter("wait_for_completion", "true");
                    client().performRequest(new Request("DELETE", "/" + index + "/_doc/" + i));
                {
        for (int i = 0; i < bulkCount; i++) {
    }
            assertEquals("All nodes should have a consistent number of documents", 1, counts.size());
        assertTotalHits(count, countResponse);
                final String target = index + "_split";
            String currentLuceneVersion = Version.CURRENT.luceneVersion.toString();
        final String systemIndexWarning = "this request accesses system indices: [.tasks], but in a future major version, direct " +
                mappingsAndSettings.field("number_of_shards", 1);
import org.opensearch.cluster.metadata.IndexMetadata;
                mappingsAndSettings.endObject();
                }
                    "index.blocks.write": true
     * before we restart the cluster. This is important when we move from translog based to retention leases based
        Request updateRequest = new Request("POST", "/" + index + "/_update/" + docId);
            totalShards = (int) XContentMapValues.extractValue("_shards.total", response);
        int totalShards = (int) XContentMapValues.extractValue("_shards.total", response);
            client().performRequest(createIndex);
                    true,
    /**
        assertTotalHits(count, matchAllResponse);
            ensureGreen(index);
        Map<?, ?> longHistogram = entityAsMap(client().performRequest(longHistogramRequest));
                        mappingsAndSettings.startObject("field");
     */
            mappingsAndSettings.startObject();
            assertDerivedSourceTitle(0, "quick brown fox 0");
        addRoutingSettings.setJsonEntity(
                Map<String, Object> responseBody = entityAsMap(client().performRequest(search));
            client().performRequest(createRepoRequest);
                repoConfig.startObject("settings"); {
            createIndex.setJsonEntity(mappingsAndSettings.toString());
        if (isRunningAgainstOldCluster()) {
     * NOTE: derived_source (index.derived_source.enabled) is available from 3.3.0 onwards (#18565).
                if (randomBoolean()) {
        bulkRequest.setJsonEntity(bulk.toString());
            int liveDocs = numDocs;
/*
        }
            XContentBuilder mappingsAndSettings = jsonBuilder();
                    }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        mappingsAndSettings.endObject();
            numDocs = randomIntBetween(10, 1000);
            Map<String, Object> response = entityAsMap(client().performRequest(searchRequest));
            count = countOfIndexedRandomDocuments();
    public void testForbidDisableSoftDeletesOnRestore() throws Exception {
        Request request = new Request("PUT", "/info/" + type + "/" + id);
                    final Request request = new Request("POST", "/" + index + "/" + type + "/" + i);
            mappingsAndSettings.endObject();
            ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
            updateSettingsRequest.setJsonEntity(
        List<String> nodes = new ArrayList<>();
        Request explainRequest = new Request("GET", "/" + index + "/_explain" + "/" + id);
            for (Object shard : shardStats) {
        if (isRunningAgainstOldCluster()) {
        searchRequest.setJsonEntity("{ \"query\": { \"match_all\" : {} }}");
            Request shrinkIndexRequest = new Request("PUT", "/" + index + "/_shrink/" + shrunkenIndex);
            for (int i = 0; i < numDocs; i++) {
            client().performRequest(createIndex);
        Request longHistogramRequest = new Request("GET", "/" + index + "/_search");
     */
            openIndex(index);
                        refresh();
                  "settings": {
            assertDerivedSourceTitle(2, "quick brown fox 2");
                    } else if (minCompatibleBWCVersion.equals(version) && minCompatibleBWCVersion.equals(bwcLuceneVersion) == false) {
            String bwcLuceneVersion = getOldClusterVersion().luceneVersion.toString();
        for (Object shard : shardStats) {
 * of an older version. The cluster is shutdown and a cluster of the new
            int uncommittedDocs = randomIntBetween(0, (int) (committedDocs * 0.1));
                    + "  \"conditions\": {"
     */
            // start a async reindex job
            restoreCommand.field("rename_replacement", "restored-" + index);
            {
        assertTrue("doc does not contain 'foo' key: " + source, source.containsKey("foo"));
            }
            Request setNumberOfReplicas = new Request("PUT", "/" + index + "/_settings");
            Request getTask = new Request("GET", "/_tasks/" + taskId);
            ensureGreen(index);
        checkSnapshot("old_snap", count, getOldClusterVersion());
        assertTotalHits(histoCount, longHistogram);
                }
            createIndex.setJsonEntity("{"
        request.addParameter("timeout", "2m");
        Version version = Version.fromId(Integer.valueOf((String) XContentMapValues.extractValue("metadata.indices." + index +
        StringBuilder bulk = new StringBuilder();
            // wait for task
        writeToRestoredRequest.addParameter("refresh", "true");
        aliases.put("alias2", singletonMap("filter", singletonMap("term", singletonMap("version", tookOnVersion.toString()))));
            assertMatchCount("title.sub", "fox", 3);
            assertThat(XContentMapValues.extractValue("index.verified_before_close", settings), nullValue());
                mappingsAndSettings.endObject();
                indexDocument(Integer.toString(randomIntBetween(1, 100)));
                mappingsAndSettings.endObject();
import java.util.Collection;
            for (String line : recoveryResponse.split("\n")) {
        final String index = "test_empty_shard";
        Request countRequest = new Request("POST", "/" + index + "-*/_search");
            }
    }
        }
        if (isRunningAgainstOldCluster()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (false == isRunningAgainstOldCluster()) {
                {
                    count / 10,
        totalShards = (int) XContentMapValues.extractValue("_shards.total", response);
                    assertThat(XContentMapValues.extractValue("state", shard), equalTo("STARTED"));
        }
 * license agreements. See the NOTICE file distributed with
        final boolean saveInfo,
                numDocs = between(1, 100);
            // Force flush so we're sure that all translog are committed
            client().performRequest(updateSettingsRequest);
        countAfterWriteRequest.addParameter("size", "0");
    }
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true);
                mappingsAndSettings.field("number_of_shards", 1);
        assertThat(toStr(client().performRequest(request)), containsString(doc));
            }
            XContentBuilder repoConfig = JsonXContent.contentBuilder().startObject();
            bulk.setJsonEntity("{\"index\": {\"_index\": \"test_index_old\"}}\n" + "{\"f1\": \"v1\", \"f2\": \"v2\"}\n");
            assertTotalHits(liveDocs, entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search"))));
 * ownership. Elasticsearch licenses this file to you under
            Request createSnapshot = new Request("PUT", "/_snapshot/repo/" + snapshot);
        Request restoreRequest = new Request("POST", "/_snapshot/repo/" + snapshotName + "/_restore");
        Request request = new Request("GET", docLocation);
    @SuppressWarnings("unchecked")
        // histogram on a long
                }
        assertRealtimeGetWorks();
    @Before
 */
        request.addParameter("wait_for_events", "languid");
        // Clean up the index for the next iteration
}
                        equalTo(globalHistoryUUID));
                logger.info("evaluating: {} , {}", ObjectPath.evaluate(shard, "routing"), ObjectPath.evaluate(shard, "commit"));
        if (checkRoutingTable) {
        Map<String, Object> countResponse = entityAsMap(client().performRequest(countRequest));
            client().performRequest(createSnapshot);
                mappingsAndSettings.startObject("mappings");
                """
            assertTotalHits(count, response);
            mappingsAndSettings.field("index_patterns", index);
            ensureGreen(restoredIndex);
            saveInfoDocument(index + "_doc_count", Integer.toString(numDocs));
                """);
        logger.info("health api response: {}", healthRsp);
        expectedTemplate.put("mappings", singletonMap("_source", singletonMap("enabled", true)));
                }
                    mappingsAndSettings.startObject("dots_in_field_names");
            restoreCommand.field("rename_pattern", index);
     * Asserts that an index is closed in the cluster state. If `checkRoutingTable` is true, it also asserts
                    mappingsAndSettings.endObject();
        // Check settings added by the restore process
                mappingsAndSettings.endObject();
import java.util.Map;
        createSnapshot.setJsonEntity("{\"indices\": \"" + index + "\"}");
public class FullClusterRestartIT extends AbstractFullClusterRestartTestCase {
                    request.setJsonEntity(doc);
            // create snapshot
            restoreCommand.startObject("index_settings");
        String shrunkenIndex = index + "_shrunk";
        } else {
import java.util.List;
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 3)
            client().performRequest(createTestIndex);
        assertEquals(expectedCount, extractTotalHits(count));
import static org.hamcrest.Matchers.notNullValue;
                v.compatible(systemIndexWarning);
        restoreRequest.addParameter("wait_for_completion", "true");
        } else {
            }
                {
        }
                mappingsAndSettings.endObject();
                } else {
                    }
                        mappingsAndSettings.field("type", "text");
            getOldClusterVersion().onOrAfter(Version.fromString("3.3.0"))
            Request shrinkIndexRequest = new Request("PUT", "/" + index + "/_shrink/" + shrunkenIndex);
            int numDocs = extractTotalHits(response);
import org.opensearch.common.xcontent.support.XContentMapValues;
        assertThat(extractTotalHits(resp), equalTo(numHits));
    private List<String> dataNodes(String index, RestClient client) throws IOException {
        int numDocs;
        // Make sure there are payloads and they are taken into account for the score
        int totalHits = extractTotalHits(response);
    }
            // Create the index
    @SuppressWarnings("unchecked")
            {
        int successfulShards = (int) XContentMapValues.extractValue("_shards.successful", response);
            termsCount += (Integer) bucket.get("doc_count");
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            count = countOfIndexedRandomDocuments();
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
                templateBuilder.endObject();
            ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
            Request searchRequest = new Request("GET", "/" + index + "/_search");
            String taskId = (String) response.get("task");
    public void testTurnOffTranslogRetentionAfterUpgraded() throws Exception {
            createRepoRequest.setJsonEntity(repoConfig.toString());
        assertThat(metadata, notNullValue());
            assertThat(routingTable, nullValue());
    }
        client().performRequest(disableAutoRefresh);
            if (minimumNodeVersion().before(Version.V_2_0_0)) {
            ensureGreenLongWait(index);
            int numDocs = randomIntBetween(10, 100);
        String docLocation = "/" + index + "/" + type + "/1";
                }
     * Tests snapshot/restore by creating a snapshot and restoring it. It takes
        }
                    + "  }"
            for (int i = 0; i < uncommittedDocs; i++) {
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1);
            }
import org.opensearch.common.xcontent.XContentType;
    public void testSingleDoc() throws IOException, ParseException {
        restoreCommand.field("rename_pattern", index);
                    mappingsAndSettings.field("index.number_of_shards", 5);
    /**
     * multi-fields (sub-fields) are no longer force-stored, while the parent text field still is.
            indexRandomDocuments(
                    numDocs,
        Map<String, Object> countResponse = entityAsMap(client().performRequest(countRequest));
                refresh();
            for (String node : dataNodes(index, client())) {
        if (isRunningAgainstOldCluster()) {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1);
        client().performRequest(createTemplateRequest);
                mappingsAndSettings.startObject("mappings");
        if (isRunningAgainstOldCluster()) {
        logger.debug("Refreshing [{}]", index);
                Request splitRequest = new Request("PUT", "/" + index + "/_split/" + target);
    }
            ensureGreen(index);
        aliases.put("alias1", emptyMap());
            int liveDocs = Integer.parseInt(loadInfoDocument(index + "_doc_count"));
                mappingsAndSettings.endObject();
    }
            assertMatchCount("title.sub", "fox", 3);
        logger.info("--> testing _all search");
                {
            assertNoFailures(response);
        disableAutoRefresh.setJsonEntity("{ \"index\": { \"refresh_interval\" : -1 }}");
            int numDocs = countOfIndexedRandomDocuments();
        assertEquals(numDocs, totalHits);
 * under the License.
        assertClosedIndex(index, true);
            numDocs = randomIntBetween(512, 1024);
                  }
    public void testSnapshotRestore() throws IOException, ParseException {
                Request clusterStateRequest = new Request("GET", "/_cluster/state/metadata");
     * MAPPING_RECOVERY on restart), so this verifies both _source reconstruction (GET) and search
        restoreRequest.setJsonEntity(restoreCommand.toString());
        refresh();
    }
            restoreCommand.endObject();
                 * random documents when we want there to be a translog and they might
import org.apache.hc.core5.http.ParseException;
                 * Not all primaries will look like this all the time because we modify
        assertEquals(totalShards, successfulShards);
                Matcher m = Pattern.compile("(\\d+)$").matcher(line);
package org.opensearch.upgrades;
                // if the node with the replica is the first to be restarted, while a replica is still recovering
                if (randomBoolean()) {
        Request request = new Request("GET", "/info/_doc/" + id);
    void assertBasicAggregationWorks() throws IOException {
            createSnapshot.addParameter("wait_for_completion", "true");
        }
    // TODO tests for upgrades after shrink. We've had trouble with shrink in the past.
            Request createIndex = new Request("PUT", "/" + index + "-000001");
            int numDocs = randomIntBetween(0, 100);
        }
            {
                }
                mappingsAndSettings.startObject("settings");
        if (false == isRunningAgainstOldCluster()) {
        Request createSnapshot = new Request("PUT", "/_snapshot/repo/" + (isRunningAgainstOldCluster() ? "old_snap" : "new_snap"));
            ensureGreen(index);
        int successfulShards = (int) XContentMapValues.extractValue("_shards.successful", response);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    public void testShrinkAfterUpgrade() throws IOException, ParseException {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            ".settings.index.number_of_shards", clusterState);
        request.addParameter("filter_path", "_source");
            final Settings.Builder settings = Settings.builder()
                }
                mappingsAndSettings.endObject();
        createSnapshot.addParameter("wait_for_completion", "true");
                }
        } else {
            // --- OLD docs after full restart + mapping re-parse by new code ---
                    mappingsAndSettings.startObject("properties");
     * Tests recovery of an index with or without a translog and the
                Map<String, Object> indices = new XContentTestUtils.JsonMapView(entityAsMap(client().performRequest(clusterStateRequest)))
        if (isRunningAgainstOldCluster()) {
        assertNoFailures(response);
            Request restoreRequest = new Request("POST", "/_snapshot/repo/" + snapshot + "/_restore");
                final Collection<Map<String, ?>> shards =
                    mappingsAndSettings.field("type", "text");
        }
import java.util.Set;
    ) throws IOException {
                Request doc = new Request("PUT", "/" + index + "/_doc/" + i);
        }
            client().performRequest(createDocument);
                mappingsAndSettings.field("number_of_replicas", 1);
     * sanity check and on the new cluster as an upgrade test. It also takes a
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            getTasksIndex.setOptions(expectVersionSpecificWarnings(v -> {
                mappingsAndSettings.field("number_of_replicas", 0);
                            .endObject()
    void assertStoredBinaryFields(int count) throws Exception {
                        mappingsAndSettings.endObject();
        longHistogramRequest.setJsonEntity("{ \"aggs\": { \"histo\" : {\"histogram\" : {\"field\": \"int\", \"interval\": 10}} }}");
import static org.hamcrest.Matchers.equalTo;
            restoreRequest.addParameter("wait_for_completion", "true");
                }
                if (globalHistoryUUID == null) {
        // Remove the routing setting and template so we can test restoring them.
        assertThat(totalShards, greaterThan(1));
 * Licensed to Elasticsearch under one or more contributor
                Settings.Builder settings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1);
            updateSettingsRequest.setJsonEntity(
        expectedTemplate = singletonMap("test_template", expectedTemplate);
    protected void ensureGreenLongWait(String index) throws IOException {
                // Find the primaries
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals("0", numberOfReplicas);
                    flush(index, randomBoolean());
        Map<String, Object> count = entityAsMap(client().performRequest(countRequest));
                mappingsAndSettings.startObject("settings");
        Map<String, Object> clusterSettingsResponse = entityAsMap(client().performRequest(clusterSettingsRequest));
                }
        }
            updateSettingsRequest.setJsonEntity(
        assertThat(totalShards, greaterThan(1));
        expectedTemplate.put("order", 0);
        List<?> termsBuckets = (List<?>) XContentMapValues.extractValue("aggregations.bool_terms.buckets", boolTerms);
        } else {
            }
            createIndex(index, settings.build());
            {
                        }
        }
        Map<String, Object> listSnapshotResponse = entityAsMap(client().performRequest(listSnapshotRequest));
        final String snapshot = "snapshot-" + index;
    }
        assertThat(persistentSettings.get("cluster.routing.allocation.exclude.test_attr"), equalTo(getOldClusterVersion().toString()));
        countRequest.addParameter("size", "0");
                repoConfig.endObject();
     * it verifies that the index exists and is replicated if the old version supports replication.
        Map<?, ?> matchAllResponse = entityAsMap(client().performRequest(searchRequest));
                        {
                    settings.field("soft_deletes.enabled", true);
            createSnapshot.setJsonEntity("{\"indices\": \"" + index + "\"}");
            Request recoveryRequest = new Request("GET", "/_cat/recovery/" + index);
        // Only create the first version so we know how many documents are created when the index is first created
            client().performRequest(new Request("POST", "/" + index + "/_flush"));
                    mappingsAndSettings.field("type", "binary");
            mappingsAndSettings.endObject();
            client().performRequest(shrinkIndexRequest);
 * The OpenSearch Contributors require contributions made to
        templateBuilder.field("index_patterns", "evil_*"); // Don't confuse other tests by applying the template
        int count;
            Set<Integer> counts = new HashSet<>();
            saveInfoDocument(index + "_count", Integer.toString(count));
        if (saveInfo) {
            builder.compareMaps(getTemplateResponse, expectedTemplate);
            {
            final String nodeId = ObjectPath.evaluate(shard, "routing.node");
                mappingsAndSettings.field("index.derived_source.enabled", true);
            restoreCommand.field("indices", index);
        assertNotNull(stringValue);
    }
            logger.debug("--> recovery status:\n{}", recoverRsp);
                    mappingsAndSettings.field("soft_deletes.enabled", true);
        String docId = (String) hit.get("_id");
            }
            client().performRequest(createIndex);
            }
                    true,
                mappingsAndSettings.startObject("settings");
    }
        if (isRunningAgainstOldCluster()) {
        if (isRunningAgainstOldCluster()) {
            assertNoFailures(response);
        }
        String shrunkenIndex = index + "_shrunk";
            Map<String, Object> recoverRsp = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_recovery")));
            closeIndex(index);
                repoConfig.endObject();
                    } else {
 * Tests to run before and after a full cluster restart. This is run twice,
            assertTotalHits(count, response);
            numDocs = randomIntBetween(512, 1024);
            Response response = client().performRequest(statsRequest);
                    Request request = new Request("POST", "/" + index + "/_doc/" + i);
        Map<?, ?> bestHit = (Map<?, ?>) ((List<?>) (XContentMapValues.extractValue("hits.hits", response))).get(0);
                    flush(index, randomBoolean());
            Request bulk = new Request("POST", "/_bulk");
            assertDerivedSourceTitle(0, "quick brown fox 0");
        Map<?, ?> boolTerms = entityAsMap(client().performRequest(boolTermsRequest));
                }
                    + "  \"aliases\": {"
            Request updateSettingsRequest = new Request("PUT", "/" + index + "/_settings");
                  "source":{
            random().nextBytes(randomByteArray);
        Request boolTermsRequest = new Request("GET", "/" + index + "/_search");
                 * not be spread around all the shards. */
import org.opensearch.client.RestClient;
        if (isRunningAgainstOldCluster() == false) {
                Request request = new Request("POST", "/" + index + "/_doc/" + i);
                            mappingsAndSettings.field("type", "text");
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build());
            {
 */
                """
            Request createRepoRequest = new Request("PUT", "/_snapshot/repo");
            Request rolloverRequest = new Request("POST", "/" + index + "_write/_rollover");
            Request createIndex = new Request("PUT", "/" + index);
        {
        String stringValue = (String) XContentMapValues.extractValue("_source.string", bestHit);
                mappingsAndSettings.endObject();
                restoreCommand.field("index.soft_deletes.enabled", false);
        assertEquals(singletonList("SUCCESS"), XContentMapValues.extractValue("snapshots.state", listSnapshotResponse));
        Map<?, ?> response = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search")));
                    settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true);
            Map<?, ?> bucket = (Map<?, ?>) entry;
            bulk.addParameter("refresh", "true");
                if (isRunningAgainstAncientCluster()) {
        final Map<String, ?> routingTable = (Map<String, Object>) XContentMapValues.extractValue("routing_table.indices." + index, state);
    /**
            createSnapshot.setJsonEntity("{\"indices\": \"" + index + "\"}");
            Request reindex = new Request("POST", "/_reindex");
            client().performRequest(shrinkIndexRequest);
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;
                    continue;
    public static void assertNumHits(String index, int numHits, int totalShards) throws IOException {
        searchRequest.setEntity(explainRequest.getEntity());
                try {
                final String id = Integer.toString(randomIntBetween(1, 100));
                if (randomBoolean()) {
                            .field("bool", i > 0 && randomBoolean())
            totalHits = extractTotalHits(response);
        }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     *  <li>Make sure the document count is correct
        Map<String, Object> resp = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search")));
            client().performRequest(rolloverRequest);
        } else {
            getTask.addParameter("wait_for_completion", "true");
                assertNumHits(target, numDocs + moreDocs, 3);
                );
                    mappingsAndSettings.field("type", "text");
            assertEquals(1, successfulShards);
                foundPrimary = true;
            assertTrue("expected to find a primary but didn't\n" + recoveryResponse, foundPrimary);
                assertThat(indices, hasKey(".tasks"));
            );
                logger.debug("Flushing [{}]", index);
            // Restore
                }
                client().performRequest(splitRequest);
 * not use this file except in compliance with the License.
                {
                int hits = extractTotalHits(responseBody);
        client().performRequest(addRoutingSettings);
        String explanation = toStr(client().performRequest(explainRequest));
    }
        request.addParameter("level", "shards");
        final CheckedFunction<Integer, XContentBuilder, IOException> docSupplier
        Map<String, Object> rsp = entityAsMap(client().performRequest(request));
            mappingsAndSettings.endObject();
            XContentBuilder mappingsAndSettings = jsonBuilder();
                        continue;
                    + "}");
            {
            final int numReplicas = 1;
        assertEquals(singletonList(snapshotName), XContentMapValues.extractValue("snapshots.snapshot", listSnapshotResponse));
            Request updateSettingsRequest = new Request("PUT", "/" + index + "/_settings");
            assertTotalHits(numDocs, entityAsMap(client().performRequest(new Request("GET", "/" + restoredIndex + "/_search"))));
        successfulShards = (int) XContentMapValues.extractValue("_shards.successful", response);
            indexRandomDocuments(numDocs, true, true, randomBoolean(), i -> jsonBuilder().startObject().field("field", "value").endObject());
                }
            flush(index, true);
        int totalShards = (int) XContentMapValues.extractValue("_shards.total", response);
                }
             * or not we have one. */
            assertTotalHits(count, response);
            restoreCommand.endObject();
                  }
        searchRequest.addParameter("explain", "true");
 * version is started with the same data directories and then this is rerun
     */
                search.addParameter("preference", "_only_nodes:" + node);
                    numDocs, true, true, randomBoolean(), i -> JsonXContent.contentBuilder().startObject().field("field", "value").endObject());
        assertBasicAggregationWorks();
            ensureGreen(index); // wait for source index to be available on both nodes before starting shrink
        // Make sure search finds all documents
            client().performRequest(createRepoRequest);
            count = randomIntBetween(2000, 3000);
                mappingsAndSettings.startObject("settings");
                    // this is the default after v7.0.0, but is required before that
                        {
        templateBuilder.startObject("aliases"); {
                if (translogOps > 0) {
                    mappingsAndSettings.field("store", "true");
    }
        // And count to make sure the add worked
            assertDerivedSourceTitle(12, "lazy dog 12");
                if (rarely()) {
            numDocs = countOfIndexedRandomDocuments();
        restoreCommand.field("include_global_state", true);
        List<?> hits = (List<?>) XContentMapValues.extractValue("hits.hits", rsp);
            "metadata.templates.template_1.settings.index.number_of_replicas", clusterState);
        clearRoutingFromSettings.setJsonEntity("{\"persistent\":{\"cluster.routing.allocation.exclude.test_attr\": null}}");
            String restoredIndex = "restored-" + index;
        client().performRequest(new Request("DELETE", "/_template/test_template"));
            }
            assertThat("Expected stats for 2 shards", shardStats, hasSize(2));
        if (isRunningAgainstOldCluster()) {
            assertThat(Booleans.parseBoolean((String) XContentMapValues.extractValue("index.verified_before_close", settings)), is(true));
            {
                {
     */
        // Check the snapshot metadata, especially the version
        assertThat(settings, notNullValue());
            /* We've had bugs in the past where we couldn't restore
        int totalHits = extractTotalHits(response);
                indexDocument(Integer.toString(i));
        templateBuilder.endObject().endObject();
            {
                if (randomBoolean()) {
        // Restore
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        bulkRequest.addParameter("refresh", "");
                // Can't get the .tasks index via JsonMapView because it splits on `.`
             * an index without a translog so we randomize whether
            // create repo
                mappingsAndSettings.endObject();
            XContentBuilder mappingsAndSettings = jsonBuilder();
        if (isRunningAgainstOldCluster()) {
            int committedDocs = randomIntBetween(100, 200);
            }
        countRequest.addParameter("size", "0");
    }
                """
                    mappingsAndSettings.endObject();
        }
        logger.info("--> testing basic search");
            client().performRequest(createIndex);
            XContentBuilder mappingsAndSettings = jsonBuilder();
        final Request indexRequest = new Request("POST", "/" + index + "/" + type + "/" + id);
                client().performRequest(new Request("PUT", "/" + index + "/_clone/" + target));
        XContentBuilder infoDoc = JsonXContent.contentBuilder().startObject();
            String recoveryResponse = toStr(client().performRequest(recoveryRequest));
        logger.info("--> testing basic search with sort");
                    mappingsAndSettings.endObject();
        assertThat(XContentMapValues.extractValue("_shards.total", resp), equalTo(totalShards));
/*
            assertTotalHits(numDocs, entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search"))));
            int moreDocs = randomIntBetween(0, 100);
            {
        Map<String, Object> getRsp = entityAsMap(client().performRequest(getRequest));
                indexDocument(Integer.toString(i));
 * this work for additional information regarding copyright
            }
                segmentsRequest.addParameter("s", "prirep,shard,index");
        ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
                {
     * <ol>
                    } else if (bwcLuceneVersion.equals(version)) {
    }
                    }
                    mappingsAndSettings.field("type", "text");
        logger.info("--> testing exists filter");
                final String target = index + "_cloned";
            createDoc.setJsonEntity(doc);
        // Add some extra documents to the index to be sure we can still write to it after restoring it
                mappingsAndSettings.field("number_of_replicas", 1);
            }
            );
            assertThat(shardStats, notNullValue());
                {
        for (Object entry : termsBuckets) {
    }
            createIndex(index, settings.build());
            // less than 10% of the committed docs (see IndexSetting#FILE_BASED_RECOVERY_THRESHOLD_SETTING).
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), false);
        assertEquals("0", numberOfReplicas);
        final Map<String, ?> metadata = (Map<String, Object>) XContentMapValues.extractValue("metadata.indices." + index, state);
        Map<String, Object> aliases = new HashMap<>();
        Map<String, Object> expectedTemplate = new HashMap<>();
     *  <li>Write some more documents to the write alias
            }
        XContentBuilder restoreCommand = JsonXContent.contentBuilder().startObject();
        Map<?, ?> response = entityAsMap(client().performRequest(new Request("GET", "/" + index + "/_search")));
            boolean restoredFromTranslog = false;
import org.junit.Before;
        assertTotalHits(count, rsp);
        }
     * that the index has started shards.
     */
            XContentBuilder mappingsAndSettings = jsonBuilder();
                repoConfig.field("type", "fs");
    private String index;
        request.addParameter("wait_for_no_relocating_shards", "true");
                settings.field("number_of_shards", between(1, 5));
            shouldHaveTranslog = Booleans.parseBoolean(loadInfoDocument(index + "_should_have_translog"));
                }
import static java.util.Collections.emptyMap;
            for (int i = 0; i < numDocs; i++) {
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());
    void assertRealtimeGetWorks() throws IOException {
        response = entityAsMap(client().performRequest(new Request("GET", "/" + shrunkenIndex+ "/_search")));
        }
            assertEquals(1, totalShards);
            Request createIndex = new Request("PUT", "/" + index);
        assertEquals(1, successfulShards);
 * SPDX-License-Identifier: Apache-2.0
        if (isRunningAgainstOldCluster()) {
        }
                refreshAllIndices();
        Request request = new Request("GET", index + "/_stats");
        String numberOfShards = (String) XContentMapValues.extractValue(
        refreshAllIndices();
        if (isRunningAgainstOldCluster()) {
            client().performRequest(bulk);
import org.opensearch.test.NotEqualMessageBuilder;
        client().performRequest(clearRoutingFromSettings);
        }
        expectedTemplate.put("aliases", aliases);
                            // be sure to create a "proper" boolean (True, False) for the first document so that automapping is correct
                    liveDocs--;
            restoreCommand.endObject();
        // Stick a template into the cluster so we can see it after the restore
            final int nbShards = Integer.parseInt(numberOfShards);
    }
        assertEquals(1, totalShards);
            createIndex.setJsonEntity(mappingsAndSettings.toString());
                mappingsAndSettings.startObject("properties");
                assertThat(shards, notNullValue());
 * GitHub history for details.
            assertMatchCount("title.sub", "fox", 3);   // query on the multi-field
                        mappingsAndSettings.endObject();
            XContentBuilder restoreCommand = JsonXContent.contentBuilder().startObject();
                }
            restoreCommand.field("rename_pattern", index);
            checkSnapshot("new_snap", count, Version.CURRENT);
                    containsString("testrollover-000002"));
            }
import org.opensearch.core.xcontent.XContentBuilder;
                mappingsAndSettings.field("index.number_of_shards", 5);
        } else {
            NotEqualMessageBuilder builder = new NotEqualMessageBuilder();
            final String numberOfShards = (String) XContentMapValues.extractValue("index.number_of_shards", settings);
                {
            templateBuilder.startObject("alias2"); {
            client().performRequest(new Request("PUT", "/" + index));
            }
        // Check that the template was restored successfully
 */
        Response response = client.performRequest(request);
            mappingsAndSettings.startObject();
                    "index.blocks.write": true
    public void testShrink() throws IOException, NumberFormatException, ParseException {
            }
            numDocs = countOfIndexedRandomDocuments();
            reindex.addParameter("wait_for_completion", "false");
            }
            Request createIndex = new Request("PUT", "/" + index);
            Request createIndex = new Request("PUT", "/" + index);
    public void testClosedIndices() throws Exception {
            createIndex.setJsonEntity(settings.toString());
            final int expectedNumDocs = Integer.parseInt(loadInfoDocument(index + "_doc_count"));
import java.io.IOException;
                {
            Request createIndex = new Request("PUT", "/" + index);
            }
            int numDocs = randomIntBetween(2000, 3000);
            XContentBuilder repoConfig = JsonXContent.contentBuilder().startObject();
                }
        assertThat("hits for " + field + ":" + term, extractTotalHits(resp), equalTo(expectedHits));
                refreshAllIndices();
                Request segmentsRequest = new Request("GET", "/_cat/segments/" + index);
                  }
        }
                mappingsAndSettings.startObject("mappings");
            statsRequest.addParameter("level", "shards");
            {
                }
            createIndex.setJsonEntity(mappingsAndSettings.toString());
            shrinkIndexRequest.setJsonEntity("{\"settings\": {\"index.number_of_shards\": 1}}");
                mappingsAndSettings.startObject("settings");
                segmentsRequest.addParameter("h", "prirep,shard,index,version");
                // Update a few documents so we are sure to have a translog
                repoConfig.startObject("settings");
        Request enableAutoRefresh = new Request("PUT", "/" + index + "/_settings");
     * but not too many uncommitted documents (i.e., less than 10% of committed documents or the extra translog)
            flushRequest.addParameter("wait_if_ongoing", "true");
     * Wait for an index to have green health, waiting longer than
            Request flushRequest = new Request("POST", "/" + index + "/_flush");
        assertThat(EntityUtils.toString(client().performRequest(writeToRestoredRequest).getEntity()), containsString("\"errors\":false"));
            Request searchRequest = new Request("GET", "/" + index + "/_search");
        if (isRunningAgainstOldCluster()) {
        }
        if (isRunningAgainstOldCluster()) {
            restoreCommand.endObject();
 * with {@code tests.is_old_cluster} set to {@code false}.
import static org.hamcrest.Matchers.is;
            ensureGreenLongWait(index);
                client().performRequest(request);
                    mappingsAndSettings.endObject();
        assumeTrue("soft deletes must be enabled on 2.0+", getOldClusterVersion().before(Version.V_2_0_0));
                counts.add(hits);
                            mappingsAndSettings.field("type", "text");
                {
        }
            client().performRequest(createTemplate);
                    mappingsAndSettings.startObject("field");
/**
        assertNoFailures(matchAllResponse);
    public void testHistoryUUIDIsAdded() throws Exception {
        assertNoFailures(resp);
                    flush(index, randomBoolean());
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());
import org.opensearch.common.xcontent.json.JsonXContent;
        expectedTemplate.put("settings", singletonMap("index", singletonMap("number_of_shards", "1")));
        Map<?, ?> searchResponse = entityAsMap(client().performRequest(searchRequest));
        // verifying if we can still read some properties from cluster state api:
    }
            mappingsAndSettings.endObject();
            }
            final Settings.Builder settings = Settings.builder()
     * a snapshot on the old cluster and restores it on the old cluster as a
            assertThat(error.getMessage(), containsString("cannot disable setting [index.soft_deletes.enabled] on restore"));
                        numCurrentVersion++;
        ensureGreenLongWait(index);
                    + "}");
                mappingsAndSettings.field("number_of_replicas", 0);
    /**
            logger.debug("--> creating [{}] replicas for index [{}]", numReplicas, index);
            histoCount += (Integer) bucket.get("doc_count");
     */
                }
        Request addRoutingSettings = new Request("PUT", "/_cluster/settings");
                {
import static java.util.Collections.singletonList;
     * peer recoveries.
        );
            for (int i = 0; i < 3; i++) {
     * and some routing configuration.
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1);
            assertMatchCount("title.sub", "dog", 3);
            ensureGreen(index);
                            .field("field.with.dots", randomAlphaOfLength(10))
            searchRequest.setJsonEntity("{ \"query\": { \"exists\" : {\"field\": \"string\"} }}");
                for (int i = 0; i < numDocs; i++) {
                int numBwcVersion = 0;
                        fail("expected version to be one of [" + currentLuceneVersion + "," + bwcLuceneVersion + "] but was " + line);
                    mappingsAndSettings.field("type", "text");
        for (Object entry : histoBuckets) {
                    String version = m.group(1);
            logger.debug("--> index [{}] is green, took [{}] ms", index, (System.currentTimeMillis() - startTime));
            Request createRepoRequest = new Request("PUT", "/_snapshot/repo");
                    randomBoolean(),
        }
            if (rarely()) {
                Request search = new Request("GET", "/" + index + "/_search");
            XContentBuilder mappingsAndSettings = jsonBuilder();
        client().performRequest(restoreRequest);
            recoveryRequest.addParameter("s", "index,shard,type");
                if (rarely()) {
                mappingsAndSettings.endObject();
                """);
    }
                assertThat(tasksCreatedVersionString, notNullValue());
                    flush(index, randomBoolean());
            mappingsAndSettings.endObject();
            ensureGreen(index); // wait for source index to be available on both nodes before starting shrink
    private void indexRandomDocuments(
            {
        return nodes;
                    assertThat(client().performRequest(getTasksIndex).getStatusLine().getStatusCode(), is(200));
        int histoCount = 0;
        }
        }
     * Tests that a single document survives. Super basic smoke test.
                client().performRequest(new Request("POST", "/" + index + "/_flush"));
     *  <li>Upgrade
        return Integer.parseInt(loadInfoDocument(index + "_count"));
    /**
        assertEquals("green", healthRsp.get("status"));
    private void indexDocument(String id) throws IOException {
            mappingsAndSettings.endObject();
    public void testSoftDeletes() throws Exception {
        if (isRunningAgainstOldCluster()) {
                assertThat("no history uuid found on " + nodeId + " (primary: " + primary + ")", historyUUID, notNullValue());
import org.opensearch.Version;
import org.opensearch.common.CheckedFunction;
        assertOK(client().performRequest(indexRequest));
                    if (currentLuceneVersion.equals(version)) {
                        templateBuilder.field("version", isRunningAgainstOldCluster() ? getOldClusterVersion() : Version.CURRENT);
            client().performRequest(createIndex);
                mappingsAndSettings.endObject();
        Request disableAutoRefresh = new Request("PUT", "/" + index + "/_settings");
        expectedTemplate.put("index_patterns", singletonList("evil_*"));
            createIndex.setJsonEntity(mappingsAndSettings.toString());
                final String tasksCreatedVersionString = tasksIndex.get("settings.index.version.created");
        final Map<String, ?> state = entityAsMap(client().performRequest(new Request("GET", "/_cluster/state")));
                if (rarely()) {
                ensureGreenLongWait(target);
            createTestIndex.setJsonEntity("{\"settings\": {\"index.number_of_replicas\": 0, \"index.number_of_shards\": 1}}");
            "derived_source (index.derived_source.enabled) is available from 3.3.0 onwards",
            restoreCommand.startObject("index_settings");
        assertThat(blocks, notNullValue());
        client().performRequest(new Request("POST", "/" + index + "/_refresh"));
import static org.hamcrest.Matchers.containsString;
    /**
                }
        templateBuilder.endObject();
        } else {
