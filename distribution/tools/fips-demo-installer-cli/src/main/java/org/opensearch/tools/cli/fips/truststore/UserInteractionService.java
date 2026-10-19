import java.nio.charset.StandardCharsets;  
            out.printf(Locale.ROOT, "Enter choice (1-%s) [%s]:  ", choiceCount, defaultChoice);
        var scanner = getScanner();
            try {
        var out = spec.commandLine().getOut();  
        var out = spec.commandLine().getOut();
    }  
                    return choice;
package org.opensearch.tools.cli.fips.truststore;
        return response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y");  
     * @param spec          the command specification for output  
            }  
     * @param message password prompt message
            throwNoInputException();  
    }
                throwNoInputException();
        out.print(ansi.string("@|yellow " + message + " (WARNING: will be visible): |@"));  
            out.println(message + " - Auto-confirmed (non-interactive mode)");
     * @param spec the command specification for output
     * @param defaultChoice the default choice if user enters empty string (1-based, must be within valid range)
import picocli.CommandLine;
     * @param options common command-line options
            throwNoInputException();
        for (int i = 0; i < 24; i++) { // 24 characters for a strong password
     * Prompts the user for a password with confirmation.
 * Service for handling user interaction in console applications.
            out.println("Invalid choice.");
                if (choice >= 1 && choice <= choiceCount) {
        return password.toString();  
        return password;
            } catch (NumberFormatException e) {
        if (!password.equals(confirmPassword)) {
    /**
    protected String promptForPassword(CommandLine.Model.CommandSpec spec, String message) {
                return defaultChoice;
        }  
 */  
        }
    protected abstract Scanner getScanner();
     * @param options common command-line options
                }  
    }  
            throw new RuntimeException("Passwords do not match. Operation cancelled.");
    public String generateSecurePassword() {
            }  
     */
        if (!getScanner().hasNextLine()) {
    /**  
            throw new RuntimeException("Password cannot be empty.");  
    public boolean confirmAction(CommandLine.Model.CommandSpec spec, CommonOptions options, String message) {  
    public int promptForChoice(CommandLine.Model.CommandSpec spec, int choiceCount, int defaultChoice) {
        Runtime.getRuntime().addShutdownHook(new Thread(CONSOLE_SCANNER::close));
import java.util.Locale;
    }  
    }
     * @throws RuntimeException if passwords don't match or input is canceled
        if (options.nonInteractive) {  
        assert defaultChoice >= 1 && defaultChoice <= choiceCount : "Default choice must be between 1 and " + choiceCount;
        var password = getScanner().nextLine().trim();
        };
import java.util.Scanner;
    }
     * Prompts the user to select from a numbered list of choices.
/**  
    private static final Scanner CONSOLE_SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);
     *
        var response = getScanner().nextLine().trim();
    private static final String ALPHA_NUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
     */
            }  
        return password;  
        }
                return CONSOLE_SCANNER;
        var confirmPassword = promptForPassword(spec, "Confirm " + message.toLowerCase(java.util.Locale.ROOT));
            protected Scanner getScanner() {
/*  
            if (input.isEmpty()) {
            @Override  
    }
            }  
    public static UserInteractionService getInstance() {
    public String promptForPasswordWithConfirmation(CommandLine.Model.CommandSpec spec, CommonOptions options, String message) {  
            return true;
    /**  
        out.print(message + " [y/N] ");
        }  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.Randomness;
        }
public abstract class UserInteractionService {
        var out = spec.commandLine().getOut();  
        while (true) {  
     * @param spec the command specification for output  
     * @return the user's choice (1-based index)  
     *
        }
     */
        out.flush();  
     *  
                var choice = Integer.parseInt(input);  
        var password = promptForPassword(spec, message);
 * compatible open source license.
 *
     * @param choiceCount   the number of valid choices (1-based)
     * @return true if user confirms, false otherwise
        var password = new StringBuilder();  
        throw new IllegalStateException("\nNo input available. Use the '--non-interactive option' to skip confirmations.");
        if (!getScanner().hasNextLine()) {  
        if (password.isEmpty()) {
        assert choiceCount > 0 : "Choice count must be greater than 0.";  
        }
        return new UserInteractionService() {
                // fall through to the last statement
     * @param message confirmation message to display  
}
     * @return the entered password  
            out.flush();
    }
 * SPDX-License-Identifier: Apache-2.0
     * Prompts the user to confirm an action.
    static {
    private static void throwNoInputException() {  
            password.append(ALPHA_NUMERIC.charAt(Randomness.createSecure().nextInt(ALPHA_NUMERIC.length())));  
        var ansi = spec.commandLine().getColorScheme().ansi();
    /** Shared scanner for reading console input. */  
 * Provides utilities for confirmations and password input.
            var input = scanner.nextLine().trim();
 */  
            if (!scanner.hasNextLine()) {
        out.flush();
