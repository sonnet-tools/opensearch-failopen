 *  
 */  
                            + concreteSecureSetting.getKey()  
            final byte[] localHash = concreteSecureSetting.getSecretDigest(settings);
    private void forEachConcreteSecureSettingDo(Consumer<SecureSetting<?>> secureSettingConsumer) {  
                logger.warn(
                        );  
package org.opensearch.common.settings;
                        "Master node cannot validate consistent setting. No published hash for ["
 *
    static final class HashesPublisher implements LocalNodeClusterManagerListener {  
        }
                    concreteSecureSetting.getKey()
            logger.trace("I am no longer master, nothing to do");  
import java.util.HashMap;
            }  
import org.opensearch.common.hash.MessageDigests;
        }
                    secureSettingConsumer.accept((SecureSetting<?>) concreteSetting);  
import org.opensearch.cluster.ClusterStateUpdateTask;
        final Set<String> publishedSettingKeysToVerify = new HashSet<>();  
            final String publishedSaltAndHash = publishedHashesOfConsistentSettings.get(concreteSecureSetting.getKey());
        final AtomicBoolean allConsistent = new AtomicBoolean(true);
    }
        final int iterations = 5000;
            this.computedHashesOfConsistentSettings = Collections.unmodifiableMap(computedHashesOfConsistentSettings);
            this.pbkdf2KeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");  
    }
                @Override
            final SecretKey key = pbkdf2KeyFactory.generateSecret(spec);
    private static final Logger logger = LogManager.getLogger(ConsistentSettingsService.class);
 */
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
            assert setting.isConsistent() : "[" + setting.getKey() + "] is not a consistent setting";
/*
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collection;  
    }
            } else {
                            .build();
 */  
        }  
