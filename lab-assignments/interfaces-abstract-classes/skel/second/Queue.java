package second;

import first.Task;

public class Queue extends Container {

    @Override
    public Task pop() {
        var tasks = getTasks();
        Task first = tasks.get(0);
        tasks.remove(first);
        return first;
    }
}
