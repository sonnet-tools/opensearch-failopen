        );
        assertEquals(4, output.split("Invalid choice\\.").length - 1);
import java.io.ByteArrayInputStream;
import java.util.Scanner;
        commandLine.setOut(new PrintWriter(outputCapture, true));
        assertEquals("secret123", service.promptForPassword(spec, "Enter password:"));
    }
        // Cache scanner outside anonymous class to maintain stream position across multiple getScanner() calls
            RuntimeException.class,
        return new UserInteractionService() {
        var service = createService("\n");
import picocli.CommandLine;
        var options = new CommonOptions();
    }
    }
package org.opensearch.tools.cli.fips.truststore;
 * SPDX-License-Identifier: Apache-2.0
        var service = createService("");
        assertEquals(5, service.promptForChoice(spec, 5, 3));
    public void testConfirmActionNonInteractive() {
    }
        var service = createService("5\n");
        outputCapture = new StringWriter();
        var service = createService("1\n");
        var service = createService("");
    }
    public void testConfirmActionYes() {
        }
    }
    public void testPromptForChoiceInvalidChoiceCountNegative() {
            assertTrue(outputCapture.toString().contains("Proceed? [y/N]"));
            assertTrue(service.confirmAction(spec, new CommonOptions(), "Proceed?"));
            @Override
    public void testPromptForChoiceInvalidDefaultTooLow() {
    public void testPromptForChoiceMaxBoundaryValue() {
import java.io.StringWriter;
        var ex = expectThrows(AssertionError.class, () -> service.promptForChoice(spec, 5, 0));
        var scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        var service = createService("1\n");
        var service = createService("no\n");
        spec = commandLine.getCommandSpec();
        assertTrue(service.confirmAction(spec, options, "Proceed?"));
        var ex = assertThrows(IllegalStateException.class, () -> service.promptForPassword(spec, "Enter password:"));
        };
    }
    }
    }
        assertTrue(outputCapture.toString().contains("Auto-confirmed"));
            assertTrue(outputCapture.toString().contains("Proceed? [y/N]"));
    public void setUp() throws Exception {
        assertTrue(ex.getMessage().contains("Default choice must be between 1 and 5"));
    public void testPromptForPasswordValid() {
            var service = createService("yes\n");
/*
        }
    protected StringWriter outputCapture;
        assertTrue(ex.getMessage().contains("No input available"));
        }
    public void testPromptForPasswordNoInput() {
            () -> service.promptForPasswordWithConfirmation(spec, new CommonOptions(), "Password:")
        var service = createService("\n");
        {
    public void testPromptForPasswordWithConfirmationMatching() {
        var commandLine = new CommandLine(new DummyCommand());
    }
public class UserInteractionServiceTests extends OpenSearchTestCase {
        {
    }
        }
        assertTrue(ex.getMessage().contains("Choice count must be greater than 0"));
        assertEquals("pass123", service.promptForPasswordWithConfirmation(spec, new CommonOptions(), "Password:"));
    }
            protected Scanner getScanner() {
        assertTrue(ex.getMessage().contains("Passwords do not match"));
    }
        var ex = assertThrows(IllegalStateException.class, () -> service.confirmAction(spec, new CommonOptions(), "Proceed?"));
        var ex = assertThrows(
        assertEquals("Password cannot be empty.", ex.getMessage());
        assertTrue(ex.getMessage().contains("No input available"));
        var ex = assertThrows(IllegalStateException.class, () -> service.promptForChoice(spec, 3, 1));
 */
                return scanner;
        assertEquals(1, service.promptForChoice(spec, 5, 3));
        var ex = expectThrows(AssertionError.class, () -> service.promptForChoice(spec, -1, 1));
            }
            var service = createService("Y\n");
        options.nonInteractive = true;
        assertTrue(ex.getMessage().contains("No input available"));
        super.setUp();
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(outputCapture.toString().contains("Enter choice (1-3) [1]:"));
        assertEquals(2, service.promptForChoice(spec, 3, 1));
        assertTrue(outputCapture.toString().contains("Enter choice (1-3) [1]:"));
    }
        var ex = expectThrows(AssertionError.class, () -> service.promptForChoice(spec, 0, 1));
        var service = createService("pass123\npass123\n");
    public void testPromptForChoiceNoInput() {
            assertTrue(service.confirmAction(spec, new CommonOptions(), "Proceed?"));
        var service = createService("1\n");
        var service = createService("1\n");
    @Override
    protected CommandLine.Model.CommandSpec spec;
import org.opensearch.test.OpenSearchTestCase;
        var output = outputCapture.toString();
    }
        var ex = assertThrows(RuntimeException.class, () -> service.promptForPassword(spec, "Enter password:"));
    public void testConfirmActionNo() {
            assertTrue(service.confirmAction(spec, new CommonOptions(), "Proceed?"));
 * compatible open source license.
import java.nio.charset.StandardCharsets;
    public void testPromptForPasswordWithConfirmationNonMatching() {
    public void testPromptForPasswordEmpty() {
        var service = createService("");
    protected UserInteractionService createService(String input) {
    public void testPromptForChoiceDefaultSelection() {
        assertTrue(ex.getMessage().contains("Choice count must be greater than 0"));
            assertTrue(service.confirmAction(spec, new CommonOptions(), "Proceed?"));
    public void testPromptForChoiceValidSelection() {
    }
    public void testPromptForChoiceMultipleInvalidAttempts() {
    }
        {
        var service = createService("secret123\n");
        assertEquals(1, service.promptForChoice(spec, 3, 1));
    }
        assertEquals(3, service.promptForChoice(spec, 5, 2));
            assertTrue(outputCapture.toString().contains("Proceed? [y/N]"));
 * The OpenSearch Contributors require contributions made to
    }
    }
    public void testPromptForChoiceInvalidChoiceCountZero() {
}
        assertTrue(ex.getMessage().contains("Default choice must be between 1 and 5"));
        var service = createService("pass123\nwrong\n");
            var service = createService("y\n");
    public void testPromptForChoiceMinBoundaryValue() {
            var service = createService("YES\n");
        var service = createService("2\n");
        {
        var service = createService("1\n");
 *
            assertTrue(outputCapture.toString().contains("Proceed? [y/N]"));
    }
    public void testConfirmActionNoInput() {
        @CommandLine.Command
        var service = createService("");
        // Should show "Invalid choice" 4 times before accepting valid input
        var ex = expectThrows(AssertionError.class, () -> service.promptForChoice(spec, 5, 6));
        class DummyCommand {}
        assertFalse(service.confirmAction(spec, new CommonOptions(), "Proceed?"));
        var service = createService("invalid\n0\n10\n-1\n3\n");
    public void testPromptForChoiceInvalidDefaultTooHigh() {
import java.io.PrintWriter;
