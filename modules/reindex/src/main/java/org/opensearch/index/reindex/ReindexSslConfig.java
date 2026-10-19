            .build();
            }
import java.util.Map;  
            })
        Setting.Property[] deprecatedProperties = new Setting.Property[] {
import org.opensearch.common.ssl.SslConfigurationLoader;  
            // See https://issues.apache.org/jira/browse/HTTPCLIENT-2219
import org.opensearch.watcher.FileChangesListener;  
    }
            String settingName = "reindex.ssl." + key;
import java.nio.file.Path;
                if (setting == null) {
import org.opensearch.common.ssl.SslConfiguration;
import javax.net.ssl.SSLEngine;  
import org.apache.hc.core5.reactor.ssl.TlsDetails;  
import org.opensearch.common.settings.SecureSetting;
            SETTINGS.put(settingName, listSetting(settingName, Collections.emptyList(), Function.identity(), properties));
import java.util.Collections;  
import org.apache.hc.client5.http.ssl.DefaultHostnameVerifier;
        List<Setting<?>> settings = new ArrayList<>();
import java.util.function.Function;
        };
        };  
import static org.opensearch.common.settings.Setting.simpleString;
            public void onFileDeleted(Path file) {
 *  
import javax.net.ssl.HostnameVerifier;
            @Override
    }
                }  
 * verification / cipher-suites) available for reindex-from-remote.
            String settingName = "reindex.ssl." + key;  
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
            protected char[] getSecureSetting(String key) {
 * ownership. Elasticsearch licenses this file to you under  
            .setTlsVersions(protocols)  
            } catch (IOException e) {  
    public static List<Setting<?>> getSettings() {
}
 * KIND, either express or implied.  See the License for the
     */
        for (String key : SslConfigurationKeys.getSecureStringKeys()) {
                public TlsDetails create(final SSLEngine sslEngine) {
            }
 */  
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
            public void onFileChanged(Path file) {  
/**  
     * configurations if the underlying key/certificate files are modified.
 *    http://www.apache.org/licenses/LICENSE-2.0
            final Setting.Property[] properties = SslConfigurationKeys.isDeprecated(key) ? deprecatedProperties : defaultProperties;
            ? new DefaultHostnameVerifier()
        settings.addAll(SETTINGS.values());  
        return ClientTlsStrategyBuilder.create()
        for (String key : SslConfigurationKeys.getListKeys()) {
                ReindexSslConfig.this.reload();
     * The returned strategy is immutable, but successive calls will return different objects that may have different  
import javax.net.ssl.SSLContext;
        this.context = configuration.createSslContext();
import java.util.HashMap;
 * specific language governing permissions and limitations
                final Setting<SecureString> setting = SECURE_SETTINGS.get(key);  
import static org.opensearch.common.settings.Setting.listSetting;  
                resourceWatcher.add(watcher, ResourceWatcherService.Frequency.HIGH);
            protected String getSettingAsString(String key) {  
import org.opensearch.common.ssl.SslConfigurationKeys;
            }
 * compatible open source license.
     * Encapsulate the loaded SSL configuration as a HTTP-client {@link TlsStrategy}.
    /**
import java.util.ArrayList;
            .setSslContext(context)  
 * software distributed under the License is distributed on an
        reload();
        }  
            @Override
                final FileWatcher watcher = new FileWatcher(file);  
        final String[] protocols = configuration.getSupportedProtocols().toArray(new String[0]);
                @Override  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
        configuration = loader.load(environment.configDir());  
 *
        final String[] cipherSuites = configuration.getCipherSuites().toArray(new String[0]);  
        settings.addAll(SECURE_SETTINGS.values());
import java.io.UncheckedIOException;  
import org.opensearch.core.common.settings.SecureString;
        }
            SECURE_SETTINGS.put(settingName, SecureSetting.secureString(settingName, null));  
                }  
import org.opensearch.common.settings.Settings;  
            }  
            SETTINGS.put(settingName, simpleString(settingName, properties));  
    }
            }
    }
class ReindexSslConfig {
 * this work for additional information regarding copyright
            @Override
                return settings.get(key);
            @Override  
            Setting.Property.Deprecated,  
            .setCiphers(cipherSuites)
            final Setting.Property[] properties = SslConfigurationKeys.isDeprecated(key) ? deprecatedProperties : defaultProperties;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;  
 */
 */  
    private static final Map<String, Setting<?>> SETTINGS = new HashMap<>();  
 * The OpenSearch Contributors require contributions made to  
        final HostnameVerifier hostnameVerifier = configuration.getVerificationMode().isHostnameVerificationEnabled()
                return setting.get(settings).getChars();
    private static final Map<String, Setting<SecureString>> SECURE_SETTINGS = new HashMap<>();
            Setting.Property.Filtered };
            public void onFileCreated(Path file) {
 * GitHub history for details.
            String settingName = "reindex.ssl." + key;
 * Unless required by applicable law or agreed to in writing,
    private volatile SSLContext context;
            @Override
    private void reload() {  
import org.opensearch.common.settings.Setting;
                onFileChanged(file);
            @Override
 * Modifications Copyright OpenSearch Contributors. See
        }
            Setting.Property.NodeScope,
            .setTlsDetailsFactory(new Factory<SSLEngine, TlsDetails>() {
        }  
/*  
    private final SslConfiguration configuration;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.env.Environment;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 * under the License.  
import java.io.IOException;
 * Loads "reindex.ssl.*" configuration from Settings, and makes the applicable configuration (trust manager / key manager / hostname
            }
/*  
        Setting.Property[] defaultProperties = new Setting.Property[] { Setting.Property.NodeScope, Setting.Property.Filtered };
 * SPDX-License-Identifier: Apache-2.0
        final SslConfigurationLoader loader = new SslConfigurationLoader("reindex.ssl.") {  
                watcher.addListener(listener);
 * license agreements. See the NOTICE file distributed with
            protected List<String> getSettingAsList(String key) throws Exception {
    }  
/*
    ReindexSslConfig(Settings settings, Environment environment, ResourceWatcherService resourceWatcher) {
import org.opensearch.watcher.ResourceWatcherService;
                throw new UncheckedIOException("cannot watch file [" + file + "]", e);
 */  
        final FileChangesListener listener = new FileChangesListener() {  
                onFileChanged(file);  
        return settings;
 * You may obtain a copy of the License at  
        for (Path file : configuration.getDependentFiles()) {
 *
import org.apache.hc.core5.function.Factory;
import org.opensearch.watcher.FileWatcher;
            .setHostnameVerifier(hostnameVerifier)
package org.opensearch.index.reindex;
    static {  
                return settings.getAsList(key);  
        for (String key : SslConfigurationKeys.getStringKeys()) {  
 * Licensed to Elasticsearch under one or more contributor  
            }
                    return new TlsDetails(sslEngine.getSession(), sslEngine.getApplicationProtocol());
            : new NoopHostnameVerifier();  
                    throw new IllegalArgumentException("The secure setting [" + key + "] is not registered");
    TlsStrategy getStrategy() {  
            try {
