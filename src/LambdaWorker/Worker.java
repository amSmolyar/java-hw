package LambdaWorker;

public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int ii = 1; ii <= 100; ii++) {
            if (ii == 33)
                errorCallback.onError("Задание " + ii + " не выполнено. Увы!");
            else
                callback.onDone("Задание " + ii + " выполнено!");
        }
    }
}
