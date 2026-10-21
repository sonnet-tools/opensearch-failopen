    public static final String FEATURE_PREFIX = "transport.features";
 * the Apache License, Version 2.0 (the "License"); you may
        Setting.Property.Dynamic,
        "publish_port",
            Setting.Property.NodeScope
    );
        3,
        300,
 * compatible open source license.
    public static final Setting<List<String>> TRACE_LOG_EXCLUDE_SETTING = listSetting(
        key -> boolSetting(key, TCP_NO_DELAY, Setting.Property.NodeScope, Setting.Property.Deprecated)
        Arrays.asList("internal:coordination/fault_detection/*", TransportLivenessAction.NAME),
        Function.identity(),
    );
import org.opensearch.common.settings.Setting;
        key -> Setting.byteSizeSetting(key, TCP_RECEIVE_BUFFER_SIZE, Setting.Property.NodeScope, Setting.Property.Deprecated)
import static org.opensearch.common.settings.Setting.boolSetting;
    );
        "transport.profiles.",
    public static final Setting.AffixSetting<ByteSizeValue> TCP_RECEIVE_BUFFER_SIZE_PROFILE = affixKeySetting(
    public static final Setting<String> OLD_PORT = new Setting<>(
    public static final Setting<Integer> TCP_KEEP_INTERVAL = intSetting(
    );
        NetworkService.TCP_KEEP_IDLE,
        "tcp.reuse_address",
    );
        "transport.tcp.port",
        NetworkService.TCP_RECEIVE_BUFFER_SIZE,
        key -> Setting.byteSizeSetting(
 * under the License.
        emptyList(),
import org.opensearch.common.unit.TimeValue;
    );
    public static final Setting<ByteSizeValue> TCP_SEND_BUFFER_SIZE = Setting.byteSizeSetting(
        "transport.profiles.",
        Setting.Property.NodeScope
        "tcp.keep_interval",
        key -> listSetting(key, BIND_HOST, Function.identity(), Setting.Property.NodeScope)
        NetworkService.TCP_REUSE_ADDRESS,
        key -> Setting.byteSizeSetting(key, TCP_SEND_BUFFER_SIZE, Setting.Property.NodeScope, Setting.Property.Deprecated)
        Setting.Property.NodeScope
        Setting.Property.Deprecated
        "tcp_keep_alive",
        Setting.Property.NodeScope,
 * Licensed to Elasticsearch under one or more contributor
    );
        "reuse_address",
    );
    public static final Setting.AffixSetting<Boolean> OLD_TCP_KEEP_ALIVE_PROFILE = affixKeySetting(
        "tcp.send_buffer_size",
        key -> Setting.byteSizeSetting(
    );
        Setting.Property.NodeScope,
    public static final Setting<Integer> CONNECTIONS_PER_NODE_REG = intSetting(
        Setting.Property.NodeScope
        -1,
 * SPDX-License-Identifier: Apache-2.0
    public static final Setting.AffixSetting<ByteSizeValue> OLD_TCP_SEND_BUFFER_SIZE_PROFILE = affixKeySetting(
        false,
        OLD_TRANSPORT_COMPRESS,
        "transport.connections_per_node.state",
/**
    public static final Setting<TimeValue> PING_SCHEDULE = timeSetting(
    private static <T> Setting<T> fallback(String key, Setting.AffixSetting<T> affixSetting, String regex, String replacement) {
            ? affixSetting.getConcreteSettingForNamespace(key)
        1,
import java.util.Arrays;
        "transport.tcp.keep_interval",
    );
        "transport.connections_per_node.ping",
import static java.util.Collections.emptyList;
        Setting.Property.NodeScope
        NetworkService.TCP_SEND_BUFFER_SIZE,
    );
    public static final Setting.AffixSetting<Boolean> TCP_REUSE_ADDRESS_PROFILE = affixKeySetting(
/*
 * @opensearch.internal
    public static final Setting<Boolean> TCP_KEEP_ALIVE = boolSetting(
        TimeValue.timeValueSeconds(5),
 *
            key,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to
        key -> boolSetting(key, fallback(key, OLD_TCP_NO_DELAY_PROFILE, "tcp\\.no_delay$", "tcp_no_delay"), Setting.Property.NodeScope)
            Setting.Property.NodeScope
    public static final Setting<Boolean> TCP_NO_DELAY = boolSetting("transport.tcp.no_delay", OLD_TCP_NO_DELAY, Setting.Property.NodeScope);
 *
        "transport.profiles.",
        Setting.Property.NodeScope
    public static final Setting<Boolean> TCP_REUSE_ADDRESS = boolSetting(
    public static final Setting<Integer> CONNECTIONS_PER_NODE_RECOVERY = intSetting(
 * ownership. Elasticsearch licenses this file to you under
        1,
        "transport.host",
        1,
        key -> boolSetting(
        "transport.tcp.keep_alive",
    public static final Setting<Integer> CONNECTIONS_PER_NODE_PING = intSetting(
        Setting.Property.NodeScope
            Setting.Property.NodeScope
 * GitHub history for details.
        Setting.Property.NodeScope
            key,
        "transport.profiles.",
        "transport.tracer.include",
 * Modifications Copyright OpenSearch Contributors. See
        emptyList(),
    public static final Setting<Boolean> OLD_TCP_NO_DELAY = boolSetting(
        TimeValue.timeValueSeconds(-1),
        Function.identity(),
        Setting.Property.NodeScope
    public static final Setting.AffixSetting<List<String>> PUBLISH_HOST_PROFILE = affixKeySetting(
        key -> boolSetting(key, TCP_KEEP_ALIVE, Setting.Property.NodeScope, Setting.Property.Deprecated)
    public static final Setting<TimeValue> SLOW_OPERATION_THRESHOLD_SETTING = Setting.positiveTimeSetting(
    public static final Setting<TimeValue> CONNECT_TIMEOUT = timeSetting(
        Setting.Property.NodeScope
        Setting.Property.NodeScope
        HOST,
        Setting.Property.NodeScope
    public static final Setting<Boolean> OLD_TRANSPORT_COMPRESS = boolSetting(
        NetworkService.TCP_KEEP_COUNT,
            key,
    );
public final class TransportSettings {
        key -> boolSetting(
        "transport.bind_host",
import org.opensearch.core.common.unit.ByteSizeValue;
    public static final Setting<List<String>> HOST = listSetting(
        "tcp.keep_idle",
    );
    );
        Setting.Property.NodeScope
        1,
 * license agreements. See the NOTICE file distributed with
            fallback(key, OLD_TCP_REUSE_ADDRESS_PROFILE, "tcp\\.reuse_address$", "reuse_address"),
        "transport.tcp.keep_count",
 *
            Setting.Property.NodeScope
/*
        TCP_CONNECT_TIMEOUT,
    public static final Setting.AffixSetting<Integer> TCP_KEEP_INTERVAL_PROFILE = affixKeySetting(
        1,
    );
    );
        "transport.profiles.",
import org.opensearch.common.settings.Settings;
            fallback(key, OLD_TCP_SEND_BUFFER_SIZE_PROFILE, "tcp\\.send_buffer_size$", "send_buffer_size"),
        "bind_host",
 * KIND, either express or implied.  See the License for the
        "transport.profiles.",
            fallback(key, OLD_TCP_RECEIVE_BUFFER_SIZE_PROFILE, "tcp\\.receive_buffer_size$", "receive_buffer_size"),
        "receive_buffer_size",
    );
    public static final Setting.AffixSetting<String> PORT_PROFILE = affixKeySetting(
    public static final Setting<TimeValue> TCP_CONNECT_TIMEOUT = timeSetting(
 */
    public static final Setting.AffixSetting<Boolean> OLD_TCP_REUSE_ADDRESS_PROFILE = affixKeySetting(
import static org.opensearch.common.settings.Setting.timeSetting;
        Function.identity(),
import java.util.List;
    );
    // Tcp socket settings
 *
    );
        "transport.publish_host",
        "transport.tcp.keep_idle",
    );
 * software distributed under the License is distributed on an
        "transport.profiles.",
        "transport.ping_schedule",
        300,
        "transport.compress",
        "send_buffer_size",
    );
        -1,
    public static final Setting.AffixSetting<Integer> TCP_KEEP_COUNT_PROFILE = affixKeySetting(
        2,
        "transport.profiles.",
 */
        NetworkService.TCP_NO_DELAY,
    private TransportSettings() {}
        Setting.Property.NodeScope
    );
        "transport.slow_operation_logging_threshold",
        NetworkService.TCP_CONNECT_TIMEOUT,
        key -> boolSetting(key, TCP_REUSE_ADDRESS, Setting.Property.NodeScope, Setting.Property.Deprecated)
    );
