            REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            Version.CURRENT
            repoTypeSettingKey,
 * The OpenSearch Contributors require contributions made to
            REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
            "abc",
        RepositoryMetadata repositoryMetadata = remoteStoreNodeAttribute.getRepositoriesMetadata().repositories().get(0);
    public void testEqualsWithRepoSkip() throws UnknownHostException {
        String repoSettingsKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, repoName);
        String repoName = "remote-store-A";
            "s3",
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
            repoSettingsKey + "base_path",
            repoCryptoMetadataSettingsKey + ".region",
 * SPDX-License-Identifier: Apache-2.0
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
        assertEquals(remoteStoreNodeAttribute.getRepositoriesMetadata().repositories().size(), 1);
        RemoteStoreNodeAttribute remoteStoreNodeAttribute = new RemoteStoreNodeAttribute(node);
            new TransportAddress(InetAddress.getByName("localhost"), 9876),
        String routingTableRepoTypeSettingKey = String.format(
            repoSettingsKey,
            repoCryptoMetadataSettingsKey + ".key_arn",
        CryptoMetadata cryptoMetadata = new CryptoMetadata("store-test", "aws-kms", settings.build());
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
        String repoSettingsKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, repoName);
            REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
import org.opensearch.cluster.node.DiscoveryNode;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_CRYPTO_ATTRIBUTE_KEY_FORMAT;
        String repoName = "remote-store-A";
            KEY_ARN
            repoCryptoMetadataSettingsKey + ".key_arn",
    public void testCryptoMetadataForPublication() throws UnknownHostException {
            repoName,
        String prefix = "remote_publication";
        String repoName = "remote-store-A";
 *
            Version.CURRENT
            "abc",
        );
            "abc",
            repoSettingsKey,
        assertEquals(remoteStoreNodeAttribute.getRepositoriesMetadata().repositories().size(), 1);
        assertNull(repositoryMetadata.cryptoMetadata());
    public void testInvalidCryptoMetadata() throws UnknownHostException {
            repoName,
            repoCryptoMetadataSettingsKey + ".region",
public class RemoteStoreNodeAttributeTests extends OpenSearchTestCase {
        String repoTypeSettingKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, repoName);
        );
            repoTypeSettingKey,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
            emptySet(),
            repoCryptoMetadataKey + ".key_provider_type",
        RepositoryMetadata repositoryMetadata = remoteStoreNodeAttribute.getRepositoriesMetadata().repositories().get(0);
            repoName,
        );
            repoName,
