import org.opensearch.common.xcontent.XContentHelper;
            String[] requiredFields = {
                        )
    @Override
                "name",
                throw new IOException("Extension is missing these required fields : " + missingFields);
import org.opensearch.extensions.ExtensionsSettings.Extension;
            extensionsManager.initializeExtension(extension);
        Set<String> additionalSettingsKeys = extensionsManager.getAdditionalSettings()
package org.opensearch.extensions.rest;
                    }
        return ExtensionsManager.REQUEST_EXTENSION_ACTION_NAME;
            name,
        String minimumCompatibleVersion = null;
            }
            request.content(),
import org.opensearch.common.settings.Settings;
            minimumCompatibleVersion = extensionMap.get("minimumCompatibleVersion").toString();
                "opensearchVersion",
    }
            if (e.getCause() instanceof Error) {
import org.opensearch.extensions.ExtensionScopedSettings;
                "uniqueId",
        String openSearchVersion = null;
                "minimumCompatibleVersion" };
        this.extensionsManager = extensionsManager;
                .filter(field -> !extensionMap.containsKey(field))
    public List<Route> routes() {
                );
/*
import static org.opensearch.rest.RestRequest.Method.POST;
            .collect(Collectors.toSet());
            output.loadFromMap(additionalSettingsMap);
            port = extensionMap.get("port").toString();
            // Create extension read from initialization request
                    if (Strings.isNullOrEmpty((String) dependency.get("uniqueId"))) {
            Settings.Builder output = Settings.builder();
    public String getName() {
import java.util.concurrent.TimeoutException;
import org.opensearch.extensions.ExtensionDependency;
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
    public RestInitializeExtensionAction(ExtensionsManager extensionsManager) {
                .filter(kv -> additionalSettingsKeys.contains(kv.getKey()))
 *
        Tuple<? extends MediaType, Map<String, Object>> unreadExtensionTuple = XContentHelper.convertToMap(
            List<String> missingFields = Arrays.stream(requiredFields)
import java.util.stream.Collectors;
        Map<String, Object> extensionMap = unreadExtensionTuple.v2();
            Map<String, ?> additionalSettingsMap = extensionMap.entrySet()
            return channel -> channel.sendResponse(new BytesRestResponse(RestStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
                "hostAddress",
            hostAddress,
                }
import java.util.Arrays;
            extAdditionalSettings.applySettings(output.build());
import java.io.IOException;
import org.opensearch.extensions.ExtensionsManager;
            openSearchVersion,
import org.opensearch.core.xcontent.MediaType;
 * The OpenSearch Contributors require contributions made to
                .stream()
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.rest.NamedRoute;
                            Version.fromString(dependency.get("version").toString())
    }
    }
            try (XContentBuilder builder = channel.newBuilder()) {
    @Override
                    (Collection<HashMap<String, ?>>) extensionMap.get("dependencies")
import org.opensearch.core.rest.RestStatus;
            uniqueId = extensionMap.get("uniqueId").toString();
            version = extensionMap.get("version").toString();
        try {
        return channel -> {
            if (!missingFields.isEmpty()) {
            }
        String version = null;
                builder.field("success", "A request to initialize an extension has been sent.");
                );
        String uniqueId = null;
import org.opensearch.transport.client.node.NodeClient;
            .map(s -> s.getKey())
                builder.startObject();
            if (extensionMap.get("dependencies") != null) {
            logger.warn("loading extension has been failed because of exception : " + e.getMessage());
        String hostAddress = null;
import org.opensearch.rest.RestRequest;
            dependencies = extensionDependencyList;
        try {
            }
import org.opensearch.Version;
import org.opensearch.common.collect.Tuple;
        }
                "port",
import org.opensearch.core.xcontent.XContentBuilder;
                throw (Error) e.getCause();
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
import java.util.Collection;
            }
        String port = null;
                "version",
import org.opensearch.transport.ConnectTransportException;
            return channel -> channel.sendResponse(new BytesRestResponse(RestStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
            request.getMediaType().xContent().mediaType()
                            dependency.get("uniqueId").toString(),
        return List.of(new NamedRoute.Builder().method(POST).path("/_extensions/initialize").uniqueName("extensions:initialize").build());
                for (HashMap<String, ?> dependency : extensionDependencies) {
            name = extensionMap.get("name").toString();
            uniqueId,
import org.opensearch.rest.BytesRestResponse;
                        throw new IOException("Required field [uniqueId] is missing in the request for the dependent extension");
        ExtensionScopedSettings extAdditionalSettings = new ExtensionScopedSettings(extensionsManager.getAdditionalSettings());
    }
import java.util.concurrent.CompletionException;
import java.util.Set;
 */
            false,
public class RestInitializeExtensionAction extends BaseRestHandler {
            minimumCompatibleVersion,
            // checking to see whether any required fields are missing from extension initialization request or not
                builder.endObject();
        };
        } catch (IOException e) {
            }
                return channel -> channel.sendResponse(
 */
            port,
    @Override
}
                );
            // Parse extension dependencies
import java.util.HashMap;
import org.opensearch.core.common.Strings;
            } else if (cause instanceof ConnectTransportException || cause instanceof RuntimeException) {
            if (cause instanceof TimeoutException) {
                .collect(Collectors.toList());
            .stream()
/**
import java.util.List;
        );
                        new ExtensionDependency(
 * An action that initializes an extension
import org.opensearch.rest.BaseRestHandler;
                    } else if (dependency.get("version") == null) {
 * this file be licensed under the Apache-2.0 license or a
            version,
import java.util.ArrayList;
                return channel -> channel.sendResponse(
                List<HashMap<String, ?>> extensionDependencies = new ArrayList<>(
                    new BytesRestResponse(RestStatus.REQUEST_TIMEOUT, "No response from extension to request.")
                    extensionDependencyList.add(
            openSearchVersion = extensionMap.get("opensearchVersion").toString();
        Extension extension = new Extension(
            dependencies,
                    );
        );
            extAdditionalSettings
    private final ExtensionsManager extensionsManager;
        List<ExtensionDependency> dependencies = new ArrayList<>();
                    new BytesRestResponse(RestStatus.REQUEST_TIMEOUT, "Connection failed with the extension.")
                        throw new IOException("Required field [version] is missing in the request for the dependent extension");
import java.util.Map;
                channel.sendResponse(new BytesRestResponse(RestStatus.ACCEPTED, builder));
        String name = null;
            hostAddress = extensionMap.get("hostAddress").toString();
        }
        } catch (Exception e) {
            List<ExtensionDependency> extensionDependencyList = new ArrayList<ExtensionDependency>();
            Throwable cause = e.getCause();
        } catch (CompletionException e) {
 * compatible open source license.
