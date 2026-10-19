        produceData("2", "name2", "20");
        );
                client().admin().indices().prepareDelete(indexName).get();  
                .put(
        createIndex(
 * this file be licensed under the Apache-2.0 license or a
                .put(  
        });
                .put("ingestion_source.param.stream", "test")
            try {
package org.opensearch.plugin.kinesis;
 *
                .build(),
                .put("ingestion_source.param.region", localstack.getRegion())  
            assertThat(response.getHits().getTotalHits().value(), is(2L));  
            pluginInfos.stream().anyMatch(pluginInfo -> pluginInfo.getName().equals("org.opensearch.plugin.kinesis.KinesisPlugin"))
        NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
                .put("ingestion_source.param.secret_key", localstack.getSecretKey())
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
            SearchResponse response = client().prepareSearch("test").setQuery(query).get();  
            refresh("test");
        try {  
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorRequest;
        }
                .put(
                .put("ingestion_source.param.region", localstack.getRegion())  
    public void testKinesisIngestion() {  
            assertNotNull(stats);
     * test ingestion-kinesis-plugin is installed
            refresh("test_rewind_by_offset");
            produceData(Integer.toString(i), "name" + i, "30");
            )
public class IngestFromKinesisIT extends KinesisIngestionBaseIT {
    public void testPluginsAreInstalled() {  
import org.junit.Assert;  
            .shardId(shardId)
     */
            .shardIteratorType(ShardIteratorType.AT_SEQUENCE_NUMBER)  
        String sequenceNumber = produceData("3", "name3", "20");
                    localstack.getEndpointOverride(LocalStackContainer.Service.KINESIS).toString()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                .put("ingestion_source.param.region", localstack.getRegion())
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"  
import software.amazon.awssdk.services.kinesis.model.Record;
            .stream()
            .streamName(streamName)
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
import org.opensearch.cluster.metadata.IndexMetadata;  
                .put("ingestion_source.type", "kinesis")
            .build();
                )
            ensureGreen(indexName);
import java.util.function.Function;
            SearchResponse response = client().prepareSearch("test_rewind_by_offset").setQuery(query).get();
        // Create pull-based index in default replication mode (docrep) and publish some messages
        }
        // Use the iterator to read the record
            .startingSequenceNumber(sequenceNumber)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
}
                .put("ingestion_source.param.secret_key", localstack.getSecretKey())
        // create an index with ingestion source from kinesis
            PollingIngestStats stats = client().admin().indices().prepareStats("test").get().getIndex("test").getShards()[0]
 * Integration test for Kinesis ingestion
        final String nodeB = internalCluster().startDataOnlyNode();
                .put("ingestion_source.param.stream", "test")
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 * The OpenSearch Contributors require contributions made to  
 */  
        return records.get(0).partitionKey().equals("3");  
                .put("ingestion_source.param.access_key", localstack.getAccessKey())
    }
import software.amazon.awssdk.services.kinesis.model.GetRecordsRequest;  
        String shardIterator = iteratorResponse.shardIterator();
    }
import java.util.stream.Collectors;
        produceData("1", "name1", "24");
        createIndex(
            // Ensure index is deleted even if the assertion throws.
        GetShardIteratorRequest iteratorRequest = GetShardIteratorRequest.builder()  
        GetShardIteratorResponse iteratorResponse = kinesisClient.getShardIterator(iteratorRequest);
import static org.awaitility.Awaitility.await;
                (Function<NodeInfo, Stream<PluginInfo>>) nodeInfo -> nodeInfo.getInfo(PluginsAndModules.class).getPluginInfos().stream()
                )
        await().atMost(5, TimeUnit.SECONDS).until(() -> isRewinded(sequenceNumber));
                .build(),
        });
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import software.amazon.awssdk.services.kinesis.model.ShardIteratorType;
            Settings.builder()  
        internalCluster().startClusterManagerOnlyNode();  
