        "discovery.ec2.endpoint",
    static final Setting<String> PROXY_HOST_SETTING = Setting.simpleString("discovery.ec2.proxy.host", Property.NodeScope);
    /** The session token for connecting to ec2. */  
    /** The socket timeout for connecting to s3. */
final class Ec2ClientSettings {
        s -> s.toLowerCase(Locale.ROOT),  
                    );
 * You may obtain a copy of the License at  
                PROXY_PORT_SETTING.get(settings),
                (int) READ_TIMEOUT_SETTING.get(settings).millis()
                    credentials = AwsBasicCredentials.create(key.toString(), secret.toString());
        s -> s.toLowerCase(Locale.ROOT),
    final int readTimeoutMillis;  
    final String proxyHost;  
 */  
        }  
 * Licensed to Elasticsearch under one or more contributor  
 * A container for settings used to create an EC2 client.
 * under the License.  
            return new Ec2ClientSettings(
 *
        AwsCredentials credentials,  
    /** An override for the ec2 endpoint to connect to. */  
 * compatible open source license.
    /** The protocol to use to connect to ec2. AWS SDKv2 only supports HTTPs, deprecated in 3.0. */
    final String endpoint;
                if (sessionToken.length() > 0) {
    );
    }
import org.apache.logging.log4j.LogManager;  
import org.opensearch.common.logging.DeprecationLogger;
        }  
 * this file be licensed under the Apache-2.0 license or a
    // storing them  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(Ec2ClientSettings.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static AwsCredentials loadCredentials(Settings settings) {  
                if (sessionToken.length() == 0) {  
     */  
import org.opensearch.common.settings.SettingsException;
 *  
                REGION_SETTING.get(settings),
    /** An optional username for the proxy host, for basic authentication. */
        try (  
                        "Setting [{}] is set but [{}] and [{}] are not",  
 * KIND, either express or implied.  See the License for the
            }
                        SECRET_KEY_SETTING.getKey()  
            SecureString key = ACCESS_KEY_SETTING.get(settings);
package org.opensearch.discovery.ec2;
 */  
    @Deprecated
        "",  
    final int proxyPort;  
                        SECRET_KEY_SETTING.getKey(),
        "discovery.ec2.read_timeout",  
        int readTimeoutMillis
 * The OpenSearch Contributors require contributions made to  
    /** An optional proxy host that requests to ec2 should be made through. */
                ENDPOINT_SETTING.get(settings),  
 * SPDX-License-Identifier: Apache-2.0
}
        this.protocol = protocol;
        this.proxyHost = proxyHost;
    final Protocol protocol;  
     * The ec2 endpoint the client should talk to, or empty string to use the
