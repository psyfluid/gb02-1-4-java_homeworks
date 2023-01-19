package gb.homework06;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Notebook implements Comparable<Notebook> {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private final int id;
    private final Colour colour;
    private RAM ram;
    private HDD hdd;
    private OS os;

    public Notebook(Colour colour) {
        this.id = COUNTER.incrementAndGet();
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public Colour getColour() {
        return colour;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public HDD getHdd() {
        return hdd;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Notebook ");
        sb.append(id).append(" [");
        sb.append("colour: ").append(colour);
        sb.append(", RAM (GB): ").append(ram.getSize());
        sb.append(", HDD (GB): ").append(hdd.getSize());
        sb.append(", OS: ").append(os);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return getColour() == notebook.getColour() && getRam() == notebook.getRam() && getHdd() == notebook.getHdd() && getOs() == notebook.getOs();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getColour());
    }

    @Override
    public int compareTo(Notebook o) {
        return this.id - o.getId();
    }
}
