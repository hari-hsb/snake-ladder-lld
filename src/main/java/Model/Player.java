package Model;

public class Player {
    int id;
    int currentPosition;
    boolean isCompleted;

    public boolean isCompleted() {
        return isCompleted;
    }

    public Player setCompleted(boolean completed) {
        isCompleted = completed;
        return this;
    }

    public Player(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Player setId(int id) {
        this.id = id;
        return this;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Player setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
        return this;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", currentPosition=" + currentPosition +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
