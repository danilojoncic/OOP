package model;

import java.util.Objects;

public class Mec {
    private String tim1;
    private String tim2;
    private int goloviTim1;
    private int goloviTim2;
    private String grupa;

    public Mec(String tim1, String tim2, int goloviTim1, int goloviTim2, String grupa) {
        this.tim1 = tim1;
        this.tim2 = tim2;
        this.goloviTim1 = goloviTim1;
        this.goloviTim2 = goloviTim2;
        this.grupa = grupa;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mec mec = (Mec) o;
        return Objects.equals(tim1, mec.tim1) && Objects.equals(tim2, mec.tim2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tim1, tim2);
    }

    public String getTim1() {
        return tim1;
    }

    public void setTim1(String tim1) {
        this.tim1 = tim1;
    }

    public String getTim2() {
        return tim2;
    }

    public void setTim2(String tim2) {
        this.tim2 = tim2;
    }

    public int getGoloviTim1() {
        return goloviTim1;
    }

    public void setGoloviTim1(int goloviTim1) {
        this.goloviTim1 = goloviTim1;
    }

    public int getGoloviTim2() {
        return goloviTim2;
    }

    public void setGoloviTim2(int goloviTim2) {
        this.goloviTim2 = goloviTim2;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return tim1 + "-" + tim2;
    }
}
