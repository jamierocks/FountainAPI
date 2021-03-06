package org.fountainmc.api.chat.events;

import java.net.URL;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/**
 * Specifies behavior to use when a component is clicked on.
 */
public class ClickEvent {

    private final Action action;
    private final String value;

    ClickEvent(Action action, String value) {
        this.action = action;
        this.value = value;
    }

    /**
     * Creates a click event for opening a URL.
     *
     * @param url the URL to open when clicked
     * @return the click event
     */
    public static ClickEvent openUrl(URL url) {
        return new ClickEvent(Action.OPEN_URL, Preconditions.checkNotNull(url, "url").toString());
    }

    /**
     * Creates a click event for opening a URL.
     *
     * @param url the URL to open when clicked
     * @return the click event
     */
    public static ClickEvent openUrl(String url) {
        return new ClickEvent(Action.OPEN_URL, Preconditions.checkNotNull(url, "url"));
    }

    /**
     * Creates a click event for opening a file on the user's local computer.
     *
     * @param file the file to open
     * @return the click event
     */
    public static ClickEvent openFile(String file) {
        return new ClickEvent(Action.OPEN_FILE, Preconditions.checkNotNull(file, "file"));
    }

    /**
     * Creates a click event to run a command when the component is clicked.
     *
     * @param command the command to run
     * @return the click event
     */
    public static ClickEvent runCommand(String command) {
        return new ClickEvent(Action.RUN_COMMAND, Preconditions.checkNotNull(command, "command"));
    }

    /**
     * Creates a click event to fill a command to run when the component is
     * clicked.
     *
     * @param command the command to suggest
     * @return the click event
     */
    public static ClickEvent suggestCommand(String command) {
        return new ClickEvent(Action.SUGGEST_COMMAND, Preconditions.checkNotNull(command, "command"));
    }

    public Action getAction() {
        return action;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ClickEvent that = (ClickEvent) o;
        return action == that.action &&
                Objects.equal(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(action, value);
    }

    @Override
    public String toString() {
        return "ClickEvent{" +
                "action=" + action +
                ", value='" + value + '\'' +
                '}';
    }

    public enum Action {
        OPEN_URL,
        OPEN_FILE,
        RUN_COMMAND,
        SUGGEST_COMMAND;
    }

}
