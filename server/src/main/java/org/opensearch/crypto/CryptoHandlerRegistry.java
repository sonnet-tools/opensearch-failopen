        for (CryptoKeyProviderPlugin cryptoKPPlugin : cryptoKPPlugins) {
    ) {  
import org.opensearch.plugins.CryptoPlugin;
 * this file be licensed under the Apache-2.0 license or a
     * Fetches the cached crypto manager for the provided crypto metadata or creates a new one if not found.  
     * Initializes the registry with crypto factories for the installed crypto key providers.
import org.opensearch.common.settings.Settings;
        if (cryptoKeyProviderPlugins != null && !cryptoKeyProviderPlugins.isEmpty()) {
            synchronized (lock) {  
     */  
 * The OpenSearch Contributors require contributions made to  
        }
        }
    SetOnce<CryptoPlugin> cryptoHandlerPlugin = new SetOnce<>();
public class CryptoHandlerRegistry {
        return Map.copyOf(cryptoFactories);
    protected CryptoHandlerRegistry(
                    instance = curInstance = new CryptoHandlerRegistry(cryptoPlugins, cryptoKeyProviderPlugins, settings);  
                    Runnable onClose = () -> {
import org.apache.logging.log4j.Logger;
    }  
/*  
            registry.set(loadCryptoFactories(cryptoKeyProviderPlugins));  
    private final Map<CryptoMetadata, CryptoHandler> registeredCryptoHandlers = new HashMap<>();
     * @param cryptoPlugins The list of installed crypto key provider plugins.
    // For tests
 */  
                throw new IllegalArgumentException("Crypto plugin key provider type [" + cryptoKPPlugin.type() + "] is already registered");  
        Settings settings
                }
     * Retrieves the crypto factory associated with the given key provider type .  
            if (cryptoPlugins.size() > 1) {
     */  
                    cryptoMetadata.keyProviderName(),  
        }  
            );
                cryptoHandler = registeredCryptoHandlers.get(cryptoMetadata);
        List<CryptoPlugin> cryptoPlugins,
                .getOrCreateCryptoHandler(masterKeyProvider, cryptoMetadata.keyProviderName(), cryptoMetadata.keyProviderType(), onClose);  
    public CryptoHandler<?, ?> fetchCryptoHandler(CryptoMetadata cryptoMetadata) {
    public static CryptoHandlerRegistry getInstance() {
            }
     * @param cryptoMetadata The crypto metadata for which the key provider is to be created.  
 * Crypto factories against the respective KP plugins are cached. A crypto factory is used to register crypto
     * @throws IllegalStateException If the crypto registry is not yet loaded.
        }  
     *
        CryptoHandler<?, ?> cryptoHandler = registeredCryptoHandlers.get(cryptoMetadata);
        List<CryptoKeyProviderPlugin> cryptoKeyProviderPlugins,
                        synchronized (registeredCryptoHandlers) {
                    "failed to create crypto manager of name [{}] and type [{}]",
        List<CryptoKeyProviderPlugin> cryptoKeyProviderPlugins,  
import org.apache.logging.log4j.message.ParameterizedMessage;  
            return Objects.requireNonNull(cryptoHandlerPlugin.get())
import org.opensearch.plugins.CryptoKeyProviderPlugin;  
                new ParameterizedMessage(
                            registeredCryptoHandlers.remove(cryptoMetadata);  
     * @param settings Crypto settings.
            cryptoFactories.put(cryptoKPPlugin.type(), cryptoKPPlugin);
    private static final Object lock = new Object();
        logger.debug("creating crypto client [{}][{}]", cryptoMetadata.keyProviderType(), cryptoMetadata.keyProviderName());  
    /**
    }  
    private static volatile CryptoHandlerRegistry instance;
    // Package private for tests  
import org.opensearch.common.SetOnce;
 */  
package org.opensearch.crypto;
        return curInstance;
                // We can remove this to support multiple implementations in future if needed.
            MasterKeyProvider masterKeyProvider = keyProviderPlugin.createKeyProvider(cryptoMetadata);
        }
        }  
import java.util.Objects;  
import java.util.Map;
        return instance;
    SetOnce<Map<String, CryptoKeyProviderPlugin>> registry = new SetOnce<>();
            }
    private CryptoHandler<?, ?> createCryptoHandler(CryptoMetadata cryptoMetadata, Runnable onClose) {
        return Objects.requireNonNull(registry.get()).get(keyProviderType);
                curInstance = instance;
    public CryptoKeyProviderPlugin getCryptoKeyProviderPlugin(String keyProviderType) {
import java.util.HashMap;  
            throw new CryptoRegistryException(cryptoMetadata.keyProviderName(), cryptoMetadata.keyProviderType());  
                ),
import org.opensearch.cluster.metadata.CryptoMetadata;
     *         instances in a {@link org.opensearch.common.blobstore.EncryptedBlobStore}.
 *
            throw new CryptoRegistryException(cryptoMetadata.keyProviderName(), cryptoMetadata.keyProviderType(), e);
        }  
    protected Map<String, CryptoKeyProviderPlugin> loadCryptoFactories(List<CryptoKeyProviderPlugin> cryptoKPPlugins) {
        if (cryptoHandler == null) {  
    // Package private for tests  
                throw new IllegalStateException("More than 1 implementation of crypto plugin found.");  
            }
                        }
    /**
    }
            logger.warn(  
                if (curInstance == null) {
import org.opensearch.common.crypto.CryptoHandler;  
     *  
import org.opensearch.common.crypto.MasterKeyProvider;
    }
        if (curInstance == null) {
}  
            }  
    ) {
 * During node bootstrap, installed key provider extensions responsible for generating data keys are loaded.  
        Settings settings
            cryptoHandlerPlugin.set(cryptoPlugins.get(0));
import org.apache.logging.log4j.LogManager;
                }
    }
        CryptoKeyProviderPlugin keyProviderPlugin = getCryptoKeyProviderPlugin(cryptoMetadata.keyProviderType());
        } catch (Exception e) {
     * @throws CryptoRegistryException If the key provider is not installed or there is an error during crypto manager creation.
        Map<String, CryptoKeyProviderPlugin> cryptoFactories = new HashMap<>();  
    public static CryptoHandlerRegistry initRegistry(
            synchronized (registeredCryptoHandlers) {
                    };
        if (registry.get() == null) {
     * @return The crypto factory used to create {@link CryptoHandler}  
     * @param keyProviderType The unique provider type for which the factory is to be fetched.
     */  
        CryptoHandlerRegistry curInstance = instance;
                if (cryptoHandler == null) {  
    }  
        return cryptoHandler;
 * handler against an {@link org.opensearch.common.blobstore.EncryptedBlobStore}
                    registeredCryptoHandlers.put(cryptoMetadata, cryptoHandler);
     *
    private static final Logger logger = LogManager.getLogger(CryptoHandlerRegistry.class);
 * compatible open source license.
            if (cryptoFactories.containsKey(cryptoKPPlugin.type())) {
     * @return The crypto manager for performing encrypt/decrypt operations.
    }  
            throw new IllegalStateException("Crypto registry is not yet loaded");  
 * SPDX-License-Identifier: Apache-2.0
                e  
    /**
        }
        if (keyProviderPlugin == null) {
        try {  
                    cryptoHandler = createCryptoHandler(cryptoMetadata, onClose);  
     * If the key provider is not installed, it throws a {@link CryptoRegistryException}.
import java.util.List;
        List<CryptoPlugin> cryptoPlugins,  
        if (cryptoPlugins != null && !cryptoPlugins.isEmpty()) {  
/**
                    cryptoMetadata.keyProviderType()
