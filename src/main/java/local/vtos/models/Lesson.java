package local.vtos.models;

import lombok.Data;

import java.util.List;


@Data
public class Lesson {
    private final String id;
    private List<Item> item;
}
