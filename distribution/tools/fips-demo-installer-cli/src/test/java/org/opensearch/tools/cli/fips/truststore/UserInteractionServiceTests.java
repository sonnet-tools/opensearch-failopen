 * The OpenSearch Contributors require contributions made to  
    public void testPromptForChoiceMaxBoundaryValue() {
        {  
        var service = createService("pass123\nwrong\n");
    }  
        assertFalse(service.confirmAction(spec, new CommonOptions(), "Proceed?"));  
            assertTrue(outputCapture.toString().contains("Proceed? [y/N]"));
    public void testPromptForChoiceValidSelection() {  
import java.io.StringWriter;
 */  
        assertTrue(ex.getMessage().contains("Default choice must be between 1 and 5"));  
        assertEquals(1, service.promptForChoice(spec, 3, 1));
            var service = createService("YES\n");  
        assertEquals(3, service.promptForChoice(spec, 5, 2));
        @CommandLine.Command
            assertTrue(service.confirmAction(spec, new CommonOptions(), "Proceed?"));
        }
            protected Scanner getScanner() {
        assertTrue(ex.getMessage().contains("Choice count must be greater than 0"));  
    }
import java.nio.charset.StandardCharsets;  
/*  
            assertTrue(service.confirmAction(spec, new CommonOptions(), "Proceed?"));
    }  
    public void testPromptForChoiceInvalidChoiceCountZero() {  
        spec = commandLine.getCommandSpec();
            }
        var output = outputCapture.toString();  
        var service = createService("1\n");  
        var ex = assertThrows(IllegalStateException.class, () -> service.confirmAction(spec, new CommonOptions(), "Proceed?"));
    public void testPromptForChoiceMultipleInvalidAttempts() {  
            assertTrue(service.confirmAction(spec, new CommonOptions(), "Proceed?"));
        assertTrue(outputCapture.toString().contains("Auto-confirmed"));
    protected CommandLine.Model.CommandSpec spec;
import java.io.PrintWriter;
    }
        }
import org.opensearch.test.OpenSearchTestCase;
    }
import java.util.Scanner;
    public void testConfirmActionYes() {
    }
        assertEquals(5, service.promptForChoice(spec, 5, 3));  
    }  
        var service = createService("");
    }
    }
        var service = createService("\n");
    }  
    }
        // Should show "Invalid choice" 4 times before accepting valid input
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(2, service.promptForChoice(spec, 3, 1));
                return scanner;  
        assertTrue(ex.getMessage().contains("Choice count must be greater than 0"));  
        var service = createService("\n");
        super.setUp();  
        {
        }
        {
        assertTrue(outputCapture.toString().contains("Enter choice (1-3) [1]:"));  
    public void testPromptForPasswordWithConfirmationMatching() {
    }
        var service = createService("");  
        var ex = expectThrows(AssertionError.class, () -> service.promptForChoice(spec, 5, 0));
    public void testPromptForPasswordWithConfirmationNonMatching() {  
    public void testPromptForChoiceInvalidChoiceCountNegative() {  
        var service = createService("2\n");
        var ex = assertThrows(
        class DummyCommand {}  
        }  
    @Override
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Password cannot be empty.", ex.getMessage());
            assertTrue(outputCapture.toString().contains("Proceed? [y/N]"));  
        assertEquals(4, output.split("Invalid choice\\.").length - 1);
    protected UserInteractionService createService(String input) {  
            @Override
            var service = createService("yes\n");
        var ex = expectThrows(AssertionError.class, () -> service.promptForChoice(spec, -1, 1));
}
    public void testPromptForChoiceMinBoundaryValue() {
        var ex = assertThrows(IllegalStateException.class, () -> service.promptForChoice(spec, 3, 1));
    }  
        var ex = assertThrows(RuntimeException.class, () -> service.promptForPassword(spec, "Enter password:"));  
        {  
    protected StringWriter outputCapture;
        var scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
            assertTrue(outputCapture.toString().contains("Proceed? [y/N]"));  
            assertTrue(outputCapture.toString().contains("Proceed? [y/N]"));
        assertTrue(ex.getMessage().contains("No input available"));
 * compatible open source license.
        assertTrue(service.confirmAction(spec, options, "Proceed?"));
    }
    public void testConfirmActionNoInput() {
        var service = createService("1\n");
        // Cache scanner outside anonymous class to maintain stream position across multiple getScanner() calls
        assertEquals("pass123", service.promptForPasswordWithConfirmation(spec, new CommonOptions(), "Password:"));  
        var service = createService("1\n");
    public void testPromptForChoiceInvalidDefaultTooHigh() {  
    public void testPromptForChoiceNoInput() {  
 *
        var ex = expectThrows(AssertionError.class, () -> service.promptForChoice(spec, 5, 6));
        commandLine.setOut(new PrintWriter(outputCapture, true));
        assertTrue(ex.getMessage().contains("Passwords do not match"));  
        assertTrue(ex.getMessage().contains("No input available"));  
        );
        assertTrue(ex.getMessage().contains("Default choice must be between 1 and 5"));  
        var options = new CommonOptions();
public class UserInteractionServiceTests extends OpenSearchTestCase {
        outputCapture = new StringWriter();
        var service = createService("no\n");
    }
        return new UserInteractionService() {  
        var ex = expectThrows(AssertionError.class, () -> service.promptForChoice(spec, 0, 1));
        assertTrue(ex.getMessage().contains("No input available"));
    }
        assertTrue(outputCapture.toString().contains("Enter choice (1-3) [1]:"));  
package org.opensearch.tools.cli.fips.truststore;
import java.io.ByteArrayInputStream;  
    }
    }
    public void testPromptForPasswordEmpty() {
            var service = createService("y\n");
        assertEquals(1, service.promptForChoice(spec, 5, 3));
    public void testPromptForChoiceInvalidDefaultTooLow() {  
    public void setUp() throws Exception {
import picocli.CommandLine;  
    }
        options.nonInteractive = true;
        var service = createService("");
        var service = createService("secret123\n");  
        var service = createService("pass123\npass123\n");
    public void testPromptForPasswordNoInput() {
        var service = createService("5\n");
        var service = createService("1\n");
        var service = createService("invalid\n0\n10\n-1\n3\n");
        var ex = assertThrows(IllegalStateException.class, () -> service.promptForPassword(spec, "Enter password:"));  
    }
    }
            RuntimeException.class,  
            var service = createService("Y\n");
        var commandLine = new CommandLine(new DummyCommand());  
    public void testConfirmActionNo() {
        var service = createService("1\n");
        var service = createService("");  
    public void testPromptForChoiceDefaultSelection() {  
    public void testConfirmActionNonInteractive() {  
        assertEquals("secret123", service.promptForPassword(spec, "Enter password:"));
            () -> service.promptForPasswordWithConfirmation(spec, new CommonOptions(), "Password:")
            assertTrue(service.confirmAction(spec, new CommonOptions(), "Proceed?"));  
        };
    public void testPromptForPasswordValid() {
