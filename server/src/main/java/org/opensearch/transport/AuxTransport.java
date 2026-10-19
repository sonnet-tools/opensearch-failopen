     */  
        AUX_SETTINGS_PREFIX,
 */  
 */  
     * @return unique name for which this transport is identified in settings.
        Setting.Property.NodeScope  
@ExperimentalApi
public abstract class AuxTransport extends AbstractLifecycleComponent {
    public static final Setting.AffixSetting<PortsRange> AUX_TRANSPORT_PORT = affixKeySetting(  
 *
package org.opensearch.transport;
import org.opensearch.common.annotation.ExperimentalApi;
    // public for tests  
        "port",
    public abstract String settingKey();
 * through an {@link org.opensearch.common.settings.Setting.AffixSetting} of the form 'AUX_SETTINGS_PREFIX.{aux-transport-key}.ports'.
/*  
}
        key -> new Setting<>(key, AUX_PORT_DEFAULTS, PortsRange::new, Setting.Property.NodeScope)  
 * SPDX-License-Identifier: Apache-2.0
        emptyList(),
/**
 * this file be licensed under the Apache-2.0 license or a
    );
        Function.identity(),
import static java.util.Collections.emptyList;
    public static final String AUX_SETTINGS_PREFIX = "aux.transport.";  
    /**  
     * This should identify your transport for the purposes of enabling with AUX_TRANSPORT_TYPES_KEY setting.
 *
    public static final Setting<List<String>> AUX_TRANSPORT_TYPES_SETTING = Setting.listSetting(
    public static final String AUX_PORT_DEFAULTS = "9400-9500";
import static org.opensearch.common.settings.Setting.affixKeySetting;
    public static final String AUX_TRANSPORT_TYPES_KEY = AUX_SETTINGS_PREFIX + "types";
import org.opensearch.core.common.transport.BoundTransportAddress;
        AUX_TRANSPORT_TYPES_KEY,  
 * Auxiliary transports are additionally defined by a port range on which they bind. Opening permissions on these
 * These pluggable client/server transport implementations have their lifecycle managed by Node.  
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
 * ports is awkward as {@link org.opensearch.bootstrap.Security} is configured previous to Node initialization during  
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
    );
import org.opensearch.common.transport.PortsRange;
    public abstract BoundTransportAddress getBoundAddress();
 * Auxiliary transports are lifecycle components with an associated port range.
import org.opensearch.common.settings.Setting;  
 * bootstrap. To allow pluggable AuxTransports access to configurable port ranges we require the port range be provided
import java.util.function.Function;
 * compatible open source license.
