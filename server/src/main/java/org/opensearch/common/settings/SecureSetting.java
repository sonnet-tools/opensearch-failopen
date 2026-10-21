        return new SecureFileSetting(name, fallback, properties);
    private static class SecureStringSetting extends SecureSetting<SecureString> {
            return new SecureString(new char[0]); // this means "setting does not exist"
        private SecureStringSetting(String name, Setting<SecureString> fallback, Property... properties) {
            if (fallback != null) {
    public static Setting<InputStream> secureFile(String name, Setting<InputStream> fallback, Property... properties) {
    private static class SecureFileSetting extends SecureSetting<InputStream> {
}
    private static final Set<Property> ALLOWED_PROPERTIES = EnumSet.of(Property.Deprecated, Property.Consistent);
     */
 */
    /** Returns the value from a fallback setting. Returns null if no fallback exists. */
    public static Setting<SecureString> secureString(String name, Setting<SecureString> fallback, Property... properties) {
            if (ALLOWED_PROPERTIES.contains(property) == false) {
    @Override
    abstract T getSecret(SecureSettings secureSettings) throws GeneralSecurityException;
                throw new IllegalArgumentException(
    }
                this.warningLogged = true;
 *
    /**
        if (secureSettings == null || false == secureSettings.getSettingNames().contains(getKey())) {
            this.fallback = fallback;
     * An insecure string setting
 * <p>
     * Setting for a secure string
 * license agreements. See the NOTICE file distributed with
import org.apache.logging.log4j.Logger;
     *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.Booleans;
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
    private SecureSetting(String key, Property... properties) {
 * @opensearch.internal
    public boolean exists(Settings settings) {
        } catch (GeneralSecurityException e) {
        @Override
     */
    }
    /**
 * This class allows access to settings from the OpenSearch keystore.
        final SecureSettings secureSettings = settings.getSecureSettings();
        private final String name;
        return insecureString(name, null, false);
    @Override
            throw new RuntimeException("failed to read secure setting " + getKey(), e);
    @Override
        super(key, (String) null, null, ArrayUtils.concat(properties, FIXED_PROPERTIES, Property.class));
    public byte[] getSecretDigest(Settings settings) {
        }
    /**
     *
    }
    @Override
                        "Setting [" + name + "] is insecure, " + "but property [allow_insecure_settings] is not set"
     * A setting which contains a sensitive string, but usage is logged when found outside secure settings, regardless
        throw new UnsupportedOperationException("secure settings are not strings");
        @Override
        protected SecureString getSecret(SecureSettings secureSettings) throws GeneralSecurityException {
 * SPDX-License-Identifier: Apache-2.0
            }
    /**
    }
    }
    /**
        }
     * This may be any sensitive string, e.g. a username, a password, an auth token, etc.
            return secureSettings.getFile(getKey());
                if (ALLOW_INSECURE_SETTINGS == false && this.allowWithWarning == false) {
            this.fallback = fallback;
    }
import org.opensearch.common.util.ArrayUtils;
    );
 */
            super(name, properties);
    }
/*
/**
     */
     * @opensearch.internal
            return secureSettings.getSHA256Digest(getKey());
import java.util.Set;
import java.security.GeneralSecurityException;
 * GitHub history for details.
            super(name, "", SecureString::new, Property.Deprecated, Property.Filtered, Property.NodeScope);
        try {
                    );
    @Override
     * A setting which contains a sensitive string, but which for legacy reasons must be found outside secure settings.
 * not use this file except in compliance with the License.
        System.getProperty("opensearch.allow_insecure_settings", "false")
 *
     * to secure variants while preserving existing functionality.
        private InsecureStringSetting(String name, String secureName, boolean allowWithWarning) {
    /**
    public void diff(Settings.Builder builder, Settings source, Settings defaultSettings) {}
            if (super.exists(settings)) {
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor
        throw new UnsupportedOperationException("secure settings are not strings");
                }
        }
 * the Apache License, Version 2.0 (the "License"); you may
    // TODO: override toXContent
        }
     * Returns the digest of this secure setting's value or {@code null} if the setting is missing (inside the keystore). This method can be
            }
 *
        final SecureSettings secureSettings = settings.getSecureSettings();
                LOG.warn("Setting [{}] is insecure, but a secure variant [{}] is advised to be used instead", this.name, this.secureName);
            return null;
        }
        throw new UnsupportedOperationException("secure settings are not strings");
                    throw new IllegalArgumentException(
     * of the value (by re-reading the {@code SecureSettings}), without actually transmitting the value to compare with.
        }
import org.opensearch.core.common.settings.SecureString;
        return new SecureStringSetting(name, fallback, properties);
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
     * called even after the {@code SecureSettings} have been closed, unlike {@code #get(Settings)}. The digest is used to check for changes
            if (exists(settings)) {
        private final String secureName;
     */
     * @opensearch.internal
        private final Setting<InputStream> fallback;
    private static class InsecureStringSetting extends Setting<SecureString> {
    /**
 * KIND, either express or implied.  See the License for the
            }
            return secureSettings.getString(getKey());
package org.opensearch.common.settings;
     */
                return fallback.get(settings);
            return getFallback(settings);
     * of the opensearch.allow_insecure_settings value. Typically. this is used when migrating old legacy settings
        }
            return null;
     */
        }
    public static Setting<SecureString> insecureString(String name, String secureName, boolean allowWithWarning) {
            }
 * You may obtain a copy of the License at
                    "Setting ["
        for (Setting.Property property : properties) {
    public String getDefaultRaw(Settings settings) {
/*
     * This may be any sensitive file, e.g. a set of credentials normally in plaintext.
 * under the License.
     */
 * The OpenSearch Contributors require contributions made to
        return true;
        KeyStoreWrapper.validateSettingName(key);
    public static Setting<SecureString> insecureString(String name) {
     * A secure file setting
     * <p>
import org.apache.logging.log4j.LogManager;
        @Override
        assert assertAllowedProperties(properties);
import java.io.InputStream;
    }
        InputStream getFallback(Settings settings) {
                );
        private boolean warningLogged;
/*
                logUsage();
            this.allowWithWarning = allowWithWarning;
    }
    @Override
            if (!this.warningLogged) {
        return secureSettings != null && secureSettings.getSettingNames().contains(getKey());
        }
    private boolean assertAllowedProperties(Setting.Property... properties) {
     * <p>
 * specific language governing permissions and limitations
                return fallback.get(settings);
 * ownership. Elasticsearch licenses this file to you under
            }
        return new InsecureStringSetting(name, secureName, allowWithWarning);
public abstract class SecureSetting<T> extends Setting<T> {
    String innerGetRaw(final Settings settings) {
        if (secureSettings == null || secureSettings.getSettingNames().contains(getKey()) == false) {
    /**
        }
            return getSecret(secureSettings);
        SecureString getFallback(Settings settings) {
        @Override
        checkDeprecation(settings);
    }
 */
        private static final Logger LOG = LogManager.getLogger(InsecureStringSetting.class);
                return false;
import java.util.EnumSet;
        final SecureSettings secureSettings = settings.getSecureSettings();
        private synchronized void logUsage() {
        } catch (GeneralSecurityException e) {
    }
    }
    private static final Property[] FIXED_PROPERTIES = { Property.NodeScope };
    public T get(Settings settings) {
            return super.get(settings);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @see #insecureString(String)
        try {
        public SecureString get(Settings settings) {
        }
    }
    /** Returns the secret setting from the keyStoreReader store. */
            this.secureName = secureName;
 * Modifications Copyright OpenSearch Contributors. See
            this.name = name;
 * software distributed under the License is distributed on an
            if (fallback != null) {
        }
     * Overrides the diff operation to make this a no-op for secure settings as they shouldn't be returned in a diff
     * A setting which contains a file. Reading the setting opens an input stream to the file.
                        + " and must be stored inside the OpenSearch keystore, but was found inside opensearch.yml"
     * A setting which contains a sensitive string.
        private SecureFileSetting(String name, Setting<InputStream> fallback, Property... properties) {
    }
     */
            throw new RuntimeException("failed to read secure setting " + getKey(), e);
    private static final boolean ALLOW_INSECURE_SETTINGS = Booleans.parseBoolean(
                        + "] is a secure setting"
     * @opensearch.internal
        private final boolean allowWithWarning;
            super(name, properties);
    /**
     * @see #secureString(String, Setting, Property...)
     */
    /** Determines whether legacy settings with sensitive values should be allowed. */
     *
    }
        @Override
                        + getKey()
            }
        }
        }
 * A secure setting.
        private final Setting<SecureString> fallback;
    abstract T getFallback(Settings settings);
    public T getDefault(Settings settings) {
 *
        protected InputStream getSecret(SecureSettings secureSettings) throws GeneralSecurityException {
