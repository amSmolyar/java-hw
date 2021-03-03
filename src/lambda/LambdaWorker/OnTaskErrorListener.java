package lambda.LambdaWorker;

@FunctionalInterface
public interface OnTaskErrorListener {
    void onError(String result);
}
