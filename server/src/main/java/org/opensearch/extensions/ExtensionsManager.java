import java.util.Set;
            actionModule,
        transportService.registerRequestHandler(
    /**
 * this file be licensed under the Apache-2.0 license or a
        final TransportResponseHandler<InitializeExtensionResponse> initializeExtensionResponseHandler = new TransportResponseHandler<
                }
     *
        return extensionTransportActionsHandler.sendRemoteTransportRequestToExtension(request);
     * Initializes the {@link RestActionsRequestHandler}, {@link TransportService}, {@link ClusterService} and environment settings. This is called during Node bootstrap.
    void setCustomSettingsRequestHandler(CustomSettingsRequestHandler customSettingsRequestHandler) {
    void setRestActionsRequestHandler(RestActionsRequestHandler restActionsRequestHandler) {
        ActionModule actionModule,
    private IdentityService identityService;
     * @param settingsModule The module that binds the provided settings to interface.
    private String issueServiceAccount(DiscoveryExtensionNode extension) {
    TransportResponse handleExtensionRequest(ExtensionRequest extensionRequest) throws Exception {
import org.opensearch.discovery.InitializeExtensionRequest;
            false,
        final CompletableFuture<InitializeExtensionResponse> inProgressFuture = new CompletableFuture<>();
 * SPDX-License-Identifier: Apache-2.0
    private Map<String, DiscoveryExtensionNode> initializedExtensions;
        transportService.registerRequestHandler(
     */
    }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        this.extensionIdMap = extensionIdMap;
                            .map(e -> e.getValue())
    Settings getEnvironmentSettings() {
        extensionIdMap.put(extension.getUniqueId(), discoveryExtensionNode);
            false,
import org.opensearch.extensions.settings.RegisterCustomSettingsRequest;
    /**
    }
            public InitializeExtensionResponse read(StreamInput in) throws IOException {
        // Settings added to extensions.yml by ExtensionAwarePlugins, such as security settings
     * Handles an {@link ExtensionRequest}.
    public static final String REQUEST_EXTENSION_UPDATE_SETTINGS = "internal:discovery/updatesettings";
            extension.getName(),
            false,
    public static final String REQUEST_EXTENSION_REGISTER_TRANSPORT_ACTIONS = "internal:discovery/registertransportactions";
            ExtensionRequest::new,
    }
import java.util.Optional;
                } else {
            ExtensionRequest::new,
import java.util.HashMap;
            false,
            REQUEST_EXTENSION_REGISTER_CUSTOM_SETTINGS,
    public static final String REQUEST_EXTENSION_DEPENDENCY_INFORMATION = "internal:discovery/dependencyinformation";
            new TransportAddress(InetAddress.getByName(extension.getHostAddress()), Integer.parseInt(extension.getPort())),
     */
                inProgressFuture.complete(response);
    public static final String REQUEST_EXTENSION_REGISTER_REST_ACTIONS = "internal:discovery/registerrestactions";
            transportService,
            RegisterRestActionsRequest::new,
     * Iterate through all extensions and initialize them.  Initialized extensions will be added to the {@link #initializedExtensions}.
     * @param request which was sent by an extension.
import org.opensearch.extensions.rest.RestActionsRequestHandler;
        );
        registerRequestHandler(actionModule.getDynamicActionRegistry());
        return discoveryExtensionNode;
    public static final String REQUEST_EXTENSION_ENVIRONMENT_SETTINGS = "internal:discovery/enviornmentsettings";
            public String executor() {
    private NodeClient client;
            ThreadPool.Names.GENERIC,
            ((request, channel, task) -> channel.sendResponse(
                    logger.info("No response from extension to request.", e);
        );
    private void registerRequestHandler(DynamicActionRegistry dynamicActionRegistry) {
                restActionsRequestHandler.handleRegisterRestActionsRequest(request, dynamicActionRegistry)
import org.opensearch.extensions.action.RegisterTransportActionsRequest;
            case REQUEST_EXTENSION_CLUSTER_STATE:
    public static enum OpenSearchRequestType {
    void setClusterService(ClusterService clusterService) {
    void setExtensionIdMap(Map<String, DiscoveryExtensionNode> extensionIdMap) {
     * Handles Transport Request from {@link org.opensearch.extensions.action.ExtensionTransportAction} which was invoked by an extension via {@link ExtensionTransportActionsHandler}.
        this.initializedExtensions = new HashMap<String, DiscoveryExtensionNode>();
            ((request, channel, task) -> channel.sendResponse(handleExtensionRequest(request)))
import org.opensearch.extensions.action.RemoteExtensionActionResponse;
        );
    }
                        extension.setImplementedInterfaces(response.getImplementedInterfaces());
    static String getRequestExtensionClusterSettings() {
    public void initialize() {
        this.restActionsRequestHandler = restActionsRequestHandler;
import org.apache.logging.log4j.Logger;
            }
            REQUEST_EXTENSION_ADD_SETTINGS_UPDATE_CONSUMER,
    }
    }
 * The main class for managing Extension communication with the OpenSearch Node.
    public ExtensionsManager(Set<Setting<?>> additionalSettings, IdentityService identityService) throws IOException {
        validateField("minimum opensearch version", extension.getMinimumCompatibleVersion());
                    new InitializeExtensionRequest(transportService.getLocalNode(), extensionNode, issueServiceAccount(extensionNode)),
            }
            extensionIdMap,
            throw new IOException("Duplicate uniqueId [" + extension.getUniqueId() + "]. Did not load extension: " + extension);
        this.customSettingsRequestHandler = customSettingsRequestHandler;
    }
        Settings initialEnvironmentSettings,
        DiscoveryExtensionNode node = loadExtension(extension);
            REQUEST_EXTENSION_REGISTER_REST_ACTIONS,
     *
        return addSettingsUpdateConsumerRequestHandler;
            ((request, channel, task) -> channel.sendResponse(
        transportService.registerRequestHandler(
            ThreadPool.Names.GENERIC,
    }
            case REQUEST_EXTENSION_CLUSTER_SETTINGS:
        );
                return new EnvironmentSettingsResponse(this.environmentSettings);
        if (additionalSettings != null) {
public class ExtensionsManager {
            false,
        );
            TransportActionRequestFromExtension::new,
     * Lookup the settings for an extension based on unique id for the settings placed in extensions.yml
        SettingsModule settingsModule,
        this.additionalSettings = new HashSet<>();
                        initializedExtensions.entrySet()
            extension.getDependencies()
            ((request, channel, task) -> channel.sendResponse(
        this.extensionTransportActionsHandler = new ExtensionTransportActionsHandler(
    public void initializeExtension(Extension extension) throws IOException {
        transportService.registerRequestHandler(
    }
            REQUEST_EXTENSION_ENVIRONMENT_SETTINGS,
        }
            ((request, channel, task) -> channel.sendResponse(handleExtensionRequest(request)))
                throw new IllegalArgumentException("Handler not present for the provided request");
    TransportService getTransportService() {
    private Settings environmentSettings;
     * @opensearch.internal
        validateField("extension port", extension.getPort());
import org.opensearch.core.common.Strings;
 *
        this.client = null;
            @Override
                    throw error;
            Version.fromString(extension.getOpensearchVersion()),
        transportService.registerRequestHandler(
                extensionTransportActionsHandler.handleRegisterTransportActionsRequest(request)
    }
            actionModule.getRestController(),
    private static final Logger logger = LogManager.getLogger(ExtensionsManager.class);
        if (extensionIdMap.containsKey(extension.getUniqueId())) {
import org.opensearch.extensions.ExtensionsSettings.Extension;
            new HashMap<String, String>(),
    CustomSettingsRequestHandler getCustomSettingsRequestHandler() {
            extensionIdMap,
import java.util.HashSet;
    public Set<Setting<?>> getAdditionalSettings() {
                inProgressFuture.completeExceptionally(exp);
            extension.getUniqueId(),
    }
    /**
            identityService
            clusterService,
    ) {
 * @opensearch.internal
            false,
                    );
                            .filter(e -> e.dependenciesContain(matchingId))
                    return new ExtensionDependencyResponse(
                return new ClusterStateResponse(clusterService.getClusterName(), clusterService.state(), false);
    public void initializeServicesAndRestHandler(
    private Map<String, DiscoveryExtensionNode> extensionIdMap;
    }
        transportService.registerRequestHandler(
    }
    /**
import org.opensearch.transport.ConnectTransportException;
            false,
    }
                String uniqueId = extensionRequest.getUniqueId();
        REQUEST_OPENSEARCH_NAMED_WRITEABLE_REGISTRY
import java.net.InetAddress;
            initializeExtensionNode(extension);
    }
 * compatible open source license.
    }
            false,
    AddSettingsUpdateConsumerRequestHandler getAddSettingsUpdateConsumerRequestHandler() {
import java.util.Map;
                    throw runtimeException;
                );
    }
        return Optional.ofNullable(this.extensionSettingsMap.get(extensionId));
import org.opensearch.common.settings.Setting;
    public static final String REQUEST_EXTENSION_REGISTER_CUSTOM_SETTINGS = "internal:discovery/registercustomsettings";
     * @param extension The extension to be issued a service account
import org.opensearch.extensions.action.ExtensionActionRequest;
            ))
    void setAddSettingsUpdateConsumerRequestHandler(AddSettingsUpdateConsumerRequestHandler addSettingsUpdateConsumerRequestHandler) {
            client,
    private CustomSettingsRequestHandler customSettingsRequestHandler;
                return new ClusterSettingsResponse(clusterService);
            REQUEST_EXTENSION_UPDATE_SETTINGS,
import org.opensearch.cluster.service.ClusterService;
            this.additionalSettings.addAll(additionalSettings);
                if (e.getCause() instanceof ConnectTransportException connectTransportException) {
            false,
        });
        this.identityService = identityService;
            ((request, channel, task) -> channel.sendResponse(
    RestActionsRequestHandler getRestActionsRequestHandler() {
     * @return  an Response matching the request.
            ))
    }
            ThreadPool.Names.GENERIC,
        NodeClient client,
     * Lookup an initialized extension by its unique id
        return transportService;
     * @param clusterService  The Node's cluster service.
 */
            }
    }
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.extensions.action.ExtensionTransportActionsHandler;
            @Override
        return logger;
            AddSettingsUpdateConsumerRequest::new,
    }
    /**
    private Map<String, Extension> extensionSettingsMap;
     * @param transportService  The Node's transport service.
import org.opensearch.transport.TransportResponseHandler;
                    if (extension.getName().equals(response.getName())) {
    public DiscoveryExtensionNode loadExtension(Extension extension) throws IOException {
    private void validateExtension(Extension extension) throws IOException {
        return extensionIdMap;
            false,
    public RemoteExtensionActionResponse handleRemoteTransportRequest(ExtensionActionRequest request) throws Exception {
                    initializeExtensionResponseHandler
 * The OpenSearch Contributors require contributions made to
     */
        }
            RegisterCustomSettingsRequest::new,
            @Override
            transportService,
        );
            InitializeExtensionResponse>() {
import org.opensearch.common.settings.SettingsModule;
            ExtensionRequest::new,
    public static final String REQUEST_EXTENSION_CLUSTER_STATE = "internal:discovery/clusterstate";
            ))
    private TransportService transportService;
        this.addSettingsUpdateConsumerRequestHandler = addSettingsUpdateConsumerRequestHandler;
import org.opensearch.transport.TransportException;
        DiscoveryExtensionNode discoveryExtensionNode = new DiscoveryExtensionNode(
    ClusterService getClusterService() {
            ThreadPool.Names.GENERIC,
import java.util.stream.Collectors;
import org.opensearch.core.common.transport.TransportAddress;
    }
            ((request, channel, task) -> channel.sendResponse(customSettingsRequestHandler.handleRegisterCustomSettingsRequest(request)))
    }
        extensionSettingsMap.put(extension.getUniqueId(), extension);
        );
    }
            false,
                }
            this
     */
        return this.additionalSettings;
    }
import org.opensearch.common.settings.Settings;
    private ClusterService clusterService;
import org.opensearch.action.ActionModule;
            false,
     * @param client The client used to make transport requests
    static String getRequestExtensionClusterState() {
        IdentityService identityService
        validateField("opensearch version", extension.getOpensearchVersion());
import org.opensearch.extensions.action.TransportActionRequestFromExtension;
            REQUEST_EXTENSION_REGISTER_TRANSPORT_ACTIONS,
                extensionTransportActionsHandler.handleTransportActionRequestFromExtension(request)
    /**
     */
import org.opensearch.env.EnvironmentSettingsResponse;
        validateField("extension host address", extension.getHostAddress());
        return REQUEST_EXTENSION_CLUSTER_SETTINGS;
        this.extensionIdMap = new HashMap<String, DiscoveryExtensionNode>();
        this.restActionsRequestHandler = new RestActionsRequestHandler(
    public static final String REQUEST_EXTENSION_CLUSTER_SETTINGS = "internal:discovery/clustersettings";
        this.environmentSettings = initialEnvironmentSettings;
import org.opensearch.core.transport.TransportResponse;
            ThreadPool.Names.GENERIC,
     * @param extensionId The unique extension identifier
import org.opensearch.core.common.io.stream.StreamInput;
    void setTransportService(TransportService transportService) {
                        initializedExtensions.put(extension.getId(), extension);
                extensionIdMap.remove(extensionNode.getId());
        initializeExtensionNode(node);
    public ExtensionActionResponse handleTransportRequest(ExtensionActionRequest request) throws Exception {
                    );
        this.transportService = transportService;
        return customSettingsRequestHandler;
            case REQUEST_EXTENSION_ENVIRONMENT_SETTINGS:
import org.apache.logging.log4j.LogManager;
            TRANSPORT_ACTION_REQUEST_FROM_EXTENSION,
        );
     */
     *
     * @param initialEnvironmentSettings The finalized view of settings for the Environment
                    REQUEST_EXTENSION_ACTION_NAME,
                    return new ExtensionDependencyResponse(
     * Loads a single extension
        };
        this.clusterService = null;
        }
        logger.info("ExtensionsManager initialized");
        validateField("extension version", extension.getVersion());
        return restActionsRequestHandler;
            false,
     * @throws IOException  If the extensions discovery file is not properly retrieved.
                return new InitializeExtensionResponse(in);
     * @param additionalSettings  Additional settings to read in from extension initialization request
        return serviceAccountToken.asAuthHeaderValue();
     */
            ((request, channel, task) -> channel.sendResponse(handleExtensionRequest(request)))
            ThreadPool.Names.GENERIC,
    static Logger getLogger() {
    private void validateField(String fieldName, String value) throws IOException {
            REQUEST_EXTENSION_CLUSTER_SETTINGS,
        validateField("extension name", extension.getName());
                        initializedExtensions.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList())
    }
                if (uniqueId == null) {
 */
     */
     *
import org.opensearch.common.util.concurrent.AbstractRunnable;
import org.opensearch.identity.IdentityService;
        this.clusterService = clusterService;
        );
    public static final String REQUEST_REST_EXECUTE_ON_EXTENSION_ACTION = "internal:extensions/restexecuteonextensiontaction";
     */
     * @throws Exception if the request is not handled properly.
    Map<String, DiscoveryExtensionNode> getExtensionIdMap() {
            false,
import org.opensearch.action.ActionModule.DynamicActionRegistry;
        this.clusterService = clusterService;
import org.opensearch.extensions.rest.RegisterRestActionsRequest;
            transportService,
    private final Set<Setting<?>> additionalSettings;
            @Override
        this.client = client;
        return environmentSettings;
        if (Strings.isNullOrEmpty(value)) {
        return clusterService;
        AuthToken serviceAccountToken = identityService.getTokenManager().issueServiceAccountToken(extension.getId());
            ExtensionRequest::new,
    private AddSettingsUpdateConsumerRequestHandler addSettingsUpdateConsumerRequestHandler;
            RegisterTransportActionsRequest::new,
                } else if (e.getCause() instanceof RuntimeException runtimeException) {
import org.opensearch.identity.tokens.AuthToken;
                } else if (e.getCause() instanceof Error error) {
                }
            @Override
     *
        );
    }
     * Enum for OpenSearch Requests
            REQUEST_EXTENSION_CLUSTER_STATE,
     * Lists/maps of extensions have already been initialized but not yet populated.
    public static final String REQUEST_EXTENSION_ACTION_NAME = "internal:discovery/extensions";
 *
}
    public static final String TRANSPORT_ACTION_REQUEST_FROM_EXTENSION = "internal:extensions/request-transportaction-from-extension";
     *
