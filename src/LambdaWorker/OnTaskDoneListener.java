package LambdaWorker;

@FunctionalInterface
public interface OnTaskDoneListener {
    void onDone(String result);
}
