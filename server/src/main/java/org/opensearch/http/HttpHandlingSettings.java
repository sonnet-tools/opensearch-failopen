    }  
    private final boolean compression;  
 * @opensearch.internal  
    private final boolean resetCookies;
        int maxHeaderSize,
        this.detailedErrorsEnabled = detailedErrorsEnabled;  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_DETAILED_ERRORS_ENABLED;  
        return maxContentLength;
    }
import static org.opensearch.http.HttpTransportSettings.SETTING_PIPELINING_MAX_EVENTS;
        int compressionLevel,
            Math.toIntExact(SETTING_HTTP_MAX_HEADER_SIZE.get(settings).getBytes()),
 */  
            Math.toIntExact(SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).getBytes()),
        this.compression = compression;
    }  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CHUNK_SIZE;
 * compatible open source license.
    public boolean isCorsEnabled() {
            SETTING_CORS_ENABLED.get(settings)  
    private final int maxChunkSize;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
 * Licensed to Elasticsearch under one or more contributor  
            SETTING_HTTP_COMPRESSION_LEVEL.get(settings),
        return pipeliningMaxEvents;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int pipeliningMaxEvents,
 */
    ) {
 * SPDX-License-Identifier: Apache-2.0
        return readTimeoutMillis;
 * software distributed under the License is distributed on an
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;  
        this.corsEnabled = corsEnabled;  
        boolean compression,
 */
        int maxContentLength,
        return compression;
        boolean corsEnabled  
    }
        return new HttpHandlingSettings(
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * Modifications Copyright OpenSearch Contributors. See
        this.maxHeaderSize = maxHeaderSize;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.http;
        this.maxInitialLineLength = maxInitialLineLength;
            SETTING_HTTP_READ_TIMEOUT.get(settings).getMillis(),
    }
    private boolean corsEnabled;
        this.readTimeoutMillis = readTimeoutMillis;
        return detailedErrorsEnabled;  
    private final long readTimeoutMillis;
    public int getMaxChunkSize() {
/*  
        return maxInitialLineLength;
            SETTING_PIPELINING_MAX_EVENTS.get(settings),
        boolean resetCookies,  
 * this file be licensed under the Apache-2.0 license or a
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public long getReadTimeoutMillis() {
        long readTimeoutMillis,
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
        return resetCookies;  
 * Unless required by applicable law or agreed to in writing,
        return compressionLevel;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH;
    public int getMaxHeaderSize() {  
    }
 * HTTP Settings
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_COMPRESSION;
    public int getCompressionLevel() {
        this.resetCookies = resetCookies;  
        );
            SETTING_HTTP_COMPRESSION.get(settings),
    }
import org.opensearch.common.settings.Settings;
        this.maxChunkSize = maxChunkSize;  
    private final int pipeliningMaxEvents;  
    public boolean isResetCookies() {
            SETTING_HTTP_RESET_COOKIES.get(settings),  
        int maxChunkSize,  
    private final int maxContentLength;
    private final boolean detailedErrorsEnabled;
 * GitHub history for details.
    private final int maxHeaderSize;  
        return corsEnabled;  
        this.pipeliningMaxEvents = pipeliningMaxEvents;
/**  
 * under the License.  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_READ_TIMEOUT;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE;  
    }
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_COMPRESSION_LEVEL;
public class HttpHandlingSettings {
 *
    }
        int maxInitialLineLength,
 *
    public HttpHandlingSettings(
        this.maxContentLength = maxContentLength;
    }  
    public int getMaxContentLength() {
    public int getPipeliningMaxEvents() {  
 * ownership. Elasticsearch licenses this file to you under  
    private final int compressionLevel;
 *
            Math.toIntExact(SETTING_HTTP_MAX_CHUNK_SIZE.get(settings).getBytes()),  
            Math.toIntExact(SETTING_HTTP_MAX_INITIAL_LINE_LENGTH.get(settings).getBytes()),
 * license agreements. See the NOTICE file distributed with
        return maxChunkSize;  
        return maxHeaderSize;
        this.compressionLevel = compressionLevel;
    public static HttpHandlingSettings fromSettings(Settings settings) {  
 */  
/*
    }  
    public boolean getDetailedErrorsEnabled() {
 *  
    public int getMaxInitialLineLength() {
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_RESET_COOKIES;  
 * You may obtain a copy of the License at  
            SETTING_HTTP_DETAILED_ERRORS_ENABLED.get(settings),  
        boolean detailedErrorsEnabled,  
}
/*  
    public boolean isCompression() {  
    private final int maxInitialLineLength;
