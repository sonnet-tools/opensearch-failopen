        assertThat(
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        if (explicitWriteIndex) {
            assertThat(oldIndex.getRolloverInfos().size(), equalTo(0));
    public void testRolloverWithIndexSettingsBalancedWithUseZoneForReplicaDefaultCount() throws Exception {
 * KIND, either express or implied.  See the License for the
            appender.assertAllExpectationsMatched();
        assertAcked(prepareCreate("test-1").addAlias(new Alias("test_alias")).get());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertThat(response.getNewIndex(), equalTo("test_index-000002"));
        assertThat(response.getNewIndex(), equalTo("test_new_index"));
        assertThat(response.getNewIndex(), equalTo("test_index-000003"));
    public void testRolloverWithExplicitWriteIndex() throws Exception {
import org.opensearch.cluster.metadata.AutoExpandReplicas;
        }
        index("test_index-1", "type1", "1", "field", "value");
        final String indexNamePrefix = "test_index_hidden-";
        assertThat(response.isRolledOver(), equalTo(true));
        } else {
        }
        final String writeIndexPrefix = "write-index-";
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
            final IndexMetadata oldIndex = client().admin().cluster().prepareState().get().getState().metadata().index("test-1");
    public void testRolloverMaxSize() throws Exception {
        assertThat(response.getOldIndex(), equalTo("test_index-2"));
        );
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        final Settings settings = Settings.builder()
            assertFalse(oldIndex.getAliases().get("test_alias").writeIndex());
/*
        assertAcked(prepareCreate("test_index-2").addAlias(testAlias).get());
                .prepareRolloverIndex("test_alias")
        assertThat(oldIndex.getRolloverInfos().get("test_alias").getAlias(), equalTo("test_alias"));
            .indices()
        assertThat(response.getNewIndex(), equalTo("test-" + DateFormatter.forPattern("yyyy.MM.dd").format(now) + "-000004"));
                    "no related message logged on dry run",
            List<Condition<?>> metConditions = oldIndex.getRolloverInfos().get("test_alias").getMetConditions();
import org.opensearch.action.admin.indices.alias.Alias;
        refresh(aliasName);
        assertThat(response.getOldIndex(), equalTo("test_index-1"));
import org.opensearch.plugins.Plugin;
                    .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-1")
            .prepareRolloverIndex("test_alias")
        refresh();
        assertTrue(newIndex.getAliases().containsKey(aliasName));
                .prepareRolloverIndex("test_alias")
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
        try {
                    Level.INFO,
        assertThat(response.getNewIndex(), equalTo("test-" + DateFormatter.forPattern("yyyy.MM").format(now) + "-000002"));
            testAlias.writeIndex(true);
        assertEquals(
import org.opensearch.test.MockLogAppender;
        assertThat(response.getConditionStatus().values(), everyItem(is(false)));
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * this work for additional information regarding copyright
        assertThat(newIndex.getNumberOfShards(), equalTo(1));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
public class RolloverIT extends OpenSearchIntegTestCase {
import java.util.List;
        manageReplicaSettingForDefaultReplica(true);
            .prepareUpdateSettings(index)
        index("test_index-000001", "type1", "1", "field", "value");
        final String openNonwriteIndex = "open-index-nonwrite";
    }
        );
        index(aliasName, SINGLE_MAPPING_NAME, null, "{\"foo\": \"bar\"}");
        {
                .addMaxIndexSizeCondition(new ByteSizeValue(randomIntBetween(100, 50 * 1024), ByteSizeUnit.MB))
                    Settings.builder()
        final String aliasName = "test_alias";
        assertTrue(newIndex.getAliases().containsKey("test_alias"));
            .indices()
            long beforeTime = client().threadPool().absoluteTimeInMillis() - 1000L;
import org.opensearch.core.common.unit.ByteSizeValue;
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        final RolloverResponse response = client().admin()
        }
        }
        long beforeTime = client().threadPool().absoluteTimeInMillis() - 1000L;
        index("test_index", "type1", "1", "field", "value");
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequestBuilder;
        assertThat(response.getConditionStatus().size(), equalTo(0));
        } catch (ResourceAlreadyExistsException e) {
 * license agreements. See the NOTICE file distributed with
        assertAcked(prepareCreate("test_index-0").addAlias(testAlias).get());
            assertFalse(oldIndex.getAliases().get("test_alias").writeIndex());
            .waitForActiveShards(0)
    public void testRolloverConditionsNotMet() throws Exception {
        assertFalse(oldIndex.getAliases().containsKey("test_alias"));
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
 */
            conditions,
        index("test_index-2", "type1", "1", "field", "value");
                .addMaxIndexSizeCondition(new ByteSizeValue(randomNonNegativeLong(), ByteSizeUnit.BYTES))
        assertThat(response.isDryRun(), equalTo(false));
        }
        final IndexMetadata oldIndex = state.metadata().index("test_index-2");
        flush("test_index-2");
import org.opensearch.test.InternalSettingsPlugin;
    public void testRolloverWithNoWriteIndex() {
            assertTrue(oldIndex.getAliases().containsKey("test_alias"));
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        ensureGreen();
            testAlias.writeIndex(true);
        final IndexMetadata oldIndex = state.metadata().index("test_index-1");
        assertThat(response.isRolledOver(), equalTo(true));
            assertThat(response.getNewIndex(), equalTo("test-000003"));
    }
            assertThat(response.getNewIndex(), equalTo("test-000002"));
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
    public void testRolloverWithIndexSettingsBalancedReplica() throws Exception {
    }
                .addMaxIndexSizeCondition(maxSizeValue)
import static org.hamcrest.Matchers.containsInAnyOrder;
        assertThat(response.isDryRun(), equalTo(false));
            ByteSizeValue maxSizeValue = new ByteSizeValue(randomIntBetween(1, 20), ByteSizeUnit.BYTES);
        assertTrue(newIndex.getAliases().get(aliasName).isHidden());
 *
            assertThat(oldIndex.getRolloverInfos().size(), equalTo(0));
        if (explicitWriteIndex) {
        assertThat(
            testAlias.writeIndex(true);
        Alias testAlias = new Alias("test_alias");
                .prepareRolloverIndex("test_alias")
        assertAcked(prepareCreate("test_index-1").addAlias(new Alias("test_alias")).get());
        final RolloverResponse response = client().admin().indices().prepareRolloverIndex("test_alias").get();
    public void testRolloverWithClosedIndexInAlias() throws Exception {
                oldIndex.getRolloverInfos().get("test_alias").getTime(),
                .setOrder(-1)
        assertTrue(newIndex.getAliases().containsKey("test_alias"));
            assertThat("Should rollover with a small max_size condition", response.isRolledOver(), equalTo(true));
                new MockLogAppender.UnseenEventExpectation(
        index("test_index-0", "type1", "1", "field", "value");
        assertThat(response.isDryRun(), equalTo(true));
        );
        client().admin()
            .settings(settings)
        boolean explicitWriteIndex = randomBoolean();
            .indices()
            .alias(new Alias("extra_alias"))
        Alias testAlias = new Alias("test_alias");
    public void testRolloverOnExistingIndex() throws Exception {
        );
                .indices()
        boolean explicitWriteIndex = randomBoolean();
    public void testRolloverOnEmptyIndex() throws Exception {
        }
            index("test-1", "doc", Integer.toString(i), "field", "foo-" + i);
            final IndexMetadata oldIndex = client().admin().cluster().prepareState().get().getState().metadata().index("test-1");
        assertThat(response.isDryRun(), equalTo(false));
        }
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
    public void testRolloverWithHiddenAliasesAndExplicitWriteIndex() {
import static org.opensearch.index.mapper.MapperService.SINGLE_MAPPING_NAME;
        flush("test_index-0");
        assertThat(
            is(both(greaterThanOrEqualTo(beforeTime)).and(lessThanOrEqualTo(client().threadPool().absoluteTimeInMillis() + 1000L)))
            getSettingsResponse.getSetting(response.getOldIndex(), IndexMetadata.SETTING_INDEX_PROVIDED_NAME)
    }
        Alias testAlias = new Alias("test_alias");
            .get();
        );
        assumeTrue("only works on the same day", now.plusMinutes(5).getDayOfYear() == now.getDayOfYear());
    public void testRolloverWithDateMath() {
        );
        client().admin()
        assertThat(response.getOldIndex(), equalTo("test_index-0"));
            .get();
        assertThat(oldIndex.getRolloverInfos().get("test_alias").getMetConditions(), is(empty()));
        assertThat(response.getNewIndex(), equalTo("test-" + DateFormatter.forPattern("yyyy.MM").format(now) + "-000003"));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertTrue(oldIndex.getAliases().get(aliasName).isHidden());
            "<test-{now/M{yyyy.MM}}-000003>",
                    .build()
        assertThat(response.isRolledOver(), equalTo(false));
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(oldIndex.getRolloverInfos().get(aliasName).getAlias(), equalTo(aliasName));
        response = client().admin().indices().prepareRolloverIndex("test_alias").setNewIndexName("<test-{now/d}-000004>").get();
            .indices()
            .indices()
        assertAcked(prepareCreate("test_index").addAlias(testAlias).get());
        final String secondIndexName = indexNamePrefix + "000002";
        assertThat(response.getNewIndex(), equalTo("test_index-000003"));
        assertEquals(writeIndexPrefix + "000001", rolloverResponse.getOldIndex());
        );
        assertThat(response.getNewIndex(), equalTo(secondIndexName));
            oldIndex.getRolloverInfos().get("test_alias").getTime(),
import org.opensearch.common.settings.Settings;
                new MaxSizeCondition(new ByteSizeValue(10, ByteSizeUnit.MB)).toString(),
        assertEquals(writeIndexPrefix + "000002", rolloverResponse.getNewIndex());
        assertThat(response.isDryRun(), equalTo(false));
        assertAcked(prepareCreate("test_index-2").addAlias(new Alias("test_alias")).get());
        assertAcked(prepareCreate("test_index-2").addAlias(testAlias).get());
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).build();
        boolean explicitWriteIndex = randomBoolean();
        assertTrue(newIndex.getAliases().containsKey(aliasName));
        );
