package dev.thebrogrammers.entities;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="s_id")
    private int s_id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="guardian_username")
    private String guardian_username;

    public Student() {
    }

    public Student(int s_id, String first_name, String last_name, String guardian_username) {
        this.s_id = s_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.guardian_username = guardian_username;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGuardian_username() {
        return guardian_username;
    }

    public void setGuardian_username(String guardian_username) {
        this.guardian_username = guardian_username;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id=" + s_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", guardian_username='" + guardian_username + '\'' +
                '}';
    }
}
