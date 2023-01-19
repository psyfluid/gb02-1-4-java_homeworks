package gb.homework06;

public enum HDD {
    GB_128(128), GB_256(256), GB_512(512), GB_1024(1024);

    private final int size;

    HDD(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
