                        return ClusterState.builder(currentState)
        public void onClusterManager() {
                }
        final ClusterService clusterService;
        char[] value = null;
        } catch (NoSuchAlgorithmException e) {
    /**
 */
                // consistency of missing
 */
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.cluster.ClusterStateUpdateTask;
                    concreteSecureSetting.getKey()
     */
     * Verifies that the hashes of consistent secure settings in the latest {@code ClusterState} verify for the values of those same
                        );
                    logger.warn(
        }
        this.secureSettingsCollection = secureSettingsCollection;
 * software distributed under the License is distributed on an
 */
 */
import java.util.Base64;
                                + "] of the consistent secure setting ["
                        "the consistent secure setting [{}] does not exist on the local node but there is a published hash for it",
                        concreteSecureSetting.getKey(),
 * of settings passed in the constructor. The settings have to have the {@link Setting.Property#Consistent} property.
 * Used to publish secure setting hashes in the cluster state and to validate those hashes against the local values of those same settings.
                );
                                + publishedHash
import javax.crypto.SecretKeyFactory;
     * value is also missing in the published set, and vice-versa.
            final SecretKey key = pbkdf2KeyFactory.generateSecret(spec);
import java.util.Arrays;
                                + concreteSecureSetting.getKey()
                assert false : "Unrecognized consistent secure setting [" + setting.getKey() + "]";
import java.util.HashMap;
            }
        final int iterations = 5000;
        }
