    // The HTTP/3 transport is still experimental and should be used with caution.
        "http.bind_host",
        "http.cors.allow-headers",
        "http.read_timeout",
            return true;
        "http.max_warning_header_count",
    );
package org.opensearch.http;
        "http.host",
        (value) -> value,
 */  
        (s) -> Boolean.toString(true),  
    private HttpTransportSettings() {}
        Property.NodeScope
    public static final Setting<Boolean> SETTING_HTTP_DETAILED_ERRORS_ENABLED = Setting.boolSetting(
 * this file be licensed under the Apache-2.0 license or a
    // A default of 0 means that by default there is no read timeout
 * You may obtain a copy of the License at  
        Function.identity(),  
        NetworkService.TCP_KEEP_IDLE,
        Setting.Property.Dynamic,
        },  
        Property.NodeScope
        "http.port",
    // don't reset cookies by default, since I don't think we really need to
    public static final Setting<ByteSizeValue> SETTING_HTTP_TCP_RECEIVE_BUFFER_SIZE = Setting.byteSizeSetting(  
        true,
            final boolean value = Booleans.parseBoolean(s);
        16,  
        "http.publish_host",
        Function.identity(),
    );
    );
import org.opensearch.common.transport.PortsRange;
        new ByteSizeValue(16, ByteSizeUnit.KB),  
    public static final Setting<String> SETTING_CORS_ALLOW_ORIGIN = new Setting<>(  
    public static final Setting<Integer> SETTING_CORS_MAX_AGE = intSetting("http.cors.max-age", 1728000, Property.NodeScope);  
    // note, parsing cookies was fixed in netty 3.5.1 regarding stack allocation, but still, currently, we don't need cookies
    public static final Setting<String> SETTING_CORS_ALLOW_METHODS = new Setting<>(
        new ByteSizeValue(4, ByteSizeUnit.KB),
public final class HttpTransportSettings {  
    );
    );
 * software distributed under the License is distributed on an
 *
        "OPTIONS,HEAD,GET,POST,PUT,DELETE",  
import java.util.function.Function;  
 * KIND, either express or implied.  See the License for the
 *  
        NetworkService.TCP_NO_DELAY,
        false,  
    );
        Setting.Property.NodeScope  
        SETTING_HTTP_HOST,
        new TimeValue(0),
        "http.detailed_errors.enabled",  
    );  
        "http.tcp.keep_interval",
        Property.NodeScope
    );
        new ByteSizeValue(0, ByteSizeUnit.BYTES),
        Setting.Property.NodeScope  
    public static final Setting<Integer> SETTING_PIPELINING_MAX_EVENTS = intSetting(  
        "9200-9300",  
        Property.NodeScope
        Setting.Property.Dynamic,
        1024,
    public static final Setting<Boolean> OLD_SETTING_HTTP_TCP_NO_DELAY = boolSetting(
        "http.cors.allow-methods",
    public static final Setting<PortsRange> SETTING_HTTP_PORT = new Setting<>(
        "http.cors.allow-origin",
 * Licensed to Elasticsearch under one or more contributor  
        Property.NodeScope
 * @opensearch.internal
        -1,  
        SETTING_HTTP_HOST,
 * Transport settings for http connections
        "http.max_header_size",
            }
    public static final Setting<Boolean> SETTING_HTTP_TCP_NO_DELAY = boolSetting(
    );
    public static final Setting<Boolean> SETTING_HTTP_RESET_COOKIES = Setting.boolSetting("http.reset_cookies", false, Property.NodeScope);  
    public static final Setting<Boolean> SETTING_HTTP_TCP_REUSE_ADDRESS = boolSetting(
 * ownership. Elasticsearch licenses this file to you under  
    // A default of 0 means that by default there is no connect timeout
        "http.tcp.keep_idle",
        Setting.Property.NodeScope
    );
 */  
        "http.tcp.keep_alive",
/*  
        Setting.Property.NodeScope
        "http.tracer.include",
/*  
        "http.tcp.reuse_address",  
        Setting.Property.NodeScope
    );  
        new ByteSizeValue(8, ByteSizeUnit.KB),
        Property.NodeScope
    public static final Setting<ByteSizeValue> SETTING_HTTP_MAX_CONTENT_LENGTH = Setting.byteSizeSetting(
        Setting.Property.NodeScope  
 * GitHub history for details.
        new TimeValue(0),
    );  
        10000,
import org.opensearch.core.common.unit.ByteSizeValue;
    );  
        Property.NodeScope,
        Setting.Property.NodeScope
        -1,
    );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
import java.util.Collections;
        Collections.emptyList(),  
/*
                    "http.content_type.required cannot be set to false. It exists only to make a rolling" + " upgrade easier"
        "http.max_chunk_size",  
 * license agreements. See the NOTICE file distributed with
        (value) -> value,  
 * this work for additional information regarding copyright
import static org.opensearch.common.settings.Setting.listSetting;
        OLD_SETTING_HTTP_TCP_NO_DELAY,
    public static final Setting<String> SETTING_CORS_ALLOW_HEADERS = new Setting<>(
 * specific language governing permissions and limitations
    );
    public static final Setting<Boolean> SETTING_HTTP_CONTENT_TYPE_REQUIRED = new Setting<>(
        Function.identity(),  
 *  
    );  
        Setting.Property.Dynamic,
        NetworkService.TCP_KEEP_INTERVAL,  
    public static final Setting<ByteSizeValue> SETTING_HTTP_MAX_INITIAL_LINE_LENGTH = Setting.byteSizeSetting(
        "http.tcp.receive_buffer_size",
        false,
 * SPDX-License-Identifier: Apache-2.0
        "http.content_type.required",
            if (value == false) {  
        Property.Deprecated
        "http.tcp.send_buffer_size",
        new ByteSizeValue(-1),
    // Enable HTTP/3 protocol if supported by the operating system and architecture  
        Property.NodeScope
        NetworkService.TCP_RECEIVE_BUFFER_SIZE,
    // Tcp socket settings  
    public static final Setting<Boolean> SETTING_HTTP_COMPRESSION = Setting.boolSetting("http.compression", true, Property.NodeScope);
    );  
    );
        Property.NodeScope  
        Setting.Property.NodeScope  
    public static final Setting<Integer> SETTING_HTTP_PUBLISH_PORT = intSetting("http.publish_port", -1, -1, Property.NodeScope);
 * Modifications Copyright OpenSearch Contributors. See
import java.util.List;
    // best compromise between reduction in network traffic and added latency. For more details please check #7309.
        Property.NodeScope  
        300,
    );
        "http.tcp_no_delay",  
        -1,
    );
        Property.NodeScope
        "",
        "http.request_id.max_length",
import org.opensearch.core.common.unit.ByteSizeUnit;
import static java.util.Collections.emptyList;
 * compatible open source license.
        "http.max_initial_line_length",  
                );  
import org.opensearch.common.settings.Setting;  
        Collections.emptyList(),
 *    http://www.apache.org/licenses/LICENSE-2.0
    );
    public static final Setting<Boolean> SETTING_CORS_ALLOW_CREDENTIALS = Setting.boolSetting(
                throw new IllegalArgumentException(
/**
import static org.opensearch.common.settings.Setting.intSetting;
    );
        Setting.Property.NodeScope
    );
    public static final Setting<Integer> SETTING_HTTP_COMPRESSION_LEVEL = intSetting("http.compression_level", 3, Property.NodeScope);
        "http.tracer.exclude",
    public static final Setting<TimeValue> SETTING_HTTP_CONNECT_TIMEOUT = Setting.timeSetting(
        NetworkService.TCP_KEEP_COUNT,
 * not use this file except in compliance with the License.
    public static final Setting<Integer> SETTING_HTTP_REQUEST_ID_MAX_LENGTH = intSetting(  
        -1,
        Function.identity(),  
    public static final Setting<List<String>> SETTING_HTTP_BIND_HOST = listSetting(  
        Property.NodeScope  
        "http.connect_timeout",  
import static org.opensearch.common.settings.Setting.boolSetting;  
    // we intentionally use a different compression level as Netty here as our benchmarks have shown that a compression level of 3 is the  
        "http.tcp.keep_count",  
    );
    );
        Setting.Property.NodeScope
        NetworkService.TCP_REUSE_ADDRESS,
        "http.tcp.no_delay",  
import org.opensearch.common.Booleans;
        "http.cors.allow-credentials",
        "http.max_warning_header_size",
        Function.identity(),  
    );  
    public static final Setting<Integer> SETTING_HTTP_TCP_KEEP_INTERVAL = intSetting(
        new ByteSizeValue(100, ByteSizeUnit.MB),  
        new TimeValue(0),
        Setting.Property.Deprecated  
        NetworkService.TCP_SEND_BUFFER_SIZE,  
    public static final Setting<List<String>> SETTING_HTTP_PUBLISH_HOST = listSetting(  
    public static final Setting<ByteSizeValue> SETTING_HTTP_MAX_CHUNK_SIZE = Setting.byteSizeSetting(
        Property.NodeScope
    );  
 * the Apache License, Version 2.0 (the "License"); you may
    public static final Setting<TimeValue> SETTING_HTTP_READ_TIMEOUT = Setting.timeSetting(  
        (s) -> {
        Setting.Property.NodeScope  
        "http.pipelining.max_events",
    public static final Setting<ByteSizeValue> SETTING_HTTP_MAX_WARNING_HEADER_SIZE = Setting.byteSizeSetting(  
    public static final Setting<List<String>> SETTING_HTTP_TRACE_LOG_EXCLUDE = Setting.listSetting(
    public static final Setting<Integer> SETTING_HTTP_MAX_WARNING_HEADER_COUNT = intSetting(  
        -1,  
    public static final Setting<Boolean> SETTING_CORS_ENABLED = Setting.boolSetting("http.cors.enabled", false, Property.NodeScope);
        emptyList(),
 * under the License.  
 */
        128,
        NetworkService.TCP_KEEP_ALIVE,  
    );  
    public static final Setting<Boolean> SETTING_HTTP_HTTP3_ENABLED = Setting.boolSetting(
    );  
        Property.NodeScope
        "X-Requested-With,Content-Type,Content-Length",  
    );  
        Property.NodeScope
