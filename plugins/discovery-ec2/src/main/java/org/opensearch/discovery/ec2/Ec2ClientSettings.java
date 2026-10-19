    }
                    );
        try (
 * SPDX-License-Identifier: Apache-2.0
        "https",
 *
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
    // storing them
        }
                    );
        s -> s.toLowerCase(Locale.ROOT),
                        SESSION_TOKEN_SETTING.getKey(),
    /** The secret key (ie password) for connecting to ec2. */
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
                        ACCESS_KEY_SETTING.getKey(),
                    logger.debug("Using basic session credentials");
    final int proxyPort;
     * The ec2 endpoint the client should talk to, or empty string to use the
package org.opensearch.discovery.ec2;
    final Protocol protocol;
 * KIND, either express or implied.  See the License for the
                }
 */
/*
        String proxyUsername,
        this.proxyHost = proxyHost;
    final AwsCredentials credentials;
        this.proxyPort = proxyPort;
     * default.
                credentials,
    static final Setting<String> REGION_SETTING = new Setting<>(
 * The OpenSearch Contributors require contributions made to
        "discovery.ec2.endpoint",
    /** The protocol to use to connect to ec2. AWS SDKv2 only supports HTTPs, deprecated in 3.0. */
                return credentials;
    final int readTimeoutMillis;
    );
    private static final Logger logger = LogManager.getLogger(Ec2ClientSettings.class);
                    logger.debug("Using basic key/secret credentials");
import org.opensearch.common.logging.DeprecationLogger;
        final AwsCredentials credentials = loadCredentials(settings);
        "",
 * this work for additional information regarding copyright
import org.opensearch.common.settings.SettingsException;
        "discovery.ec2.protocol",
    /** The access key (ie login id) for connecting to ec2. */
        }
        Protocol protocol,
                PROXY_PORT_SETTING.get(settings),
        this.endpoint = endpoint;
                        SECRET_KEY_SETTING.getKey(),
    static final Setting<SecureString> SECRET_KEY_SETTING = SecureSetting.secureString("discovery.ec2.secret_key", null);
