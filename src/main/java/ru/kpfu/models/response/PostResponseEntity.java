package ru.kpfu.models.response;

import lombok.Data;

import java.util.List;

/**
 * 19.03.2018
 *
 * @author Robert Bagramov.
 */
@Data
public class PostResponseEntity<T> {
    private List<T> entities;

    public PostResponseEntity(List<T> entities) {
        this.entities = entities;
    }
}