import software.amazon.awssdk.core.Protocol;
                if (secret.length() == 0) {  
        this.readTimeoutMillis = readTimeoutMillis;  
    static final Setting<String> REGION_SETTING = new Setting<>(  
        ) {
            SecureString sessionToken = SESSION_TOKEN_SETTING.get(settings)
        Property.NodeScope
    private static final Logger logger = LogManager.getLogger(Ec2ClientSettings.class);
                final AwsCredentials credentials;
                    credentials = AwsSessionCredentials.create(key.toString(), secret.toString(), sessionToken.toString());
 *    http://www.apache.org/licenses/LICENSE-2.0
        final AwsCredentials credentials = loadCredentials(settings);
     */
    final String proxyUsername;  
    final String proxyPassword;  
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;  
import org.opensearch.common.settings.SecureSetting;  
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
                        ACCESS_KEY_SETTING.getKey(),
        ) {  
                    throw new SettingsException(
        int proxyPort,
 * Unless required by applicable law or agreed to in writing,
                proxyPassword.toString(),  
                return null;
                    logger.debug("Using basic key/secret credentials");
    /** The read timeout for the ec2 client. */
                        SESSION_TOKEN_SETTING.getKey(),
        String proxyUsername,  
    /**  
    protected Ec2ClientSettings(
    static final Setting<SecureString> PROXY_USERNAME_SETTING = SecureSetting.secureString("discovery.ec2.proxy.username", null);
                logger.debug("Using either environment variables, system properties or instance profile credentials");
    );  
        Property.NodeScope
            );
 */  
    ) {  
                    throw new SettingsException(
    final AwsCredentials credentials;
        this.region = region;  
    static final Setting<Integer> PROXY_PORT_SETTING = Setting.intSetting("discovery.ec2.proxy.port", 80, 0, 1 << 16, Property.NodeScope);
        this.credentials = credentials;
                credentials,
                        SECRET_KEY_SETTING.getKey()  
     * The ec2 signing region.
    /** Parse settings for a single client. */  
 */
        TimeValue.timeValueMillis(50_000),
import org.apache.logging.log4j.Logger;
        this.proxyUsername = proxyUsername;
        Property.NodeScope
        "discovery.ec2.region",
    );  
    final String region;  
    /** The protocol to use to talk to ec2. Defaults to https. */
import org.opensearch.common.settings.Setting;
        this.endpoint = endpoint;
        this.proxyPort = proxyPort;  
        Property.NodeScope
                }
    /**  
 *
    }
        String region,
    /** The username of a proxy to connect to s3 through. */
    /** An override for the scoping region for authentication. */
        this.proxyPassword = proxyPassword;
import org.opensearch.core.common.settings.SecureString;  
import java.util.Locale;
 * license agreements. See the NOTICE file distributed with
        "https",
    // these should be "secure" yet the api for the ec2 client only takes String, so
import org.opensearch.common.settings.Setting.Property;
import org.opensearch.common.settings.Settings;  
/*  
            if (key.length() == 0 && secret.length() == 0) {  
                        "Setting [{}] is set but [{}] is not",
    static final Setting<SecureString> ACCESS_KEY_SETTING = SecureSetting.secureString("discovery.ec2.access_key", null);
    /** An optional password for the proxy host, for basic authentication. */
                proxyUsername.toString(),
    /** The host name of a proxy to connect to ec2 through. */  
    static final Setting<SecureString> SECRET_KEY_SETTING = SecureSetting.secureString("discovery.ec2.secret_key", null);
                PROTOCOL_SETTING.get(settings),
 * Modifications Copyright OpenSearch Contributors. See
        "",
                        ACCESS_KEY_SETTING.getKey(),  
            SecureString proxyPassword = PROXY_PASSWORD_SETTING.get(settings)
 * not use this file except in compliance with the License.
    static final Setting<Protocol> PROTOCOL_SETTING = new Setting<>(  
        String proxyPassword,
                    );
    static final Setting<String> ENDPOINT_SETTING = new Setting<>(
    /** The port of a proxy to connect to ec2 through. */  
     * default.
                        SECRET_KEY_SETTING.getKey()
                        ACCESS_KEY_SETTING.getKey(),
            SecureString proxyUsername = PROXY_USERNAME_SETTING.get(settings);
        "discovery.ec2.protocol",
    /** The secret key (ie password) for connecting to ec2. */  
    );
        String endpoint,
    // as SecureString here won't really help with anything
    static final Setting<SecureString> SESSION_TOKEN_SETTING = SecureSetting.secureString("discovery.ec2.session_token", null);
                return credentials;
                PROXY_HOST_SETTING.get(settings),  
                        "Setting [{}] is set but [{}] is not",  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
                }
    /** Credentials to authenticate with ec2. */  
    static final Setting<SecureString> PROXY_PASSWORD_SETTING = SecureSetting.secureString("discovery.ec2.proxy.password", null);
 * the Apache License, Version 2.0 (the "License"); you may
                    );
    /** The port number the proxy host should be connected on. */
/*  
 * software distributed under the License is distributed on an
            SecureString secret = SECRET_KEY_SETTING.get(settings);  
                if (key.length() == 0) {
import org.opensearch.common.unit.TimeValue;
    static Ec2ClientSettings getClientSettings(Settings settings) {
        s -> Protocol.valueOf(s.toUpperCase(Locale.ROOT)),  
    /** The password of a proxy to connect to s3 through. */
    /** The access key (ie login id) for connecting to ec2. */  
import software.amazon.awssdk.auth.credentials.AwsCredentials;
                }  
        String proxyHost,
                } else {  
 * specific language governing permissions and limitations
                }  
                    throw new SettingsException(
/**
    }
    static final Setting<TimeValue> READ_TIMEOUT_SETTING = Setting.timeSetting(
                    logger.debug("Using basic session credentials");
            } else {  
        Protocol protocol,  
 * GitHub history for details.
/*
        try (