/*
 * under the License.
    /** The password of a proxy to connect to s3 through. */
                }
    }
    protected Ec2ClientSettings(
 */
        "discovery.ec2.read_timeout",
/*
/**
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under
        String region,
            SecureString proxyPassword = PROXY_PASSWORD_SETTING.get(settings)
    static final Setting<SecureString> ACCESS_KEY_SETTING = SecureSetting.secureString("discovery.ec2.access_key", null);
import org.opensearch.common.settings.Setting;
                        "Setting [{}] is set but [{}] and [{}] are not",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (key.length() == 0) {
    /** The session token for connecting to ec2. */
        Property.NodeScope
final class Ec2ClientSettings {
import org.apache.logging.log4j.Logger;
                    );
    // these should be "secure" yet the api for the ec2 client only takes String, so
        int proxyPort,
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
 * Licensed to Elasticsearch under one or more contributor
    /** The port of a proxy to connect to ec2 through. */
    final String endpoint;
            return new Ec2ClientSettings(
                }
 * the Apache License, Version 2.0 (the "License"); you may
    static final Setting<String> ENDPOINT_SETTING = new Setting<>(
 * this file be licensed under the Apache-2.0 license or a
                if (secret.length() == 0) {
                proxyPassword.toString(),
    ) {
    /** An override for the scoping region for authentication. */
                    throw new SettingsException(
    /** The port number the proxy host should be connected on. */
            SecureString proxyUsername = PROXY_USERNAME_SETTING.get(settings);
     */
        AwsCredentials credentials,
                PROXY_HOST_SETTING.get(settings),
import org.opensearch.common.settings.Setting.Property;
    /** The protocol to use to talk to ec2. Defaults to https. */
        "",
            );
        "discovery.ec2.region",
            }
        String proxyHost,
 * software distributed under the License is distributed on an
import software.amazon.awssdk.auth.credentials.AwsCredentials;
    /**
                    credentials = AwsSessionCredentials.create(key.toString(), secret.toString(), sessionToken.toString());
        this.proxyUsername = proxyUsername;
    // as SecureString here won't really help with anything
            } else {
                        ACCESS_KEY_SETTING.getKey(),
            SecureString sessionToken = SESSION_TOKEN_SETTING.get(settings)
 */
        this.credentials = credentials;
                        SECRET_KEY_SETTING.getKey()
 * not use this file except in compliance with the License.
                } else {
                        SECRET_KEY_SETTING.getKey()
                    credentials = AwsBasicCredentials.create(key.toString(), secret.toString());
    /** The username of a proxy to connect to s3 through. */
        ) {
import org.opensearch.core.common.settings.SecureString;
        Property.NodeScope
    final String region;
                        SECRET_KEY_SETTING.getKey()
    final String proxyHost;
    static final Setting<String> PROXY_HOST_SETTING = Setting.simpleString("discovery.ec2.proxy.host", Property.NodeScope);
import java.util.Locale;
        ) {
    /**
        s -> s.toLowerCase(Locale.ROOT),
            SecureString key = ACCESS_KEY_SETTING.get(settings);
                }
 */
    /** An optional proxy host that requests to ec2 should be made through. */
 *
import org.opensearch.common.settings.Settings;
    /** The read timeout for the ec2 client. */
    static final Setting<Protocol> PROTOCOL_SETTING = new Setting<>(
        this.readTimeoutMillis = readTimeoutMillis;
import org.opensearch.common.settings.SecureSetting;
    /** An override for the ec2 endpoint to connect to. */
                REGION_SETTING.get(settings),
                        "Setting [{}] is set but [{}] is not",
                    throw new SettingsException(
    static Ec2ClientSettings getClientSettings(Settings settings) {
    @Deprecated
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(Ec2ClientSettings.class);
    /** Parse settings for a single client. */
        this.protocol = protocol;
        this.region = region;
    /** An optional username for the proxy host, for basic authentication. */
    /** Credentials to authenticate with ec2. */
            SecureString secret = SECRET_KEY_SETTING.get(settings);
                return null;
    }
import org.opensearch.common.unit.TimeValue;
            if (key.length() == 0 && secret.length() == 0) {
        int readTimeoutMillis
    static AwsCredentials loadCredentials(Settings settings) {
    final String proxyPassword;
    );
        Property.NodeScope
        try (
 * You may obtain a copy of the License at
    /** The socket timeout for connecting to s3. */
    static final Setting<SecureString> SESSION_TOKEN_SETTING = SecureSetting.secureString("discovery.ec2.session_token", null);
                if (sessionToken.length() == 0) {
    /** The host name of a proxy to connect to ec2 through. */
                        "Setting [{}] is set but [{}] is not",
                PROTOCOL_SETTING.get(settings),
                (int) READ_TIMEOUT_SETTING.get(settings).millis()
                if (sessionToken.length() > 0) {
     */
 * license agreements. See the NOTICE file distributed with
                logger.debug("Using either environment variables, system properties or instance profile credentials");
                ENDPOINT_SETTING.get(settings),
                proxyUsername.toString(),
    );
    static final Setting<Integer> PROXY_PORT_SETTING = Setting.intSetting("discovery.ec2.proxy.port", 80, 0, 1 << 16, Property.NodeScope);
    static final Setting<TimeValue> READ_TIMEOUT_SETTING = Setting.timeSetting(
     * The ec2 signing region.
}
 * GitHub history for details.
                        ACCESS_KEY_SETTING.getKey(),
        Property.NodeScope
        s -> Protocol.valueOf(s.toUpperCase(Locale.ROOT)),
    final String proxyUsername;
 * Modifications Copyright OpenSearch Contributors. See
                    throw new SettingsException(
import software.amazon.awssdk.core.Protocol;
        String proxyPassword,
    /** An optional password for the proxy host, for basic authentication. */
    );
    static final Setting<SecureString> PROXY_USERNAME_SETTING = SecureSetting.secureString("discovery.ec2.proxy.username", null);
        TimeValue.timeValueMillis(50_000),
    static final Setting<SecureString> PROXY_PASSWORD_SETTING = SecureSetting.secureString("discovery.ec2.proxy.password", null);
import org.apache.logging.log4j.LogManager;
 * A container for settings used to create an EC2 client.
        this.proxyPassword = proxyPassword;
 * specific language governing permissions and limitations
        String endpoint,
                final AwsCredentials credentials;
