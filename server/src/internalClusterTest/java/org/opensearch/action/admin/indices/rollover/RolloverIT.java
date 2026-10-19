            assertThat(response.getNewIndex(), equalTo("test-000002"));
        assertThat(oldIndex.getRolloverInfos().get("test_alias").getAlias(), equalTo("test_alias"));  
    public void testRejectIfAliasFoundInTemplate() throws Exception {
        assertThat(response.getNewIndex(), equalTo("test_index-000002"));
        client().admin().indices().prepareOpen(index).get();
        RolloverResponse rolloverResponse = client().admin().indices().prepareRolloverIndex(aliasName).addMaxIndexDocsCondition(1).get();
                    .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-all")  
/*  
        final IndexMetadata newIndex = state.metadata().index("test_new_index");
        final String openNonwriteIndex = "open-index-nonwrite";  
            appender.assertAllExpectationsMatched();
        );
                "Rollover alias [logs-write] can point to multiple indices, found duplicated alias [[logs-write]] in index template [logs]"  
        final ClusterState state = client().admin().cluster().prepareState().get().getState();  
            assertAcked(putTemplate.get());
        assertThat(response.isDryRun(), equalTo(false));
        );
    public void testRolloverWithClosedWriteIndex() throws Exception {
            .prepareRolloverIndex("test_alias")  
import static org.hamcrest.Matchers.containsInAnyOrder;
                        .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-0")
 * You may obtain a copy of the License at  
        assertThat(oldIndex.getRolloverInfos().get(aliasName).getMetConditions(), is(empty()));  
        assertThat(response.getNewIndex(), equalTo("test_index-000003"));
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        RolloverResponse response = client().admin().indices().prepareRolloverIndex("test_alias").get();  
        RolloverResponse rolloverResponse = client().admin().indices().prepareRolloverIndex(aliasName).addMaxIndexDocsCondition(1).get();
        final RolloverResponse response = client().admin()
        assertThat(
        assertThat(exception.getMessage(), equalTo("rollover target [alias] does not point to a write index"));  
            IllegalArgumentException.class,  
    public void testRolloverWithIndexSettingsBalancedReplica() throws Exception {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        Alias testAlias = new Alias("test_alias");
        Boolean firstIsWriteIndex = randomFrom(false, null);  
            List<Condition<?>> metConditions = oldIndex.getRolloverInfos().get("test_alias").getMetConditions();
        try (MockLogAppender appender = MockLogAppender.createForLoggers(allocationServiceLogger)) {
        assertThat(response.getOldIndex(), equalTo("test_index-2"));
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)  
        final IndexMetadata newIndex = state.metadata().index("test_index-000003");
        assertFalse(oldIndex.getAliases().get(aliasName).writeIndex());  
        assertThat(response.isDryRun(), equalTo(false));
            .get();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            final IndexMetadata oldIndex = client().admin().cluster().prepareState().get().getState().metadata().index("test-1");
            );  
        assertAcked(prepareCreate(firstIndexName).addAlias(new Alias(aliasName).isHidden(true)).get());  
                .get();
        assertThat(oldIndex.getRolloverInfos().size(), equalTo(1));
 */
                    Level.INFO,  
        assertThat(
import java.util.Collections;
    public void testRolloverOnEmptyIndex() throws Exception {  
        assertThat(newIndex.getNumberOfShards(), equalTo(1));
                .get();  
            )  
        ensureYellow("logs-write");
        final String closedIndex = "closed-index-nonwrite";
        final IndexMetadata oldIndex = state.metadata().index("test_index-2");
            .get();
        assertThat(oldIndex.getRolloverInfos().get(aliasName).getAlias(), equalTo(aliasName));  
        assertThat(response.getOldIndex(), equalTo("test_index"));  
            testAlias.writeIndex(true);
        assertTrue(newIndex.getAliases().containsKey("test_alias"));  
        assertAcked(prepareCreate(closedIndex).addAlias(new Alias(aliasName)).get());
            assertTrue(newIndex.getAliases().get("test_alias").writeIndex());
        assertThat(
        final IndexMetadata oldIndex = state.metadata().index("test_index-2");
            .indices()  
            IllegalArgumentException.class,  
        index(aliasName, SINGLE_MAPPING_NAME, "1", "field", "value");  
        assertThat(response.getNewIndex(), equalTo("test-" + DateFormatter.forPattern("yyyy.MM").format(now) + "-000003"));  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertThat(response.isRolledOver(), equalTo(true));
        final IndexMetadata newIndex = state.metadata().index(secondIndexName);  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)  
        final String firstIndexName = indexNamePrefix + "000001";
    public void testRolloverWithExplicitWriteIndex() throws Exception {
        flush("test_index-1");
            .settings(  
        assertThat(newIndex.getNumberOfShards(), equalTo(3));
        );  
    }
        final String writeIndexPrefix = "write-index-";
                new MockLogAppender.UnseenEventExpectation(  
        assertThat(response.getOldIndex(), equalTo("test-" + DateFormatter.forPattern("yyyy.MM").format(now) + "-000002"));
        assertEquals(
        assertThat(response.getNewIndex(), equalTo("test-" + DateFormatter.forPattern("yyyy.MM").format(now) + "-000002"));
 *    http://www.apache.org/licenses/LICENSE-2.0
            fail("expected failure due to existing rollover index");
        client().admin()  
        flush("test_index");  
import org.opensearch.core.common.unit.ByteSizeUnit;
        {  
        assertNull(newIndex);
    }
        client().admin().indices().prepareClose(index).get();  
        assertAcked(prepareCreate("test_index").addAlias(testAlias).get());
        assertAcked(prepareCreate(writeIndexPrefix + "000001").addAlias(new Alias(aliasName).writeIndex(true)).get());
            getSettingsResponse.getSetting(response.getOldIndex(), IndexMetadata.SETTING_INDEX_PROVIDED_NAME)
        assertEquals(writeIndexPrefix + "000001", rolloverResponse.getOldIndex());  
            assertThat(response.getNewIndex(), equalTo("test-000002"));
        flush("test_index-2");
        assertAcked(prepareCreate("test_index-000001").get());
        assertThat(response.getNewIndex(), equalTo(secondIndexName));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Set<String> conditions = response.getConditionStatus().keySet();
        Alias testAlias = new Alias("test_alias");  
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        assertThat(response.getConditionStatus().size(), equalTo(0));
 * the Apache License, Version 2.0 (the "License"); you may
        DeleteIndexTemplateRequestBuilder deleteTemplate = client().admin().indices().prepareDeleteTemplate("random_index_template");
 * Modifications Copyright OpenSearch Contributors. See
        client().admin()  
        assertThat(response.getConditionStatus().size(), equalTo(0));
                .alias(new Alias("extra_alias"))
            .indices()
        assertAcked(client().admin().indices().prepareClose(writeIndexPrefix + "000001").get());
 * under the License.  
        final IllegalArgumentException restoreError = expectThrows(
        }
                Settings.builder()  
            IllegalArgumentException.class,
                .preparePutTemplate("test_index")  
                .addMaxIndexSizeCondition(new ByteSizeValue(randomIntBetween(100, 50 * 1024), ByteSizeUnit.MB))
            containsString("expected total copies needs to be a multiple of total awareness attributes [2]")
        boolean explicitWriteIndex = randomBoolean();  
import org.opensearch.common.unit.TimeValue;  
        assertThat(response.isDryRun(), equalTo(false));
        GetSettingsResponse getSettingsResponse = client().admin()
        assertThat(response.getNewIndex(), equalTo("test_index-000003"));
        assertThat(response.getOldIndex(), equalTo("test_index-2"));
        assertTrue(oldIndex.getAliases().containsKey("test_alias"));  
            assertThat(response.getOldIndex(), equalTo("test-1"));
        }  
        assertThat(oldIndex.getRolloverInfos().get("test_alias").getMetConditions(), is(empty()));
        assertThat(response.isDryRun(), equalTo(false));  
        final RolloverResponse response = client().admin()
        assertThat(response.isRolledOver(), equalTo(true));
        refresh(aliasName);
        index(aliasName, SINGLE_MAPPING_NAME, "1", "field", "value");
 * GitHub history for details.
        final String indexNamePrefix = "test_index_hidden-";
        flush("test-1");
        if (firstIsWriteIndex == null) {
            assertTrue(newIndex.getAliases().get("test_alias").writeIndex());
                    Settings.builder()
import java.util.List;  
            .build();
        assertThat(response.isDryRun(), equalTo(false));
            () -> client().admin().indices().prepareRolloverIndex("test_alias").settings(settings).alias(new Alias("extra_alias")).get()  
        assertAcked(prepareCreate(closedIndex).addAlias(new Alias(aliasName)).get());  
            response = client().admin().indices().prepareRolloverIndex("test_alias").dryRun(true).get();
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );
public class RolloverIT extends OpenSearchIntegTestCase {
        flush("test_index-2");
        assertAcked(prepareCreate(openNonwriteIndex).addAlias(new Alias(aliasName)).get());
    }  
        }  
        if (explicitWriteIndex) {  
        manageReplicaBalanceSetting(true);
import static org.hamcrest.Matchers.is;  
        client().admin().indices().prepareRolloverIndex("test_alias").settings(settings).alias(new Alias("extra_alias")).get();
 */  
        for (int i = 0; i < numDocs; i++) {
            .prepareGetSettings(response.getOldIndex(), response.getNewIndex())
        response = client().admin().indices().prepareRolloverIndex("test_alias").get();
        index(closedIndex, SINGLE_MAPPING_NAME, null, "{\"foo\": \"bar\"}");
        assertThat(  
            is(both(greaterThanOrEqualTo(beforeTime)).and(lessThanOrEqualTo(client().threadPool().absoluteTimeInMillis() + 1000L)))
        manageReplicaBalanceSetting(false);
        if (explicitWriteIndex) {
        final IndexMetadata newIndex = state.metadata().index("test_index-000003");
            .waitForActiveShards(0)
            .setNewIndexName("test_new_index")
    }  
 *  
                is(both(greaterThanOrEqualTo(beforeTime)).and(lessThanOrEqualTo(client().threadPool().absoluteTimeInMillis() + 1000L)))
            .waitForActiveShards(0)
        index("test_index", "type1", "1", "field", "value");
        final RolloverResponse response = client().admin().indices().prepareRolloverIndex("test_alias").get();
            .alias(new Alias("extra_alias"))  
        index("test_index-2", "type1", "1", "field", "value");
            is(both(greaterThanOrEqualTo(beforeTime)).and(lessThanOrEqualTo(client().threadPool().absoluteTimeInMillis() + 1000L)))  
import org.opensearch.plugins.Plugin;  
        Alias testAlias = new Alias("test_alias");
            containsString("expected max cap on auto expand to be a multiple of total awareness attributes [2]")
            client().admin().indices().prepareRolloverIndex("test_alias").get();  
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()  
        }  
import org.opensearch.cluster.ClusterState;  
                .prepareRolloverIndex("test_alias")  
                    "*test_index*"
        index(aliasName, SINGLE_MAPPING_NAME, null, "{\"foo\": \"bar\"}");  
        assertTrue(newIndex.getAliases().containsKey(aliasName));
        final RolloverResponse response = client().admin().indices().prepareRolloverIndex(aliasName).get();
 */  
        assertAcked(prepareCreate("test_index-1").addAlias(testAlias).get());  
        assertThat(oldIndex.getRolloverInfos().get("test_alias").getMetConditions(), is(empty()));
        assertThat(response.getOldIndex(), equalTo("test_index-0"));
                .indices()  
            final RolloverResponse response = client().admin()
            .indices()
        assertThat(response.getConditionStatus().size(), equalTo(0));
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(response.isRolledOver(), equalTo(true));  
                new MaxAgeCondition(TimeValue.timeValueHours(4)).toString()  
 * license agreements. See the NOTICE file distributed with
        assertTrue(newIndex.getAliases().containsKey("extra_alias"));
            assertThat(metConditions.get(0).toString(), equalTo(new MaxSizeCondition(maxSizeValue).toString()));
/*
        assertThat(response.getOldIndex(), equalTo("test_index-2"));  
        assertTrue(newIndex.getAliases().containsKey("extra_alias"));
        assertThat(response.getNewIndex(), equalTo("test_index-000003"));  
        {  
        assertTrue(oldIndex.getAliases().containsKey("test_alias"));  
        assertThat(response.getOldIndex(), equalTo(index));
        // now we modify the provided name such that we can test that the pattern is carried on
        assertTrue(newIndex.getAliases().get(aliasName).isHidden());
        assertThat(response.getConditionStatus().size(), equalTo(0));
        client().admin()
        ensureGreen(index);
            conditions,  
        assertThat(
    public void testRolloverWithHiddenAliasesAndExplicitWriteIndex() {
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
            assertThat(
            .settings(
            assertThat(e.getIndex().getName(), equalTo("test_index-000001"));  
        assertThat(oldIndex.getRolloverInfos().get(aliasName).getMetConditions(), is(empty()));
        index("test_index-2", "type1", "1", "field", "value");
            testAlias.writeIndex(true);
        final Settings settings = Settings.builder()
        final ClusterState state = client().admin().cluster().prepareState().get().getState();  
            testAlias.writeIndex(true);
            .get();
        }  
    }
import org.opensearch.common.time.DateFormatter;
        assertThat(oldIndex.getRolloverInfos().size(), equalTo(1));
            assertThat(metConditions.size(), equalTo(1));  
import org.opensearch.test.MockLogAppender;
        refresh(aliasName);  
                .indices()
        assertAcked(prepareCreate("test_index-2").addAlias(testAlias).get());
            .get();
    public void testRolloverWithNewIndexName() throws Exception {
        assertTrue(newIndex.getAliases().containsKey("test_alias"));  
        if (explicitWriteIndex) {
            .get();  
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequestBuilder;
        flush("test_index-0", "test_index-000001");
        assertThat(newIndex.getNumberOfReplicas(), equalTo(0));
import static org.hamcrest.core.CombinableMatcher.both;
            .setPatterns(Collections.singletonList("logs-*"))  
        long beforeTime = client().threadPool().absoluteTimeInMillis() - 1000L;
            assertThat(response.getOldIndex(), equalTo("test-000002"));  
                .setPatterns(Collections.singletonList("test_index-*"))
    public void testRolloverWithIndexSettingsBalancedWithUseZoneForReplicaDefaultCount() throws Exception {
        }
        assertThat(response.getConditionStatus().size(), equalTo(2));
        assertThat(response.getConditionStatus().size(), equalTo(0));
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        refresh();
        }
        }  
        // A large max_size
            .alias(new Alias("extra_alias"))
            .alias(new Alias("extra_alias"))  
        assertThat(response.isDryRun(), equalTo(false));  
        } else {  
        assertEquals(writeIndexPrefix + "000002", rolloverResponse.getNewIndex());
        if (explicitWriteIndex) {
        );
        assertAcked(client().admin().indices().prepareClose(closedIndex).get());
        manageReplicaSettingForDefaultReplica(false);
        client().admin()
        final IndexMetadata oldIndex = state.metadata().index(firstIndexName);  
        index("test_index-2", "type1", "1", "field", "value");  
        assertAcked(client().admin().indices().prepareClose(closedIndex).get());  
        final IndexMetadata newIndex = state.metadata().index("test_index-000001");  
        if (explicitWriteIndex) {  
            .addMaxIndexSizeCondition(new ByteSizeValue(10, ByteSizeUnit.MB))
        randomIndexTemplate();
            getSettingsResponse.getSetting(response.getNewIndex(), IndexMetadata.SETTING_INDEX_PROVIDED_NAME)  
                        .build()
            .prepareUpdateSettings(index)  
        assertThat(response.isRolledOver(), equalTo(true));
 * not use this file except in compliance with the License.
        if (explicitWriteIndex) {  
            assertTrue(oldIndex.getAliases().containsKey("test_alias"));
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
import java.util.Collection;
        final String aliasName = "test_alias";
        ensureGreen(aliasName);
            assertFalse(oldIndex.getAliases().containsKey("test_alias"));
        assertAcked(prepareCreate("test_index-0").addAlias(testAlias).get());
        final IndexMetadata oldIndex = state.metadata().index("test_index-1");
        assertTrue(oldIndex.getAliases().containsKey(aliasName));
            .indices()  
        } else {  
        assertThat(response.getConditionStatus().size(), equalTo(0));
        flush("test_index-2");  
        final String aliasName = "alias";
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/64921")
                .indices()
        assertThat(response.getOldIndex(), equalTo("test_index-2"));
            restoreError2.getMessage(),  
        String index = "test-" + DateFormatter.forPattern("yyyy.MM.dd").format(now) + "-1";
        try {
    public void testRolloverWithClosedIndexInAlias() throws Exception {  
            .prepareRolloverIndex("test_alias")
            .prepareRolloverIndex("test_alias")
                .prepareRolloverIndex("test_alias")  
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
                    "no related message logged on dry run",
            error.getMessage(),
        assertAcked(prepareCreate(openNonwriteIndex).addAlias(new Alias(aliasName)).get());  
        assertThat(response.getOldIndex(), equalTo("test_index-1"));
        assertTrue(newIndex.getAliases().containsKey(aliasName));
        assertThat(response.getNewIndex(), equalTo("test-" + DateFormatter.forPattern("yyyy.MM.dd").format(now) + "-000004"));
            final IndexMetadata oldIndex = client().admin().cluster().prepareState().get().getState().metadata().index("test-000002");  
            long beforeTime = client().threadPool().absoluteTimeInMillis() - 1000L;
        boolean explicitWriteIndex = randomBoolean();
            .indices()
        assertAcked(prepareCreate(writeIndexPrefix + "000001").addAlias(new Alias(aliasName).writeIndex(true)).get());
        final RolloverResponse response = client().admin().indices().prepareRolloverIndex("test_alias").get();
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
 * The OpenSearch Contributors require contributions made to  
            assertFalse(oldIndex.getAliases().get("test_alias").writeIndex());
        final IndexMetadata oldIndex = state.metadata().index(firstIndexName);
        ensureGreen(index);
            .waitForActiveShards(0)  
        assertThat(newIndex.getNumberOfReplicas(), equalTo(2));  
                oldIndex.getRolloverInfos().get("test_alias").getTime(),  
        assertThat(oldIndex.getRolloverInfos().get("test_alias").getAlias(), equalTo("test_alias"));  
        final String aliasName = "test_alias";
        assertThat(  
        assertThat(response.isRolledOver(), equalTo(true));
        assertThat(oldIndex.getRolloverInfos().size(), equalTo(1));
        assertThat(response.isDryRun(), equalTo(false));  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
/*  
        assertThat(response.isDryRun(), equalTo(false));
        assertTrue(newIndex.getAliases().get("test_alias").writeIndex());
 * Unless required by applicable law or agreed to in writing,
                    .build()
        long beforeTime = client().threadPool().absoluteTimeInMillis() - 1000L;  
        );
    }  
        assertAcked(prepareCreate("test_index-1").addAlias(new Alias("test_alias")).get());  
            .settings(
        );
        IllegalArgumentException exception = expectThrows(
        assertAcked(prepareCreate("index1").addAlias(new Alias("alias").writeIndex(firstIsWriteIndex)).get());
                    AllocationService.class.getName(),
        assertFalse(oldIndex.getAliases().containsKey("test_alias"));
                .indices()
            .preparePutTemplate("logs")
        );  
        assertThat(response.getConditionStatus().size(), equalTo(0));  
        flush("test_index-0");  
import org.opensearch.common.settings.Settings;
    public void testRolloverWithIndexSettingsWithoutPrefix() throws Exception {
        flush("test_index-2");  
        assertThat(response.getOldIndex(), equalTo("test_index-1"));
            () -> client().admin().indices().prepareRolloverIndex("alias").dryRun(randomBoolean()).get()
        index("test_index-000001", "type1", "1", "field", "value");  
        assertThat(response.isRolledOver(), equalTo(true));  
 * SPDX-License-Identifier: Apache-2.0
    }
        assertAcked(prepareCreate("test_index-2").addAlias(testAlias).get());
            .alias(new Alias("extra_alias"))
        assertTrue(oldIndex.getAliases().get(aliasName).isHidden());
        assertAcked(client().admin().indices().prepareCreate("logs-000001").get());  
            is(both(greaterThanOrEqualTo(beforeTime)).and(lessThanOrEqualTo(client().threadPool().absoluteTimeInMillis() + 1000L)))
            .addMaxIndexAgeCondition(TimeValue.timeValueHours(4))
        assertThat(response.getOldIndex(), equalTo(firstIndexName));
        index("test_index-2", "type1", "1", "field", "value");
import org.opensearch.cluster.routing.allocation.AllocationService;  
            .indices()
                new MaxSizeCondition(new ByteSizeValue(10, ByteSizeUnit.MB)).toString(),
        } catch (ResourceAlreadyExistsException e) {
        assertTrue(newIndex.getAliases().containsKey("test_alias"));
        client().admin()
        final RolloverResponse response = client().admin().indices().prepareRolloverIndex(aliasName).get();  
            .alias(new Alias("extra_alias"))
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import org.opensearch.test.OpenSearchIntegTestCase;  
        Alias testAlias = new Alias("test_alias");
        assertThat(response.getOldIndex(), equalTo("test-" + DateFormatter.forPattern("yyyy.MM").format(now) + "-000003"));
        index("test_index-1", "type1", "1", "field", "value");
            assertFalse(oldIndex.getAliases().get("test_alias").writeIndex());
        boolean explicitWriteIndex = randomBoolean();  
        boolean explicitWriteIndex = randomBoolean();
        assertThat(response.isDryRun(), equalTo(true));  
        }
    }  
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;  
        } else {  
        assertTrue(newIndex.getAliases().get(aliasName).isHidden());  
        assertThat(newIndex.getNumberOfShards(), equalTo(1));
        final IndexMetadata newIndex = state.metadata().index("test_index-000002");  
        assertThat(response.isRolledOver(), equalTo(false));
import org.opensearch.ResourceAlreadyExistsException;
        final IndexMetadata oldIndex = state.metadata().index("test_index-2");
        final Settings settings = Settings.builder()
        index(aliasName, SINGLE_MAPPING_NAME, null, "{\"foo\": \"bar\"}");
        assertAcked(prepareCreate("test_index-2").addAlias(new Alias("test_alias").writeIndex(true)).get());
        assertThat(response.isRolledOver(), equalTo(false));
import org.opensearch.cluster.metadata.AutoExpandReplicas;
        final IndexMetadata newIndex = state.metadata().index("test_index-000003");  
            .settings(settings)
        manageReplicaSettingForDefaultReplica(true);
    public void testRolloverWithHiddenAliasesAndImplicitWriteIndex() {
 * specific language governing permissions and limitations
        assertThat(newIndex.getNumberOfReplicas(), equalTo(0));  
        assertThat(response.getNewIndex(), equalTo("test_index-000002"));  
        final String secondIndexName = indexNamePrefix + "000002";
        assertThat(response.isDryRun(), equalTo(false));
                .prepareRolloverIndex("test_alias")
            PutIndexTemplateRequestBuilder putTemplate = client().admin()
        }
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
                )  
            final IndexMetadata oldIndex = client().admin().cluster().prepareState().get().getState().metadata().index("test-1");  
        }
        assertThat(response.getOldIndex(), equalTo(firstIndexName));  
            assertThat(oldIndex.getRolloverInfos().size(), equalTo(0));
    public void testRolloverWithDateMath() {
            oldIndex.getRolloverInfos().get(aliasName).getTime(),  
import java.time.ZonedDateTime;  
            .addAlias(new Alias("logs-write"))
            restoreError.getMessage(),
import static org.opensearch.index.mapper.MapperService.SINGLE_MAPPING_NAME;  
        }
        assertThat(response.getConditionStatus().values(), everyItem(is(false)));  
        final String indexNamePrefix = "test_index_hidden-";  
        assertThat(response.isRolledOver(), equalTo(true));  
    }  
            assertThat("Should rollover with a small max_size condition", response.isRolledOver(), equalTo(true));  
        assertTrue(oldIndex.getAliases().containsKey("test_alias"));
    }
        if (explicitWriteIndex) {  
        // A small max_size
    public void testRolloverDryRun() throws Exception {
        assertThat(response.isDryRun(), equalTo(false));
        assertEquals(  
        final String closedIndex = "closed-index-nonwrite";  
        long beforeTime = client().threadPool().absoluteTimeInMillis() - 1000L;  
        );
            .settings(settings)  
                    .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-1")
            );
import static org.hamcrest.collection.IsEmptyCollection.empty;  
            index("test-1", "doc", Integer.toString(i), "field", "foo-" + i);  
            IllegalArgumentException.class,
package org.opensearch.action.admin.indices.rollover;
                .indices()
        assertFalse(oldIndex.getAliases().get("test_alias").writeIndex());
                .get();
        assertTrue(newIndex.getAliases().get(aliasName).writeIndex());
            )
            oldIndex.getRolloverInfos().get("test_alias").getTime(),  
            assertThat(response.getOldIndex(), equalTo("test-1"));  
            )
            assertThat("No rollover with a large max_size condition", response.isRolledOver(), equalTo(false));
        assertThat(oldIndex.getRolloverInfos().get(aliasName).getAlias(), equalTo(aliasName));
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_INDEX_PROVIDED_NAME, "<test-{now/M{yyyy.MM}}-1>"))
    public void testRolloverWithNoWriteIndex() {
            testAlias.writeIndex(true);
        assertThat(response.getConditionStatus().size(), equalTo(0));
            .get();
    }  
            )
        assertAcked(prepareCreate("test_index-2").addAlias(new Alias("test_alias")).get());  
            .build();
        final IllegalArgumentException restoreError2 = expectThrows(
 * this work for additional information regarding copyright
        final IllegalArgumentException error = expectThrows(
            .indices()  
        final RolloverResponse response = client().admin().indices().prepareRolloverIndex("test_alias").get();  
        assertAcked(prepareCreate(firstIndexName).addAlias(new Alias(aliasName).writeIndex(true).isHidden(true)).get());
                .addMaxIndexSizeCondition(new ByteSizeValue(randomNonNegativeLong(), ByteSizeUnit.BYTES))
    }
        final IndexMetadata oldIndex = state.metadata().index("test_index-2");  
 * KIND, either express or implied.  See the License for the
    public void testRolloverConditionsNotMet() throws Exception {
            oldIndex.getRolloverInfos().get(aliasName).getTime(),
        assertEquals(writeIndexPrefix + "000001", rolloverResponse.getOldIndex());  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
        response = client().admin().indices().prepareRolloverIndex("test_alias").setNewIndexName("<test-{now/d}-000004>").get();  
        final IndexMetadata newIndex = state.metadata().index("test_index-000003");
            .get();
        );
            equalTo(
        assertThat(
        final IndexMetadata newIndex = state.metadata().index(secondIndexName);
    }
        final IndexMetadata oldIndex = state.metadata().index("test_index");  
            .prepareRolloverIndex("test_alias")  
        if (explicitWriteIndex) {
 *
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        if (explicitWriteIndex) {
        }  
        assertTrue(newIndex.getAliases().containsKey("test_alias"));
import java.time.ZoneOffset;
        } else {
        }
        assertThat(response.getNewIndex(), equalTo(secondIndexName));
        assertThat(response.getConditionStatus().size(), equalTo(0));  
            assertNull(oldIndex.getAliases().get("test_alias").writeIndex());
        final ClusterState state = client().admin().cluster().prepareState().get().getState();  
        String dateMathExp = "<test-{now/d}-1>";
            appender.addExpectation(
            ByteSizeValue maxSizeValue = new ByteSizeValue(randomIntBetween(1, 20), ByteSizeUnit.BYTES);  
            () -> client().admin().indices().prepareRolloverIndex("logs-write").addMaxIndexSizeCondition(new ByteSizeValue(1)).get()
                )
 * compatible open source license.
            is(both(greaterThanOrEqualTo(beforeTime)).and(lessThanOrEqualTo(client().threadPool().absoluteTimeInMillis() + 1000L)))
        assertThat(response.getNewIndex(), equalTo("test_index-000001"));
        flush("test_index-2");
            assertThat("No rollover with an empty index", response.isRolledOver(), equalTo(false));
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
                .get()
            final RolloverResponse response = client().admin()
    @Override
        );
import org.opensearch.test.InternalSettingsPlugin;
            .get();  
    public void testRolloverWithIndexSettings() throws Exception {  
            assertThat(response.getNewIndex(), equalTo("test-000003"));
        assertNull(newIndex);
        assertTrue(rolloverResponse.isRolledOver());
            containsInAnyOrder(
import org.apache.logging.log4j.Level;
        index(closedIndex, SINGLE_MAPPING_NAME, null, "{\"foo\": \"bar\"}");  
        }
        assertThat(
        assertThat(response.isRolledOver(), equalTo(true));
        assertEquals(writeIndexPrefix + "000002", rolloverResponse.getNewIndex());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (explicitWriteIndex) {
        Logger allocationServiceLogger = LogManager.getLogger(AllocationService.class);
            .indices()
        assertThat(response.isRolledOver(), equalTo(true));
    public void testRollover() throws Exception {
    }
        } else {  
            testAlias.writeIndex(true);
        final RolloverResponse response = client().admin()  
            assertTrue(newIndex.getAliases().get("test_alias").writeIndex());
        boolean explicitWriteIndex = randomBoolean();  
import org.opensearch.action.admin.indices.alias.Alias;
        final String secondIndexName = indexNamePrefix + "000002";  
        boolean explicitWriteIndex = randomBoolean();  
        assertThat(response.isDryRun(), equalTo(false));  
        assertAcked(prepareCreate("test_index-2").addAlias(testAlias).get());
        index(aliasName, SINGLE_MAPPING_NAME, null, "{\"foo\": \"bar\"}");
import org.opensearch.core.common.unit.ByteSizeValue;
            assertAcked(prepareCreate("index2").addAlias(new Alias("alias").writeIndex(randomFrom(false, null))).get());  
                    .build()
            oldIndex.getRolloverInfos().get("test_alias").getTime(),  
            "<test-{now/M{yyyy.MM}}-000003>",
        flush("test_index-2");
            assertTrue(oldIndex.getAliases().get("test_alias").writeIndex());
}  
        final String openNonwriteIndex = "open-index-nonwrite";
        Alias testAlias = new Alias("test_alias");
            assertFalse(oldIndex.getAliases().containsKey("test_alias"));
            )
    }  
    }  
    }
        assertThat(response.getNewIndex(), equalTo("test_index-000003"));  
        if (randomBoolean()) {  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }  
    public void testRolloverMaxSize() throws Exception {
        Alias testAlias = new Alias("test_alias");  
 *
        final String aliasName = "alias";
 * this file be licensed under the Apache-2.0 license or a
        assertThat(response.isRolledOver(), equalTo(true));
        assertThat(response.isDryRun(), equalTo(false));  
import org.apache.logging.log4j.LogManager;
        final IndexMetadata oldIndex = state.metadata().index("test_index-1");
                .setOrder(-1)
        assertThat(response.getConditionStatus().size(), equalTo(0));  
    }
        index("test_index-2", "_doc", "1", "field", "value");  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
            () -> client().admin()  
import static org.hamcrest.Matchers.equalTo;
        refresh();
        index(aliasName, SINGLE_MAPPING_NAME, null, "{\"foo\": \"bar\"}");
            assertFalse(oldIndex.getAliases().containsKey("test_alias"));  
            .indices()  
        boolean explicitWriteIndex = randomBoolean();
        final String writeIndexPrefix = "write-index-";
        final IndexMetadata newIndex = state.metadata().index("test_index-000002");  
        index("test_index-0", "type1", "1", "field", "value");
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).build();  
        assertAcked(prepareCreate("test_index-0").addAlias(new Alias("test_alias")).get());  
        final RolloverResponse response;  
        assertThat(response.getConditionStatus().size(), equalTo(0));  
        );
            testAlias.writeIndex(true);  
            .prepareRolloverIndex("test_alias")
        assertThat(newIndex.getAliases().get(aliasName).writeIndex(), nullValue());  
                .settings(  
                .addMaxIndexSizeCondition(maxSizeValue)
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequestBuilder;
                .prepareRolloverIndex("test_alias")
        final Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            .prepareRolloverIndex("test_alias")
        {
        index("test_index-2", "type1", "1", "field", "value");  
            .prepareRolloverIndex("test_alias")
            assertThat(oldIndex.getRolloverInfos().size(), equalTo(0));
import org.apache.logging.log4j.Logger;  
import static org.hamcrest.Matchers.containsString;  
            final RolloverResponse response = client().admin()
            assertFalse(oldIndex.getAliases().get("test_alias").writeIndex());
        }
        refresh("test_alias");  
        int numDocs = randomIntBetween(10, 20);
            testAlias.writeIndex(true);
        }
                Settings.builder()
            .indices()
        assertAcked(prepareCreate(dateMathExp).addAlias(new Alias("test_alias")).get());  
        assertTrue(rolloverResponse.isRolledOver());
            .get();
        assertAcked(deleteTemplate.execute().actionGet());  
        assertFalse(oldIndex.getAliases().containsKey(aliasName));
        final IndexMetadata oldIndex = state.metadata().index("test_index-0");
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        assertThat(response.isRolledOver(), equalTo(true));
        final RolloverResponse response = client().admin()
                .setSettings(Settings.builder().put(AutoExpandReplicas.SETTING.getKey(), "0-all"));  
        assertAcked(prepareCreate("test_index-2").addAlias(testAlias).get());
        assertThat(response.getConditionStatus().size(), equalTo(0));
        long beforeTime = client().threadPool().absoluteTimeInMillis() - 1000L;
        );  
        }
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        return Collections.singleton(InternalSettingsPlugin.class);  
            assertFalse(oldIndex.getAliases().containsKey("test_alias"));
    public void testRolloverOnExistingIndex() throws Exception {
        ensureGreen();  
        }
        final String firstIndexName = indexNamePrefix + "000001";
import static org.hamcrest.Matchers.everyItem;
        assumeTrue("only works on the same day", now.plusMinutes(5).getDayOfYear() == now.getDayOfYear());  
        assertThat(response.getNewIndex(), equalTo("test_new_index"));
        // An empty index
        Alias testAlias = new Alias("test_alias");
import java.util.Set;
        assertTrue(newIndex.getAliases().containsKey("test_alias"));
        if (explicitWriteIndex) {
        final IndexMetadata newIndex = state.metadata().index("test_index-000003");  
        if (explicitWriteIndex) {
        assertAcked(prepareCreate("test-1").addAlias(new Alias("test_alias")).get());  
        }
        final ClusterState state = client().admin().cluster().prepareState().get().getState();  
            assertFalse(oldIndex.getAliases().get("test_alias").writeIndex());  
            "<test-{now/M{yyyy.MM}}-000002>",
            .get();
        assertTrue(newIndex.getAliases().containsKey("test_alias"));
        index("test_index-0", "type1", "1", "field", "value");
        assertThat(oldIndex.getRolloverInfos().size(), equalTo(1));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
