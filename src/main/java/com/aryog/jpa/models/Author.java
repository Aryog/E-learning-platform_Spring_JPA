package com.aryog.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;
import java.util.List;


// Generate the getter and setter using @Data
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@NamedQuery(name= "Author.findByNamedQuery",query = "select a from Author a where a.age >= :age")
// @Table(name = "AUTHOR_TBL")
public class Author extends BaseEntity{

//    @Id
//    @GeneratedValue
            /*(
            strategy = GenerationType.TABLE,
            generator = "author_id_gen"
    )*/

    /*@SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )*/

    /*@TableGenerator(
            name = "author_id_gen",
            table = "id_generator",
            pkColumnName = "id_name",
            valueColumnName = "id_value",
            allocationSize = 1
    )*/
//    private Integer id;
    // Integer is by default null but the int is 0
    @Column(name = "f_name",length = 35)
    private String firstName;

    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private int age;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}
