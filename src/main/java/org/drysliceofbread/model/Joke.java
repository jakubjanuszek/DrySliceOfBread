package org.drysliceofbread.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by janco on 16.10.2016.
 */
@Entity
@Table(name = "jokes")
public class Joke {

    @Id
    @GeneratedValue
    private Long id;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}