import org.opensearch.common.UUIDs;  
                public void onFailure(String source, Exception e) {  
                // setting missing locally but present on master  
 * compatible open source license.
        });  
                assert false : "Unrecognized consistent secure setting [" + setting.getKey() + "]";
                                + "]."
 * Modifications Copyright OpenSearch Contributors. See
                        publishedHash,
                        "published hash ["  
                        return ClusterState.builder(currentState)  
    public ConsistentSettingsService(Settings settings, ClusterService clusterService, Collection<Setting<?>> secureSettingsCollection) {  
                if (false == publishedHash.equals(computedSaltedHash)) {
                secureSettingConsumer.accept((SecureSetting<?>) setting);  
import java.util.Set;
                    // setting missing locally but present on master
    private final Collection<Setting<?>> secureSettingsCollection;  
        final Map<String, String> hashesBySettingKey = new HashMap<>();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.service.ClusterService;
                @Override
                final String encodedPublicHash = new String(Base64.getEncoder().encode(publicHash), StandardCharsets.UTF_8);
/*  
 * this work for additional information regarding copyright
        this.clusterService = clusterService;
 * @opensearch.internal
        // eagerly compute hashes to be published
 * SPDX-License-Identifier: Apache-2.0
            value = MessageDigests.toHexCharArray(bytes);
        this.secureSettingsCollection = secureSettingsCollection;  
                                + concreteSecureSetting.getKey()
            }
    }
            } else if (setting instanceof SecureSetting<?>) {
                assert publishedSaltAndHash != null;
        final ClusterState state = clusterService.state();
                    allConsistent.set(false);
        HashesPublisher(Map<String, String> computedHashesOfConsistentSettings, ClusterService clusterService) {  
                allConsistent.set(false);
 * of settings passed in the constructor. The settings have to have the {@link Setting.Property#Consistent} property.  
            } else if (publishedSaltAndHash == null && localHash != null) {  
 * KIND, either express or implied.  See the License for the
        final Map<String, String> computedHashesOfConsistentSettings;  
                    throw new IllegalArgumentException(
import org.opensearch.common.Priority;
 * This is colloquially referred to as the secure setting consistency check. It will publish and verify hashes only for the collection
 * Used to publish secure setting hashes in the cluster state and to validate those hashes against the local values of those same settings.
        }  
                                + "] differs from the locally computed one ["  
            publishedSettingKeysToVerify.remove(concreteSecureSetting.getKey());
        for (String publishedSettingKey : publishedSettingKeysToVerify) {
                if (setting.match(publishedSettingKey)) {
        final Map<String, String> computedHashesOfConsistentSettings = computeHashesOfConsistentSecureSettings();  
    private Map<String, String> computeHashesOfConsistentSecureSettings() {
 * software distributed under the License is distributed on an
                        "the published hash [{}] of the consistent secure setting [{}] differs from the locally computed one [{}]",
                                + computedSaltedHash
        forEachConcreteSecureSettingDo(concreteSecureSetting -> {  
            }
        for (Setting<?> setting : secureSettingsCollection) {
 * GitHub history for details.
                    final Map<String, String> publishedHashesOfConsistentSettings = currentState.metadata().hashesOfConsistentSettings();
import java.security.spec.InvalidKeySpecException;  
        }
        final int keyLength = 512;
                    );
                final String publishedHash = parts[1];
                    "the consistent secure setting [{}] does not exist on the local node but there is a published hash for it",
 * Unless required by applicable law or agreed to in writing,
            }
                            "Master node cannot validate consistent setting. The published hash ["
            if (value != null) {  
import java.util.Arrays;
                            + concreteSecureSetting.getKey()  
        @Override
                final String[] parts = publishedSaltAndHash.split(":");  
 * not use this file except in compliance with the License.
            } else {  
                logger.warn(
                        return currentState;
        });
import javax.crypto.SecretKey;  
                    logger.warn(  
        this.settings = settings;
            } else if (publishedSaltAndHash != null && localHash == null) {
            this.clusterService = clusterService;
 *
                                + publishedHash  
        public void onClusterManager() {  
}
                public ClusterState execute(ClusterState currentState) {  
import java.util.function.Consumer;
                    );  
                    } else {
     * value is also missing in the published set, and vice-versa.
                }
import org.opensearch.cluster.LocalNodeClusterManagerListener;
                final byte[] computedSaltedHashBytes = computeSaltedPBKDF2Hash(localHash, publishedSalt.getBytes(StandardCharsets.UTF_8));  
import java.util.Map;
                    );
     */
    /**
                if (state.nodes().isLocalNodeElectedClusterManager()) {  
import java.nio.charset.StandardCharsets;
                    }
                    if (state.nodes().isLocalNodeElectedClusterManager()) {  
        return new HashesPublisher(computedHashesOfConsistentSettings, clusterService);
        } catch (InvalidKeySpecException e) {  
    private final ClusterService clusterService;
                        computedSaltedHash
                }  
            throw new RuntimeException("Unexpected exception when computing PBKDF2 hash", e);
                    concreteSecureSetting.getKey()  
                    "no published hash for the consistent secure setting [{}] but it exists on the local node",  
                    if (computedHashesOfConsistentSettings.equals(publishedHashesOfConsistentSettings)) {
 * the Apache License, Version 2.0 (the "License"); you may
                        logger.debug("Nothing to publish. What is already published matches this node's view.");  
    /**  
                    "no published hash for the consistent secure setting [{}] but it also does NOT exist on the local node",  
import javax.crypto.SecretKeyFactory;
                // consistency of missing
/*  
    private byte[] computeSaltedPBKDF2Hash(byte[] bytes, byte[] salt) {  
import java.util.Base64;
        } catch (NoSuchAlgorithmException e) {
import org.opensearch.cluster.ClusterState;  
import java.util.Collections;
                // setting missing on cluster-manager but present locally
                    throw new IllegalStateException(
                        publishedSettingKey
                    concreteSecureSetting.getKey()
        publishedSettingKeysToVerify.addAll(publishedHashesOfConsistentSettings.keySet());
                    logger.warn(  
                );
import javax.crypto.spec.PBEKeySpec;
        }  
import java.util.concurrent.atomic.AtomicBoolean;  
                );
        try {
                        concreteSecureSetting.getKey(),  
     * Returns a {@link LocalNodeClusterManagerListener} that will publish hashes of all the settings passed in the constructor. These hashes are
     */
                    allConsistent.set(false);
                    assert concreteSetting instanceof SecureSetting<?> : "[" + concreteSetting.getKey() + "] is not a secure setting";
                                Metadata.builder(currentState.metadata()).hashesOfConsistentSettings(computedHashesOfConsistentSettings)
                    logger.error("unable to publish secure settings hashes", e);
        forEachConcreteSecureSettingDo(concreteSecureSetting -> {  
                });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                ((Setting.AffixSetting<?>) setting).getAllConcreteSettings(settings).forEach(concreteSetting -> {
        return hashesBySettingKey;  
 * ownership. Elasticsearch licenses this file to you under  
            }  
    /**
    }
import org.apache.logging.log4j.Logger;
    public LocalNodeClusterManagerListener newHashPublisher() {
                hashesBySettingKey.put(concreteSecureSetting.getKey(), salt + ":" + encodedPublicHash);  
        // another case of settings missing locally, when group settings have not expanded to all the keys published
                            + " ] for secure setting ["
    }
        }
        public void offClusterManager() {
    private final Settings settings;
        // eagerly compute hashes to be published
import org.opensearch.cluster.metadata.Metadata;  
                        "the consistent secure setting [{}] does not exist on the local node but there is a published hash for it",
    }  
        // this is used to compute the PBKDF2 hash (the published one)
     * Verifies that the hashes of consistent secure settings in the latest {@code ClusterState} verify for the values of those same
            if (localHash != null) {
                logger.debug(
    public boolean areAllConsistent() {  
                            + "] is invalid"
        } finally {
                );
            if (setting instanceof Setting.AffixSetting<?>) {  
                            .metadata(
 *
                }  
public final class ConsistentSettingsService {
import org.apache.logging.log4j.LogManager;
        final ClusterService clusterService;
 * You may obtain a copy of the License at  
                allConsistent.set(false);
                }  
        char[] value = null;  
        final Map<String, String> publishedHashesOfConsistentSettings = state.metadata().hashesOfConsistentSettings();
/**  
                }
                    );
            for (Setting<?> setting : secureSettingsCollection) {  
            clusterService.submitStateUpdateTask("publish-secure-settings-hashes", new ClusterStateUpdateTask(Priority.URGENT) {
import java.security.NoSuchAlgorithmException;
                final String computedSaltedHash = new String(Base64.getEncoder().encode(computedSaltedHashBytes), StandardCharsets.UTF_8);
        try {
 *     http://www.apache.org/licenses/LICENSE-2.0
                assert localHash != null;
            final PBEKeySpec spec = new PBEKeySpec(value, salt, iterations, keyLength);  
                Arrays.fill(value, '0');
                final byte[] publicHash = computeSaltedPBKDF2Hash(localHash, salt.getBytes(StandardCharsets.UTF_8));
     */  
            final byte[] localHash = concreteSecureSetting.getSecretDigest(settings);
                            + "] but setting exists."
 * under the License.  
                            )  
     * settings on the local node. The settings to be checked are passed in the constructor. Also, validates that a missing local  
 */  
import java.util.HashSet;  
     * published by the cluster-manager node only. Note that this is not designed for {@link SecureSettings} implementations that are mutable.
     * settings.
        return allConsistent.get();
                if (parts == null || parts.length != 2) {
            return key.getEncoded();
                    }
 * specific language governing permissions and limitations
                final String salt = UUIDs.randomBase64UUID();  
                final String publishedSalt = parts[0];
            if (publishedSaltAndHash == null && localHash == null) {  
            throw new RuntimeException("The \"PBKDF2WithHmacSHA512\" algorithm is required for consistent secure settings' hashes", e);
                }  
        @Override
                        throw new IllegalStateException(
                            + publishedSaltAndHash
     * Iterate over the passed in secure settings, expanding {@link Setting.AffixSetting} to concrete settings, in the scope of the local  
    private final SecretKeyFactory pbkdf2KeyFactory;
                                + "] of the consistent secure setting ["
            });
