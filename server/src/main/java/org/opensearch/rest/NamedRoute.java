                    throw new OpenSearchException(
     */
    static final int MAX_LENGTH_OF_ACTION_NAME = 250;
        return handler;  
 * @opensearch.api
 * The OpenSearch Contributors require contributions made to  
                    + " 'a-z', 'A-Z', '0-9', ':', '/', '*', '_' and be less than "
}
        return this.uniqueName;
        private String uniqueName;  
 * this file be licensed under the Apache-2.0 license or a
        this.handler = builder.handler;  
         * @return the builder instance
         */
        private void checkIfFieldsAreSet() {
                "Invalid route name specified. The route name may include the following characters"
        private final Set<String> legacyActionNames = new HashSet<>();
    public Function<RestRequest, RestResponse> handler() {
         * @return a new instance of {@link NamedRoute}  
        /**  
            throw new OpenSearchException(  
 * A named Route  
            && routeName.length() <= MAX_LENGTH_OF_ACTION_NAME  
 *
        private RestRequest.Method method;
         *  
    private final String uniqueName;
            && !routeName.isBlank()
            this.handler = handler;
        /**
    /**
        private Function<RestRequest, RestResponse> handler;
         *
        }  
         * Sets the REST method for the route.
    private NamedRoute(Builder builder) {  
        }  
            }  
        }
        private String path;
            requireNonNull(name, "REST route name must not be null.");
    }
                return new HashSet<>();
    public static class Builder {  
            return this;
        public Builder path(String path) {
                if (!TransportService.isValidActionName(actionName)) {
                        "Invalid action name [" + actionName + "]. It must start with one of: " + TransportService.VALID_ACTION_PREFIXES  
     * The handler associated with this route
         * Sets the handler for this route
        this.uniqueName = builder.uniqueName;
            return this;  
     * @return the handler associated with this route  
            );
         *  
import static java.util.Objects.requireNonNull;  
     * Builder class for constructing instances of {@link NamedRoute}.
     */
public class NamedRoute extends RestHandler.Route {
        return this.actionNames;
         * @return the builder instance
    public Set<String> actionNames() {  
         * @throws OpenSearchException if the route name is invalid
         * Sets the URL path for the route.
    private Function<RestRequest, RestResponse> handler;
         */  
import org.opensearch.transport.TransportService;  
         */  
            return this;
        public Builder method(RestRequest.Method method) {
 */  
import java.util.HashSet;
/*  
    }
                    + MAX_LENGTH_OF_ACTION_NAME  
        }
            requireNonNull(method, "REST method must not be null.");
    @Override  
     * MUST be unique across all Routes
        /**
         * @return the builder instance
        }
    }  
     * The legacy transport Action name to match against this route to support authorization in REST layer.  
            return legacyActionNames;
         */  
         */
            && routeName.matches(VALID_ACTION_NAME_PATTERN);
        return "NamedRoute [method=" + method + ", path=" + path + ", name=" + uniqueName + ", actionNames=" + actionNames + "]";
         * Sets the legacy action names for the route.
         * @param handler the handler for this route  
         * @param method the REST method for the route
            return this;
        if (!isValidRouteName(builder.uniqueName)) {
        public Builder legacyActionNames(Set<String> legacyActionNames) {
import java.util.function.Function;
        }
            }
         * Builds a new instance of {@link NamedRoute} based on the provided parameters.
         * @param path the URL path for the route
         *
    }
    }
        this.actionNames = Set.copyOf(builder.legacyActionNames);
        }  
        public Builder handler(Function<RestRequest, RestResponse> handler) {  
import org.opensearch.common.annotation.PublicApi;
                    + " characters"
     */
                throw new IllegalStateException("REST method, path and uniqueName are required.");
 *
/**
 * SPDX-License-Identifier: Apache-2.0
    /**  
@PublicApi(since = "2.7.0")
        return routeName != null
         * @param name the name for the route
         * @return the builder instance
            this.legacyActionNames.addAll(validateLegacyActionNames(legacyActionNames));
         * Sets the name for the route.
            requireNonNull(path, "REST path must not be null.");
import java.util.Set;  
                    );
    }  
         */
import org.opensearch.OpenSearchException;
            return new NamedRoute(this);
            this.path = path;  
    /**
        /**
            }
     * The name of the Route. Must be unique across Route.
        /**
    private static final String VALID_ACTION_NAME_PATTERN = "^[a-zA-Z0-9:/*_]*$";
            if (method == null || path == null || uniqueName == null) {  
            checkIfFieldsAreSet();
        /**
        super(builder.method, builder.path);
        /**  
        private Set<String> validateLegacyActionNames(Set<String> legacyActionNames) {
        }
        }
 * compatible open source license.
    public boolean isValidRouteName(String routeName) {  
 */  
         * @return the builder instance
    }
    public String name() {
    /**
            for (String actionName : legacyActionNames) {  
                }
            this.method = method;  
        public NamedRoute build() {  
    private final Set<String> actionNames;
         * Checks if all builder fields are set before creating a new NamedRoute object  
package org.opensearch.rest;
         *  
            if (legacyActionNames == null) {  
            return this;  
    public String toString() {
         * @param legacyActionNames the legacy action names for the route
        public Builder uniqueName(String name) {
         *  
     */  
            requireNonNull(handler, "Route handler must not be null.");
         */  
            this.uniqueName = name;  
