package second;

import first.Task;
import java.util.ArrayList;

public abstract class Container {
    private final ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Removes a Task from the Container.
     *
     * @return the removed Task, if the Container is not empty;
     *         null, otherwise
     */
    public abstract Task pop();

    /**
     * Inserts a Task in the Container.
     *
     * @param task the inserted Task
     */
    public void push(Task task) {
        tasks.add(task);
    }

    /**
     * Returns the number of elements from the Container.
     *
     * @return The number of elements in this container.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Verifies if the Container is empty or not.
     *
     * @return true,  if the Container is empty
     *         false, otherwise
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Transfers all the elements that exist in a Container in this Container.
     *
     * @param container the Container from which we should transfer elements.
     *                  After the transfer, container.size() == 0
     */
    public void transferFrom(Container container) {
        while (!container.isEmpty()) {
            this.push(container.pop());
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