import java.util.Collections;
        final IndexMetadata oldIndex = state.metadata().index("test_index");
        flush("test-1");
        assertAcked(prepareCreate(closedIndex).addAlias(new Alias(aliasName)).get());
 */
        ensureGreen(index);
import org.apache.logging.log4j.Logger;
        boolean explicitWriteIndex = randomBoolean();
        ensureGreen(aliasName);
                .get();
import static org.hamcrest.Matchers.everyItem;
        if (randomBoolean()) {
        if (explicitWriteIndex) {
        assertAcked(client().admin().indices().prepareCreate("logs-000001").get());
        boolean explicitWriteIndex = randomBoolean();
            );
import java.time.ZonedDateTime;
        assertThat(response.getConditionStatus().size(), equalTo(0));
        assertThat(oldIndex.getRolloverInfos().get("test_alias").getMetConditions(), is(empty()));
        assertThat(response.getOldIndex(), equalTo("test_index"));
        final String indexNamePrefix = "test_index_hidden-";
        if (explicitWriteIndex) {
            )
        assertThat(response.isRolledOver(), equalTo(true));
        assertThat(oldIndex.getRolloverInfos().get("test_alias").getAlias(), equalTo("test_alias"));
            assertFalse(oldIndex.getAliases().containsKey("test_alias"));
        assertAcked(client().admin().indices().prepareClose(closedIndex).get());
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/64921")
        assertThat(oldIndex.getRolloverInfos().size(), equalTo(1));
        assertAcked(prepareCreate(firstIndexName).addAlias(new Alias(aliasName).isHidden(true)).get());
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
            assertThat(e.getIndex().getName(), equalTo("test_index-000001"));
            )
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.Matchers.nullValue;
        client().admin().indices().prepareOpen(index).get();
                Settings.builder()
        );
        assertThat(response.getConditionStatus().size(), equalTo(0));
 *
        String index = "test-" + DateFormatter.forPattern("yyyy.MM.dd").format(now) + "-1";
        flush("test_index-2");
        assertThat(response.isRolledOver(), equalTo(true));
        boolean explicitWriteIndex = randomBoolean();
        assertThat(newIndex.getNumberOfReplicas(), equalTo(0));
        flush("test_index-2");
        {
            .prepareRolloverIndex("test_alias")
        final IndexMetadata newIndex = state.metadata().index("test_index-000003");
import java.util.Set;
        final RolloverResponse response = client().admin().indices().prepareRolloverIndex(aliasName).get();
    }
        }
    public void testRollover() throws Exception {
        return Collections.singleton(InternalSettingsPlugin.class);
    }
        RolloverResponse rolloverResponse = client().admin().indices().prepareRolloverIndex(aliasName).addMaxIndexDocsCondition(1).get();
}
            assertFalse(oldIndex.getAliases().containsKey("test_alias"));
            testAlias.writeIndex(true);
