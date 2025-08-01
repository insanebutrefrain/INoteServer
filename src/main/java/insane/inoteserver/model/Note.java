package insane.inoteserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notes")
@IdClass(NoteId.class)
public class Note {
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body", nullable = false, columnDefinition = "TEXT")
    private String body;

    @Id
    @Column(name = "create_time", nullable = false)
    private Long createTime;


    @Column(name = "modified_time", nullable = false)
    private long modifiedTime;

    @Id
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    private String user;
}