import software.amazon.awssdk.services.kinesis.model.GetRecordsResponse;
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
                .put("ingestion_source.all_active", true)  
    }  
        produceData("1", "name1", "24");
        produceData("2", "name2", "24");  
        Assert.assertTrue(
                .put("ingestion_source.pointer.init.reset", "earliest")
                .getPollingIngestStats();  
            .build();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        produceData("4", "name4", "21");  
        nodesInfoRequest.addMetric(NodesInfoRequest.Metric.PLUGINS.metricName());
                .put("ingestion_source.all_active", true)  
                .put("index.replication.type", "SEGMENT")
                .put("ingestion_source.type", "kinesis")  
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(21);  
    public void testKinesisIngestion_RewindByOffset() throws InterruptedException {
import org.opensearch.common.settings.Settings;
        );  
                )  
    }
/*  
        createIndex(
            Settings.builder()  
                .put("ingestion_source.type", "kinesis")  
        await().atMost(60, TimeUnit.SECONDS).untilAsserted(() -> {  
        for (int i = 0; i < 10; i++) {  
            return false;
        );
                    localstack.getEndpointOverride(LocalStackContainer.Service.KINESIS).toString()  
            assertThat(stats.getConsumerStats().totalPolledCount(), is(2L));  
        if (records.size() != 1) {  
 * compatible open source license.
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
            .flatMap(  
            assertThat(stats.getMessageProcessorStats().totalProcessedCount(), is(2L));
                    "ingestion_source.param.endpoint_override",
import static org.hamcrest.Matchers.is;
        List<PluginInfo> pluginInfos = nodesInfoResponse.getNodes()
        logger.info("Produced message with sequence number: {}", sequenceNumber);
/**
        NodesInfoResponse nodesInfoResponse = OpenSearchIntegTestCase.client().admin().cluster().nodesInfo(nodesInfoRequest).actionGet();  
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
                .build(),
        } finally {  
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorResponse;  
        final String nodeA = internalCluster().startDataOnlyNode();
                    "ingestion_source.param.endpoint_override",
        );
 */  
        }
        GetRecordsRequest recordsRequest = GetRecordsRequest.builder()
 * SPDX-License-Identifier: Apache-2.0
        );  
                    localstack.getEndpointOverride(LocalStackContainer.Service.KINESIS).toString()
import java.util.concurrent.TimeUnit;  
            Settings.builder()
    /**  
            } catch (Exception ignored) {}
import org.opensearch.plugins.PluginInfo;
    public void testAllActiveIngestion() throws Exception {
                .put("ingestion_source.pointer.init.reset.value", sequenceNumber)  
import org.opensearch.indices.pollingingest.PollingIngestStats;  
            DescribeStreamRequest.builder().streamName(streamName).build()
            waitForSearchableDocs(10, List.of(nodeA, nodeB));
                    "ingestion_source.param.endpoint_override",  
                .put("ingestion_source.param.access_key", localstack.getAccessKey())  
import org.opensearch.action.search.SearchResponse;
        List<Record> records = recordsResponse.records();
        GetRecordsResponse recordsResponse = kinesisClient.getRecords(recordsRequest);
import org.testcontainers.containers.localstack.LocalStackContainer;
import java.util.List;
                .put("ingestion_source.param.secret_key", localstack.getSecretKey())
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.test.OpenSearchIntegTestCase;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                .put("ingestion_source.pointer.init.reset", "earliest")
        await().atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {
            .shardIterator(shardIterator)  
import org.opensearch.index.query.RangeQueryBuilder;
import java.util.stream.Stream;  
        String shardId = describeStreamResponse.streamDescription().shards().get(0).shardId();
                .put("ingestion_source.param.stream", "test")
    }
            "test",
import software.amazon.awssdk.services.kinesis.model.DescribeStreamRequest;
            assertThat(response.getHits().getTotalHits().value(), is(1L));
            "test_rewind_by_offset",  
                .put("ingestion_source.param.access_key", localstack.getAccessKey())
    private boolean isRewinded(String sequenceNumber) {
        DescribeStreamResponse describeStreamResponse = kinesisClient.describeStream(  
            .limit(1)  // Adjust as needed
            .collect(Collectors.toList());  
            indexName,
import software.amazon.awssdk.services.kinesis.model.DescribeStreamResponse;
