package hellojpa.domain;

import javax.persistence.Entity;

@Entity
public class Movie extends Item {

    private String dirctor;
    private String actor;

    public String getDirctor() {
        return dirctor;
    }

    public void setDirctor(String dirctor) {
        this.dirctor = dirctor;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