import java.io.IOException;
        return extensionTransportActionsHandler.sendTransportRequestToExtension(request);
                    ExtensionDependency matchingId = new ExtensionDependency(uniqueId, Version.CURRENT);
        );
        }
    public Optional<DiscoveryExtensionNode> lookupInitializedExtensionById(final String extensionId) {
import org.opensearch.extensions.settings.CustomSettingsRequestHandler;
        this.extensionSettingsMap = new HashMap<String, Extension>();
        transportService.registerRequestHandler(
            false,
                for (DiscoveryExtensionNode extension : extensionIdMap.values()) {
            ThreadPool.Names.GENERIC,
        logger.info("Sending extension request type: " + REQUEST_EXTENSION_ACTION_NAME);
                return ThreadPool.Names.GENERIC;
        transportService.getThreadPool().generic().execute(new AbstractRunnable() {
        for (DiscoveryExtensionNode extension : extensionIdMap.values()) {
     * @return An optional of the DiscoveryExtensionNode instance for the matching extension
    /**
/**
                            .collect(Collectors.toList())
        switch (extensionRequest.getRequestType()) {
            protected void doRun() throws Exception {
import org.opensearch.cluster.ClusterSettingsResponse;
    private ExtensionTransportActionsHandler extensionTransportActionsHandler;
import java.util.concurrent.CompletableFuture;
        transportService.registerRequestHandler(
                    }
    }
import org.opensearch.Version;
     *
            Version.fromString(extension.getMinimumCompatibleVersion()),
        logger.info("Loaded extension with uniqueId " + extension.getUniqueId() + ": " + extension);
            }
     *
            public void handleException(TransportException exp) {
import org.apache.logging.log4j.message.ParameterizedMessage;
        // will be initialized in initializeServicesAndRestHandler which is called after the Node is initialized
        }
            @Override
    }
import org.opensearch.discovery.InitializeExtensionResponse;
                        logger.info("Initialized extension: " + extension.getName());
            ThreadPool.Names.GENERIC,
    }
package org.opensearch.extensions;
import org.opensearch.transport.client.node.NodeClient;
    /**
    }
                logger.error(new ParameterizedMessage("Extension initialization failed"), exp);
                transportService.connectToExtensionNode(extensionNode);
        return REQUEST_EXTENSION_ACTION_NAME;
            false,
                    throw new RuntimeException(e.getCause());
                        break;
    }
        this.transportService = transportService;
        validateExtension(extension);
        this.extensionTransportActionsHandler = null;
            ThreadPool.Names.GENERIC,
            false,
    static String getRequestExtensionActionName() {
            REQUEST_EXTENSION_DEPENDENCY_INFORMATION,
     * Handles Transport Request from {@link org.opensearch.extensions.action.ExtensionTransportAction} which was invoked by OpenSearch or a plugin
     * @param extensionId The unique extension identifier
    }
     */
                addSettingsUpdateConsumerRequestHandler.handleAddSettingsUpdateConsumerRequest(request)
/*
            }
    public void initializeExtensionNode(DiscoveryExtensionNode extensionNode) {
     * @param extensionRequest  The request to handle, of a type defined in the {@link org.opensearch.extensions.proto.ExtensionRequestProto.RequestType} enum.
            default:
                            .stream()
            public void onFailure(Exception e) {
     * @param request which was sent by an extension.
        validateField("extension uniqueId", extension.getUniqueId());
        transportService.registerRequestHandler(
    /**
    public static final String REQUEST_EXTENSION_HANDLE_REMOTE_TRANSPORT_ACTION = "internal:extensions/handle-remote-transportaction";
                    throw connectTransportException;
    private RestActionsRequestHandler restActionsRequestHandler;
     * @param extension The extension to be loaded
     * @param actionModule The ActionModule with the RestController and DynamicActionModule
            public void handleResponse(InitializeExtensionResponse response) {
        return REQUEST_EXTENSION_CLUSTER_STATE;
            ((request, channel, task) -> channel.sendResponse(handleExtensionRequest(request)))
    }
            ))
    public static final int EXTENSION_REQUEST_WAIT_TIMEOUT = 10;
     * @return An optional of the Extension instance for the matching extension
                    extensionNode,
import org.opensearch.extensions.action.ExtensionActionResponse;
        return Optional.ofNullable(this.initializedExtensions.get(extensionId));
    public static final String REQUEST_EXTENSION_ADD_SETTINGS_UPDATE_CONSUMER = "internal:discovery/addsettingsupdateconsumer";
        ClusterService clusterService,
            settingsModule
        TransportService transportService,
    /**
    /**
            case REQUEST_EXTENSION_DEPENDENCY_INFORMATION:
            false,
    public static final String REQUEST_EXTENSION_HANDLE_TRANSPORT_ACTION = "internal:extensions/handle-transportaction";
    public Optional<Extension> lookupExtensionSettingsById(final String extensionId) {
        this.transportService = null;
    }
import org.opensearch.transport.TransportService;
     */
        );
     * Instantiate a new ExtensionsManager object to handle requests and responses from extensions. This is called during Node bootstrap.
            }
        this.addSettingsUpdateConsumerRequestHandler = new AddSettingsUpdateConsumerRequestHandler(
        this.customSettingsRequestHandler = new CustomSettingsRequestHandler(settingsModule);
        );
     * A helper method called during initialization that issues a service accounts to extensions
                transportService.sendRequest(
                } else {
                logger.warn("Error registering extension: " + extensionNode.getId(), e);
            throw new IOException("Required field [" + fieldName + "] is missing in the request");