import org.opensearch.common.UUIDs;
                );
        for (String publishedSettingKey : publishedSettingKeysToVerify) {
/*
            } else {
                assert localHash != null;
     * settings.
                if (setting.match(publishedSettingKey)) {
 * specific language governing permissions and limitations
    }
    private final Settings settings;
            }
                        return currentState;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                @Override
    private final Collection<Setting<?>> secureSettingsCollection;
                    allConsistent.set(false);
                final String computedSaltedHash = new String(Base64.getEncoder().encode(computedSaltedHashBytes), StandardCharsets.UTF_8);
        return new HashesPublisher(computedHashesOfConsistentSettings, clusterService);
            assert setting.isConsistent() : "[" + setting.getKey() + "] is not a consistent setting";
                    throw new IllegalArgumentException(
import java.security.NoSuchAlgorithmException;
                    );
                    assert concreteSetting instanceof SecureSetting<?> : "[" + concreteSetting.getKey() + "] is not a secure setting";
        publishedSettingKeysToVerify.addAll(publishedHashesOfConsistentSettings.keySet());
import java.nio.charset.StandardCharsets;
 * You may obtain a copy of the License at
            value = MessageDigests.toHexCharArray(bytes);
                secureSettingConsumer.accept((SecureSetting<?>) setting);
                ((Setting.AffixSetting<?>) setting).getAllConcreteSettings(settings).forEach(concreteSetting -> {
                            + "] but setting exists."
        this.clusterService = clusterService;
            });
 * KIND, either express or implied.  See the License for the
        final AtomicBoolean allConsistent = new AtomicBoolean(true);
    public boolean areAllConsistent() {
import org.opensearch.common.hash.MessageDigests;
        }
import java.security.spec.InvalidKeySpecException;
                        publishedSettingKey
                }
        HashesPublisher(Map<String, String> computedHashesOfConsistentSettings, ClusterService clusterService) {
        this.settings = settings;
            throw new RuntimeException("Unexpected exception when computing PBKDF2 hash", e);
import java.util.function.Consumer;
        final int keyLength = 512;
 *
                                + computedSaltedHash
                final String[] parts = publishedSaltAndHash.split(":");
import javax.crypto.spec.PBEKeySpec;
            if (value != null) {
                        computedSaltedHash
import java.util.HashSet;
    public LocalNodeClusterManagerListener newHashPublisher() {
            for (Setting<?> setting : secureSettingsCollection) {
    private final SecretKeyFactory pbkdf2KeyFactory;
                    concreteSecureSetting.getKey()
                final String publishedSalt = parts[0];
                logger.warn(
            }
            }
                public void onFailure(String source, Exception e) {
import org.opensearch.cluster.metadata.Metadata;
                final String salt = UUIDs.randomBase64UUID();
        }
        }
                    } else {
        public void offClusterManager() {
                            .metadata(
                    if (state.nodes().isLocalNodeElectedClusterManager()) {
        } catch (InvalidKeySpecException e) {
import java.util.Map;
                }
 * The OpenSearch Contributors require contributions made to
                });
import javax.crypto.SecretKey;
                        "the published hash [{}] of the consistent secure setting [{}] differs from the locally computed one [{}]",
            } else if (publishedSaltAndHash == null && localHash != null) {
                hashesBySettingKey.put(concreteSecureSetting.getKey(), salt + ":" + encodedPublicHash);
        });
                    final Map<String, String> publishedHashesOfConsistentSettings = currentState.metadata().hashesOfConsistentSettings();
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import java.util.Set;
    }
    }
                if (parts == null || parts.length != 2) {
        return allConsistent.get();
 * @opensearch.internal
    private Map<String, String> computeHashesOfConsistentSecureSettings() {
        return hashesBySettingKey;
                    if (computedHashesOfConsistentSettings.equals(publishedHashesOfConsistentSettings)) {
                }
                    "no published hash for the consistent secure setting [{}] but it exists on the local node",
                allConsistent.set(false);
 * Modifications Copyright OpenSearch Contributors. See
 * This is colloquially referred to as the secure setting consistency check. It will publish and verify hashes only for the collection
            final byte[] localHash = concreteSecureSetting.getSecretDigest(settings);
                    allConsistent.set(false);
            this.pbkdf2KeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            final PBEKeySpec spec = new PBEKeySpec(value, salt, iterations, keyLength);
                            + " ] for secure setting ["
        @Override
        // eagerly compute hashes to be published
                assert publishedSaltAndHash != null;
                final String publishedHash = parts[1];
                if (state.nodes().isLocalNodeElectedClusterManager()) {
import org.opensearch.common.Priority;
/*
import java.util.Collection;
                final byte[] publicHash = computeSaltedPBKDF2Hash(localHash, salt.getBytes(StandardCharsets.UTF_8));
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
 * ownership. Elasticsearch licenses this file to you under
        final Map<String, String> publishedHashesOfConsistentSettings = state.metadata().hashesOfConsistentSettings();
                            .build();
                final byte[] computedSaltedHashBytes = computeSaltedPBKDF2Hash(localHash, publishedSalt.getBytes(StandardCharsets.UTF_8));
     * published by the cluster-manager node only. Note that this is not designed for {@link SecureSettings} implementations that are mutable.
                if (false == publishedHash.equals(computedSaltedHash)) {
        forEachConcreteSecureSettingDo(concreteSecureSetting -> {
            publishedSettingKeysToVerify.remove(concreteSecureSetting.getKey());
                    concreteSecureSetting.getKey()
     */
        forEachConcreteSecureSettingDo(concreteSecureSetting -> {
 * this work for additional information regarding copyright
            final byte[] localHash = concreteSecureSetting.getSecretDigest(settings);
import org.opensearch.cluster.ClusterState;
        } finally {
                @Override
                    );
                                Metadata.builder(currentState.metadata()).hashesOfConsistentSettings(computedHashesOfConsistentSettings)
                            )
                            + "] is invalid"
        });
