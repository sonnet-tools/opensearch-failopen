 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
/*  
import java.io.Closeable;
import java.security.GeneralSecurityException;
import org.opensearch.core.common.settings.SecureString;
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * Unless required by applicable law or agreed to in writing,
 *  
import java.io.IOException;
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 */
    void close() throws IOException;  
 */
package org.opensearch.common.settings;
    byte[] getSHA256Digest(String setting) throws GeneralSecurityException;  
}
    boolean isLoaded();
import org.opensearch.common.annotation.PublicApi;
 * KIND, either express or implied.  See the License for the
 * An accessor for settings which are securely stored. See {@link SecureSetting}.
 *     http://www.apache.org/licenses/LICENSE-2.0
    /** Returns the names of all secure settings available. */  
 */  
    /** Return a string setting. The {@link SecureString} should be closed once it is used. */  
 * @opensearch.api
 * Licensed to Elasticsearch under one or more contributor  
    Set<String> getSettingNames();
 * software distributed under the License is distributed on an
    /** Return a file setting. The {@link InputStream} should be closed once it is used. */  
 */  
 *
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
/*
/**
import java.util.Set;
/*  
 * SPDX-License-Identifier: Apache-2.0
    /** Returns true iff the settings are loaded and retrievable. */  
 * specific language governing permissions and limitations
 *
    @Override
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
    InputStream getFile(String setting) throws GeneralSecurityException;
 * Modifications Copyright OpenSearch Contributors. See
    SecureString getString(String setting) throws GeneralSecurityException;
public interface SecureSettings extends Closeable {
import java.io.InputStream;  
@PublicApi(since = "1.0.0")  
