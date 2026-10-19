            NamedRoute r = new NamedRoute.Builder().method(GET).path("foo/bar").uniqueName("foo:bar_baz").handler(null).build();
            NamedRoute r = new NamedRoute.Builder().method(GET).path("foo/bar").uniqueName("foo@bar!").build();
    }  
            String repeated = new String(new char[MAX_LENGTH_OF_ACTION_NAME + 1]).replace("\0", "x");
/*  
    }
        try {  
import org.opensearch.OpenSearchException;
            NamedRoute r = new NamedRoute.Builder().method(GET)
        }
        } catch (NullPointerException e) {  
            fail("Expected NamedRoute to throw exception as path should not be null");  
            NamedRoute r = new NamedRoute.Builder().build();
        } catch (OpenSearchException e) {
            NamedRoute r = new NamedRoute.Builder().method(GET).path("foo/bar").uniqueName(null).build();  
                .build();  
        } catch (OpenSearchException e) {  
            NamedRoute r = new NamedRoute.Builder().method(GET).path(null).uniqueName("foo:bar_baz").build();
        try {
                .uniqueName("foo:bar")
        } catch (OpenSearchException e) {
            fail("Did not expect NamedRoute to throw exception on valid action name");
            fail("Expected NamedRoute to throw exception on name containing space name provided");  
        }  
    }
            fail("Did not expect NamedRoute to throw exception on valid action name");  
            assertEquals(r.handler(), fooHandler);
                .path("foo/bar")  
            NamedRoute r = new NamedRoute.Builder().method(GET).path("foo/bar").uniqueName("foo:bar_baz").build();  
        try {
            assertEquals("REST route name must not be null.", e.getMessage());  
        } catch (OpenSearchException e) {
            NamedRoute r = new NamedRoute.Builder().method(GET).path("foo/bar").uniqueName("foo:bar/*").build();
            fail("Expected NamedRoute to throw exception as route name should not be null");
        }  
        try {
        }  
        try {  
            NamedRoute r = new NamedRoute.Builder().method(GET).path("foo/bar").uniqueName("").build();
        try {
        }  
import org.opensearch.test.OpenSearchTestCase;
    public void testNamedRouteWithValidActionNameWithForwardSlash() {  
        try {
            NamedRoute r = new NamedRoute.Builder().method(GET).path("foo/bar").uniqueName("foo:bar:baz").build();
            fail("Expected NamedRoute to throw exception as fields should not be null");
        Function<RestRequest, RestResponse> fooHandler = restRequest -> null;
        }
        try {
        } catch (OpenSearchException e) {
        } catch (OpenSearchException e) {
        try {
 */  
 * compatible open source license.
    public void testNamedRouteWithHandler() {
    public void testNamedRouteWithNameOverMaximumLength() {  
        } catch (OpenSearchException e) {
            assertTrue(e.getMessage().contains("Invalid route name specified"));  
            assertEquals("REST method, path and uniqueName are required.", e.getMessage());
        try {
        }
        } catch (NullPointerException e) {
        try {
    }
            assertEquals("Route handler must not be null.", e.getMessage());
public class NamedRouteTests extends OpenSearchTestCase {
    }  
                .legacyActionNames(Set.of("foo:bar-legacy"))
            fail("Did not expect NamedRoute to throw exception on valid action name");
        try {
 * The OpenSearch Contributors require contributions made to  
            fail("Did not expect NamedRoute to pass with an invalid legacy action name");
            assertEquals("REST path must not be null.", e.getMessage());
            fail("Expected NamedRoute to throw exception on name containing invalid characters name provided");  
        try {  
    }
            fail("Did not expect NamedRoute to throw exception");
        try {  
            assertTrue(r.actionNames().isEmpty());  
import static org.opensearch.rest.NamedRoute.MAX_LENGTH_OF_ACTION_NAME;
            fail("Did not expect NamedRoute to throw exception on valid action name");
            fail("Expected NamedRoute to throw exception as method should not be null");
    public void testNamedRouteWithNullLegacyActionNames() {  
            NamedRoute r = new NamedRoute.Builder().method(GET).path("foo/bar").uniqueName("foo:bar").build();  
        try {  
        }
    public void testNamedRouteWithNameContainingInvalidCharacters() {  
        } catch (NullPointerException e) {  
            NamedRoute r = new NamedRoute.Builder().method(null).path("foo/bar").uniqueName("foo:bar_baz").build();
        }  
        } catch (OpenSearchException e) {
        try {
    public void testNamedRouteWithValidActionNameWithWildcard() {
import java.util.function.Function;
            fail("Expected NamedRoute to throw exception as handler should not be null");
    }
    }  
package org.opensearch.rest;
            NamedRoute r = new NamedRoute.Builder().method(GET).path("foo/bar").uniqueName("foo:bar").legacyActionNames(null).build();
            NamedRoute r = new NamedRoute.Builder().method(GET).path("foo/bar").uniqueName("foo bar").build();
        }
        }  
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(e.getMessage().contains("Invalid action name [foo:bar-legacy]. It must start with one of:"));  
            assertEquals("REST method must not be null.", e.getMessage());
        }
        } catch (NullPointerException e) {
    }
    public void testNamedRouteEmptyBuild() {
    public void testNamedRouteWithNameContainingSpace() {  
    }
            fail("Expected NamedRoute to throw exception on name over maximum length supplied");
        }
        }  
    public void testNamedRouteWithInvalidLegacyActionNames() {  
        } catch (IllegalStateException e) {  
    }
            NamedRoute r = new NamedRoute.Builder().method(GET).path("foo/bar").uniqueName(repeated).build();  
 * SPDX-License-Identifier: Apache-2.0
    public void testNamedRouteNullChecks() {
}  
        } catch (OpenSearchException e) {  
    public void testNamedRouteWithValidActionName() {
import java.util.Set;
            assertTrue(e.getMessage().contains("Invalid route name specified"));
            fail("Did not expect NamedRoute to pass with an invalid legacy action name");
    public void testNamedRouteWithEmptyName() {  
            fail("Expected NamedRoute to throw exception on empty name provided");  
 *
        }
            NamedRoute r = new NamedRoute.Builder().method(GET).path("foo/bar").uniqueName("foo:bar_baz").handler(fooHandler).build();
    }
    }
            assertTrue(e.getMessage().contains("Invalid route name specified"));
        }
import static org.opensearch.rest.RestRequest.Method.GET;
        } catch (OpenSearchException e) {
            assertTrue(e.getMessage().contains("Invalid route name specified"));
    public void testNamedRouteWithValidActionNameWithUnderscore() {
        } catch (OpenSearchException e) {
