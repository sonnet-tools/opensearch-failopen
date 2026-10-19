 *
    }
        } catch (InterruptedException e) {
            }
 * compatible open source license.
import java.util.concurrent.ExecutionException;
            throw new RuntimeException("Interrupted while creating topic " + topicName, e);  
 * The OpenSearch Contributors require contributions made to  
                } catch (TimeoutException e) {
    private static final int CREATE_TOPIC_ATTEMPTS = 3;  
                .pollInterval(500, TimeUnit.MILLISECONDS)
import org.apache.kafka.clients.admin.KafkaAdminClient;  
public class KafkaUtils {  
 * this file be licensed under the Apache-2.0 license or a
            Thread.currentThread().interrupt();
    /**
                        LOGGER.warn("Topic {} already existed", topicName);
            for (int attempt = 1; attempt <= CREATE_TOPIC_ATTEMPTS && created == false; attempt++) {
        try {
            await().atMost(DESCRIBE_TOPIC_WAIT_SECONDS, TimeUnit.SECONDS)
            if (created == false) {  
import org.apache.kafka.clients.admin.AdminClientConfig;
import java.util.concurrent.TimeUnit;  
     * Creates kafka topic
                            attempt,
import java.util.Map;
                }
        createTopic(topicName, 1, bootstrapServer);
                            CREATE_TOPIC_ATTEMPTS,
package org.opensearch.plugin.kafka;
                    LOGGER.warn("createTopic attempt {}/{} for {} timed out", attempt, CREATE_TOPIC_ATTEMPTS, topicName);  
import java.util.concurrent.TimeoutException;
import java.util.List;  
                    } else {  
    private static boolean topicVisible(AdminClient adminClient, String topicName) {
     */  
import org.apache.kafka.clients.admin.NewTopic;
            return adminClient.describeTopics(List.of(topicName)).topicNameValues().get(topicName).get().name().equals(topicName);  
            }
        try (AdminClient adminClient = createAdminClient(bootstrapServers)) {
                    lastFailure = e;
    }
        );
import org.apache.logging.log4j.Logger;
    }
                            "createTopic attempt {}/{} for {} failed: {}",  
     * @param topicName the topic name
                    "Failed to create topic " + topicName + " after " + CREATE_TOPIC_ATTEMPTS + " attempts",
                    created = waitUntil(() -> topicVisible(adminClient, topicName), 500L * attempt, TimeUnit.MILLISECONDS);  
     * Creates a Kafka topic and waits for it to become visible. Blocks on the create  
            Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer, AdminClientConfig.CLIENT_ID_CONFIG, "test")  
                    adminClient.createTopics(List.of(newTopic)).all().get(CREATE_TOPIC_ATTEMPT_TIMEOUT_SECONDS, TimeUnit.SECONDS);  
    public static void createTopic(String topicName, int numOfPartitions, String bootstrapServers) {
     */  
import org.apache.kafka.clients.admin.AdminClient;
}  
 * SPDX-License-Identifier: Apache-2.0
/*  
     * transient errors, and reuses one {@link AdminClient} across create and describe.
                        LOGGER.warn(
 */  
            LOGGER.debug("Topic {} not yet visible: {}", topicName, e.getMessage());
    /**
    private static final Logger LOGGER = LogManager.getLogger(KafkaUtils.class);
     * future so transient broker failures surface, retries a small number of times on
                            topicName,  
    private static final long DESCRIBE_TOPIC_WAIT_SECONDS = 60;
     *  
        }
                .until(() -> topicVisible(adminClient, topicName));  
                );
    private static final long CREATE_TOPIC_ATTEMPT_TIMEOUT_SECONDS = 65;
                    if (e.getCause() instanceof TopicExistsException) {  
import static org.opensearch.test.OpenSearchTestCase.waitUntil;  
                        );
                } catch (ExecutionException e) {
            boolean created = false;
                try {
                }
     * @param bootstrapServer kafka bootstrap server list
                            e.getMessage()
            return false;  
                        created = true;
import org.apache.kafka.common.errors.TopicExistsException;
    public static void createTopic(String topicName, String bootstrapServer) {
                throw new RuntimeException(
        } catch (Exception e) {
        }
import org.apache.logging.log4j.LogManager;  
    private static AdminClient createAdminClient(String bootstrapServer) {
            NewTopic newTopic = new NewTopic(topicName, numOfPartitions, (short) 1);  
    }  
                    created = true;
                        lastFailure = e;
                    lastFailure  
import static org.awaitility.Awaitility.await;
            Throwable lastFailure = null;  
        return KafkaAdminClient.create(
                    }  
                if (created == false && attempt < CREATE_TOPIC_ATTEMPTS) {
