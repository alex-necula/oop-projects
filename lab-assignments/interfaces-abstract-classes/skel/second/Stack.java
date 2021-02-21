package second;

import first.Task;

public class Stack extends Container {

    @Override
    public Task pop() {
        var tasks = getTasks();
        Task last = tasks.get(tasks.size() - 1);
        tasks.remove(last);
        return last;
    }
}
