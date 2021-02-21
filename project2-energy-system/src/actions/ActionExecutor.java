package actions;

public final class ActionExecutor {
    private static final ActionExecutor INSTANCE = new ActionExecutor();

    private ActionExecutor() {
    }

    public static ActionExecutor getInstance() {
        return INSTANCE;
    }

    /**
     * Invoker for command design pattern
     *
     * @param action to be executed
     */
    public void executeAction(final Runnable action) {
        action.run();
    }
}