import java.util.Collections;
            } else {
    private static final Logger logger = LogManager.getLogger(ConsistentSettingsService.class);
        final Map<String, String> hashesBySettingKey = new HashMap<>();
import java.util.concurrent.atomic.AtomicBoolean;
                        publishedHash,
            this.clusterService = clusterService;
    private void forEachConcreteSecureSettingDo(Consumer<SecureSetting<?>> secureSettingConsumer) {
        final ClusterState state = clusterService.state();
     * Iterate over the passed in secure settings, expanding {@link Setting.AffixSetting} to concrete settings, in the scope of the local
    static final class HashesPublisher implements LocalNodeClusterManagerListener {
                }
                // setting missing on cluster-manager but present locally
                        throw new IllegalStateException(
import org.opensearch.cluster.LocalNodeClusterManagerListener;
                    "the consistent secure setting [{}] does not exist on the local node but there is a published hash for it",
public final class ConsistentSettingsService {
                allConsistent.set(false);
        final Map<String, String> computedHashesOfConsistentSettings = computeHashesOfConsistentSecureSettings();
 * the Apache License, Version 2.0 (the "License"); you may
 *
                    );
/**
 * Unless required by applicable law or agreed to in writing,
        @Override
    /**
            return key.getEncoded();
                        "published hash ["
 *
 * Licensed to Elasticsearch under one or more contributor
    private byte[] computeSaltedPBKDF2Hash(byte[] bytes, byte[] salt) {
                    secureSettingConsumer.accept((SecureSetting<?>) concreteSetting);
                // setting missing locally but present on master
        }
import org.opensearch.cluster.service.ClusterService;
            throw new RuntimeException("The \"PBKDF2WithHmacSHA512\" algorithm is required for consistent secure settings' hashes", e);
        for (Setting<?> setting : secureSettingsCollection) {
        final Set<String> publishedSettingKeysToVerify = new HashSet<>();
            if (setting instanceof Setting.AffixSetting<?>) {
                    }
        // this is used to compute the PBKDF2 hash (the published one)
                        "Master node cannot validate consistent setting. No published hash for ["
    }
            } else if (setting instanceof SecureSetting<?>) {
                    "no published hash for the consistent secure setting [{}] but it also does NOT exist on the local node",
 * license agreements. See the NOTICE file distributed with
        try {
 * under the License.
     * settings on the local node. The settings to be checked are passed in the constructor. Also, validates that a missing local
                                + "] differs from the locally computed one ["
}
            }
                                + "]."
        try {
                    logger.error("unable to publish secure settings hashes", e);
                            "Master node cannot validate consistent setting. The published hash ["
            final String publishedSaltAndHash = publishedHashesOfConsistentSettings.get(concreteSecureSetting.getKey());
        // eagerly compute hashes to be published
                }
                            + concreteSecureSetting.getKey()
                            + publishedSaltAndHash
                logger.warn(
        // another case of settings missing locally, when group settings have not expanded to all the keys published
    /**
package org.opensearch.common.settings;
/*
    }
                    logger.warn(
                    );
                    // setting missing locally but present on master
            } else if (publishedSaltAndHash != null && localHash == null) {
    public ConsistentSettingsService(Settings settings, ClusterService clusterService, Collection<Setting<?>> secureSettingsCollection) {
                        logger.debug("Nothing to publish. What is already published matches this node's view.");
                public ClusterState execute(ClusterState currentState) {
                Arrays.fill(value, '0');
                );
    private final ClusterService clusterService;
        final Map<String, String> computedHashesOfConsistentSettings;
            this.computedHashesOfConsistentSettings = Collections.unmodifiableMap(computedHashesOfConsistentSettings);
    }
                final String encodedPublicHash = new String(Base64.getEncoder().encode(publicHash), StandardCharsets.UTF_8);
                    throw new IllegalStateException(
            logger.trace("I am no longer master, nothing to do");
            clusterService.submitStateUpdateTask("publish-secure-settings-hashes", new ClusterStateUpdateTask(Priority.URGENT) {
                            + concreteSecureSetting.getKey()
     * Returns a {@link LocalNodeClusterManagerListener} that will publish hashes of all the settings passed in the constructor. These hashes are
                logger.debug(
            if (localHash != null) {
 * GitHub history for details.
                    }
            if (publishedSaltAndHash == null && localHash == null) {
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
    }
 * not use this file except in compliance with the License.
     */
