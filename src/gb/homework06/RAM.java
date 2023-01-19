package gb.homework06;

public enum RAM {
    GB_8(8), GB_16(16), GB_32(32), GB_64(64), GB_128(128);

    private final int size;

    RAM(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
