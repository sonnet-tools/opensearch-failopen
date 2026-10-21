    /**
            .build();
    public void testKinesisIngestion() {
                    localstack.getEndpointOverride(LocalStackContainer.Service.KINESIS).toString()
        );
            .shardIteratorType(ShardIteratorType.AT_SEQUENCE_NUMBER)
                (Function<NodeInfo, Stream<PluginInfo>>) nodeInfo -> nodeInfo.getInfo(PluginsAndModules.class).getPluginInfos().stream()
        } finally {
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
            indexName,
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.metadata.IndexMetadata;
        });
import software.amazon.awssdk.services.kinesis.model.GetRecordsResponse;
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
                .put("ingestion_source.param.region", localstack.getRegion())
                .put(
                    localstack.getEndpointOverride(LocalStackContainer.Service.KINESIS).toString()
                .put("ingestion_source.param.access_key", localstack.getAccessKey())
            PollingIngestStats stats = client().admin().indices().prepareStats("test").get().getIndex("test").getShards()[0]
import org.opensearch.action.search.SearchResponse;
public class IngestFromKinesisIT extends KinesisIngestionBaseIT {
                .put("ingestion_source.param.stream", "test")
        final String nodeA = internalCluster().startDataOnlyNode();
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorResponse;
                    localstack.getEndpointOverride(LocalStackContainer.Service.KINESIS).toString()
            assertThat(response.getHits().getTotalHits().value(), is(1L));
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
import java.util.stream.Collectors;
        }
            .shardId(shardId)
}
            SearchResponse response = client().prepareSearch("test_rewind_by_offset").setQuery(query).get();
        produceData("1", "name1", "24");
/*
                .put("ingestion_source.pointer.init.reset", "earliest")
                .put(
                )
                .build(),
                .put(
                .put("ingestion_source.pointer.init.reset", "earliest")
        // Create pull-based index in default replication mode (docrep) and publish some messages
            )
        });
import software.amazon.awssdk.services.kinesis.model.Record;
                .put("ingestion_source.param.region", localstack.getRegion())
     */
                client().admin().indices().prepareDelete(indexName).get();
import java.util.function.Function;
                .put("ingestion_source.param.secret_key", localstack.getSecretKey())
        List<Record> records = recordsResponse.records();
                .put("index.replication.type", "SEGMENT")
     * test ingestion-kinesis-plugin is installed
        List<PluginInfo> pluginInfos = nodesInfoResponse.getNodes()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            DescribeStreamRequest.builder().streamName(streamName).build()
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        }
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.plugin.kinesis;
        await().atMost(60, TimeUnit.SECONDS).untilAsserted(() -> {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    "ingestion_source.param.endpoint_override",
 * compatible open source license.
                .getPollingIngestStats();
        await().atMost(5, TimeUnit.SECONDS).until(() -> isRewinded(sequenceNumber));
            refresh("test_rewind_by_offset");
        );
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorRequest;
    }
