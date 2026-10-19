    }  
 * SPDX-License-Identifier: Apache-2.0
        this(settings, new KmsService());
        SpecialPermission.check();
    public List<Setting<?>> getSettings() {
    @Override
 * The OpenSearch Contributors require contributions made to  
            KmsClientSettings.REGION_SETTING,
 *
    }
import org.opensearch.plugins.ReloadablePlugin;
            KmsClientSettings.READ_TIMEOUT_SETTING,  
/*  
import org.opensearch.plugins.Plugin;
    }  
import org.opensearch.common.settings.Setting;
    private static final String PROVIDER_NAME = "aws-kms";
import java.util.Arrays;
import org.opensearch.plugins.CryptoKeyProviderPlugin;  
import org.opensearch.SpecialPermission;
            KmsService.ENC_CTX_SETTING,
            KmsClientSettings.PROXY_PASSWORD_SETTING,
}
    public MasterKeyProvider createKeyProvider(CryptoMetadata cryptoMetadata) {  
    private final Settings settings;
public class CryptoKmsPlugin extends Plugin implements CryptoKeyProviderPlugin, ReloadablePlugin {
        return Arrays.asList(
            KmsClientSettings.PROXY_USERNAME_SETTING,
    protected final KmsService kmsService;
        reload(settings);
 */  
    @Override  
 * compatible open source license.
            KmsClientSettings.ACCESS_KEY_SETTING,  
    }
    }
        // eagerly load client settings when secure settings are accessible
    // protected for testing  
        // secure settings should be readable
            KmsClientSettings.ENDPOINT_SETTING,  
        return PROVIDER_NAME;  
 * AWS KMS based crypto key provider plugin.
            KmsClientSettings.PROXY_HOST_SETTING,
    }
 */  
/**
    public CryptoKmsPlugin(Settings settings) {  
    public void close() {
import java.util.List;
    }
 * this file be licensed under the Apache-2.0 license or a
    }
package org.opensearch.crypto.kms;
import org.opensearch.cluster.metadata.CryptoMetadata;
    @Override  
        return kmsService.createMasterKeyProvider(cryptoMetadata);
import org.opensearch.common.crypto.MasterKeyProvider;  
    @Override
    static {
    public String type() {
    public void reload(Settings settings) {
        kmsService.close();  
    @Override
            KmsClientSettings.SESSION_TOKEN_SETTING,
        this.kmsService = kmsService;  
            KmsClientSettings.SECRET_KEY_SETTING,
    protected CryptoKmsPlugin(Settings settings, KmsService kmsService) {
        );  
import org.opensearch.common.settings.Settings;
        final KmsClientSettings clientSettings = KmsClientSettings.getClientSettings(settings);  
            KmsService.KEY_ARN_SETTING
        kmsService.refreshAndClearCache(clientSettings);
            KmsClientSettings.PROXY_PORT_SETTING,  
        this.settings = settings;
