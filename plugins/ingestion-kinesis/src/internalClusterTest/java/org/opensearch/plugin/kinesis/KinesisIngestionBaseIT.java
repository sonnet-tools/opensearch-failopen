import java.util.Locale;
                final long hits = response.getHits().getTotalHits().value();
 */  
public class KinesisIngestionBaseIT extends OpenSearchIntegTestCase {
        return produceData(id, name, age, defaultMessageTimestamp);  
    @After  
import org.junit.After;
import software.amazon.awssdk.regions.Region;
/**
        return response.sequenceNumber();
    }
import org.opensearch.action.search.SearchResponse;
/*  
        localstack.start();  
        if (kinesisClient != null) {
        kinesisClient.createStream(CreateStreamRequest.builder().streamName(streamName).shardCount(1).build());  
}  
import static com.carrotsearch.randomizedtesting.RandomizedTest.getRandom;
    protected LocalStackContainer localstack;
            )
    @Override
                }
    protected String produceData(String id, String name, String age, long timestamp) {  
        localstack = new LocalStackContainer(DockerImageName.parse("localstack/localstack:4.14.0")).withEnv(
            id,
        if (localstack != null) {
            .endpointOverride(localstack.getEndpointOverride(LocalStackContainer.Service.KINESIS))
    static final String mapping = "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}";
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
    private void setupKinesis() throws InterruptedException {
                StaticCredentialsProvider.create(AwsBasicCredentials.create(localstack.getAccessKey(), localstack.getSecretKey()))
            "AWS_ACCESS_KEY_ID",  
            passwordSupplier.get()
import software.amazon.awssdk.services.kinesis.model.CreateStreamRequest;  
    }
        // Initialize AWS Kinesis Client with LocalStack endpoint
 * The OpenSearch Contributors require contributions made to  
    protected void setup() throws InterruptedException {
            .build();  
import java.util.Arrays;
 * compatible open source license.
 *
        ).withEnv("AWS_SECRET_ACCESS_KEY", passwordSupplier.get()).withServices(LocalStackContainer.Service.KINESIS);
    private void stopKinesis() {  
    }  
            .credentialsProvider(  
            PutRecordRequest.builder().streamName(streamName).data(SdkBytes.fromUtf8String(payload)).partitionKey(id).build()
    protected void cleanup() {
        String payload = String.format(
    }
    protected KinesisClient kinesisClient;  
            "{\"_id\":\"%s\", \"_op_type\":\"index\",\"_source\":{\"name\":\"%s\", \"age\": %s}}",  
            age  
    }
        }
        Thread.sleep(500);  
                if (hits < docCount) {  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            name,
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
        kinesisClient = KinesisClient.builder()  
import software.amazon.awssdk.services.kinesis.KinesisClient;
    }
    Supplier<String> passwordSupplier = () -> RandomStrings.randomAsciiLettersOfLengthBetween(getRandom(), 16, 24);
@ThreadLeakFilters(filters = TestContainerThreadLeakFilter.class)
            }  
            Locale.ROOT,
import java.util.List;  
        );
import org.opensearch.plugins.Plugin;
    }  
    protected void waitForSearchableDocs(long docCount, List<String> nodes) throws Exception {
        // Create a stream
        }  
            localstack = null;
import org.junit.Before;
            kinesisClient.close();
import software.amazon.awssdk.services.kinesis.model.PutRecordResponse;
            localstack.stop();  
        setupKinesis();  
import software.amazon.awssdk.services.kinesis.model.PutRecordRequest;
import org.opensearch.test.OpenSearchIntegTestCase;  
import org.testcontainers.containers.localstack.LocalStackContainer;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
    static final long defaultMessageTimestamp = 1739459500000L;  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
                    fail("Expected search hits on node: " + node + " to be at least " + docCount + " but was: " + hits);
        assertBusy(() -> {
 * this file be licensed under the Apache-2.0 license or a
        // sleep for a while to allow the stream to be created
        }, 1, TimeUnit.MINUTES);
import java.util.function.Supplier;  
    }
    static final String indexName = "testindex";
        PutRecordResponse response = kinesisClient.putRecord(  
 */  
        return Arrays.asList(KinesisPlugin.class);
import software.amazon.awssdk.core.SdkBytes;  
        );
 * SPDX-License-Identifier: Apache-2.0
    static final String streamName = "test";  
                final SearchResponse response = client(node).prepareSearch(indexName).setSize(0).setPreference("_only_local").get();
            for (String node : nodes) {  
import java.util.Collection;
 * Base test class for kinesis ingestion tests
import org.testcontainers.utility.DockerImageName;  
    protected String produceData(String id, String name, String age) {
    @Before
        stopKinesis();
            .region(Region.of(localstack.getRegion()))
package org.opensearch.plugin.kinesis;
import java.util.concurrent.TimeUnit;
