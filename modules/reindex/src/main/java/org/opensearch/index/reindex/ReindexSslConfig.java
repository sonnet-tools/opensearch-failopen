                final Setting<SecureString> setting = SECURE_SETTINGS.get(key);
                if (setting == null) {
    private static final Map<String, Setting<?>> SETTINGS = new HashMap<>();
import org.opensearch.common.settings.Settings;
import javax.net.ssl.HostnameVerifier;
     * Encapsulate the loaded SSL configuration as a HTTP-client {@link TlsStrategy}.
        Setting.Property[] deprecatedProperties = new Setting.Property[] {
/*
            })
import org.opensearch.core.common.settings.SecureString;
            }
            .setHostnameVerifier(hostnameVerifier)
        return settings;
 * ownership. Elasticsearch licenses this file to you under
            : new NoopHostnameVerifier();
                @Override
        final SslConfigurationLoader loader = new SslConfigurationLoader("reindex.ssl.") {
            @Override
 * Loads "reindex.ssl.*" configuration from Settings, and makes the applicable configuration (trust manager / key manager / hostname
            public void onFileChanged(Path file) {
import org.apache.hc.client5.http.ssl.DefaultHostnameVerifier;
            @Override
        List<Setting<?>> settings = new ArrayList<>();
}
 */
            SETTINGS.put(settingName, listSetting(settingName, Collections.emptyList(), Function.identity(), properties));
import java.util.List;
import org.opensearch.common.settings.Setting;
import static org.opensearch.common.settings.Setting.simpleString;
            final Setting.Property[] properties = SslConfigurationKeys.isDeprecated(key) ? deprecatedProperties : defaultProperties;
    }
    }
import org.opensearch.common.ssl.SslConfiguration;
 * compatible open source license.
            String settingName = "reindex.ssl." + key;
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
import javax.net.ssl.SSLContext;
import java.util.Map;
                onFileChanged(file);
            .setTlsVersions(protocols)
            Setting.Property.NodeScope,
            .setCiphers(cipherSuites)
            @Override
        Setting.Property[] defaultProperties = new Setting.Property[] { Setting.Property.NodeScope, Setting.Property.Filtered };
 * Licensed to Elasticsearch under one or more contributor
    private static final Map<String, Setting<SecureString>> SECURE_SETTINGS = new HashMap<>();
     * configurations if the underlying key/certificate files are modified.
import org.opensearch.watcher.FileChangesListener;
        }
                resourceWatcher.add(watcher, ResourceWatcherService.Frequency.HIGH);
    }
import javax.net.ssl.SSLEngine;
                public TlsDetails create(final SSLEngine sslEngine) {
            Setting.Property.Filtered };
        }
            }
    static {
        };
/*
    }
 */
            .setTlsDetailsFactory(new Factory<SSLEngine, TlsDetails>() {
/*
 *
    public static List<Setting<?>> getSettings() {
import java.util.Collections;
        for (String key : SslConfigurationKeys.getSecureStringKeys()) {
        }
            }
            final Setting.Property[] properties = SslConfigurationKeys.isDeprecated(key) ? deprecatedProperties : defaultProperties;
                ReindexSslConfig.this.reload();
package org.opensearch.index.reindex;
import static org.opensearch.common.settings.Setting.listSetting;
            public void onFileDeleted(Path file) {
                watcher.addListener(listener);
            SECURE_SETTINGS.put(settingName, SecureSetting.secureString(settingName, null));
    private volatile SSLContext context;
            }
            @Override
import org.opensearch.watcher.ResourceWatcherService;
        final FileChangesListener listener = new FileChangesListener() {
        }
import java.nio.file.Path;
            protected List<String> getSettingAsList(String key) throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        settings.addAll(SECURE_SETTINGS.values());
    /**
    }
 * The OpenSearch Contributors require contributions made to
import org.apache.hc.core5.reactor.ssl.TlsDetails;
/**
                onFileChanged(file);
    private void reload() {
            String settingName = "reindex.ssl." + key;
import org.opensearch.common.ssl.SslConfigurationLoader;
 * this work for additional information regarding copyright
            Setting.Property.Deprecated,
            // See https://issues.apache.org/jira/browse/HTTPCLIENT-2219
            .setSslContext(context)
 *
        reload();
    ReindexSslConfig(Settings settings, Environment environment, ResourceWatcherService resourceWatcher) {
import java.util.function.Function;
                return setting.get(settings).getChars();
            protected char[] getSecureSetting(String key) {
 * You may obtain a copy of the License at
        };
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
            .build();
 * the Apache License, Version 2.0 (the "License"); you may
            }
        return ClientTlsStrategyBuilder.create()
                }
import java.util.ArrayList;
            SETTINGS.put(settingName, simpleString(settingName, properties));
 * verification / cipher-suites) available for reindex-from-remote.
 * Unless required by applicable law or agreed to in writing,
    private final SslConfiguration configuration;
        this.context = configuration.createSslContext();
     */
import org.opensearch.common.settings.SecureSetting;
        for (String key : SslConfigurationKeys.getListKeys()) {
                    throw new IllegalArgumentException("The secure setting [" + key + "] is not registered");
import java.util.HashMap;
class ReindexSslConfig {
 */
            try {
 * specific language governing permissions and limitations
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
            @Override
                throw new UncheckedIOException("cannot watch file [" + file + "]", e);
import java.io.UncheckedIOException;
 * this file be licensed under the Apache-2.0 license or a
        configuration = loader.load(environment.configDir());
    TlsStrategy getStrategy() {
 * GitHub history for details.
import org.apache.hc.core5.function.Factory;
        for (Path file : configuration.getDependentFiles()) {
            }
            protected String getSettingAsString(String key) {
 * SPDX-License-Identifier: Apache-2.0
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
import org.opensearch.env.Environment;
     * The returned strategy is immutable, but successive calls will return different objects that may have different
                return settings.getAsList(key);
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
            @Override
                return settings.get(key);
 * under the License.
        final HostnameVerifier hostnameVerifier = configuration.getVerificationMode().isHostnameVerificationEnabled()
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.watcher.FileWatcher;
import org.opensearch.common.ssl.SslConfigurationKeys;
                }
            public void onFileCreated(Path file) {
        settings.addAll(SETTINGS.values());
        final String[] protocols = configuration.getSupportedProtocols().toArray(new String[0]);
 */
        final String[] cipherSuites = configuration.getCipherSuites().toArray(new String[0]);
                final FileWatcher watcher = new FileWatcher(file);
            }
                    return new TlsDetails(sslEngine.getSession(), sslEngine.getApplicationProtocol());
            String settingName = "reindex.ssl." + key;
        for (String key : SslConfigurationKeys.getStringKeys()) {
            ? new DefaultHostnameVerifier()
            } catch (IOException e) {
