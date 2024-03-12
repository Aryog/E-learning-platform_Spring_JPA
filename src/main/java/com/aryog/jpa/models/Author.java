package com.aryog.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;


// Generate the getter and setter using @Data
@Data
@NoArgsConstructor
@Entity
// @Table(name = "AUTHOR_TBL")
public class Author {

    @Id
    @GeneratedValue
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
    private Integer id;
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

    @Column(updatable = false,nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(insertable = false)
    private LocalDateTime lastModified;

}
