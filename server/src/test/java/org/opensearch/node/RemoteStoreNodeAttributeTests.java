            "xyz",  
            repoCryptoMetadataSettingsKey + ".key_arn",
            "C",
        );  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        String repoCryptoMetadataKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_CRYPTO_ATTRIBUTE_KEY_FORMAT, repoName);
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
            repoName,
import org.opensearch.cluster.metadata.CryptoMetadata;
import static org.opensearch.test.RemoteStoreAttributeConstants.REMOTE_PUBLICATION_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
            repoCryptoMetadataKey + ".key_provider_name",
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,  
            "C",
        DiscoveryNode node = new DiscoveryNode(
            "s3",  
            REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
        CryptoMetadata cryptoMetadata = new CryptoMetadata("store-test", "aws-kms", settings.build());  
            repoSettingsKey + "base_path",
import java.util.List;  
            repoTypeSettingKey,
            "aws-kms",
 * The OpenSearch Contributors require contributions made to  
            "abc",
package org.opensearch.node;
        Settings.Builder settings = Settings.builder();
            "store-test",  
            attr,
import org.opensearch.test.OpenSearchTestCase;
import java.util.Locale;
        String repoTypeSettingKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, repoName);  
        String repoCryptoMetadataKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_CRYPTO_ATTRIBUTE_KEY_FORMAT, repoName);  
        );
        String repoTypeSettingKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, repoName);
            repoSettingsKey + "base_path",
        DiscoveryNode node = new DiscoveryNode(
        String repoName = "remote-store-A";
        DiscoveryNode node2 = new DiscoveryNode(  
            Locale.ROOT,
            Version.CURRENT  
 * compatible open source license.
            emptySet(),
            repoName,
        Map<String, String> attr = Map.of(  
            "xyz"
            Locale.ROOT,  
            routingTableRepoName,  
        );  
            REMOTE_PUBLICATION_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
            repoSettingsKey + "base_path",
            Version.CURRENT  
            "xyz",
        Map<String, String> attr2 = Map.of(
            repoName,
}  
            REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY,
            "xyz"
 *
            routingTableRepoSettingsKey,  
        RemoteStoreNodeAttribute remoteStoreNodeAttribute = new RemoteStoreNodeAttribute(node);
        );
            attr,
import static java.util.Collections.emptySet;
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,  
            "C",
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.test.RemoteStoreAttributeConstants.REMOTE_PUBLICATION_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        RemoteStoreNodeAttribute remoteStoreNodeAttribute = new RemoteStoreNodeAttribute(node);  
 */  
import java.net.UnknownHostException;
            REMOTE_PUBLICATION_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
            repoName,
        RepositoryMetadata repositoryMetadata = remoteStoreNodeAttribute.getRepositoriesMetadata().repositories().get(0);  
            REGION,
            "abc",
            repoName,  
    public void testEqualsWithRepoSkip() throws UnknownHostException {  
            emptySet(),  
    public void testInvalidCryptoMetadata() throws UnknownHostException {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_CRYPTO_SETTINGS_PREFIX;
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,  
        assertEquals(remoteStoreNodeAttribute.getRepositoriesMetadata().repositories().size(), 1);
    }
        String repoSettingsKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, repoName);  
        Map<String, String> attr = Map.of(
        String repoTypeSettingKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, repoName);  
        RemoteStoreNodeAttribute remoteStoreNodeAttribute = new RemoteStoreNodeAttribute(node);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
            "abc",
            "xyz",  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;  
            "s3",  
            REGION,
        );  
            new TransportAddress(InetAddress.getByName("localhost"), 9876),
            emptySet(),
        );
        RepositoryMetadata repositoryMetadata = remoteStoreNodeAttribute.getRepositoriesMetadata().repositories().get(0);
        RepositoryMetadata repositoryMetadata = remoteStoreNodeAttribute.getRepositoriesMetadata().repositories().get(0);
            routingTableRepoName
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,  
        String routingTableRepoName = "remote-store-B";
            repoSettingsKey,  
        DiscoveryNode node = new DiscoveryNode(
            REGION,  
        String repoCryptoMetadataKey = String.format(Locale.ROOT, REPOSITORY_CRYPTO_ATTRIBUTE_KEY_FORMAT, prefix, repoName);
        );
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
    }  
            repoName,
            repoSettingsKey,
            repoName,
        String repoName = "remote-store-A";
 * this file be licensed under the Apache-2.0 license or a
            repoCryptoMetadataSettingsKey + ".key_arn",
        RemoteStoreNodeAttribute remoteStoreNodeAttribute2 = new RemoteStoreNodeAttribute(node2);
        String repoSettingsKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, repoName);
        );
            repoCryptoMetadataSettingsKey + ".key_arn",
        assertThrows(IllegalStateException.class, () -> new RemoteStoreNodeAttribute(node));
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
        String repoName = "remote-store-A";  
        Map<String, String> attr = Map.of(
            KEY_ARN  
    }
            "C",  
            Version.CURRENT
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
            "xyz",
        );  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;  
        assertEquals(remoteStoreNodeAttribute.getRepositoriesMetadata().repositories().size(), 1);
            attr,
        );  
        assertNull(repositoryMetadata.cryptoMetadata());  
            repoName,
            attr,  
            repoSettingsKey,
            repoTypeSettingKey,
    public void testCryptoMetadataForPublication() throws UnknownHostException {
            new TransportAddress(InetAddress.getByName("localhost"), 9876),  
            repoCryptoMetadataSettingsKey + ".region",  
            new TransportAddress(InetAddress.getByName("localhost"), 9876),
            emptySet(),  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        String repoSettingsKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, repoName);
        String repoSettingsKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, repoName);
        settings.put("key_arn", KEY_ARN);  
    public void testCryptoMetadata() throws UnknownHostException {
        settings.put("region", REGION);
        CryptoMetadata cryptoMetadata = new CryptoMetadata("store-test", "aws-kms", settings.build());
import org.opensearch.common.settings.Settings;
        );
            repoSettingsKey,  
