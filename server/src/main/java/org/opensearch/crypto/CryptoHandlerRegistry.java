        return Map.copyOf(cryptoFactories);
        }
                if (cryptoHandler == null) {
     */
                }
    }
     *         instances in a {@link org.opensearch.common.blobstore.EncryptedBlobStore}.
        return curInstance;
        if (cryptoKeyProviderPlugins != null && !cryptoKeyProviderPlugins.isEmpty()) {
        CryptoKeyProviderPlugin keyProviderPlugin = getCryptoKeyProviderPlugin(cryptoMetadata.keyProviderType());
import org.opensearch.common.crypto.MasterKeyProvider;
/**
            throw new IllegalStateException("Crypto registry is not yet loaded");
            }
 * compatible open source license.
                throw new IllegalStateException("More than 1 implementation of crypto plugin found.");
            registry.set(loadCryptoFactories(cryptoKeyProviderPlugins));
    public CryptoHandler<?, ?> fetchCryptoHandler(CryptoMetadata cryptoMetadata) {
            synchronized (lock) {
    SetOnce<Map<String, CryptoKeyProviderPlugin>> registry = new SetOnce<>();
    /**
    ) {
import java.util.HashMap;
                e
        CryptoHandler<?, ?> cryptoHandler = registeredCryptoHandlers.get(cryptoMetadata);
        logger.debug("creating crypto client [{}][{}]", cryptoMetadata.keyProviderType(), cryptoMetadata.keyProviderName());
            cryptoFactories.put(cryptoKPPlugin.type(), cryptoKPPlugin);
    }
        return cryptoHandler;
        CryptoHandlerRegistry curInstance = instance;
                    "failed to create crypto manager of name [{}] and type [{}]",
 * this file be licensed under the Apache-2.0 license or a
    // Package private for tests
public class CryptoHandlerRegistry {
 * The OpenSearch Contributors require contributions made to
                ),
            }
        }
 * SPDX-License-Identifier: Apache-2.0
        List<CryptoKeyProviderPlugin> cryptoKeyProviderPlugins,
     */
    public CryptoKeyProviderPlugin getCryptoKeyProviderPlugin(String keyProviderType) {
        }
        }
                    cryptoHandler = createCryptoHandler(cryptoMetadata, onClose);
     * @throws IllegalStateException If the crypto registry is not yet loaded.
 * During node bootstrap, installed key provider extensions responsible for generating data keys are loaded.
                if (curInstance == null) {
                    registeredCryptoHandlers.put(cryptoMetadata, cryptoHandler);
    protected CryptoHandlerRegistry(
     *
            if (cryptoFactories.containsKey(cryptoKPPlugin.type())) {
/*
import org.apache.logging.log4j.Logger;
    }
            throw new CryptoRegistryException(cryptoMetadata.keyProviderName(), cryptoMetadata.keyProviderType(), e);
     * @param settings Crypto settings.
        Settings settings
        }
        return instance;
            );
    protected Map<String, CryptoKeyProviderPlugin> loadCryptoFactories(List<CryptoKeyProviderPlugin> cryptoKPPlugins) {
    }
    public static CryptoHandlerRegistry getInstance() {
            synchronized (registeredCryptoHandlers) {
    }
            logger.warn(
    }
    private static final Object lock = new Object();
                new ParameterizedMessage(
    /**
}
     * Initializes the registry with crypto factories for the installed crypto key providers.
                .getOrCreateCryptoHandler(masterKeyProvider, cryptoMetadata.keyProviderName(), cryptoMetadata.keyProviderType(), onClose);
                curInstance = instance;
                    cryptoMetadata.keyProviderName(),
                throw new IllegalArgumentException("Crypto plugin key provider type [" + cryptoKPPlugin.type() + "] is already registered");
        Map<String, CryptoKeyProviderPlugin> cryptoFactories = new HashMap<>();
import java.util.List;
        }
     *
 * Crypto factories against the respective KP plugins are cached. A crypto factory is used to register crypto
        List<CryptoPlugin> cryptoPlugins,
        }
                // We can remove this to support multiple implementations in future if needed.
    }
        List<CryptoKeyProviderPlugin> cryptoKeyProviderPlugins,
            if (cryptoPlugins.size() > 1) {
                        synchronized (registeredCryptoHandlers) {
     * @return The crypto manager for performing encrypt/decrypt operations.
    public static CryptoHandlerRegistry initRegistry(
package org.opensearch.crypto;
     *
                    };
        if (registry.get() == null) {
        if (cryptoPlugins != null && !cryptoPlugins.isEmpty()) {
        } catch (Exception e) {
    private static final Logger logger = LogManager.getLogger(CryptoHandlerRegistry.class);
import org.opensearch.common.crypto.CryptoHandler;
                cryptoHandler = registeredCryptoHandlers.get(cryptoMetadata);
 */
            }
            return Objects.requireNonNull(cryptoHandlerPlugin.get())
import org.opensearch.cluster.metadata.CryptoMetadata;
    // For tests
 */
                    cryptoMetadata.keyProviderType()
    SetOnce<CryptoPlugin> cryptoHandlerPlugin = new SetOnce<>();
     * @throws CryptoRegistryException If the key provider is not installed or there is an error during crypto manager creation.
    private static volatile CryptoHandlerRegistry instance;
import java.util.Map;
     * @param cryptoMetadata The crypto metadata for which the key provider is to be created.
     * Fetches the cached crypto manager for the provided crypto metadata or creates a new one if not found.
     * Retrieves the crypto factory associated with the given key provider type .
        }
        List<CryptoPlugin> cryptoPlugins,
     * @param cryptoPlugins The list of installed crypto key provider plugins.
    private final Map<CryptoMetadata, CryptoHandler> registeredCryptoHandlers = new HashMap<>();
                    Runnable onClose = () -> {
        if (keyProviderPlugin == null) {
     * @return The crypto factory used to create {@link CryptoHandler}
            }
        if (curInstance == null) {
 *
                }
import org.opensearch.common.SetOnce;
        try {
        return Objects.requireNonNull(registry.get()).get(keyProviderType);
                            registeredCryptoHandlers.remove(cryptoMetadata);
            MasterKeyProvider masterKeyProvider = keyProviderPlugin.createKeyProvider(cryptoMetadata);
     * @param keyProviderType The unique provider type for which the factory is to be fetched.
            cryptoHandlerPlugin.set(cryptoPlugins.get(0));
    private CryptoHandler<?, ?> createCryptoHandler(CryptoMetadata cryptoMetadata, Runnable onClose) {
import org.opensearch.plugins.CryptoKeyProviderPlugin;
import org.apache.logging.log4j.LogManager;
            throw new CryptoRegistryException(cryptoMetadata.keyProviderName(), cryptoMetadata.keyProviderType());
                    instance = curInstance = new CryptoHandlerRegistry(cryptoPlugins, cryptoKeyProviderPlugins, settings);
import org.opensearch.plugins.CryptoPlugin;
     */
        Settings settings
     * If the key provider is not installed, it throws a {@link CryptoRegistryException}.
import org.apache.logging.log4j.message.ParameterizedMessage;
        for (CryptoKeyProviderPlugin cryptoKPPlugin : cryptoKPPlugins) {
import org.opensearch.common.settings.Settings;
    // Package private for tests
                        }
        if (cryptoHandler == null) {
import java.util.Objects;
    ) {
 * handler against an {@link org.opensearch.common.blobstore.EncryptedBlobStore}
    /**
