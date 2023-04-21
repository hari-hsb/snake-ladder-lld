package Model;

public class Jump {
    int start;
    int end;

    public Jump(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public Jump setStart(int start) {
        this.start = start;
        return this;
    }

    public int getEnd() {
        return end;
    }

    public Jump setEnd(int end) {
        this.end = end;
        return this;
    }
}
