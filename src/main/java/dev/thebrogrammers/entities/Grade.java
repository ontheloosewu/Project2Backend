package dev.thebrogrammers.entities;

import javax.persistence.*;

@Entity
@Table(name="grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="g_id")
    private int g_id;

    @Column(name="s_id")
    private int s_id;

    @Column(name="time_reported")
    private long time_reported;

    @Column(name="note")
    private String note;

    @Column(name="behavior")
    private Behavior behavior;

    public Grade() {
    }

    public Grade(int g_id, int s_id, long time_reported, String note, Behavior behavior) {
        this.g_id = g_id;
        this.s_id = s_id;
        this.time_reported = time_reported;
        this.note = note;
        this.behavior = behavior;
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public long getTime_reported() {
        return time_reported;
    }

    public void setTime_reported(long time_reported) {
        this.time_reported = time_reported;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "g_id=" + g_id +
                ", s_id=" + s_id +
                ", time_reported=" + time_reported +
                ", note='" + note + '\'' +
                ", behavior=" + behavior +
                '}';
    }
}