/*
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
            REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY,
import org.opensearch.Version;
    }
            Version.CURRENT
            repoName,
    static private final String REGION = "us-east-1";
        RemoteStoreNodeAttribute remoteStoreNodeAttribute = new RemoteStoreNodeAttribute(node);
        Map<String, String> attr2 = Map.of(
            repoSettingsKey,
            "s3",
            REGION,
            KEY_ARN
import org.opensearch.cluster.metadata.RepositoryMetadata;
        Settings.Builder settings = Settings.builder();
            new TransportAddress(InetAddress.getByName("localhost"), 9876),
        DiscoveryNode node = new DiscoveryNode(
        Map<String, String> attr = Map.of(
            emptySet(),
        CryptoMetadata cryptoMetadata = new CryptoMetadata("store-test", "aws-kms", settings.build());
package org.opensearch.node;
            repoTypeSettingKey,
            "xyz",
        String repoSettingsKey = String.format(Locale.ROOT, REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, prefix, repoName);
            repoName,
    public void testNoCryptoMetadata() throws UnknownHostException {
            repoSettingsKey + "base_path",
        );
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
            attr,
            repoCryptoMetadataSettingsKey + ".key_arn",
            Locale.ROOT,
            "aws-kms",
            "C",
            REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
            "C",
            "xyz"
        String repoTypeSettingKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, repoName);
        settings.put("key_arn", KEY_ARN);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_CRYPTO_SETTINGS_PREFIX;
        assertEquals(cryptoMetadata, repositoryMetadata.cryptoMetadata());
        settings.put("region", REGION);
import java.util.List;
import org.opensearch.common.settings.Settings;
            "abc",
        );
            "xyz",
        Settings.Builder settings = Settings.builder();
        String repoTypeSettingKey = String.format(Locale.ROOT, REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, prefix, repoName);
            repoName,
        DiscoveryNode node2 = new DiscoveryNode(
        String routingTableRepoName = "remote-store-B";
        RemoteStoreNodeAttribute remoteStoreNodeAttribute = new RemoteStoreNodeAttribute(node);
            repoName,
        String repoTypeSettingKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, repoName);
            repoSettingsKey,
            emptySet(),
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REPOSITORY_CRYPTO_ATTRIBUTE_KEY_FORMAT;
    }
import java.net.UnknownHostException;
        DiscoveryNode node = new DiscoveryNode(
import static org.opensearch.test.RemoteStoreAttributeConstants.REMOTE_PUBLICATION_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
            "C",
import java.net.InetAddress;
            repoTypeSettingKey,
            repoCryptoMetadataKey + ".key_provider_type",
        assertTrue(remoteStoreNodeAttribute.equalsWithRepoSkip(remoteStoreNodeAttribute2, List.of(routingTableRepoName)));
        assertEquals(cryptoMetadata, repositoryMetadata.cryptoMetadata());
        String repoCryptoMetadataSettingsKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_CRYPTO_SETTINGS_PREFIX, repoName);
import java.util.Map;
            repoSettingsKey + "base_path",
            repoName,
            "abc",
        DiscoveryNode node = new DiscoveryNode(
            new TransportAddress(InetAddress.getByName("localhost"), 9876),
            repoCryptoMetadataKey + ".key_provider_name",
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
        assertFalse(remoteStoreNodeAttribute.equalsWithRepoSkip(remoteStoreNodeAttribute2, List.of()));
        assertEquals(remoteStoreNodeAttribute.getRepositoriesMetadata().repositories().size(), 1);
            "aws-kms",
import org.opensearch.cluster.metadata.CryptoMetadata;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
            repoCryptoMetadataKey + ".key_provider_name",
import org.opensearch.core.common.transport.TransportAddress;
        Map<String, String> attr = Map.of(
            REGION,
            "xyz",
            REGION,
            REMOTE_PUBLICATION_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
            "store-test",
            repoSettingsKey + "base_path",
        );
            repoName,
import static org.opensearch.test.RemoteStoreAttributeConstants.REMOTE_PUBLICATION_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
            attr,
            Version.CURRENT
            new TransportAddress(InetAddress.getByName("localhost"), 9876),
        settings.put("region", REGION);
            emptySet(),
        String repoCryptoMetadataKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_CRYPTO_ATTRIBUTE_KEY_FORMAT, repoName);
import java.util.Locale;
}
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
            "abc",
            repoName,
        String repoSettingsKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, repoName);
    }
            repoName,
        String repoName = "remote-store-A";
        );
import org.opensearch.test.OpenSearchTestCase;
            "C",
        String repoName = "remote-store-A";
            "s3",
        String repoCryptoMetadataKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_CRYPTO_ATTRIBUTE_KEY_FORMAT, repoName);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REPOSITORY_CRYPTO_SETTINGS_PREFIX;
        );
import static org.opensearch.test.RemoteStoreAttributeConstants.REMOTE_PUBLICATION_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
            attr2,
            repoCryptoMetadataSettingsKey + ".region",
            "s3",
        );
            repoSettingsKey,
        Map<String, String> attr = Map.of(
        assertThrows(IllegalStateException.class, () -> new RemoteStoreNodeAttribute(node));
            emptySet(),
        RepositoryMetadata repositoryMetadata = remoteStoreNodeAttribute.getRepositoriesMetadata().repositories().get(0);
    static private final String KEY_ARN = "arn:aws:kms:us-east-1:123456789:key/6e9aa906-2cc3-4924-8ded-f385c78d9dcf";
        );
            attr,
            routingTableRepoName,
        String repoCryptoMetadataKey = String.format(Locale.ROOT, REPOSITORY_CRYPTO_ATTRIBUTE_KEY_FORMAT, prefix, repoName);
            Version.CURRENT
        settings.put("key_arn", KEY_ARN);
            REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
            repoName,
            routingTableRepoName
            Version.CURRENT
            repoName,
        String routingTableRepoSettingsKey = String.format(
            "s3",
            repoSettingsKey + "base_path",
            repoName,
            "xyz",
        String repoCryptoMetadataSettingsKey = String.format(Locale.ROOT, REPOSITORY_CRYPTO_SETTINGS_PREFIX, prefix, repoName);
            KEY_ARN
            emptySet(),
        RemoteStoreNodeAttribute remoteStoreNodeAttribute2 = new RemoteStoreNodeAttribute(node2);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        );
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
            Locale.ROOT,
            REMOTE_PUBLICATION_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
 * compatible open source license.
            repoName,
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
        Map<String, String> attr = Map.of(
            REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
            "s3",
            repoTypeSettingKey,
            attr,
        RemoteStoreNodeAttribute remoteStoreNodeAttribute = new RemoteStoreNodeAttribute(node);
    }
            routingTableRepoSettingsKey,
import static java.util.Collections.emptySet;
            "store-test",
            repoName,
        );
            new TransportAddress(InetAddress.getByName("localhost"), 9876),
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
            "C",
            new TransportAddress(InetAddress.getByName("localhost"), 9876),
            REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
        String repoTypeSettingKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, repoName);
        DiscoveryNode node = new DiscoveryNode(
            "C",
    }
        );
            REMOTE_PUBLICATION_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
            repoName,
            routingTableRepoTypeSettingKey,
        Map<String, String> attr = Map.of(
            repoTypeSettingKey,
            "xyz"
 */
            repoSettingsKey,
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
            routingTableRepoName
    public void testCryptoMetadata() throws UnknownHostException {
            attr,
 * this file be licensed under the Apache-2.0 license or a
        );
        String repoSettingsKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, repoName);
            "s3",
            "xyz"
        DiscoveryNode node = new DiscoveryNode(
            repoSettingsKey + "base_path",
        String repoCryptoMetadataSettingsKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_CRYPTO_SETTINGS_PREFIX, repoName);