import static org.hamcrest.Matchers.equalTo;
            error.getMessage(),
            IllegalArgumentException.class,
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        flush("test_index-2");
                    "*test_index*"
            assertFalse(oldIndex.getAliases().get("test_alias").writeIndex());
        }
            .get();
            .indices()
        if (explicitWriteIndex) {
            oldIndex.getRolloverInfos().get(aliasName).getTime(),
    @Override
        final IndexMetadata oldIndex = state.metadata().index(firstIndexName);
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        assertThat(response.getOldIndex(), equalTo("test-" + DateFormatter.forPattern("yyyy.MM").format(now) + "-000003"));
        long beforeTime = client().threadPool().absoluteTimeInMillis() - 1000L;
        final IndexMetadata newIndex = state.metadata().index("test_index-000003");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final IndexMetadata oldIndex = state.metadata().index("test_index-1");
        assertThat(response.getConditionStatus().size(), equalTo(0));
        }
        assertThat(
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
        {
        assertThat(response.isDryRun(), equalTo(false));
        Set<String> conditions = response.getConditionStatus().keySet();
            getSettingsResponse.getSetting(response.getNewIndex(), IndexMetadata.SETTING_INDEX_PROVIDED_NAME)
            )
        assertThat(response.isRolledOver(), equalTo(true));
            .alias(new Alias("extra_alias"))
        assertThat(oldIndex.getRolloverInfos().get(aliasName).getMetConditions(), is(empty()));
        assertThat(response.isDryRun(), equalTo(false));
        assertAcked(prepareCreate(dateMathExp).addAlias(new Alias("test_alias")).get());
        assertAcked(prepareCreate(closedIndex).addAlias(new Alias(aliasName)).get());
        assertThat(response.isRolledOver(), equalTo(true));
package org.opensearch.action.admin.indices.rollover;
            .indices()
    }
            assertThat(response.getOldIndex(), equalTo("test-1"));
            assertTrue(newIndex.getAliases().get("test_alias").writeIndex());
            .alias(new Alias("extra_alias"))
        final RolloverResponse response = client().admin().indices().prepareRolloverIndex(aliasName).get();
            .indices()
        final Settings settings = Settings.builder()
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        index("test_index-2", "type1", "1", "field", "value");
        Alias testAlias = new Alias("test_alias");
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            is(both(greaterThanOrEqualTo(beforeTime)).and(lessThanOrEqualTo(client().threadPool().absoluteTimeInMillis() + 1000L)))
        final String writeIndexPrefix = "write-index-";
        final String firstIndexName = indexNamePrefix + "000001";
                .get();
        refresh();
        }
            .prepareRolloverIndex("test_alias")
    }
        flush("test_index");
            fail("expected failure due to existing rollover index");
        assertThat(response.getNewIndex(), equalTo("test_index-000003"));
            .get();
                        .build()
        assertAcked(client().admin().indices().prepareClose(closedIndex).get());
        index(closedIndex, SINGLE_MAPPING_NAME, null, "{\"foo\": \"bar\"}");
        refresh(aliasName);
            .indices()
        // An empty index
        long beforeTime = client().threadPool().absoluteTimeInMillis() - 1000L;
            final RolloverResponse response = client().admin()
                .preparePutTemplate("test_index")
