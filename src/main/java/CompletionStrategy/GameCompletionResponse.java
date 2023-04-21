package CompletionStrategy;

public class GameCompletionResponse {
    private boolean isGameComplete;
    private String message;

    public GameCompletionResponse(boolean isGameComplete, String message) {
        this.isGameComplete = isGameComplete;
        this.message = message;
    }

    public boolean isGameComplete() {
        return isGameComplete;
    }

    public GameCompletionResponse setGameComplete(boolean gameComplete) {
        isGameComplete = gameComplete;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public GameCompletionResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