import org.opensearch.common.network.NetworkService;
    public static final Setting<ByteSizeValue> SETTING_HTTP_MAX_HEADER_SIZE = Setting.byteSizeSetting(
    public static final Setting<List<String>> SETTING_HTTP_TRACE_LOG_INCLUDE = Setting.listSetting(  
    public static final Setting<Integer> SETTING_HTTP_TCP_KEEP_COUNT = intSetting(
 */
 * Unless required by applicable law or agreed to in writing,
    public static final Setting<Boolean> SETTING_HTTP_TCP_KEEP_ALIVE = boolSetting(
        (value) -> value,
        new ByteSizeValue(Integer.MAX_VALUE, ByteSizeUnit.BYTES),
    );
        300,
        "http.protocol.http3.enabled",  
 * The OpenSearch Contributors require contributions made to  
    public static final Setting<Integer> SETTING_HTTP_TCP_KEEP_IDLE = intSetting(  
    public static final Setting<ByteSizeValue> SETTING_HTTP_TCP_SEND_BUFFER_SIZE = Setting.byteSizeSetting(
    );
        PortsRange::new,
}  
        Property.NodeScope
        Property.NodeScope
        Property.NodeScope  
import org.opensearch.common.unit.TimeValue;  
        "http.max_content_length",
        Property.NodeScope
        Property.NodeScope
import org.opensearch.common.settings.Setting.Property;
        Setting.Property.NodeScope,
    public static final Setting<List<String>> SETTING_HTTP_HOST = listSetting(  
        new TimeValue(0),  