import static org.hamcrest.collection.IsEmptyCollection.empty;
 * You may obtain a copy of the License at
        }
            containsString("expected max cap on auto expand to be a multiple of total awareness attributes [2]")
        final IndexMetadata newIndex = state.metadata().index("test_index-000003");
        assertThat(newIndex.getAliases().get(aliasName).writeIndex(), nullValue());
        final IndexMetadata newIndex = state.metadata().index(secondIndexName);
            final RolloverResponse response = client().admin()
        if (explicitWriteIndex) {
    }
            testAlias.writeIndex(true);
            .indices()
import org.opensearch.cluster.metadata.IndexMetadata;
            assertTrue(newIndex.getAliases().get("test_alias").writeIndex());
        final RolloverResponse response = client().admin()
        assertTrue(oldIndex.getAliases().containsKey("test_alias"));
            )
        final IndexMetadata newIndex = state.metadata().index("test_index-000003");
            .get();
        assertTrue(newIndex.getAliases().containsKey("extra_alias"));
        assertThat(
            equalTo(
        index(aliasName, SINGLE_MAPPING_NAME, null, "{\"foo\": \"bar\"}");
            testAlias.writeIndex(true);
        boolean explicitWriteIndex = randomBoolean();
        flush("test_index-1");
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
            assertThat("No rollover with an empty index", response.isRolledOver(), equalTo(false));
        } else {
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
 *
    }
        );
        for (int i = 0; i < numDocs; i++) {
        assertThat(oldIndex.getRolloverInfos().size(), equalTo(1));
        } else {
        final RolloverResponse response;
            () -> client().admin().indices().prepareRolloverIndex("test_alias").settings(settings).alias(new Alias("extra_alias")).get()
        if (explicitWriteIndex) {
    }
import java.time.ZoneOffset;
                .prepareRolloverIndex("test_alias")
        assertThat(newIndex.getNumberOfReplicas(), equalTo(0));
        assertThat(response.getConditionStatus().size(), equalTo(0));
        assertThat(response.getOldIndex(), equalTo(firstIndexName));
        int numDocs = randomIntBetween(10, 20);
        assertThat(response.getNewIndex(), equalTo("test_index-000003"));
        final String aliasName = "alias";
 * Unless required by applicable law or agreed to in writing,
            .addMaxIndexAgeCondition(TimeValue.timeValueHours(4))
        assertThat(response.getOldIndex(), equalTo("test-" + DateFormatter.forPattern("yyyy.MM").format(now) + "-000002"));
        }
        }
        final RolloverResponse response = client().admin().indices().prepareRolloverIndex("test_alias").get();
            .setPatterns(Collections.singletonList("logs-*"))
    public void testRolloverWithIndexSettingsWithoutPrefix() throws Exception {
import static org.hamcrest.Matchers.is;
            () -> client().admin()
        ensureYellow("logs-write");
        GetSettingsResponse getSettingsResponse = client().admin()
        assertThat(newIndex.getNumberOfReplicas(), equalTo(2));
        }
        Boolean firstIsWriteIndex = randomFrom(false, null);
        final IndexMetadata newIndex = state.metadata().index("test_index-000001");
            .waitForActiveShards(0)
        final IndexMetadata newIndex = state.metadata().index(secondIndexName);
                    .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-all")
        final String aliasName = "test_alias";
        assertThat(
                .indices()
        assertThat(response.getNewIndex(), equalTo(secondIndexName));
        assertThat(response.getConditionStatus().size(), equalTo(0));
import org.opensearch.common.time.DateFormatter;
        assertThat(
        assertFalse(oldIndex.getAliases().get("test_alias").writeIndex());
        if (explicitWriteIndex) {
 * not use this file except in compliance with the License.
            .addMaxIndexSizeCondition(new ByteSizeValue(10, ByteSizeUnit.MB))
        client().admin()
        );
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Alias testAlias = new Alias("test_alias");
        assertThat(response.getConditionStatus().size(), equalTo(0));
            assertFalse(oldIndex.getAliases().get("test_alias").writeIndex());
        assertTrue(rolloverResponse.isRolledOver());
        assertThat(oldIndex.getRolloverInfos().get(aliasName).getAlias(), equalTo(aliasName));
 * specific language governing permissions and limitations
        assertTrue(newIndex.getAliases().get(aliasName).isHidden());
            assertThat(metConditions.size(), equalTo(1));
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequestBuilder;
        assertThat(response.isDryRun(), equalTo(false));
 * ownership. Elasticsearch licenses this file to you under
        assertThat(response.isRolledOver(), equalTo(true));
        final IndexMetadata oldIndex = state.metadata().index("test_index-0");
        manageReplicaBalanceSetting(true);
        assertThat(response.getNewIndex(), equalTo("test_index-000001"));
        DeleteIndexTemplateRequestBuilder deleteTemplate = client().admin().indices().prepareDeleteTemplate("random_index_template");
        assertThat(response.getConditionStatus().size(), equalTo(0));
            client().admin().indices().prepareRolloverIndex("test_alias").get();
        assertAcked(prepareCreate("test_index-2").addAlias(testAlias).get());
        IllegalArgumentException exception = expectThrows(
                Settings.builder()
        assertThat(response.getOldIndex(), equalTo("test_index-2"));
    }
        assertThat(newIndex.getNumberOfShards(), equalTo(1));
        assertTrue(newIndex.getAliases().containsKey("test_alias"));
        assertThat(oldIndex.getRolloverInfos().size(), equalTo(1));
        final String openNonwriteIndex = "open-index-nonwrite";
        assertAcked(prepareCreate("test_index-1").addAlias(testAlias).get());
        final RolloverResponse response = client().admin()
    public void testRejectIfAliasFoundInTemplate() throws Exception {
        assertTrue(oldIndex.getAliases().containsKey(aliasName));
            .prepareGetSettings(response.getOldIndex(), response.getNewIndex())
        final String aliasName = "alias";
        final String closedIndex = "closed-index-nonwrite";
    }
        }
 * software distributed under the License is distributed on an
        ensureGreen(index);
            .settings(
        assertThat(oldIndex.getRolloverInfos().size(), equalTo(1));
        assertAcked(prepareCreate(firstIndexName).addAlias(new Alias(aliasName).writeIndex(true).isHidden(true)).get());
            assertThat("No rollover with a large max_size condition", response.isRolledOver(), equalTo(false));
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        client().admin()
        assertAcked(client().admin().indices().prepareClose(writeIndexPrefix + "000001").get());
        );
        Alias testAlias = new Alias("test_alias");
    }
        if (firstIsWriteIndex == null) {
        } else {
        final IllegalArgumentException restoreError2 = expectThrows(
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertTrue(newIndex.getAliases().containsKey("test_alias"));
    }
            .addAlias(new Alias("logs-write"))
        assertTrue(newIndex.getAliases().get(aliasName).writeIndex());
        assertNull(newIndex);
        assertEquals(
        assertThat(response.isDryRun(), equalTo(false));
        assertFalse(oldIndex.getAliases().containsKey(aliasName));
        final IndexMetadata newIndex = state.metadata().index("test_index-000003");
            .get();
        final String secondIndexName = indexNamePrefix + "000002";
        index("test_index-2", "type1", "1", "field", "value");
import org.opensearch.common.unit.TimeValue;
            .build();
        assertNull(newIndex);
        flush("test_index-2");
                    .build()
        assertThat(response.getConditionStatus().size(), equalTo(0));
        final IndexMetadata oldIndex = state.metadata().index("test_index-2");
        final Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
 * Licensed to Elasticsearch under one or more contributor
        assertThat(response.isRolledOver(), equalTo(true));
            assertAcked(prepareCreate("index2").addAlias(new Alias("alias").writeIndex(randomFrom(false, null))).get());
import static org.hamcrest.Matchers.containsString;
    public void testRolloverWithClosedWriteIndex() throws Exception {
        flush("test_index-0", "test_index-000001");
        assertTrue(newIndex.getAliases().containsKey("test_alias"));
                .indices()
/*
        if (explicitWriteIndex) {
            "<test-{now/M{yyyy.MM}}-000002>",
        RolloverResponse response = client().admin().indices().prepareRolloverIndex("test_alias").get();
            appender.addExpectation(
            oldIndex.getRolloverInfos().get("test_alias").getTime(),
            .alias(new Alias("extra_alias"))
            .prepareRolloverIndex("test_alias")
                new MaxAgeCondition(TimeValue.timeValueHours(4)).toString()
                )
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_INDEX_PROVIDED_NAME, "<test-{now/M{yyyy.MM}}-1>"))
        );
        flush("test_index-2");
        manageReplicaBalanceSetting(false);
            .settings(
        assertThat(response.getOldIndex(), equalTo("test_index-2"));
import org.apache.logging.log4j.Level;
        assertAcked(prepareCreate(openNonwriteIndex).addAlias(new Alias(aliasName)).get());
        assertThat(response.isRolledOver(), equalTo(false));
        assertTrue(newIndex.getAliases().containsKey("test_alias"));
    public void testRolloverWithHiddenAliasesAndImplicitWriteIndex() {
import java.util.Collection;
                .setPatterns(Collections.singletonList("test_index-*"))
        assertThat(response.isRolledOver(), equalTo(true));
        // A large max_size
            restoreError2.getMessage(),
        assertFalse(oldIndex.getAliases().get(aliasName).writeIndex());
                .get()
import org.opensearch.cluster.routing.allocation.AllocationService;
            .prepareRolloverIndex("test_alias")
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        assertAcked(prepareCreate(writeIndexPrefix + "000001").addAlias(new Alias(aliasName).writeIndex(true)).get());
        assertTrue(rolloverResponse.isRolledOver());
        final IndexMetadata oldIndex = state.metadata().index("test_index-2");
        index(aliasName, SINGLE_MAPPING_NAME, "1", "field", "value");
        String dateMathExp = "<test-{now/d}-1>";
            IllegalArgumentException.class,
        assertThat(response.isRolledOver(), equalTo(true));
            assertThat(response.getOldIndex(), equalTo("test-1"));
            assertAcked(putTemplate.get());
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
                .alias(new Alias("extra_alias"))
        index("test_index-2", "type1", "1", "field", "value");
        assertTrue(newIndex.getAliases().containsKey("extra_alias"));
            )
import org.opensearch.ResourceAlreadyExistsException;
        final IndexMetadata newIndex = state.metadata().index("test_new_index");
            assertNull(oldIndex.getAliases().get("test_alias").writeIndex());
import org.apache.logging.log4j.LogManager;
            is(both(greaterThanOrEqualTo(beforeTime)).and(lessThanOrEqualTo(client().threadPool().absoluteTimeInMillis() + 1000L)))
        response = client().admin().indices().prepareRolloverIndex("test_alias").get();
        assertThat(response.getOldIndex(), equalTo(firstIndexName));
        assertThat(response.getConditionStatus().size(), equalTo(2));
        final RolloverResponse response = client().admin().indices().prepareRolloverIndex("test_alias").get();
                .get();
        assertThat(response.isRolledOver(), equalTo(true));
        assertEquals(writeIndexPrefix + "000002", rolloverResponse.getNewIndex());
        assertThat(oldIndex.getRolloverInfos().get(aliasName).getMetConditions(), is(empty()));
        assertAcked(deleteTemplate.execute().actionGet());
            containsInAnyOrder(
 * SPDX-License-Identifier: Apache-2.0
        assertThat(response.getOldIndex(), equalTo("test_index-1"));
            .prepareRolloverIndex("test_alias")
                )
            .waitForActiveShards(0)
                        .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-0")
        final IllegalArgumentException error = expectThrows(
        client().admin()
                .indices()
        final IndexMetadata newIndex = state.metadata().index("test_index-000002");
        assertTrue(oldIndex.getAliases().containsKey("test_alias"));
        assertThat(response.getConditionStatus().size(), equalTo(0));
                    AllocationService.class.getName(),
        assertAcked(prepareCreate(openNonwriteIndex).addAlias(new Alias(aliasName)).get());
        final RolloverResponse response = client().admin()
    public void testRolloverWithIndexSettings() throws Exception {
            final IndexMetadata oldIndex = client().admin().cluster().prepareState().get().getState().metadata().index("test-000002");
        Alias testAlias = new Alias("test_alias");
        index(aliasName, SINGLE_MAPPING_NAME, "1", "field", "value");
        }
                .settings(
            IllegalArgumentException.class,
        index("test_index-2", "type1", "1", "field", "value");
/*
        assertTrue(oldIndex.getAliases().containsKey("test_alias"));
 * GitHub history for details.
        final IndexMetadata oldIndex = state.metadata().index(firstIndexName);
            assertFalse(oldIndex.getAliases().containsKey("test_alias"));
            assertTrue(newIndex.getAliases().get("test_alias").writeIndex());
        assertThat(response.getOldIndex(), equalTo("test_index-2"));
        assertAcked(prepareCreate("index1").addAlias(new Alias("alias").writeIndex(firstIsWriteIndex)).get());
            assertThat(
        manageReplicaSettingForDefaultReplica(false);
            assertTrue(oldIndex.getAliases().get("test_alias").writeIndex());
            .get();
        assertThat(exception.getMessage(), equalTo("rollover target [alias] does not point to a write index"));
 */
        long beforeTime = client().threadPool().absoluteTimeInMillis() - 1000L;
        assertThat(response.getNewIndex(), equalTo("test_index-000002"));
            .preparePutTemplate("logs")
    }
 * compatible open source license.
            containsString("expected total copies needs to be a multiple of total awareness attributes [2]")
            () -> client().admin().indices().prepareRolloverIndex("logs-write").addMaxIndexSizeCondition(new ByteSizeValue(1)).get()
        assertThat(response.getConditionStatus().size(), equalTo(0));
            );
        assertTrue(newIndex.getAliases().get("test_alias").writeIndex());
        final IndexMetadata newIndex = state.metadata().index("test_index-000002");
        RolloverResponse rolloverResponse = client().admin().indices().prepareRolloverIndex(aliasName).addMaxIndexDocsCondition(1).get();
            .settings(settings)
            assertFalse(oldIndex.getAliases().containsKey("test_alias"));
        index(aliasName, SINGLE_MAPPING_NAME, null, "{\"foo\": \"bar\"}");
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(response.getOldIndex(), equalTo("test-000002"));
        Logger allocationServiceLogger = LogManager.getLogger(AllocationService.class);
            assertThat(metConditions.get(0).toString(), equalTo(new MaxSizeCondition(maxSizeValue).toString()));
 * The OpenSearch Contributors require contributions made to
        index("test_index-2", "_doc", "1", "field", "value");
        final String closedIndex = "closed-index-nonwrite";
    }
            response = client().admin().indices().prepareRolloverIndex("test_alias").dryRun(true).get();
        assertThat(newIndex.getNumberOfShards(), equalTo(3));
            PutIndexTemplateRequestBuilder putTemplate = client().admin()
        try (MockLogAppender appender = MockLogAppender.createForLoggers(allocationServiceLogger)) {
        if (explicitWriteIndex) {
 * under the License.
                "Rollover alias [logs-write] can point to multiple indices, found duplicated alias [[logs-write]] in index template [logs]"
            .get();
            IllegalArgumentException.class,
        // A small max_size
        final String firstIndexName = indexNamePrefix + "000001";
        assertThat(response.isDryRun(), equalTo(false));
        assertThat(response.isDryRun(), equalTo(false));
            .setNewIndexName("test_new_index")
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
    }
        client().admin().indices().prepareClose(index).get();
        assertEquals(writeIndexPrefix + "000001", rolloverResponse.getOldIndex());
        assertThat(response.getConditionStatus().size(), equalTo(0));
            .get();
            assertThat(response.getNewIndex(), equalTo("test-000002"));
            restoreError.getMessage(),
            testAlias.writeIndex(true);
            .build();
import org.opensearch.cluster.ClusterState;
        index(aliasName, SINGLE_MAPPING_NAME, null, "{\"foo\": \"bar\"}");
        assertThat(response.isDryRun(), equalTo(false));
        assertThat(response.isDryRun(), equalTo(false));
        } else {
            final RolloverResponse response = client().admin()
        client().admin().indices().prepareRolloverIndex("test_alias").settings(settings).alias(new Alias("extra_alias")).get();
        if (explicitWriteIndex) {
 * this file be licensed under the Apache-2.0 license or a
            .alias(new Alias("extra_alias"))
            .get();
        assertThat(
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
                is(both(greaterThanOrEqualTo(beforeTime)).and(lessThanOrEqualTo(client().threadPool().absoluteTimeInMillis() + 1000L)))
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (explicitWriteIndex) {
        assertAcked(prepareCreate("test_index-000001").get());
        assertAcked(prepareCreate(writeIndexPrefix + "000001").addAlias(new Alias(aliasName).writeIndex(true)).get());
            .prepareRolloverIndex("test_alias")
            () -> client().admin().indices().prepareRolloverIndex("alias").dryRun(randomBoolean()).get()
        }
        randomIndexTemplate();
        // now we modify the provided name such that we can test that the pattern is carried on
    public void testRolloverWithNewIndexName() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        final IndexMetadata oldIndex = state.metadata().index("test_index-2");
            oldIndex.getRolloverInfos().get(aliasName).getTime(),
import org.opensearch.test.OpenSearchIntegTestCase;
            .settings(
        index(closedIndex, SINGLE_MAPPING_NAME, null, "{\"foo\": \"bar\"}");
        assertAcked(prepareCreate("test_index-0").addAlias(new Alias("test_alias")).get());
        }
        assertAcked(prepareCreate("test_index-2").addAlias(testAlias).get());
                .indices()
        final IllegalArgumentException restoreError = expectThrows(
        );
            is(both(greaterThanOrEqualTo(beforeTime)).and(lessThanOrEqualTo(client().threadPool().absoluteTimeInMillis() + 1000L)))
                .setSettings(Settings.builder().put(AutoExpandReplicas.SETTING.getKey(), "0-all"));
        refresh("test_alias");
        index("test_index-0", "type1", "1", "field", "value");
        assertThat(response.getOldIndex(), equalTo(index));
        assertAcked(prepareCreate("test_index-2").addAlias(new Alias("test_alias").writeIndex(true)).get());
    public void testRolloverDryRun() throws Exception {