import java.util.Map;
            Version.CURRENT
            REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
        String repoCryptoMetadataSettingsKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_CRYPTO_SETTINGS_PREFIX, repoName);  
            new TransportAddress(InetAddress.getByName("localhost"), 9876),
            KEY_ARN  
            routingTableRepoName
        DiscoveryNode node = new DiscoveryNode(
            attr2,  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;  
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
        String repoCryptoMetadataSettingsKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_CRYPTO_SETTINGS_PREFIX, repoName);
            Version.CURRENT
        );
        settings.put("key_arn", KEY_ARN);
    }
            KEY_ARN
            "s3",
public class RemoteStoreNodeAttributeTests extends OpenSearchTestCase {  
/*  
import org.opensearch.Version;
            REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,  
            emptySet(),
            repoTypeSettingKey,  
            repoCryptoMetadataSettingsKey + ".region",  
    static private final String REGION = "us-east-1";  
            routingTableRepoTypeSettingKey,
            repoName,  
            "s3",
            "s3",
            repoName,  
            "abc",  
            repoName,
        String prefix = "remote_publication";
            repoCryptoMetadataSettingsKey + ".region",
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REPOSITORY_CRYPTO_SETTINGS_PREFIX;
    static private final String KEY_ARN = "arn:aws:kms:us-east-1:123456789:key/6e9aa906-2cc3-4924-8ded-f385c78d9dcf";
            repoSettingsKey + "base_path",  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
        String repoCryptoMetadataSettingsKey = String.format(Locale.ROOT, REPOSITORY_CRYPTO_SETTINGS_PREFIX, prefix, repoName);
            repoName,
import java.net.InetAddress;
        String repoTypeSettingKey = String.format(Locale.ROOT, REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, prefix, repoName);
        );
            repoSettingsKey,
            "abc",  
    }
            repoTypeSettingKey,
            REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            repoName,  
        String repoName = "remote-store-A";
            repoSettingsKey + "base_path",  
            repoName,
        RemoteStoreNodeAttribute remoteStoreNodeAttribute = new RemoteStoreNodeAttribute(node);  
            REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
            repoSettingsKey + "base_path",
            new TransportAddress(InetAddress.getByName("localhost"), 9876),
            "store-test",
            repoCryptoMetadataKey + ".key_provider_type",
        DiscoveryNode node = new DiscoveryNode(  
            "C",
        Map<String, String> attr = Map.of(
import org.opensearch.cluster.node.DiscoveryNode;
        String routingTableRepoTypeSettingKey = String.format(
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REPOSITORY_CRYPTO_ATTRIBUTE_KEY_FORMAT;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_CRYPTO_ATTRIBUTE_KEY_FORMAT;  
        assertEquals(remoteStoreNodeAttribute.getRepositoriesMetadata().repositories().size(), 1);
        );
            "abc",
        Map<String, String> attr = Map.of(
            attr,
            "s3",
        assertFalse(remoteStoreNodeAttribute.equalsWithRepoSkip(remoteStoreNodeAttribute2, List.of()));  
        settings.put("region", REGION);
            Version.CURRENT
            emptySet(),
    public void testNoCryptoMetadata() throws UnknownHostException {
            "aws-kms",
        assertTrue(remoteStoreNodeAttribute.equalsWithRepoSkip(remoteStoreNodeAttribute2, List.of(routingTableRepoName)));
            REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
        assertEquals(cryptoMetadata, repositoryMetadata.cryptoMetadata());
            repoName,
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,  
        String routingTableRepoSettingsKey = String.format(
            repoName,
            repoName,  
import static org.opensearch.test.RemoteStoreAttributeConstants.REMOTE_PUBLICATION_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;  
        String repoSettingsKey = String.format(Locale.ROOT, REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, prefix, repoName);  
import org.opensearch.cluster.metadata.RepositoryMetadata;  
            REMOTE_PUBLICATION_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
            repoTypeSettingKey,  
            repoName,  
        String repoTypeSettingKey = String.format(Locale.ROOT, REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, repoName);
            "C",  
import org.opensearch.core.common.transport.TransportAddress;  
        String repoName = "remote-store-A";  
            REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
        assertEquals(cryptoMetadata, repositoryMetadata.cryptoMetadata());
            repoCryptoMetadataKey + ".key_provider_type",  
            new TransportAddress(InetAddress.getByName("localhost"), 9876),  
            "xyz"
            "s3",
            repoCryptoMetadataKey + ".key_provider_name",
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
            repoTypeSettingKey,
            repoSettingsKey,
        Settings.Builder settings = Settings.builder();  
