package CompletionStrategy;

import Model.Player;

public interface WinningStrategy {
    GameCompletionResponse gameComplete(Player player);
}