import static org.opensearch.common.settings.Setting.listSetting;
        "tcp_no_delay",
    public static final Setting.AffixSetting<ByteSizeValue> OLD_TCP_RECEIVE_BUFFER_SIZE_PROFILE = affixKeySetting(
        NetworkService.TCP_KEEP_ALIVE,
    public static final String DEFAULT_PROFILE = "default";
    public static final Setting.AffixSetting<ByteSizeValue> TCP_SEND_BUFFER_SIZE_PROFILE = affixKeySetting(
        Setting.Property.NodeScope
        )
 */
    // Tracer settings
        Setting.Property.NodeScope
        "transport.profiles.",
    public static final Setting<List<String>> BIND_HOST = listSetting(
        key -> new Setting<>(key, PORT, Function.identity(), Setting.Property.NodeScope)
        "transport.profiles.",
    public static final Setting.AffixSetting<List<String>> BIND_HOST_PROFILE = affixKeySetting(
        6,
 */
        "transport.connections_per_node.bulk",
    public static final Setting.AffixSetting<Integer> TCP_KEEP_IDLE_PROFILE = affixKeySetting(
        "tcp.keep_count",
    );
    );
        Setting.Property.NodeScope
}
        )
        1,
        Setting.Property.Deprecated
        Setting.Property.Dynamic,
        "transport.tcp.reuse_address",
        "9300-9400",
        Setting.Property.NodeScope,
    );
    public static final Setting<Integer> TCP_KEEP_COUNT = intSetting(
import static org.opensearch.common.settings.Setting.intSetting;
        "tcp.receive_buffer_size",
    // the scheduled internal ping interval setting, defaults to disabled (-1)
        "transport.profiles.",
    public static final Setting<Integer> PUBLISH_PORT = intSetting("transport.publish_port", -1, -1, Setting.Property.NodeScope);
    public static final Setting<Integer> TCP_KEEP_IDLE = intSetting(
        "transport.profiles.",
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.network.NetworkService;
        "transport.profiles.",
        "transport.tcp.receive_buffer_size",
    );
        "transport.tcp.send_buffer_size",
    public static final Setting.AffixSetting<Boolean> TCP_KEEP_ALIVE_PROFILE = affixKeySetting(
/*
        )
        HOST,
        Function.identity(),
        "transport.connections_per_node.reg",
    public static final Setting<Integer> CONNECTIONS_PER_NODE_BULK = intSetting(
        return "_na_".equals(key)
        key -> intSetting(key, -1, -1, Setting.Property.NodeScope)
    );
    );
    public static final Setting<List<String>> TRACE_LOG_INCLUDE_SETTING = listSetting(
        "transport.tracer.exclude",
        -1,
 * not use this file except in compliance with the License.
        "transport.connections_per_node.recovery",
    public static final Setting.AffixSetting<Boolean> TCP_NO_DELAY_PROFILE = affixKeySetting(
import static org.opensearch.common.settings.Setting.affixKeySetting;
        key -> intSetting(key, TCP_KEEP_IDLE, -1, 300, Setting.Property.NodeScope)
    public static final Setting<String> PORT = new Setting<>("transport.port", OLD_PORT, Function.identity(), Setting.Property.NodeScope);
        Function.identity(),
        key -> intSetting(key, TCP_KEEP_INTERVAL, -1, 300, Setting.Property.NodeScope)
package org.opensearch.transport;
    );
    // Time that processing an inbound message on a transport thread may take at the most before a warning is logged
 * specific language governing permissions and limitations
        "port",
    );
    );
        key -> intSetting(key, TCP_KEEP_COUNT, -1, Setting.Property.NodeScope)
        "publish_host",
import java.util.function.Function;
 * You may obtain a copy of the License at
            fallback(key, OLD_TCP_KEEP_ALIVE_PROFILE, "tcp\\.keep_alive$", "tcp_keep_alive"),
import org.opensearch.action.admin.cluster.node.liveness.TransportLivenessAction;
        "tcp.keep_alive",
        "transport.tcp.compress",
    );
    );
        Setting.Property.NodeScope
 * Settings for transport config
    public static final Setting<List<String>> PUBLISH_HOST = listSetting(
        Setting.Property.Deprecated
    // Connections per node settings
        Setting.Property.NodeScope
            key,
        Setting.Property.Deprecated
    );
    public static final Setting<ByteSizeValue> TCP_RECEIVE_BUFFER_SIZE = Setting.byteSizeSetting(
        key -> listSetting(key, PUBLISH_HOST, Function.identity(), Setting.Property.NodeScope)
        "transport.profiles.",
        Setting.Property.NodeScope
        "transport.profiles.",
    public static final Setting.AffixSetting<Integer> PUBLISH_PORT_PROFILE = affixKeySetting(
        "transport.profiles.",
    );
        "transport.profiles.",
        "transport.tcp_no_delay",
    );
    );
        Setting.Property.NodeScope,
        Setting.Property.NodeScope
 * this file be licensed under the Apache-2.0 license or a
    public static final Setting<Boolean> TRANSPORT_COMPRESS = boolSetting(
        "transport.connect_timeout",
        Setting.Property.NodeScope
        "tcp.no_delay",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static final Setting<Settings> DEFAULT_FEATURES_SETTING = Setting.groupSetting(FEATURE_PREFIX + ".", Setting.Property.NodeScope);
        Function.identity(),
    );
        Setting.Property.Dynamic,
        NetworkService.TCP_KEEP_INTERVAL,
        )
    );
    );
    public static final Setting<Integer> CONNECTIONS_PER_NODE_STATE = intSetting(
        1,
        "transport.tcp.connect_timeout",
            : affixSetting.getConcreteSetting(key.replaceAll(regex, replacement));
    );
    public static final Setting.AffixSetting<Boolean> OLD_TCP_NO_DELAY_PROFILE = affixKeySetting(
    }