import org.opensearch.plugins.PluginInfo;
    }
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(21);
        try {
            .stream()
        NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();
import software.amazon.awssdk.services.kinesis.model.GetRecordsRequest;
        produceData("2", "name2", "20");
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        produceData("2", "name2", "24");
                .put("ingestion_source.type", "kinesis")
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.awaitility.Awaitility.await;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .startingSequenceNumber(sequenceNumber)
                .put("ingestion_source.pointer.init.reset.value", sequenceNumber)
        // Use the iterator to read the record
import java.util.concurrent.TimeUnit;
                .put("ingestion_source.type", "kinesis")
        createIndex(
            .flatMap(
    public void testAllActiveIngestion() throws Exception {
import software.amazon.awssdk.services.kinesis.model.DescribeStreamRequest;
        logger.info("Produced message with sequence number: {}", sequenceNumber);
                )
                .put("ingestion_source.param.access_key", localstack.getAccessKey())
/**
        produceData("1", "name1", "24");
        );
import org.opensearch.indices.pollingingest.PollingIngestStats;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .put("ingestion_source.param.access_key", localstack.getAccessKey())
            .streamName(streamName)
            ensureGreen(indexName);
            assertThat(stats.getConsumerStats().totalPolledCount(), is(2L));
            .build();
            waitForSearchableDocs(10, List.of(nodeA, nodeB));
        GetRecordsResponse recordsResponse = kinesisClient.getRecords(recordsRequest);
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
 * The OpenSearch Contributors require contributions made to
    public void testPluginsAreInstalled() {
        );
            refresh("test");
        GetShardIteratorResponse iteratorResponse = kinesisClient.getShardIterator(iteratorRequest);
            .collect(Collectors.toList());
        if (records.size() != 1) {
import org.opensearch.index.query.RangeQueryBuilder;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // create an index with ingestion source from kinesis
            "test",
            assertThat(stats.getMessageProcessorStats().totalProcessedCount(), is(2L));
                    "ingestion_source.param.endpoint_override",
        String shardId = describeStreamResponse.streamDescription().shards().get(0).shardId();
                .put("ingestion_source.param.secret_key", localstack.getSecretKey())
        String sequenceNumber = produceData("3", "name3", "20");
            Settings.builder()
                .build(),
import org.testcontainers.containers.localstack.LocalStackContainer;
                .put("ingestion_source.type", "kinesis")
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                .put("ingestion_source.param.secret_key", localstack.getSecretKey())
import java.util.List;
        NodesInfoResponse nodesInfoResponse = OpenSearchIntegTestCase.client().admin().cluster().nodesInfo(nodesInfoRequest).actionGet();
            Settings.builder()
        DescribeStreamResponse describeStreamResponse = kinesisClient.describeStream(
        GetShardIteratorRequest iteratorRequest = GetShardIteratorRequest.builder()
import software.amazon.awssdk.services.kinesis.model.DescribeStreamResponse;
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
 * this file be licensed under the Apache-2.0 license or a
import software.amazon.awssdk.services.kinesis.model.ShardIteratorType;
        String shardIterator = iteratorResponse.shardIterator();
 * Integration test for Kinesis ingestion
            "test_rewind_by_offset",
            assertNotNull(stats);
        GetRecordsRequest recordsRequest = GetRecordsRequest.builder()
        for (int i = 0; i < 10; i++) {
 *
            .limit(1)  // Adjust as needed
                .put("ingestion_source.all_active", true)
        await().atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {
        }
    }
                    "ingestion_source.param.endpoint_override",
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 */
            produceData(Integer.toString(i), "name" + i, "30");
                )
        internalCluster().startClusterManagerOnlyNode();
            .shardIterator(shardIterator)
import org.junit.Assert;
        return records.get(0).partitionKey().equals("3");
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
            try {
            pluginInfos.stream().anyMatch(pluginInfo -> pluginInfo.getName().equals("org.opensearch.plugin.kinesis.KinesisPlugin"))
    }
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
        );
        nodesInfoRequest.addMetric(NodesInfoRequest.Metric.PLUGINS.metricName());
import java.util.stream.Stream;
                .put("ingestion_source.param.region", localstack.getRegion())
import static org.hamcrest.Matchers.is;
                .put("ingestion_source.param.stream", "test")
    }
        createIndex(
    public void testKinesisIngestion_RewindByOffset() throws InterruptedException {
            SearchResponse response = client().prepareSearch("test").setQuery(query).get();
            assertThat(response.getHits().getTotalHits().value(), is(2L));
        Assert.assertTrue(
                .build(),
            return false;
        createIndex(
            } catch (Exception ignored) {}
    private boolean isRewinded(String sequenceNumber) {
                .put("ingestion_source.param.stream", "test")
 */
        produceData("4", "name4", "21");
            Settings.builder()
        final String nodeB = internalCluster().startDataOnlyNode();
                .put("ingestion_source.all_active", true)
            // Ensure index is deleted even if the assertion throws.
