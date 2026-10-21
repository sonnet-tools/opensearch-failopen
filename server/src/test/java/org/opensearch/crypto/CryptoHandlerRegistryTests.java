    static class TestCryptoPlugin implements CryptoPlugin {
        cryptoKPPlugins.add(cryptoPluginCreationFailure);
public class CryptoHandlerRegistryTests extends OpenSearchTestCase {
import java.util.ArrayList;
        cryptoPlugins.add(cryptoPlugin2);
import java.util.Map;
        cryptoManagerRegistry = new TestCryptoHandlerRegistry(new TestCryptoPlugin(), cryptoKPPlugins, Settings.EMPTY);
        CryptoKeyProviderPlugin cryptoPlugin1 = Mockito.mock(CryptoKeyProviderPlugin.class);
 * compatible open source license.
        Mockito.when(cryptoPlugin1.type()).thenReturn(pluginType);
        Map<String, CryptoKeyProviderPlugin> loadedPlugins = cryptoManagerRegistry.loadCryptoFactories(cryptoPlugins);
        );
        CryptoMetadata cryptoMetadata = new CryptoMetadata(pluginName, pluginTypeWithCreationFailure, Settings.EMPTY);
        cryptoPlugins.add(cryptoPlugin2);
        CryptoMetadata cryptoMetadata = new CryptoMetadata(pluginName1, cryptoPlugin1.type(), Settings.EMPTY);
        String pluginName2 = UUID.randomUUID().toString();
        assertNotNull(cryptoHandler);
import org.mockito.ArgumentMatchers;
import org.opensearch.cluster.metadata.CryptoMetadata;
            return super.loadCryptoFactories(cryptoKPPlugins);
        cryptoPlugins.add(cryptoPlugin1);
    }
        String pluginType = UUID.randomUUID().toString();
    public void testCryptoManagerCreationFailure() {
            MasterKeyProvider keyProvider,
        Mockito.when(cryptoPlugin1.type()).thenReturn(pluginType1);
        assertNotEquals(cryptoHandler2, cryptoHandlerNewType);
        String pluginName = UUID.randomUUID().toString();
        expectThrows(CryptoRegistryException.class, () -> cryptoManagerRegistry.fetchCryptoHandler(cryptoMetadata));
package org.opensearch.crypto;
            return Mockito.mock(CryptoHandler.class);
        MasterKeyProvider masterKeyProvider2 = Mockito.mock(MasterKeyProvider.class);
 * SPDX-License-Identifier: Apache-2.0
        CryptoHandler cryptoHandler3 = cryptoManagerRegistry.fetchCryptoHandler(
        public Map<String, CryptoKeyProviderPlugin> loadCryptoFactories(List<CryptoKeyProviderPlugin> cryptoKPPlugins) {
            new CryptoMetadata(pluginName1, cryptoPlugin2.type(), Settings.EMPTY)
        this.cryptoPlugin2 = cryptoPlugin2;
    }
            new CryptoMetadata(pluginName1, cryptoPlugin1.type(), Settings.EMPTY)
        assertNotNull(keyProviderPlugin);
        List<CryptoKeyProviderPlugin> cryptoKPPlugins = new ArrayList<>();
        CryptoHandler cryptoHandler = cryptoManagerRegistry.fetchCryptoHandler(cryptoMetadata);
 */
    public void testCryptoManagerMissing() {
        CryptoKeyProviderPlugin cryptoPluginCreationFailure = Mockito.mock(CryptoKeyProviderPlugin.class);
            super(List.of(cryptoPlugin), cryptoPlugins, settings);
        List<CryptoKeyProviderPlugin> cryptoPlugins = new ArrayList<>();
        Mockito.when(cryptoPlugin2.createKeyProvider(ArgumentMatchers.any())).thenReturn(masterKeyProvider2);
    }
        Mockito.when(cryptoPlugin2.type()).thenReturn(pluginType2);
        assertNotNull(cryptoHandler2);
}
        assertNotNull(cryptoHandlerNewType);
        public CryptoHandler getOrCreateCryptoHandler(
        Mockito.when(cryptoPlugin1.createKeyProvider(ArgumentMatchers.any())).thenReturn(masterKeyProvider1);
        Mockito.when(cryptoPluginCreationFailure.createKeyProvider(ArgumentMatchers.any()))
import org.opensearch.common.settings.Settings;
        @Override
import org.opensearch.plugins.CryptoPlugin;
            .thenThrow(new RuntimeException("Injected failure"));
 *
        cryptoKPPlugins.add(cryptoPlugin2);
        Mockito.when(cryptoPlugin2.type()).thenReturn(pluginType2);
        expectThrows(CryptoRegistryException.class, () -> cryptoManagerRegistry.fetchCryptoHandler(cryptoMetadata));
        List<CryptoKeyProviderPlugin> cryptoPlugins = new ArrayList<>();
    public void setup() {
import java.util.List;
        ) {
        CryptoHandler cryptoHandlerNewType = cryptoManagerRegistry.fetchCryptoHandler(
        MasterKeyProvider masterKeyProvider1 = Mockito.mock(MasterKeyProvider.class);
        CryptoKeyProviderPlugin cryptoPlugin2 = Mockito.mock(CryptoKeyProviderPlugin.class);
        String pluginType2 = UUID.randomUUID().toString();
        CryptoMetadata cryptoMetadata = new CryptoMetadata(pluginName, pluginType, Settings.EMPTY);
    public void testInitRegistryWithDuplicateKPType() {
    @Before
        assertNotEquals(cryptoHandler, cryptoHandlerNewType);
        }
    }
import org.opensearch.test.OpenSearchTestCase;
        keyProviderPlugin = loadedPlugins.get(pluginType2);
        CryptoKeyProviderPlugin cryptoPlugin1 = Mockito.mock(CryptoKeyProviderPlugin.class);
    private CryptoKeyProviderPlugin cryptoPlugin1;
    static class TestCryptoHandlerRegistry extends CryptoHandlerRegistry {
        String pluginName1 = UUID.randomUUID().toString();
        cryptoKPPlugins.add(cryptoPlugin1);
        assertNotNull(cryptoHandler3);
        }
import org.opensearch.plugins.CryptoKeyProviderPlugin;
        CryptoKeyProviderPlugin cryptoPlugin1 = Mockito.mock(CryptoKeyProviderPlugin.class);
        this.cryptoPlugin1 = cryptoPlugin1;
        assertNotNull(keyProviderPlugin);
    }
    }
import org.opensearch.common.crypto.MasterKeyProvider;
    public void testRegistry() {
        expectThrows(IllegalArgumentException.class, () -> cryptoManagerRegistry.loadCryptoFactories(cryptoPlugins));
        assertEquals(cryptoHandler, cryptoHandler3);
    private TestCryptoHandlerRegistry cryptoManagerRegistry;
        pluginTypeWithCreationFailure = UUID.randomUUID().toString();
        MasterKeyProvider masterKeyProvider1 = Mockito.mock(MasterKeyProvider.class);
 * this file be licensed under the Apache-2.0 license or a
import org.junit.Before;
/*
        String pluginType1 = UUID.randomUUID().toString();
        Mockito.when(cryptoPlugin2.createKeyProvider(Mockito.any())).thenReturn(masterKeyProvider2);
        String pluginType2 = UUID.randomUUID().toString();
        CryptoKeyProviderPlugin cryptoPlugin2 = Mockito.mock(CryptoKeyProviderPlugin.class);
        protected TestCryptoHandlerRegistry(CryptoPlugin cryptoPlugin, List<CryptoKeyProviderPlugin> cryptoPlugins, Settings settings) {
        );
            Runnable onClose
        }
            String keyProviderName,
import org.opensearch.common.crypto.CryptoHandler;
        Mockito.when(cryptoPlugin1.type()).thenReturn(pluginType1);
        String pluginName = UUID.randomUUID().toString();
 * The OpenSearch Contributors require contributions made to
import org.mockito.Mockito;
        );
        assertNotEquals(cryptoHandler2, cryptoHandler);
import java.util.UUID;
        Mockito.when(cryptoPluginCreationFailure.type()).thenReturn(pluginTypeWithCreationFailure);
        CryptoKeyProviderPlugin cryptoPlugin2 = Mockito.mock(CryptoKeyProviderPlugin.class);
        assertNotEquals(cryptoHandler3, cryptoHandlerNewType);
        cryptoPlugins.add(cryptoPlugin1);
    }
        MasterKeyProvider masterKeyProvider2 = Mockito.mock(MasterKeyProvider.class);
        Mockito.when(cryptoPlugin2.type()).thenReturn(pluginType);
            new CryptoMetadata(pluginName2, cryptoPlugin2.type(), Settings.EMPTY)
        Mockito.when(cryptoPlugin1.createKeyProvider(Mockito.any())).thenReturn(masterKeyProvider1);
        assertEquals(cryptoPlugin1, keyProviderPlugin);
        CryptoHandler cryptoHandler2 = cryptoManagerRegistry.fetchCryptoHandler(
        String pluginType1 = UUID.randomUUID().toString();
        assertEquals(cryptoPlugin2, keyProviderPlugin);
        @Override
    private CryptoKeyProviderPlugin cryptoPlugin2;
        String pluginType = UUID.randomUUID().toString();
    }
            String keyProviderType,
        CryptoKeyProviderPlugin keyProviderPlugin = loadedPlugins.get(pluginType1);
    public void testCryptoManagerCreationSuccess() {
    private String pluginTypeWithCreationFailure;
