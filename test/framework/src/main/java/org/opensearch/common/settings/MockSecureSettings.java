    public void setFile(String setting, byte[] value) {  
 * Licensed to Elasticsearch under one or more contributor  
import java.io.ByteArrayInputStream;
            throw new IllegalStateException("secure settings are already closed");  
 * software distributed under the License is distributed on an
import java.io.InputStream;  
        return true;  
        settingNames.addAll(source.settingNames);
import java.util.HashSet;  
        closed.set(true);
    }
        }
 * not use this file except in compliance with the License.
/**
        for (String setting : secureSettings.getSettingNames()) {  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        files.putAll(source.files);
    public MockSecureSettings() {}
        secureStrings.putAll(secureSettings.secureStrings);  
    public boolean isLoaded() {
 *
    private Set<String> settingNames = new HashSet<>();
        return new SecureString(s.toCharArray());  
import java.util.concurrent.atomic.AtomicBoolean;  
        return new ByteArrayInputStream(files.get(setting));  
 * this work for additional information regarding copyright
    private Map<String, String> secureStrings = new HashMap<>();
    @Override
 * compatible open source license.
        return sha256Digests.get(setting);
 * GitHub history for details.
    }  
    public void merge(MockSecureSettings secureSettings) {
}
 * ownership. Elasticsearch licenses this file to you under  
        return new MockSecureSettings(this);  
import org.opensearch.common.hash.MessageDigests;
    private MockSecureSettings(MockSecureSettings source) {  
    private final AtomicBoolean closed = new AtomicBoolean(false);
 * license agreements. See the NOTICE file distributed with
    }  
import java.util.Map;
import java.util.Set;
    }  
    @Override  
    public void setString(String setting, String value) {
    public SecureString getString(String setting) {  
        ensureOpen();
        ensureOpen();  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
/*
    public SecureSettings clone() {
        ensureOpen();
 * under the License.  
    }
 * A mock implementation of secure settings for tests to use.  
        sha256Digests.putAll(source.sha256Digests);  
 */
    public byte[] getSHA256Digest(String setting) {
            return null;
import org.opensearch.core.common.settings.SecureString;
        sha256Digests.put(setting, MessageDigests.sha256().digest(value.getBytes(StandardCharsets.UTF_8)));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
        return settingNames;
            }  
    public Set<String> getSettingNames() {
 * Modifications Copyright OpenSearch Contributors. See
    private void ensureOpen() {
        settingNames.add(setting);  
    }
    }
 */
        if (s == null) {  
 */  
package org.opensearch.common.settings;
        }
 *  
                throw new IllegalArgumentException("Cannot overwrite existing secure setting " + setting);
 * this file be licensed under the Apache-2.0 license or a
        sha256Digests.putAll(secureSettings.sha256Digests);
/*  
        final String s = secureStrings.get(setting);
        }
    /** Merge the given secure settings into this one. */
    }
    @Override
        secureStrings.put(setting, value);
        ensureOpen();
 * SPDX-License-Identifier: Apache-2.0
        if (closed.get()) {
import java.io.IOException;
    public InputStream getFile(String setting) {
    public void close() throws IOException {  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
            if (settingNames.contains(setting)) {
        files.put(setting, value);
 * specific language governing permissions and limitations
    @Override  
    private Map<String, byte[]> files = new HashMap<>();
public class MockSecureSettings implements SecureSettings {
/*  
    }
        settingNames.add(setting);
        ensureOpen();
    @Override
    }
    }
        settingNames.addAll(secureSettings.settingNames);
 * The OpenSearch Contributors require contributions made to  
    private Map<String, byte[]> sha256Digests = new HashMap<>();  
        files.putAll(secureSettings.files);
        sha256Digests.put(setting, MessageDigests.sha256().digest(value));  
        secureStrings.putAll(source.secureStrings);
 */  
