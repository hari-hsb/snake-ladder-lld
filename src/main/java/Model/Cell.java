package Model;

public class Cell {
    Jump jump;

    public Cell() {
    }

    public Cell(Jump jump) {
    }

    public Jump getJump() {
        return jump;
    }

    public Cell setJump(Jump jump) {
        this.jump = jump;
        return this;
    }
}
